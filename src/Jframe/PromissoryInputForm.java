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
import javax.swing.border.TitledBorder;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PromissoryInputForm extends JFrame {
	private JPanel contentPane;
	private JTextField txtMaphieuxuat;
	private JTextField txtNgayban;
	private JTextField txtTennhanvien;
	private JTextField txtDienthoai;
	private JTextField txtDiachi;
	private JTextField txtTenkhachhang;
	private JTextField txtSoluong;
	private JTextField txtTenhang;
	private JTextField txtGiamgia;
	private JTextField txtDongia;
	private JTextField txtThanhtien;
	private JTextField txtTongtien;
	private JTable tablePhieuxuat;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PromissoryInputForm frame = new PromissoryInputForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close() {
		//AWTEvent winClosingEvent;
		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}

	/**
	 * Create the frame.
	 */
	public PromissoryInputForm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 886, 832);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(107, 142, 35));
		contentPane.setForeground(new Color(107, 142, 35));
		setLocationRelativeTo(null);//hiển thị chính giữa màn hình
		setResizable(false);//không thể thay đổi kích cỡ giao diện khi chạy chương trình
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPhiuXutHng = new JLabel("PHIẾU NHẬP KHO");
		lblPhiuXutHng.setForeground(new Color(255, 255, 255));
		lblPhiuXutHng.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhiuXutHng.setBounds(331, 13, 270, 66);
		contentPane.add(lblPhiuXutHng);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(107, 142, 35));
		panel1.setBorder(new TitledBorder(null, "Th\u00F4ng tin chung", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel1.setBounds(40, 71, 792, 219);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JLabel lblPhieuxuat = new JLabel("Mã Hoá Đơn");
		lblPhieuxuat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhieuxuat.setBounds(10, 44, 98, 27);
		panel1.add(lblPhieuxuat);
		
		txtMaphieuxuat = new JTextField();
		txtMaphieuxuat.setBounds(118, 44, 143, 25);
		panel1.add(txtMaphieuxuat);
		txtMaphieuxuat.setColumns(10);
		
		JLabel lblNgayban = new JLabel("Ngày Nhập");
		lblNgayban.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgayban.setBounds(10, 82, 98, 27);
		panel1.add(lblNgayban);
		
		JButton btnNgayban = new JButton("...");
		btnNgayban.setBounds(233, 80, 28, 27);
		panel1.add(btnNgayban);
		
		JLabel lblManhanvien = new JLabel("M\u00E3 nh\u00E2n vi\u00EAn");
		lblManhanvien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblManhanvien.setBounds(10, 117, 98, 27);
		panel1.add(lblManhanvien);
		
		JComboBox cbbManhanvien = new JComboBox();
		cbbManhanvien.setBounds(118, 120, 143, 25);
		panel1.add(cbbManhanvien);
		
		txtNgayban = new JTextField();
		txtNgayban.setColumns(10);
		txtNgayban.setBounds(118, 80, 113, 25);
		panel1.add(txtNgayban);
		
		txtTennhanvien = new JTextField();
		txtTennhanvien.setColumns(10);
		txtTennhanvien.setBounds(118, 158, 143, 25);
		panel1.add(txtTennhanvien);
		
		JLabel lblTennhanvien = new JLabel("T\u00EAn nh\u00E2n vi\u00EAn");
		lblTennhanvien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTennhanvien.setBounds(10, 156, 98, 27);
		panel1.add(lblTennhanvien);
		
		txtDienthoai = new JTextField();
		txtDienthoai.setColumns(10);
		txtDienthoai.setBounds(591, 156, 143, 25);
		panel1.add(txtDienthoai);
		
		JLabel lblDienthoai = new JLabel("\u0110i\u1EC7n tho\u1EA1i");
		lblDienthoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDienthoai.setBounds(479, 158, 80, 27);
		panel1.add(lblDienthoai);
		
		txtDiachi = new JTextField();
		txtDiachi.setColumns(10);
		txtDiachi.setBounds(591, 118, 143, 25);
		panel1.add(txtDiachi);
		
		JLabel lblDiachi = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblDiachi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiachi.setBounds(479, 120, 80, 27);
		panel1.add(lblDiachi);
		
		txtTenkhachhang = new JTextField();
		txtTenkhachhang.setColumns(10);
		txtTenkhachhang.setBounds(591, 83, 143, 25);
		panel1.add(txtTenkhachhang);
		
		JLabel lblTenkhachhang = new JLabel("Tên Nhà Cung Cấp");
		lblTenkhachhang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenkhachhang.setBounds(479, 82, 102, 27);
		panel1.add(lblTenkhachhang);
		
		JComboBox cbbMakhachhang = new JComboBox();
		cbbMakhachhang.setBounds(591, 45, 143, 25);
		panel1.add(cbbMakhachhang);
		
		JLabel lblMakhachhang = new JLabel("Mã Nhà Cung Cấp");
		lblMakhachhang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMakhachhang.setBounds(479, 44, 102, 27);
		panel1.add(lblMakhachhang);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(107, 142, 35));
		panel2.setBorder(new TitledBorder(null, "Th\u00F4ng tin c\u00E1c m\u1EB7t h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel2.setBounds(24, 318, 808, 431);
		contentPane.add(panel2);
		panel2.setLayout(null);
		
		JComboBox cbbMahang = new JComboBox();
		cbbMahang.setBounds(102, 28, 96, 25);
		panel2.add(cbbMahang);
		
		JLabel lblMahang = new JLabel("M\u00E3 h\u00E0ng");
		lblMahang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMahang.setBounds(24, 28, 80, 27);
		panel2.add(lblMahang);
		
		txtSoluong = new JTextField();
		txtSoluong.setColumns(10);
		txtSoluong.setBounds(102, 64, 96, 25);
		panel2.add(txtSoluong);
		
		JLabel lblSoluong = new JLabel("S\u1ED1 l\u01B0\u1EE3ng");
		lblSoluong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSoluong.setBounds(23, 64, 80, 27);
		panel2.add(lblSoluong);
		
		txtTenhang = new JTextField();
		txtTenhang.setColumns(10);
		txtTenhang.setBounds(411, 28, 80, 25);
		panel2.add(txtTenhang);
		
		JLabel lblTenhang = new JLabel("T\u00EAn h\u00E0ng");
		lblTenhang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenhang.setBounds(330, 28, 80, 27);
		panel2.add(lblTenhang);
		
		txtGiamgia = new JTextField();
		txtGiamgia.setColumns(10);
		txtGiamgia.setBounds(411, 64, 80, 25);
		panel2.add(txtGiamgia);
		
		JLabel lblMHan_3_1_2 = new JLabel("Gi\u1EA3m gi\u00E1 %");
		lblMHan_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMHan_3_1_2.setBounds(330, 61, 80, 27);
		panel2.add(lblMHan_3_1_2);
		
		txtDongia = new JTextField();
		txtDongia.setColumns(10);
		txtDongia.setBounds(702, 29, 80, 25);
		panel2.add(txtDongia);
		
		JLabel lblDongia = new JLabel("\u0110\u01A1n gi\u00E1");
		lblDongia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDongia.setBounds(624, 28, 80, 27);
		panel2.add(lblDongia);
		
		txtThanhtien = new JTextField();
		txtThanhtien.setColumns(10);
		txtThanhtien.setBounds(702, 67, 80, 25);
		panel2.add(txtThanhtien);
		
		JLabel lblMHan_3_1_3_1 = new JLabel("Th\u00E0nh ti\u1EC1n");
		lblMHan_3_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMHan_3_1_3_1.setBounds(624, 66, 80, 27);
		panel2.add(lblMHan_3_1_3_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 109, 772, 183);
		panel2.add(scrollPane);
		
		tablePhieuxuat = new JTable();
		scrollPane.setViewportView(tablePhieuxuat);
		
		JLabel lblKich = new JLabel("K\u00EDch \u0111\u00FAng m\u1ED9t d\u00F2ng \u0111\u1EC3 x\u00F3a");
		lblKich.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblKich.setBounds(10, 303, 188, 25);
		panel2.add(lblKich);
		
		JLabel lblTongtien = new JLabel("T\u1ED5ng ti\u1EC1n");
		lblTongtien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTongtien.setBounds(569, 305, 71, 25);
		panel2.add(lblTongtien);
		
		txtTongtien = new JTextField();
		txtTongtien.setColumns(10);
		txtTongtien.setBounds(650, 305, 132, 25);
		panel2.add(txtTongtien);
		
		JLabel lblBangchu = new JLabel("B\u1EB1ng ch\u1EEF: ");
		lblBangchu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBangchu.setBounds(10, 331, 71, 25);
		panel2.add(lblBangchu);
		
		JButton btnThem = new JButton("Th\u00EAm H\u00F3a \u0110\u01A1n");
		btnThem.setIcon(new ImageIcon(PromissoryInputForm.class.getResource("/img/ic_add.png")));
		btnThem.setBounds(34, 367, 164, 42);
		panel2.add(btnThem);
		
		JButton btnLuu = new JButton("L\u01B0u");
		btnLuu.setIcon(new ImageIcon(PromissoryInputForm.class.getResource("/img/ic_save.png")));
		btnLuu.setBounds(224, 367, 106, 42);
		panel2.add(btnLuu);
		
		JButton btnHuy = new JButton("H\u1EE7y h\u00F3a \u0111\u01A1n");
		btnHuy.setIcon(new ImageIcon(PromissoryInputForm.class.getResource("/img/ic_delete.png")));
		btnHuy.setBounds(355, 367, 139, 42);
		panel2.add(btnHuy);
		
		JButton btnIn = new JButton("In h\u00F3a \u0111\u01A1n");
		btnIn.setIcon(new ImageIcon(PromissoryInputForm.class.getResource("/img/ic_printf.png")));
		btnIn.setBounds(519, 367, 132, 42);
		panel2.add(btnIn);
		
		JButton btnDong = new JButton("\u0110\u00F3ng");
		btnDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManagerForm().main(null);
				close();
			}
		});
		btnDong.setIcon(new ImageIcon(PromissoryInputForm.class.getResource("/img/ic_off.png")));
		btnDong.setBounds(672, 367, 110, 42);
		panel2.add(btnDong);
	}

}
