package truongQuocBao_21017351_tuan1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class hienThiNSoNguyenTo_View extends JFrame implements ActionListener{
	private JTextField txt;
	private JButton button;
	private JTextArea area;
	
	public hienThiNSoNguyenTo_View() {
		setTitle("Primes");
		setSize(500,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		create_GUI();
		setVisible(true);
	}
	
	public void create_GUI() {
		setLayout(null);
		txt = new JTextField();
		add(txt);
		txt.setBounds(90, 40, 200, 30);
		txt.setToolTipText("Nhập số nguyên tố cần hiển thị");
		
		button = new JButton("Generate");
		add(button);
		button.setBounds(290, 39, 100, 30);
		
		
		JScrollPane croll = new JScrollPane(area = new JTextArea());
		add(croll);
		croll.setBounds(90, 80, 300, 200);
		area.setToolTipText("Các số nguyên tố đã hiển thị");
		area.setEditable(false);
		
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setText("");
				try {
					int n = Integer.parseInt(txt.getText());
					if(n > 0) {
						for(int i = 2;i < Integer.MAX_VALUE;i ++) {
							if(isPrime(i)) {
								n--;
								area.append(i + "\n");
							}
							if(n == 0)
								break;
						}
					}
					else 
						JOptionPane.showMessageDialog(null, "Nhập số nguyên dương");
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Lỗi nhập liệu");
				}
				focus();
			}
		});
	}
	
	private void focus() {
		txt.selectAll();
		txt.requestFocus();
		return;
	}
	
	
	private boolean isPrime(int n) {
		for(int i=2;i<n;i++) {
			if(n%i==0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		new hienThiNSoNguyenTo_View();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}