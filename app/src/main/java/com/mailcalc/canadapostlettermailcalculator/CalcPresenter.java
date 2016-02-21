package com.mailcalc.canadapostlettermailcalculator;

/**
 * Created by Maxy on 2016-02-18.
 */
public class CalcPresenter {
    private CalcView view;
    private CalcService service;

    public CalcPresenter(CalcView view) {
        this.view = view;
        this.service = new CalcService();
    }

    public void attemptCalc(String weight, String length, String width, String thickness, String destination, String typeOfItem) {
        boolean dontCalc = false;



        if(weight.isEmpty()) {
            view.showWeightError(R.string.weight_empty);
            dontCalc = true;
        }
        else {
            int weightValue = Integer.parseInt(weight);
            if (weightValue < 2 || weightValue > 500) {
                view.showWeightError(R.string.weight_outofbounds);
                dontCalc = true;
            }
        }

        if(length.isEmpty()) {
            view.showLengthError(R.string.length_empty);
            dontCalc = true;
        }
        else{
            int lengthValue = Integer.parseInt(length);
            if(lengthValue < 140 || lengthValue > 380) {
                view.showLengthError(R.string.length_outofbounds);
                dontCalc = true;
            }
        }

        if(width.isEmpty()) {
            view.showWidthError(R.string.width_empty);
            dontCalc = true;
        }
        else{
            int widthValue = Integer.parseInt(width);
            if(widthValue < 90 || widthValue > 270) {
                view.showWidthError(R.string.width_outofbounds);
                dontCalc = true;
            }

        }

        if(thickness.isEmpty()) {
            view.showThicknessError(R.string.thickness_empty);
            dontCalc = true;
        }
        else{
            double thicknessValue = Double.parseDouble(thickness);
            if(thicknessValue < 0.18 || thicknessValue > 20) {
                view.showThicknessError(R.string.thickness_outofbounds);
                dontCalc = true;
            }
        }

        if(destination.equals("Destination")) {
            view.showDestinationError(R.string.destination_empty);
            dontCalc = true;
        }

        if(typeOfItem.equals("Type of item")) {
            view.showTypeOfItemError(R.string.typeofitem_empty);
            dontCalc = true;
        }

        if(dontCalc) {
            return;
        }
        else {
            int weightValue = Integer.parseInt(weight);
            int lengthValue = Integer.parseInt(length);
            int widthValue = Integer.parseInt(width);
            double thicknessValue = Double.parseDouble(thickness);

            double calcRate = service.calc(weightValue, lengthValue, widthValue, thicknessValue, destination, typeOfItem);
            String result = String.valueOf(calcRate);

            view.setResult(result);
        }
    }
}
