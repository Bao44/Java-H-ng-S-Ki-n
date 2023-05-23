package demo2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import demo.Database;

public class GUI extends JFrame implements ActionListener,MouseListener{
	private Database data;
	private dsPhong2 ds;
	private JLabel lbMP,lbTP,lbLP,lbDT,lbGC,lbNMP;
	private JTextField txtMP,txtTP,txtDT,txtGC,txtNMP;
	private JComboBox combobox;
	private JButton btTim,btThem,btXoa,btXoaTrang,btLuu;
	private JTable table;
	private DefaultTableModel model;
	private JPanel center;
	
	public GUI() {
		setTitle("21017351_Truong Quoc Bao");
		setSize(800,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ds = new dsPhong2();
		data = new Database();
		create_GUI();
		try {
			loadData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		setVisible(true);
	}
	
	public void create_GUI() {
		JPanel border = new JPanel();
		border.setLayout(new BorderLayout());
		
		JPanel north = new JPanel();
		JLabel title = new JLabel("THÔNG TIN PHÒNG");
		title.setForeground(Color.BLUE);
		title.setFont(new Font("Arial",Font.BOLD,25));
		north.add(title);
		border.add(north,BorderLayout.NORTH);
		
		
		center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.X_AXIS));
		
		Box b = Box.createVerticalBox();
		Box b1 = Box.createVerticalBox();
		
		b.add(b1);
		b.add(Box.createVerticalStrut(50));
		
		center.add(b);
		center.add(Box.createHorizontalStrut(10));
		
		lbMP = new JLabel("Mã phòng");
		txtMP = new JTextField();
		b1.add(lbMP);
		b1.add(txtMP);
		
		lbTP = new JLabel("Tên phòng");
		txtTP = new JTextField();
		b1.add(lbTP);
		b1.add(txtTP);
		
		lbLP = new JLabel("Loại phòng");
		combobox = new JComboBox(); 
		combobox.addItem("A");
		combobox.addItem("B");
		combobox.addItem("C");
		combobox.addItem("D");
		b1.add(lbLP);
		b1.add(combobox);
		
		lbDT = new JLabel("Diện tích");
		txtDT = new JTextField();
		b1.add(lbDT);
		b1.add(txtDT);
		
		lbGC = new JLabel("Ghi chú");
		txtGC = new JTextField();
		b1.add(lbGC);
		b1.add(txtGC);
		
		create_table();
		
		border.add(center,BorderLayout.CENTER);
		
		
		JPanel south = new JPanel();
		lbNMP = new JLabel("Nhập mã phòng: ");
		txtNMP = new JTextField(15);
		btTim = new JButton("Tìm");
		btThem = new JButton("Thêm");
		btXoa = new JButton("Xóa");
		btXoaTrang = new JButton("Xóa trắng");
		btLuu = new JButton("Lưu");
		
		south.add(lbNMP);
		south.add(txtNMP);
		south.add(btTim);
		south.add(btThem);
		south.add(btXoa);
		south.add(btXoaTrang);
		south.add(btLuu);
		
		border.add(south,BorderLayout.SOUTH);
		
		this.add(border);
		
		
		btThem.addActionListener(this);
		btXoa.addActionListener(this);
		btXoaTrang.addActionListener(this);
		btLuu.addActionListener(this);
		btTim.addActionListener(this);
		
		table.addMouseListener(this);
	}
	
	public void create_table() {
		model = new DefaultTableModel();
		table = new JTable(model);
		model.addColumn("Mã phòng");
		model.addColumn("Tên phòng");
		model.addColumn("Loại phòng");
		model.addColumn("Diện tích");
		model.addColumn("Ghi chú");
		
		JScrollPane croll = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		croll.setPreferredSize(new Dimension(500,50));
		center.add(croll);
	}
	
	public static void main(String[] args) {
		new GUI();
	}
	
	public void loadData() {
		ds = (dsPhong2)data.readFile("Phong2.dat");
		if(ds == null)
			ds = new dsPhong2();
		else {
			for(Phong2 p2 : ds.getDsPhong2()) {
				String []row = {p2.getMaPhong(),p2.getTenPhong(),p2.getLoaiPhong(),
								p2.getDienTich()+"",p2.getGhiChu()};
				model.addRow(row);
			}
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btThem)) {
			if(btThem.getText().equals("Thêm")) {
				xoaTrang();
				txtMP.requestFocus();
				
				btXoa.setEnabled(false);
				btThem.setText("Hủy");
			}else {
				btXoa.setEnabled(true);
				btThem.setText("Thêm");
			}
		}else if(o.equals(btXoaTrang))
			xoaTrang();
		else if(o.equals(btLuu)) {
			if(txtMP.getText().equals("") || txtTP.getText().equals("") || 
				txtDT.getText().equals("") || txtGC.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Chưa nhập thông tin");
			}else {
				try {
					luu();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			xoaTrang();
			btXoa.setEnabled(true);
			btThem.setText("Thêm");
		}else if(o.equals(btXoa)) {
			try {
				xoa();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}else if(o.equals(btTim)) {
			int pos = ds.timKiem(txtNMP.getText());
			if(pos == -1) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy mã");
			}else {
				table.setRowSelectionInterval(pos, pos);
			}
		}
		
	}
	
	public void luu() throws Exception{
		String mp = txtMP.getText();
		String tp = txtTP.getText();
		String lp = combobox.getSelectedItem().toString();
		String dt = txtDT.getText();
		String gc = txtGC.getText();
		
		Phong2 phong2 = new Phong2(mp, tp, lp, Double.parseDouble(dt), gc);
		if(ds.add(phong2)) {
			JOptionPane.showMessageDialog(this, "Thêm thành công");
				String []row = {mp,tp,lp,dt,gc};
				model.addRow(row);
				xoaTrang();
				data.saveFile("Phong2.dat", ds);
		}else {
			JOptionPane.showMessageDialog(this, "Mã phòng đã tồn tại");
		}
	}
	
	public void xoa() throws Exception{
		int r =  table.getSelectedRow();
		if(r != -1) {
			int tb = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa dòng này!","Delete",JOptionPane.YES_NO_OPTION);
			if(tb == JOptionPane.YES_OPTION) {
				ds.xoa(r);
				model.removeRow(r);
				xoaTrang();
				data.saveFile("Phong2.dat", ds);
			}
		}else {
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng cần xóa");
		}
	}
	
	public void xoaTrang() {
		txtMP.setText("");
		txtTP.setText("");
		combobox.setSelectedIndex(0);
		txtDT.setText("");
		txtGC.setText("");
		txtMP.requestFocus();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int vitri = table.getSelectedRow();
		Phong2 p = ds.getPhong2(vitri);
		
		txtMP.setText(p.getMaPhong());
		txtTP.setText(p.getTenPhong());
		combobox.setSelectedItem(p.getLoaiPhong());
		txtDT.setText(p.getDienTich()+"");
		txtGC.setText(p.getGhiChu());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
