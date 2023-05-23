package truongQuocBao_21017351_tuan1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class phuongTrinhBac2_View extends JFrame implements ActionListener{
	private JTextField txtA,txtB,txtC,txtAns;
	private JButton buttonGiai,butonXoa,buttonThoat;
	public phuongTrinhBac2_View() {
		this.setTitle("^.^");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		giaiPT();
		this.setVisible(true);
	}
	
	private void giaiPT() {
		Font font = new Font("Arial",Font.BOLD,25);
		JLabel title = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC HAI",SwingConstants.CENTER);
		title.setFont(font);
		title.setBackground(Color.CYAN);
		title.setOpaque(true);
		add(title,BorderLayout.NORTH);
		
		
		
		JPanel panelCenter = new JPanel();
		add(panelCenter,BorderLayout.CENTER);
		panelCenter.setLayout(null);
		
		
		
		int x = 60,y = 40,with = 100, height = 30;
		JLabel lBlNhapA = new JLabel("Nhập a: ");
		panelCenter.add(lBlNhapA);
		lBlNhapA.setBounds(x, y, with, height);
		
		JLabel lBlNhapB = new JLabel("Nhập b: ");
		panelCenter.add(lBlNhapB);
		y+=50;
		lBlNhapB.setBounds(x, y, with, height);
		
		JLabel lBlNhapC = new JLabel("Nhập c: ");
		panelCenter.add(lBlNhapC);
		y+=50;
		lBlNhapC.setBounds(x, y, with, height);

		JLabel lBlAns = new JLabel("Kết quả: ");
		panelCenter.add(lBlAns);
		y+=50;
		lBlAns.setBounds(x, y, with, height);
		
		
		x += 100;y = 40; with = 350;
		panelCenter.add(txtA = new JTextField());
		txtA.setBounds(x, y, with, height);
		
		panelCenter.add(txtB = new JTextField());
		y+=50;
		txtB.setBounds(x, y, with, height);
		
		panelCenter.add(txtC = new JTextField());
		y+=50;
		txtC.setBounds(x, y, with, height);
		
		panelCenter.add(txtAns = new JTextField());
		y+=50;
		txtAns.setBounds(x, y, with, height);
		txtAns.setEditable(false);
		
		
		JPanel panelSouth = new JPanel();
		this.add(panelSouth,BorderLayout.SOUTH);
		panelSouth.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		
		panelSouth.add(buttonGiai = new JButton("Giải"));
		panelSouth.add(butonXoa = new JButton("Xóa rỗng"));
		panelSouth.add(buttonThoat = new JButton("Xóa"));
		
		buttonGiai.addActionListener(this);
		butonXoa.addActionListener(this);
		buttonThoat.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new phuongTrinhBac2_View(); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(buttonThoat))
			System.exit(0);
		else if(o.equals(butonXoa)) {
			txtA.setText("");
			txtB.setText("");
			txtC.setText("");
			txtAns.setText("");
			txtA.requestFocus();
		}else if(o.equals(buttonGiai)) {
			if(!isInt(txtA)) {
				focus(txtA);
			}else if(!isInt(txtB)) {
				focus(txtB);
			}else if(!isInt(txtC)) {
				focus(txtC);
			}else {
				int a = Integer.parseInt(txtA.getText());
				int b = Integer.parseInt(txtB.getText());
				int c = Integer.parseInt(txtC.getText());
				if(a == 0)
					giaiPTBac1(b, c);
				else {
					float detal = b * b - 4 * a *c;
					if(detal < 0) {
						txtAns.setText("Vô nghiệm");
					}else if(detal == 0) {
						txtAns.setText("Nghiệm kép x1 = x2 = " + (-b / 2 * (float)a));
					}else {
						txtAns.setText("Có 2 nghiệm x1 = " + ((-b + Math.sqrt(detal)) / 2 * (float)a)
						+ ", x2 = " + ((-b - Math.sqrt(detal)) / 2 * (float)a));
					}
				}
			}
		}
	}
	
	private void giaiPTBac1(int a,int b) {
		if(a != 0) {
			txtAns.setText("Nghiệm x = " + (-b / (float)a));
		}else if(b == 0) {
			txtAns.setText("Vô số nghiệm");
		}else
			txtAns.setText("Vô nghiệm");
	}

	private void focus(JTextField txtA2) {
		// TODO Auto-generated method stub
		
	}

	private boolean isInt(JTextField text) {
		boolean result = true;
		try {
			Integer.parseInt(text.getText());
		} catch (NumberFormatException ex) {
			result = false;
		}
		return result;
	}
}

 