package cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import cs.architecture.Internal;
import cs.architecture.routine.Routine;

/*
 * For parsing ###($rd): \d{1,}\(\$\w\d\)
 */
public class Parser
{
	private FileHandler binary; 
	
	public Parser()
	{
		binary = new FileHandler();
	}
	
	public String parseSingle(String line)
	{
		// Remove comment
		line = line.replaceAll("#.{1,}", "");
		
		// Trim leading and trailing whitespace
		line = line.trim();
		
		return line;
	}
	
	public ArrayList<String> parseInstructionFile(String dir)
	{
		ArrayList<String> expressions = new ArrayList<String>();
		
		if(binary.openFile(dir))
		{
			String line = binary.readLine();
			while(line != null)
			{
				expressions.add(line);
				line = binary.readLine();
			}
			
			binary.closeReader();
			
			return expressions;
		}
		
		return expressions;
	}
	
	public LinkedHashMap<Integer, Integer> loadMemory(String dir, Internal internal)
	{
		LinkedHashMap<Integer, Integer> memoryList = new LinkedHashMap<Integer, Integer>();
		if(binary.openFile(dir))
		{
			String line = binary.readLine();
			while(!line.contains("MEMORY:") && line != null)
				line = binary.readLine();
			
			line = binary.readLine();
			while(line != null)
			{
				line = binary.readLine();
				
				// Remove comment
				line = line.replaceAll("#.{1,}", "");
				
				// Trim leading and trailing whitespace
				line = line.trim();
				
				if(!line.isEmpty()) // If line is not empty, start parsing
				{
					line = line.replaceAll("\\s{1,}", "");
					String[] memory = line.split(":");
					
					// Hex check for input
					memory[0] = memory[0].replaceAll("0x", "");
					int address = (int) Long.parseLong(memory[0], 16);
					
					// Hex check for input
					int value = 0;
					if(memory[1].startsWith("0x"))
					{
						memory[1] = memory[1].replaceAll("0x", "");
						value = (int) Long.parseLong(memory[1], 16);
					}
					else if(memory[1].matches("[^0-9]"))
						value = memory[1].charAt(0);
					else
						value = Integer.parseInt(memory[1]);
					
					memoryList.put(address, value);
				}
				
				line = binary.readLine();
			}
			
			binary.closeReader();
		}
		
		return memoryList;
	}
	
	public void saveInstructionToFile(File file, String line)
	{
		if(binary.writeFile(file))
		{
			binary.writeLine(line);
			binary.closeWriter();
		}
	}
	
	public String parsePrompt(String dir)
	{
		String prompt = "";
		try
		{
			
			if(binary.openFile(dir))
			{
				
			}
			File file = new File(dir);
			
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String line = br.readLine();
			while(line != null)
			{
				line = line.replaceAll("#.{1,}", "");
				String[] parsed = line.split("#");
				if(!line.isEmpty())
				{
					if(parsed[0].contains("PROMPT:")) ;
					else if(parsed[0].contains("MEMORY:"))
					{
						br.close();
						return prompt;
					}
					else
					{
						prompt += line + "\n";
					}
				}
				
				line = br.readLine();
			}
			
			br.close();
		}
		catch(Exception err)
		{
			err.printStackTrace();
			return prompt;
		}
		return prompt;
	}
	
	public void parseInstructions()
	{
//		String line = "(add $t0, $t1, $t2)";
	}
}
