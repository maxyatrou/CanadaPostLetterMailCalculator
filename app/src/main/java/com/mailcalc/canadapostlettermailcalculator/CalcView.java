package com.mailcalc.canadapostlettermailcalculator;

/**
 * Created by Maxy on 2016-02-18.
 */
public interface CalcView {

    String getWeight();
    void showWeightError(int resId);

    String getLength();
    void showLengthError(int resId);

    String getWidth();
    void showWidthError(int resId);

    String getThickness();
    void showThicknessError(int resId);

    String getDestination();
    void showDestinationError(int resId);

    String getTypeOfItem();
    void showTypeOfItemError(int resId);

    String getWeightError();

}