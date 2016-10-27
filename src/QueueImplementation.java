//This class provides the functionality of a queue.

import java.util.Scanner;

public class QueueImplementation implements QueueFunctions {

	Scanner s = new Scanner (System.in);
	
	public static QueueStructure front; 

    public static QueueStructure rear; 
    
    //Method for inserting information in the queue.
	public void InsertIntoQueue(String subjectname, int priority, double weekhrs, double weekendhrs,String t1, String t2) 
	{
		
		QueueStructure node = new QueueStructure(subjectname,priority,weekhrs, weekendhrs, t1,t2);

        node.next = null; 

        if(front == null && rear == null)	
        {
            front = node; 

            rear = node; 
        }
        
        else
        {
            rear.next = node;

            rear = node; 
        }

	}

	//Method for deleting from the queue.
	public void DeleteFromQueue() 
	{
		
		boolean check = isEmpty(); 

        if(check==false)
        {
            if(front==rear)
            {
                front = null;
                rear = null;
            }
            else
            {
                front = front.next; 
            }
        }
        else
        {
            System.out.println("There is nothing to delete.");
        }

        System.out.println("You have deleted");

        System.out.println("");

	}

	//Method to check if the queue is empty
	public boolean isEmpty() 
	{

        if(front==null) 
        {
            return true;
        }
        else
        	
        
        {
            return false;
        }
	}

	//Method to return the reference to the front of the queue.
	public QueueStructure ReturnClassInfo() 
	{

		 return front;
		
	}
	
	//Used to print the schedule for the week.
	 public void Print1()
	    {
	        QueueStructure PrintVar = null; 

	        if(front == null)
	        {
	            System.out.println("There is nothing to print."); 

	        }
	        else
	        {
	            PrintVar = front;
	            
	            System.out.println("Do you want to save the schedule to a text file? Enter 1 for yes and 0 for no.");
	            
	            System.out.println("");
            	
            	int checkPrint = s.nextInt();
            	
            	System.out.println("");
            	
            	String fileName = ""; 
            	
            	if(checkPrint == 1)
            	{
            		
            	System.out.println("Enter the name of the file.");
            	
            	System.out.println("");
            	
            	fileName = s.next();
            	
                System.out.println("");
                
                System.out.println("Saved to the file " + fileName + ".txt");
               
                System.out.println("");          
            	
            	System.out.println("Your schedule for the week is: ");
            	
            	System.out.println("");
            	
            	}
            	else
            	{
            		System.out.println("Not stored in a file.");
            		
            		System.out.println("");
            		
            		System.out.println("Your schedule for the weekend is: ");
            		
            		System.out.println("");
            	}

	            while(PrintVar != null)
	            {
	            	
	                PrintVar.printQueueWeek(checkPrint, fileName);

	                PrintVar = PrintVar.next;
	            }
	        }
	    }
	 
	//Used to print the schedule for the weekend. 
	 public void Print2()
	    {
	        QueueStructure PrintVar = null; 

	        if(front == null)
	        {
	            System.out.println("There is nothing to print."); 

	        }
	        else
	        {
	            PrintVar = front;
	            
                System.out.println("Do you want to save the schedule to a text file? Enter 1 for yes and 0 for no.");
                
                System.out.println("");
            	
            	int checkPrint = s.nextInt();
            	
            	System.out.println("");
            	
            	String fileName = ""; 
            	
            	if(checkPrint == 1)
            		
            	{
            		
            	System.out.println("Enter the name of the file.");
            	
            	System.out.println("");
            	
            	fileName = s.next();
            	
                System.out.println("");
                
                System.out.println("Saved to the file " + fileName + ".txt");
                
                System.out.println("");
            	
            	System.out.println("Your schedule for the weekend is: ");
            	
            	System.out.println("");
            	
            	}
            	else
            	{
            		System.out.println("Not stored in a file.");
            		
            		System.out.println("");
            		
            		System.out.println("Your schedule for the weekend is: ");
            		
            		System.out.println("");

            	}

	            while(PrintVar != null)
	            {
	                PrintVar.printQueueWeekEnd(checkPrint, fileName);

	                PrintVar = PrintVar.next;
	            }
	        }
	    }
}