package com.myfirst.getresourcesapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText mEtId;
    private Button mBtSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        mBtSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEtId.getText().toString().trim().equals(""))
                    Toast.makeText(MainActivity.this, "Please enter Id", Toast.LENGTH_SHORT).show();
                else {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("id", mEtId.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }

    private void initViews() {
        mEtId = findViewById(R.id.etId);
        mBtSubmit = findViewById(R.id.btSubmit);
    }
}