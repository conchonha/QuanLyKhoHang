package Jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PromissoryPaymentForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PromissoryPaymentForm frame = new PromissoryPaymentForm();
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
		
	public PromissoryPaymentForm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1033, 857);
		contentPane = new JPanel();
		setLocationRelativeTo(null);//hiển thị chính giữa màn hình
		setResizable(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Phi\u1EBFu Chi");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 13, 979, 34);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Th\u00F4ng tin chung", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(78, 61, 890, 170);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Phiếu Chi");
		lblNewLabel_1.setBounds(47, 30, 89, 16);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(187, 24, 154, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã Nhà Cung Cấp");
		lblNewLabel_1_1.setBounds(47, 78, 128, 16);
		panel.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(187, 72, 154, 22);
		panel.add(textField_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tên Nhà Cung Cấp");
		lblNewLabel_1_2.setBounds(47, 127, 89, 16);
		panel.add(lblNewLabel_1_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(187, 121, 154, 22);
		panel.add(textField_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Mã Phiếu Nhập");
		lblNewLabel_1_3.setBounds(505, 32, 89, 16);
		panel.add(lblNewLabel_1_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(606, 29, 168, 22);
		panel.add(textField_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Ngày Tháng");
		lblNewLabel_1_3_1.setBounds(505, 77, 89, 16);
		panel.add(lblNewLabel_1_3_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(606, 74, 100, 22);
		panel.add(textField_4);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(736, 76, 38, 20);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Th\u00F4ng tin c\u00E1c m\u1EB7t h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(78, 288, 890, 404);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 48, 786, 195);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2 = new JLabel("Kích đúp một dòng hàng để xoá");
		lblNewLabel_2.setBounds(71, 269, 254, 16);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Tổng tiền");
		lblNewLabel_1_2_1.setBounds(590, 266, 68, 22);
		panel_1.add(lblNewLabel_1_2_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(670, 266, 167, 22);
		panel_1.add(textField_5);
		
		JLabel lblNewLabel_2_1 = new JLabel("Bằng chữ");
		lblNewLabel_2_1.setBounds(71, 326, 88, 16);
		panel_1.add(lblNewLabel_2_1);
		
		JButton btnNewButton_1 = new JButton("Thêm Hoá Đơn");
		btnNewButton_1.setIcon(new ImageIcon(PromissoryPaymentForm.class.getResource("/img/ic_add.png")));
		btnNewButton_1.setBounds(154, 326, 155, 48);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_1_2 = new JButton("Lưu");
		btnNewButton_1_2.setIcon(new ImageIcon(PromissoryPaymentForm.class.getResource("/img/ic_save.png")));
		btnNewButton_1_2.setBounds(314, 326, 101, 48);
		panel_1.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("Huỷ Hoá Đơn");
		btnNewButton_1_3.setIcon(new ImageIcon(PromissoryPaymentForm.class.getResource("/img/ic_delete.png")));
		btnNewButton_1_3.setBounds(419, 326, 143, 48);
		panel_1.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_3_1 = new JButton("In Hoá Đơn");
		btnNewButton_1_3_1.setIcon(new ImageIcon(PromissoryPaymentForm.class.getResource("/img/ic_printf.png")));
		btnNewButton_1_3_1.setBounds(574, 326, 133, 48);
		panel_1.add(btnNewButton_1_3_1);
		
		JButton btnNewButton_1_3_1_1 = new JButton("Đóng");
		btnNewButton_1_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManagerForm().main(null);
				close();
			}
		});
		btnNewButton_1_3_1_1.setIcon(new ImageIcon(PromissoryPaymentForm.class.getResource("/img/ic_off.png")));
		btnNewButton_1_3_1_1.setBounds(719, 326, 118, 48);
		panel_1.add(btnNewButton_1_3_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Mã Hoá Đơn");
		lblNewLabel_2_1_1.setBounds(32, 731, 88, 16);
		contentPane.add(lblNewLabel_2_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(123, 728, 155, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton_1_3_1_1_1 = new JButton("Tìm Kiếm");
		btnNewButton_1_3_1_1_1.setIcon(new ImageIcon(PromissoryPaymentForm.class.getResource("/img/ic_search.png")));
		btnNewButton_1_3_1_1_1.setBounds(310, 727, 123, 34);
		contentPane.add(btnNewButton_1_3_1_1_1);
	}
}
