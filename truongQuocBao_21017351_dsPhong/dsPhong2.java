package demo2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class dsPhong2 implements Serializable{
	private ArrayList<Phong2> dsPhong2;

	public dsPhong2(ArrayList<Phong2> dsPhong2) {
		super();
		this.dsPhong2 = dsPhong2;
	}

	public dsPhong2() {
		dsPhong2 = new ArrayList<Phong2>();
	}

	public ArrayList<Phong2> getDsPhong2() {
		return dsPhong2;
	}

	public Phong2 getPhong2(int i) {
		if(i>=0 && i<=dsPhong2.size()) {
			return dsPhong2.get(i);
		}
		return null;
	}
	
	public boolean add(Phong2 p) {
		for (Phong2 phong2 : dsPhong2) {
			if(phong2.getMaPhong().equalsIgnoreCase(p.getMaPhong()))
				return false;
		}
		dsPhong2.add(p);
		return true;
	}
	
	public boolean xoa(int i) {
		if(i>=0 && i<=dsPhong2.size()) {
			dsPhong2.remove(i);
			return true;
		}else
			return false;
	}
	
	public int timKiem(String ma) {
		for(int i=0;i<dsPhong2.size();i++) {
			if(dsPhong2.get(i).getMaPhong().equals(ma))
				return i;
		}
		return -1;
	}

	@Override
	public String toString() {
		return "dsPhong2 [dsPhong2=" + dsPhong2 + "]";
	}
	
}
