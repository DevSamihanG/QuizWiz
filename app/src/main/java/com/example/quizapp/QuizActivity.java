package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView questionTextView;
    private RadioGroup optionsRadioGroup;
    private Button nextButton;
    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private List<Integer> userResponses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Initialize views
        questionTextView = findViewById(R.id.questionTextView);
        optionsRadioGroup = findViewById(R.id.optionsRadioGroup);
        nextButton = findViewById(R.id.nextButton);

        questions = QuizData.getQuestions();
        userResponses = new ArrayList<>();

        displayQuestion();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedOptionId = optionsRadioGroup.getCheckedRadioButtonId();
                if (selectedOptionId == -1) {
                    Toast.makeText(QuizActivity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Add user response
                userResponses.add(optionsRadioGroup.indexOfChild(findViewById(selectedOptionId)));

                // Move to next question or submit quiz
                if (currentQuestionIndex < questions.size() - 1) {
                    currentQuestionIndex++;
                    displayQuestion();
                    if (currentQuestionIndex == questions.size() - 1) {
                        nextButton.setText("Submit Quiz");
                    }
                } else {
                    // Start result activity
                    Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                    intent.putIntegerArrayListExtra("user_responses", (ArrayList<Integer>) userResponses);
                    startActivity(intent);
                }
            }
        });
    }



    private void displayQuestion() {
        // Clear radio group
        optionsRadioGroup.removeAllViews();

        // Get current question
        Question currentQuestion = questions.get(currentQuestionIndex);
        questionTextView.setText(currentQuestion.getQuestionText());

        // Add options to radio group
        List<String> options = currentQuestion.getOptions();
        for (String option : options) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(option);
            optionsRadioGroup.addView(radioButton);
        }
    }
}
