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
	
	public TaiSan() { }

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

}
