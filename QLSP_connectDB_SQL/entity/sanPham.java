package entity;

public class sanPham {
	private String maLoaiXe,loaiXe,nuocSX;
	private long giaBan;
	private int soLuong;
	private String soSuon,soKhung;
	private int soPK;
	public sanPham() {
	}
	public sanPham(String maLoaiXe) {
		this.maLoaiXe = maLoaiXe;
	}
	public sanPham(String maLoaiXe, String loaiXe, String nuocSX, long giaBan, int soLuong, String soSuon,
			String soKhung, int soPK) {
		this.maLoaiXe = maLoaiXe;
		this.loaiXe = loaiXe;
		this.nuocSX = nuocSX;
		this.giaBan = giaBan;
		this.soLuong = soLuong;
		this.soSuon = soSuon;
		this.soKhung = soKhung;
		this.soPK = soPK;
	}
	public String getMaLoaiXe() {
		return maLoaiXe;
	}
	public void setMaLoaiXe(String maLoaiXe) {
		this.maLoaiXe = maLoaiXe;
	}
	public String getLoaiXe() {
		return loaiXe;
	}
	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}
	public String getNuocSX() {
		return nuocSX;
	}
	public void setNuocSX(String nuocSX) {
		this.nuocSX = nuocSX;
	}
	public long getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(long giaBan) {
		this.giaBan = giaBan;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getSoSuon() {
		return soSuon;
	}
	public void setSoSuon(String soSuon) {
		this.soSuon = soSuon;
	}
	public String getSoKhung() {
		return soKhung;
	}
	public void setSoKhung(String soKhung) {
		this.soKhung = soKhung;
	}
	public int getSoPK() {
		return soPK;
	}
	public void setSoPK(int soPK) {
		this.soPK = soPK;
	}

	
	
}
