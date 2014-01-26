package com.muntashir.truthtablegenerator;

import android.app.Activity;
import android.graphics.Color;
import android.widget.Button;

public class Buttons {
	
	public boolean variablesDisabled = false;
	Activity activity = new Activity();
	
	public Buttons(Activity activity)
	{
		this.activity = activity;
	}
	
	protected void enableButton(Button button)
	{
		button.setClickable(true);
		button.setTextColor(Color.WHITE);
	}
	
	protected void disableButton(Button button)
	{
		button.setClickable(false);
		button.setTextColor(Color.parseColor("#696969"));
	}
	
	public void enableOperators()
	    {
	    	Button AND = (Button)this.activity.findViewById(R.id.buttonAnd);
	    	Button OR = (Button)this.activity.findViewById(R.id.buttonOr);
	    	Button XOR = (Button)this.activity.findViewById(R.id.buttonXor);
	    	Button NAND = (Button)this.activity.findViewById(R.id.buttonNand);
	    	Button NOR = (Button)this.activity.findViewById(R.id.buttonNor);
	    	Button XNOR = (Button)this.activity.findViewById(R.id.buttonXnor);

	    	enableButton(AND);
	    	enableButton(OR);
	    	enableButton(XOR);
	    	enableButton(NAND);
	    	enableButton(NOR);
	    	enableButton(XNOR);
	    }
	    
	    public void disableOperators()
	    {
	    	Button AND = (Button)this.activity.findViewById(R.id.buttonAnd);
	    	Button OR = (Button)this.activity.findViewById(R.id.buttonOr);
	    	Button XOR = (Button)this.activity.findViewById(R.id.buttonXor);
	    	Button NAND = (Button)this.activity.findViewById(R.id.buttonNand);
	    	Button NOR = (Button)this.activity.findViewById(R.id.buttonNor);
	    	Button XNOR = (Button)this.activity.findViewById(R.id.buttonXnor);
	    	
	    	disableButton(AND);
	    	disableButton(OR);
	    	disableButton(XOR);
	    	disableButton(NAND);
	    	disableButton(NOR);
	    	disableButton(XNOR);
	    }
	    
	    public void disableVariables()
	    {
	    	Button A = (Button)this.activity.findViewById(R.id.buttonA);
	    	Button B = (Button)this.activity.findViewById(R.id.buttonB);
	    	Button C = (Button)this.activity.findViewById(R.id.buttonC);
	    	Button D = (Button)this.activity.findViewById(R.id.buttonD);
	    	Button ANot = (Button)this.activity.findViewById(R.id.buttonANot);
	    	Button BNot = (Button)this.activity.findViewById(R.id.buttonBNot);
	    	Button CNot = (Button)this.activity.findViewById(R.id.buttonCNot);
	    	Button DNot = (Button)this.activity.findViewById(R.id.buttonDNot);
	    	
	    	disableButton(A);
	    	disableButton(B);
	    	disableButton(C);
	    	disableButton(D);
	    	disableButton(ANot);
	    	disableButton(BNot);
	    	disableButton(CNot);
	    	disableButton(DNot);
	    	
	    	variablesDisabled = true;
	    }
	    
	    public void enableVariables()
	    {
	    	Button A = (Button)this.activity.findViewById(R.id.buttonA);
	    	Button B = (Button)this.activity.findViewById(R.id.buttonB);
	    	Button C = (Button)this.activity.findViewById(R.id.buttonC);
	    	Button D = (Button)this.activity.findViewById(R.id.buttonD);
	    	Button ANot = (Button)this.activity.findViewById(R.id.buttonANot);
	    	Button BNot = (Button)this.activity.findViewById(R.id.buttonBNot);
	    	Button CNot = (Button)this.activity.findViewById(R.id.buttonCNot);
	    	Button DNot = (Button)this.activity.findViewById(R.id.buttonDNot);
	    	
	    	enableButton(A);
	    	enableButton(B);
	    	enableButton(C);
	    	enableButton(D);
	    	enableButton(ANot);
	    	enableButton(BNot);
	    	enableButton(CNot);
	    	enableButton(DNot);
	    	
	    	variablesDisabled = false;
	    }
	    
	    public void enableEnter()
	    {
	    	Button enter = (Button)this.activity.findViewById(R.id.buttonEnter);
	    	
	    	enableButton(enter);
	    }
	    
	    public void disableEnter()
	    {
	    	Button enter = (Button)this.activity.findViewById(R.id.buttonEnter);
	    	
	    	disableButton(enter);
	    }
	    
	    public void disableLBracket()
	    {
	    	Button LBracket = (Button)this.activity.findViewById(R.id.buttonLBracket);
	    	
	    	disableButton(LBracket);
	    }
	    
	    public void enableLBracket()
	    {
	    	Button LBracket = (Button)this.activity.findViewById(R.id.buttonLBracket);
	    	
	    	enableButton(LBracket);
	    }
	    
	    public void disableRBracket()
	    {
	    	Button RBracket = (Button)this.activity.findViewById(R.id.buttonRBracket);
	    	
	    	disableButton(RBracket);
	    }
	    
	    public void enableRBracket()
	    {
	    	Button RBracket = (Button)this.activity.findViewById(R.id.buttonRBracket);
	    	
	    	enableButton(RBracket);
	    }
}
