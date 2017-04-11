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
package ca.qc.nmatic.cinematique.jcfx.formulas;

/**
 *
 * @author Victor Babin
 */
public class Formulas {

    //TODO: Terminer les formules
    protected static final String DELTA = "\u0394";
    protected static final String HALF = "\u00BD";
    protected static final String SQUARED = "\u00B2";
    protected static final String RADICAL = "\u23B7";
    protected static final String PLUS_MINUS = "\u00B1";

    protected static final String LATEX_UNIT_DISTANCE = " m";
    protected static final String LATEX_UNIT_VELOCITY = " \\frac{m}{s}";
    protected static final String LATEX_UNIT_ACCELERATION = " \\frac{m}{s^{2}}";
    protected static final String LATEX_UNIT_TIME = " s";

    

    // Formules affichées
    protected static final String FORM_VF_1 = "Vf = Vi + a" + DELTA + "t";
    protected static final String FORM_VI_1 = "Vi = -(a" + DELTA + "t - Vf)";
    protected static final String FORM_A_1 = "a = (" + DELTA + "v )/" + DELTA + "t";
    protected static final String FORM_DT_1 = DELTA + "t = " + DELTA + "v/a";
    protected static final String FORM_XF_2 = "Xf = Xi + " + HALF + "(Vi + Vf) * " + DELTA + "t";
    protected static final String FORM_XI_2 = "Xi = -(" + HALF + "(Vi + Vf) * " + DELTA + "t - Xf)";
    protected static final String FORM_VI_2 = "Vi = 2(" + DELTA + "x)/(" + DELTA + "t - Vf)";
    protected static final String FORM_VF_2 = "Vf = 2(" + DELTA + "x)/(" + DELTA + "t - Vi)";
    protected static final String FORM_DT_2 = DELTA + "t = " + DELTA + "x / (" + HALF + "(Vi + Vf)";
    protected static final String FORM_XF_3 = "Xf = Xi + (Vi * " + DELTA + "t) + (" + HALF + "a * (" + DELTA + "t" + SQUARED + "))";
    protected static final String FORM_XI_3 = "Xi = (-((Vi * " + DELTA + "t) + (" + HALF + "a * " + DELTA + "t" + SQUARED + ")) - Xf))";
    protected static final String FORM_DT_3 = DELTA + "t = (-Vi " + PLUS_MINUS + " " + RADICAL + "((Vi" + SQUARED + ") - 4((a / 2) * (" + DELTA + "x)))) / a";
    protected static final String FORM_VI_3 = "Vi = ((" + HALF + "a * (" + DELTA + "t" + SQUARED + ") - (" + DELTA + "x)) / - " + DELTA + "t)";
    protected static final String FORM_A_3 = "a = ((Vi * " + DELTA + "t - (" + DELTA + "x)) / (" + DELTA + "t" + SQUARED + ")) / (- " + HALF + ")";
    protected static final String FORM_VF_4 = "Vf = " + RADICAL + "((Vi" + SQUARED + ") + 2a(" + DELTA + "x))";
    protected static final String FORM_VI_4 = "Vi = " + RADICAL + "(-(2a" + DELTA + "x) - (Vf" + SQUARED + ")))";
    protected static final String FORM_A_4 = "a = (((Vf" + SQUARED + ") - (Vi" + SQUARED + ")) / 2 * " + DELTA + "x))";
    protected static final String FORM_XI_4 = "Xi = -((((Vf" + SQUARED + ") - (Vi" + SQUARED + ")) / (2a)) - Xf)";
    protected static final String FORM_XF_4 = "Xf = (((Vf" + SQUARED + ") - (Vi" + SQUARED + ")) / 2a) + Xi";

