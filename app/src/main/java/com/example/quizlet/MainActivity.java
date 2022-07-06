package com.example.quizlet;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int score = 0;
    private int numberOfSubmissions = 0;
//    private static HashMap<Integer,Integer> mp = new HashMap<Integer, Integer>();
    private boolean[] questions;
    private boolean[] submitted = new boolean[]{false,false,false,false};
    private boolean finishAttempt = false;
    /*static {
        mp.put(0,R.id.Q1C);
        mp.put(1,R.id.Q1B);
        mp.put(2,R.id.Q1A);
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    @SuppressLint("SetTextI18n")
    public void FinalSubmmit(View v){

        if(!checkSubmitAllQuestions())
            Toast.makeText(this, "Please submit All Questions", Toast.LENGTH_SHORT).show();
        else if(!finishAttempt){
            finishAttempt = true;
            calculateScore();
            TextView tex = findViewById(R.id.ScoreId);
            tex.setText("Score: "+score+"/8"+"\n"+"Question #1: "+questions[0]+"\nQuestion #2: "+questions[1]+"\nQuestion #3: "+questions[2]+"\nQuestion #4: "+questions[3]);
        }

    }

    boolean checkSubmitAllQuestions(){
        for (boolean it:
             submitted) {
            if(!it)
                return false;
        }
        return true;
    }

    public void handleQ(View v){
        int id = v.getId();
        RadioGroup radioGroup;
        switch (id){
            case R.id.submitQ1:
            case R.id.ClearQ1:
            {
                radioGroup = findViewById(R.id.answerQ1);
                int size = radioGroup.getChildCount();
                if(id == R.id.submitQ1)
                {
                    if(isChecked(radioGroup,size)){
                        disableRadioGroup(radioGroup,size);
                        submitted[0] = true;
                    }

                }
                else{
                    if(!finishAttempt){
                        radioGroup.clearCheck();
                        EnableRadioGroup(radioGroup, size);
                        submitted[0] = false;
                    }
                }
            }
            break;
            case R.id.submitQ2:
            case R.id.ClearQ2:
            {
                radioGroup = findViewById(R.id.answerQ2);
                int size = radioGroup.getChildCount();
                if(id == R.id.submitQ2)
                {

                    if(isChecked(radioGroup,size)){
                        disableRadioGroup(radioGroup,size);
                        submitted[1] = true;
                    }
                }
                else{
                    if(!finishAttempt){
                        radioGroup.clearCheck();
                        EnableRadioGroup(radioGroup, size);
                        submitted[1] = false;
                    }
                }
            }
            break;

            case R.id.submitQ3:
            case R.id.ClearQ3:
            {
                radioGroup = findViewById(R.id.answerQ3);
                int size = radioGroup.getChildCount();
                if(id == R.id.submitQ3)
                {

                    if(isChecked(radioGroup,size)){
                        disableRadioGroup(radioGroup,size);
                        submitted[2] = true;
                    }
                }
                else{
                    if(!finishAttempt){
                        radioGroup.clearCheck();
                        EnableRadioGroup(radioGroup, size);
                        submitted[2] = false;
                    }
                }
            }
            break;

            case R.id.submitQ4:
            case R.id.ClearQ4:
            {
                radioGroup = findViewById(R.id.answerQ4);
                int size = radioGroup.getChildCount();
                if(id == R.id.submitQ4)
                {

                    if(isChecked(radioGroup,size)){
                        disableRadioGroup(radioGroup,size);
                        submitted[3] = true;
                    }
                }
                else{
                    if(!finishAttempt){
                        radioGroup.clearCheck();
                        EnableRadioGroup(radioGroup, size);
                        submitted[3] = false;
                    }
                }
            }
            break;
        }




    }



    boolean isChecked(RadioGroup radioGroup,int size){


        for(int i = 0 ; i < size;i++) {
            Object temp = radioGroup.getChildAt(i);
            if (temp instanceof RadioButton) {
                if(((RadioButton)temp).isChecked())
                    return true;
            }
            else if(temp instanceof CheckBox){
                if(((CheckBox)temp).isChecked())
                    return true;
            }
        }
        return false;
    }
    void disableRadioGroup(RadioGroup radioGroup,int size){
        for (int i = 0; i < size ; i++){
            radioGroup.getChildAt(i).setEnabled(false);
        }
    }
    void EnableRadioGroup(RadioGroup radioGroup,int size){
        for (int i = 0; i < size ; i++){
            radioGroup.getChildAt(i).setEnabled(true);
        }
    }

    /*public  boolean checkAllSubmitted(){
        *//*if(radioGroupList == null){
         *//**//*RadioAns.put(R.id.answerQ1,R.id.Q1C);
            RadioAns.put(R.id.answerQ2,R.id.Q2B);
            RadioAns.put(R.id.answerQ3,R.id.Q3A);*//**//*
            radioGroupList.add((RadioGroup) findViewById(R.id.answerQ1));
            radioGroupList.add((RadioGroup) findViewById(R.id.answerQ2));
            radioGroupList.add((RadioGroup) findViewById(R.id.answerQ3));
            radioGroupList.add((RadioGroup) findViewById(R.id.answerQ4));
        }*//*

    }*/

    void calculateScore(){
        questions = new boolean[]{false,false,false,false};
        score = 0;
        int q1 = ((RadioGroup)findViewById(R.id.answerQ1)).getCheckedRadioButtonId();
        int q2 = ((RadioGroup)findViewById(R.id.answerQ2)).getCheckedRadioButtonId();
        int q3 = ((RadioGroup)findViewById(R.id.answerQ3)).getCheckedRadioButtonId();
        if(R.id.Q1C==q1) {
            score += 2;
            questions[0] = true;
        }
        if(R.id.Q2B==q2) {
            score += 2;
            questions[1] = true;
        }
        if(R.id.Q3A==q3) {
            score += 2;
            questions[2] = true;
        }
        CheckBox c1 = findViewById(R.id.Q4A);
        CheckBox c2 = findViewById(R.id.Q4B);
        CheckBox c3 = findViewById(R.id.Q4C);

        if(c1.isChecked() && c2.isChecked() && !c3.isChecked())
        {
            questions[3] =true;
            score +=2;
        }


    }



}