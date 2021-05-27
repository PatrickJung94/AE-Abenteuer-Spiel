package wwae;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class SPanel {

	private JFrame frame;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SPanel window = new SPanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public SPanel() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1600, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton stufe10_3 = new JButton("Zurück");
		JButton stufe10_3_1 = new JButton("Beenden");
		
		JButton stufe10_1 = new JButton("50/50 ");
		JButton stufe10_1_1 = new JButton("Telefon");
		JButton stufe10_1_1_1 = new JButton("Publikum");
		JButton stufe10_1_1_1_1 = new JButton("Zusatz");
		
		
		
		JButton joker1 = new JButton("New Test4");
		
		JButton joker1_1 = new JButton("New Test5");
		
		JButton joker1_2 = new JButton("New Test6");
		
		JButton joker1_2_1 = new JButton("New Test7");
		
		
		
		stufe10_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		
		
		JButton stufe1 = new JButton("Stufe 1");
		JButton stufe2 = new JButton("Stufe 2");
		JButton stufe3 = new JButton("Stufe 3");
		JButton stufe4 = new JButton("Stufe 4");
		JButton stufe5 = new JButton("Stufe 5");
		JButton stufe6 = new JButton("Stufe 6");
		JButton stufe7 = new JButton("Stufe 7");
		JButton stufe8 = new JButton("Stufe 8");
		JButton stufe9 = new JButton("Stufe 9");
		JButton stufe10 = new JButton("Stufe 10");
		
		JLabel lblNewLabel = new JLabel("New label", SwingConstants.CENTER );
		
		JProgressBar progressBar = new JProgressBar();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(stufe1, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(stufe2, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(stufe3, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(groupLayout.createSequentialGroup()
										.addContainerGap()
										.addComponent(stufe4, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup()
											.addContainerGap()
											.addComponent(stufe5, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addGroup(groupLayout.createSequentialGroup()
												.addContainerGap()
												.addComponent(stufe6, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE))
											.addGroup(groupLayout.createSequentialGroup()
												.addGap(76)
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
													.addGroup(groupLayout.createSequentialGroup()
														.addComponent(stufe10_1_1_1_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED, 983, Short.MAX_VALUE)
														.addComponent(stufe7, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE))
													.addGroup(groupLayout.createSequentialGroup()
														.addComponent(stufe10_3, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE)
														.addGap(222)
														.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
														.addComponent(stufe10_3_1, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE))
													.addGroup(groupLayout.createSequentialGroup()
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
															.addComponent(stufe10_1_1_1, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
															.addComponent(stufe10_1_1, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
														.addPreferredGap(ComponentPlacement.RELATED, 983, Short.MAX_VALUE)
														.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
															.addComponent(stufe9, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)
															.addComponent(stufe8, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)))
													.addGroup(groupLayout.createSequentialGroup()
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
															.addComponent(joker1, GroupLayout.PREFERRED_SIZE, 653, GroupLayout.PREFERRED_SIZE)
															.addComponent(joker1_2, GroupLayout.PREFERRED_SIZE, 653, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
															.addComponent(joker1_2_1, GroupLayout.PREFERRED_SIZE, 653, GroupLayout.PREFERRED_SIZE)
															.addComponent(joker1_1, GroupLayout.PREFERRED_SIZE, 653, GroupLayout.PREFERRED_SIZE)))
													.addGroup(groupLayout.createSequentialGroup()
														.addComponent(stufe10_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
														.addGap(983)
														.addComponent(stufe10, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE))
													.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1430, Short.MAX_VALUE)))))))))
					.addGap(78))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(stufe10_3, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
									.addGap(107)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(stufe10_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
										.addComponent(stufe10))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(stufe10_1_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
										.addComponent(stufe9))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(stufe10_1_1_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
										.addComponent(stufe8)))
								.addComponent(stufe10_3_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(stufe10_1_1_1_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(stufe7))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(stufe6)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(stufe5)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(stufe4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(stufe3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(stufe2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(stufe1))
						.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(143)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(joker1_1, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
						.addComponent(joker1, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(joker1_2, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
						.addComponent(joker1_2_1, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
					.addGap(20))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
