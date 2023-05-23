package truongQuocBao_21017351_tuan3;

import java.util.ArrayList;

public class PhongBan {
	private String maPhong, tenPhong;
	
	private ArrayList<NhanVien> dsnv;

	public PhongBan(String maPhong, String tenPhong) {
		super();
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
		this.dsnv = new ArrayList<NhanVien>();
	}
	
	public void themNV(String maSo,String ho,String ten,Boolean phai,int tuoi,double luong) {
		NhanVien nv = new NhanVien(maSo, ho, ten, phai, tuoi, luong,this);
		dsnv.add(nv);
		
	}

	public ArrayList<NhanVien> getDsnv() {
		return dsnv;
	}

	@Override
	public String toString() {
		return tenPhong;
	}
	
}
