package truongQuocBao_21017351_tuan3;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class fromNV extends JFrame{
	private JTable table;
	private DefaultTableModel model;
	private ArrayList<NhanVien> dsnv;
	
	public fromNV(ArrayList<NhanVien> dsnv,String title) {
		setTitle(title);
		setSize(600,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		this.dsnv = dsnv;
		String column[] = {"Mã","Họ","Tên","Phòng ban","Tuổi","Tiền lương"};
		table = new JTable(model = new DefaultTableModel(column, 0));
		
		for(int i=0;i<dsnv.size();i++) {
			NhanVien nv = dsnv.get(i);
			String[] row = {nv.getMaSo(),nv.getHo(),nv.getTen(),nv.getPb().toString(),nv.getTuoi()+"",nv.getLuong()+""};
			model.addRow(row);
		}
		table.setRowHeight(30);
		add(new JScrollPane(table),BorderLayout.CENTER);
	}
}
