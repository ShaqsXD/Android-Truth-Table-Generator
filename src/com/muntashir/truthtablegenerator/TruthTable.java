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
	protected boolean varAVal = false;
	protected boolean varBVal = false;
	protected boolean varCVal = false;
	protected boolean varDVal = false;
	protected ArrayList<String> expression;
	protected Expressions expressions = new Expressions();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_truth_table);
		// Show the Up button in the action bar.
		setupActionBar();
		
		EditText editText = (EditText)findViewById(R.id.editText1);
		Intent intent = getIntent();

		expression  = intent.getStringArrayListExtra("expression");
		
    	for (String term : expression)
    	{
    		editText.append(term);
    	}
		
    	editText.append("\n");
    	
    	expression = expressions.parse(expression);
		expressions.getVarNum(expression);
    	
        editText.append("D|C|B|A\n");	
        
		for (int i = 0; i < Math.pow(2, expressions.numVar); i++)
		{
			if ((i + 1) % 2 == 0)
				varAVal = true;
			else
			{
				varAVal = false;
				if (i > 0)
					varBVal = !varBVal;
			}
			
			if ((i >= 4 && i <= 7) || (i >= 12 && i<= 15))
				varCVal = true;
			else
				varCVal = false;
			
			if (i >= 8 && i<= 15)
				varDVal = true;
			else
				varDVal = false;
			
			insertVal();	    		
			
	    	Evaluator evaluator = new Evaluator();
	    	
	    	boolean result = true;
	    	
			try {
				result = evaluator.getBooleanResult(evaluator.evaluate(boolExpression));
			} catch (EvaluationException e) {
				e.printStackTrace();
			}
	        
	        editText.append(expressions.boolToBin(varDVal) + "|" + expressions.boolToBin(varCVal) + "|" +
	        		expressions.boolToBin(varBVal) + "|" + expressions.boolToBin(varAVal) + 
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
	
	protected void insertVal() {
		
    	for (String term : expression)
    	{
    		if (term.equals("A") || term.equals("!!A"))
    			boolExpression += expressions.boolToBin(varAVal);
    		else if (term.equals("B") || term.equals("!!B"))
    			boolExpression += expressions.boolToBin(varBVal);
    		else if (term.equals("C") || term.equals("!!C"))
	    		boolExpression += expressions.boolToBin(varCVal);
    		else if (term.equals("D") || term.equals("!!D"))
    	    	boolExpression += expressions.boolToBin(varDVal);
    		else if (term.equals("!A"))
    			boolExpression += expressions.boolToBin(!varAVal);
    		else if (term.equals("!B"))
    			boolExpression += expressions.boolToBin(!varBVal);
    		else if (term.equals("!C"))
	    		boolExpression += expressions.boolToBin(!varCVal);
    		else if (term.equals("!D"))
    	    	boolExpression += expressions.boolToBin(!varDVal);
    		else
    			boolExpression += term;
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
