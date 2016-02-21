package com.mailcalc.canadapostlettermailcalculator;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(MockitoJUnitRunner.class)
public class CanadaPostLetterMailCalculatorUnitTests {
    @Mock
    private CalcView view;
    private CalcPresenter presenter;

    @Before
    public void setUp()throws Exception{
        presenter = new CalcPresenter(view);
    }

    @Test
    public void test01ErrorWhenWeightEmpty () throws Exception{
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
    public void test02ErrorWhenLengthEmpty () throws Exception{
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
    public void test03ErrorWhenThicknessEmpty () throws Exception{
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
    public void test04ErrorWhenWidthEmpty () throws Exception{
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
    public void test05ErrorWhenDestinationEmpty () throws Exception{
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
    public void test06ErrorWhenTypeEmpty () throws Exception{
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
    public void test07ErrorWhenWeightInvalid () throws Exception {
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
    public void test08ErrorWhenLengthInvalid () throws Exception {
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
    public void test09ErrorWhenThicknessInvalid() throws Exception {
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
    public void test10ErrorWhenWidthInvalid() throws Exception {
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
    public void test11ResultWhenCanadaStandardUpTo30gStamp() throws Exception {
        when(view.getWeight()).thenReturn("30");
        when(view.getDestination()).thenReturn("Canada");
        when(view.getLength()).thenReturn("140");
        when(view.getThickness()).thenReturn("2");
        when(view.getWidth()).thenReturn("100");
        when(view.getTypeOfItem()).thenReturn("Stamp(s)");
        presenter.attemptCalc(view.getWeight(), view.getLength(), view.getWidth(), view.getThickness(), view.getDestination(), view.getTypeOfItem());
        verify(view).setResult("$0.85");
    }

}