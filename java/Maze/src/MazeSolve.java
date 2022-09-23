import java.awt.Point;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class MazeSolve
{
	public int [][] maze;
	public PointInMaze [] [] Pmaze;
	
	public void solve(int [][] mazex) 
	{
		Queue<PointInMaze> q = new ArrayDeque<PointInMaze>();
		maze = mazex;
		Pmaze = new PointInMaze[maze.length][maze[0].length];
		for(int i = 0 ;i < 40 ; i++)
		{
			for(int j =0 ; j < 40 ; j++)
			{
				Pmaze[i][j] = new PointInMaze();
				Pmaze[i][j].x = j;
				Pmaze[i][j].y = i;
				Pmaze[i][j].count_walk = 0 ;
				Pmaze[i][j].visited = false;
				if(maze[i][j] == -10)
				{
					Pmaze[i][j].isValid = false;
				}else {
					Pmaze[i][j].isValid = true;
				}
			
			}
		}
		
		PointInMaze start = Pmaze[0][0];
		PointInMaze end = Pmaze[maze.length-1][maze[0].length-1];
		
		q.offer(start);
		start.visited = true;
		while(q.size()>0)
		{
			PointInMaze now = q.poll();
			now.visited = true;
			if(now.x > 0 && Pmaze[now.y][now.x-1].isValid && Pmaze[now.y][now.x-1].visited)
			{
				Pmaze[now.y][now.x-1].prev = now;
				Pmaze[now.y][now.x-1].count_walk = now.count_walk+1;
				q.offer(Pmaze[now.y][now.x-1]);
				PointInMaze next = Pmaze[now.y][now.x-1];
				next.visited = true;
				if(next == end) {
					break;
				}
			}
			if(now.y > 0 && Pmaze[now.y-1][now.x].isValid && Pmaze[now.y-1][now.x].visited)
			{
				Pmaze[now.y-1][now.x].prev = now;
				Pmaze[now.y-1][now.x].count_walk = now.count_walk+1;
				q.offer(Pmaze[now.y-1][now.x]);
				PointInMaze next = Pmaze[now.y-1][now.x];
				next.visited = true;
				if(next == end) {
					break;
				}
			}
			if(now.x < mazex[0].length-1 && Pmaze[now.y][now.x+1].isValid && Pmaze[now.y][now.x+1].visited)
			{
				Pmaze[now.y][now.x+1].prev = now;
				Pmaze[now.y][now.x+1].count_walk = now.count_walk+1;
				q.offer(Pmaze[now.y][now.x+1]);
				PointInMaze next = Pmaze[now.y][now.x+1];
				next.visited = true;
				if(next == end) {
					break;
				}
			}
			if(now.y < mazex[0].length-1 && Pmaze[now.y+1][now.x].isValid && Pmaze[now.y+1][now.x].visited)
			{
				Pmaze[now.y+1][now.x].prev = now;
				Pmaze[now.y+1][now.x].count_walk = now.count_walk+1;
				q.offer(Pmaze[now.y+1][now.x]);
				PointInMaze next = Pmaze[now.y+1][now.x];
				next.visited = true;
				if(next == end) {
					break;
				}
			}
		}
		PointInMaze ee =end;
		while(ee.prev != null && ee != start) {
			System.out.println(ee.y+" "+ee.x);
			mazex[ee.y][ee.x]= 1;
			ee = ee.prev;
		}
	}
	
	public MazeSolve()
	{
		// TODO Auto-generated constructor stub
	}

}

class PointInMaze
{
	public int x, y, count_walk ;
	public PointInMaze prev;
	public boolean isValid;
	public boolean visited;
}
