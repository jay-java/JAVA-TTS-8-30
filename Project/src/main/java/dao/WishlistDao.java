package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import model.Wishlist;

public class WishlistDao {
	public static void addToWishlist(Wishlist w) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "insert into wishlist(pid,cid) values(?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, w.getPid());
			pst.setInt(2, w.getCid());
			pst.executeUpdate();
			System.out.println("added to wishlist");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static List<Wishlist> fetchWishlistByCid(int cid){
		List<Wishlist> list = new ArrayList<Wishlist>();
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from wishlist where cid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, cid);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Wishlist w = new Wishlist();
				w.setWid(rs.getInt("wid"));
				w.setPid(rs.getInt("pid"));
				w.setCid(rs.getInt("cid"));
				list.add(w);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void removeFromWishlist(int wid) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "delete from wishlist where wid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, wid);
			pst.executeUpdate();
			System.out.println("removed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean checkProductIntoWishlit(int pid,int cid) {
		boolean flag = false;
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from wishlist where pid=? and cid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, pid);
			pst.setInt(2, cid);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
