package com.example.vedranduka.alkotestv1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle extras = getIntent().getExtras();
        Data d;
        if(extras != null)
            d = (Data)extras.getSerializable("Data");
        else
            d = null;

        double consumedAlcohol = d.amountDrinking * d.alcoholPercentage * 0.789;

        double bloodAlcoholPercentage = (consumedAlcohol/ (d.userMass * d.gender.getNumVal())) * 100;

        double finalAlcoholPercentage = bloodAlcoholPercentage - d.timeDrinking * 0.015;
        TextView result = (TextView)findViewById(R.id.textViewResult);
        result.setText(String.format("%s",finalAlcoholPercentage));
    }
}
