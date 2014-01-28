package com.muntashir.truthtablegenerator;

import java.util.ArrayList;

import com.muntashir.truthtablegenerator.jeval.EvaluationException;
import com.muntashir.truthtablegenerator.jeval.Evaluator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class TruthTable extends Activity {

	protected String boolExpression = "";
	protected boolean firstVarVal = false;
	protected boolean secondVarVal = false;
	protected boolean thirdVarVal = false;
	protected boolean fourthVarVal = false;
	protected ArrayList<String> expression;
	protected Expressions expressions = new Expressions();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_truth_table);
		// Show the Up button in the action bar.
		setupActionBar();
		
		Intent intent = getIntent();

		expression = intent.getStringArrayListExtra("expression");
		
		expressions.getVar(expression);
		
		EditText editText = (EditText)findViewById(R.id.editText1);
		
        editText.append(expressions.fourthVar + "|" + expressions.thirdVar + "|" +
        		expressions.secondVar + "|" + expressions.firstVar + "\n");	
        
		for (int i = 0; i < Math.pow(2, expressions.numVar); i++)
		{
			if ((i + 1) % 2 == 0)
				firstVarVal = true;
			else
			{
				firstVarVal = false;
				if (i > 0)
					secondVarVal = !secondVarVal;
			}
			
			if ((i >= 4 && i <= 7) || (i >= 12 && i<= 15))
				thirdVarVal = true;
			else
				thirdVarVal = false;
			
			if (i >= 8 && i<= 15)
				fourthVarVal = true;
			else
				fourthVarVal = false;
			
			insertVal();	    	
			
			//editText.append(boolExpression + "\n");		
			
	    	Evaluator evaluator = new Evaluator();
	    	
	    	boolean result = true;
	    	
			try {
				result = evaluator.getBooleanResult(evaluator.evaluate(boolExpression));
			} catch (EvaluationException e) {
				e.printStackTrace();
			}
	        
	        editText.append(expressions.boolToBin(fourthVarVal) + "|" + expressions.boolToBin(thirdVarVal) + "|" +
	        		expressions.boolToBin(secondVarVal) + "|" + expressions.boolToBin(firstVarVal) + 
	        		" => " + expressions.boolToBin(result) + "\n");	
	        
	        boolExpression = "";
		}	
	}
	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}
	
	protected void insertVal()
	{
    	for (String term : expression)
    	{
    		if (term.equals(expressions.firstVar) || term.equals("!" + expressions.firstVar + "' ") || term.equals("!!" + expressions.firstVar))
    		{
    			boolExpression += expressions.boolToBin(firstVarVal);
    		}
    		else if (term.equals(expressions.secondVar) || term.equals("!" + expressions.secondVar + "' ") || term.equals("!!" + expressions.secondVar))
    		{
    			boolExpression += expressions.boolToBin(secondVarVal);
    		}
    		else if (term.equals(expressions.thirdVar) || term.equals("!" + expressions.thirdVar + "' ") || term.equals("!!" + expressions.thirdVar))
    		{
	    		boolExpression += expressions.boolToBin(thirdVarVal);
	    	}
    		else if (term.equals(expressions.fourthVar) || term.equals("!" + expressions.fourthVar + "' ") || term.equals("!!" + expressions.fourthVar))
    	    {
    	    	boolExpression += expressions.boolToBin(fourthVarVal);
    	    }
    		else if (term.equals("!" + expressions.firstVar))
    		{
    			boolExpression += expressions.boolToBin(!firstVarVal);
    		}
    		else if (term.equals("!" + expressions.secondVar))
    		{
    			boolExpression += expressions.boolToBin(!secondVarVal);
    		}
    		else if (term.equals("!" + expressions.thirdVar))
    		{
	    		boolExpression += expressions.boolToBin(!thirdVarVal);
	    	}
    		else if (term.equals("!" + expressions.fourthVar))
    	    {
    	    	boolExpression += expressions.boolToBin(!fourthVarVal);
    	    }
    		else
    		{
    		boolExpression += term;
    		}
    	}
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
