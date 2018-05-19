package asset.entity;

public class Quyen {
	private String quyen;
	private String mauSo;
	private String kyHieu;
	
	public Quyen(String quyen, String mauSo, String kyHieu) {
		setQuyen(quyen);
		setMauSo(mauSo);
		setKyHieu(kyHieu);
	}

	public String getQuyen() {
		return quyen;
	}

	public void setQuyen(String quyen) {
		this.quyen = quyen;
	}

	public String getMauSo() {
		return mauSo;
	}

	public void setMauSo(String mauSo) {
		this.mauSo = mauSo;
	}

	public String getKyHieu() {
		return kyHieu;
	}

	public void setKyHieu(String kyHieu) {
		this.kyHieu = kyHieu;
	}

}
