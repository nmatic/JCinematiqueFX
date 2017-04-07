package ca.qc.nmatic.cinematique.JCinematiqueFX;

public class Kinetics {

    private int desiredValue = 0; // liste déroulante, valeur par def = 1

    // Déclaration des booleens pour les cases des valeurs connues
    private boolean bXi = false;
    private boolean bXf = false;
    private boolean bVi = false;
    private boolean bVf = false;
    private boolean bDt = false;
    private boolean bA = false;

    // Variables de lecture du formulaire
    private double initialPos, finalPos, initialVel, finalVel, elapsedTime, acceleration;

    private final String initialPosStr, finalPosStr, initialVelStr, finalVelStr, elapsedTimeStr, accelerationStr;
    // Variables de sortie
    private String unit, formule, formuleDonnees, output;
    private double result;
    
    private final Formulas formula;

    public Kinetics(String initialPosStr, String finalPosStr, String initialVelStr, String finalVelStr, String elapsedTimeStr, String accelerationStr, int desiredValue) {
        this.formula = new Formulas();
        this.initialPosStr = initialPosStr;
        this.finalPosStr = finalPosStr;
        this.initialVelStr = initialVelStr;
        this.finalVelStr = finalVelStr;
        this.elapsedTimeStr = elapsedTimeStr;
        this.accelerationStr = accelerationStr;
        this.desiredValue = desiredValue;
    }


