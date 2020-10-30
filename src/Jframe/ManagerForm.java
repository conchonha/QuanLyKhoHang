package Jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerForm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerForm frame = new ManagerForm();
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
		
	public ManagerForm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1111, 610);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(107, 142, 35));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);//hiển thị chính giữa màn hình
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.LIGHT_GRAY);
		menuBar.setBackground(Color.LIGHT_GRAY);
		menuBar.setBounds(0, 0, 1105, 51);
		contentPane.add(menuBar);
		
		JMenu mnSd = new JMenu("Danh Mục");
		mnSd.setIcon(new ImageIcon(ManagerForm.class.getResource("/img/category (1).png")));
		menuBar.add(mnSd);
		
		JMenuItem mntmDanhMcHng = new JMenuItem("Danh Mục Khách Hàng");
		mntmDanhMcHng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CategoryCustomerForm info = new CategoryCustomerForm();
				info.setVisible(true);
				close();
			}
		});
		mnSd.add(mntmDanhMcHng);
		
		JMenuItem mntmDanhMc = new JMenuItem("Danh Mục Nhân Viên");
		mntmDanhMc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CategoryStaffForm info = new CategoryStaffForm();
				info.setVisible(true);
				close();
			}
		});
		mnSd.add(mntmDanhMc);
		
		JMenuItem mntmDanhMcHng_1 = new JMenuItem("Danh Mục Hàng Hoá");
		mntmDanhMcHng_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CategoryCommoditiesForm info = new CategoryCommoditiesForm();
				info.setVisible(true);
				close();
			}
		});
		mnSd.add(mntmDanhMcHng_1);
		
		JMenuItem mntmDanhMcNh = new JMenuItem("Danh Mục Nhà Cung Cấp");
		mntmDanhMcNh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CategorySupplierForm info = new CategorySupplierForm();
				info.setVisible(true);
				close();
			}
		});
		mnSd.add(mntmDanhMcNh);
		
		JMenu mnChngT = new JMenu("Chứng Từ");
		mnChngT.setIcon(new ImageIcon(ManagerForm.class.getResource("/img/ic_license.png")));
		menuBar.add(mnChngT);
		
		JMenuItem mntmPhiuXut = new JMenuItem("Phiếu Xuất");
		mntmPhiuXut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PromissoryExportForm info = new PromissoryExportForm();
				info.setVisible(true);
				close();
			}
		});
		mnChngT.add(mntmPhiuXut);
		
		JMenuItem mntmPhiuNhp = new JMenuItem("Phiếu Nhập");
		mntmPhiuNhp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PromissoryInputForm info = new PromissoryInputForm();
				info.setVisible(true);
				close();
			}
		});
		mnChngT.add(mntmPhiuNhp);
		
		JMenuItem mntmPhiuChi = new JMenuItem("Phiếu Chi");
		mntmPhiuChi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PromissoryPaymentForm info = new PromissoryPaymentForm();
				info.setVisible(true);
				close();
			}
		});
		mnChngT.add(mntmPhiuChi);
		
		JMenu mnTmKim = new JMenu("Tìm Kiếm");
		mnTmKim.setIcon(new ImageIcon(ManagerForm.class.getResource("/img/ic_search.png")));
		menuBar.add(mnTmKim);
		
		JMenuItem mntmTmKimPiu = new JMenuItem("Tìm Kiếm Piếu Xuất");
		mntmTmKimPiu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchBillexportForm info = new SearchBillexportForm();
				info.setVisible(true);
				close();
			}
		});
		
		JMenuItem mntmTmKimPhiu = new JMenuItem("Tìm Kiếm Phiếu Nhập");
		mntmTmKimPhiu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchBillInputForm info = new SearchBillInputForm();
				info.setVisible(true);
				close();
			}
		});
		mnTmKim.add(mntmTmKimPhiu);
		mnTmKim.add(mntmTmKimPiu);
		
		JMenuItem mntmTmKimHng = new JMenuItem("Tìm Kiếm Hàng Hoá");
		mntmTmKimHng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchGoodsForm info = new SearchGoodsForm();
				info.setVisible(true);
				close();
			}
		});
		mnTmKim.add(mntmTmKimHng);
		
		JMenu mnBoCo = new JMenu("Báo Cáo");
		mnBoCo.setIcon(new ImageIcon(ManagerForm.class.getResource("/img/ic_report.png")));
		menuBar.add(mnBoCo);
		
		JMenuItem mntmBoCoHng = new JMenuItem("Báo Cáo Hàng Tồn");
		mntmBoCoHng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InventoryReportForm info = new InventoryReportForm();
				info.setVisible(true);
				close();
			}
		});
		mnBoCo.add(mntmBoCoHng);
		
		JMenuItem mntmBoCoTng = new JMenuItem("Báo Cáo Tổng Doanh Thu");
		mntmBoCoTng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RevenueReportForm info = new RevenueReportForm();
				info.setVisible(true);
				close();
			}
		});
		mnBoCo.add(mntmBoCoTng);
		
		JMenu mnThot = new JMenu("Thoát");
		mnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnThot.setIcon(new ImageIcon(ManagerForm.class.getResource("/img/ic_off.png")));
		menuBar.add(mnThot);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ret =JOptionPane.showConfirmDialog(null, "Đóng chương trình", "câu hõi", JOptionPane.YES_NO_OPTION);
				if(ret == JOptionPane.YES_OPTION) {
				System.exit(0);	
				}
			}
		});
		mnThot.add(mntmExit);
		
		JLabel lblBackgroundHeader = new JLabel("");
		lblBackgroundHeader.setOpaque(true);
		lblBackgroundHeader.setBackground(Color.LIGHT_GRAY);
		lblBackgroundHeader.setBounds(0, 0, 1105, 51);
		contentPane.add(lblBackgroundHeader);
		
		JLabel lblTextTitle = new JLabel("Phần Mềm Quản Lý Kho Xây Dựng");
		lblTextTitle.setBackground(Color.LIGHT_GRAY);
		lblTextTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTextTitle.setForeground(Color.BLACK);
		lblTextTitle.setBounds(329, 241, 491, 39);
		lblTextTitle.setOpaque(true);
		contentPane.add(lblTextTitle);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setIcon(new ImageIcon(ManagerForm.class.getResource("/img/hinhnen.jpeg")));
		lblNewLabel.setBounds(0, 0, 1105, 575);
		contentPane.add(lblNewLabel);
	}
	
	private Image getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;
	}
}
