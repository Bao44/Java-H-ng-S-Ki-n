package truongQuocBao_21017351_tuan2;

import java.io.Serializable;

public class NhanVien implements Serializable{
	private String maNV,ho,ten,gt;
	private int tuoi;
	private double luong;
	public NhanVien(String maNV, String ho, String ten,String gt, int tuoi, double luong) {
		this.setMaNV(maNV);
		this.setHo(ho);
		this.setTen(ten);
		this.setGt(gt);
		this.setTuoi(tuoi);
		this.setLuong(luong);
	}
	public String getGt() {
		return gt;
	}
	public void setGt(String gt) {
		this.gt = gt;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
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
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		if(tuoi > 0 || tuoi <100)
			this.tuoi = tuoi;
		else 
			this.tuoi = 1;
	}
	public double getLuong() {
		return luong;
	}
	public void setLuong(double luong) {
		if(luong > 0)
			this.luong = luong;
		else 
			this.luong = 1;
	}
	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", ho=" + ho + ", ten=" + ten + ", tuoi=" + tuoi + ", luong=" + luong + "]";
	}
	
}
