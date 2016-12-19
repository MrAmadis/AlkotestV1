package com.example.vedranduka.alkotestv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.vedranduka.alkotestv1.R.id.radioMale;


public class MainActivity extends AppCompatActivity {
    TextView viewAmountDrinking;
    TextView viewAlcoholPercentage;
    TextView viewUserMass;
    RadioGroup radioSex;
    TextView viewTimeDrinking;
    TextView viewTimeResting;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linkData();
        setTestData();
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = viewAmountDrinking.getText().toString();
                double amountDrinking = Double.parseDouble(temp);

                temp = viewAlcoholPercentage.getText().toString();
                double alcoholPercentage = Double.parseDouble(temp);

                temp = viewUserMass.getText().toString();
                int userMass = Integer.parseInt(temp);

                int selectedId = radioSex.getCheckedRadioButtonId();
                RadioButton radioSexButton = (RadioButton) findViewById(selectedId);
                Data.genderEnum g;
                if(radioSexButton.getText().equals("Male"))
                    g = Data.genderEnum.Male;
                else
                    g = Data.genderEnum.Female;

                temp = viewTimeDrinking.getText().toString();
                double timeDrinking = Double.parseDouble(temp);

                temp = viewTimeResting.getText().toString();
                double timeResting = Double.parseDouble(temp);

                Data d = new Data(amountDrinking, alcoholPercentage, userMass, g, timeDrinking, timeResting);
                //Toast.makeText(MainActivity.this, d.toString(), Toast.LENGTH_SHORT).show();
                reset();
                startSecondActivity(d);
            }
        });

    }

    private void startSecondActivity(Data d) {
        Intent intent = new Intent(this, Main2Activity.class);
        Bundle b = new Bundle();
        b.putSerializable("Data", d);
        intent.putExtras(b);
        startActivity(intent);
    }

    private void linkData() {
        viewAmountDrinking = (TextView)findViewById(R.id.alcoholQuantityTextBox);
        viewAlcoholPercentage = (TextView)findViewById(R.id.alcoholPercentageTextBox);
        viewUserMass = (TextView)findViewById(R.id.userMassEditText);
        radioSex = (RadioGroup) findViewById(R.id.radioSex);
        viewTimeDrinking = (TextView)findViewById(R.id.timeDrinkingTimeBox);
        viewTimeResting = (TextView)findViewById(R.id.timeRestingTimeBox);
        submitButton = (Button) findViewById(R.id.submitButton);
    }

    private void reset() {
        viewAmountDrinking.setText("");
        viewAlcoholPercentage.setText("");
        viewUserMass.setText("");
        radioSex.clearCheck();
        viewTimeDrinking.setText("");
        viewTimeResting.setText("");
    }

    private void setTestData() {
        viewAmountDrinking.setText("2.5");
        viewAlcoholPercentage.setText("4.5");
        viewUserMass.setText("100");
        radioSex.check(radioMale);
        viewTimeDrinking.setText("3");
        viewTimeResting.setText("2");
    }
}
