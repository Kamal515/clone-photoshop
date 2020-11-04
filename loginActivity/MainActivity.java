package com.example.clonephotoshopexplorer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.R;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private EditText Login;
    private int counter = 5;

    public MainActivity(EditText editTextTextPersonName, EditText password, EditText login) {
        this.Name = editTextTextPersonName;
        this.Password = password;
        this.Login = login;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abc_tooltip);
        Name = (EditText) findViewById(R.id.text2);
        Password = (EditText) findViewById(R.id.text);
        Login = (EditText) findViewById(R.id.buttonPanel);

        ((View) Login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });

    }

    private void validate(String userName, String userpassword) {

        if ((userName.equals("Admin")) && (userpassword.equals("3139"))) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);

        } else {
            counter--;
            if (counter == 0) {

                Login.setEnabled(false);
            }

        }
    }
}
