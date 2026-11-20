package com.example.androidstudiodebugger; // Prilagodi imenu svojega paketa na vrhu datoteke

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etNumber1, etNumber2;
    private TextView tvResult;
    private Button btnAdd, btnSub, btnDiv, btnMul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Povezava elementov iz XML-ja s kodo
        etNumber1 = findViewById(R.id.etNumber1);
        etNumber2 = findViewById(R.id.etNumber2);
        tvResult = findViewById(R.id.tvResult);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnDiv = findViewById(R.id.btnDiv);
        btnMul = findViewById(R.id.btnMul);

        // Poslušalci za klike na gumbe
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+');
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('/');
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('*');
            }
        });
    }

    private void calculate(char operator) {
        String strNum1 = etNumber1.getText().toString().trim();
        String strNum2 = etNumber2.getText().toString().trim();

        // Preveri, ali sta obe polji izpolnjeni
        if (strNum1.isEmpty() || strNum2.isEmpty()) {
            Toast.makeText(this, "Vnesi obe števili!", Toast.LENGTH_SHORT).show();
            return;
        }

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        double result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
        }

        tvResult.setText("Rezultat: " + result);
    }
}