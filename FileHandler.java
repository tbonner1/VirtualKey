package pack;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileHandler
{
	static final Scanner sc = new Scanner(System.in);
	
	//Attempts to create a new file or alerts the user if it exists, then writes a default message to these generated files
	public void AddFile(String fileName)
	{
		try 
		{
			File f = new File(fileName);
			
			//Creates the file or breaks if file already exists
			if (f.createNewFile()) 
				System.out.println("File successfully added.");
			else
			{
				System.out.println("That file already exists. Please try again.");
				return;
			}
		} 
		catch (IOException e)
		{
			System.out.println("An error occurred creating the file.");
		    return;
		}
		
		try 
		{
			FileWriter writer = new FileWriter(fileName);
			
			System.out.println("Type what you want to write to the file. (press enter when done)\n");
			String writing = "New File created by LOCKEDME.COM FILE MANAGER";
			
			writer.write(writing);
			writer.close();
		} 
		catch (IOException e) 
		{
			System.out.println("An error occurred writing to the file.");
		}
	}
	
	
	//Checks if file exists and deletes it if the user wishes to
	public void DeleteFile(String fileName)
	{
		File f = new File(fileName);
		
		if(!f.exists())
		{
			System.out.println("File does not exist in current directory.");
		}
		else
		{
			if(f.delete())
				System.out.println("File successfully deleted.");
			else
				System.out.println("Unable to delete file.");
		}
	}
	
	
	//Uses the search function to recursively search c: 
	public void SearchFile(String fileName)
	{
		File f = new File(fileName);
		
		File file = new File("c:\\");
		
		System.out.println("Searching all directories in c:");
		search(file, f);
	}
	
	//Using a DFS the recursive function will calculate whole branches to their ends and backtrack to check every directory
	private void search(File file, File f)
	{
		File[] files = file.listFiles();
		
		if(files != null)
			for (File fuf: files) 
			{
				if (fuf.getName().equals(f.getName())) 
				{
					System.out.println("File found at " + fuf.toString());
					break;
				}
				else if(fuf.isDirectory())
					search(fuf, f);
			}
	}
	
	
	//used below
	private ArrayList<String> fileNames;
	
	//Uses ascRecursive to gather all files in the current directory then sorts them using collections and prints each file
	public void ascendingFiles()
	{
		File file = new File(System.getProperty("user.dir"));
		
		fileNames = new ArrayList<String>();
		
		ascRecursive(file);
		
		Collections.sort(fileNames);
		
		System.out.println("The files in the current directory(and it's directories) are: ");
		for(String f: fileNames)
		{
			System.out.println(f);
		}
	}
	
	//Using a DFS this adds every filename to fileNames
	private void ascRecursive(File file)
	{
		File[] files = file.listFiles();
		
		if(files != null)
		{
			for (File fuf: files)
			{
				if (!fuf.isDirectory())
					fileNames.add(fuf.getName());
				else
					ascRecursive(fuf);
			}
		}
	}
	
	public void close()
	{
		sc.close();
	}

}
