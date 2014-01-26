package com.muntashir.truthtablegenerator;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	int emptyBracket = 0;
	boolean variableEntered = false;
	ArrayList<String> expression = new ArrayList<String>();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void variablePress()
    {
    	Buttons buttons = new Buttons(this);
    	buttons.enableOperators();
    	buttons.disableVariables();
    	buttons.enableEnter();
    	variableEntered = true;
    	buttons.disableLBracket();
    	
    	if (emptyBracket > 0)
    	{
    		buttons.enableRBracket();
    	}
    }
    
    public void operatorPress()
    {
    	Buttons buttons = new Buttons(this);

    	buttons.enableLBracket();
    	buttons.disableOperators();
    	buttons.enableVariables();
    	buttons.disableEnter();
    	buttons.disableRBracket();
    }
    
    public void writeExpressionToText()
    {
    	EditText editText = (EditText)findViewById(R.id.textExpression);
    	
    	editText.setText("");
		
    	for (String term : expression)
    	{
    		editText.append(term);
    	}
    }
    
    public void buttonBksp(View view)
    {    	
    	Buttons buttons = new Buttons(this);
    	//String term = expression.get(expression.size() - 1);  	
    	
    	buttons.enableOperators();
    	buttons.enableVariables();
    	buttons.enableLBracket();
    	buttons.enableRBracket();
    	
    	if(!expression.isEmpty())
    	{
    		expression.remove(expression.size() - 1);
    	}
    	
    	writeExpressionToText();
    }
    
    public void buttonA(View view)
    {    	
    	expression.add("A ");
    	
    	writeExpressionToText();
    	
    	variablePress();
    }
    
    public void buttonB(View view)
    {
    	expression.add("B ");
    	
    	writeExpressionToText();
    	
    	variablePress();
    }
    
    public void buttonC(View view)
    {
    	expression.add("C ");
    	
    	writeExpressionToText();
    	
    	variablePress();
    }
    
    public void buttonD(View view)
    {
    	expression.add("D ");
    	
    	writeExpressionToText();
    	
    	variablePress();
    }
    
    public void buttonANot(View view)
    {
    	expression.add("A' ");
    	
    	writeExpressionToText();
    	
    	variablePress();
    }
    
    public void buttonBNot(View view)
    {
    	expression.add("B' ");
    	
    	writeExpressionToText();
    	
    	variablePress();
    }
    
    public void buttonCNot(View view)
    {
    	expression.add("C' ");
    	
    	writeExpressionToText();
    	
    	variablePress();
    }
    
    public void buttonDNot(View view)
    {
    	expression.add("D' ");
    	
    	writeExpressionToText();
    	
    	variablePress();
    }
    
    public void buttonAnd(View view)
    {
    	expression.add("AND ");
    	
    	writeExpressionToText();

    	operatorPress();
    }
    
    public void buttonOr(View view)
    {
    	expression.add("OR ");
    	
    	writeExpressionToText();
    	
    	operatorPress();
    }
    
    public void buttonXor(View view)
    {
    	expression.add("XOR ");
    	
    	writeExpressionToText();
    	
    	operatorPress();
    }
    
    public void buttonNand(View view)
    {
    	expression.add("NAND ");
    	
    	writeExpressionToText();
    	
    	operatorPress();
    }
    
    public void buttonNor(View view)
    {
    	expression.add("NOR ");
    	
    	writeExpressionToText();
    	
    	operatorPress();
    }
    
    public void buttonXnor(View view)
    {
    	expression.add("XNOR ");
    	
    	writeExpressionToText();
    	
    	operatorPress();
    }
    
    public void buttonLBracket(View view)
    {
    	expression.add("(");
    	
    	writeExpressionToText();    	
    	
    	Buttons buttons = new Buttons(this);
    	
    	emptyBracket++;
    	
    	buttons.disableLBracket();
    	buttons.disableEnter();
    }
    
    public void buttonRBracket(View view)
    {
    	expression.add(") ");
    	
    	writeExpressionToText();
    	
    	Buttons buttons = new Buttons(this);
    	
    	if (buttons.variablesDisabled)
    	{
        	buttons.enableLBracket();
    	}
    	
    	emptyBracket--;
    	buttons.disableRBracket();

    	if (variableEntered = true)
    		buttons.enableEnter();
    }

    public void buttonEnter(View view)
    {	
    	Intent intent = new Intent(this, TruthTable.class);
    	EditText editText = (EditText)findViewById(R.id.textExpression);
    	
    	editText.setText("");
		
    	ArrayList<String> temp = new ArrayList<String>(); 
    	
    	temp = parse(expression);
    	
    	intent.putExtra("expression", temp);
    	
    	startActivity(intent);
    	
    	for (String term : temp)
    	{
    		editText.append(term);
    	}
    }
   
    public ArrayList<String> parse(ArrayList<String> input)
    {
    	for (int i = 0; i < input.size(); i++)
    	{
    		if (input.get(i) == "AND ")
    		{
    			input.set(i, "&&");
    		}
    		else if (input.get(i) == "OR ")
    		{
    			input.set(i, "||");
    		}
    		else if (input.get(i) == "XOR ")
    		{
    			input.set(i, "!=");
    		}
    		else if (input.get(i) == "NAND ")
    		{
    			input.set(i, "||");
    			input.set(i + 1, "!" + input.get(i + 1));
    			input.set(i - 1, "!" + input.get(i - 1));
    		}
    		else if (input.get(i) == "NOR ")
    		{
    			input.set(i, "&&");
    			input.set(i + 1, "!" + input.get(i + 1));
    			input.set(i - 1, "!" + input.get(i - 1));
    		}
    		else if (input.get(i) == "XNOR ")
    		{
    			input.set(i, "==");
    		}
    		else if (input.get(i) == "A ")
    		{
    			input.set(i, "A");
    		}
    		else if (input.get(i) == "B ")
    		{
    			input.set(i, "B");
    		}
    		else if (input.get(i) == "C ")
    		{
    			input.set(i, "C");
    		}
    		else if (input.get(i) == "D ")
    		{
    			input.set(i, "D");
    		}
    		else if (input.get(i) == "A' ")
    		{
    			input.set(i, "!A");
    		}
    		else if (input.get(i) == "B' ")
    		{
    			input.set(i, "!B");
    		}
    		else if (input.get(i) == "C' ")
    		{
    			input.set(i, "!C");
    		}
    		else if (input.get(i) == "D' ")
    		{
    			input.set(i, "!D");
    		}
    		else if (input.get(i) == ") ")
    		{
    			input.set(i, ")");
    		}
    	}
    	
		return input;
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
