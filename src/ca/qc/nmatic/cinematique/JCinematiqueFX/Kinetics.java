package ca.qc.nmatic.cinematique.JCinematiqueFX;

public class Kinetics {

    private String desiredValue = null;

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
    private final String UNIT_DISTANCE = " m";
    private final String UNIT_VELOCITY = " m/s";
    private final String UNIT_ACCELERATION = " m/s²";
    private final String UNIT_TIME = " s";
    private final String IMPOSSIBLE_WITH_GIVEN_VALUES = "Impossible to find desired value with given values.";
    private final String DELTA = "\u0394";
    // Variables de sortie
    private String unit, formule, formuleDonnees, output;
    private double result;

    private final Formulas formula;

    public Kinetics(String initialPosStr, String finalPosStr, String initialVelStr, String finalVelStr, String elapsedTimeStr, String accelerationStr, String desiredValue) {
        this.formula = new Formulas();
        this.initialPosStr = initialPosStr;
        this.finalPosStr = finalPosStr;
        this.initialVelStr = initialVelStr;
        this.finalVelStr = finalVelStr;
        this.elapsedTimeStr = elapsedTimeStr;
        this.accelerationStr = accelerationStr;
        this.desiredValue = desiredValue;
        System.out.println(this.desiredValue);
    }

    public String findValue() {
        bXi = !initialPosStr.equals("");
        bXf = !finalPosStr.equals("");
        bVi = !initialVelStr.equals("");
        bVf = !finalVelStr.equals("");
        bDt = !elapsedTimeStr.equals("");
        bA = !accelerationStr.equals("");

        try {
            if (bXi) {
                initialPos = Double.parseDouble(initialPosStr);
            }
            if (bXf) {
                finalPos = Double.parseDouble(finalPosStr);
            }
            if (bVi) {
                initialVel = Double.parseDouble(initialVelStr);
            }
            if (bVf) {
                finalVel = Double.parseDouble(finalVelStr);
            }
            if (bDt) {
                elapsedTime = Double.parseDouble(elapsedTimeStr);
            }
            if (bA) {
                acceleration = Double.parseDouble(accelerationStr);
            }
        } catch (NumberFormatException e) {
            return "Bad input, try again.";
        }

        switch (desiredValue) {
            case "Initial position":
                unit = UNIT_DISTANCE;
                if (bXf && bVi && bVf && bDt) {
                    result = formula.xi_2(finalPos, initialVel, finalVel, elapsedTime);
                    formule = "Xi = -½ *(Vi + Vf)* " + DELTA + "t - Xf";
                    formuleDonnees = "Xi = -½ * (" + initialVel + " + " + finalVel + ") * " + elapsedTime + " - " + finalPos;
                    output = formule + "\n" + formuleDonnees + "\n" + "Xi = " + result + unit;
                } else if (bA && bXf && bVi && bDt) {
                    result = formula.xi_3(acceleration, finalPos, initialVel, elapsedTime);
                    output = result + unit;
                } else if (bVi && bVf && bA && bXf) {
                    result = formula.xi_4(initialVel, finalVel, acceleration, finalPos);
                    output = result + unit;
                } else {
                    output = IMPOSSIBLE_WITH_GIVEN_VALUES;
                }
                break;
            case "Final position":
                unit = UNIT_DISTANCE;
                if (bXi && bVi && bVf && bDt) {
                    result = formula.xf_2(initialPos, initialVel, finalVel, elapsedTime);
                    output = result + unit;
                } else if (bA && bXi && bVi && bDt) {
                    result = formula.xf_3(acceleration, initialPos, initialVel, elapsedTime);
                    output = result + unit;
                } else if (bXi && bVi && bVf && bA) {
                    result = formula.xf_4(initialVel, finalVel, acceleration, initialPos);
                    output = result + unit;
                } else {
                    output = IMPOSSIBLE_WITH_GIVEN_VALUES;
                }
                break;
            case "Initial velocity":
                unit = UNIT_VELOCITY;
                if (bA && bVf && bDt) {
                    result = formula.vi_1(acceleration, finalVel, elapsedTime);
                    output = result + unit;
                } else if (bXf && bXi && bVf && bDt) {
                    result = formula.vi_2(initialPos, finalPos, finalVel, elapsedTime);
                    output = result + unit;
                } else if (bXf && bXi && bA && bDt) {
                    result = formula.vi_3(initialPos, finalPos, acceleration, elapsedTime);
                    output = result + unit;
                } else if (bXf && bXi && bVf && bA) {
                    result = formula.vi_4(initialPos, finalPos, finalVel, acceleration);
                    output = result + unit;
                } else {
                    output = IMPOSSIBLE_WITH_GIVEN_VALUES;
                }
                break;
            case "Final velocity":
                unit = UNIT_VELOCITY;
                if (bA && bDt && bVi) {
                    formule = "Vf = Vi * a\u0394t";
                    result = formula.vf_1(acceleration, initialVel, elapsedTime);
                    output = result + unit;
                } else if (bXf && bXi && bVi && bDt) {
                    result = formula.vf_2(initialPos, finalPos, initialVel, elapsedTime);
                    output = result + unit;
                } else if (bXf && bXi && bVi && bA) {
                    result = formula.vf_4(initialPos, finalPos, initialVel, acceleration);
                    output = result + unit;
                } else {
                    output = IMPOSSIBLE_WITH_GIVEN_VALUES;
                }
                break;
            case "Elapsed time":
                unit = UNIT_TIME;
                if (bVi && bVf && bA) {
                    result = formula.d_t_1(initialVel, finalVel, acceleration);
                    output = result + unit;
                } else if (bXi && bXf && bVi && bVf) {
                    result = formula.d_t_2(initialPos, finalPos, initialVel, finalVel);
                    output = result + unit;
                } else if (bXi && bXf && bVi && bA) {
                    double result1 = formula.d_t1_3(acceleration, initialPos, finalPos, initialVel);
                    double result2 = formula.d_t2_3(acceleration, initialPos, finalPos, initialVel);
                    output = result1 + unit + " or " + result2 + unit;
                } else {
                    output = IMPOSSIBLE_WITH_GIVEN_VALUES;
                }
                break;
            case "Acceleration":
                unit = UNIT_ACCELERATION;
                if (bVi && bVf && bDt) {
                    result = formula.a_1(initialVel, finalVel, elapsedTime);
                    output = result + unit;
                } else if (bXi && bXf && bVi && bDt) {
                    result = formula.a_3(initialPos, finalPos, elapsedTime, initialVel);
                    output = result + unit;
                } else if (bXi && bXf && bVi && bVf) {
                    result = formula.a_4(initialPos, finalPos, initialVel, finalVel);
                    output = result + unit;
                } else {
                    output = IMPOSSIBLE_WITH_GIVEN_VALUES;
                }
                break;
            default:
                output = "Please choose the unknown value.";
                break;
        }
        return output;
    }
}