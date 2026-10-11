package com.example.simplecalculator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText etNumber1 = findViewById(R.id.etNumber1);
        EditText etNumber2 = findViewById(R.id.etNumber2);
        RadioGroup rgOperations = findViewById(R.id.rgOperations);
        Button btnCalculate = findViewById(R.id.btnCalculate);
        TextView tvResult = findViewById(R.id.tvResult);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1str = etNumber1.getText().toString();
                String num2str = etNumber2.getText().toString();
                if (num1str.isEmpty() || num2str.isEmpty()){

                    Toast.makeText(MainActivity.this,"Please enter both numbers",
Toast.LENGTH_SHORT).show();
                    return;
                }
                double num1 = Double.parseDouble(num1str);
                double num2 = Double.parseDouble(num2str);
                double result = 0;
                int selectedId = rgOperations.getCheckedRadioButtonId();
                if (selectedId == R.id.rbAdd) {
                    result = num1 + num2;
                } else if (selectedId == R.id.rbSubtract) {
                    result = num1 - num2;
                } else if (selectedId == R.id.rbMultiply) {
                    result = num1 * num2;
                } else if (selectedId == R.id.rbDivide) {
                    if (num2 == 0){
                        tvResult.setText("Error:cannot divide by zero");
                        return;
                    }
                    result = num1 / num2;
                }
                tvResult.setText("Result: " +result);
            }
        });
    }
}
