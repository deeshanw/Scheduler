//This class provides implementation and logic for generating the schedule.
 

import java.util.InputMismatchException;

import java.util.Scanner;

public class Scheduler
{
	public static int NofSub = 0;
	
	static int count1 = 0;

	private static Scanner s;
	
	public static void main(String[] args)

	{
		try 
		
		{
		
		s = new Scanner(System.in);
			
		int localvar = 0;

		while (true) 
		{
	
			// Providing various options for the user to navigate easily
			
			System.out.println(" ");
			
			System.out.println("Welcome to Scheduler. Scheduler will make your everyday student life easier by automatically generating a schedule for you based on your responses. Please enter 1, 2 or 3  to get started.");

			System.out.println("");
			
			System.out.println("==================");
			
			System.out.println("1. Start Scheduler");

			System.out.println("2. Exit Scheduler");

			System.out.println("3. About Scheduler");
			
			System.out.println("==================");
			
			System.out.println("");

			int initialinput = s.nextInt();
			
				if (initialinput == 1)

				{
					System.out.println("");

					System.out.println("You will be asked several questions throughout the course of the program. Please answer these to the best of your abilities.");

					System.out.println("");

					System.out.println("How many subjects do you take?");
					
					System.out.println("");

				    final int NofSub = s.nextInt();

					System.out.println("");

					int WeekDayHours = 0;

					System.out.println("Please enter the amount of time you can dedicate to studies during the week (in hours).");
					
					System.out.println("");

					WeekDayHours = s.nextInt();
					
					System.out.println("");

					int WeekEndHours = 0;

					System.out.println("Please enter the amount of time you can dedicate to studies during the weekend (in hours).");
					
					System.out.println("");

					WeekEndHours = s.nextInt();
					
					System.out.println("");

					QueueImplementation objQueueImplementation1 = new QueueImplementation();

					QueueImplementation objQueueImplementation2 = new QueueImplementation();

					int i = 0;

					// Storing the list of subjects temporarily
					String[] Subject = new String[NofSub];

					// Array for Storing priority of the subjects temporarily
					int[] Priority = new int[NofSub];

					i = NofSub;

					int j = 0;

					System.out.println("Enter your subjects in the order of priority (from highest to lowest). Press enter after entering a subject. WARNING: Subject names cannot have spaces. The program will not work as intended if it is not heeded to.");
					System.out.println("");

					// While Loop to Enter Subject specific Details
					while (i > 0)

					{

						Subject[j] = s.next();
						
						System.out.println("");

						Priority[j] = i;

						i--;

						j++;

					}
					
					double[] temp1 = new double[NofSub];

					double[] temp2 = new double[NofSub];
					
					while (localvar != 1) 
					
					{
						System.out.println("===================================================");

						System.out.println("What would you like to do?");
						
						System.out.println("");

						System.out.println("Press 1 to generate your schedule for the week.");

						System.out.println("Press 2 to generate your schedule for the weekend.");
						
						System.out.println("Press 3 to go back to the main menu.");
						
						System.out.println("===================================================");
						
						System.out.println("");
						
						String t1 = "";
						
						String t2 = "";
						
						int choice = 0;
						
						choice = s.nextInt();
			
				   	    System.out.println("");
						
						// Inserting information in the queue
						if (count1 == 0) 
						{
							temp1 = TimeDivision(NofSub, WeekDayHours);

							temp2 = TimeDivision(NofSub, WeekEndHours);
							
							int z = 0;
							
							while (z < NofSub) 
							{
								t1 = ReturnTime(temp1[z]);

								t2 = ReturnTime(temp2[z]);

								// Inserting information in the queue
								objQueueImplementation1.InsertIntoQueue(Subject[z], Priority[z], temp1[z],temp2[z], t1, t2);
								
								z++;
							}
							count1++;
						}

						switch (choice) 
						{
						// Case 1 is hit when we select the option for generating Weekday Schedule
						case 1: divisionOfDaysWeek(objQueueImplementation1,WeekDayHours);
						{
							objQueueImplementation1.Print1();
							
							break;
						}
						
						// Case 2 is hit when we select the option for generating WeekEnd Schedule
						
						case 2: {divisionOfDaysWeekEnd(objQueueImplementation1,WeekEndHours); // Dividing the hours among days
							// Printing the Schedule

						    objQueueImplementation2.Print2();	
							
							break;
						}
						case 3: 
						{
							localvar++;
							
							break;
						}

						default: 
						{
							System.out.println("");
							
							System.out.println("Incorrect input.");
							
							System.out.println("");
							
							break;
						}
						
						}

					}
				}

				else if (initialinput == 2) 
				{
					System.exit(0);
				}

				else if (initialinput == 3) 
				{
					System.out.println("");
					
					System.out.println("Scheduler by Deeshan Wassan, Pathways World School, Gurgaon, Haryana.");
					
					System.out.println("");
				}

				else 
				{
					System.out.println("");
					
					System.out.println("Incorrect Input.");
					
					System.out.println("");
				}

				--localvar;
		}
	}
		
		catch(InputMismatchException e)
		{
			System.out.println("Incorrect input, please try again.");
		}
	}
		
