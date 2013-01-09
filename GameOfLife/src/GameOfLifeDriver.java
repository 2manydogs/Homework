import java.io.IOException;
import java.util.Scanner;
public class GameOfLifeDriver 
{
	public static void main(String[] args)  throws IOException
	{
		Scanner initializer = new Scanner(System.in);
		int totalRows = 0;
		int totalCols = 0;
		
		//System.out.println("Welcome to the Game of Life.");
		//System.out.println("Your choices for building the initial grid is as follows:");
		//System.out.println("\t(R)andom Grid\n\t (F)ile Input\n\t (P)rebuilt Grid");
		//System.out.println("\nPlease input your choice:");
		
		//String input = initializer.next();
		//if(input.equalsIgnoreCase("R"))
		
		//System.out.println("Please input how many rows you would like to have:");
		//int rows = initializer.nextInt();
		
	//	System.out.println("Please input how many columns you would like to have:");
		//int cols = initializer.nextInt();
		
		//totalRows = rows;
		//totalCols = cols;
		
		//Life aGame = new Life(totalRows, totalCols);
		
		// original
		//Life theGame = new Life(30, 30);
		Life theGame = new Life(10, 10);
		
		// initial game
		theGame.randomBuild(); //initialGrid();
		//System.out.println(theGame.toString());	
		//theGame.nextGeneration();
		System.out.println(theGame.toString());		
		//****
		for (int gen = 0; gen <= 15; gen++)
		{
			theGame.nextGeneration();
			System.out.println(theGame.toString());
			System.out.println("=========================");
		}
		//******/			
	}

}
