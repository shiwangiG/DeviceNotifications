package com.example.devicenotifications;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText title = findViewById(R.id.editTextTitle);
        EditText message = findViewById(R.id.editTextMessage);


        findViewById(R.id.sendBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!title.getText().toString().isEmpty() && !message.getText().toString().isEmpty()) {

                    FcmNotificationSender notificationSender = new FcmNotificationSender(userFcmToken:"/topic/all", title.getText().toString(),message.getText().toString(),getApplicationContext(),MainActivity.this);

                } else {
                    Toast.makeText(MainActivity.this, "Enter details", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}