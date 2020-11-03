package com.example.clonephotoshopexplorer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private int STORAGE_PERMISSION_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button buttonRequest = findViewById(R.id.button);
        buttonRequest.setOnClickListener(new View.OnClickListener() {
            public void setBuilder(AlertDialog builder) {
                this.builder = builder;
            }

            private AlertDialog builder;

            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(SecondActivity.this,Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(SecondActivity.this, "You have already granted this permission!", Toast.LENGTH_SHORT).show();
                } else {
                    requestStoragePermission();
                }
            }

            private void requestStoragePermission() {
                if (ActivityCompat.shouldShowRequestPermissionRationale(SecondActivity.this,Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    final AlertDialog.Builder builder;
                    builder = new AlertDialog.Builder(this.
                    builder.setTitle("Permission")
                    builder.setMessage("This permission is needed because of this and that")
                    builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(SecondActivity.this,
                                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);

                        }
                    })
                       .setNegativeButton("cancel", new DialogInterface().OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                    }

                }
}