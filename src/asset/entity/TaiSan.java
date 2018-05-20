package asset.entity;

import java.util.Date;

public class TaiSan {
	private String maTS;
	private String tenTS;
	private int soNamKH;
	private Date ngaySD;
	private int soThangSD;
	private String maDVT;
	private int trangThai;
	private int nguyenGia;
	private String maPN;
	private int sl;
	private String taiKhoanDU;

	public TaiSan() { }

	public TaiSan(String maTS, String tenTS, int soNamKH, Date ngaySD, int nguyenGia) {
		this.maTS = maTS;
		this.tenTS = tenTS;
		this.soNamKH = soNamKH;
		this.ngaySD = ngaySD;
		this.nguyenGia = nguyenGia;
	}

	public TaiSan(String maTS, String tenTS, int soNamKH, Date ngaySD, int soThangSD, String maDVT, int trangThai,
			int nguyenGia, String maPN, int sl) {
		this.maTS = maTS;
		this.tenTS = tenTS;
		this.soNamKH = soNamKH;
		this.ngaySD = ngaySD;
		this.soThangSD = soThangSD;
		this.maDVT = maDVT;
		this.trangThai = trangThai;
		this.nguyenGia = nguyenGia;
		this.maPN = maPN;
		this.sl = sl;
	}

	public TaiSan(String maTS, String tenTS) {
		setMaTS(maTS);
		setTenTS(tenTS);
	}
	
	public String getMaTS() {
		return maTS;
	}

	public void setMaTS(String maTS) {
		this.maTS = maTS;
	}

	public String getTenTS() {
		return tenTS;
	}

	public void setTenTS(String tenTS) {
		this.tenTS = tenTS;
	}

	public int getSoNamKH() {
		return soNamKH;
	}

	public void setSoNamKH(int soNamKH) {
		this.soNamKH = soNamKH;
	}

	public Date getNgaySD() {
		return ngaySD;
	}

	public void setNgaySD(Date ngaySD) {
		this.ngaySD = ngaySD;
	}

	public int getSoThangSD() {
		return soThangSD;
	}

	public void setSoThangSD(int soThangSD) {
		this.soThangSD = soThangSD;
	}

	public String getMaDVT() {
		return maDVT;
	}

	public void setMaDVT(String maDVT) {
		this.maDVT = maDVT;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public int getNguyenGia() {
		return nguyenGia;
	}

	public void setNguyenGia(int nguyenGia) {
		this.nguyenGia = nguyenGia;
	}

	public String getMaPN() {
		return maPN;
	}

	public void setMaPN(String maPN) {
		this.maPN = maPN;
	}

	public int getSl() {
		return sl;
	}

	public void setSl(int sl) {
		this.sl = sl;
	}

	public String getTaiKhoanDU() {
		return taiKhoanDU;
	}

	public void setTaiKhoanDU(String taiKhoanDU) {
		this.taiKhoanDU = taiKhoanDU;
	}
	
	
}
