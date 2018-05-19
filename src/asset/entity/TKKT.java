package asset.entity;

public class TKKT {
	private int maTK;
	private String tenTK;
	
	public TKKT(int maTK, String tenTK) {
		setMaTK(maTK);
		setTenTK(tenTK);
	}

	public int getMaTK() {
		return maTK;
	}

	public void setMaTK(int maTK) {
		this.maTK = maTK;
	}

	public String getTenTK() {
		return tenTK;
	}

	public void setTenTK(String tenTK) {
		this.tenTK = tenTK;
	}
}
