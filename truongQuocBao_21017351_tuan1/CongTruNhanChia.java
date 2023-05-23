package truongQuocBao_21017351_tuan1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class CongTruNhanChia extends JFrame implements ActionListener{
	private JButton buttonGiai,buttonXoa,buttonThoat;
	private JTextField txtA,txtB,txtAns;
	private JRadioButton cong,tru,nhan,chia;
	public CongTruNhanChia() {
		setTitle("Cộng-Trừ-Nhân-Chia");
		setSize(600,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		createGUI();
		setVisible(true);
	}
	
	
	private void createGUI() {
		title();
		west();
		center();
		south();
	}
	private void title() {
		Font font = new Font("Arial",Font.BOLD,30);
		JLabel title = new JLabel("Cộng Trừ Nhân Chia",SwingConstants.CENTER);
		title.setFont(font);
		title.setForeground(Color.BLUE);
		title.setOpaque(true);
		add(title,BorderLayout.NORTH);
	}
	
	private void west() {
		JPanel panelWest = new JPanel();
		add(panelWest,BorderLayout.WEST);
		panelWest.setLayout(new GridLayout(7,1,0,10));
		panelWest.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		panelWest.setPreferredSize(new Dimension(100, 100));
		
		panelWest.add(buttonGiai = new JButton("Giải"));
		panelWest.add(buttonXoa = new JButton("Xóa"));
		panelWest.add(buttonThoat = new JButton("Thoát"));
		panelWest.setBackground(Color.LIGHT_GRAY);
	}
	
	private void center() {
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(null);
		add(panelCenter,BorderLayout.CENTER);
		panelCenter.setBorder(BorderFactory.createTitledBorder("Tính toán"));
		
		JLabel lblA,lblB,lblAns ;
		panelCenter.add(lblA = new JLabel("Nhập a: "));
		lblA.setBounds(80, 40, 100, 30);
		panelCenter.add(txtA = new JTextField(10));
		txtA.setBounds(140, 40,250,30);
		
		panelCenter.add(lblB = new JLabel("Nhập b: "));
		lblB.setBounds(80, 85, 100, 30);
		panelCenter.add(txtB = new JTextField(10));
		txtB.setBounds(140, 85,250,30);
		
		JPanel panel_miniCenter = new JPanel();
		panelCenter.add(panel_miniCenter);
		panel_miniCenter.setLayout(new GridLayout(2,2));
		panel_miniCenter.setBounds(140, 120, 250, 100);
		panel_miniCenter.setBorder(BorderFactory.createTitledBorder("Phép toán"));
		
		
		ButtonGroup group = new ButtonGroup();
		group.add(cong = new JRadioButton("Cộng"));
		group.add(tru = new JRadioButton("Trừ"));
		group.add(nhan = new JRadioButton("Nhân"));
		group.add(chia = new JRadioButton("Chia"));
		
		panel_miniCenter.add(cong);
		panel_miniCenter.add(tru);
		panel_miniCenter.add(nhan);
		panel_miniCenter.add(chia);
		
		panelCenter.add(lblAns = new JLabel("Kết quả: "));
		lblAns.setBounds(80, 230, 100, 30);
		panelCenter.add(txtAns = new JTextField(10));
		txtAns.setBounds(140, 230,250,30);
		txtAns.setEditable(false);
		
		buttonGiai.addActionListener(this);
		buttonXoa.addActionListener(this);
		buttonThoat.addActionListener(this);
		setVisible(true);
	}
	
	private void south() {
		Font font = new Font("Arial",Font.BOLD,25);
		JPanel panelSouth = new JPanel();
		add(panelSouth,BorderLayout.SOUTH);
		panelSouth.setBackground(Color.PINK);
		panelSouth.setPreferredSize(new Dimension(100, 50));
		Button a = new Button("   ");
		Button b = new Button("   ");
		Button c = new Button("   ");
		panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		panelSouth.add(a,BorderLayout.NORTH);
		a.setFont(font);
		a.setBackground(Color.BLUE);
		a.setPreferredSize(new Dimension(30,20));
		panelSouth.add(b,BorderLayout.NORTH);
		b.setFont(font);
		b.setBackground(Color.RED);
		b.setPreferredSize(new Dimension(30,20));
		panelSouth.add(c,BorderLayout.NORTH);
		c.setFont(font);
		c.setBackground(Color.YELLOW);
		c.setPreferredSize(new Dimension(30,20));
	}
	
	public static void main(String[] args) {
		new CongTruNhanChia();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(buttonThoat))
			System.exit(0);
		else if(o.equals(buttonXoa)) {
			txtA.setText("");
			txtB.setText("");
			txtAns.setText("");
			txtA.requestFocus();
		}else if(o.equals(buttonGiai)) {
			if(!isInt(txtA))
				focus(txtA);
			else if(!isInt(txtB))
				focus(txtB);
			else {
				int a = Integer.parseInt(txtA.getText());
				int b = Integer.parseInt(txtB.getText());
				if(cong.isSelected())
					txtAns.setText("" + (a+b));
				else if(tru.isSelected())
					txtAns.setText("" + (a-b));
				else if(nhan.isSelected())
					txtAns.setText("" + (a*b));
				else
					txtAns.setText("" + ((float)a/b));
			}
		}
	}
	
	
	// kiem tra gia tri nhap vao la so nguyen
	private boolean isInt(JTextField text) {
		try {
			Integer.parseInt(text.getText());
		} catch (NumberFormatException ex) {
			return false;
		}
		return true;
	}
	
	// neu nhap sai se tra ve thong bao
	private void focus(JTextField text) {
		JOptionPane.showMessageDialog(null, "Lỗi nhập liệu");
		text.selectAll();
		text.requestFocus();
	}
}
