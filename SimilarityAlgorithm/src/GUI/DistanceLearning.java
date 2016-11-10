/*
 * DistanceLearning.java
 *
 * Created on __DATE__, __TIME__
 */

package GUI;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import dataStruture.DataSet;

import abstractFactory.DistanceHierarchy;

import processAlgorithm.Similarity.AlgorithmSelection;
import processAlgorithm.Similarity.AlgorithmSelection.Algorithm;

/**
 *
 * @author  __USER__
 */
public class DistanceLearning extends javax.swing.JFrame {

	/** Creates new form DistanceLearning */
	public DistanceLearning() {
		initComponents();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jf = new javax.swing.JFileChooser();
		jButton1 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		lblLoader = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		lblSaver = new javax.swing.JLabel();
		jButton2 = new javax.swing.JButton();
		jLabel5 = new javax.swing.JLabel();
		txtType = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		comboxChoose = new javax.swing.JComboBox();
		jButton3 = new javax.swing.JButton();
		jProgressBar1 = new javax.swing.JProgressBar();
		jLabel2 = new javax.swing.JLabel();
		comboxChoose2 = new javax.swing.JComboBox();

		jf.setMultiSelectionEnabled(true);
		jf.setName("jf");
		jf.setOpaque(true);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 676, Short.MAX_VALUE)
						.addGroup(
								jPanel1Layout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												jPanel1Layout
														.createSequentialGroup()
														.addGap(0, 0,
																Short.MAX_VALUE)
														.addComponent(
																jf,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(0, 0,
																Short.MAX_VALUE))));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 398, Short.MAX_VALUE)
						.addGroup(
								jPanel1Layout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												jPanel1Layout
														.createSequentialGroup()
														.addGap(0, 0,
																Short.MAX_VALUE)
														.addComponent(
																jf,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(0, 0,
																Short.MAX_VALUE))));

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("\u81ea\u52d5\u5efa\u6a39");

		jButton1.setText("Open");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jLabel1.setText("\u76ee\u6a19\u8cc7\u6599\u96c6");

		lblLoader.setText("null");

		jLabel3.setText("\u5132\u5b58\u8cc7\u6599\u593e");

		lblSaver.setText("null");

		jButton2.setText("Open");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jLabel5.setText("\u8cc7\u6599\u578b\u614b");

		txtType.addAncestorListener(new javax.swing.event.AncestorListener() {
			public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
				txtTypeAncestorMoved(evt);
			}

			public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
			}

			public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
			}
		});

		jLabel6.setText("\u8ddd\u96e2\u6f14\u7b97\u6cd5");

		comboxChoose.setModel(new javax.swing.DefaultComboBoxModel(
				new Algorithm[] { Algorithm.DISC, Algorithm.mDILCA,
						Algorithm.DILCA, Algorithm.COFC, Algorithm.DISC2,
						Algorithm.DISC3 }));

		jButton3.setText("\u8a13\u7df4\u958b\u59cb");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jLabel2.setText("\u968e\u5c64\u6f14\u7b97\u6cd5");

		comboxChoose2.setModel(new javax.swing.DefaultComboBoxModel(
				new Algorithm[] { Algorithm.SingleLinkage,
						Algorithm.AverageLinkage }));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				false)
																				.addComponent(
																						jLabel6,
																						javax.swing.GroupLayout.Alignment.LEADING,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(
																						jLabel5,
																						javax.swing.GroupLayout.Alignment.LEADING,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(
																						jLabel3,
																						javax.swing.GroupLayout.Alignment.LEADING,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(
																						jLabel1,
																						javax.swing.GroupLayout.Alignment.LEADING,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING,
																												false)
																												.addComponent(
																														txtType)
																												.addComponent(
																														lblSaver,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														Short.MAX_VALUE)
																												.addComponent(
																														lblLoader,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														280,
																														Short.MAX_VALUE))
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																										247,
																										Short.MAX_VALUE)
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.TRAILING)
																												.addComponent(
																														jButton1)
																												.addComponent(
																														jButton2,
																														javax.swing.GroupLayout.PREFERRED_SIZE,
																														65,
																														javax.swing.GroupLayout.PREFERRED_SIZE)))
																				.addGroup(
																						layout.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								false)
																								.addComponent(
																										comboxChoose2,
																										javax.swing.GroupLayout.Alignment.LEADING,
																										0,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)
																								.addComponent(
																										comboxChoose,
																										javax.swing.GroupLayout.Alignment.LEADING,
																										0,
																										133,
																										Short.MAX_VALUE))))
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addComponent(
																		jProgressBar1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		263,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		272,
																		Short.MAX_VALUE)
																.addComponent(
																		jButton3,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		129,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addComponent(jLabel2))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														jLabel1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														30,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(lblLoader)
												.addComponent(jButton1))
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel3)
												.addComponent(lblSaver)
												.addComponent(jButton2))
								.addGap(31, 31, 31)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel5)
												.addComponent(
														txtType,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(28, 28, 28)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														jLabel6,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														32,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														comboxChoose,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														27,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(26, 26, 26)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel2)
												.addComponent(
														comboxChoose2,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(146, 146, 146)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(
														jButton3,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														46,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jProgressBar1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														22,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap()));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

		if (evt.getSource() == jButton2) {
			jf.setSelectedFile(new File("請選擇資料夾"));
			int returnVal = jf.showSaveDialog(jPanel1);
			if (returnVal == JFileChooser.APPROVE_OPTION) {

				this.lblSaver.setText(new String(jf
						.getSelectedFile()
						.getPath()
						.substring(
								0,
								jf.getSelectedFile().getPath()
										.lastIndexOf("\\") + 1)));
				System.out.print(new String(jf
						.getSelectedFile()
						.getPath()
						.substring(
								0,
								jf.getSelectedFile().getPath()
										.lastIndexOf("\\") + 1)));
			}
		}
	}

	private void txtTypeAncestorMoved(javax.swing.event.AncestorEvent evt) {
		// TODO add your handling code here:
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		Integer chk = 0;
		if (lblLoader.getText().equals("null"))
			chk = 1;
		if (lblSaver.getText().equals("null"))
			chk = 1;
		if (txtType.getText().equals(""))
			chk = 1;
		if (comboxChoose.getSelectedItem() == null)
			chk = 1;
		if (comboxChoose2.getSelectedItem() == null)
			chk = 1;

		if (chk == 1)
			JOptionPane.showMessageDialog(null, "ff", "error",
					JOptionPane.ERROR_MESSAGE);

		else {

			System.out.print("STart");
			DistanceHierarchy DH = new DistanceHierarchy();
			DH.setDataSetType(new DataSet(
					turnType(txtType.getText().split(","))));
			DH.setInput(lblLoader.getText());
			DH.setOutput(lblSaver.getText());
			DH.setLinkageAlgoritm((Algorithm) comboxChoose2.getSelectedItem());
			DH.setSimilarityAlgorithm((Algorithm) comboxChoose
					.getSelectedItem());
			DH.start();
			System.out.print("End");
		}
	}

	private int[] turnType(String input[]) {
		int[] output = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			output[i] = Integer.parseInt(input[i]);
		}
		return output;
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		//	jf.showOpenDialog(jPanel1);
		if (evt.getSource() == jButton1) {
			int returnVal = jf.showOpenDialog(jPanel1);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				this.lblLoader.setText(jf.getSelectedFile().getPath());

			}
		}

	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new DistanceLearning().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JComboBox comboxChoose;
	private javax.swing.JComboBox comboxChoose2;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JProgressBar jProgressBar1;
	private javax.swing.JFileChooser jf;
	private javax.swing.JLabel lblLoader;
	private javax.swing.JLabel lblSaver;
	private javax.swing.JTextField txtType;
	// End of variables declaration//GEN-END:variables

}