package asset.entity;

public class Ban {
	private String soHD;
	private String maTS;
	private int sl;
	private int giaBan;
	private String TKDUTaiSan;
	
	public Ban(String soHD, String maTS, int sl, int giaBan, String tKDUTaiSan) {
		setSoHD(soHD);
		setMaTS(maTS);
		setSl(sl);
		setGiaBan(giaBan);
		setTKDUTaiSan(tKDUTaiSan);
	}

	public String getTKDUTaiSan() {
		return TKDUTaiSan;
	}

	public void setTKDUTaiSan(String tKDUTaiSan) {
		TKDUTaiSan = tKDUTaiSan;
	}

	public String getSoHD() {
		return soHD;
	}

	public void setSoHD(String soHD) {
		this.soHD = soHD;
	}

	public String getMaTS() {
		return maTS;
	}

	public void setMaTS(String maTS) {
		this.maTS = maTS;
	}

	public int getSl() {
		return sl;
	}

	public void setSl(int sl) {
		this.sl = sl;
	}

	public int getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(int giaBan) {
		this.giaBan = giaBan;
	}

}