    protected static final String LATEX_VF_1 = "v_{f} = v_{i} + a\\Delta t";
    protected static final String LATEX_VI_1 = "v_{i} = -(a\\Delta t - v_{f})";
    protected static final String LATEX_A_1 = "a = \\frac{\\Delta v}{\\Delta t}";
    protected static final String LATEX_DT_1 = "\\Delta t = \\frac{\\Delta v}{a}";
    protected static final String LATEX_XF_2 = "x_{f} = x_{i} + \\frac{1}{2} (v_{i} + v_{f})\\Delta t";
    protected static final String LATEX_XI_2 = "x_{i} = -(\\frac{1}{2}(v_{i} + v_{f})\\Delta t - x_{f})";
    protected static final String LATEX_VI_2 = "v_{i} = 2(\\Delta x)/(\\Delta t - v_{f})";
    protected static final String LATEX_VF_2 = "v_{f} = 2(\\Delta x)/(\\Delta t - v_{i})";
    protected static final String LATEX_DT_2 = "\\Delta t = \\Delta x / (\\frac{1}{2}(v_{i} + v_{f})";
    protected static final String LATEX_XF_3 = "x_{f} = x_{i} + (v_{i} * \\Delta t) + (\\frac{1}{2}a * (\\Delta t^{2}))";
    protected static final String LATEX_XI_3 = "x_{i} = -\\left (v_{i} * \\Delta t) + (\\frac{1}{2}a * \\Delta t^{2})) - x_{f} \\right";
    protected static final String LATEX_DT_3 = "\\Delta t = \\frac{-v_{i} \\pm \\sqrt{((v_{i}^{2}) - 4((a / 2) * (\\Delta x)))}}{a}";
    protected static final String LATEX_VI_3 = "v_{i} = \\frac{((\\frac{1}{2}a * (\\Delta t^{2}) - (\\Delta x))}{-\\Delta t}";
    protected static final String LATEX_A_3 = "a = \\frac{v_{i}\\Delta t - \\Delta x}{\\Delta t^{2}}\\;/\\;- \\frac{1}{2}";
    protected static final String LATEX_VF_4 = "v_{f} = \\sqrt{(v_{i}^{2}) + 2a\\Delta x}";
    protected static final String LATEX_VI_4 = "v_{i} = \\sqrt{-(2a\\Delta x) - (v_{f}^{2})}";
    protected static final String LATEX_A_4 = "a = \\frac{((v_{f}^{2}) - (v_{i}^{2}))}{2}\\;\\Delta x)";
    protected static final String LATEX_XI_4 = "x_{i} = -\\left \\frac{(v_{f}^{2} - v_{i}^{2})}{2a} - x_{f} \\right";
    protected static final String LATEX_XF_4 = "x_{f} = \\frac{(v_{f}^{2} - v_{i}^{2})}{2a} + x_{i}";

    protected static final String LATEX_VF = "v_{f} = ";
    protected static final String LATEX_VI = "v_{i} = ";
    protected static final String LATEX_A = "a = ";
    protected static final String LATEX_DT = "\\Delta t = ";
    protected static final String LATEX_XF = "x_{f} = ";
    protected static final String LATEX_XI = "x_{i} = ";

    public Result outVf_1(double a, double vi, double d_t) {
        return (new Result((vi + a * d_t), FORM_VF_1, LATEX_VF_1, vi + " + " + a + " \\cdot " + d_t + "", LATEX_VF, LATEX_UNIT_VELOCITY));
    }

    public Result outVi_1(double a, double vf, double d_t) {
        return (new Result((-(a * d_t - vf)), FORM_VI_1, LATEX_VI_1, LATEX_VI + "-(" + a + "" + d_t + " - " + vf + ")", LATEX_VI, LATEX_UNIT_VELOCITY));
    }

    public Result outA_1(double vi, double vf, double d_t) {
        return (new Result(((vf - vi) / d_t), FORM_A_1, LATEX_A_1, "\\frac{" + (vf - vi) + "}{" + d_t + "}", LATEX_A, LATEX_UNIT_ACCELERATION));
    }

    public Result outD_t_1(double vi, double vf, double a) {
        return (new Result(((vf - vi) / a), FORM_DT_1, LATEX_DT_1, "\\frac{" + (vf - vi) + "}{" + a + "}", LATEX_DT, LATEX_UNIT_TIME));
    }

    public Result outXf_2(double xi, double vi, double vf, double d_t) {
        return (new Result((xi + 0.5 * (vi + vf) * d_t), FORM_XF_2, LATEX_XF_2, xi + " + \\frac{1}{2} \\cdot (" + vi + " + " + vf + ") \\cdot " + d_t + "", LATEX_XF, LATEX_UNIT_DISTANCE));
    }

    public Result outXi_2(double xf, double vi, double vf, double d_t) {
        return (new Result((-(0.5 * (vi + vf) * d_t - xf)), FORM_XI_2, LATEX_XI_2, "-(\\frac{1}{2}( " + vi + " + " + vf + ") \\cdot " + d_t + " - " + xf + ")", LATEX_XI, LATEX_UNIT_DISTANCE));
    }

    public Result outVi_2(double xi, double xf, double vf, double d_t) {
        return (new Result(((2 * (xf - xi)) / (d_t) - vf), FORM_VF_2, LATEX_VF_2, "2 \\cdot \\frac{" + (xf - xi) + "}{" + d_t + " - " + vf + "}", LATEX_VI, LATEX_UNIT_VELOCITY));
    }

    public Result outVf_2(double xi, double xf, double vi, double d_t) {
        return (new Result(((2 * (xf - xi)) / (d_t) - vi), FORM_VF_2, LATEX_VF_2, "2 \\cdot \\frac{" + (xf - xi) + "}{" + d_t + " - " + vi + "}", LATEX_VF, LATEX_UNIT_VELOCITY));
    }

    public Result outD_t_2(double xi, double xf, double vi, double vf) {
        return (new Result(((xf - xi) / (0.5 * (vi + vf))), FORM_DT_2, LATEX_DT_2, "\\frac{" + (xf - xi) + "}{(\\frac{1}{2} \\cdot (" + vi + " + " + vf + ")}", LATEX_DT, LATEX_UNIT_TIME));
    }

