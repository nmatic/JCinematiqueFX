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

import org.scilab.forge.jlatexmath.*;

/**
 *
 * @author Victor Babin
 */
public class Formulas {

    //TODO: Terminer les formules
    protected final String DELTA = "\u0394";
    protected final String HALF = "\u00BD";
    protected final String SQUARED = "\u00B2";
    protected final String RADICAL = "\u23B7";
    protected final String PLUS_MINUS = "\u00B1";

    // Formules affichées
    protected final String FORM_VF_1 = "Vf = Vi + a" + DELTA + "t";
    protected final String FORM_VI_1 = "Vi = -(a" + DELTA + "t - Vf)";
    protected final String FORM_A_1 = "a = (" + DELTA + "v )/" + DELTA + "t";
    protected final String FORM_DT_1 = DELTA + "t = " + DELTA + "v/a";
    protected final String FORM_XF_2 = "Xf = Xi + " + HALF + "(Vi + Vf) * " + DELTA + "t";
    protected final String FORM_XI_2 = "Xi = -(" + HALF + "(Vi + Vf) * " + DELTA + "t - Xf)";
    protected final String FORM_VI_2 = "Vi = 2(" + DELTA + "x)/(" + DELTA + "t - Vf)";
    protected final String FORM_VF_2 = "Vf = 2(" + DELTA + "x)/(" + DELTA + "t - Vi)";
    protected final String FORM_DT_2 = DELTA + "t = " + DELTA + "x / (" + HALF + "(Vi + Vf)";
    protected final String FORM_XF_3 = "Xf = Xi + (Vi * " + DELTA + "t) + (" + HALF + "a * (" + DELTA + "t" + SQUARED + "))";
    protected final String FORM_XI_3 = "Xi = (-((Vi * " + DELTA + "t) + (" + HALF + "a * " + DELTA + "t" + SQUARED + ")) - Xf))";
    protected final String FORM_DT_3 = DELTA + "t = (-Vi " + PLUS_MINUS + " " + RADICAL + "((Vi" + SQUARED + ") - 4((a / 2) * (" + DELTA + "x)))) / a";
    protected final String FORM_VI_3 = "Vi = ((" + HALF + "a * (" + DELTA + "t" + SQUARED + ") - (" + DELTA + "x)) / - " + DELTA + "t)";
    protected final String FORM_A_3 = "a = ((Vi * " + DELTA + "t - (" + DELTA + "x)) / (" + DELTA + "t" + SQUARED + ")) / (- " + HALF + ")";
    protected final String FORM_VF_4 = "Vf = " + RADICAL + "((Vi" + SQUARED + ") + 2a(" + DELTA + "x))";
    protected final String FORM_VI_4 = "Vi = " + RADICAL + "(-(2a" + DELTA + "x) - (Vf" + SQUARED + ")))";
    protected final String FORM_A_4 = "a = (((Vf" + SQUARED + ") - (Vi" + SQUARED + ")) / 2 * " + DELTA + "x))";
    protected final String FORM_XI_4 = "Xi = -((((Vf" + SQUARED + ") - (Vi" + SQUARED + ")) / (2a)) - Xf)";
    protected final String FORM_XF_4 = "Xf = (((Vf" + SQUARED + ") - (Vi" + SQUARED + ")) / 2a) + Xi";

