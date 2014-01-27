package com.muntashir.truthtablegenerator;

import java.util.ArrayList;

public class Expressions {

	public boolean varA = false;
	public boolean varB = false;
	public boolean varC = false;
	public boolean varD = false;
	public String firstVar = null;
	public String secondVar = null;
	public String thirdVar = null;
	public String fourthVar = null;
	public int numVar = 0;
	
    public void getVar(ArrayList<String> input)
    {  	
    	
    	for (String term : input)
    	{
    		if (term.equals("A") || term.equals("!A"))
    		{
    			varA = true;
    		}
    		else if (term.equals("B") || term.equals("!B"))
    		{
    			varB = true;
    		}
    		else if (term.equals("C") || term.equals("!C"))
    		{
    			varC = true;
    		}
    		else if (term.equals("D") || term.equals("!D"))
    		{
    			varD = true;
    		}
    	}
    	
  	if (varA == true)
		{
			numVar++;
			firstVar = "A";
		}
		if (varB == true)
		{
			numVar++;
			
			if (firstVar == null)
				firstVar = "B";
			else
				secondVar = "B";
		}
		if (varC == true)
		{
			numVar++;
			
			if (secondVar == null)
			{
				if (firstVar == null)
					firstVar = "C";
				else
					secondVar = "C";
			}
			else
				thirdVar = "C";
		}
		if (varD == true)
		{
			numVar++;

			if (thirdVar == null)
			{
				if (secondVar == null)
				{
					if (firstVar == null)
						firstVar = "D";
					else
						secondVar = "D";
				}
				else
					thirdVar = "D";
			}
			else
				fourthVar = "D";
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
    
}
