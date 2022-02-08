import java.util.*;
import java.io.*;
class secondChance
{
	public static void main(String args[])throws IOException
	{
		String example = "2 3 2 1 5 2 4 5 3 2 3 5";
		int frames = 3;
		
		printHitsAndFaults(example,frames);		
	}
	
	static boolean findAndUpdate(int x,int arr[],boolean second_chance[],int frames)
	{
		int i;

		for(i = 0; i < frames; i++)
		{
			
			if(arr[i] == x)
			{
				second_chance[i] = true;
				
				return true;
			}
		}
		return false;
		
	}
	
	static int replaceAndUpdate(int x,int arr[],
				boolean second_chance[],int frames,int pointer)
	{
		while(true)
		{
			
			if(!second_chance[pointer])
			{
				arr[pointer] = x;
				
				return (pointer+1)%frames;
			}
			
			second_chance[pointer] = false;
			
			pointer = (pointer+1)%frames;
		}
	}
	
	static void printHitsAndFaults(String example,
												int frames)
	{
		int pointer,i,l,x,pf;
		
		pointer = 0;
		
		pf = 0;
		
		int arr[] = new int[frames];
		
		Arrays.fill(arr,-1);
		
		boolean second_chance[] = new boolean[frames];
		
		String str[] = example.split(" ");
		
		l = str.length;
		
		for(i = 0; i<l; i++)
		{
			
			x = Integer.parseInt(str[i]);

			if(!findAndUpdate(x,arr,second_chance,frames))
			{
				pointer = replaceAndUpdate(x,arr,
						second_chance,frames,pointer);
				
				pf++;
			}
		}
		
		System.out.println("Total page faults were "+pf);
	}
}
