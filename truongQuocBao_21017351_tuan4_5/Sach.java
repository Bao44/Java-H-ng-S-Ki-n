package truongQuocBao_21017351_tuan4_5;

import java.io.Serializable;

public class Sach implements Serializable{
	private String maSach,tuaSach,tacGia;
	private int namSX;
	private String nXB;
	private int soTrang;
	private double donGia;
	private String iSBN;
	public Sach(String maSach, String tuaSach, String tacGia, int namSX, String nXB, int soTrang, double donGia,
			String iSBN){
		super();
		this.maSach = maSach;
		this.tuaSach = tuaSach;
		this.tacGia = tacGia;
		this.namSX = namSX;
		this.nXB = nXB;
		this.setSoTrang(soTrang);;
		this.donGia = donGia;
		this.iSBN = iSBN;
	}
	
	public Sach(String maSach) {
		super();
		this.maSach = maSach;
	}

	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public String getTuaSach() {
		return tuaSach;
	}
	public void setTuaSach(String tuaSach) {
		this.tuaSach = tuaSach;
	}
	public String getTacGia() {
		return tacGia;
	}
	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}
	public int getNamSX() {
		return namSX;
	}
	public void setNamSX(int namSX) {
		this.namSX = namSX;
	}
	public String getnXB() {
		return nXB;
	}
	public void setnXB(String nXB) {
		this.nXB = nXB;
	}
	public int getSoTrang() {
		return soTrang;
	}
	public void setSoTrang(int soTrang){
		if(soTrang > 0)
			this.soTrang = soTrang;
		else
			this.soTrang = 1;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public String getiSBN() {
		return iSBN;
	}
	public void setiSBN(String iSBN) {
		this.iSBN = iSBN;
	}
	@Override
	public String toString() {
		return "Sach [maSach=" + maSach + ", tuaSach=" + tuaSach + ", tacGia=" + tacGia + ", namSX=" + namSX + ", nXB="
				+ nXB + ", soTrang=" + soTrang + ", donGia=" + donGia + ", iSBN=" + iSBN + "]";
	}
	
}
