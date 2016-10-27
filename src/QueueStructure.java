//This class provides the structure of the queue.

import java.io.*; 
import java.util.Scanner;


class QueueStructure

        { 
	
	       public int checkPrint; 
	       
	       /*public QueueStructure(int checkPrint)
           {
             this.checkPrint = checkPrint; 
           }*/
	       
	       Scanner s = new Scanner (System.in);
	        
            public String SubjectName; 

            public int Priority;

            public double WeekDayHours;

            public double WeekEndHours;
            
            public double WeekDayHoursLeft; 
            
            public double WeekEndHoursLeft; 
            
            public String DaysAllocated;
            
            String timeweek = "";
            
            String timeweekend = "";
            
            public QueueStructure next; 
            
            //Constructor for Assigning Values to various variables
            public QueueStructure(String d1, int d2, double d3, double d4, String timeweek, String timeweekend)
            {
            	this.SubjectName = d1; 

            	this.Priority = d2; 

            	this.WeekDayHours = d3;

            	this.WeekEndHours = d4;
                
                this.timeweek = timeweek;
                
                this.timeweekend = timeweekend;
                
            }
            
            //Method for printing information of the week
            public void printQueueWeek(int checkPrint, String fileName) 
            {
        	    
            	if(checkPrint == 1)
            	{
            		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName + ".txt", true)))) 
            		{
            			out.println(SubjectName + " on " + DaysAllocated + " for " + timeweek + ".");

            			out.println(" ");
            		}
            		catch (IOException e) 
            		{
            			System.out.println("Something went wrong. Please try again.");
            		}
            	}

            	System.out.println(SubjectName + " on " + DaysAllocated + " for " + timeweek + ".");

            	System.out.println("");
        	    
        	    }
            
            //Method for Printing information of WeekEnd
            public void printQueueWeekEnd(int checkPrint, String fileName) 
            {
            	if(checkPrint == 1)
            	{
            		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName + ".txt", true)))) 
            		{
            			out.println(SubjectName + " on " + DaysAllocated  + " for " + timeweekend + ".");

            			out.println(" ");
            		}
            		catch (IOException e) 
            		{
            			System.out.println("Something went wrong. Please try again.");
            		}
            	}
            	
            	System.out.println(SubjectName + " on " + DaysAllocated  + " for " + timeweekend);
            	
            	System.out.println("");
                
            }
        }
