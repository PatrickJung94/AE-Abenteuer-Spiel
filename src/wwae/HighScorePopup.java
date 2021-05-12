package wwae;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

public class HighScorePopup extends JFrame {

	public HighScorePopup(String data[]) {
		super("HighScorePopup");
		JLabel titel = new JLabel("TOP 20 SCORES", SwingConstants.CENTER);
		JScrollPane scrollPane = new JScrollPane();
		JPanel titlePanel = new JPanel();
		JPanel scrollPanel = new JPanel();
		JTable personTable = new JTable();
		MyRenderer cellRenderer = new MyRenderer();
		Font titleFont = new Font("Comic Sans MS", Font.BOLD, 30);
		Font tableFont = new Font("Microsoft YaHei", Font.BOLD, 10);
		Color backgroundColor = new Color(0, 165, 147);
		Color schriftColor = new Color(0, 91, 127);
		Color arrayColor = new Color(202, 234, 172);

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
				setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 50, 50));
			}
		});

		// sytle
		// setLocationRelativeTo(null);
		setUndecorated(true);
		setLocation(450, 150);
		setSize(400, 500);

		titlePanel.setBackground(backgroundColor);
		scrollPanel.setBackground(backgroundColor);
		titel.setForeground(schriftColor);
		titel.setFont(titleFont);
		personTable.setModel(model);
		personTable.setFont(tableFont);
		personTable.getTableHeader().setFont(tableFont);
		titel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0, 0, 0)));
		scrollPane.setPreferredSize(new Dimension(getWidth() - 30, 350));
		/* Array ausf�llen */
		// add column to Array
		model.addColumn("Rang");
		model.addColumn("Name");
		model.addColumn("Punkte");
		model.addColumn("Datum");
		// add Element to Array List
		int j = 0;
		for (int i = 0; i < data.length; i++) {
			model.addRow(new Object[0]);
			model.setValueAt(j + 1, j, 0);
			model.setValueAt(data[i], j, 1);
			model.setValueAt(data[i + 1], j, 2);
			model.setValueAt(data[i + 2], j, 3);

			i = i + 2;
			j++;
		}

		// add Table to scroll Panel
		scrollPane.setViewportView(personTable);

		personTable.getTableHeader().setBackground(arrayColor);
		titel.setPreferredSize(new Dimension(30, 10));
		personTable.getColumnModel().getColumn(0).setPreferredWidth(getWidth() - (getWidth() - 7));
		personTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		personTable.getColumnModel().getColumn(2).setPreferredWidth(70);
		personTable.getColumnModel().getColumn(3).setPreferredWidth(90);
		
		cellRenderer.setHorizontalAlignment(JLabel.CENTER);
		personTable.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
		personTable.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
		personTable.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
		personTable.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
		personTable.setRowHeight(30);
		titel.setPreferredSize(new Dimension(getWidth() - 20, 100));
		titlePanel.setLayout(new FlowLayout());
		titlePanel.add(titel);

		scrollPanel.add(scrollPane);
		
		setLayout(new BorderLayout());
		add(BorderLayout.NORTH, titlePanel);
		add(BorderLayout.CENTER, scrollPanel);
		setBackground(new Color(202, 234, 172));
	}

	public class MyRenderer extends DefaultTableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			setBorder(noFocusBorder);
			Color arrayColor = new Color(202, 234, 172);
			setBackground(arrayColor);

			return this;
		}

	}

	public static void main(String[] args) {
		String data[] = { "omss  ssss sar1aas", "10098222830", "2021-10-10 13:30", "omar2", "200", "2021-10-10 13:30",
				"omar3", "300", "2021-10-10 13:30", "omar4", "400", "2021-10-10 13:30", "omar5", "500",
				"2021-10-10 12:30", "omar6", "600", "2021-10-10 12:30", "omar7", "700", "2021-10-10 12:30", "omar8",
				"800", "2021-10-10 12:30", "omar9", "900", "2021-10-10 12:30", "omar10", "1000", "2021-10-12 10:30",
				"omar1", "1000", "2021-10-12 10:30", "omar2", "200", "2021-10-12 10:30", "omar3", "300",
				"2021-10-12 10:30", "omar4", "400", "2021-10-12 10:30", "omar5", "500", "2021-10-12 10:30", "omar6",
				"600", "2021-10-12 10:30", "omar7", "700", "2021-10-12 10:30", "omar8", "800", "2021-10-12 10:30",
				"omar9", "900", "2021-10-12 10:30", "omar10", "1000", "2021-10-12 10:30" };
		HighScorePopup highScore = new HighScorePopup(data);
		highScore.setVisible(true);
	}

}
