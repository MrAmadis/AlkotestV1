package com.example.vedranduka.alkotestv1;

import java.io.Serializable;
import java.text.MessageFormat;

/**
 * Created by Vedran Duka on 2.12.2016..
 */

public class Data implements Serializable{
    public double amountDrinking;
    public double alcoholPercentage;
    public int userMass;
    public enum genderEnum {
        Male(0.68), Female(0.55);

        private double numVal;

        genderEnum(double numVal) {
            this.numVal = numVal;
        }

        public double getNumVal() {
            return numVal;
        }
    }
    public genderEnum gender;
    public double timeDrinking;
    public double timeResting;

    public Data() {
        amountDrinking = 1;
        alcoholPercentage = 17.4;
        userMass = 60;
        gender = genderEnum.Male;
        timeDrinking = 2;
        timeResting = 0.5;

    }

    public Data(double amountDrinking, double alcoholPercentage, int userMass, genderEnum gender,
                double timeDrinking, double timeResting) {
        this.amountDrinking = amountDrinking;
        this.alcoholPercentage = alcoholPercentage;
        this.userMass = userMass;
        this.gender = gender;
        this.timeDrinking = timeDrinking;
        this.amountDrinking = amountDrinking;

    }

    @Override
    public String toString() {
        return String.format("{%d}", amountDrinking);
    }
}
