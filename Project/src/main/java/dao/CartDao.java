package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import model.Cart;

public class CartDao {
	public static void addToCart(Cart c) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "insert into cart(pid, cus_id, pprice, qty, total_price,image, pname, pcategory, pdesc, payment_status) values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, c.getPid());
			pst.setInt(2, c.getCus_id());
			pst.setInt(3, c.getPprice());
			pst.setInt(4, c.getQty());
			pst.setInt(5, c.getTotal_price());
			pst.setString(6, c.getImage());
			pst.setString(7, c.getPname());
			pst.setString(8, c.getPcategory());
			pst.setString(9, c.getPdesc());
			pst.setString(10, c.getPayment_status());
			pst.executeUpdate();
			System.out.println("done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Cart> getCartByCustId(int cid) {
		List<Cart> list = new ArrayList<Cart>();
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from cart where cus_id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, cid);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Cart c = new Cart();
				c.setCart_id(rs.getInt("cart_id"));
				c.setPid(rs.getInt("pid"));
				c.setCus_id(rs.getInt("cus_id"));
				c.setPprice(rs.getInt("pprice"));
				c.setQty(rs.getInt("qty"));
				c.setTotal_price(rs.getInt("total_price"));
				c.setImage(rs.getString("image"));
				c.setPname(rs.getString("pname"));
				c.setPcategory(rs.getString("pcategory"));
				c.setPdesc(rs.getString("pdesc"));
				c.setPayment_status(rs.getString("payment_status"));
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static Cart getCartByCartId(int cart_id) {
		Cart c = null;
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from cart where cart_id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, cart_id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				c = new Cart();
				c.setCart_id(rs.getInt("cart_id"));
				c.setPid(rs.getInt("pid"));
				c.setCus_id(rs.getInt("cus_id"));
				c.setPprice(rs.getInt("pprice"));
				c.setQty(rs.getInt("qty"));
				c.setTotal_price(rs.getInt("total_price"));
				c.setImage(rs.getString("image"));
				c.setPname(rs.getString("pname"));
				c.setPcategory(rs.getString("pcategory"));
				c.setPdesc(rs.getString("pdesc"));
				c.setPayment_status(rs.getString("payment_status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
	public static void updateCart(Cart c) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql ="update cart set qty=?,total_price=?  where cart_id=?";
			PreparedStatement pst  = conn.prepareStatement(sql);
			pst.setInt(1, c.getQty());
			pst.setInt(2,c.getTotal_price());
			pst.setInt(3,c.getCart_id());
			pst.executeUpdate();
			System.out.println("cart updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
