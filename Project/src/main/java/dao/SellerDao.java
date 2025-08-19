package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.DBConnection;
import model.Seller;

public class SellerDao {
	public static void insertSeller(Seller u) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "insert into seller(name,contact,address,email,password) values(?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, u.getName());
			pst.setLong(2, u.getContact());
			pst.setString(3, u.getAddress());
			pst.setString(4, u.getEmail());
			pst.setString(5, u.getPassword());
			pst.executeUpdate();
			System.out.println("data inserted");
//			pst.executeUpdate(); -> DML (insert,update,delete)
//			pst.executeQuery(); -> DQL (select)

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean checkEmail(String email) {
		boolean flag = false;
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from seller where email =?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static Seller sellerLogin(Seller u) {
		Seller u1 = null;
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from seller where email =? and password =?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, u.getEmail());
			pst.setString(2, u.getPassword());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				u1 = new Seller();
				u1.setId(rs.getInt("id"));
				u1.setName(rs.getString("name"));
				u1.setContact(rs.getLong("contact"));
				u1.setAddress(rs.getString("address"));
				u1.setEmail(rs.getString("email"));
				u1.setPassword(rs.getString("password"));
				System.out.println(u1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u1;

	}

	public static void updateProfile(Seller s) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "update seller set name=?,contact=?,address=?,email=? where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, s.getName());
			pst.setLong(2, s.getContact());
			pst.setString(3, s.getAddress());
			pst.setString(4, s.getEmail());
			pst.setInt(5, s.getId());
			pst.executeUpdate();
			System.out.println("data updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean checkOldPassword(String email, String op) {
		boolean flag = false;
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from seller where email =? and password=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, op);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static void changePassword(String email, String np) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "update seller set password=? where email=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, np);
			pst.setString(2, email);
			pst.executeUpdate();
			System.out.println("password updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
