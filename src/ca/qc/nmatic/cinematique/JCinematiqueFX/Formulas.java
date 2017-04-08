package ca.qc.nmatic.cinematique.JCinematiqueFX;

import org.scilab.forge.jlatexmath.*;
/**
 *
 * @author Victor Babin
 */
public class Formulas {
    
    //TODO: Terminer les formules
    public final String DELTA = "\u0394";
    public final String HALF = "\u00BD";
    
    // Formules affichées
    public final String FORM_VF_1 = "Vf = Vi + a" + DELTA + "t";
    public final String FORM_VI_1 = "Vi = -(a" + DELTA + "t - Vf)";
    public final String FORM_A_1 = "a = (" + DELTA + "v )/" + DELTA + "t";
    public final String FORM_DT_1 = DELTA + "t = " + DELTA + "v/a";
    public final String FORM_XF_2 = "Xf = Xi + " + HALF + "(Vi + Vf) * " + DELTA + "t";
    public final String FORM_XI_2 = "Xi = -(" + HALF + "(Vi + Vf) * " + DELTA + "t - Xf)";
    public final String FORM_VI_2 = "Vi = 2(" + DELTA + "x)/(" + DELTA + "t - Vf)";
    public final String FORM_VF_2 = "Vf = 2(" + DELTA + "x)/(" + DELTA + "t - Vi)";
    public final String FORM_DT_2 = DELTA + "t = " + DELTA + "x / (" + HALF + "(Vi + Vf)";
    public final String FORM_XF_3 = "Xf = ";
    public final String FORM_XI_3 = "";
    public final String FORM_DT1_3 = "";
    public final String FORM_DT2_3 = "";
    public final String FORM_VI_3 = "";
    public final String FORM_A_3 = "";
    public final String FORM_VF_4 = "";
    public final String FORM_VI_4 = "";
    public final String FORM_A_4 = "";
    public final String FORM_XI_4 = "";
    public final String FORM_XF_4 = "";
    
    
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

}
