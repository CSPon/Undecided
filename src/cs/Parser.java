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
		String[] parsed = line.split("#");
		if(!parsed[0].isEmpty())
		{
			if(parsed[0].contains(":"))
			{
				String[] instruction = parsed[0].split(":");
				if(instruction.length == 2)
					routine.addInstruction(instruction[1]);
				routine.addLabel(instruction[0]);
			}
			else
				routine.addInstruction(line);
		}
	}
	
	public ArrayList<String> parseOnly(File file)
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
	
	public void parse(String dir, Routine routine)
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(dir));
			
			String line = br.readLine();
			while(line != null)
			{
				String[] parsed = line.split("#");
				if(!parsed[0].isEmpty())
				{
					if(parsed[0].contains(":"))
						routine.addLabel(line);
					else
						routine.addInstruction(line);
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
	
	public void loadMemory(String dir, Internal internal)
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(dir));
			
			String line = br.readLine();
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
	
	public void loadMemory(File file, Internal internal)
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String line = br.readLine();
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
	
	public void writeToFile(File file, String line)
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
}
