package com.muntashir.truthtablegenerator;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	protected Buttons buttons;
	
	//Checks whether brackets are properly closed
	protected int emptyBracket = 0;
	//Checks if a variable has been already entered into expression
	protected boolean variableEntered = false;
	
	//Stores the entered expression
	ArrayList<String> expression = new ArrayList<String>();
	
	EditText editText;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        buttons = new Buttons(this);
        editText = (EditText)findViewById(R.id.textExpression);
        expression = new ArrayList<String>();
    }
    
    protected void onResume() {
    	super.onResume();
    	
        writeExpressionToText();
    }
    
    public void variablePress() {
    	buttons.enableOperators();
    	buttons.disableVariables();
    	buttons.enableEnter();
    	variableEntered = true;
    	buttons.disableLBracket();
    	
    	if (emptyBracket > 0)
    		buttons.enableRBracket();
    }
    
    public void operatorPress() {
    	buttons.enableLBracket();
    	buttons.disableOperators();
    	buttons.enableVariables();
    	buttons.disableEnter();
    	buttons.disableRBracket();
    }
    
    public void writeExpressionToText() {	
    	editText.setText("");
		
    	for (String term : expression)
    	{
    		editText.append(term);
    	}
    }
    
    public void buttonBksp(View view) {    	
    	//String term = expression.get(expression.size() - 1);  	
    	
    	buttons.enableOperators();
    	buttons.enableVariables();
    	buttons.enableLBracket();
    	buttons.enableRBracket();
    	
    	if(!expression.isEmpty())
    		expression.remove(expression.size() - 1);
    	
    	writeExpressionToText();
    }
    
    public void buttonA(View view) {    	
    	expression.add("A ");
    	
    	writeExpressionToText();
    	
    	variablePress();
    }
    
    public void buttonB(View view) {
    	expression.add("B ");
    	
    	writeExpressionToText();
    	
    	variablePress();
    }
    
    public void buttonC(View view) {
    	expression.add("C ");
    	
    	writeExpressionToText();
    	
    	variablePress();
    }
    
    public void buttonD(View view) {
    	expression.add("D ");
    	
    	writeExpressionToText();
    	
    	variablePress();
    }
    
    public void buttonANot(View view) {
    	expression.add("A' ");
    	
    	writeExpressionToText();
    	
    	variablePress();
    }
    
    public void buttonBNot(View view) {
    	expression.add("B' ");
    	
    	writeExpressionToText();
    	
    	variablePress();
    }
    
    public void buttonCNot(View view) {
    	expression.add("C' ");
    	
    	writeExpressionToText();
    	
    	variablePress();
    }
    
    public void buttonDNot(View view) {
    	expression.add("D' ");
    	
    	writeExpressionToText();
    	
    	variablePress();
    }
    
    public void buttonAnd(View view) {
    	expression.add("AND ");
    	
    	writeExpressionToText();

    	operatorPress();
    }
    
    public void buttonOr(View view) {
    	expression.add("OR ");
    	
    	writeExpressionToText();
    	
    	operatorPress();
    }
    
    public void buttonXor(View view) {
    	expression.add("XOR ");
    	
    	writeExpressionToText();
    	
    	operatorPress();
    }
    
    public void buttonNand(View view) {
    	expression.add("NAND ");
    	
    	writeExpressionToText();
    	
    	operatorPress();
    }
    
    public void buttonNor(View view) {
    	expression.add("NOR ");
    	
    	writeExpressionToText();
    	
    	operatorPress();
    }
    
    public void buttonXnor(View view) {
    	expression.add("XNOR ");
    	
    	writeExpressionToText();
    	
    	operatorPress();
    }
    
    public void buttonLBracket(View view) {
    	expression.add("(");
    	
    	writeExpressionToText();    	

    	emptyBracket++;
    	
    	buttons.disableLBracket();
    	buttons.disableEnter();
    }
    
    public void buttonRBracket(View view) {
    	expression.add(") ");
    	
    	writeExpressionToText();

    	if (buttons.variablesDisabled)
    	{
        	buttons.enableLBracket();
    	}
    	
    	emptyBracket--;
    	buttons.disableRBracket();

    	if (variableEntered = true)
    		buttons.enableEnter();
    }

    public void buttonEnter(View view) {	
    	Intent intent = new Intent(this, TruthTable.class);
    	
    	editText.setText("");
    	
    	intent.putExtra("expression", expression);
    	
    	startActivity(intent);    	
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
