package asset.entity;

import java.util.Date;

public class TaiSanKhauHao {
	private String maTS;
	private String tenTS;
	private String boPhanSD;
	private int nguyenGia;
	private Date ngaySD;
	private int soThangSD;
	private int soThangDaSD;
	private long khauHaoHangThang;
	private long khauHaoTrongThang;
	private long khauHaoLuyKe;
	private long giaTriConLai;

	public TaiSanKhauHao(String maTS, String tenTS, String boPhanSD, int nguyenGia, Date ngaySD, int soThangSD,
			int soThangDaSD, long khauHaoHangThang, long khauHaoTrongThang, long khauHaoLuyKe, long giaTriConLai) {
		setMaTS(maTS);
		setTenTS(tenTS);
		setBoPhanSD(boPhanSD);
		setNguyenGia(nguyenGia);
		setNgaySD(ngaySD);
		setSoThangSD(soThangSD);
		setSoThangDaSD(soThangDaSD);
		setKhauHaoHangThang(khauHaoHangThang);
		setKhauHaoTrongThang(khauHaoTrongThang);
		setKhauHaoLuyKe(khauHaoLuyKe);
		setGiaTriConLai(giaTriConLai);
	}

	public TaiSanKhauHao(String maTS, String tenTS, String boPhanSD, int nguyenGia, Date ngaySD, int soThangSD,int soThangDaSD) {
		setMaTS(maTS);
		setTenTS(tenTS);
		setBoPhanSD(boPhanSD);
		setNguyenGia(nguyenGia);
		setNgaySD(ngaySD);
		setSoThangSD(soThangSD);
		setSoThangDaSD(soThangDaSD);
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

	public String getBoPhanSD() {
		return boPhanSD;
	}

	public void setBoPhanSD(String boPhanSD) {
		this.boPhanSD = boPhanSD;
	}

	public int getNguyenGia() {
		return nguyenGia;
	}

	public void setNguyenGia(int nguyenGia) {
		this.nguyenGia = nguyenGia;
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

	public int getSoThangDaSD() {
		return soThangDaSD;
	}

	public void setSoThangDaSD(int soThangDaSD) {
		this.soThangDaSD = soThangDaSD;
	}

	public long getKhauHaoHangThang() {
		return khauHaoHangThang;
	}

	public void setKhauHaoHangThang(long khauHaoHangThang) {
		this.khauHaoHangThang = khauHaoHangThang;
	}

	public long getKhauHaoTrongThang() {
		return khauHaoTrongThang;
	}

	public void setKhauHaoTrongThang(long khauHaoTrongThang) {
		this.khauHaoTrongThang = khauHaoTrongThang;
	}

	public long getKhauHaoLuyKe() {
		return khauHaoLuyKe;
	}

	public void setKhauHaoLuyKe(long khauHaoLuyKe) {
		this.khauHaoLuyKe = khauHaoLuyKe;
	}

	public long getGiaTriConLai() {
		return giaTriConLai;
	}

	public void setGiaTriConLai(long giaTriConLai) {
		this.giaTriConLai = giaTriConLai;
	}

}
