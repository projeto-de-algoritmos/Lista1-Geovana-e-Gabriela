import java.awt.Color;
import java.awt.Point;
import java.util.LinkedList;

import javax.swing.JTable;


// Reference: http://www.thecshandbook.com/Flood_Fill
class Graph{ 
	
    public void FloodFillBFS(
    		int x, int y, Color buttonColorClicked, int width, int height,
    			ColoringCellRenderer cellRenderer, JTable table, Color newColor) {
    	boolean visited[][] = new boolean[width][height];
    	
    	LinkedList<Point> queue = new LinkedList<Point>();
    	queue.push(new Point(x, y));
    	
    	while (queue.isEmpty() == false) {
    		Point currentPoint = queue.pop();
    		
		    if (currentPoint.x < 0 || currentPoint.x >= width || currentPoint.y < 0 || currentPoint.y >= height) {
		      continue;
		    }
		    
		    if (visited[currentPoint.x][currentPoint.y]) {
		      continue;
		    }
		    
		    visited[currentPoint.x][currentPoint.y] = true;    
		    Color cellColor = cellRenderer.getCellColor(currentPoint.x, currentPoint.y);
		    if (cellColor != buttonColorClicked) {
			      continue;
			}
		    
		    cellRenderer.setCellColor(currentPoint.x, currentPoint.y, newColor);
		    
		    queue.push(new Point(currentPoint.x + 1, currentPoint.y));
		    queue.push(new Point(currentPoint.x - 1, currentPoint.y));
		    queue.push(new Point(currentPoint.x, currentPoint.y + 1));
		    queue.push(new Point(currentPoint.x, currentPoint.y - 1));
		}
    	table.repaint();
    }
}