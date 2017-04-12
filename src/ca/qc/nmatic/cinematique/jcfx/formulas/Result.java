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
public class Result {

    protected static final String NEWLINE = "\\\\";

    protected double result;
    protected String regularFormula;
    protected String latexFormula;
    protected String latexData;
    protected String type;
    protected String unit;

    protected String regularError = "No errors occured.";
    protected String latexError = "No errors occured.";

    public Result(double result, String regularFormula, String latexFormula, String latexData, String type, String unit) {
        this.result = result;
        this.regularFormula = regularFormula;
        this.latexFormula = latexFormula;
        this.latexData = latexData;
        this.type = type;
        this.unit = unit;
    }

    public Result() {
    }

    public String toLatex(boolean noError) {
        if (noError) {
            return latexFormula + NEWLINE + type + latexData + NEWLINE + type + result + unit;
        } else {
            return latexError;
        }
    }

    public String toRegular(boolean noError) {
        if (noError) {
            return regularFormula + "\n" + "    = " + result;
        } else {
            return regularError;
        }
    }

    public void setRegularError(String regularError) {
        this.regularError = regularError;
    }

    public void setLatexError(String latexError) {
        this.latexError = latexError;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getRegularFormula() {
        return regularFormula;
    }

    public void setRegularFormula(String regularFormula) {
        this.regularFormula = regularFormula;
    }

    public String getLatexFormula() {
        return latexFormula;
    }

    public void setLatexFormula(String latexFormula) {
        this.latexFormula = latexFormula;
    }

    public String getLatexData() {
        return latexData;
    }

    public void setLatexData(String latexData) {
        this.latexData = latexData;
    }

    @Override
    public String toString() {
        return "Result{" + "result=" + result + ", regularFormula=" + regularFormula + ", latexFormula=" + latexFormula + ", latexData=" + latexData + '}';
    }

}
