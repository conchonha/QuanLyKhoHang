package Jframe;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.image.ImageFilter;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import Connection.connection;
import model.HangHoa;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CategoryCommoditiesForm extends JFrame {
	private JPanel contentPane;
	private JTable tableHanghoa;
	private JTextField txtMaHang;
	private JTextField txtTenHang;
	private JTextField txtSoLuong;
	private JTextField txtDonViTinh;
	private JTextField txtDonGiaNhap;
	private JTextField txtDonGiaBan;
	private JTextField txtImage;
	
	private Connection conn;
	private PreparedStatement ptmt = null;
	private ArrayList<HangHoa>arrayListHangHoa = new ArrayList<HangHoa>();
	private int row;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CategoryCommoditiesForm frame = new CategoryCommoditiesForm();
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
		
	public CategoryCommoditiesForm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1089, 749);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(107, 142, 35));
		setLocationRelativeTo(null);//hiển thị chính giữa màn hình
		setResizable(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtGhiChu = new JTextArea();
		txtGhiChu.setBounds(502, 190, 481, 121);
		contentPane.add(txtGhiChu);
		
		JLabel lblDanhMuc = new JLabel("DANH M\u1EE4C H\u00C0NG H\u00D3A");
		lblDanhMuc.setForeground(new Color(255, 255, 255));
		lblDanhMuc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDanhMuc.setBounds(279, 22, 260, 48);
		contentPane.add(lblDanhMuc);
		
		JLabel lblMahang = new JLabel("M\u00E3 H\u00E0ng");
		lblMahang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMahang.setForeground(new Color(255, 255, 255));
		lblMahang.setBounds(58, 82, 93, 28);
		contentPane.add(lblMahang);
		
		JLabel lblAnh = new JLabel("\u1EA2nh");
		lblAnh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAnh.setForeground(Color.WHITE);
		lblAnh.setBounds(440, 84, 93, 19);
		contentPane.add(lblAnh);
		
		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  JFileChooser file = new JFileChooser();
		          file.setCurrentDirectory(new File(System.getProperty("user.home")));
		          //filter the files
		          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
		          file.addChoosableFileFilter(filter);
		          int result = file.showSaveDialog(null);
		           //if the user click on save in Jfilechooser
		          if(result == JFileChooser.APPROVE_OPTION){
		              File selectedFile = file.getSelectedFile();
		              String path = selectedFile.getAbsolutePath();
		              txtImage.setText(path);
		          }
		           //if the user click on save in Jfilechooser


		          else if(result == JFileChooser.CANCEL_OPTION){
		              System.out.println("No File Select");
		          }
			}
		});
		btnOpen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOpen.setBounds(502, 125, 74, 23);
		contentPane.add(btnOpen);
		
		JLabel lblGhichu = new JLabel("Ghi ch\u00FA");
		lblGhichu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGhichu.setForeground(Color.WHITE);
		lblGhichu.setBounds(440, 213, 101, 27);
		contentPane.add(lblGhichu);
		
		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     conn = new connection().ketnoi();
				String sql = "INSERT INTO `hanghoa`(`MaHang`, `TenHang`, `SoLuong`, `DonViTinh`, `DonViNhap`, `DonGiaBan`, `Anh`, `GhiChu`)"
						+ " VALUES (?,?,?,?,?,?,?,?)";
				
				try {
					ptmt = conn.prepareStatement(sql);
					ptmt.setString(1, txtMaHang.getText().toString());
					ptmt.setString(2, txtTenHang.getText().toString());
					ptmt.setFloat(3, Float.parseFloat(txtSoLuong.getText().toString()));
					ptmt.setString(4, txtDonViTinh.getText().toString());
					ptmt.setFloat(5, Float.parseFloat(txtDonGiaNhap.getText().toString()));
					ptmt.setFloat(6, Float.parseFloat(txtDonGiaBan.getText().toString()));
					ptmt.setString(7, txtImage.getText().toString());
					ptmt.setString(8, txtGhiChu.getText().toString());
					ptmt.executeUpdate();
				} catch (SQLException e1) {
					JOptionPane.showConfirmDialog(null, "Vui Lòng Kiểm Tra Lại Dữ Liêu", "câu hõi", JOptionPane.YES_OPTION);
					e1.printStackTrace();
				}
			
			}
		});
		btnThem.setIcon(new ImageIcon(CategoryCommoditiesForm.class.getResource("/img/ic_add.png")));
		btnThem.setBounds(45, 623, 106, 35);
		contentPane.add(btnThem);
		
		JButton btnXoa = new JButton("Xo\u00E1");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conn = new connection().ketnoi();
				String sql = "DELETE FROM `hanghoa` WHERE MaHang = ?";
				try {
					ptmt = conn.prepareStatement(sql);
					try {
						ptmt.setString(1, txtMaHang.getText().toString());
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
		btnXoa.setIcon(new ImageIcon(CategoryCommoditiesForm.class.getResource("/img/ic_delete.png")));
		btnXoa.setBounds(163, 623, 94, 35);
		contentPane.add(btnXoa);
		
		JButton btnSua = new JButton("S\u1EEDa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update(txtGhiChu.getText().toString());
			
			}
		});
		btnSua.setIcon(new ImageIcon(CategoryCommoditiesForm.class.getResource("/img/ic_update.png")));
		btnSua.setBounds(266, 623, 101, 35);
		contentPane.add(btnSua);
		
		JButton btnLuu = new JButton("L\u01B0u");
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update(txtGhiChu.getText().toString());
			}
		});
		btnLuu.setIcon(new ImageIcon(CategoryCommoditiesForm.class.getResource("/img/ic_save.png")));
		btnLuu.setBounds(379, 623, 93, 35);
		contentPane.add(btnLuu);
		
		JButton btnBoqua = new JButton("B\u1ECF qua");
		btnBoqua.setIcon(new ImageIcon(CategoryCommoditiesForm.class.getResource("/img/ic_ingnone.png")));
		btnBoqua.setBounds(484, 623, 109, 35);
		contentPane.add(btnBoqua);
		
		JButton btnTimkiem = new JButton("T\u00ECm ki\u1EBFm");
		btnTimkiem.setIcon(new ImageIcon(CategoryCommoditiesForm.class.getResource("/img/ic_search.png")));
		btnTimkiem.setBounds(605, 623, 123, 35);
		contentPane.add(btnTimkiem);
		
		JButton btnHienthiDS = new JButton("Hi\u1EC3n th\u1ECB DS");
		btnHienthiDS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showData();
			}
		});
		btnHienthiDS.setIcon(new ImageIcon(CategoryCommoditiesForm.class.getResource("/img/category (1).png")));
		btnHienthiDS.setBounds(740, 623, 131, 35);
		contentPane.add(btnHienthiDS);
		
		JButton btnDong = new JButton("\u0110\u00F3ng");
		btnDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManagerForm().main(null);
				close();
			}
		});
		btnDong.setIcon(new ImageIcon(CategoryCommoditiesForm.class.getResource("/img/ic_off.png")));
		btnDong.setBounds(877, 623, 106, 35);
		contentPane.add(btnDong);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 381, 950, 207);
		contentPane.add(scrollPane);
		
		tableHanghoa = new JTable();
		tableHanghoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel defaultTableModel = (DefaultTableModel) tableHanghoa.getModel();
				row=tableHanghoa.getSelectedRow();
				txtMaHang.setText(defaultTableModel.getValueAt(row, 0).toString());
				txtTenHang.setText(defaultTableModel.getValueAt(row, 1).toString());
				txtSoLuong.setText(defaultTableModel.getValueAt(row, 2).toString());
				txtDonViTinh.setText(defaultTableModel.getValueAt(row, 3).toString());
				txtDonGiaNhap.setText(defaultTableModel.getValueAt(row, 4).toString());
				txtDonGiaBan.setText(defaultTableModel.getValueAt(row, 5).toString());
				txtImage.setText(defaultTableModel.getValueAt(row, 6).toString());
				txtGhiChu.setText(defaultTableModel.getValueAt(row, 7).toString());
				//HangHoa hangHoa = new HangHoa(maHangHoa, tenHang, soLuong, donViTinh, donViNhap, donGiaBan, hinhAnh, ghiChu)
			}
		});
		scrollPane.setViewportView(tableHanghoa);
		
		txtMaHang = new JTextField();
		txtMaHang.setColumns(10);
		txtMaHang.setBounds(153, 83, 214, 27);
		contentPane.add(txtMaHang);
		
		txtTenHang = new JTextField();
		txtTenHang.setColumns(10);
		txtTenHang.setBounds(153, 124, 214, 27);
		contentPane.add(txtTenHang);
		
		JLabel lblTnHng = new JLabel("T\u00EAn H\u00E0ng");
		lblTnHng.setForeground(Color.WHITE);
		lblTnHng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnHng.setBounds(58, 123, 93, 28);
		contentPane.add(lblTnHng);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(153, 165, 214, 27);
		contentPane.add(txtSoLuong);
		
		JLabel lblSLng = new JLabel("S\u1ED1 L\u01B0\u1EE3ng");
		lblSLng.setForeground(Color.WHITE);
		lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSLng.setBounds(58, 164, 93, 28);
		contentPane.add(lblSLng);
		
		txtDonViTinh = new JTextField();
		txtDonViTinh.setColumns(10);
		txtDonViTinh.setBounds(153, 202, 214, 27);
		contentPane.add(txtDonViTinh);
		
		JLabel lblnVTnh = new JLabel("\u0110\u01A1n V\u1ECB T\u00EDnh");
		lblnVTnh.setForeground(Color.WHITE);
		lblnVTnh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblnVTnh.setBounds(58, 201, 93, 28);
		contentPane.add(lblnVTnh);
		
		txtDonGiaNhap = new JTextField();
		txtDonGiaNhap.setColumns(10);
		txtDonGiaNhap.setBounds(153, 243, 214, 27);
		contentPane.add(txtDonGiaNhap);
		
		JLabel lblnGiNhp = new JLabel("\u0110\u01A1n Gi\u00E1 Nh\u1EADp");
		lblnGiNhp.setForeground(Color.WHITE);
		lblnGiNhp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblnGiNhp.setBounds(58, 242, 93, 28);
		contentPane.add(lblnGiNhp);
		
		txtDonGiaBan = new JTextField();
		txtDonGiaBan.setColumns(10);
		txtDonGiaBan.setBounds(153, 284, 214, 27);
		contentPane.add(txtDonGiaBan);
		
		JLabel lblnGiBn = new JLabel("\u0110\u01A1n Gi\u00E1 B\u00E1n");
		lblnGiBn.setForeground(Color.WHITE);
		lblnGiBn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblnGiBn.setBounds(58, 283, 93, 28);
		contentPane.add(lblnGiBn);
		
		txtImage = new JTextField();
		txtImage.setColumns(10);
		txtImage.setBounds(502, 83, 214, 27);
		contentPane.add(txtImage);
	}
	
	private void showData() {
		arrayListHangHoa.clear();
		conn = new connection().ketnoi();
		try {
			ptmt = conn.prepareStatement("SELECT * FROM `hanghoa`");
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				String maHangHoa = rs.getString("MaHang");
				String tenHang = rs.getString("TenHang");
				float soLuong = rs.getFloat("SoLuong");
		        String donViTinh=rs.getString("DonViTinh");
		        float donViNhap = rs.getFloat("DonViNhap");
		        float donGiaBan = rs.getFloat("DonGiaBan");
				String hinhAnh = rs.getString("Anh");
				String ghiChu = rs.getString("GhiChu");
				HangHoa hanghoa = new HangHoa(maHangHoa, tenHang, soLuong, donViTinh, donViNhap, donGiaBan, hinhAnh, ghiChu);
				arrayListHangHoa.add(hanghoa);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tableHanghoa.removeAll();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("MaHang");
		model.addColumn("TenHang");
		model.addColumn("SoLuong");
		model.addColumn("DonViTinh");
		model.addColumn("DonViNhap");
		model.addColumn("DonGiaBan");
		model.addColumn("Anh");
		model.addColumn("GhiChu");
		for (HangHoa hangHoa : arrayListHangHoa) {
			model.addRow(hangHoa.toarray());
		}
		
		tableHanghoa.setModel(model);
	}
	
	private void update(String txtGhiChu) {
		String sql = "UPDATE `hanghoa` SET `TenHang`=?,`SoLuong`=?,`DonViTinh`=?,`DonViNhap`=?,`DonGiaBan`=?,`Anh`=?,`GhiChu`=? WHERE `MaHang`=?";
		conn = new connection().ketnoi();
		try {
			ptmt = conn.prepareStatement(sql);
			try {
				ptmt.setString(1, txtTenHang.getText().toString());
				ptmt.setFloat(2, Float.parseFloat( txtSoLuong.getText().toString()));
				ptmt.setString(3, txtDonViTinh.getText().toString());
				ptmt.setFloat(4,Float.parseFloat(txtDonGiaNhap.getText().toString()) );
				ptmt.setFloat(5, Float.parseFloat(txtDonGiaBan.getText().toString()));
				ptmt.setString(6, txtImage.getText().toString());
				ptmt.setString(7, txtGhiChu);
				ptmt.setString(8, txtMaHang.getText().toString());
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
