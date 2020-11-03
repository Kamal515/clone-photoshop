package com.example.clonephotoshopexplorer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

private EditText Name;
private EditText Password;
private Button Login;
private int counter = 5;

    public MainActivity(EditText editTextTextPersonName, EditText password, Button login) {
        this.Name = editTextTextPersonName;
        this.Password = password;
        this.Login = login;
    }


    @Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         Name = findViewById(R.id.editTextTextPersonName);
         Password = findViewById(R.id.editTextNumberPassword);
        Login = findViewById(R.id.Button);

         Login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 validate(Name.getText().toString(), Password.getText().toString());
             }
         });

}
private void validate(String userName,String userpassword){

        if((userName.equals("Admin")) && (userpassword.equals("3139"))){
            Intent intent  = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);

        } else{
            counter--;
            if(counter == 0){

                Login.setEnabled(false);
            }


        }
}

}