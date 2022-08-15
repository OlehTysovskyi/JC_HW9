package First_Task;

import java.util.Scanner;
/*Main Class*/
public class Main {
	/*Creating enum with seasons*/
	enum Season {
		WINTER, SPRING, SUMMER, FALL;
	}
	/*Creating enum with months*/
	enum Month {
		JANUARY(Season.WINTER, 31), FEBRUARY(Season.WINTER, 28), MARCH(Season.SPRING, 31), APRIL(Season.SPRING, 30),
		MAY(Season.SPRING, 31), JUNE(Season.SUMMER, 30), JULY(Season.SUMMER, 31), AUGUST(Season.SUMMER, 31),
		SEPTEMBER(Season.FALL, 30), OCTOBER(Season.FALL, 31), NOVEMBER(Season.FALL, 30), DECEMBER(Season.WINTER, 31);
		/*Values for month constructor*/
		Season season;
		int days;
		/*Month constructor*/
		Month(Season season, int days) {
			this.season = season;
			this.days = days;
		}
		/*Season getter*/
		public Season getSeason() {
			return season;
		}
		/*Days getter*/
		public int getDays() {
			return days;
		}
	}
	/*Method for menu in console*/
	static void menu() {
		System.out.println(
				"Press '1' to check if this month exists" + "\n" + "Press '2' to check all monthes with the same SEASON"
						+ "\n" + "Press '3' to check all monthes with the same amount of days" + "\n"
						+ "Press '4' to see all monthes with the smallest amount of days" + "\n"
						+ "Press '5' to see all monthes with the biggest amount of days" + "\n"
						+ "Press '6' to check the next SEASON" + "\n" + "Press '7' to check the previous SEASON" + "\n"
						+ "Press '8' to see all monthes with EVEN number off days" + "\n"
						+ "Press '9' to see all monthes with ODD number off days" + "\n"
						+ "Press '10' to check if this nonth has EVEN number of days" + "\n");
	}
	
	/*Method for entering season name through console*/
	static String monthScn(String month) {
		System.out.println("Enter the name of MONTH: ");
		Scanner scn2 = new Scanner(System.in);
		/*Entering trough console*/
		month = scn2.next().toUpperCase();
		return month;
	}
	/*Method for entering season name through console*/
	static String seasonScn(String season) {
		System.out.println("Enter the name of SEASON: ");
		Scanner scn2 = new Scanner(System.in);
		/*Entering trough console*/
		season = scn2.next().toUpperCase();
		return season;
	}
	
    /*Main function*/
	public static void main(String[] args) {
		/*Array with enums values*/
		Month[] arr = Month.values();
		Season[] sarr = Season.values();
		/*Creating scanner object*/
		Scanner scn = new Scanner(System.in);
		/*Values for recording*/
		String month = null;
		String season = null;
		
		/*eternal loop for continuous program operation*/
		while (true) {
			/*Using menu method*/
			menu();
			/*Operator which lets to choose one of the items from menu*/
			switch (scn.nextInt()) {
			
			case (1): {
				/*Entering thanks to monthScanner method*/
				month = monthScn(month);
				/*Value that indicates whether such an month exists*/
				boolean exist = false;
				/*Controlled code*/
				try {
					/*Checking the each array element*/
					for (Month m : arr) {
						if (m.name().equals(month)) {
							System.out.println("Such month - EXISTS" + "\n");
							exist = true;
						}
					}
					if (exist == false) {
						throw new WrongInputConsoleParametersException();
					}
				}
				/*If user entered incorrect name of month*/
				catch (WrongInputConsoleParametersException e){
					System.err.println("Such month - DON'T EXISTS" + "\n");
				}
				break;
			}	
				

			case (2): {

				System.out.println("Enter the name of SEASON: ");
				scn = new Scanner(System.in);
				String season2 = scn.next().toUpperCase();
				System.out.println("There are " + season2.toUpperCase() + " monthes:");

				for (Month m : arr) {
					if (m.getSeason().name().equals(season2)) {
						System.out.println("-" + m.name());
					}
				}
				break;
			}

			case (3): {

				System.out.println("Enter the number of DAYS: ");
				scn = new Scanner(System.in);
				/*Entering though console*/
				int days = scn.nextInt();

				try {
						if ((days == 28) | (days == 30) | (days == 31)) {
						System.out.println("There are monthes with " + days + " days:");
						for (Month m : arr) {
							if (m.getDays() == days)
								System.out.println("-" + m.name());
						}
					} 
					else throw new WrongInputConsoleParametersException();
				}
				/*If user entered incorrect number of days*/
				catch (WrongInputConsoleParametersException e) {
					System.err.println("You entered incorrect number of days");
				}
				
				/*Retreat in console*/
				System.out.println();
				break;
			}

			case (4): {
				/*Value for checking minimal number of days*/
				int minCountOfDays = 50;

				System.out.println("Month with the smallest amount of days: ");
				/*Searching minimal number of days*/
				for (Month m : arr) {
					if (m.getDays() < minCountOfDays)
						minCountOfDays = m.getDays();
				}
				for (Month m : arr) {
					if (m.getDays() == minCountOfDays)
						System.out.println("-" + m.name());
				}
				break;
			}

			case (5): {
				/*Value for checking maximal number of days*/
				int maxCountOfDays = 0;

				System.out.println("Month with the biggest5 amount of days: ");
				/*Searching maximal number of days*/
				for (Month m : arr) {
					if (m.getDays() > maxCountOfDays)
						maxCountOfDays = m.getDays();
				}
				/*Searching months with the same amount of days*/
				for (Month m : arr) {
					if (m.getDays() == maxCountOfDays)
						System.out.println("-" + m.name());
				}
				break;
			}
			
			case (6) : {
				/*Entering though console*/
				season = seasonScn(season);
				Season season2 = Season.valueOf(season);
				int index = season2.ordinal();
				/*Checking if this season is the last in year*/
				if(index == (sarr.length-1)) {
					System.out.println("The next season is: " + "\n" + "-" + sarr[0]);
				}
				else System.out.println("The next season is: " + "\n" + "-" + sarr[index+1]);

				break;	
			}
			
			case (7) : {
				/*Entering though console*/
				season = seasonScn(season);
				Season season2 = Season.valueOf(season);
				int index = season2.ordinal();
				/*Checking if this season is the first in year*/
				if(index == 0) {
					System.out.println("The previos season is: " + "\n" + "-" + sarr[sarr.length-1]);
				}
				else System.out.println("The previos season is: " + "\n" + "-" + sarr[index-1]);

				break;	
			}
			
			case (8) : {
				/*Searching months with even number of days*/
				System.out.println("There are months with EVEN number of days: " + "\n");
				for(Month m : arr) {
					if(m.getDays() % 2 == 0) 
						System.out.println("-" + m.name());
				}
				
				break;				
			}
			case (9) : {
				/*Searching months with odd number of days*/
				System.out.println("There are months with ODD number of days: " + "\n");
				for(Month m : arr) {
					if(m.getDays() % 2 == 1) 
						System.out.println("-" + m.name());
				}
				
				break;				
			}
			
			case (10) : {
				/*Entering though console*/
				month = monthScn(month);
				Month month2 = Month.valueOf(month);
				int index = month2.ordinal();
				/*Checking if the month has an even number of days */
				if(month2.getDays() % 2 == 0) {
					System.out.println(month2.name() + " has EVEN number of days");
				}
				else System.out.println(month2.name() + " has ODD number of days");
				
				break;
			}
			}
		}
	}
}