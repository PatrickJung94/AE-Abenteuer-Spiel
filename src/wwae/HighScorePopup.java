package wwae;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
public class HighScorePopup extends JFrame {
	
	public HighScorePopup(ArrayList<Rank> data,int x, int y, int locationX , int locationY) {
		super("HighScorePopup");
		setSize(x, y);
		setUndecorated(true);
		setLocation(locationX, locationY);

		JLabel titel = new JLabel("Highscore", SwingConstants.CENTER);
		JScrollPane scrollPane = new JScrollPane();
		JPanel titlePanel = new JPanel();
		JLabel iconLabel= new JLabel();
		JPanel scrollPanel = new JPanel();
		JTable personTable = new JTable();
		MyRenderer cellRenderer = new MyRenderer();
		Font titleFont = new Font("Arial", Font.BOLD,(int) (getWidth()/15));
		Font tableFont = new Font("Consolas", Font.BOLD, (int) (getWidth()/41.5));
		Color backgroundColor = new Color(220,220,220);
		Color fontColor = new Color(0, 0, 0);
		Color arrayColor = new Color(131, 150, 247);
		String dir = System.getProperty("user.dir");
		ImageIcon closeIcon = new ImageIcon(dir+"\\images\\close.PNG");
		Image image = closeIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		closeIcon = new ImageIcon(newimg);  // transform it back
		DefaultTableModel model = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		};

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
			}
		});

		// sytle
		// setLocationRelativeTo(null);
		
		titlePanel.setBackground(backgroundColor);
		scrollPanel.setBackground(backgroundColor);
		titel.setForeground(fontColor);
		titel.setFont(titleFont);
		personTable.setModel(model);
		personTable.setFont(tableFont);
		personTable.getTableHeader().setFont(tableFont);
		titel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0, 0, 0)));
		iconLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 2,0, new Color(0, 0, 0)));
	
		iconLabel.setLayout(new GridBagLayout());
		iconLabel.setPreferredSize(new Dimension(30,20));
		iconLabel.setIcon(closeIcon);
		 HighScorePopup _this=this;
		
		iconLabel.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				iconLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent evt) {
				_this.dispatchEvent(new WindowEvent(_this, WindowEvent.WINDOW_CLOSING));
			}
		});
		/* Array ausf�llen */
		// add column to Array
		model.addColumn("Rang");
		model.addColumn("Name");
		model.addColumn("Punkte");
		model.addColumn("Datum");
		
		// add Element to Array List
		for (int i = 0; i < data.size(); i++) {
			model.addRow(new Object[0]);
			model.setValueAt(i + 1, i, 0);
			model.setValueAt(data.get(i).getName(), i, 1);
			model.setValueAt(data.get(i).getScore(), i, 2);
			model.setValueAt(data.get(i).getTimestamp(), i, 3);
		}

		// add Table to scroll Panel
		scrollPane.setViewportView(personTable);

		personTable.getTableHeader().setBackground(arrayColor);
		personTable.getColumnModel().getColumn(0).setPreferredWidth(getWidth() - (getWidth() - 7));
		personTable.getColumnModel().getColumn(1).setPreferredWidth((int)(getWidth()/4.5));
		personTable.getColumnModel().getColumn(2).setPreferredWidth((int)(getWidth()/5.5));
		personTable.getColumnModel().getColumn(3).setPreferredWidth((int)(getWidth()/5));
		
		cellRenderer.setHorizontalAlignment(JLabel.CENTER);
		personTable.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
		personTable.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
		personTable.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
		personTable.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
		personTable.setRowHeight((int)(getHeight()/15));
		titel.setPreferredSize(new Dimension(getWidth() - 20, getHeight()/6));
		scrollPane.setPreferredSize(new Dimension(getWidth() - 30,  (int)(getHeight()/1.4)));
		
		titlePanel.setLayout(new BorderLayout());
		titlePanel.add(BorderLayout.CENTER,titel);
		titlePanel.add(BorderLayout.EAST ,iconLabel);
		scrollPanel.add(scrollPane);
		setLayout(new BorderLayout());
		add(BorderLayout.NORTH, titlePanel);
		add(BorderLayout.CENTER, scrollPanel);
		
	}


	public class MyRenderer extends DefaultTableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			setBorder(noFocusBorder);
			Color arrayColor = new Color(194, 207, 255);
			setBackground(arrayColor);

			return this;
		}

	}

}
