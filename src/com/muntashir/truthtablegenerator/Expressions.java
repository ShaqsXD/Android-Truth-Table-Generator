package com.muntashir.truthtablegenerator;

import java.util.ArrayList;

public class Expressions {

	public boolean varA = false;
	public boolean varB = false;
	public boolean varC = false;
	public boolean varD = false;
	
	public int numVar = 0;
	
    public void getVarNum(ArrayList<String> input) {  	    	
    	for (String term : input)
    	{
    		if (term.equals("A") || term.equals("!A") || term.equals("!!A"))
    			varA = true;
    		else if (term.equals("B") || term.equals("!B") || term.equals("!!B"))
    			varB = true;
    		else if (term.equals("C") || term.equals("!C") || term.equals("!!C"))
    			varC = true;
    		else if (term.equals("D") || term.equals("!D") || term.equals("!!D"))
    			varD = true;
    	}
    	
  	if (varA == true)
		numVar = 1;
	if (varB == true)
		numVar = 2;
	if (varC == true)
		numVar = 3;
	if (varD == true)
		numVar = 4; 	
		
    }

    public ArrayList<String> parse(ArrayList<String> input) {
    	
    	for (int i = 0; i < input.size(); i++)
    		{
    			input.set(i, input.get(i).trim());
    			
    			if (input.get(i).equals("AND"))
    				input.set(i, "&&");
    			else if (input.get(i).equals("OR"))
    				input.set(i, "||");
    			else if (input.get(i).equals("XOR"))
    				input.set(i, "!=");
    			else if (input.get(i).equals("NAND"))
    			{
    				input.set(i, "||");
    				input.set(i + 1, "!" + input.get(i + 1));
    				input.set(i - 1, "!" + input.get(i - 1));
    			}
    			else if (input.get(i).equals("NOR"))
    			{
    				input.set(i, "&&");
    				input.set(i + 1, "!" + input.get(i + 1));
    				input.set(i - 1, "!" + input.get(i - 1));
    			}
    			else if (input.get(i).equals("XNOR"))
    				input.set(i, "==");   		
    			else if ((input.get(i).equals("A")) || (input.get(i).equals("!A'")))
    				input.set(i, "A");
    			else if ((input.get(i).equals("B")) || (input.get(i).equals("!B'")))
    				input.set(i, "B");
    			else if ((input.get(i).equals("C")) || (input.get(i).equals("!C'")))
    				input.set(i, "C");
    			else if ((input.get(i).equals("D")) || (input.get(i).equals("!D'")))
    				input.set(i, "D");
    			else if (input.get(i).equals("A'"))
    				input.set(i, "!A");
    			else if (input.get(i).equals("B'"))
    				input.set(i, "!B");
    			else if (input.get(i).equals("C'"))
    				input.set(i, "!C");
    			else if (input.get(i).equals("D'"))
    				input.set(i, "!D");		
    		}
    	
    	return input;	
	}
    
	public int boolToBin(boolean input) {
    	if (input == true)
    		return 1;
    	else
    		return 0;
	}
}