	// Method to return time in terms of hours and minutes as a String.
	public static String ReturnTime(double time) {

		int hours = 0;

		int mins = 0;

		mins = (int) time % 60;

		// Else if ladder for a more accurate division of time.
		if (mins > 0 && mins < 8) {
			mins = 0;
		}

		else if (mins >= 8 && mins <= 15) {
			mins = 10;
		}

		else if (mins > 15 && mins <= 25) {
			mins = 20;
		}

		else if (mins > 25 && mins <= 40) {
			mins = 30;
		}

		else if (mins > 40 && mins <= 59) {
			mins = 45;
		}

		hours = (int) time / 60;

		String TimeString = hours + " hours and " + mins + " minutes";

		return (TimeString);
	}

	// Method For dividing time between subjects based on the order of priority they were entered in.
	public static double[] TimeDivision(int NofSub, int TotalTime) {

		double[] subjarr = new double[NofSub]; //Makes a new array with length as the number of subjects. 

		int tempofsub = NofSub; //Initializes a temporary variable equal to the number of subjects entered.

		int i = 0;

		int sum = 0;

		double ratio = 0.0;

		while (tempofsub > 0) 
		{
			subjarr[i] = tempofsub;

			sum = sum + tempofsub;

			tempofsub--;

			i++;
		}

		ratio = ((((double) TotalTime) * 60) / sum);

		for (int j = 0; j < NofSub; j++) 
		{
			subjarr[j] = (subjarr[j] * ratio);
		}

		return subjarr;

	}

	// Method for dividing subjects during the week
	public static void divisionOfDaysWeek(QueueImplementation queueObj,int WeekDayHours) 
	{
		QueueStructure front = queueObj.ReturnClassInfo();

		String[] Day = new String[5];

		Day[0] = "Monday";

		Day[1] = "Tuesday";

		Day[2] = "Wednesday";

		Day[3] = "Thursday";

		Day[4] = "Friday";

		int count = 0;

		if (front == null) 
		{
			System.out.println("Division of days cannot be done.");
		}
		
		double timePerDay = (double) WeekDayHours / 5;

		double timeLeftForday = timePerDay;

		while (front != null) 
		{

			front.WeekDayHoursLeft = ((front.WeekDayHours) / 60) - timeLeftForday;

			if ((front.WeekDayHoursLeft > 0) && (front.WeekDayHoursLeft < timePerDay)) 
			{

				front.DaysAllocated = ("" + Day[count] + " and " + Day[count + 1]);

				front.WeekDayHoursLeft = 0;

				timeLeftForday = timeLeftForday - front.WeekEndHours;

				front = front.next;

				count++;

			} 

			else 
			{
				if (count >= 4)
					
				{

					front.DaysAllocated = ("" + Day[4]);

					front.WeekDayHoursLeft = 0;

					front = front.next;

				}

				else 
				{
					front.DaysAllocated = ("" + Day[count]);

					front.WeekDayHoursLeft = 0;

					front = front.next;

					count++;
				}
			}

		}
	}

	// Method for dividing the subjects on various days
	public static void divisionOfDaysWeekEnd(QueueImplementation queueObj,int WeekEndHours) 
	{
		QueueStructure front = queueObj.ReturnClassInfo();

		String saturdaySub = "";

		String sundaydaySub = "";

		if (front == null) 
		{
			System.out.println("Division of days cannot be done.");

		}
		
		double timePerDaysun = (double)WeekEndHours / 1.8;
		
		double timeLeftForday = timePerDaysun;

		while (front != null) 
		{
			if (((front.WeekEndHours) / 60) < timeLeftForday) 
			{
				front.DaysAllocated = "Saturday";

				saturdaySub = saturdaySub + front.SubjectName + " ";

				timeLeftForday = timeLeftForday - (front.WeekEndHours/60);
				

				front = front.next;	
			} 
			
			else 
			{
				front.DaysAllocated = "Sunday";

				sundaydaySub = sundaydaySub + front.SubjectName;

				front = front.next;

			}

		}
	}

}
