package demo2;

import java.io.Serializable;

public class Phong2 implements Serializable{
	private String maPhong,tenPhong,loaiPhong;
	private double dienTich;
	private String ghiChu;
	public Phong2(String maPhong, String tenPhong, String loaiPhong, double dienTich, String ghiChu) {
		super();
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
		this.loaiPhong = loaiPhong;
		this.dienTich = dienTich;
		this.ghiChu = ghiChu;
	}
	public Phong2(String maPhong) {
		super();
		this.maPhong = maPhong;
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public String getTenPhong() {
		return tenPhong;
	}
	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}
	public String getLoaiPhong() {
		return loaiPhong;
	}
	public void setLoaiPhong(String loaiPhong) {
		this.loaiPhong = loaiPhong;
	}
	public double getDienTich() {
		return dienTich;
	}
	public void setDienTich(double dienTich) {
		this.dienTich = dienTich;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	@Override
	public String toString() {
		return "Phong2 [maPhong=" + maPhong + ", tenPhong=" + tenPhong + ", loaiPhong=" + loaiPhong + ", dienTich="
				+ dienTich + ", ghiChu=" + ghiChu + "]";
	}
	
}
