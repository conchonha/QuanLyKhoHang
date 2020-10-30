package model;

public class NhanVien {
	private String MaNhanVien;
	private String TenNhanVien;
	private String GioiTinh;
	private String DiaChi;
	private String SoDienThoai;
	private String NgaySinh;
	public String getMaNhanVien() {
		return MaNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		MaNhanVien = maNhanVien;
	}
	public String getTenNhanVien() {
		return TenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		TenNhanVien = tenNhanVien;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getSoDienThoai() {
		return SoDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}
	public String getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public NhanVien(String maNhanVien, String tenNhanVien, String gioiTinh, String diaChi, String soDienThoai,
			String ngaySinh) {
		super();
		MaNhanVien = maNhanVien;
		TenNhanVien = tenNhanVien;
		GioiTinh = gioiTinh;
		DiaChi = diaChi;
		SoDienThoai = soDienThoai;
		NgaySinh = ngaySinh;
	}
	
	public Object[] toarray() {
		return new Object[] {MaNhanVien,TenNhanVien,GioiTinh,DiaChi,SoDienThoai,NgaySinh};
	}
}
