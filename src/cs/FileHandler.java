package cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileHandler
{
	private BufferedReader br;
	private BufferedWriter bw;
	
	public boolean openFile(String dir)
	{
		try
		{
			if(br != null)
				br.close();
			
			br = new BufferedReader(new FileReader(dir));
			
			return true;
		}
		catch(Exception err)
		{
			err.printStackTrace();
			return false;
		}
	}
	
	public boolean openFile(File dir)
	{
		try
		{
			if(br != null)
				br.close();
			
			br = new BufferedReader(new FileReader(dir));
			
			return true;
		}
		catch(Exception err)
		{
			err.printStackTrace();
			return false;
		}
	}
	
	public boolean writeFile(String dir)
	{
		try
		{
			File file = new File(dir);
			if(!file.exists())
				file.createNewFile();
			
			if(bw != null)
				bw.close();
			
			bw = new BufferedWriter(new FileWriter(file));
			
			return true;
		}
		catch(Exception err)
		{
			err.printStackTrace();
			return false;
		}
	}
	
	public boolean writeFile(File dir)
	{
		try
		{
			if(!dir.exists())
				dir.createNewFile();
			
			if(bw != null)
				bw.close();
			
			bw = new BufferedWriter(new FileWriter(dir));
			
			return true;
		}
		catch(Exception err)
		{
			err.printStackTrace();
			return false;
		}
	}
	
	public boolean closeReader()
	{
		try
		{
			br.close();
			return true;
		}
		catch(Exception err)
		{
			err.printStackTrace();
			return false;
		}
	}
	
	public boolean closeWriter()
	{
		try
		{
			bw.flush();
			bw.close();
			
			return true;
		}
		catch(Exception err)
		{
			err.printStackTrace();
			return false;
		}
	}
	
	public String readLine()
	{
		try
		{
			return br.readLine();
		}
		catch(Exception err)
		{
			err.printStackTrace();
			return null;
		}
	}
	
	public String writeLine(String line)
	{
		try
		{
			bw.write(line); bw.write("\n");
			return line;
		}
		catch(Exception err)
		{
			err.printStackTrace();
			return "";
		}
	}
}
