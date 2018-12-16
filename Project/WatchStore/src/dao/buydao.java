package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.buydate;
import model.itemdate;

public class buydao {
	public int buyInfo(int userId,int totalPrice,int deliveryId) throws SQLException {

		Connection con = null;
	    List<buydate> buyList = new ArrayList<buydate>();
	    int autoIncKey = -1;
	    PreparedStatement st = null;

	        // データベースへ接続
	    	try {
				con = DBManeger.getConnection();
				st = con.prepareStatement(
						"INSERT INTO w_buy(user_id,total_price,delivery,create_date) VALUES(?,?,?,now())",
						Statement.RETURN_GENERATED_KEYS);
				st.setInt(1, userId);
				st.setInt(2,totalPrice);
				st.setInt(3,deliveryId);
				st.executeUpdate();

				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					autoIncKey = rs.getInt(1);
				}
				System.out.println("inserting buy-datas has been completed");

				return autoIncKey;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				throw new SQLException(e);
			} finally {
				if (con != null) {
					con.close();
				}

			}
	    }
	public static buydate getBuyDataBeansByBuyId(int buyId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManeger.getConnection();

			st = con.prepareStatement(
					"SELECT * FROM w_buy"
							+ " JOIN delivery"
							+ " ON w_buy.delivery = delivery.id"
							+ " WHERE w_buy.id = ?");
			st.setInt(1, buyId);

			ResultSet rs = st.executeQuery();

			buydate bd = new buydate();
			if (rs.next()) {
				bd.setId(rs.getInt("id"));
				bd.setTotalPrice(rs.getInt("total_price"));
				bd.setBuyDate(rs.getDate("create_date"));
				bd.setDelivertMethodId(rs.getInt("delivery"));
				bd.setUserId(rs.getInt("user_id"));
				bd.setDeliveryMethodPrice(rs.getInt("price"));
				bd.setDeliveryMethodName(rs.getString("method"));
			}

			System.out.println("searching BuyDataBeans by buyID has been completed");

			return bd;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public List<buydate> find(String Id) {
        Connection conn = null;
        List<buydate> List = new ArrayList<buydate>();

        try {
            // データベースへ接続
            conn = DBManeger.getConnection();

         // SELECT文を準備
            // TODO: 未実装：管理者以外を取得するようSQLを変更する
            String sql = "select*from w_buy inner join delivery on w_buy.delivery = delivery.id WHERE w_buy.user_id="+Id+" order by w_buy.create_date desc";

             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Employeeインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                int userId = rs.getInt("user_id");
                int totalPrice = rs.getInt("total_price");
                int delivery = rs.getInt("delivery");
                Timestamp buyDate = rs.getTimestamp("create_date");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
                sdf.format(buyDate);
                String method=rs.getString("method");
                int Price = rs.getInt("price");

                buydate date = new buydate(id, userId, totalPrice, delivery,buyDate,method,Price);

                List.add(date);
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
        return List;
    }

	public List<itemdate> findData(String id) {
        Connection conn = null;
        List<itemdate> itemList = new ArrayList<itemdate>();

        try {
            // データベースへ接続
            conn = DBManeger.getConnection();

         // SELECT文を準備
            // TODO: 未実装：管理者以外を取得するようSQLを変更する
            String sql = "select*from w_buy_detail inner join w_item on w_buy_detail.item_id = w_item.id WHERE w_buy_detail.buy_id="+id+";";

             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Employeeインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int Id = rs.getInt("id");
                int buyId = rs.getInt("buy_id");
                int itemId = rs.getInt("item_id");
                String itemName=rs.getString("item_name");
                String detail=rs.getString("detail");
                String Price = rs.getString("price");
                String fileName=rs.getString("file_name");

                itemdate item = new itemdate(Id,buyId,itemId,itemName,detail,Price ,fileName);

                itemList.add(item);
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
        return itemList;
    }

	public List<buydate> findbuy(String Id) {
        Connection conn = null;
        List<buydate> List = new ArrayList<buydate>();

        try {
            // データベースへ接続
            conn = DBManeger.getConnection();

         // SELECT文を準備
            // TODO: 未実装：管理者以外を取得するようSQLを変更する
            String sql = "select*from w_buy inner join delivery on w_buy.delivery = delivery.id WHERE w_buy.id="+Id+" ";

             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Employeeインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                int userId = rs.getInt("user_id");
                int totalPrice = rs.getInt("total_price");
                int delivery = rs.getInt("delivery");
                Timestamp buyDate = rs.getTimestamp("create_date");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
                sdf.format(buyDate);
                String method=rs.getString("method");
                int Price = rs.getInt("price");

                buydate date = new buydate(id, userId, totalPrice, delivery,buyDate,method,Price);

                List.add(date);
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
        return List;
    }

}


