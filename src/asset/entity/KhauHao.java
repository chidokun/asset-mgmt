package asset.entity;

public class KhauHao {
	private String maTS;
	private String maCT;
	private long khauHaoTrongThang;
	private long khauHaoLuyKe;
	private long giaTriConLai;
	
	public KhauHao() {
		
	}

	public KhauHao(String maTS, String maCT, long khauHaoTrongThang, long khauHaoLuyKe, long giaTriConLai) {
		this.maTS = maTS;
		this.maCT = maCT;
		this.khauHaoTrongThang = khauHaoTrongThang;
		this.khauHaoLuyKe = khauHaoLuyKe;
		this.giaTriConLai = giaTriConLai;
	}

	public String getMaTS() {
		return maTS;
	}

	public void setMaTS(String maTS) {
		this.maTS = maTS;
	}

	public String getMaCT() {
		return maCT;
	}

	public void setMaCT(String maCT) {
		this.maCT = maCT;
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