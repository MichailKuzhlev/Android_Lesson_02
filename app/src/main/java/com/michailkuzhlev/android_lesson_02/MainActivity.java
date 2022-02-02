package com.michailkuzhlev.android_lesson_02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//region Инициализация кнопок

    private TextView calDisplay;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button0;
    private Button button000;
    private Button buttonAC;
    private Button buttonPersent;
    private Button buttonPS;
    private Button buttonComma;
    private Button buttonDivis;
    private Button buttonPlus;
    private Button buttonMinus;
    private Button buttonRes;
    private Button buttonX;


//endregion


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        myOnCreate();

    }


    private void myOnCreate() {
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button0.setOnClickListener(this);
        button000.setOnClickListener(this);
        buttonComma.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonPersent.setOnClickListener(this);
        buttonPS.setOnClickListener(this);
        buttonRes.setOnClickListener(this);
        buttonDivis.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonX.setOnClickListener(this);
        buttonAC.setOnClickListener(this);
    }

    private void initView() {
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button0 = findViewById(R.id.button0);
        button000 = findViewById(R.id.button000);
        buttonAC = findViewById(R.id.buttonAC);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonDivis = findViewById(R.id.buttonDivis);
        buttonPersent = findViewById(R.id.buttonPersent);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonPS = findViewById(R.id.buttonPS);
        buttonComma = findViewById(R.id.buttonComma);
        buttonRes = findViewById(R.id.buttonRes);
        buttonX = findViewById(R.id.buttonX);
        calDisplay = findViewById(R.id.calDisplay);
    }

    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("calDisplay", calDisplay.getText().toString());


    }

    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        calDisplay.setText(savedInstanceState.getString("calDisplay"));

    }


    private Double first = 0.0;
    private Double Two = 0.0;
    private int operation = 0;
    String input = "";

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        calDisplay.setText(String.format("%s%s", calDisplay.getText().toString(), button.getText().toString()));
        switch (view.getId()) {
            case R.id.button1:
            case R.id.button2:
            case R.id.button3:
            case R.id.button4:
            case R.id.button5:
            case R.id.button6:
            case R.id.button7:
            case R.id.button8:
            case R.id.button9:
            case R.id.button0:
            case R.id.buttonComma:
            case R.id.button000: {
                input += button.getText().toString();
                break;
            }
            case R.id.buttonPlus: {
                Two = first;
                first = Double.parseDouble(input);
                input = "";
                operation = 1;
                break;
            }
            case R.id.buttonMinus: {
                Two = first;
                first = Double.parseDouble(input);
                input = "";
                operation = 2;
                break;
            }
            case R.id.buttonX: {
                Two = first;
                first = Double.parseDouble(input);
                input = "";
                operation = 3;
                break;
            }
            case R.id.buttonDivis: {
                Two = first;
                first = Double.parseDouble(input);
                input = "";
                operation = 4;
                break;
            }
            case R.id.buttonPersent: {
                Two = first;
                first = Double.parseDouble(input);
                input = "";
                operation = 5;
                break;
            }
            case R.id.buttonAC: {
                operation = 5;
                result();
                break;
            }
            case R.id.buttonRes: {
                Two = first;
                first = Double.parseDouble(input);
                result();
            }


        }


    }

    void result() {
        switch (operation) {
            case 1: {
                calDisplay.setText((String.format("%.2f", first + Two)));
                break;
            }
            case 2: {
                calDisplay.setText((String.format("%.2f", Two - first)));
                break;
            }
            case 3: {
                calDisplay.setText((String.format("%.2f", Two * first)));
                break;
            }
            case 4: {
                calDisplay.setText((String.format("%.2f", Two / first)));
                break;
            }
            case 5: {
                calDisplay.setText("");
            }

        }


    }

}

