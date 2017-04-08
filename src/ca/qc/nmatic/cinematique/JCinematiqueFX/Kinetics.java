/*
 * Copyright (C) 2017 Victor Babin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ca.qc.nmatic.cinematique.JCinematiqueFX;

/**
 *
 * @author Victor Babin
 */
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
    private static final String UNIT_DISTANCE = " m";
    private static final String UNIT_VELOCITY = " m/s";
    private static final String UNIT_ACCELERATION = " m/s²";
    private static final String UNIT_TIME = " s";
    private static final String IMPOSSIBLE_WITH_GIVEN_VALUES = "Impossible to find desired value with given values.";

    // Variables de sortie
    private String unit, formule, formuleDonnees, output;
    private double result;

    private static final Formulas formula = new Formulas();

    ;

    public Kinetics(String initialPosStr, String finalPosStr, String initialVelStr, String finalVelStr, String elapsedTimeStr, String accelerationStr, String desiredValue) {
        this.initialPosStr = initialPosStr;
        this.finalPosStr = finalPosStr;
        this.initialVelStr = initialVelStr;
        this.finalVelStr = finalVelStr;
        this.elapsedTimeStr = elapsedTimeStr;
        this.accelerationStr = accelerationStr;
        this.desiredValue = desiredValue;
    }

    public double getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(double elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public String getDesiredValue() {
        return desiredValue;
    }

    public void setDesiredValue(String desiredValue) {
        this.desiredValue = desiredValue;
    }

    public double getInitialPos() {
        return initialPos;
    }

    public void setInitialPos(double initialPos) {
        this.initialPos = initialPos;
    }

    public double getFinalPos() {
        return finalPos;
    }

    public void setFinalPos(double finalPos) {
        this.finalPos = finalPos;
    }

    public double getInitialVel() {
        return initialVel;
    }

    public void setInitialVel(double initialVel) {
        this.initialVel = initialVel;
    }

    public double getFinalVel() {
        return finalVel;
    }

    public void setFinalVel(double finalVel) {
        this.finalVel = finalVel;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
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
                    initialPos = formula.xi_2(finalPos, initialVel, finalVel, elapsedTime);
                    result = initialPos;
                    formule = formula.FORM_XI_2;

                } else if (bA && bXf && bVi && bDt) {
                    initialPos = formula.xi_3(acceleration, finalPos, initialVel, elapsedTime);
                    result = initialPos;
                    formule = formula.FORM_XI_3;

                } else if (bVi && bVf && bA && bXf) {
                    initialPos = formula.xi_4(initialVel, finalVel, acceleration, finalPos);
                    result = initialPos;
                    formule = formula.FORM_XI_4;

                } else {
                    return IMPOSSIBLE_WITH_GIVEN_VALUES;
                }
                break;
            case "Final position":
                unit = UNIT_DISTANCE;
                if (bXi && bVi && bVf && bDt) {
                    finalPos = formula.xf_2(initialPos, initialVel, finalVel, elapsedTime);
                    result = finalPos;
                    formule = formula.FORM_XF_2;

                } else if (bA && bXi && bVi && bDt) {
                    finalPos = formula.xf_3(acceleration, initialPos, initialVel, elapsedTime);
                    result = finalPos;
                    formule = formula.FORM_XF_3;

                } else if (bXi && bVi && bVf && bA) {
                    finalPos = formula.xf_4(initialVel, finalVel, acceleration, initialPos);
                    result = finalPos;
                    formule = formula.FORM_XF_4;

                } else {
                    return IMPOSSIBLE_WITH_GIVEN_VALUES;
                }
                break;
            case "Initial velocity":
                unit = UNIT_VELOCITY;
                if (bA && bVf && bDt) {
                    initialVel = formula.vi_1(acceleration, finalVel, elapsedTime);
                    result = initialVel;
                    formule = formula.FORM_VI_1;

                } else if (bXf && bXi && bVf && bDt) {
                    initialVel = formula.vi_2(initialPos, finalPos, finalVel, elapsedTime);
                    result = initialVel;
                    formule = formula.FORM_VI_2;

                } else if (bXf && bXi && bA && bDt) {
                    initialVel = formula.vi_3(initialPos, finalPos, acceleration, elapsedTime);
                    result = initialVel;
                    formule = formula.FORM_VI_3;

                } else if (bXf && bXi && bVf && bA) {
                    initialVel = formula.vi_4(initialPos, finalPos, finalVel, acceleration);
                    result = initialVel;
                    formule = formula.FORM_VI_4;

                } else {
                    return IMPOSSIBLE_WITH_GIVEN_VALUES;
                }
                break;
            case "Final velocity":
                unit = UNIT_VELOCITY;
                if (bA && bDt && bVi) {
                    finalVel = formula.vf_1(acceleration, initialVel, elapsedTime);
                    result = finalVel;
                    formule = formula.FORM_VF_1;

                } else if (bXf && bXi && bVi && bDt) {
                    finalVel = formula.vf_2(initialPos, finalPos, initialVel, elapsedTime);
                    result = finalVel;
                    formule = formula.FORM_VF_2;

                } else if (bXf && bXi && bVi && bA) {
                    finalVel = formula.vf_4(initialPos, finalPos, initialVel, acceleration);
                    result = finalVel;
                    formule = formula.FORM_VF_4;

                } else {
                    return IMPOSSIBLE_WITH_GIVEN_VALUES;
                }
                break;
            case "Elapsed time":
                unit = UNIT_TIME;
                if (bVi && bVf && bA) {
                    elapsedTime = formula.d_t_1(initialVel, finalVel, acceleration);
                    result = elapsedTime;
                    formule = formula.FORM_DT_1;

                } else if (bXi && bXf && bVi && bVf) {
                    elapsedTime = formula.d_t_2(initialPos, finalPos, initialVel, finalVel);
                    result = elapsedTime;
                    formule = formula.FORM_DT_1;

                } else if (bXi && bXf && bVi && bA) {
                    formule = formula.FORM_DT_3;
                    double result1 = formula.d_t1_3(acceleration, initialPos, finalPos, initialVel);
                    double result2 = formula.d_t2_3(acceleration, initialPos, finalPos, initialVel);
                    if (result1 > 0) {
                        elapsedTime = result1;
                    } else if (result2 > 0) {
                        elapsedTime = result2;
                    }
                    result = elapsedTime;

                } else {
                    return IMPOSSIBLE_WITH_GIVEN_VALUES;
                }
                break;
            case "Acceleration":
                unit = UNIT_ACCELERATION;
                if (bVi && bVf && bDt) {
                    acceleration = formula.a_1(initialVel, finalVel, elapsedTime);
                    result = acceleration;
                    formule = formula.FORM_A_1;

                } else if (bXi && bXf && bVi && bDt) {
                    acceleration = formula.a_3(initialPos, finalPos, elapsedTime, initialVel);
                    result = acceleration;
                    formule = formula.FORM_A_3;

                } else if (bXi && bXf && bVi && bVf) {
                    acceleration = formula.a_4(initialPos, finalPos, initialVel, finalVel);
                    result = acceleration;
                    formule = formula.FORM_A_4;

                } else {
                    return IMPOSSIBLE_WITH_GIVEN_VALUES;
                }
                break;
            default:
                return "Please choose the unknown value.";
        }
        return formule + "\n" + result + unit;
    }

}
