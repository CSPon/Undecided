package cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import cs.architecture.Internal;
import cs.routine.Routine;

public class Parser
{
	public void parseSingle(String line, Routine routine)
	{
		line = line.replaceAll("#.{1,}", "");
		if(!line.isEmpty())
		{
			if(line.contains(":"))
			{
				String[] instructions = line.split(":");
				if(instructions.length == 2)
					routine.addInstruction(instructions[1]);
				routine.addLabel(instructions[0]);
			}
			else
				routine.addInstruction(line);
		}
	}
	
	public void parseInstructionFromFile(String dir, Routine routine)
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(dir));
			
			String line = br.readLine();
			while(line != null)
			{
				parseSingle(line, routine);
				
				line = br.readLine();
			}
			
			br.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> readInstructionFromFile(File file)
	{
		ArrayList<String> lines = new ArrayList<String>();
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String line = br.readLine();
			while(line != null)
			{
				lines.add(line);
				line = br.readLine();
			}
			
			br.close();
		}
		catch(Exception err)
		{
			err.printStackTrace();
			return lines;
		}
		
		return lines;
	}
	
	public void loadMemory(String dir, Internal internal)
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(dir));
			
			String line = br.readLine();
			while(!line.contains("MEMORY:"))
				line = br.readLine();
			
			line = br.readLine();
			while(line != null)
			{
				
				String[] parsed = line.split("#");
				if(!parsed[0].isEmpty())
				{
					String combined = parsed[0];
					combined = combined.trim();
					combined = combined.replaceAll("\\s{1,}", "");
					parsed = combined.split(":");
					// Hex check for input
					parsed[0] = parsed[0].replaceAll("0x", "");
					
					int address = (int) Long.parseLong(parsed[0], 16);
					int value = 0;
					
					if(parsed[1].startsWith("0x"))
					{
						parsed[1] = parsed[1].replaceAll("0x", "");
						value = (int) Long.parseLong(parsed[1], 16);
					}
					else if(parsed[1].matches("[^0-9]"))
					{
						value = parsed[1].charAt(0);
					}
					else
						value = Integer.parseInt(parsed[1]);
					
					internal.setToMem(address, 0, value);
				}
				
				line = br.readLine();
			}
			
			br.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void loadMemoryFromFile(File file, Internal internal)
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String line = br.readLine();
			while(!line.contains("MEMORY:"))
				line = br.readLine();
			
			line = br.readLine();
			while(line != null)
			{
				line = line.replaceAll("#.{1,}", "");				
				if(!line.isEmpty())
				{
					line = line.trim();
					line = line.replaceAll("\\s{1,}", "");
					String[] memory = line.split(":");
					// Hex check for input
					memory[0] = memory[0].replaceAll("0x", "");
					
					int address = (int) Long.parseLong(memory[0], 16);
					int value = 0;
					
					if(memory[1].startsWith("0x"))
					{
						memory[1] = memory[1].replaceAll("0x", "");
						value = (int) Long.parseLong(memory[1], 16);
					}
					else if(memory[1].matches("[^0-9]"))
					{
						value = memory[1].charAt(0);
					}
					else
						value = Integer.parseInt(memory[1]);
					
					internal.setMemoryVal(address, 0, value);
				}
				
				line = br.readLine();
			}
			
			br.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void saveInstructionToFile(File file, String line)
	{
		try
		{
			file.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			
			bw.write(line);
			
			bw.close();
		}
		catch(Exception err)
		{
			err.printStackTrace();
		}
	}
	
	public String parsePrompt(String dir)
	{
		String prompt = "";
		try
		{
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
		String line = "(add $t0, $t1, $t2)";
	}
}
