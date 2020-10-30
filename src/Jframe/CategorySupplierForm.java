package Jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Connection.connection;
import model.KhachHang;
import model.NhaCungCap;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CategorySupplierForm extends JFrame {
	private JPanel contentPane;
	private JTextField txtManhacungcap;
	private JTextField txtTennhacungcap;
	private JTextField txtDiachi;
	private JTextField txtDienthoai;
	private JTable tableNhacungcap;
	
	private Connection conn;
	private PreparedStatement ptmt = null;
	private ArrayList<NhaCungCap>arrayListNhaCungCap = new ArrayList<NhaCungCap>();
	private int row;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CategorySupplierForm frame = new CategorySupplierForm();
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
		
	public CategorySupplierForm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 753, 505);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(107, 142, 35));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);//hiển thị chính giữa màn hình
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDanhmuc = new JLabel("DANH M\u1EE4C NH\u00C0 CUNG C\u1EA4P");
		lblDanhmuc.setForeground(new Color(255, 255, 255));
		lblDanhmuc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDanhmuc.setBounds(225, 25, 309, 37);
		contentPane.add(lblDanhmuc);
		
		JLabel lblManhacungcap = new JLabel("M\u00E3 nh\u00E0 cung c\u1EA5p");
		lblManhacungcap.setForeground(new Color(255, 255, 255));
		lblManhacungcap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblManhacungcap.setBounds(42, 81, 137, 25);
		contentPane.add(lblManhacungcap);
		
		txtManhacungcap = new JTextField();
		txtManhacungcap.setBounds(163, 85, 137, 20);
		contentPane.add(txtManhacungcap);
		txtManhacungcap.setColumns(10);
		
		JLabel lblTennhacungcap = new JLabel("T\u00EAn nh\u00E0 cung c\u1EA5p");
		lblTennhacungcap.setForeground(Color.WHITE);
		lblTennhacungcap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTennhacungcap.setBounds(42, 127, 137, 25);
		contentPane.add(lblTennhacungcap);
		
		txtTennhacungcap = new JTextField();
		txtTennhacungcap.setColumns(10);
		txtTennhacungcap.setBounds(163, 131, 137, 20);
		contentPane.add(txtTennhacungcap);
		
		JLabel lblDiachi = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblDiachi.setForeground(Color.WHITE);
		lblDiachi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiachi.setBounds(431, 81, 137, 25);
		contentPane.add(lblDiachi);
		
		txtDiachi = new JTextField();
		txtDiachi.setColumns(10);
		txtDiachi.setBounds(552, 85, 137, 20);
		contentPane.add(txtDiachi);
		
		JLabel lblDienthoai = new JLabel("\u0110i\u1EC7n tho\u1EA1i");
		lblDienthoai.setForeground(Color.WHITE);
		lblDienthoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDienthoai.setBounds(431, 127, 137, 25);
		contentPane.add(lblDienthoai);
		
		txtDienthoai = new JTextField();
		txtDienthoai.setColumns(10);
		txtDienthoai.setBounds(552, 131, 137, 20);
		contentPane.add(txtDienthoai);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 185, 647, 174);
		contentPane.add(scrollPane);
		
		tableNhacungcap = new JTable();
		tableNhacungcap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel defaultTableModel = (DefaultTableModel) tableNhacungcap.getModel();
				row=tableNhacungcap.getSelectedRow();
				txtManhacungcap.setText(defaultTableModel.getValueAt(row, 0).toString());
				txtTennhacungcap.setText(defaultTableModel.getValueAt(row, 1).toString());
				txtDiachi.setText(defaultTableModel.getValueAt(row, 2).toString());
				txtDienthoai.setText(defaultTableModel.getValueAt(row, 0).toString());
			}
		});
		scrollPane.setViewportView(tableNhacungcap);
		
		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				 conn = new connection().ketnoi();
					String sql = "INSERT INTO `nhacungcap`(`MaNCC`, `TenNCC`, `DiaChi`, `SoDienThoai`) VALUES (?,?,?,?)";
					
					try {
						ptmt = conn.prepareStatement(sql);
						try {
							ptmt.setString(1, txtManhacungcap.getText().toString());
							ptmt.setString(2, txtTennhacungcap.getText().toString());							
							ptmt.setString(3, txtDiachi.getText().toString());							
							ptmt.setString(4, txtDienthoai.getText().toString());						
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
		btnThem.setIcon(new ImageIcon(CategorySupplierForm.class.getResource("/img/ic_add.png")));
		btnThem.setBounds(42, 403, 101, 31);
		contentPane.add(btnThem);
		
		JButton btnXoa = new JButton("X\u00F3a");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conn = new connection().ketnoi();
				String sql = "DELETE FROM `nhacungcap` WHERE MaNCC = ?";
				try {
					ptmt = conn.prepareStatement(sql);
					try {
						ptmt.setString(1, txtManhacungcap.getText().toString());
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
		btnXoa.setIcon(new ImageIcon(CategorySupplierForm.class.getResource("/img/ic_delete.png")));
		btnXoa.setBounds(155, 403, 91, 31);
		contentPane.add(btnXoa);
		
		JButton btnSua = new JButton("S\u1EEDa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		btnSua.setIcon(new ImageIcon(CategorySupplierForm.class.getResource("/img/ic_update.png")));
		btnSua.setBounds(258, 403, 91, 31);
		contentPane.add(btnSua);
		
		JButton btnLuu = new JButton("L\u01B0u");
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		btnLuu.setIcon(new ImageIcon(CategorySupplierForm.class.getResource("/img/ic_save.png")));
		btnLuu.setBounds(361, 403, 91, 31);
		contentPane.add(btnLuu);
		
		JButton btnBoqua = new JButton("B\u1ECF qua");
		btnBoqua.setIcon(new ImageIcon(CategorySupplierForm.class.getResource("/img/ic_ingnone.png")));
		btnBoqua.setBounds(464, 403, 107, 31);
		contentPane.add(btnBoqua);
		
		JButton btnDong = new JButton("\u0110\u00F3ng");
		btnDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManagerForm().main(null);
				close();
			}
		});
		btnDong.setIcon(new ImageIcon(CategorySupplierForm.class.getResource("/img/ic_off.png")));
		btnDong.setBounds(582, 403, 107, 31);
		contentPane.add(btnDong);
		
		showData();
		
	}
	
	private void showData() {
		arrayListNhaCungCap.clear();
		conn = new connection().ketnoi();
		try {
			ptmt = conn.prepareStatement("SELECT * FROM `nhacungcap`");
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				String maNcc = rs.getString("MaNCC");
				String tenNcc = rs.getString("TenNCC");
				String soDienThoai = rs.getString("DiaChi");
		        String diaChi=rs.getString("SoDienThoai");
		        
				NhaCungCap nhaCungCap = new NhaCungCap(maNcc, tenNcc, diaChi, soDienThoai);
				arrayListNhaCungCap.add(nhaCungCap);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tableNhacungcap.removeAll();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("MaNCC");
		model.addColumn("TenNCC");
		model.addColumn("DiaChi");
		model.addColumn("SoDienThoai");
		
		for (NhaCungCap nhaCungCap : arrayListNhaCungCap) {
			model.addRow(nhaCungCap.toarray());
		}
		
		tableNhacungcap.setModel(model);
	}
	
	private void update() {
		String sql = "UPDATE `nhacungcap` SET `TenNCC`=?,`DiaChi`=?,`SoDienThoai`=? WHERE `MaNCC`=?";
		conn = new connection().ketnoi();
		try {
			ptmt = conn.prepareStatement(sql);
			try {
				ptmt.setString(1, txtTennhacungcap.getText().toString());
				ptmt.setString(2, txtDiachi.getText().toString());
				ptmt.setString(3, txtDienthoai.getText().toString());
				ptmt.setString(4, txtManhacungcap.getText().toString());
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
