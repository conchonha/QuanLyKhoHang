package Jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Connection.connection;
import model.KhachHang;
import model.NhanVien;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CategoryStaffForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaNhanVien;
	private JTextField txtTenNhanVien;
	private JTextField txtDiaChi;
	private JTextField txtDienThoai;
	private JTextField txtNgaySinh;
	private JTable table;
	
	private Connection conn;
	private PreparedStatement ptmt = null;
	private ArrayList<NhanVien>arrayListNhanVien = new ArrayList<NhanVien>();
	private int row;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CategoryStaffForm frame = new CategoryStaffForm();
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
			
	public CategoryStaffForm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 805, 651);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(107, 142, 35));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);//hiển thị chính giữa màn hình
		setResizable(false);
		contentPane.setLayout(null);
		
		JCheckBox chckbxNam = new JCheckBox("Nam");
		chckbxNam.setBounds(134, 245, 113, 25);
		contentPane.add(chckbxNam);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 298, 740, 218);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
				row=table.getSelectedRow();
				txtMaNhanVien.setText(defaultTableModel.getValueAt(row, 0).toString());
				txtTenNhanVien.setText(defaultTableModel.getValueAt(row, 1).toString());
				String gt = defaultTableModel.getValueAt(row, 2).toString();
				if(gt.equals("Nam")) {
					chckbxNam.setSelected(true);
				}else {
					chckbxNam.setSelected(false);
				}
				txtDiaChi.setText(defaultTableModel.getValueAt(row, 3).toString());
				txtDienThoai.setText(defaultTableModel.getValueAt(row, 4).toString());
				txtNgaySinh.setText(defaultTableModel.getValueAt(row, 5).toString());
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("DANH MỤC NHÂN VIÊN");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 33, 775, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblMNhnVin = new JLabel("Mã Nhân Viên");
		lblMNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMNhnVin.setForeground(new Color(255, 255, 255));
		lblMNhnVin.setBounds(22, 98, 111, 27);
		contentPane.add(lblMNhnVin);
		
		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setBounds(134, 96, 200, 32);
		contentPane.add(txtMaNhanVien);
		txtMaNhanVien.setColumns(10);
		
		JLabel lblMNhnVin_1 = new JLabel("Tên Nhân Viên");
		lblMNhnVin_1.setForeground(Color.WHITE);
		lblMNhnVin_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMNhnVin_1.setBounds(22, 156, 111, 27);
		contentPane.add(lblMNhnVin_1);
		
		txtTenNhanVien = new JTextField();
		txtTenNhanVien.setColumns(10);
		txtTenNhanVien.setBounds(134, 154, 200, 32);
		contentPane.add(txtTenNhanVien);
		
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
		
		JLabel lblMNhnVin_4 = new JLabel("Ngày Sinh");
		lblMNhnVin_4.setForeground(Color.WHITE);
		lblMNhnVin_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMNhnVin_4.setBounds(440, 237, 111, 27);
		contentPane.add(lblMNhnVin_4);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setText("yyy-mm-dd");
		txtNgaySinh.setToolTipText("yyyy-mm-dd");
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(552, 235, 213, 32);
		contentPane.add(txtNgaySinh);
		
		JLabel lblMNhnVin_1_1 = new JLabel("Giới Tính");
		lblMNhnVin_1_1.setForeground(Color.WHITE);
		lblMNhnVin_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMNhnVin_1_1.setBounds(22, 243, 111, 27);
		contentPane.add(lblMNhnVin_1_1);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gt = "";
				if(chckbxNam.isSelected()) {
					gt = "Nam";
				}else {
					gt = "Nữ";
				}
				conn = new connection().ketnoi();
				String sql = "INSERT INTO `nhanvien`(`MaNhanVien`, `TenNhanVien`, `GioiTinh`, `DiaChi`, `SoDienThoai`, `NgaySinh`)"
						+ " VALUES (?,?,?,?,?,?)";
				
				try {
					ptmt = conn.prepareStatement(sql);
					try {
						ptmt.setString(1, txtMaNhanVien.getText().toString());
						ptmt.setString(2, txtTenNhanVien.getText().toString());							
						ptmt.setString(3, gt);							
						ptmt.setString(4, txtDiaChi.getText().toString());	
						ptmt.setString(5, txtDienThoai.getText().toString());	
						ptmt.setString(6, txtNgaySinh.getText().toString());	
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
		btnNewButton.setBounds(22, 549, 103, 39);
		contentPane.add(btnNewButton);
		
		JButton btnXo = new JButton("Xoá");
		btnXo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				conn = new connection().ketnoi();
				String sql = "DELETE FROM `nhanvien` WHERE MaNhanVien = ?";
				try {
					ptmt = conn.prepareStatement(sql);
					try {
						ptmt.setString(1, txtMaNhanVien.getText().toString());
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
		btnXo.setBounds(151, 549, 103, 39);
		contentPane.add(btnXo);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNam.isSelected()) {
					update("Nam");
				}else {
					update("Nữ");
				}
				
			}
		});
		btnSa.setIcon(new ImageIcon(CategoryStaffForm.class.getResource("/img/ic_update.png")));
		btnSa.setHorizontalAlignment(SwingConstants.LEFT);
		btnSa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSa.setBounds(280, 549, 103, 39);
		contentPane.add(btnSa);
		
		JButton btnLu = new JButton("Lưu");
		btnLu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNam.isSelected()) {
					update("Nam");
				}else {
					update("Nữ");
				}
			}
		});
		btnLu.setIcon(new ImageIcon(CategoryStaffForm.class.getResource("/img/ic_save.png")));
		btnLu.setHorizontalAlignment(SwingConstants.LEFT);
		btnLu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLu.setBounds(414, 549, 103, 39);
		contentPane.add(btnLu);
		
		JButton btnBQua = new JButton("Bỏ Qua");
		btnBQua.setIcon(new ImageIcon(CategoryStaffForm.class.getResource("/img/ic_ingnone.png")));
		btnBQua.setHorizontalAlignment(SwingConstants.LEFT);
		btnBQua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBQua.setBounds(538, 549, 103, 39);
		contentPane.add(btnBQua);
		
		JButton btnng = new JButton("Đóng");
		btnng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerForm info = new ManagerForm();
				info.setVisible(true);
				close();
			}
		});
		btnng.setIcon(new ImageIcon(CategoryStaffForm.class.getResource("/img/ic_off.png")));
		btnng.setHorizontalAlignment(SwingConstants.LEFT);
		btnng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnng.setBounds(662, 549, 103, 39);
		contentPane.add(btnng);
		
		showData();
	}
	
	private void showData() {
		arrayListNhanVien.clear();
		conn = new connection().ketnoi();
		try {
			ptmt = conn.prepareStatement("SELECT * FROM `nhanvien`");
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				String maNhanVien = rs.getString("MaNhanVien");
				String tenNhanVien = rs.getString("TenNhanVien");
				String gioiTinh = rs.getString("GioiTinh");
		        String diaChi=rs.getString("DiaChi");
		        String soDienThoai=rs.getString("SoDienThoai");
		        String ngaySinh=rs.getString("NgaySinh");
		        
				NhanVien nhanVien = new NhanVien(maNhanVien, tenNhanVien, gioiTinh, diaChi, soDienThoai, ngaySinh);
				arrayListNhanVien.add(nhanVien);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table.removeAll();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("MaNhanVien");
		model.addColumn("TenNhanVien");
		model.addColumn("GioiTinh");
		model.addColumn("DiaChi");
		model.addColumn("SoDienThoai");
		model.addColumn("NgaySinh");
		
		for (NhanVien nhanVien : arrayListNhanVien) {
			model.addRow(nhanVien.toarray());
		}
		
		table.setModel(model);
	}
	
	private void update(String gioitinh) {
		String sql = "UPDATE `nhanvien` SET `TenNhanVien`=?,`GioiTinh`=?,`DiaChi`=?,`SoDienThoai`=?,`NgaySinh`=? WHERE `MaNhanVien`=?";
		conn = new connection().ketnoi();
		try {
			ptmt = conn.prepareStatement(sql);
			try {
				ptmt.setString(1, txtTenNhanVien.getText().toString());
				ptmt.setString(2, gioitinh);
				ptmt.setString(3, txtDiaChi.getText().toString());
				ptmt.setString(4, txtDienThoai.getText().toString());
				ptmt.setString(5, txtNgaySinh.getText().toString());
				ptmt.setString(6, txtMaNhanVien.getText().toString());
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
