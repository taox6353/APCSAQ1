package unit14turnin;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Maze
{
   private int[][] maze;
   private int[][] usedmaze;
   private int found;

	public Maze()
	{
		maze = new int[0][0];
	}

	public Maze(int size, String line)
	{
		found = 0;
		Scanner scan = new Scanner(line);
		maze = new int[size][size];
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				maze[i][j]=scan.nextInt();
			}
		}
		usedmaze = new int[size][size];
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				usedmaze[i][j]=maze[i][j];
			}
		}
	}

	public boolean hasExitPath(int r, int c)
	{
		if(r>=0&&r<usedmaze.length&&c>=0&&c<usedmaze.length&&usedmaze[r][c]==1){
			usedmaze[r][c]=2;
			if(c>=usedmaze.length-1){
				found=1;
				return true;
			}
			else
				hasExitPath(r-1,c);//up
				hasExitPath(r+1,c);//down
				hasExitPath(r,c-1);//left
				hasExitPath(r,c+1);//right
		}
		return false;
		
	}

	public String toString()
	{
		String output="";
		
		for(int i=0;i<maze.length;i++){
			for(int j=0;j<maze.length;j++){
				output = output + maze[i][j];
			}
			output = output + "\n";
		}

		if(found==1)
			output = output + "exit found\n";
		else if(found==0)
			output = output + "exit not found\n";
		
		return output;
	}
}