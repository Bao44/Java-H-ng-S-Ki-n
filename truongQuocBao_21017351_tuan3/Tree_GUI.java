package truongQuocBao_21017351_tuan3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class Tree_GUI extends JFrame{
	private JTree tree;
	private DefaultMutableTreeNode root;
	private ArrayList<PhongBan> dspb;
	
	
	public Tree_GUI(ArrayList<PhongBan> dspb) {
		setTitle("^-^");
//		setExtendedState(MAXIMIZED_BOTH);
		setSize(900, 600);
		setMinimumSize(new Dimension(800,550));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.dspb = dspb;
		
		root = new DefaultMutableTreeNode("Danh sách phòng ban");
		tree = new JTree(root);
		tree.setShowsRootHandles(true);
		
		int soPhongBan = dspb.size();
		
		for(int i=0;i<soPhongBan;i++) {
			PhongBan pb = dspb.get(i);
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(pb);
			root.add(node);
		}
		
		add(new JScrollPane(tree),BorderLayout.CENTER);
		
		tree.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					DefaultMutableTreeNode x = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
					if(x != null) {
						Object gt = x.getUserObject();
						if(gt instanceof PhongBan) {
							PhongBan pb = (PhongBan) x.getUserObject();
							ArrayList<NhanVien> dsnv = pb.getDsnv();
							
							fromNV gd = new fromNV(dsnv, pb.toString());
							gd.show();
						}
					}
				}
				
			}
		});
	}
	public static void main(String[] args) {
		CongTy ct = new CongTy();
		PhongBan tc,kt,ns,dn,bh;
		ct.themMoiPhongBan(tc = new PhongBan("TC", "Phòng tổ chức"));
		ct.themMoiPhongBan(kt = new PhongBan("KT", "Phòng kỹ thuật"));
		ct.themMoiPhongBan(ns = new PhongBan("NS", "Nhân sự"));
		ct.themMoiPhongBan(dn = new PhongBan("DN", "Đối ngoại"));
		ct.themMoiPhongBan(bh = new PhongBan("BH", "Bán hàng"));
		
		tc.themNV("0111", "Nguyễn", "An", false, 25, 3000);
		kt.themNV("0111", "Nguyễn", "An", false, 25, 3000);
		dn.themNV("0111", "Nguyễn", "An", false, 25, 3000);
		
		ArrayList<PhongBan> dspb = ct.getDsPB();
		new Tree_GUI(dspb).setVisible(true);
	}
}
