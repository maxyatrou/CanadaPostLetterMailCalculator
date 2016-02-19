package com.mailcalc.canadapostlettermailcalculator;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class CalcActivity extends AppCompatActivity implements CalcView {

    private CalcPresenter presenter;

    private EditText weightTextView;
    private EditText lengthTextView;
    private EditText widthTextView;
    private EditText thicknessTextView;
    private Spinner destinationSpinner;
    private Spinner typeOfItemSpinner;
    private Button calculateRateButton;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }); */

        addItemsToSpinners();

        initializeInputs();

        calculateRateButton = (Button) findViewById(R.id.calcButton);

        calculateRateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.attemptCalc(getWeight(),getLength(),getWidth(),getThickness(),getDestination(),getTypeOfItem());
            }
        });

        result = (TextView) findViewById(R.id.result);

        presenter = new CalcPresenter(this);

    }


    public void initializeInputs() {

        weightTextView = (EditText) findViewById(R.id.weightField);

        lengthTextView = (EditText) findViewById(R.id.lengthField);

        widthTextView = (EditText) findViewById(R.id.widthField);

        thicknessTextView = (EditText) findViewById(R.id.thicknessField);

    }

    public void addItemsToSpinners() {

        destinationSpinner = (Spinner) findViewById(R.id.destinationSpinner);
        typeOfItemSpinner = (Spinner) findViewById(R.id.typeOfItemSpinner);

        ArrayAdapter<CharSequence> destinationSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.destination_types, R.layout.spinner_layout);
        ArrayAdapter<CharSequence> typeOfItem = ArrayAdapter.createFromResource(this, R.array.typeofitem_types, R.layout.spinner_layout);

        destinationSpinnerAdapter.setDropDownViewResource(R.layout.spinner_layout);
        typeOfItem.setDropDownViewResource(R.layout.spinner_layout);

        destinationSpinner.setAdapter(destinationSpinnerAdapter);
        typeOfItemSpinner.setAdapter(typeOfItem);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calc, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public String getWeight() {
        return weightTextView.getText().toString();
    }

    @Override
    public void showWeightError(int resId) {
        weightTextView.setError(getString(resId));
    }

    @Override
    public String getLength() {
        return lengthTextView.getText().toString();
    }

    @Override
    public void showLengthError(int resId) {
        lengthTextView.setError(getString(resId));
    }

    @Override
    public String getWidth() {
        return widthTextView.getText().toString();
    }

    @Override
    public void showWidthError(int resId) {
        widthTextView.setError(getString(resId));
    }

    @Override
    public String getThickness() {
        return thicknessTextView.getText().toString();
    }

    @Override
    public void showThicknessError(int resId) {
        thicknessTextView.setError(getString(resId));
    }

    @Override
    public String getDestination() {
        return destinationSpinner.getSelectedItem().toString();
    }

    @Override
    public void showDestinationError(int resId) {
        TextView errorText = (TextView) destinationSpinner.getSelectedView();
        errorText.setError("");
        errorText.setTextColor(Color.RED);
        errorText.setText(getString(resId));
    }

    @Override
    public String getTypeOfItem() {
        return typeOfItemSpinner.getSelectedItem().toString();
    }

    @Override
    public void showTypeOfItemError(int resId) {
        TextView errorText = (TextView) typeOfItemSpinner.getSelectedView();
        errorText.setError("");
        errorText.setTextColor(Color.RED);
        errorText.setText(getString(resId));
    }
}
