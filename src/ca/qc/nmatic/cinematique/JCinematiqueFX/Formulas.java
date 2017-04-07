package ca.qc.nmatic.cinematique.JCinematiqueFX;

/**
 *
 * @author Victor Babin
 */
public class Formulas {

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
