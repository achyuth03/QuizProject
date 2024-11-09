package com.example.quizproject;

import java.util.List;

public class Question {
    private String questionText;
    private List<String> options;
    private String answer;

    public Question(String questionText, List<String> options, String answer) {
        this.questionText = questionText;
        this.options = options;
        this.answer = answer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getAnswer() {
        return answer;
    }
}
