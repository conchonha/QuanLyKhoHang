package model;

public class KhachHang {
	private String MaKhach;
	private String TenKhach;
	private String SoDienThoai;
	private String DiaChi;
	public String getMaKhach() {
		return MaKhach;
	}
	public void setMaKhach(String maKhach) {
		MaKhach = maKhach;
	}
	public String getTenKhach() {
		return TenKhach;
	}
	public void setTenKhach(String tenKhach) {
		TenKhach = tenKhach;
	}
	public String getSoDienThoai() {
		return SoDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public KhachHang(String maKhach, String tenKhach, String soDienThoai, String diaChi) {
		super();
		MaKhach = maKhach;
		TenKhach = tenKhach;
		SoDienThoai = soDienThoai;
		DiaChi = diaChi;
	}
	
	public Object[] toarray() {
		return new Object[] {MaKhach,TenKhach,SoDienThoai,DiaChi};
	}
}
