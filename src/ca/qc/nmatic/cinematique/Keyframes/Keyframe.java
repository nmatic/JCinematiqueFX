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
package ca.qc.nmatic.cinematique.Keyframes;

import ca.qc.nmatic.cinematique.*;
import ca.qc.nmatic.cinematique.JCinematiqueFX.Kinetics;
import java.util.ArrayList;
import javafx.scene.chart.XYChart;

/**
 *
 * @author Victor Babin
 */
public class Keyframe {

    private int time;
    private double interval, value;
    private ArrayList<Double> chartData;

    public Keyframe(int time, double interval, double value) {
        this.chartData = new ArrayList<Double>();
        this.time = time;
        this.interval = interval;
        this.value = value;
    }

    public double getCoords(int time) {
        chartData.add(time, value);
        return chartData.get(time);
    }

    public double getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getInterval() {
        return interval;
    }

    public void setInterval(double interval) {
        this.interval = interval;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public ArrayList<Double> getChartData() {
        return chartData;
    }

    public void setChartData(ArrayList<Double> chartData) {
        this.chartData = chartData;
    }

    public double posValue(int time, Kinetics obj) {
        if (time == 0) {
            obj.setDesiredValue("Initial Position");
            obj.findValue();
            return obj.getInitialPos();
        } else {
            obj.setDesiredValue("Final Position");
            obj.setElapsedTime(time);
            obj.setInitialPos(time - 1);
            obj.findValue();
            return obj.getFinalPos();
        }
    }

}
