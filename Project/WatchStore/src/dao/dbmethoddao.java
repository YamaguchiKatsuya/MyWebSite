package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dbmethod;

public class dbmethoddao {

	public static ArrayList<dbmethod> getAllDeliveryMethodDataBeans() throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManeger.getConnection();

			st = con.prepareStatement("SELECT * FROM delivery");

			ResultSet rs = st.executeQuery();

			ArrayList<dbmethod> deliveryMethodDataBeansList = new ArrayList<dbmethod>();
			while (rs.next()) {
				dbmethod dmdb = new dbmethod();
				dmdb.setId(rs.getInt("id"));
				dmdb.setMethod(rs.getString("method"));
				dmdb.setPrice(rs.getInt("price"));
				deliveryMethodDataBeansList.add(dmdb);
			}

			System.out.println("searching all DeliveryMethodDataBeans has been completed");

			return deliveryMethodDataBeansList;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public static dbmethod getDeliveryMethodDataBeansByID(int DeliveryMethodId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManeger.getConnection();

			st = con.prepareStatement(
					"SELECT * FROM delivery WHERE id = ?");
			st.setInt(1, DeliveryMethodId);

			ResultSet rs = st.executeQuery();

			dbmethod dmdb = new dbmethod();
			if (rs.next()) {
				dmdb.setId(rs.getInt("id"));
				dmdb.setMethod(rs.getString("method"));
				dmdb.setPrice(rs.getInt("price"));
			}

			System.out.println("searching DeliveryMethodDataBeans by DeliveryMethodID has been completed");

			return dmdb;
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
