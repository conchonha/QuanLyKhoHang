package model;

public class NhaCungCap {
	private String MaNcc;
	private String TenNcc;
	private String DiaChi;
	private String SoDienThoai;
	public String getMaNcc() {
		return MaNcc;
	}
	public void setMaNcc(String maNcc) {
		MaNcc = maNcc;
	}
	public String getTenNcc() {
		return TenNcc;
	}
	public void setTenNcc(String tenNcc) {
		TenNcc = tenNcc;
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
	public NhaCungCap(String maNcc, String tenNcc, String diaChi, String soDienThoai) {
		super();
		MaNcc = maNcc;
		TenNcc = tenNcc;
		DiaChi = diaChi;
		SoDienThoai = soDienThoai;
	}
	
	public Object[] toarray() {
		return new Object[] {MaNcc,TenNcc,DiaChi,SoDienThoai};
	}

}