    public String findValue() {
        bXi = initialPosStr.equals("");
        bXf = initialPosStr.equals("");
        bVi = initialPosStr.equals("");
        bVf = initialPosStr.equals("");
        bDt = initialPosStr.equals("");
        bA = initialPosStr.equals("");

        // Trouver la position initiale(1):
        if (desiredValue == 1 && bXf == true && bVi == true && bVf == true && bDt == true) {
            unit = " m";
            finalPos = Double.parseDouble(finalPosStr);
            initialVel = Double.parseDouble(initialVelStr);
            finalVel = Double.parseDouble(finalVelStr);
            elapsedTime = Double.parseDouble(elapsedTimeStr);
            result = formula.xi_2(finalPos, initialVel, finalVel, elapsedTime);
            formule = "Xi = -½ *(Vi + Vf)* \u0394t - Xf";
            formuleDonnees = "Xi = -½ * (" + initialVel + " + " + finalVel + ") * " + elapsedTime + " - " + finalPos;
            System.out.println(formule);

            output = formule + "\n" + formuleDonnees + "\n" + "Xi = " + result + unit;

        } else if (desiredValue == 1 && bA == true && bXf == true && bVi == true && bDt == true) {
            unit = " m";
            finalPos = Double.parseDouble(finalPosStr);
            initialVel = Double.parseDouble(initialVelStr);
            elapsedTime = Double.parseDouble(elapsedTimeStr);
            acceleration = Double.parseDouble(accelerationStr);

            result = formula.xi_3(acceleration, finalPos, initialVel, elapsedTime);
            output = result + unit;

        } else if (desiredValue == 1 && bVi == true && bVf == true && bA == true && bXf == true) {
            unit = " m";
            finalPos = Double.parseDouble(finalPosStr);
            initialVel = Double.parseDouble(initialVelStr);
            finalVel = Double.parseDouble(finalVelStr);
            acceleration = Double.parseDouble(accelerationStr);

            result = formula.xi_4(initialVel, finalVel, acceleration, finalPos);

            output = result + unit;

        } // Trouver le déplacement final(2):
        else if (desiredValue == 2 && bXi == true && bVi == true && bVf == true && bDt == true) {
            unit = " m";
            initialPos = Double.parseDouble(initialPosStr);
            initialVel = Double.parseDouble(initialVelStr);
            finalVel = Double.parseDouble(finalVelStr);
            elapsedTime = Double.parseDouble(elapsedTimeStr);

            result = formula.xf_2(initialPos, initialVel, finalVel, elapsedTime);

            output = result + unit;

        } else if (desiredValue == 2 && bA == true && bXi == true && bVi == true && bDt == true) {
            unit = " m";
            acceleration = Double.parseDouble(accelerationStr);
            elapsedTime = Double.parseDouble(elapsedTimeStr);
            initialVel = Double.parseDouble(initialVelStr);
            initialPos = Double.parseDouble(initialPosStr);

            result = formula.xf_3(acceleration, initialPos, initialVel, elapsedTime);

            output = result + unit;

        } else if (desiredValue == 2 && bXi == true && bVi == true && bVf == true && bA == true) {
            unit = " m";
            initialPos = Double.parseDouble(initialPosStr);
            initialVel = Double.parseDouble(initialVelStr);
            finalVel = Double.parseDouble(finalVelStr);
            acceleration = Double.parseDouble(accelerationStr);

            result = formula.xf_4(initialVel, finalVel, acceleration, initialPos);

            output = result + unit;

        } // Trouver la vitesse initiale(3):
        else if (desiredValue == 3 && bA == true && bVf == true && bDt == true) {
            unit = " m/s";
            acceleration = Double.parseDouble(accelerationStr);
            finalVel = Double.parseDouble(finalVelStr);
            elapsedTime = Double.parseDouble(elapsedTimeStr);

            result = formula.vi_1(acceleration, finalVel, elapsedTime);

            output = result + unit;

        } else if (desiredValue == 3 && bXf == true && bXi == true && bVf == true && bDt == true) {
            unit = " m/s";
            initialPos = Double.parseDouble(initialPosStr);
            finalPos = Double.parseDouble(finalPosStr);
            finalVel = Double.parseDouble(finalVelStr);
            elapsedTime = Double.parseDouble(elapsedTimeStr);

            result = formula.vi_2(initialPos, finalPos, finalVel, elapsedTime);

            output = result + unit;

        } else if (desiredValue == 3 && bXf == true && bXi == true && bA == true && bDt == true) {
            unit = " m/s";
            initialPos = Double.parseDouble(initialPosStr);
            finalPos = Double.parseDouble(finalPosStr);
            elapsedTime = Double.parseDouble(elapsedTimeStr);
            acceleration = Double.parseDouble(accelerationStr);

            result = formula.vi_3(initialPos, finalPos, acceleration, elapsedTime);

            output = result + unit;

        } else if (desiredValue == 3 && bXf == true && bXi == true && bVf == true && bA == true) {
            unit = " m/s";
            initialPos = Double.parseDouble(initialPosStr);
            finalPos = Double.parseDouble(finalPosStr);
            finalVel = Double.parseDouble(finalVelStr);
            acceleration = Double.parseDouble(accelerationStr);

            result = formula.vi_4(initialPos, finalPos, finalVel, acceleration);
            output = result + unit;

        } // Trouver la vitesse finale(4):
        else if (desiredValue == 4 && bA == true && bDt == true && bVi == true) {
            unit = " m/s";
            acceleration = Double.parseDouble(accelerationStr);
            elapsedTime = Double.parseDouble(elapsedTimeStr);
            initialVel = Double.parseDouble(initialVelStr);

            formule = "Vf = Vi * a\u0394t";
            result = formula.vf_1(acceleration, initialVel, elapsedTime);

            output = result + unit;

        } else if (desiredValue == 4 && bXf == true && bXi == true && bVi == true && bDt == true) {
            unit = " m/s";
            initialPos = Double.parseDouble(initialPosStr);
            finalPos = Double.parseDouble(finalPosStr);
            initialVel = Double.parseDouble(initialVelStr);
            elapsedTime = Double.parseDouble(elapsedTimeStr);

            result = formula.vf_2(initialPos, finalPos, initialVel, elapsedTime);

            output = result + unit;
        } else if (desiredValue == 4 && bXf == true && bXi == true && bVi == true && bA == true) {
            unit = " m/s";
            initialPos = Double.parseDouble(initialPosStr);
            finalPos = Double.parseDouble(finalPosStr);
            initialVel = Double.parseDouble(initialVelStr);
            acceleration = Double.parseDouble(accelerationStr);

            result = formula.vf_4(initialPos, finalPos, initialVel, acceleration);

            output = result + unit;
        } // Trouver la variation du temps (5):
        else if (desiredValue == 5 && bVi == true && bVf == true && bA == true) {
            unit = " s";
            initialVel = Double.parseDouble(initialVelStr);
            finalVel = Double.parseDouble(finalVelStr);
            acceleration = Double.parseDouble(accelerationStr);

            result = formula.d_t_1(initialVel, finalVel, acceleration);

            output = result + unit;

        } else if (desiredValue == 5 && bXi == true && bXf == true && bVi == true && bVf == true) {
            unit = " s";
            initialPos = Double.parseDouble(initialPosStr);
            finalPos = Double.parseDouble(finalPosStr);
            initialVel = Double.parseDouble(initialVelStr);
            finalVel = Double.parseDouble(finalVelStr);

            result = formula.d_t_2(initialPos, finalPos, initialVel, finalVel);

            output = result + unit;
        } else if (desiredValue == 5 && bXi == true && bXf == true && bVi == true && bA == true) {
            unit = " s";
            initialPos = Double.parseDouble(initialPosStr);
            finalPos = Double.parseDouble(finalPosStr);
            initialVel = Double.parseDouble(initialVelStr);

            double result1 = formula.d_t1_3(acceleration, initialPos, finalPos, initialVel);
            double result2 = formula.d_t2_3(acceleration, initialPos, finalPos, initialVel);

            output = result1 + unit + " or " + result2 + unit;
        } // Trouver l'accélération(6):
        else if (desiredValue == 6 && bVi == true && bVf == true && bDt == true) {
            unit = " m/s²";
            initialVel = Double.parseDouble(initialVelStr);
            finalVel = Double.parseDouble(finalVelStr);
            elapsedTime = Double.parseDouble(elapsedTimeStr);

            result = formula.a_1(initialVel, finalVel, elapsedTime);

            output = result + unit;
        } else if (desiredValue == 6 && bXi == true && bXf == true && bVi == true && bDt == true) {
            unit = " m/s²";
            initialPos = Double.parseDouble(initialPosStr);
            finalPos = Double.parseDouble(finalPosStr);
            initialVel = Double.parseDouble(initialVelStr);
            elapsedTime = Double.parseDouble(elapsedTimeStr);

            result = formula.a_3(initialPos, finalPos, elapsedTime, initialVel);

            output = result + unit;
        } else if (desiredValue == 6 && bXi == true && bXf == true && bVi == true && bVf == true) {
            unit = " m/s²";
            initialPos = Double.parseDouble(initialPosStr);
            finalPos = Double.parseDouble(finalPosStr);
            initialVel = Double.parseDouble(initialVelStr);
            finalVel = Double.parseDouble(finalVelStr);

            result = formula.a_4(initialPos, finalPos, initialVel, finalVel);

            output = result + unit;
        } else if (desiredValue == 0){
            output = "Please choose the value you are looking for.";
        } else {
            output = "Impossible to find desired value with given values.";
        }
        return output;
    }
}
