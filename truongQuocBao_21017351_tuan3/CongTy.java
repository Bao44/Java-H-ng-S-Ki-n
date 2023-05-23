package truongQuocBao_21017351_tuan3;

import java.util.ArrayList;

public class CongTy {
	private ArrayList<PhongBan> dspb;

	public CongTy() {
		dspb = new ArrayList<PhongBan>();
	}
	public void themMoiPhongBan(PhongBan pb) {
		dspb.add(pb);
	}
	public ArrayList<PhongBan> getDsPB(){
		return dspb;
	}
}
