package com.example.application.inputy;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout main_layout;
    TextInputLayout username_container, password_container;
    AppCompatEditText username_input, password_input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_layout =(RelativeLayout) findViewById(R.id.main_layout);
        username_container =(TextInputLayout) findViewById(R.id.username_container);
        password_container =(TextInputLayout) findViewById(R.id.password_container);
        username_input =(AppCompatEditText) findViewById(R.id.username_input);
        password_input =(AppCompatEditText) findViewById(R.id.password_input);

        main_layout.setOnClickListener(null);

        username_input.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if(username_input.getText().toString().isEmpty()){
                    username_container.setErrorEnabled(true);
                    username_container.setError("Username Is Required");
                }else{
                    username_container.setErrorEnabled(false);
                }

            }
        });
        username_input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(username_input.getText().toString().isEmpty()){
                    username_container.setErrorEnabled(true);
                    username_container.setError("Username Is Required");
                }else{
                    username_container.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        password_container.setCounterEnabled(true);
        password_container.setCounterMaxLength(60);


    }


}
