package asset.entity;

public class Kho {
	private String maKho;
	private String tenKho;
	
	public Kho(String maKho, String tenKho) {
		setMaKho(maKho);
		setTenKho(tenKho);
	}

	public String getMaKho() {
		return maKho;
	}

	public void setMaKho(String maKho) {
		this.maKho = maKho;
	}

	public String getTenKho() {
		return tenKho;
	}

	public void setTenKho(String tenKho) {
		this.tenKho = tenKho;
	}

}
