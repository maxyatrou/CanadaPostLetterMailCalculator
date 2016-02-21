package com.mailcalc.canadapostlettermailcalculator;

import com.mailcalc.canadapostlettermailcalculator.CalcPresenter;
import com.mailcalc.canadapostlettermailcalculator.CalcView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import java.lang.Exception;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.mailcalc.canadapostlettermailcalculator.R;
import static org.junit.Assert.*;

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
        when(view.getDestination()).thenReturn("");
        when(view.getLength()).thenReturn("");
        when(view.getThickness()).thenReturn("");
        when(view.getWeightError()).thenReturn("");
        when(view.getWidth()).thenReturn("");
        when(view.getTypeOfItem()).thenReturn("");
        presenter.attemptCalc(view.getWeight(), view.getLength(), view.getWidth(), view.getThickness(), view.getDestination(), view.getTypeOfItem());
        verify(view).showWeightError(R.string.weight_empty);
    }

    @Test
    public void errorWhenLengthEmpty () throws Exception{
        when(view.getWeight()).thenReturn("");
        when(view.getDestination()).thenReturn("");
        when(view.getLength()).thenReturn("");
        when(view.getThickness()).thenReturn("");
        when(view.getWidth()).thenReturn("");
        when(view.getTypeOfItem()).thenReturn("");
        presenter.attemptCalc(view.getWeight(), view.getLength(), view.getWidth(), view.getThickness(), view.getDestination(), view.getTypeOfItem());
        verify(view).showLengthError(R.string.length_empty);
    }

    @Test
    public void errorWhenThicknessEmpty () throws Exception{
        when(view.getWeight()).thenReturn("");
        when(view.getDestination()).thenReturn("");
        when(view.getLength()).thenReturn("");
        when(view.getThickness()).thenReturn("");
        when(view.getWidth()).thenReturn("");
        when(view.getTypeOfItem()).thenReturn("");
        presenter.attemptCalc(view.getWeight(), view.getLength(), view.getWidth(), view.getThickness(), view.getDestination(), view.getTypeOfItem());
        verify(view).showThicknessError(R.string.thickness_empty);
    }

    @Test
    public void errorWhenWidthEmpty () throws Exception{
        when(view.getWeight()).thenReturn("");
        when(view.getDestination()).thenReturn("");
        when(view.getLength()).thenReturn("");
        when(view.getThickness()).thenReturn("");
        when(view.getWidth()).thenReturn("");
        when(view.getTypeOfItem()).thenReturn("");
        presenter.attemptCalc(view.getWeight(), view.getLength(), view.getWidth(), view.getThickness(), view.getDestination(), view.getTypeOfItem());
        verify(view).showWidthError(R.string.width_empty);
    }

    @Test
    public void errorWhenDestinationEmpty () throws Exception{
        when(view.getWeight()).thenReturn("");
        when(view.getDestination()).thenReturn("");
        when(view.getLength()).thenReturn("");
        when(view.getThickness()).thenReturn("");
        when(view.getWidth()).thenReturn("");
        when(view.getTypeOfItem()).thenReturn("");
        presenter.attemptCalc(view.getWeight(), view.getLength(), view.getWidth(), view.getThickness(), view.getDestination(), view.getTypeOfItem());
        verify(view).showDestinationError(R.string.destination_empty);
    }



}