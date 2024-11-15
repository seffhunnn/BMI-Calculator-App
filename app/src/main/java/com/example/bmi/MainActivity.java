package com.example.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

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


        EditText edtWeight, edtHeightFT, edtHeightIN;
        Button btnCalculate;
        TextView txtResult;
        LinearLayout main;

        edtWeight = findViewById(R.id.edtWeigth);
        edtHeightFT = findViewById(R.id.edtHeightFT);
        edtHeightIN = findViewById(R.id.edtHeightIN);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);
        main = findViewById(R.id.main);



        btnCalculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int ft =Integer.parseInt(edtHeightFT.getText().toString());
                int in = Integer.parseInt(edtHeightIN.getText().toString());

                int totalIn = ft*12 + in;

                double totalCm = totalIn*2.53;

                double totalM = totalCm/100;

                double bmi = wt/(totalM*totalM);

                if(bmi>25){
                    txtResult.setText("You are Overweight");
                    main.setBackgroundColor(getResources().getColor(R.color.colorOW));
                } else if (bmi<18) {
                    txtResult.setText("You are Underweight");
                    main.setBackgroundColor(getResources().getColor(R.color.colorUW));
                } else {
                    txtResult.setText("You are Healthy");
                    main.setBackgroundColor(getResources().getColor(R.color.colorH));
                }

            }
        });






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}