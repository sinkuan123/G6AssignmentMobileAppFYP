package com.example.android_assignment;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener{

    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ansA, ansB, ansC, ansD;
    Button submitButton;

    int score=0;
    int totalQuestion = QuestionAnswer.question.length;
    int currentQuestionIndex = 0;
    String selectAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        totalQuestionsTextView = findViewById(R.id.TotalQuestion);
        questionTextView = findViewById(R.id.Question);
        ansA = findViewById(R.id.AnsA);
        ansB = findViewById(R.id.AnsB);
        ansC = findViewById(R.id.AnsC);
        ansD = findViewById(R.id.AnsD);
        submitButton = findViewById(R.id.SubmitButton);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitButton.setOnClickListener(this);

        totalQuestionsTextView.setText("Total questions : " + totalQuestion);

        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {

        ansA.setBackgroundColor(Color.CYAN);
        ansB.setBackgroundColor(Color.CYAN);
        ansC.setBackgroundColor(Color.CYAN);
        ansD.setBackgroundColor(Color.CYAN);


        Button clickedButton = (Button) view;
        if (clickedButton.getId()==R.id.SubmitButton){ if (selectAnswer.equals(QuestionAnswer.correctAnswers[currentQuestionIndex])){
            score++;
        }
            currentQuestionIndex++;
            loadNewQuestion();


        }else{
            selectAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }
    }
    void loadNewQuestion(){

        if (currentQuestionIndex == totalQuestion){
            finishQuiz();
            return;
        }
        questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
        ansA.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionAnswer.choices[currentQuestionIndex][3]);
    }

    void finishQuiz(){
        String passStatus = "";
        if(score > totalQuestion*0.60){
            passStatus = "Passed";
        }else{
            passStatus = "Failed";
        }

        new AlertDialog.Builder(this).setTitle(passStatus).setMessage("Score is "+ score + " out of "+ totalQuestion).setPositiveButton("Go Back", (dialogInterface, i) -> homePage()).setCancelable(false).show();


    }

    void homePage(){
        startActivity(new Intent(QuizActivity.this, MainActivity.class));
    }
}
