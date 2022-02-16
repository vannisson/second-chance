import java.util.*;
import java.io.*;
class secondChance
{
	public static void main(String args[])throws IOException
	{
		// Creating an page example (17 numbers)
		String example = "2 3 2 1 5 2 4 5 3 2 3 5 1 3 2 1 1";
		// Setting the number of frames
		int frames = 4;
		// Start the algorithm
		run(example,frames);		
	}
	
	// Update the reference bit, if page was found
	static boolean updateReferenceBit(int x,int arr[],boolean marker[],int frames)
	{
		// Counter
		int i;

		for(i = 0; i < frames; i++)
		{
			if(arr[i] == x)
			{
				// Setting it to true represents that the page deserves a second chance
				marker[i] = true;
				
				// Returning true indicates that the page does not need to be switched
				return true;
			}
		}
		// Returning false indicates that the page needs to be switched
		return false;
	}
	
	static int replacePage(int x,int arr[], boolean marker[],int frames,int pointer)
	{
		while(true)
		{
			// Check if page that needs to be replaced was found
			if(!marker[pointer])
			{
				// Replace the page with a new one
				arr[pointer] = x;

				// Return the pointer updated
				return (pointer+1)%frames;
			}
			// Mark in the second chance frames as false, as it got one chance
			// It will be replaced in the next time 
			marker[pointer] = false;
			
			// Pointer is updated
			pointer = (pointer+1)%frames;
			}
	}
	
	static void run(String example, int frames)
	{
		int pointer,i,aux,x,pf;
		// Create a array to keep the page numbers
		int arr[] = new int[frames];
		// Create the second chance frames (array)
		boolean marker[] = new boolean[frames];
		// Print the page
		String page[] = example.split(" ");
		System.out.println("Page situation: "+Arrays.toString(page));

		// Set the frame 0 to be replaced
		pointer = 0;
		// Number of page faults
		pf = 0;
		// Set the frames with 
		Arrays.fill(arr,-1);
		
		aux = page.length;
		
		for(i = 0; i<aux; i++)
		{
			
			x = Integer.parseInt(page[i]);
			System.out.println("Memory Array: "+ Arrays.toString(arr));
			System.out.println("Second Chance Array: "+Arrays.toString(marker));
			System.out.println("Page Element: "+x);
			
			// If updateReferenceBit returns false, replace the page
			if(!updateReferenceBit(x,arr,marker,frames))
			{
				pointer = replacePage(x,arr,
						marker,frames,pointer);
				// Increases the number of page fault
				pf++;
				System.out.println("Page Fault Number: "+ pf);
				
			}
			System.out.println("---------------------");
		}
		
		System.out.println("Total page faults were "+pf);
	}
}
