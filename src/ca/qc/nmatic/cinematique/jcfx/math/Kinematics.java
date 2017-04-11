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
package ca.qc.nmatic.cinematique.jcfx.math;

import ca.qc.nmatic.cinematique.jcfx.formulas.Formulas;
import ca.qc.nmatic.cinematique.jcfx.formulas.Result;

/**
 *
 * @author Victor Babin
 */
public class Kinematics {

    private String desiredValue = null;

    // Déclaration des booleens pour les cases des valeurs connues
    private boolean xiAlive = false;
    private boolean xfAlive = false;
    private boolean viAlive = false;
    private boolean vfAlive = false;
    private boolean dtAlive = false;
    private boolean aAlive = false;

    // Variables de lecture du formulaire
    private double initialPos, finalPos, initialVel, finalVel, elapsedTime, acceleration;

    private final String initialPosStr, finalPosStr, initialVelStr, finalVelStr, elapsedTimeStr, accelerationStr;
    private static final String UNIT_DISTANCE = " m";
    private static final String UNIT_VELOCITY = " m/s";
    private static final String UNIT_ACCELERATION = " m/s²";
    private static final String UNIT_TIME = " s";
    private static final String IMPOSSIBLE_WITH_GIVEN_VALUES = "Impossible to find desired value with given values.";
    private static final String LATEX_IMPOSSIBLE_WITH_GIVEN_VALUES = "Impossible\\; to\\; compute\\; with\\; given\\; values.";

    // Variables de sortie
    private String unit, formule, formuleDonnees, output, latexOut;

    private boolean withoutError = false;

    private static final Formulas formula = new Formulas();

    public String getLatex() {
        return latexOut;
    }

    public Kinematics(String initialPosStr, String finalPosStr, String initialVelStr, String finalVelStr, String elapsedTimeStr, String accelerationStr, String desiredValue) {
        this.latexOut = null;
        this.initialPosStr = initialPosStr;
        this.finalPosStr = finalPosStr;
        this.initialVelStr = initialVelStr;
        this.finalVelStr = finalVelStr;
        this.elapsedTimeStr = elapsedTimeStr;
        this.accelerationStr = accelerationStr;
        this.desiredValue = desiredValue;
        //formula.formula.createPNG(0, 0, formula.LATEX_VF_1, Color.white, Color.black);
    }

    public boolean isWithoutError() {
        return withoutError;
    }

    public boolean isXiAlive() {
        return xiAlive;
    }

    public void setXiAlive(boolean xiAlive) {
        this.xiAlive = xiAlive;
    }

    public boolean isXfAlive() {
        return xfAlive;
    }

    public void setXfAlive(boolean xfAlive) {
        this.xfAlive = xfAlive;
    }

    public boolean isViAlive() {
        return viAlive;
    }

    public void setViAlive(boolean viAlive) {
        this.viAlive = viAlive;
    }

    public boolean isVfAlive() {
        return vfAlive;
    }

    public void setVfAlive(boolean vfAlive) {
        this.vfAlive = vfAlive;
    }

    public boolean isDtAlive() {
        return dtAlive;
    }

    public void setDtAlive(boolean dtAlive) {
        this.dtAlive = dtAlive;
    }

    public boolean isaAlive() {
        return aAlive;
    }

