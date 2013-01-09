
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class Life
{
	private int columns;
	private int rows;
	private Boolean[][] theGrid;
	private Boolean[][] initialGrid;

	public Life (int rowCount, int columnCount)
	{
		rows = rowCount;
		columns = columnCount;
		initialGrid = new Boolean[rows][columns];
		theGrid = new Boolean[rows][columns];
		
		for (int x = 0; x < rows; x++)
		{
			for (int y = 0; y < columns; y++)
			{
				initialGrid[x][y] = false;
				theGrid[x][y] = false;
			}
		}
	}

	public void randomBuild()
	{
		Random alive = new Random();
		
		for (int row = 0; row < rows; row++)
		{
			for (int col = 0; col < columns; col++)
			{
				int which = alive.nextInt(3);
				
				if (which == 0 || which == 1)
				{
					initialGrid [row][col] = false;
				}
				else 
				{
					initialGrid [row][col] = true;
				}
			}
		}
	}

	public void fileInput() throws IOException
	{
		String pathToFile = "//Users//imdisturbedlol//Desktop//WORKSPACE//GameOfLife.java";  
		File inFile = new File(pathToFile, "FileOne.txt");
		Scanner inData= new Scanner(inFile);
		
		String aString = "";	
			while (inData.hasNextLine())
			{
					aString = inData.next();
				for ( int p = 0; p < aString.length(); p++)
				{
					for (int i = 0; i < rows; i++)
					{
						for (int c = 0; c < columns; c++)
						{
							if (aString.substring(p, p + 1).equals("*"))
							{
								initialGrid[i][c] = true;
							}
							else
								initialGrid[i][c] = false;
						}
					}
				}
			}
	}

		

public void userInput(int howManyLines)
{
		Scanner input = new Scanner(System.in);
		String str = "";
		
		
	for (int i = 0; i < howManyLines; i++)	
	{
		boolean done = false;
		while (!done)
		{
			System.out.println("Please enter line " + i);
			String line = input.next();
		for (int h = 0; h < line.length(); h ++)
		{
			for (int r = 0; r < rows; r++)
			{
				for (int c = 0; c < columns; c++)
				{
					if (line.substring(h, h + 1).equals("*"))
					{
						initialGrid[r][c] = true;
					}
					if (line.substring(h, h + 1).equals("_"))
						initialGrid[r][c] = false;				
				}
			}
		}
		done = true;	
		}
	}
		
}
	
/* original
public void nextGeneration()
{	
	for (int row = 0; row < rows; row++)
	{
		for(int col = 0; col < columns; col++)
		{
			int neighborCount = 0;
			
			if (row > 0 && initialGrid[row - 1][col])
			{
				neighborCount++;
			}
			if ((row < rows - 1) && initialGrid[row + 1][col])
			{
				neighborCount++;
			}
			if (col > 0 && initialGrid[row][col - 1])
			{
				neighborCount++;
			}
			if (row > 0 && col > 0 && initialGrid[row - 1][col - 1])
			{
				neighborCount++;
			}
			if (row < rows - 1 && col > 0 && initialGrid[row + 1][col - 1])
			{
				neighborCount++;
			}
			if (row > 0 && col < columns - 1 && initialGrid[row][col + 1])
			{
				neighborCount++;
			}
			if (row < rows - 1 && col < columns - 1 && initialGrid[row + 1][col + 1])
			{
				neighborCount++;
			}
			if (row < rows - 1 && col > 0 && initialGrid[row + 1][col - 1])
			{
				neighborCount++;
			}
			
			if (neighborCount < 2 || neighborCount > 3)
			{
				theGrid[row][col] = false;
			}
			if (neighborCount == 3)
			{
				theGrid[row][col] = true;
			}
		}
	}	
	
	initialGrid = theGrid;
}
*/

public void nextGeneration()
{
	for (int row = 0; row < rows; row++)
	{
		for (int col = 0; col < columns; col++)
		{
			int neighborCount = 0;
			
			// above
			if (row > 0 && initialGrid[row - 1][col] == true)
			{
				neighborCount++;
			}
			
			// below
			if ((row + 1 < rows) && initialGrid[row + 1][col] == true)
			{
				neighborCount++;
			}
			
			// left
			if ((col > 0) && initialGrid[row][col - 1] == true)
			{
				neighborCount++;
			}
			
			// right
			if ((col + 1 < columns) && initialGrid[row][col + 1] == true)
			{
				neighborCount++;
			}			
			
			// above, left
			if ((row > 0) && (col > 0) && initialGrid[row - 1][col - 1] == true)
			{
				neighborCount++;
			}
			
			// below, left
			if ((row + 1 < rows) && (col > 0) && initialGrid[row + 1][col - 1] == true)
			{
				neighborCount++;
			}
			
			// above, right
			if ((row > 0) && (col + 1 < columns) && initialGrid[row - 1][col + 1] == true)
			{
				neighborCount++;
			}
			
			// below, right
			if ((row + 1 < rows) && (col + 1 < columns) && initialGrid[row + 1][col + 1] == true)
			{
				neighborCount++;
			}
			
			// evaluate neighbors for this cell
			if (neighborCount < 2 || neighborCount > 3)
			{
				theGrid[row][col] = false;
			}
			
			if (neighborCount == 3)
			{
				theGrid[row][col] = true;
			}
		}		
	}	
	
	initialGrid = theGrid.clone();
}


public String toString()
{
	String board = "";
	
	for (int r = 0; r  < rows; r++)
	{
		for (int c = 0; c < columns; c++)
		{
			if (c % columns == 0)
			{
				board = board +"\n";
			}
			
			if (initialGrid[r][c] != null && initialGrid[r][c] == false)
			{
				board = board + "|   |";					
			}
			else 
			{
				board = board + "| * |";
			}				
		}
		
	}
	
	return board;
}

/*	original
	public String toString()
	{
		String board = "";
		
		for (int r = 0; r  < rows; r++)
		{
			for (int c = 0; c < columns; c++)
			{
				if (c % columns == 0)
				{
					board = board +"\n";
				}
				
				if (initialGrid[r][c] != null && initialGrid[r][c] == false)
				{
					board = board + " ";					
				}
				else 
				{
					board = board + "*"; 		
				}				
			}	
		}	
		return board;
	}

*/

	public void initialGrid()
	{
		int r = rows / 3;
		int c = columns / 3;
		
		for (int a = 0; a < rows; a++)
		{
			for (int b = 0; b < columns; b++)
			{
				initialGrid[a][b] = false;
			}
		}
		
		initialGrid[r][c + 3] = initialGrid[r][c + 8] = true;
		initialGrid[r + 1][c + 1] = initialGrid[r + 1][c + 2] = true;	
		initialGrid[r + 1][c + 9] = initialGrid[r + 1][c + 10] = true;	
		initialGrid[r + 1][c + 4] = initialGrid[r + 1][c + 5] = true;	
		initialGrid[r + 1][c + 6] = initialGrid[r + 1][c + 7] = true;
		initialGrid[r + 2][c + 3] = initialGrid[r + 2][c + 8] = true;
	}
}


