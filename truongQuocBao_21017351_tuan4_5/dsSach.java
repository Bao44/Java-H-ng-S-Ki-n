package truongQuocBao_21017351_tuan4_5;

import java.io.Serializable;
import java.util.ArrayList;

public class dsSach implements Serializable{
	private ArrayList<Sach> dsSach;

	public dsSach(ArrayList<Sach> dsSach) {
		this.dsSach = dsSach;
	}

	public dsSach() {
		this.dsSach = new ArrayList<Sach>();
	}
	
	public Sach getSach(int i) {
		if(i>=0 && i<dsSach.size())
			return dsSach.get(i);
		return null;
	}

	public ArrayList<Sach> getDsSach() {
		return dsSach;
	}

	public void setDsSach(ArrayList<Sach> dsSach) {
		this.dsSach = dsSach;
	}
	
	public boolean add(Sach Sach) {
		for (Sach sach : dsSach) {
			if(Sach.getMaSach().equalsIgnoreCase(sach.getMaSach()))
				return false;
		}
		dsSach.add(Sach);
		return true;
	}
	
	public boolean xoaViTri(int i) {
		if(i >= 0 && i < dsSach.size()) {
			dsSach.remove(i);
			return true;
		}else
			return false;
	}
	
	public Sach timKiemSach(String masach) {
		Sach s = new Sach(masach);
		if(dsSach.contains(s))
			return dsSach.get(dsSach.indexOf(s));
		return null;
	}
	
	public int count() {
		return dsSach.size();
	}

	@Override
	public String toString() {
		return "dsSach [dsSach=" + dsSach + "]";
	}
	
}
