package Jframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Connection.connection;
import model.HangHoa;
import model.KhachHang;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CategoryCustomerForm extends JFrame {
	private JPanel contentPane;
	private JTextField txtMaKhach;
	private JTextField txtTenKhach;
	private JTextField txtDiaChi;
	private JTextField txtDienThoai;
	private JTable table;
	
	private Connection conn;
	private PreparedStatement ptmt = null;
	private ArrayList<KhachHang>arrayListKhachHang = new ArrayList<KhachHang>();
	private int row;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CategoryCustomerForm frame = new CategoryCustomerForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//------------------------------------------------------HAMF DONG FROM-------------------------------------
		public void close() {
			//AWTEvent winClosingEvent;
			WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
			Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
		}

	/**
	 * Create the frame.
	 */
	public CategoryCustomerForm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 819, 635);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(107, 142, 35));
		setLocationRelativeTo(null);//hiển thị chính giữa màn hình
		setResizable(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DANH M\u1EE4C KH\u00C1CH H\u00C0NG");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 33, 775, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblMNhnVin = new JLabel("M\u00E3 Kh\u00E1ch");
		lblMNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMNhnVin.setForeground(new Color(255, 255, 255));
		lblMNhnVin.setBounds(22, 98, 111, 27);
		contentPane.add(lblMNhnVin);
		
		txtMaKhach = new JTextField();
		txtMaKhach.setBounds(134, 96, 200, 32);
		contentPane.add(txtMaKhach);
		txtMaKhach.setColumns(10);
		
		JLabel lblMNhnVin_1 = new JLabel("T\u00EAn Kh\u00E1ch");
		lblMNhnVin_1.setForeground(Color.WHITE);
		lblMNhnVin_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMNhnVin_1.setBounds(22, 165, 111, 27);
		contentPane.add(lblMNhnVin_1);
		
		txtTenKhach = new JTextField();
		txtTenKhach.setColumns(10);
		txtTenKhach.setBounds(134, 163, 200, 32);
		contentPane.add(txtTenKhach);
		
		JLabel lblMNhnVin_2 = new JLabel("Địa Chỉ");
		lblMNhnVin_2.setForeground(Color.WHITE);
		lblMNhnVin_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMNhnVin_2.setBounds(440, 100, 111, 27);
		contentPane.add(lblMNhnVin_2);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(552, 98, 213, 32);
		contentPane.add(txtDiaChi);
		
		JLabel lblMNhnVin_3 = new JLabel("Điện Thoại");
		lblMNhnVin_3.setForeground(Color.WHITE);
		lblMNhnVin_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMNhnVin_3.setBounds(440, 168, 111, 27);
		contentPane.add(lblMNhnVin_3);
		
		txtDienThoai = new JTextField();
		txtDienThoai.setColumns(10);
		txtDienThoai.setBounds(552, 166, 213, 32);
		contentPane.add(txtDienThoai);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 523, 730, -203);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 conn = new connection().ketnoi();
					String sql = "INSERT INTO `khachhang`(`MaKhach`, `TenKhach`, `SoDienThoai`, `DiaChi`) VALUES (?,?,?,?)";
					
					try {
						ptmt = conn.prepareStatement(sql);
						try {
							ptmt.setString(1, txtMaKhach.getText().toString());
							ptmt.setString(2, txtTenKhach.getText().toString());							
							ptmt.setString(3, txtDienThoai.getText().toString());							
							ptmt.setString(4, txtDiaChi.getText().toString());						
							ptmt.executeUpdate();
							showData();
						} catch (Exception e2) {
							JOptionPane.showConfirmDialog(null, "Vui Lòng Kiểm Tra Lại Dữ Liêu", "câu hõi", JOptionPane.YES_OPTION);
						}
					} catch (SQLException e1) {
						JOptionPane.showConfirmDialog(null, "Vui Lòng Kiểm Tra Lại Dữ Liêu", "câu hõi", JOptionPane.YES_OPTION);
						e1.printStackTrace();
					}
					
					
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon(CategoryStaffForm.class.getResource("/img/ic_add.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(22, 523, 103, 39);
		contentPane.add(btnNewButton);
		
		JButton btnXo = new JButton("Xoá");
		btnXo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conn = new connection().ketnoi();
				String sql = "DELETE FROM `khachhang` WHERE MaKhach = ?";
				try {
					ptmt = conn.prepareStatement(sql);
					try {
						ptmt.setString(1, txtMaKhach.getText().toString());
						ptmt.execute();
						showData();
					} catch (Exception e2) {
						JOptionPane.showConfirmDialog(null, "Vui Lòng Kiểm Tra Lại Dữ Liêu", "câu hõi", JOptionPane.YES_OPTION);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnXo.setIcon(new ImageIcon(CategoryStaffForm.class.getResource("/img/ic_delete.png")));
		btnXo.setHorizontalAlignment(SwingConstants.LEFT);
		btnXo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXo.setBounds(151, 523, 103, 39);
		contentPane.add(btnXo);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		btnSa.setIcon(new ImageIcon(CategoryStaffForm.class.getResource("/img/ic_update.png")));
		btnSa.setHorizontalAlignment(SwingConstants.LEFT);
		btnSa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSa.setBounds(280, 523, 103, 39);
		contentPane.add(btnSa);
		
		JButton btnLu = new JButton("Lưu");
		btnLu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		btnLu.setIcon(new ImageIcon(CategoryStaffForm.class.getResource("/img/ic_save.png")));
		btnLu.setHorizontalAlignment(SwingConstants.LEFT);
		btnLu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLu.setBounds(414, 523, 103, 39);
		contentPane.add(btnLu);
		
		JButton btnBQua = new JButton("Bỏ Qua");
		btnBQua.setIcon(new ImageIcon(CategoryStaffForm.class.getResource("/img/ic_ingnone.png")));
		btnBQua.setHorizontalAlignment(SwingConstants.LEFT);
		btnBQua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBQua.setBounds(538, 523, 103, 39);
		contentPane.add(btnBQua);
		
		JButton btnng = new JButton("Đóng");
		btnng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManagerForm().main(null);
				close();
			}
		});
		btnng.setIcon(new ImageIcon(CategoryStaffForm.class.getResource("/img/ic_off.png")));
		btnng.setHorizontalAlignment(SwingConstants.LEFT);
		btnng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnng.setBounds(662, 523, 103, 39);
		contentPane.add(btnng);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(22, 263, 745, 215);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
				row=table.getSelectedRow();
				txtMaKhach.setText(defaultTableModel.getValueAt(row, 0).toString());
				txtTenKhach.setText(defaultTableModel.getValueAt(row, 1).toString());
				txtDienThoai.setText(defaultTableModel.getValueAt(row, 2).toString());
				txtDiaChi.setText(defaultTableModel.getValueAt(row, 0).toString());
			}
		});
	
		scrollPane_1.setViewportView(table);
		showData();
	}
	
	private void showData() {
		arrayListKhachHang.clear();
		conn = new connection().ketnoi();
		try {
			ptmt = conn.prepareStatement("SELECT * FROM `khachhang`");
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				String maKhach = rs.getString("MaKhach");
				String tenKhach = rs.getString("TenKhach");
				String soDienThoai = rs.getString("SoDienThoai");
		        String diaChi=rs.getString("DiaChi");
		        
				KhachHang khachHang = new KhachHang(maKhach, tenKhach, soDienThoai, diaChi);
				arrayListKhachHang.add(khachHang);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table.removeAll();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("MaKhach");
		model.addColumn("TenKhach");
		model.addColumn("SoDienThoai");
		model.addColumn("DiaChi");
		
		for (KhachHang khachHang : arrayListKhachHang) {
			model.addRow(khachHang.toarray());
		}
		
		table.setModel(model);
	}
	
	private void update() {
		String sql = "UPDATE `khachhang` SET `TenKhach`=?,`SoDienThoai`=?,`DiaChi`=? WHERE `MaKhach`=?";
		conn = new connection().ketnoi();
		try {
			ptmt = conn.prepareStatement(sql);
			try {
				ptmt.setString(1, txtTenKhach.getText().toString());
				ptmt.setString(2, txtDienThoai.getText().toString());
				ptmt.setString(3, txtDiaChi.getText().toString());
				ptmt.setString(4, txtMaKhach.getText().toString());
				ptmt.executeUpdate();
				showData();
			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, "Vui Lòng Kiểm Tra Lại Dữ Liêu", "câu hõi", JOptionPane.YES_OPTION);
			}
		} catch (SQLException e) {
			JOptionPane.showConfirmDialog(null, "Vui Lòng Kiểm Tra Lại Dữ Liêu", "câu hõi", JOptionPane.YES_OPTION);
			e.printStackTrace();
		}
	}

}
