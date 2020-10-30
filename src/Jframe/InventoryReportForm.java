package Jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InventoryReportForm extends JFrame {


	private JPanel contentPane;
	private JTextField txtSoluongcon;
	private JTable tableBaocao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryReportForm frame = new InventoryReportForm();
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
	public void close() {
		//AWTEvent winClosingEvent;
		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
	
	public InventoryReportForm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 999, 642);
		contentPane = new JPanel();
	
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);//hiển thị chính giữa màn hình
		setResizable(false);//không thể thay đổi kích cỡ giao diện khi chạy chương trình
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTieude = new JLabel("B\u00C1O C\u00C1O H\u00C0NG T\u1ED2N");
		lblTieude.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTieude.setBounds(363, 13, 246, 53);
		contentPane.add(lblTieude);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Chi ti\u1EBFt", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(34, 85, 858, 134);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTenhang = new JLabel("T\u00EAn h\u00E0ng");
		lblTenhang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenhang.setBounds(10, 26, 70, 29);
		panel.add(lblTenhang);
		
		JLabel lblSoluongcon = new JLabel("S\u1ED1 l\u01B0\u1EE3ng c\u00F2n");
		lblSoluongcon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSoluongcon.setBounds(511, 26, 92, 29);
		panel.add(lblSoluongcon);
		
		txtSoluongcon = new JTextField();
		txtSoluongcon.setBounds(613, 26, 200, 29);
		panel.add(txtSoluongcon);
		txtSoluongcon.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(92, 30, 159, 22);
		panel.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 244, 855, 222);
		contentPane.add(scrollPane);
		
		tableBaocao = new JTable();
		scrollPane.setViewportView(tableBaocao);
		
		JButton btnBaocao = new JButton("B\u00E1o c\u00E1o");
		btnBaocao.setIcon(new ImageIcon(InventoryReportForm.class.getResource("/img/ic_report.png")));
		btnBaocao.setBounds(82, 487, 164, 48);
		contentPane.add(btnBaocao);
		
		JButton btnInbaocao = new JButton("In b\u00E1o c\u00E1o");
		btnInbaocao.setIcon(new ImageIcon(InventoryReportForm.class.getResource("/img/ic_printf.png")));
		btnInbaocao.setBounds(407, 487, 125, 48);
		contentPane.add(btnInbaocao);
		
		JButton btnDong = new JButton("\u0110\u00F3ng");
		btnDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManagerForm().main(null);
				close();
			}
		});
		btnDong.setIcon(new ImageIcon(InventoryReportForm.class.getResource("/img/ic_off.png")));
		btnDong.setBounds(704, 487, 142, 48);
		contentPane.add(btnDong);
	
	}

}
