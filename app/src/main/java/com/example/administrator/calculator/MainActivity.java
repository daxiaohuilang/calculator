package com.example.administrator.calculator;

import android.content.DialogInterface;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.app.Activity;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import java.lang.String;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    Button btn_0;
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_7;
    Button btn_8;
    Button btn_9;
    Button C;
    Button mul;
    Button add;
    Button del;
    Button divide;
    Button deng;
    Button min;
    Button btn_point;
    EditText et_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        add = (Button) findViewById(R.id.add);
        mul = (Button) findViewById(R.id.mul);
        min = (Button) findViewById(R.id.min);
        divide = (Button) findViewById(R.id.divide);
        del = (Button) findViewById(R.id.del);
        deng = (Button) findViewById(R.id.deng);
        btn_point = (Button) findViewById(R.id.btn_point);
        et_input = (EditText) findViewById(R.id.et_input);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        add.setOnClickListener(this);
        mul.setOnClickListener(this);
        del.setOnClickListener(this);
        min.setOnClickListener(this);
        divide.setOnClickListener(this);
        btn_0.setOnClickListener(this);
        deng.setOnClickListener(this);
    }

    public void onClick(View v) {
        String str = et_input.getText().toString();
        switch (v.getId()) {
            case R.id.btn_0:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
            case R.id.btn_point:

                et_input.setText(str + ((Button) v).getText());
                break;
            case R.id.add:
            case R.id.divide:
            case R.id.min:
            case R.id.mul:
                et_input.setText(str + " " + ((Button) v).getText() + " ");
                break;
            case R.id.C:
                et_input.setText("");
                break;
            case R.id.del:
                if (str != null && str.equals("")) {
                    et_input.setText(str.substring(0, str.length() - 1));
                }
                break;
            case R.id.deng:
                et_input.setText(String.valueOf(getResult()));
                break;
        }
    }

    private double getResult() {
        String exp = et_input.getText().toString();
        if (exp == null || exp.equals("")) {
            return 0;
        }
        if (!exp.contains(" ")) {
            return 0;
        }
        double result=0;
        String s1 = exp.substring(0, exp.indexOf(" "));
        String op = exp.substring(exp.indexOf(" ") + 1, exp.indexOf(" ") + 2);
        String s2 = exp.substring(exp.indexOf(" ") + 3);
        if (!s1.equals("") && !s2.equals("")) {
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);
            if (op.equals("+")) {
                result = d1 + d2;
               }
            else if (op.equals("-")) {
                result = d1 - d2;
            } else if (op.equals("×")) {
                result = d1 * d2;
            } else if(op.equals("÷")) {
                if (d2 == 0) {
                    result = 0;
                }
                result = d1 / d2;
            }


        }
        return result;

    }
}