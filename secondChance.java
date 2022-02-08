import java.util.*;
import java.io.*;
class secondChance
{
	public static void main(String args[])throws IOException
	{
		// Creating an page example 
		String example = "2 3 2 1 5 2 4 5 3 2 3 5 1 3 2 1 1";
		// Setting the number of frames
		int frames = 4;
		
		run(example,frames);		
	}
	
	static boolean find(int x,int arr[],boolean marker[],int frames)
	{
		int i;

		for(i = 0; i < frames; i++)
		{
			
			if(arr[i] == x)
			{
				marker[i] = true;
				
				return true;
			}
		}
		return false;
		
	}
	
	static int replace(int x,int arr[], boolean marker[],int frames,int pointer)
	{
		while(true)
		{
			if(!marker[pointer])
			{
				arr[pointer] = x;
				
				return (pointer+1)%frames;
			}
			
			marker[pointer] = false;
			
			pointer = (pointer+1)%frames;
			}
	}
	
	static void run(String example, int frames)
	{
		int pointer,i,l,x,pf;
		int arr[] = new int[frames];
		boolean marker[] = new boolean[frames];
		String page[] = example.split(" ");
		System.out.println("Page situation: "+Arrays.toString(page));

		pointer = 0;
		
		pf = 0;
		
		
		
		Arrays.fill(arr,-1);
		
		
		l = page.length;
		
		for(i = 0; i<l; i++)
		{
			
			x = Integer.parseInt(page[i]);
			System.out.println("Page element: "+x);
			System.out.println("Second Chance frame: "+Arrays.toString(marker));
			

			if(!find(x,arr,marker,frames))
			{
				pointer = replace(x,arr,
						marker,frames,pointer);
				
				pf++;
			}
		}
		
		System.out.println("Total page faults were "+pf);
	}
}
