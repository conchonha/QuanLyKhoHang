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

public class RevenueReportForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtDoanhthu;
	private JTable tableDanhthu;
	private JTextField txtLoinhuan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RevenueReportForm frame = new RevenueReportForm();
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
	public RevenueReportForm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 688, 554);
		contentPane = new JPanel();
		setLocationRelativeTo(null);//hiển thị chính giữa màn hình
		setResizable(false);//không thể thay đổi kích cỡ giao diện khi chạy chương trình
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTieude = new JLabel("T\u1ED4NG DOANH THU B\u00C1N H\u00C0NG THEO TH\u1EDCI GIAN");
		lblTieude.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTieude.setBounds(118, 11, 439, 63);
		contentPane.add(lblTieude);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Danh thu", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(29, 85, 608, 145);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTheothang = new JLabel("Theo th\u00E1ng");
		lblTheothang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTheothang.setBounds(10, 26, 87, 29);
		panel.add(lblTheothang);
		
		JComboBox cbbTheothang = new JComboBox();
		cbbTheothang.setBounds(107, 26, 107, 26);
		panel.add(cbbTheothang);
		
		JLabel lblSoluongcon = new JLabel("Doanh thu");
		lblSoluongcon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSoluongcon.setBounds(333, 26, 92, 29);
		panel.add(lblSoluongcon);
		
		txtDoanhthu = new JTextField();
		txtDoanhthu.setBounds(435, 26, 132, 29);
		panel.add(txtDoanhthu);
		txtDoanhthu.setColumns(10);
		
		JLabel lblTheoquy = new JLabel("Theo qu\u00FD");
		lblTheoquy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTheoquy.setBounds(10, 66, 70, 29);
		panel.add(lblTheoquy);
		
		JComboBox cbbTheoquy = new JComboBox();
		cbbTheoquy.setBounds(107, 66, 107, 26);
		panel.add(cbbTheoquy);
		
		JLabel lblTheonam = new JLabel("Theo n\u0103m");
		lblTheonam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTheonam.setBounds(10, 105, 70, 29);
		panel.add(lblTheonam);
		
		JComboBox cbbTheonam = new JComboBox();
		cbbTheonam.setBounds(107, 105, 125, 26);
		panel.add(cbbTheonam);
		
		txtLoinhuan = new JTextField();
		txtLoinhuan.setColumns(10);
		txtLoinhuan.setBounds(435, 66, 132, 29);
		panel.add(txtLoinhuan);
		
		JLabel lblLoinhuan = new JLabel("L\u1EE3i nhu\u1EADn");
		lblLoinhuan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLoinhuan.setBounds(333, 66, 92, 29);
		panel.add(lblLoinhuan);
		
		JLabel lblText = new JLabel("Doanh thu, l\u1EE3i nhu\u1EADn t\u00EDnh theo s\u1ED1 s\u1EA3n ph\u1EA9m \u0111\u00E3 b\u00E1n \u0111\u01B0\u1EE3c ");
		lblText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblText.setBounds(242, 105, 356, 29);
		panel.add(lblText);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 241, 608, 155);
		contentPane.add(scrollPane);
		
		tableDanhthu = new JTable();
		scrollPane.setViewportView(tableDanhthu);
		
		JButton btnBaocao = new JButton("B\u00E1o c\u00E1o");
		btnBaocao.setIcon(new ImageIcon(RevenueReportForm.class.getResource("/img/ic_license.png")));
		btnBaocao.setBounds(53, 407, 113, 48);
		contentPane.add(btnBaocao);
		
		JButton btnBoqua = new JButton("B\u1ECF qua");
		btnBoqua.setIcon(new ImageIcon(RevenueReportForm.class.getResource("/img/ic_ingnone.png")));
		btnBoqua.setBounds(376, 407, 107, 48);
		contentPane.add(btnBoqua);
		
		JButton btnThoat = new JButton("Tho\u00E1t");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManagerForm().main(null);
				close();
			}
		});
		btnThoat.setIcon(new ImageIcon(RevenueReportForm.class.getResource("/img/ic_off.png")));
		btnThoat.setBounds(530, 407, 107, 48);
		contentPane.add(btnThoat);
		
		JButton btnInbaocao = new JButton("In b\u00E1o c\u00E1o");
		btnInbaocao.setIcon(new ImageIcon(RevenueReportForm.class.getResource("/img/ic_printf.png")));
		btnInbaocao.setBounds(209, 409, 129, 48);
		contentPane.add(btnInbaocao);
	}

}
