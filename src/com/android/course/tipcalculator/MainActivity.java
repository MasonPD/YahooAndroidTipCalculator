package com.android.course.tipcalculator;
/*
 * author: Linkai Xi
 */

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private EditText billInput;
	private TextView tipResult;
	private double bill = 0;
	private double tip = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	    billInput = (EditText) findViewById(R.id.text_bill);
	    tipResult = (TextView) findViewById(R.id.text_tip);
	

		Button tip10 = (Button) findViewById(R.id.button_tip10);
		tip10.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				bill = getBill();
				tip = RoundTo2Decimals(bill * 0.1);
				String tipString = getString(R.string.tip_result) + Double.valueOf(tip);
				tipResult.setText(tipString);
			}
		});

		Button tip15 = (Button) findViewById(R.id.button_tip15);
		tip15.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				bill = getBill();
				tip = RoundTo2Decimals(bill * 0.15);
				String tipString = getString(R.string.tip_result) + Double.valueOf(tip);
				tipResult.setText(tipString);
			}
		});

		Button tip20 = (Button) findViewById(R.id.button_tip20);
		tip20.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				bill = getBill();
				tip = RoundTo2Decimals(bill * 0.2);
				String tipString = getString(R.string.tip_result) + Double.valueOf(tip);
				tipResult.setText(tipString);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private double RoundTo2Decimals(double val) {
		DecimalFormat df2 = new DecimalFormat("###.##");
		return Double.valueOf(df2.format(val));
	}
	
	private double getBill(){
		String billString = billInput.getText().toString();
		double result = 0;
		if (billString != null) {
			try {
				result = Double.parseDouble(billString);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
