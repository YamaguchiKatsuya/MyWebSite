package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.buyDetail;

public class buyDetaildao {
	public static void insertBuyDetail(buyDetail bddb) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManeger.getConnection();
			st = con.prepareStatement(
					"INSERT INTO w_buy_detail(buy_id,item_id) VALUES(?,?)");
			st.setInt(1, bddb.getBuyId());
			st.setInt(2, bddb.getItemId());
			st.executeUpdate();
			System.out.println("inserting BuyDetail has been completed");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

}