    public Result outXf_3(double a, double xi, double vi, double d_t) {
        return (new Result(xi + (vi * d_t) + (0.5 * a * (d_t * d_t)), FORM_XF_3, LATEX_XF_3, xi + " + ( " + vi + " *  " + d_t + ") + (\\frac{1}{2} " + a + "* ( " + d_t + "^{2}))", LATEX_XF, LATEX_UNIT_DISTANCE));
    }

    public Result outXi_3(double a, double xf, double vi, double d_t) {
        return (new Result((-((vi * d_t) + (0.5 * a * (d_t * d_t)) - xf)), FORM_XI_3, LATEX_XI_3, "-\\left ( " + vi + " *  " + d_t + ") + (\\frac{1}{2}" + a + " * " + d_t + "^{2})) - " + xf + " \\right", LATEX_XI, LATEX_UNIT_DISTANCE));
    }

    public Result outD_t1_3(double a, double xi, double xf, double vi) {
        return (new Result((-vi + Math.sqrt((vi * vi) - 4 * ((a / 2) * (xf - xi)))) / a, FORM_DT_3, LATEX_DT_3, "\\frac{- " + vi + " \\pm \\sqrt{(( " + vi + "^{2}) - 4((" + a + "/ 2) \\cdot ( " + (xf - xi) + ")))}}{" + a + "}", LATEX_DT, LATEX_UNIT_TIME));
    }

    public Result outD_t2_3(double a, double xi, double xf, double vi) {
        return (new Result((-vi - Math.sqrt((vi * vi) - 4 * ((a / 2) * (xf - xi)))) / a, FORM_DT_3, LATEX_DT_3, "\\frac{- " + vi + " \\pm \\sqrt{(( " + vi + "^{2}) - 4((" + a + "/ 2) \\cdot ( " + (xf - xi) + ")))}}{" + a + "}", LATEX_DT, LATEX_UNIT_TIME));
    }

    public Result outVi_3(double xi, double xf, double a, double d_t) {
        return (new Result(((0.5 * a * (d_t * d_t) - (xf - xi)) / -d_t) / a, FORM_VI_3, LATEX_VI_3, "\\frac{((\\frac{1}{2} " + a + " \\cdot (" + d_t + "^{2}) - ( " + (xf - xi) + "))}{- " + d_t + "}", LATEX_VI, LATEX_UNIT_VELOCITY));
    }

    public Result outA_3(double xi, double xf, double d_t, double vi) {
        return (new Result(((vi * d_t - (xf - xi)) / (d_t * d_t)) / (-0.5), FORM_A_3, LATEX_A_3, "\\frac{ " + vi + "" + d_t + " - " + (xf - xi) + "}{ " + d_t + "^{2}}\\;/\\;- \\frac{1}{2}", LATEX_A, LATEX_UNIT_ACCELERATION));
    }

    public Result outVf_4(double xi, double xf, double vi, double a) {
        return (new Result(Math.sqrt((vi * vi) + 2 * a * (xf - xi)), FORM_VF_4, LATEX_VF_4, "\\sqrt{(" + vi + "^{2}) + 2 \\cdot " + a + "\\cdot" + (xf - xi) + "}", LATEX_VF, LATEX_UNIT_VELOCITY));
    }

    public Result outVi_4(double xi, double xf, double vf, double a) {
        return (new Result(Math.sqrt(-(2 * a * (xf - xi) - (vf * vf))), FORM_VI_4, LATEX_VI_4, "\\sqrt{-(" + 2 * a + " \\cdot (" + (xf - xi) + ") - (" + vf + "^{2})}", LATEX_VI, LATEX_UNIT_VELOCITY));
    }

    public Result outA_4(double xi, double xf, double vi, double vf) {
        return (new Result((((vf * vf) - (vi * vi)) / 2 * (xf - xi)), FORM_A_4, LATEX_A_4, "\\frac{(( " + vf + "^{2}) - (" + vi + "^{2}))}{2}\\; " + (xf - xi) + ")", LATEX_A, LATEX_UNIT_ACCELERATION));
    }

    public Result outXi_4(double vi, double vf, double a, double xf) {
        return (new Result(-((((vf * vf) - (vi * vi)) / (2 * a)) - xf), FORM_XI_4, LATEX_XI_4, "-\\left \\frac{( " + vf + "^{2} - " + vi + "^{2})}{2 " + a + "} - " + xf + " \\right", LATEX_XI, LATEX_UNIT_DISTANCE));
    }

    public Result outXf_4(double vi, double vf, double a, double xi) {
        return (new Result((((vf * vf) - (vi * vi)) / 2 * a) + xi, FORM_XF_4, LATEX_XF_4, "\\frac{( " + vf + "^{2} - " + vi + "^{2})}{" + (2 * a) + "} + " + xi + "", LATEX_XF, LATEX_UNIT_DISTANCE));
    }

}
