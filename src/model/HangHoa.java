package model;

public class HangHoa {
	private String MaHangHoa;
	private String TenHang;
	private float SoLuong;
	private String DonViTinh;
	private float DonViNhap;
	private float DonGiaBan;
	private String HinhAnh;
	private String GhiChu;
	public String getMaHangHoa() {
		return MaHangHoa;
	}
	public void setMaHangHoa(String maHangHoa) {
		MaHangHoa = maHangHoa;
	}
	public String getTenHang() {
		return TenHang;
	}
	public void setTenHang(String tenHang) {
		TenHang = tenHang;
	}
	public float getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(float soLuong) {
		SoLuong = soLuong;
	}
	public String getDonViTinh() {
		return DonViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		DonViTinh = donViTinh;
	}
	public float getDonViNhap() {
		return DonViNhap;
	}
	public void setDonViNhap(float donViNhap) {
		DonViNhap = donViNhap;
	}
	public float getDonGiaBan() {
		return DonGiaBan;
	}
	public void setDonGiaBan(float donGiaBan) {
		DonGiaBan = donGiaBan;
	}
	public String getHinhAnh() {
		return HinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		HinhAnh = hinhAnh;
	}
	public String getGhiChu() {
		return GhiChu;
	}
	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}
	public HangHoa(String maHangHoa, String tenHang, float soLuong, String donViTinh, float donViNhap, float donGiaBan,
			String hinhAnh, String ghiChu) {
		super();
		MaHangHoa = maHangHoa;
		TenHang = tenHang;
		SoLuong = soLuong;
		DonViTinh = donViTinh;
		DonViNhap = donViNhap;
		DonGiaBan = donGiaBan;
		HinhAnh = hinhAnh;
		GhiChu = ghiChu;
	}
	
	public Object[] toarray() {
		return new Object[] {MaHangHoa,TenHang,SoLuong,DonViTinh,DonViNhap,DonGiaBan,HinhAnh,GhiChu};
	}
	
}
