package com.mailcalc.canadapostlettermailcalculator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */


@RunWith(MockitoJUnitRunner.class)
public class ExampleUnitTest {
    @Mock
    private CalcView view;
    private CalcPresenter presenter;

    @Before
    public void setUp()throws Exception{
        presenter = new CalcPresenter(view);
    }

    @Test
    public void errorWhenWeightEmpty () throws Exception{
        when(view.getWeight()).thenReturn("");
        when(view.getDestination()).thenReturn("Destination");
        when(view.getLength()).thenReturn("");
        when(view.getThickness()).thenReturn("");
        when(view.getWidth()).thenReturn("");
        when(view.getTypeOfItem()).thenReturn("Type of item");
        presenter.attemptCalc(view.getWeight(), view.getLength(), view.getWidth(), view.getThickness(), view.getDestination(), view.getTypeOfItem());
        verify(view).showWeightError(R.string.weight_empty);
    }

    @Test
    public void errorWhenLengthEmpty () throws Exception{
        when(view.getWeight()).thenReturn("");
        when(view.getDestination()).thenReturn("Destination");
        when(view.getLength()).thenReturn("");
        when(view.getThickness()).thenReturn("");
        when(view.getWidth()).thenReturn("");
        when(view.getTypeOfItem()).thenReturn("Type of item");
        presenter.attemptCalc(view.getWeight(), view.getLength(), view.getWidth(), view.getThickness(), view.getDestination(), view.getTypeOfItem());
        verify(view).showLengthError(R.string.length_empty);
    }

    @Test
    public void errorWhenThicknessEmpty () throws Exception{
        when(view.getWeight()).thenReturn("");
        when(view.getDestination()).thenReturn("Destination");
        when(view.getLength()).thenReturn("");
        when(view.getThickness()).thenReturn("");
        when(view.getWidth()).thenReturn("");
        when(view.getTypeOfItem()).thenReturn("Type of item");
        presenter.attemptCalc(view.getWeight(), view.getLength(), view.getWidth(), view.getThickness(), view.getDestination(), view.getTypeOfItem());
        verify(view).showThicknessError(R.string.thickness_empty);
    }

    @Test
    public void errorWhenWidthEmpty () throws Exception{
        when(view.getWeight()).thenReturn("");
        when(view.getDestination()).thenReturn("Destination");
        when(view.getLength()).thenReturn("");
        when(view.getThickness()).thenReturn("");
        when(view.getWidth()).thenReturn("");
        when(view.getTypeOfItem()).thenReturn("Type of item");
        presenter.attemptCalc(view.getWeight(), view.getLength(), view.getWidth(), view.getThickness(), view.getDestination(), view.getTypeOfItem());
        verify(view).showWidthError(R.string.width_empty);
    }

    @Test
    public void errorWhenDestinationEmpty () throws Exception{
        when(view.getWeight()).thenReturn("");
        when(view.getDestination()).thenReturn("Destination");
        when(view.getLength()).thenReturn("");
        when(view.getThickness()).thenReturn("");
        when(view.getWidth()).thenReturn("");
        when(view.getTypeOfItem()).thenReturn("Type of item");
        presenter.attemptCalc(view.getWeight(), view.getLength(), view.getWidth(), view.getThickness(), view.getDestination(), view.getTypeOfItem());
        verify(view).showDestinationError(R.string.destination_empty);
    }

    @Test
    public void errorWhenTypeEmpty () throws Exception{
        when(view.getWeight()).thenReturn("");
        when(view.getDestination()).thenReturn("Destination");
        when(view.getLength()).thenReturn("");
        when(view.getThickness()).thenReturn("");
        when(view.getWidth()).thenReturn("");
        when(view.getTypeOfItem()).thenReturn("Type of item");
        presenter.attemptCalc(view.getWeight(), view.getLength(), view.getWidth(), view.getThickness(), view.getDestination(), view.getTypeOfItem());
        verify(view).showTypeOfItemError(R.string.typeofitem_empty);
    }

    @Test
    public void errorWhenWeightInvalid () throws Exception {
        when(view.getWeight()).thenReturn("0");
        when(view.getDestination()).thenReturn("Canada");
        when(view.getLength()).thenReturn("140");
        when(view.getThickness()).thenReturn("2");
        when(view.getWidth()).thenReturn("90");
        when(view.getTypeOfItem()).thenReturn("Stamp(s)");
        presenter.attemptCalc(view.getWeight(), view.getLength(), view.getWidth(), view.getThickness(), view.getDestination(), view.getTypeOfItem());
        verify(view).showWeightError(R.string.weight_outofbounds);
    }

    @Test
    public void errorWhenLengthInvalid () throws Exception {
        when(view.getWeight()).thenReturn("5");
        when(view.getDestination()).thenReturn("Canada");
        when(view.getLength()).thenReturn("10");
        when(view.getThickness()).thenReturn("2");
        when(view.getWidth()).thenReturn("90");
        when(view.getTypeOfItem()).thenReturn("Stamp(s)");
        presenter.attemptCalc(view.getWeight(), view.getLength(), view.getWidth(), view.getThickness(), view.getDestination(), view.getTypeOfItem());
        verify(view).showLengthError(R.string.length_outofbounds);
    }

    @Test
    public void errorWhenThicknessInvalid() throws Exception {
        when(view.getWeight()).thenReturn("5");
        when(view.getDestination()).thenReturn("Canada");
        when(view.getLength()).thenReturn("140");
        when(view.getThickness()).thenReturn("0.01");
        when(view.getWidth()).thenReturn("90");
        when(view.getTypeOfItem()).thenReturn("Stamp(s)");
        presenter.attemptCalc(view.getWeight(), view.getLength(), view.getWidth(), view.getThickness(), view.getDestination(), view.getTypeOfItem());
        verify(view).showThicknessError(R.string.thickness_outofbounds);
    }

    @Test
    public void errorWhenWidthInvalid() throws Exception {
        when(view.getWeight()).thenReturn("5");
        when(view.getDestination()).thenReturn("Canada");
        when(view.getLength()).thenReturn("140");
        when(view.getThickness()).thenReturn("2");
        when(view.getWidth()).thenReturn("80");
        when(view.getTypeOfItem()).thenReturn("Stamp(s)");
        presenter.attemptCalc(view.getWeight(), view.getLength(), view.getWidth(), view.getThickness(), view.getDestination(), view.getTypeOfItem());
        verify(view).showWidthError(R.string.width_outofbounds);
    }


    @Test
    public void resultCanadaStandardUpTo30gStamp() throws Exception {
        when(view.getWeight()).thenReturn("30");
        when(view.getDestination()).thenReturn("Canada");
        when(view.getLength()).thenReturn("140");
        when(view.getThickness()).thenReturn("2");
        when(view.getWidth()).thenReturn("100");
        when(view.getTypeOfItem()).thenReturn("Stamp(s)");
        presenter.attemptCalc(view.getWeight(), view.getLength(), view.getWidth(), view.getThickness(), view.getDestination(), view.getTypeOfItem());
        verify(view).setResult("0.85");
    }

}