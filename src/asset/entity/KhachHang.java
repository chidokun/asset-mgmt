package asset.entity;

public class KhachHang {
	private String maKH;
	private String tenKH;
	private String diaChi;
	private String soTK;
	
	public KhachHang(String maKH, String tenKH, String diaChi, String soTK) {
		setMaKH(maKH);
		setTenKH(tenKH);
		setDiaChi(diaChi);
		setSoTK(soTK);
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoTK() {
		return soTK;
	}

	public void setSoTK(String soTK) {
		this.soTK = soTK;
	}

}