/******	
public void nextGeneration()
{
	
	
	for (int row = 0; row < rows; row++)
	{
		for(int col = 0; col < columns; col++)
		{
			int neighborCount = 0;
			
			if (row > 0 && initialGrid[row - 1][col])
			{
				neighborCount++;
			}
			if ((row < rows - 1) && initialGrid[row + 1][col])
			{
				neighborCount++;
			}
			if (col > 0 && initialGrid[row][col - 1])
			{
				neighborCount++;
			}
			if (row > 0 && col > 0 && initialGrid[row - 1][col - 1])
			{
				neighborCount++;
			}
			if (row < rows - 1 && col > 0 && initialGrid[row + 1][col - 1])
			{
				neighborCount++;
			}
			if (row > 0 && col < columns - 1 && initialGrid[row][col + 1])
			{
				neighborCount++;
			}
			if (row < rows - 1 && col < columns - 1 && initialGrid[row + 1][col + 1])
			{
				neighborCount++;
			}
			if (row < rows - 1 && col > 0 && initialGrid[row + 1][col - 1])
			{
				neighborCount++;
			}
			
			if (neighborCount < 2 || neighborCount > 3)
			{
				theGrid[row][col] = false;
			}
			if (neighborCount == 3)
			{
				theGrid[row][col] = true;
			}
		}
	}	
	
	initialGrid = theGrid;
}
*****/



/*******
public void nextGeneration()
{
	for (int row = 0; row < rows; row++)
	{
		for (int col = 0; col < columns; col++)
		{
			int neighborCount = 0;
			
			// above
			if (row > 0 && initialGrid[row - 1][col] == true)
			{
				neighborCount++;
			}
			
			// below
			if ((row + 1 < rows) && initialGrid[row + 1][col] == true)
			{
				neighborCount++;
			}
			
			// left
			if ((col > 0) && initialGrid[row][col - 1] == true)
			{
				neighborCount++;
			}
			
			// right
			if ((col + 1 < columns) && initialGrid[row][col + 1] == true)
			{
				neighborCount++;
			}			
			
			// above, left
			if ((row > 0) && (col > 0) && initialGrid[row - 1][col - 1] == true)
			{
				neighborCount++;
			}
			
			// below, left
			if ((row + 1 < rows) && (col > 0) && initialGrid[row + 1][col - 1] == true)
			{
				neighborCount++;
			}
			
			// above, right
			if ((row > 0) && (col + 1 < columns) && initialGrid[row - 1][col + 1] == true)
			{
				neighborCount++;
			}
			
			// below, right
			if ((row + 1 < rows) && (col + 1 < columns) && initialGrid[row + 1][col + 1] == true)
			{
				neighborCount++;
			}
			
			// evaluate neighbors for this cell
			if (neighborCount < 2 || neighborCount > 3)
			{
				theGrid[row][col] = false;
			}
			
			if (neighborCount == 3)
			{
				theGrid[row][col] = true;
			}
		}		
	}	
	
	initialGrid = theGrid;
}
***/