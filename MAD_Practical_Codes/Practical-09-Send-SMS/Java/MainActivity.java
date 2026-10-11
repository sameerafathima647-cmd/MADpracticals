package com.example.smsapp;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {
    private EditText etPhoneNumber, etMessage;
    private static final int SMS_PERMISSION_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        etMessage = findViewById(R.id.etMessage);
        Button btnSendSms = findViewById(R.id.btnSendSms);
        btnSendSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity.this,
Manifest.permission.SEND_SMS )
                        == PackageManager.PERMISSION_GRANTED) {
                    sendSmsMessage();

                } else {
                    ActivityCompat.requestPermissions(
                            MainActivity.this,
                            new String[]{Manifest.permission.SEND_SMS},
                            SMS_PERMISSION_CODE
                    );
                }
            }
        });
    }
    private void sendSmsMessage() {
        String phoneNumber = etPhoneNumber.getText().toString().trim();
        String message = etMessage.getText().toString().trim();
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNumber, null, message, null, null);
        Toast.makeText(this, "SMS Sent Successfully!", Toast.LENGTH_SHORT).show();
        etMessage.setText("");
        etPhoneNumber.setText("");
    }
}
