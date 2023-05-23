package truongQuocBao_21017351_tuan3;

public class NhanVien {
	private String maSo,ho,ten;
	private boolean phai;
	private int tuoi;
	private double luong;
	private PhongBan pb;
	public NhanVien(String maSo, String ho, String ten,boolean phai, int tuoi, double luong, PhongBan pb) {
		super();
		this.maSo = maSo;
		this.ho = ho;
		this.ten = ten;
		this.phai = phai;
		this.tuoi = tuoi;
		this.luong = luong;
		this.pb = pb;
	}
	
	public NhanVien(String maSo, String ho, String ten, boolean phai, int tuoi, double luong) {
		super();
		this.maSo = maSo;
		this.ho = ho;
		this.ten = ten;
		this.tuoi = tuoi;
		this.luong = luong;
	}

	public String getMaSo() {
		return maSo;
	}
	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}
	public String getHo() {
		return ho;
	}
	public void setHo(String ho) {
		this.ho = ho;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	
	public boolean isPhai() {
		return phai;
	}

	public void setPhai(boolean phai) {
		this.phai = phai;
	}

	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public double getLuong() {
		return luong;
	}
	public void setLuong(double luong) {
		this.luong = luong;
	}
	public PhongBan getPb() {
		return pb;
	}
	public void setPb(PhongBan pb) {
		this.pb = pb;
	}

	@Override
	public String toString() {
		return "NhanVien [maSo=" + maSo + ", ho=" + ho + ", ten=" + ten + ", phai=" + phai + ", tuoi=" + tuoi
				+ ", luong=" + luong + ", pb=" + pb + "]";
	}
	
}
