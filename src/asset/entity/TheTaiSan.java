package asset.entity;

import java.util.Date;

public class TheTaiSan {
	private String maThe;
	private Date ngayLap;
	private String boPhanSD;
	private String maTS;
	private int namDinhChi;
	private String lyDoDinhChi;

	public TheTaiSan() {

	}

	public TheTaiSan(String maThe, Date ngayLap, String boPhanSD, String maTS, int namDinhChi, String lyDoDinhChi) {
		this.maThe = maThe;
		this.ngayLap = ngayLap;
		this.boPhanSD = boPhanSD;
		this.maTS = maTS;
		this.namDinhChi = namDinhChi;
		this.lyDoDinhChi = lyDoDinhChi;
	}

	public String getMaThe() {
		return maThe;
	}

	public void setMaThe(String maThe) {
		this.maThe = maThe;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public String getBoPhanSD() {
		return boPhanSD;
	}

	public void setBoPhanSD(String boPhanSD) {
		this.boPhanSD = boPhanSD;
	}

	public String getMaTS() {
		return maTS;
	}

	public void setMaTS(String maTS) {
		this.maTS = maTS;
	}

	public int getNamDinhChi() {
		return namDinhChi;
	}

	public void setNamDinhChi(int namDinhChi) {
		this.namDinhChi = namDinhChi;
	}

	public String getLyDoDinhChi() {
		return lyDoDinhChi;
	}

	public void setLyDoDinhChi(String lyDoDinhChi) {
		this.lyDoDinhChi = lyDoDinhChi;
	}

}
