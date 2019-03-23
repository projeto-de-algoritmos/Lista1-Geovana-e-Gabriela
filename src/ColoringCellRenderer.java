import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

@SuppressWarnings("serial")
class ColoringCellRenderer extends DefaultTableCellRenderer{
	private final Map<Point, Color> cellColors = new HashMap<Point, Color>();
	
	void setCellColor(int r, int c, Color color){
	    
		if (color == null)
	        cellColors.remove(new Point(r,c));
	    else
	        cellColors.put(new Point(r,c), color);
	
	}
	
	public Color getCellColor(int r, int c){
	    Color color = cellColors.get(new Point(r,c));
	    Random rand = new Random();
	   
	    if (color == null) {
	    	int clrNum = rand.nextInt(3);
	        
	    	if(clrNum == 0) 
	        	color = Color.RED;
	    	else if(clrNum == 1) 
	        	color = Color.BLUE;
	        else 
	        	color = Color.YELLOW;
			    
	    	
	    	setCellColor(r,c,color);
		}
	    
	    return color;
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
	    boolean isSelected, boolean hasFocus, int row, int column){
	    	super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	    
	    Color color = getCellColor(row, column);
	    setBackground(color);
	    return this;
	}

}
