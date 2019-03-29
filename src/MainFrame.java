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
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	
	Color newColor;
	JButton currentBtn;

	public MainFrame() {
			
		setTitle("Graphs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(false);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
			
		//Title section
		JLabel lblQuestion = new JLabel(
				"Escolha uma cor e clique em uma célula para pintar"
		);
		lblQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblQuestion);
		
		
		//Separating label and buttons
		contentPane.add(Box.createRigidArea(new Dimension(10,10)));
		
		//Buttons section
		JPanel buttonsPane = new JPanel();
		JButton buttonBlack = new JButton("Preto");
		JButton buttonPurple = new JButton("Roxo");
		JButton buttonGray = new JButton("Cinza");
		newColor = Color.BLACK;
		currentBtn = buttonBlack;
		buttonBlack.setEnabled(false);
		buttonsPane.add(buttonBlack);
		buttonsPane.add(buttonPurple);
		buttonsPane.add(buttonGray);
		contentPane.add(buttonsPane);
		
			
		//Table 1
		JTable table = new JTable(40,85);
		ColoringCellRenderer cellRenderer = new ColoringCellRenderer(); 
        TableColumnModel columnModel = table.getColumnModel();
        int cc = columnModel.getColumnCount();
        for (int c=0; c<cc; c++){
            TableColumn column = columnModel.getColumn(c);
            column.setCellRenderer(cellRenderer);
        }
		contentPane.add(table);
		
		
		//Buttons listeners
		buttonBlack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonBlack.setEnabled(false);
				currentBtn.setEnabled(true); 
				currentBtn = buttonBlack;
				newColor = Color.BLACK;
				
			}
		});
		
		buttonPurple.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonPurple.setEnabled(false);
				currentBtn.setEnabled(true);
				currentBtn = buttonPurple;
				newColor = Color.MAGENTA;
				
			}
		});
		
		buttonGray.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonGray.setEnabled(false);
				currentBtn.setEnabled(true);
				currentBtn = buttonGray;
				newColor = Color.GRAY;
				
			}
		});
		
		
		//Mouse listener for table
		table.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int row = table.rowAtPoint(evt.getPoint());
		        int col = table.columnAtPoint(evt.getPoint());
		        
		        Color cellColor = cellRenderer.getCellColor(row, col);  
		       
		        Graph graph = new Graph();		    
		        graph.FloodFillBFS(row, col, cellColor, 40, 85, cellRenderer, table, newColor); 
		        
		    }
		});		

	}
	
	
	
	
	


}

