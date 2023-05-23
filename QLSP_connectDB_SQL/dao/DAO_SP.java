package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connectDB.ConnectDB;
import entity.sanPham;

public class DAO_SP {
	public ArrayList<sanPham> getAllSP(){
		ArrayList<sanPham> list = new ArrayList<sanPham>();
		Connection con = ConnectDB.getConnection();
		ConnectDB.getInstance();
		try {
			String sql = "SELECT * FROM thongtinSanPham";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				sanPham sp = new sanPham(
						rs.getString("maLoaiXe"),
						rs.getString("loaiXe"),
						rs.getString("nuocSX"),
						rs.getLong("giaBan"),
						rs.getInt("soLuong"),
						rs.getString("soSuon"),
						rs.getString("soKhung"),
						rs.getInt("soPK"));
				list.add(sp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean addSP(sanPham sp) {
		Connection con = connectDB.ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("INSERT INTO thongtinSanPham values(?,?,?,?,?,?,?,?)");
			stmt.setString(1, sp.getMaLoaiXe());
			stmt.setString(2, sp.getLoaiXe());
			stmt.setString(3, sp.getNuocSX());
			stmt.setLong(4, sp.getGiaBan());
			stmt.setInt(5, sp.getSoLuong());
			stmt.setString(6, sp.getSoSuon());
			stmt.setString(7, sp.getSoKhung());
			stmt.setInt(8, sp.getSoPK());
			return stmt.executeUpdate()>0;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Thêm không thành công");
			e.printStackTrace();
		}finally {
			close(stmt);
		}
		return false;
	}
	
	public static void delete(String ma) {
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "DELETE FROM thongtinSanPham WHERE maLoaiXe = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, ma);
			pst.executeUpdate();
			ConnectDB.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void updateGia(String ma,long giaMoi) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement("UPDATE thongtinSanPham set giaban = ? where maLoaiXe = ?");
			pst.setLong(1, giaMoi);
			pst.setString(2, ma);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pst.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public static void updateSL(String ma,int sl) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement("UPDATE thongtinSanPham set soLuong = ? where maLoaiXe = ?");
			pst.setInt(1, sl);
			pst.setString(2, ma);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pst.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	private void close(PreparedStatement stmt) {
		if(stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}