    public void setaAlive(boolean aAlive) {
        this.aAlive = aAlive;
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

    public Result findValue() {
        Result result = new Result();
        xiAlive = !initialPosStr.equals("");
        xfAlive = !finalPosStr.equals("");
        viAlive = !initialVelStr.equals("");
        vfAlive = !finalVelStr.equals("");
        dtAlive = !elapsedTimeStr.equals("");
        aAlive = !accelerationStr.equals("");

        try {
            if (xiAlive) {
                initialPos = Double.parseDouble(initialPosStr);
            }
            if (xfAlive) {
                finalPos = Double.parseDouble(finalPosStr);
            }
            if (viAlive) {
                initialVel = Double.parseDouble(initialVelStr);
            }
            if (vfAlive) {
                finalVel = Double.parseDouble(finalVelStr);
            }
            if (dtAlive) {
                elapsedTime = Double.parseDouble(elapsedTimeStr);
            }
            if (aAlive) {
                acceleration = Double.parseDouble(accelerationStr);
            }
        } catch (NumberFormatException e) {
            latexOut = "Bad\\; input,\\; try\\; again.";
            return "Bad input, try again.";
        }
        switch (desiredValue) {
            case "Initial position":
                unit = UNIT_DISTANCE;
                if (xfAlive && viAlive && vfAlive && dtAlive) {
                    result = formula.outXi_2(finalPos, initialVel, finalVel, elapsedTime);
                    initialPos = result.getResult();
                } else if (aAlive && xfAlive && viAlive && dtAlive) {
                    result = formula.outXi_3(acceleration, finalPos, initialVel, elapsedTime);
                    initialPos = result.getResult();
                } else if (viAlive && vfAlive && aAlive && xfAlive) {
                    result = formula.outXi_4(initialVel, finalVel, acceleration, finalPos);
                    initialPos = result.getResult();
                } else {
                    result.setLatexError(LATEX_IMPOSSIBLE_WITH_GIVEN_VALUES);
                    result.setRegularError(IMPOSSIBLE_WITH_GIVEN_VALUES);
                    return result;
                }
                break;
            case "Final position":
                unit = UNIT_DISTANCE;
                if (xiAlive && viAlive && vfAlive && dtAlive) {
                    result = formula.outXf_2(initialPos, initialVel, finalVel, elapsedTime);
                    finalPos = result.getResult();
                } else if (aAlive && xiAlive && viAlive && dtAlive) {
                    result = formula.outXf_3(acceleration, initialPos, initialVel, elapsedTime);
                    finalPos = result.getResult();
                } else if (xiAlive && viAlive && vfAlive && aAlive) {
                    result = formula.outXf_4(initialVel, finalVel, acceleration, initialPos);
                    finalPos = result.getResult();
                } else {
                    result.setLatexError(LATEX_IMPOSSIBLE_WITH_GIVEN_VALUES);
                    result.setRegularError(IMPOSSIBLE_WITH_GIVEN_VALUES);
                    return result;
                }
                break;
            case "Initial velocity":
                unit = UNIT_VELOCITY;
                if (aAlive && vfAlive && dtAlive) {
                    result = formula.outVi_1(acceleration, finalVel, elapsedTime);
                    initialVel = result.getResult();
//                    initialVel = formula.outVi_1(acceleration, finalVel, elapsedTime).getResult();
//                    result = initialVel;
//                    formule = formula.FORM_VI_1;
//                    latexOut = formula.outVi_1(acceleration, finalVel, elapsedTime);
                } else if (xfAlive && xiAlive && vfAlive && dtAlive) {

//                    initialVel = formula.outVi_2(initialPos, finalPos, finalVel, elapsedTime).getResult();
//                    result = initialVel;
//                    formule = formula.FORM_VI_2;
//                    latexOut = formula.outVi_2(initialPos, finalPos, finalVel, elapsedTime);
                } else if (xfAlive && xiAlive && aAlive && dtAlive) {

//                    initialVel = formula.outVi_3(initialPos, finalPos, acceleration, elapsedTime).getResult();
//                    result = initialVel;
//                    formule = formula.FORM_VI_3;
//                    latexOut = formula.outVi_3(initialPos, finalPos, acceleration, elapsedTime);
                } else if (xfAlive && xiAlive && vfAlive && aAlive) {

//                    initialVel = formula.outVi_4(initialPos, finalPos, finalVel, acceleration).getResult();
//                    result = initialVel;
//                    formule = formula.FORM_VI_4;
//                    latexOut = formula.outVi_4(initialPos, finalPos, finalVel, acceleration);
                } else {
                    result.setLatexError(LATEX_IMPOSSIBLE_WITH_GIVEN_VALUES);
                    result.setRegularError(IMPOSSIBLE_WITH_GIVEN_VALUES);
                    return result;
                }
                break;
            case "Final velocity":
                unit = UNIT_VELOCITY;
                if (aAlive && dtAlive && viAlive) {

//                    finalVel = formula.outVf_1(acceleration, initialVel, elapsedTime).getResult();
//                    result = finalVel;
//                    formule = formula.FORM_VF_1;
//                    latexOut = formula.outVf_1(acceleration, initialVel, elapsedTime);
                } else if (xfAlive && xiAlive && viAlive && dtAlive) {

//                    finalVel = formula.outVf_2(initialPos, finalPos, initialVel, elapsedTime).getResult();
//                    result = finalVel;
//                    formule = formula.FORM_VF_2;
//                    latexOut = formula.outVf_2(initialPos, finalPos, initialVel, elapsedTime);
                } else if (xfAlive && xiAlive && viAlive && aAlive) {

//                    finalVel = formula.outVf_4(initialPos, finalPos, initialVel, acceleration).getResult();
//                    result = finalVel;
//                    formule = formula.FORM_VF_4;
//                    latexOut = formula.outVf_4(initialPos, finalPos, initialVel, acceleration);
                } else {
                    result.setLatexError(LATEX_IMPOSSIBLE_WITH_GIVEN_VALUES);
                    result.setRegularError(IMPOSSIBLE_WITH_GIVEN_VALUES);
                    return result;
                }
                break;
            case "Elapsed time":
                unit = UNIT_TIME;
                if (viAlive && vfAlive && aAlive) {

//                    elapsedTime = formula.outD_t_1(initialVel, finalVel, acceleration).getResult();
//                    result = elapsedTime;
//                    formule = formula.FORM_DT_1;
//                    latexOut = formula.outD_t_1(initialVel, finalVel, acceleration);
                } else if (xiAlive && xfAlive && viAlive && vfAlive) {

//                    elapsedTime = formula.outD_t_2(initialPos, finalPos, initialVel, finalVel).getResult();
//                    result = elapsedTime;
//                    formule = formula.FORM_DT_2;
//                    latexOut = formula.outD_t_2(initialPos, finalPos, initialVel, finalVel);
                } else if (xiAlive && xfAlive && viAlive && aAlive) {

//                    formule = formula.FORM_DT_3;
                    double result1 = formula.outD_t1_3(acceleration, initialPos, finalPos, initialVel).getResult();
                    double result2 = formula.outD_t2_3(acceleration, initialPos, finalPos, initialVel).getResult();
                    if (result1 > 0) {

//                        elapsedTime = result1;
//                        latexOut = formula.outD_t1_3(acceleration, initialPos, finalPos, initialVel);
                    } else if (result2 > 0) {

//                        elapsedTime = result2;
//                        latexOut = formula.outD_t2_3(acceleration, initialPos, finalPos, initialVel);
                    }
//                    result = elapsedTime;

                } else {
                    result.setLatexError(LATEX_IMPOSSIBLE_WITH_GIVEN_VALUES);
                    result.setRegularError(IMPOSSIBLE_WITH_GIVEN_VALUES);
                    return result;
                }
                break;
            case "Acceleration":
                unit = UNIT_ACCELERATION;
                if (viAlive && vfAlive && dtAlive) {

//                    acceleration = formula.outA_1(initialVel, finalVel, elapsedTime).getResult();
//                    result = acceleration;
//                    formule = formula.FORM_A_1;
//                    latexOut = formula.outA_1(initialVel, finalVel, elapsedTime);
                } else if (xiAlive && xfAlive && viAlive && dtAlive) {

//                    acceleration = formula.outA_3(initialPos, finalPos, elapsedTime, initialVel).getResult();
//                    result = acceleration;
//                    formule = formula.FORM_A_3;
//                    latexOut = formula.outA_3(initialPos, finalPos, elapsedTime, initialVel);
                } else if (xiAlive && xfAlive && viAlive && vfAlive) {

//                    acceleration = formula.outA_4(initialPos, finalPos, initialVel, finalVel).getResult();
//                    result = acceleration;
//                    formule = formula.FORM_A_4;
//                    latexOut = formula.outA_4(initialPos, finalPos, initialVel, finalVel);
                } else {
                    result.setLatexError(LATEX_IMPOSSIBLE_WITH_GIVEN_VALUES);
                    result.setRegularError(IMPOSSIBLE_WITH_GIVEN_VALUES);
                    return result;
                }
                break;
            default:
                latexOut = "\\displaystyle Please\\; choose\\; unknown\\; value.";
                return "Please choose the unknown value.";
        }
        withoutError = true;
        return formule + "\n" + result + unit;
    }

}
