package Jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchBillexportForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchBillexportForm frame = new SearchBillexportForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	//------------------------------------------------------HAMF DONG FROM-------------------------------------
		public void close() {
			//AWTEvent winClosingEvent;
			WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
			Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
		}
		
	public SearchBillexportForm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 849, 683);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(107, 142, 35));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);//hiển thị chính giữa màn hình
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T\u00CCM KI\u1EBEM PHI\u1EBEU XU\u1EA4T");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 36, 807, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E3 Phi\u1EBFu Xu\u1EA5t");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(60, 104, 98, 16);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(170, 101, 156, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Th\u00E1ng");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setBounds(60, 158, 98, 16);
		contentPane.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(170, 155, 98, 22);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("N\u0103m");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setBounds(298, 158, 46, 16);
		contentPane.add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(356, 156, 98, 22);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("M\u00E3 Nh\u00E2n Vi\u00EAn");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(60, 215, 98, 16);
		contentPane.add(lblNewLabel_1_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(170, 212, 156, 22);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("M\u00E3 Kh\u00E1ch H\u00E0ng");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(541, 101, 98, 16);
		contentPane.add(lblNewLabel_1_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(651, 98, 156, 22);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_1_4 = new JLabel("T\u1ED5ng Ti\u1EC1n");
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(541, 172, 98, 16);
		contentPane.add(lblNewLabel_1_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(651, 169, 156, 22);
		contentPane.add(textField_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 286, 748, 210);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("K\u00EDch \u0111\u00FAp m\u1ED9t ho\u00E1 \u0111\u01A1n \u0111\u1EC3 hi\u1EC3n th\u1ECB th\u00F4ng tin chi ti\u1EBFt");
		lblNewLabel_1_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1.setBounds(60, 530, 323, 16);
		contentPane.add(lblNewLabel_1_2_1_1);
		
		JButton btnTm = new JButton("T\u00ECm");
		btnTm.setBounds(110, 583, 97, 25);
		contentPane.add(btnTm);
		
		JButton btnTmLi = new JButton("T\u00ECm L\u1EA1i");
		btnTmLi.setBounds(389, 583, 97, 25);
		contentPane.add(btnTmLi);
		
		JButton btnng = new JButton("\u0110\u00F3ng");
		btnng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManagerForm().main(null);
				close();
			}
		});
		btnng.setBounds(660, 583, 97, 25);
		contentPane.add(btnng);
	}
}
