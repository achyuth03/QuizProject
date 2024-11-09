package com.example.quizproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.QuizViewHolder> {

    private List<Question> questionList;

    // Constructor to initialize the question list
    public QuizAdapter(List<Question> questionList) {
        this.questionList = questionList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public QuizViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the layout for individual question item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_question, parent, false);
        return new QuizViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(QuizViewHolder holder, int position) {
        // Get the current question
        Question question = questionList.get(position);

        // Set question text and options in the views
        holder.questionText.setText(question.getQuestionText());
        holder.option1.setText(question.getOptions().get(0));
        holder.option2.setText(question.getOptions().get(1));
        holder.option3.setText(question.getOptions().get(2));
        holder.option4.setText(question.getOptions().get(3));
    }

    // Return the size of the dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return questionList.size();
    }

    // Provide a reference to the views for each data item
    public static class QuizViewHolder extends RecyclerView.ViewHolder {

        public TextView questionText;
        public TextView option1;
        public TextView option2;
        public TextView option3;
        public TextView option4;

        public QuizViewHolder(View itemView) {
            super(itemView);

            // Initialize the views in the item layout
            questionText = itemView.findViewById(R.id.question_text);
            option1 = itemView.findViewById(R.id.option_1);
            option2 = itemView.findViewById(R.id.option_2);
            option3 = itemView.findViewById(R.id.option_3);
            option4 = itemView.findViewById(R.id.option_4);
        }
    }
}
