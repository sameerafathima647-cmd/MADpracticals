package com.example.emailapp;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.ashiqa.emailapp.R;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText etTo = findViewById(R.id.etTo);
        EditText etSubject = findViewById(R.id.etSubject);
        EditText etMessage = findViewById(R.id.etMessage);
        Button btnSendEmail = findViewById(R.id.btnSendEmail);
        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toEmail = etTo.getText().toString().trim();
                String subject = etSubject.getText().toString().trim();
                String message = etMessage.getText().toString().trim();
                if (toEmail.isEmpty() || subject.isEmpty() || message.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill in all fields",

Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("message/rfc822");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{toEmail});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
                emailIntent.putExtra(Intent.EXTRA_TEXT, message);
                try {
                    startActivity(Intent.createChooser(emailIntent, "Choose an Email Client..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(MainActivity.this, "No email clients installed.",
Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
