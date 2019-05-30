package com.laacompany.barcodescanner;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 0;

    private Button mButton;
    private TextView mTextView1;
    private TextView mTextView2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ScannerActivity.newIntent(MainActivity.this);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });

        mTextView1 = findViewById(R.id.textview1);
        mTextView2 = findViewById(R.id.textview2);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE){
            if (resultCode == ScannerActivity.RESULT_CODE){
                String s = data.getStringExtra(ScannerActivity.EXTRA_CODE);
                mTextView1.setText(s);

                s = data.getStringExtra(ScannerActivity.EXTRA_TYPE);
                mTextView2.setText(s);
            }
        }
    }
}