    protected final String LATEX_VF_1 = "v_{f} = v_{i} + a\\Delta t";
    protected final String LATEX_VI_1 = "v_{i} = -(a\\Delta t - v_{f})";
    protected final String LATEX_A_1 = "a = \\frac{\\Delta v}{\\Delta t}";
    protected final String LATEX_DT_1 = "\\Delta t = \\frac{\\Delta v}{a}";
    protected final String LATEX_XF_2 = "x_{f} = x{i} + \\frac{1}{2} (v{i} + v{f})\\Delta t";
    protected final String LATEX_XI_2 = "x{i} = -(\\frac{1}{2}(v{i} + v{f})\\Delta t - x{f})";
    protected final String LATEX_VI_2 = "v{i} = 2(\\Delta x)/(\\Delta t - v{f})";
    protected final String LATEX_VF_2 = "v{f} = 2(\\Delta x)/(\\Delta t - v{i})";
    protected final String LATEX_DT_2 = "\\Delta t = \\Delta x / (\\frac{1}{2}(v{i} + v{f})";
    protected final String LATEX_XF_3 = "x{f} = x{i} + (v{i} * \\Delta t) + (\\frac{1}{2}a * (\\Delta t^{2}))";
    protected final String LATEX_XI_3 = "x{i} = -\\left (v{i} * \\Delta t) + (\\frac{1}{2}a * \\Delta t^{2})) - x{f} \\right";
    protected final String LATEX_DT_3 = "\\Delta t = \\frac{-v{i} \\pm \\sqrt{((v{i}^{2}) - 4((a / 2) * (\\Delta x)))}}{a}";
    protected final String LATEX_VI_3 = "v{i} = \\frac{((\\frac{1}{2}a * (\\Delta t^{2}) - (\\Delta x))}{-\\Delta t}";
    protected final String LATEX_A_3 = "a = \\frac{v{i}\\Delta t - \\Delta x}{\\Delta t^{2}}\\;/\\;- \\frac{1}{2}";
    protected final String LATEX_VF_4 = "v{f} = \\sqrt{(v{i}^{2}) + 2a\\Delta x}";
    protected final String LATEX_VI_4 = "v{i} = \\sqrt{-(2a\\Delta x) - (v{f}^{2})}";
    protected final String LATEX_A_4 = "a = \\frac{((v{f}^{2}) - (v{i}^{2}))}{2}\\;\\Delta x)";
    protected final String LATEX_XI_4 = "x{i} = -\\left \\frac{(v{f}^{2} - v{i}^{2})}{2a} - x{f} \\right";
    protected final String LATEX_XF_4 = "x{f} = \\frac{(v{f}^{2} - v{i}^{2})}{2a} + x{i}";

    private double result;
    private String output, latexData;

    // Formules calculées
    public double vf_1(double a, double vi, double d_t) {
        return (vi + a * d_t);
    }

    public double vi_1(double a, double vf, double d_t) {
        return (-(a * d_t - vf));
    }

    public double a_1(double vi, double vf, double d_t) {
        return ((vf - vi) / d_t);
    }

    public double d_t_1(double vi, double vf, double a) {
        return ((vf - vi) / a);
    }

    public double xf_2(double xi, double vi, double vf, double d_t) {
        return (xi + 0.5 * (vi + vf) * d_t);
    }

    public double xi_2(double xf, double vi, double vf, double d_t) {
        return (-(0.5 * (vi + vf) * d_t - xf));
    }

    public double vi_2(double xi, double xf, double vf, double d_t) {
        return ((2 * (xf - xi)) / (d_t) - vf);
    }

    public double vf_2(double xi, double xf, double vi, double d_t) {
        return ((2 * (xf - xi)) / (d_t) - vi);
    }

    public double d_t_2(double xi, double xf, double vi, double vf) {
        return ((xf - xi) / (0.5 * (vi + vf)));
    }

    public double xf_3(double a, double xi, double vi, double d_t) {
        return xi + (vi * d_t) + (0.5 * a * (d_t * d_t));
    }

    public double xi_3(double a, double xf, double vi, double d_t) {
        return (-((vi * d_t) + (0.5 * a * (d_t * d_t)) - xf));
    }

    public double d_t1_3(double a, double xi, double xf, double vi) {
        return (-vi + Math.sqrt((vi * vi) - 4 * ((a / 2) * (xf - xi)))) / a;
    }

    public double d_t2_3(double a, double xi, double xf, double vi) {
        return ((-vi - Math.sqrt((vi * vi) - 4 * ((a / 2) * (xf - xi)))) / a);
    }

    public double vi_3(double xi, double xf, double a, double d_t) {
        return ((0.5 * a * (d_t * d_t) - (xf - xi)) / -d_t);
    }

    public double a_3(double xi, double xf, double d_t, double vi) {
        return ((vi * d_t - (xf - xi)) / (d_t * d_t)) / (-0.5);
    }

    public double vf_4(double xi, double xf, double vi, double a) {
        return Math.sqrt((vi * vi) + 2 * a * (xf - xi));
    }

    public double vi_4(double xi, double xf, double vf, double a) {
        return Math.sqrt(-(2 * a * (xf - xi) - (vf * vf)));
    }

