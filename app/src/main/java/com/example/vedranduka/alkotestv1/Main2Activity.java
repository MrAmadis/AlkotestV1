package com.example.vedranduka.alkotestv1;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    Button btnProvjeri;
    TextView result;
    EditText timeResting;
    TextView resultRested;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnProvjeri = (Button) findViewById(R.id.btnPotvrdi);
        result = (TextView)findViewById(R.id.textViewResult);
        timeResting = (EditText) findViewById(R.id.editTextAmountResting);
        resultRested = (TextView) findViewById(R.id.textViewRestTime);

        final Data d = getData();

        double consumedAlcohol = d.amountDrinking * d.alcoholPercentage * 0.789 * 10;

        final double bloodAlcoholPercentage = (consumedAlcohol / (d.userMass * d.gender.getNumVal())) / 10;

        double finalAlcoholPercentage = bloodAlcoholPercentage - (d.timeDrinking * 0.015);

        result.setText(String.valueOf(finalAlcoholPercentage));
        timeResting.setText("0");
        resultRested.setText(String.valueOf(finalAlcoholPercentage));

        btnProvjeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //formula za time resting
                double timeRested = Double.parseDouble(timeResting.getText().toString());
                double TimePercentage = bloodAlcoholPercentage - d.timeDrinking * 0.015;
                double alcoholAfterResting = TimePercentage - timeRested * 0.015;
                if(alcoholAfterResting > 0)
                    resultRested.setText(String.valueOf(alcoholAfterResting));
                else
                    resultRested.setText("0");

            }
        });
    }

    @Nullable
    private Data getData() {
        Bundle extras = getIntent().getExtras();
        Data d;
        if(extras != null)
            d = (Data)extras.getSerializable("Data");
        else
            d = null;
        return d;
    }
}
