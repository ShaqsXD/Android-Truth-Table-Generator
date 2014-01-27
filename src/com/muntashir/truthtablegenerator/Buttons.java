package com.muntashir.truthtablegenerator;

import android.app.Activity;
import android.graphics.Color;
import android.widget.Button;

public class Buttons {
	
	public boolean variablesDisabled = false;
	Activity activity = new Activity();
	
	protected Button AND;
	protected Button OR;
	protected Button XOR;
	protected Button NAND;
	protected Button NOR;
	protected Button XNOR;
	protected Button A;
	protected Button B;
	protected Button C;
	protected Button D;
	protected Button ANot;
	protected Button BNot;
	protected Button CNot;
	protected Button DNot;
	protected Button Enter;
	protected Button LBracket;
	protected Button RBracket;
	
	public Buttons(Activity activity)
	{
		this.activity = activity;	
		
		AND = (Button)this.activity.findViewById(R.id.buttonAnd);
		OR = (Button)this.activity.findViewById(R.id.buttonOr);
		XOR = (Button)this.activity.findViewById(R.id.buttonXor);
		NAND = (Button)this.activity.findViewById(R.id.buttonNand);
		NOR = (Button)this.activity.findViewById(R.id.buttonNor);
		XNOR = (Button)this.activity.findViewById(R.id.buttonXnor);
		A = (Button)this.activity.findViewById(R.id.buttonA);
		B = (Button)this.activity.findViewById(R.id.buttonB);
		C = (Button)this.activity.findViewById(R.id.buttonC);
		D = (Button)this.activity.findViewById(R.id.buttonD);
		ANot = (Button)this.activity.findViewById(R.id.buttonANot);
		BNot = (Button)this.activity.findViewById(R.id.buttonBNot);
		CNot = (Button)this.activity.findViewById(R.id.buttonCNot);
		DNot = (Button)this.activity.findViewById(R.id.buttonDNot);
		Enter = (Button)this.activity.findViewById(R.id.buttonEnter);
		LBracket = (Button)this.activity.findViewById(R.id.buttonLBracket);
		RBracket = (Button)this.activity.findViewById(R.id.buttonRBracket);
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
	    	enableButton(AND);
	    	enableButton(OR);
	    	enableButton(XOR);
	    	enableButton(NAND);
	    	enableButton(NOR);
	    	enableButton(XNOR);
	    }
	    
	    public void disableOperators()
	    {
	    	disableButton(AND);
	    	disableButton(OR);
	    	disableButton(XOR);
	    	disableButton(NAND);
	    	disableButton(NOR);
	    	disableButton(XNOR);
	    }
	    
	    public void disableVariables()
	    {
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
	    	enableButton(Enter);
	    }
	    
	    public void disableEnter()
	    {
	    	disableButton(Enter);
	    }
	    
	    public void disableLBracket()
	    {
	    	disableButton(LBracket);
	    }
	    
	    public void enableLBracket()
	    {
	    	enableButton(LBracket);
	    }
	    
	    public void disableRBracket()
	    {  	
	    	disableButton(RBracket);
	    }
	    
	    public void enableRBracket()
	    {
	    	enableButton(RBracket);
	    }
}
