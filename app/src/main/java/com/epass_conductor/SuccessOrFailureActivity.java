package com.epass_conductor;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SuccessOrFailureActivity extends AppCompatActivity {

    private TextView textTextView;
    private Button mDoneButton;
    private LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_or_failure);
        textTextView = findViewById(R.id.textMessage);
        mLinearLayout = findViewById(R.id.mainBackground);
        mDoneButton = findViewById(R.id.doneButton);
        Bundle intent = getIntent().getExtras();
        String value = Integer.toString(intent.getInt("resultValue"));

        Log.d("Shubham", "onCreate: " + value);
        if (value != null && value.equalsIgnoreCase("1")) {
            textTextView.setText("Valid User");
            mLinearLayout.setBackgroundColor(getResources().getColor(R.color.green));
        } else {
            mLinearLayout.setBackgroundColor(getResources().getColor(R.color.red));
            textTextView.setText("Invalid User");
        }
        mDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ScannedBarcodeActivity.class);
                SuccessOrFailureActivity.this.startActivity(intent);
            }
        });
    }
}