    public double a_4(double xi, double xf, double vi, double vf) {
        return (((vf * vf) - (vi * vi)) / 2 * (xf - xi));
    }

    public double xi_4(double vi, double vf, double a, double xf) {
        return -((((vf * vf) - (vi * vi)) / (2 * a)) - xf);
    }

    public double xf_4(double vi, double vf, double a, double xi) {
        return (((vf * vf) - (vi * vi)) / 2 * a) + xi;
    }

    public String outVf_1(double a, double vi, double d_t) {
        latexData = "v_{f} = " + vi + " + " + a + " " + d_t + "";
        result = (vi + a * d_t);
        return LATEX_VF_1 + "\\\\" + latexData + "\\\\v_{f} = " + result;
    }

    public String outVi_1(double a, double vf, double d_t) {
        latexData = "v_{i} = -(a " + d_t + " - " + vf + ")";
        result = (-(a * d_t - vf));
        return LATEX_VI_1 + "\\\\" + latexData + "\\\\v_{i} = " + result;
    }

    public String outA_1(double vi, double vf, double d_t) {
        latexData = "a = \\frac{ " + (vf - vi) + "}{ " + d_t + "}";
        result = ((vf - vi) / d_t);
        return LATEX_A_1 + "\\\\" + latexData + "\\\\a = " + result;
    }

    public String outD_t_1(double vi, double vf, double a) {
        latexData = " \\Delta t = \\frac{ " + (vf - vi) + "}{a}";

        result = ((vf - vi) / a);
        return LATEX_DT_1 + "\\\\" + latexData + "\\\\\\Delta t = " + result;
    }

    public String outXf_2(double xi, double vi, double vf, double d_t) {
        latexData = "x_{f} = " + xi + " + \\frac{1}{2} ( " + vi + " + " + vf + ") " + d_t + "";

        result = (xi + 0.5 * (vi + vf) * d_t);
        return LATEX_XF_2 + "\\\\" + latexData + "\\\\x_{f} = " + result;
    }

    public String outXi_2(double xf, double vi, double vf, double d_t) {
        latexData = "x_{i} = -(\\frac{1}{2}( " + vi + " + " + vf + ") \\cdot " + d_t + " - " + xf + ")";

        result = (-(0.5 * (vi + vf) * d_t - xf));
        return LATEX_XI_2 + "\\\\" + latexData + "\\\\x_{i} = " + result;
    }

    public String outVi_2(double xi, double xf, double vf, double d_t) {
        latexData = "v_{i} = 2( " + (xf - xi) + ")/( " + d_t + " - " + vf + ")";

        result = ((2 * (xf - xi)) / (d_t) - vf);
        return LATEX_VI_2 + "\\\\" + latexData + "\\\\v_{i} = " + result;
    }

    public String outVf_2(double xi, double xf, double vi, double d_t) {
        latexData = "v_{f} = 2( " + (xf - xi) + ")/( " + d_t + " - " + vi + ")";

        result = ((2 * (xf - xi)) / (d_t) - vi);
        return LATEX_VF_2 + "\\\\" + latexData + "\\\\v_{f} = " + result;
    }

    public String outD_t_2(double xi, double xf, double vi, double vf) {
        latexData = " \\Delta t = " + (xf - xi) + " / (\\frac{1}{2}( " + vi + " + " + vf + ")";

        result = ((xf - xi) / (0.5 * (vi + vf)));
        return LATEX_DT_2 + "\\\\" + latexData + "\\\\\\Delta t = " + result;
    }

    public String outXf_3(double a, double xi, double vi, double d_t) {
        latexData = "x_{f} = " + xi + " + ( " + vi + " *  " + d_t + ") + (\\frac{1}{2} " + a + "* ( " + d_t + "^{2}))";

        result = xi + (vi * d_t) + (0.5 * a * (d_t * d_t));
        return LATEX_XF_3 + "\\\\" + latexData + "\\\\x_{f} = " + result;

    }

