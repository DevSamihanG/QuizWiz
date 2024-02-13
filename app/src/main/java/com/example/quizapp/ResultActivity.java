package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity {


    private TextView scoreTextView;
    private TextView responsesTextView;

    private ProgressBar scoreProgressBar;

    Button retryButton;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        scoreTextView = findViewById(R.id.scoreTextView);
        responsesTextView = findViewById(R.id.responsesTextView);
        scoreProgressBar  = findViewById(R.id.scoreProgressBar);
        retryButton = findViewById(R.id.retryButton);

        // Get user responses and correct answers from intent
        ArrayList<Integer> userResponses = getIntent().getIntegerArrayListExtra("user_responses");
        List<Question> questions = QuizData.getQuestions();

        // Calculate score and display result
        if (userResponses != null) {
            int score = calculateScore(userResponses, questions);
            scoreTextView.setText("Your Score: " + score + "%");
            scoreProgressBar.setProgress(score);
            displayResponses(userResponses, questions);

            retryButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                }
            });
        }
    }

    private int calculateScore(List<Integer> userResponses, List<Question> questions) {
        int score = 0;
        for (int i = 0; i < userResponses.size(); i++) {
            if (userResponses.get(i).equals(questions.get(i).getCorrectAnswerIndex())){
                score++;
            }
        }
        return (int) ((score / (double) userResponses.size()) * 100);
    }

    private void displayResponses(List<Integer> userResponses, List<Question> questions) {
        StringBuilder responseBuilder = new StringBuilder();
        for (int i = 0; i < userResponses.size(); i++) {
            String response = "Q" + (i + 1) + ". Your Response: " + questions.get(i).getOptions().get(userResponses.get(i)) +
                    ". Correct Answer: " + questions.get(i).getOptions().get(questions.get(i).getCorrectAnswerIndex()) + "\n";
            responseBuilder.append(response);
        }
        responsesTextView.setText(responseBuilder.toString());
    }
}