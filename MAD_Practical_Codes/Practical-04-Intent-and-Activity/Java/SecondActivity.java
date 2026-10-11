package com.example.intentapp;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class SecondActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView tvReceivedMessage = findViewById(R.id.tvReceviedMessage);
        Button btnBack = findViewById(R.id.btnBack);
        Intent incomingIntent = getIntent();

        String receivedText = incomingIntent.getStringExtra("SECRET_MESSAGE");
        if(receivedText != null && !receivedText.isEmpty()){
            tvReceivedMessage.setText(receivedText);
        }
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
