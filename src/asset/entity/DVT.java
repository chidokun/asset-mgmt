package asset.entity;

public class DVT {
	private String maDVT;
	private String tenDVT;
	
	
	
	public DVT(String maDVT, String tenDVT) {
		super();
		this.maDVT = maDVT;
		this.tenDVT = tenDVT;
	}

	public String getMaDVT() {
		return maDVT;
	}

	public void setMaDVT(String maDVT) {
		this.maDVT = maDVT;
	}

	public String getTenDVT() {
		return tenDVT;
	}

	public void setTenDVT(String tenDVT) {
		this.tenDVT = tenDVT;
	}

}
