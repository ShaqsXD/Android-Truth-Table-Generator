package com.muntashir.truthtablegenerator;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class TruthTable extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_truth_table);
		// Show the Up button in the action bar.
		setupActionBar();
		
		Intent intent = getIntent();
		Expressions expressions = new Expressions();
		ArrayList<String> expression = intent.getStringArrayListExtra("expression");
		
		expressions.getVar(expression);
		
		EditText editText = (EditText)findViewById(R.id.editText1);
		
		boolean firstVarVal = false;
		boolean secondVarVal = false;
		boolean thirdVarVal = false;
		boolean fourthVarVal = false;
		
		for (int i = 0; i < Math.pow(2, expressions.numVar); i++)
		{
			if ((i + 1) % 2 == 0)
			{
				firstVarVal = true;
			}
			else
			{
				firstVarVal = false;
				if (i > 0)
				{
					secondVarVal = !secondVarVal;
				}
			}
			//editText.append(firstVarVal + " " + secondVarVal + "\n");	
		}
		
		
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.truth_table, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
