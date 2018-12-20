package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.userdate;

public class Logindao {

	public userdate findById(String userName,String password) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManeger.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM w_user WHERE user_name = ? and password = ? ORDER BY id desc";
             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, userName);
            pStmt.setString(2, password);
            ResultSet rs = pStmt.executeQuery();
             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }
            int Id=rs.getInt("id");
            String UserName = rs.getString("user_name");
            String Password = rs.getString("password");

            return new userdate(Id,UserName,Password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }




	  public List<userdate> findAll() {
	        Connection conn = null;
	        List<userdate> userList = new ArrayList<userdate>();

	        try {
	            // データベースへ接続
	            conn = DBManeger.getConnection();

	         // SELECT文を準備
	            // TODO: 未実装：管理者以外を取得するようSQLを変更する
	            String sql = "SELECT * FROM w_user WHERE id <> 1 ORDER BY update_date desc";

	             // SELECTを実行し、結果表を取得
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);

	            // 結果表に格納されたレコードの内容を
	            // Employeeインスタンスに設定し、ArrayListインスタンスに追加
	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String userName = rs.getString("user_name");
	                String address = rs.getString("address");
	                String birthDate = rs.getString("birth_date");
	                String Password = rs.getString("password");
	                String createDate = rs.getString("create_date");
	                Timestamp updateDate = rs.getTimestamp("update_date");
	                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
	                sdf.format(updateDate);
	                userdate user = new userdate(id, userName, address, birthDate, Password, createDate, updateDate);

	                userList.add(user);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        } finally {
	            // データベース切断
	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                    return null;
	                }
	            }
	        }
	        return userList;
	    }

	  public List<userdate> search(String userName, String address,String Date1,String Date2) {
		    Connection conn = null;
		    List<userdate> userList = new ArrayList<userdate>();

		    try {
		        // データベースへ接続
		        conn = DBManeger.getConnection();

		     // SELECT文を準備
		        // TODO: 未実装：管理者以外を取得するようSQLを変更する
		        String sql = "SELECT * FROM w_user WHERE id <> 1 ";

			if (!userName.isEmpty()) {
				sql += "AND user_name like '%" + userName + "%' ";

			}
			if (!address.isEmpty()) {
				sql += "AND address like '%" + address + "%' ";

			}
			if (!Date1.isEmpty()) {
				sql += "AND birth_date>='" + Date1 + "' ";

			}
			if (!Date2.isEmpty()) {
				sql += "AND birth_date<='" + Date2 + "' ";
			}
			sql +="ORDER BY id desc";
		         // SELECTを実行し、結果表を取得
		        Statement stmt = conn.createStatement();
		        ResultSet rs = stmt.executeQuery(sql);

		        // 結果表に格納されたレコードの内容を
		        // Employeeインスタンスに設定し、ArrayListインスタンスに追加
		        while (rs.next()) {
		            int id = rs.getInt("id");
		            String  UserName = rs.getString("user_name");
		            String Address = rs.getString("address");
		            String birthDate = rs.getString("birth_date");
		            String Password = rs.getString("password");
		            String createDate = rs.getString("create_date");
		            Date updateDate = rs.getDate("update_date");
		            userdate user = new userdate(id, UserName, Address, birthDate, Password, createDate, updateDate);

		            userList.add(user);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return null;
		    } finally {
		        // データベース切断
		        if (conn != null) {
		            try {
		                conn.close();
		            } catch (SQLException e) {
		                e.printStackTrace();
		                return null;
		            }
		        }
		    }
		    return userList;
		}

}
