package com.hell.plusminusappfirstproject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button plusBtn = (Button) findViewById(R.id.plusBtn);
    Button minBtn = (Button) findViewById(R.id.minusBtn);
    TextView number = (TextView) findViewById(R.id.numInt);
    public int minus = -1;
    public int plus = 1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.main);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int clickedBtnId = v.getId();
                if (clickedBtnId == R.id.plusBtn)
                {
                    changeNumber(plus);
                }
                else
                {
                    if (clickedBtnId == R.id.minusBtn)
                    {
                        changeNumber(minus);
                    }
                }
            }
        };

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void changeNumber(int numToAdd)
        {
            int newValue = getNumValue() + numToAdd;
            number.setText( String.valueOf(newValue) );
        }

    public int getNumValue()
    {
         String text = number.getText().toString();
         int num = Integer.parseInt(text);
         return num;
    }

}