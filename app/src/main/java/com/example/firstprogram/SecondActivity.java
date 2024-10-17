package com.example.firstprogram;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private EditText editTextName;
    private Button buttonOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editTextName = findViewById(R.id.editTextName);
        buttonOk = findViewById(R.id.buttonOk);

        String greeting = getIntent().getStringExtra("greeting");

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();


                if (name.isEmpty()) {
                    Toast.makeText(SecondActivity.this, "Пожалуйста, введите имя!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("name", name);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
            }
        });
    }
}
