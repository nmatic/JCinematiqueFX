package ca.qc.nmatic.cinematique.JCinematiqueFX;

/**
 *
 * @author Victor Babin
 */
public class Formulas {
        // Équations 1:
    public double vf_1(double a, double vi, double d_t) {
        return (vi + a * d_t);
    }

    public double vi_1(double a, double vf, double d_t) {
        return (-(a * d_t - vf));
    }

    public double a_1(double vi, double vf, double d_t) {
        double d_v = vf - vi;
        return (d_v / d_t);
    }

    public double d_t_1(double vi, double vf, double a) {
        double d_v = vf - vi;
        return (d_v / a);
    }

    // Équations 2:
    public double xf_2(double xi, double vi, double vf, double d_t) {
        return (xi + 0.5 * (vi + vf) * d_t);
        //R: xf C: xi, vi, vf, d_t
    }

    public double xi_2(double xf, double vi, double vf, double d_t) {
        return (-(0.5 * (vi + vf) * d_t - xf));
        //R: xi C: xf, vi, vf, d_t        
    }

    public double vi_2(double xi, double xf, double vf, double d_t) {
        double d_x = xf - xi;
        return ((2 * d_x) / (d_t) - vf);
        //R: vi C: xf, xi, d_t, vf        
    }

    public double vf_2(double xi, double xf, double vi, double d_t) {
        double d_x = xf - xi;
        return ((2 * d_x) / (d_t) - vi);
        //R: vf C: xf, xi, d_t, vi        
    }

    public double d_t_2(double xi, double xf, double vi, double vf) {
        double d_x = xf - xi;
        return (d_x / (0.5 * (vi + vf)));
    }

    // Équations 3:
    public double xf_3(double a, double xi, double vi, double d_t) {
        double ans = xi + (vi * d_t) + (0.5 * a * (d_t * d_t));
        return ans;
    }

    public double xi_3(double a, double xf, double vi, double d_t) {
        return (-((vi * d_t) + (0.5 * a * (d_t * d_t)) - xf));
    }

    public double d_t1_3(double a, double xi, double xf, double vi) {
        double d_x = xf - xi;
        double d = (vi * vi) - 4 * ((a / 2) * (d_x));
        double ans = (-vi + Math.sqrt(d)) / a;
        return ans;
    }

    public double d_t2_3(double a, double xi, double xf, double vi) {
        double d_x = xf - xi;
        double d = (vi * vi) - 4 * ((a / 2) * (d_x));
        return ((-vi - Math.sqrt(d)) / a);
    }

    public double vi_3(double xi, double xf, double a, double d_t) {
        double d_x = xf - xi;
        return ((0.5 * a * (d_t * d_t) - d_x) / -d_t);
    }

    public double a_3(double xi, double xf, double d_t, double vi) {
        double d_x = xf - xi;
        return ((vi * d_t - d_x) / (d_t * d_t)) / (-0.5);
    }

    // Équations 4:
    public double vf_4(double xi, double xf, double vi, double a) {
        double d_x = xf - xi;
        double anss = (vi * vi) + 2 * a * d_x;
        return Math.sqrt(anss);
    }

    public double vi_4(double xi, double xf, double vf, double a) {

        double d_x = xf - xi;
        double anss = -(2 * a * d_x - (vf * vf));
        return Math.sqrt(anss);
    }

    public double a_4(double xi, double xf, double vi, double vf) {
        double d_x = xf - xi;
        return (((vf * vf) - (vi * vi)) / 2 * d_x);
    }

    public double xi_4(double vi, double vf, double a, double xf) {
        return -((((vf * vf) - (vi * vi)) / (2 * a)) - xf);
    }

    public double xf_4(double vi, double vf, double a, double xi) {
        return (((vf * vf) - (vi * vi)) / 2 * a) + xi;
    }

}