    public String outXi_3(double a, double xf, double vi, double d_t) {
        latexData = "x_{i} = -\\left ( " + vi + " *  " + d_t + ") + (\\frac{1}{2}" + a + " * " + d_t + "^{2})) - " + xf + " \\right";

        result = (-((vi * d_t) + (0.5 * a * (d_t * d_t)) - xf));
        return LATEX_XI_3 + "\\\\" + latexData + "\\\\x_{i} = " + result;
    }

    public String outD_t1_3(double a, double xi, double xf, double vi) {
        latexData = " \\Delta t = \\frac{- " + vi + " \\pm \\sqrt{(( " + vi + "^{2}) - 4((" + a + "/ 2) * ( " + (xf - xi) + ")))}}{" + a + "}";

        result = (-vi + Math.sqrt((vi * vi) - 4 * ((a / 2) * (xf - xi)))) / a;
        return LATEX_DT_3 + "\\\\" + latexData + "\\\\\\Delta t = " + result;
    }

    public String outD_t2_3(double a, double xi, double xf, double vi) {
        latexData = " \\Delta t = \\frac{- " + vi + " \\pm \\sqrt{(( " + vi + "^{2}) - 4((" + a + "/ 2) * ( " + (xf - xi) + ")))}}{" + a + "}";;

        result = ((-vi - Math.sqrt((vi * vi) - 4 * ((a / 2) * (xf - xi)))) / a);
        return LATEX_DT_3 + "\\\\" + latexData + "\\\\\\Delta t = " + result;
    }

    public String outVi_3(double xi, double xf, double a, double d_t) {
        latexData = "v_{i} = \\frac{((\\frac{1}{2} " + a + " * (" + d_t + "^{2}) - ( " + (xf - xi) + "))}{- " + d_t + "}";

        result = ((0.5 * a * (d_t * d_t) - (xf - xi)) / -d_t);
        return LATEX_VI_3 + "\\\\" + latexData + "\\\\v_{i} = " + result;
    }

    public String outA_3(double xi, double xf, double d_t, double vi) {
        latexData = "a = \\frac{ " + vi + "" + d_t + " - " + (xf - xi) + "}{ " + d_t + "^{2}}\\;/\\;- \\frac{1}{2}";

        result = ((vi * d_t - (xf - xi)) / (d_t * d_t)) / (-0.5);
        return LATEX_A_3 + "\\\\" + latexData + "\\\\a = " + result;
    }

    public String outVf_4(double xi, double xf, double vi, double a) {
        latexData = "v_{f} = \\sqrt{(" + vi + "^{2}) + 2a " + (xf - xi) + "}";

        result = Math.sqrt((vi * vi) + 2 * a * (xf - xi));
        return LATEX_VF_4 + "\\\\" + latexData + "\\\\v_{f} = " + result;
    }

    public String outVi_4(double xi, double xf, double vf, double a) {
        latexData = "v_{i} = \\sqrt{-(" + 2 * a + "(" + (xf - xi) + ") - (" + vf + "^{2})}";

        result = Math.sqrt(-(2 * a * (xf - xi) - (vf * vf)));
        return LATEX_VI_4 + "\\\\" + latexData + "\\\\v_{i} = " + result;
    }

    public String outA_4(double xi, double xf, double vi, double vf) {
        latexData = "a = \\frac{(( " + vf + "^{2}) - ( " + vi + "^{2}))}{2}\\; " + (xf - xi) + ")";

        result = (((vf * vf) - (vi * vi)) / 2 * (xf - xi));
        return LATEX_A_4 + "\\\\" + latexData + "\\\\a = " + result;
    }

    public String outXi_4(double vi, double vf, double a, double xf) {
        latexData = "x_{i} = -\\left \\frac{( " + vf + "^{2} - " + vi + "^{2})}{2a} - " + xf + " \\right";

        result = -((((vf * vf) - (vi * vi)) / (2 * a)) - xf);
        return LATEX_XI_4 + "\\\\" + latexData + "\\\\x_{i} = " + result;
    }

    public String outXf_4(double vi, double vf, double a, double xi) {
        latexData = "x_{f} = \\frac{( " + vf + "^{2} - " + vi + "^{2})}{" + (2 * a) + "} + " + xi + "";
        result = (((vf * vf) - (vi * vi)) / 2 * a) + xi;
        return LATEX_XF_4 + "\\\\" + latexData + "\\\\x_{f} = " + result;

    }

}
