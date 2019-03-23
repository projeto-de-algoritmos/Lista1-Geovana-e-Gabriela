import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private JPanel contentPane;

	public MainFrame() {
			
		setTitle("Graphs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
			
		//Title section
		JLabel lblQuestion = new JLabel("Clique em uma célula para pintar");
		lblQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblQuestion);
		
		
		//Separating label and first table
		contentPane.add(Box.createRigidArea(new Dimension(40,40)));
			
		//Table 1
		JTable table = new JTable(40,85);
		ColoringCellRenderer cellRenderer = new ColoringCellRenderer(); 
        TableColumnModel columnModel = table.getColumnModel();
        int cc = columnModel.getColumnCount();
        for (int c=0; c<cc; c++){
            TableColumn column = columnModel.getColumn(c);
            column.setCellRenderer(cellRenderer);
        }
	    //tableObjects.setMaximumSize(new Dimension(500, 150 ));
		contentPane.add(table);
		
		
		//Mouse listener for table
		table.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int row = table.rowAtPoint(evt.getPoint());
		        int col = table.columnAtPoint(evt.getPoint());
		        if (row >= 0 && col >= 0) {
		        	cellRenderer.setCellColor(row, col, Color.GREEN);
	                table.repaint();
		        }
		    }
		});
		

	}
	
	
	
	
	


}

