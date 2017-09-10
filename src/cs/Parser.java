package cs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import cs.routine.Routine;

public class Parser
{	
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
}
