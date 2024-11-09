package com.example.quizproject;
import com.example.quizproject.Question;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView categoryText;
    private RecyclerView quizRecyclerView;
    private QuizAdapter quizAdapter;
    private List<Question> questionList;

    private FirebaseFirestore db;
    private String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Initialize Firestore instance
        db = FirebaseFirestore.getInstance();

        categoryText = findViewById(R.id.category_text);
        quizRecyclerView = findViewById(R.id.quiz_recycler_view);
        quizRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the list to hold quiz questions
        questionList = new ArrayList<>();

        // Get category from Intent
        category = getIntent().getStringExtra("CATEGORY");

        // Display category name
        categoryText.setText("Quiz on " + category);

        // Fetch questions from Firestore
        fetchQuizQuestions(category);
    }

    private void fetchQuizQuestions(String category) {
        // Query Firestore for the selected category's questions
        db.collection("quizzes").document(category)
                .get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        // Fetch the questions array from Firestore
                        List<Map<String, Object>> questions = (List<Map<String, Object>>) documentSnapshot.get("questions");

                        for (Map<String, Object> questionData : questions) {
                            String questionText = (String) questionData.get("question");
                            List<String> options = (List<String>) questionData.get("options");
                            String answer = (String) questionData.get("answer");

                            // Create a Question object and add it to the list
                            Question question = new Question(questionText, options, answer);
                            questionList.add(question);
                        }

                        // Set up the adapter with the fetched questions
                        quizAdapter = new QuizAdapter(questionList);
                        quizRecyclerView.setAdapter(quizAdapter);

                    } else {
                        // No such document exists in Firestore
                        Toast.makeText(QuizActivity.this, "No questions found for this category", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(e -> {
                    // Handle error
                    Toast.makeText(QuizActivity.this, "Error loading questions", Toast.LENGTH_SHORT).show();
                });
    }
}
