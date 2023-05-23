package truongQuocBao_21017351_tuan4_5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class GUI_Sach extends JFrame implements ActionListener,MouseListener{
	private JLabel lbMaSach,lbTuaSach,lbTacGia,lbNamSX,lbNXB,lbSoTrang,lbDonGia,lbISBN,lbTim;
	private JTextField txtMaSach,txtTuaSach,txtTacGia,txtNamSX,txtNXB,txtSoTrang,txtDonGia,txtISBN,txtMess;
	private JButton btThem,btXoaRong,btSua,btXoa,btLuu;
	private JTable table;
	private DefaultTableModel model;
	private dsSach ds;
	private Database data;
	private JComboBox combobox;
	
	public GUI_Sach() {
		setTitle("Quản lí sách");
		setSize(1000,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		ds = new dsSach();
		create_GUI();
		data = new Database();
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
		//add(border,BorderLayout.NORTH);
		
		Box b = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		
		b.add(b1);
		b.add(Box.createVerticalStrut(40));
		b.add(b2);

		//header
		JPanel header = new JPanel();
		header.setLayout(null);
		b1.setBorder(BorderFactory.createTitledBorder("Records Editor"));
		
		//mã sách
		lbMaSach = new JLabel("Mã sách:");
		lbMaSach.setBounds(3,20,80,30);
		txtMaSach = new JTextField();
		txtMaSach.setBounds(85,25,270,20);
		header.add(lbMaSach);
		header.add(txtMaSach);
		
		// tựa sách
		lbTuaSach = new JLabel("Tựa sách:");
		lbTuaSach.setBounds(3,50,80,30);
		txtTuaSach = new JTextField();
		txtTuaSach.setBounds(85,55,370,20);
		header.add(lbTuaSach);
		header.add(txtTuaSach);
		
		// nam sản xuất
		lbNamSX = new JLabel("Năm xuất bản:");
		lbNamSX.setBounds(3,80,80,30);
		txtNamSX = new JTextField();
		txtNamSX.setBounds(85,85,370,20);
		header.add(lbNamSX);
		header.add(txtNamSX);
		
		//số trang
		lbSoTrang = new JLabel("Số trang:");
		lbSoTrang.setBounds(3,110,80,30);
		txtSoTrang = new JTextField();
		txtSoTrang.setBounds(85,115,370,20);
		header.add(lbSoTrang);
		header.add(txtSoTrang);
		
		//ISBN
		lbISBN = new JLabel("International Standard Book Number (ISBN):");
		lbISBN.setBounds(2,140,300,30);
		txtISBN = new JTextField();
		txtISBN.setBounds(255,145,200,20);
		header.add(lbISBN);
		header.add(txtISBN);
		
		txtMess = new JTextField();
		header.add(txtMess);
		txtMess.setEditable(false);
		txtMess.setFont(new Font("Arial", Font.ITALIC, 12));
		txtMess.setBorder(null);
		txtMess.setForeground(Color.red);
		txtMess.setBounds(20, 170, 550, 20);
		
		//tác giả
		lbTacGia = new JLabel("Tác Giả:");
		lbTacGia.setBounds(550,50,50,30);
		txtTacGia = new JTextField();
		txtTacGia.setBounds(630,55,350,20);
		header.add(lbTacGia);
		header.add(txtTacGia);
		
		lbNXB = new JLabel("Nhà xuất bản:");
		lbNXB.setBounds(550,80,80,30);
		txtNXB = new JTextField();
		txtNXB.setBounds(630,85,350,20);
		header.add(lbNXB);
		header.add(txtNXB);
		
		lbDonGia = new JLabel("Đơn giá:");
		lbDonGia.setBounds(550,110,80,30);
		txtDonGia = new JTextField();
		txtDonGia.setBounds(630,115,350,20);
		header.add(lbDonGia);
		header.add(txtDonGia);
		
		b1.add(header);
		border.add(b,BorderLayout.CENTER);	
		

		// button
		btThem = new JButton("Thêm");
		btThem.setBounds(110,220,70,25);
		btXoaRong = new JButton("Xóa rỗng");
		btXoaRong.setBounds(185,220,90,25);
		btSua = new JButton("Sửa");
		btSua.setBounds(280,220,60,25);
		btXoa = new JButton("Xóa");
		btXoa.setBounds(345,220,60,25);
		btLuu = new JButton("Lưu");
		btLuu.setBounds(410,220,60,25);
		add(btThem);
		add(btXoaRong);
		add(btSua);
		add(btXoa);
		add(btLuu);
		
		lbTim = new JLabel("Tìm theo mã sách");
		lbTim.setBounds(550,220,100,25);
		add(lbTim);
		combobox = new JComboBox();
		combobox.setBounds(655,220,70,25);
		add(combobox);
		add(b);
		
		
		
		// table
		b2.setBorder(BorderFactory.createTitledBorder("Danh sách các cuốn sách"));
		
		model = new DefaultTableModel();
		table = new JTable(model);
		model.addColumn("Mã sách");
		model.addColumn("Tựa sách");
		model.addColumn("Tác giả");
		model.addColumn("Năm xuất bản");
		model.addColumn("Nhà xuất bản");
		model.addColumn("Số trang");
		model.addColumn("Đơn giá");
		model.addColumn("ISBN");
		
		TableColumn tableColumn = new TableColumn();
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		
		DefaultTableCellRenderer table_right = new DefaultTableCellRenderer();
		table_right.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		
		table.getColumnModel().getColumn(3).setCellRenderer(table_right);
		table.getColumnModel().getColumn(5).setCellRenderer(table_right);
		table.getColumnModel().getColumn(6).setCellRenderer(table_right);
		
		JScrollPane scroll = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setPreferredSize(new Dimension(0,100));
		b2.add(scroll);
		
		this.add(b);
		
		updateComboboxData();
		
		
		btThem.addActionListener(this);
		btLuu.addActionListener(this);
		btXoa.addActionListener(this);
		btXoaRong.addActionListener(this);
		table.addMouseListener(this);
		combobox.addActionListener(this);
	}
	public static void main(String[] args) {
		new GUI_Sach();
	}
	
	private void loadData() throws Exception{
		//ds = (dsSach)data.readFile("Sach.dat");
		
		ds = data.read_Sach("Sach.txt");
		
		
		if(ds == null)
			ds = new dsSach();
		else {
			for (Sach s : ds.getDsSach()) {
				String[] row = {s.getMaSach(), s.getTuaSach(),
								s.getTacGia(), s.getNamSX()+"",
								s.getnXB(), s.getSoTrang()+"",
								s.getDonGia()+"",s.getiSBN()};
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
				txtMaSach.requestFocus();
				
				btXoa.setEnabled(false);
				btThem.setText("Hủy");
			}else {
				btThem.setText("Thêm");
				btXoa.setEnabled(true);
			}
		}else if(o.equals(btLuu)) {
			if(txtMaSach.getText().equals("") || txtTuaSach.getText().equals("") || txtTacGia.getText().equals(""))
				JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin");
			else {
				try {
					luu();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			xoaTrang();
			this.btThem.setText("Thêm");
			this.btXoa.setEnabled(true);
		}else if(o.equals(btXoa)) {
			try {
				xoaDong();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}else if(o.equals(btXoaRong))
			xoaTrang();
		else if(o.equals(combobox)) {
			String masach = (String) combobox.getSelectedItem();
			Sach s = ds.timKiemSach(masach);
			if(s!=null) {
				int index = ds.getDsSach().indexOf(s);
				
				txtMaSach.setEditable(false);
				txtMaSach.setText(model.getValueAt(index, 0).toString());
				txtTuaSach.setText(model.getValueAt(index, 1).toString());
				txtTacGia.setText(model.getValueAt(index, 2).toString());
				txtNamSX.setText(model.getValueAt(index, 3).toString());
				txtNXB.setText(model.getValueAt(index, 4).toString());
				txtSoTrang.setText(model.getValueAt(index, 5).toString());
				txtDonGia.setText(model.getValueAt(index, 6).toString());
				txtISBN.setText(model.getValueAt(index, 7).toString());
				
				table.getSelectionModel().setSelectionInterval(index, index);
				table.scrollRectToVisible(table.getCellRect(index, index, true));
			}
		}
	}
	
	public boolean validData() {
		String masach = txtMaSach.getText().trim();
		String tuasach = txtTuaSach.getText().trim();
		String tacgia = txtTacGia.getText().trim();
		String namxb = txtNamSX.getText().trim();
		String nhaxb = txtNXB.getText().trim();
		String sotrang = txtSoTrang.getText().trim();
		String dongia = txtDonGia.getText().trim();
		String isbn = txtISBN.getText().trim();
		
		if(masach.equals("")) {
			showMessage("Mã sách không được rỗng", txtMaSach);;
			return false;
		}else if(tuasach.equals("")) {
			showMessage("Tựa sách không được rỗng", txtTuaSach);
			return false;
		}else if(tacgia.equals("")) {
			showMessage("Tác giả không được rỗng", txtTacGia);
			return false;
		}else if(isbn.equals("")) {
			showMessage("ISBN không được rỗng", txtISBN);
			return false;
		}else {
			if(!masach.matches("^[a-zA-z]\\d{3}$")) {
				showMessage(
						"Mã sách phải theo qui ước sau: Có ký tự đầu là ký tự đầu của tựa sách, theo sau là 3 ký số",
						txtMaSach);
				return false;
			}else if(masach.charAt(0) != tuasach.charAt(0)) {
				showMessage("Mã sách phải có kí tự đầu của tựa sách", txtMaSach);
				return false;
			}else if(!isbn.matches("^\\d+-\\d+-\\d+-\\d+(-\\d+)?$")) {
				showMessage("ISBN có mẫu dạng X-X-X-X (hoặc X-X-X-X-X). Trong đó, X gồm các ký số, ít nhất là 1 ký số",
						txtISBN);
				return false;
			}else
				return true;
		}
	}
	
	public void showMessage(String mess, JTextField txt) {
		txt.requestFocus();
		txtMess.setText(mess);
	}
	
	private void xoaDong() throws Exception{
		int r = table.getSelectedRow();
		if(r != -1) {
			int thongBao = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa dòng này không?","Delete",JOptionPane.YES_NO_OPTION);
			if(thongBao == JOptionPane.YES_OPTION) {
				ds.xoaViTri(r);
				model.removeRow(r);
				txtMess.setText("Xoa thanh cong");
				updateComboboxData();
				xoaTrang();
				
				data.writeSach("Sach.txt", ds);
				//data.saveFile("Sach.dat", ds);
			}
		}else {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng cần xóa!");
		}
		
		
	}

	private void luu() throws Exception{
		String msach = txtMaSach.getText();
		String tuasach = txtTuaSach.getText();
		String tacgia = txtTacGia.getText();
		String namxb = txtNamSX.getText();
		String nxb = txtNXB.getText();
		String sotrang = txtSoTrang.getText();
		String dongia = txtDonGia.getText();
		String isbn = txtISBN.getText();
		
		Sach s = new Sach(msach, tuasach, tacgia, Integer.parseInt(namxb), nxb, Integer.parseInt(sotrang), Integer.parseInt(dongia),isbn);
		if(validData()) {
			if(ds.add(s)) {
				//JOptionPane.showMessageDialog(this, "Thêm thành công");
				txtMess.setText("Them thanh cong 1 cuon sach");
				String [] row = {msach, tuasach, tacgia,namxb, nxb, sotrang, dongia,isbn};
				
				updateComboboxData();
				
				model.addRow(row);
				
				data.writeSach("Sach.txt", ds);
				
				//data.saveFile("Sach.dat", ds);
			}else {
				showMessage("Error: Trung ma sach", txtMaSach);
				txtMaSach.setText("");
			}
		}
	}
	
	public void updateComboboxData() {
		int n = ds.count();
		String[] items = new String[n];
		int i = 0;
		for(Sach s : ds.getDsSach()) {
			items[i] = s.getMaSach();
			i++;
		}
		combobox.setModel(new DefaultComboBoxModel<String>(items));
	}
	


	public void xoaTrang() {
		txtMaSach.setText("");
		txtTuaSach.setText("");
		txtTacGia.setText("");
		txtNamSX.setText("");
		txtNXB.setText("");
		txtSoTrang.setText("");
		txtDonGia.setText("");
		txtISBN.setText("");
		txtMaSach.requestFocus();
	}
	
	public void mouseClicked(MouseEvent e) {
		int vitri = table.getSelectedRow();//Lấy vị trí được chọn trong table
		Sach s = ds.getSach(vitri);
		//Lấy thông tin sinh viên tại vitri trong danh sách SV
		
		//Nạp thông tin của sinh viên vào các components tương úng
		napLaiThongTin(s);
	}
	
	private void napLaiThongTin(Sach s) {
		txtMaSach.setText(s.getMaSach());
		txtTuaSach.setText(s.getTuaSach());			
		txtTacGia.setText(s.getTacGia());
		txtNamSX.setText(s.getNamSX()+"");
		txtNXB.setText(s.getnXB());
		txtSoTrang.setText(s.getSoTrang()+"");
		txtDonGia.setText(s.getDonGia()+"");
		txtISBN.setText(s.getiSBN());
		txtMaSach.requestFocus();
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
