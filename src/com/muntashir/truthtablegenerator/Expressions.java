package com.muntashir.truthtablegenerator;

import java.util.ArrayList;

public class Expressions {

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
