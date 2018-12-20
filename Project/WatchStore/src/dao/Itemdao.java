package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.brandDate;
import model.itemdate;

public class Itemdao {

	public List<itemdate> findAll() {
        Connection conn = null;
        List<itemdate> itemList = new ArrayList<itemdate>();

        try {
            // データベースへ接続
            conn = DBManeger.getConnection();

         // SELECT文を準備
            // TODO: 未実装：管理者以外を取得するようSQLを変更する
            String sql = "SELECT * FROM w_item ORDER BY id desc ";

             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Employeeインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                String brandName = rs.getString("brand_name");
                String itemName = rs.getString("item_name");
                String detail = rs.getString("detail");
                String price = rs.getString("price");
                String fileName = rs.getString("file_name");
                String createDate = rs.getString("create_date");
                Timestamp updateDate = rs.getTimestamp("update_date");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
                sdf.format(updateDate);
                itemdate item = new itemdate(id, itemName, detail, price, fileName, createDate, updateDate);

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
	public List<itemdate> search(String itemName, String detail,String price1,String price2) {
	    Connection conn = null;
	    List<itemdate> itemList = new ArrayList<itemdate>();

	    try {
	        // データベースへ接続
	        conn = DBManeger.getConnection();



	     // SELECT文を準備
	        // TODO: 未実装：管理者以外を取得するようSQLを変更する
	        String sql = "SELECT * FROM w_item WHERE id<>0 ";

		if (!itemName.isEmpty()) {
			sql += "AND item_name like '%" + itemName + "%' ";

		}
		if (!detail.isEmpty()) {
			sql += "AND detail like '%" + detail + "%' ";

		}
		if (!price1.isEmpty()) {
			sql += "AND price>='" + price1 + "' ";

		}
		if (!price2.isEmpty()) {
			sql += "AND price<='" + price2 + "' ";
		}
		sql +="ORDER BY id desc";
	         // SELECTを実行し、結果表を取得
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);

	        // 結果表に格納されたレコードの内容を
	        // Employeeインスタンスに設定し、ArrayListインスタンスに追加
	        while (rs.next()) {
                int id = rs.getInt("id");
                String itemname = rs.getString("item_name");
                String Detail = rs.getString("detail");
                String price = rs.getString("price");
                String fileName = rs.getString("file_name");
                String createDate = rs.getString("create_date");
                Date updateDate = rs.getDate("update_date");
                itemdate item = new itemdate(id, itemname, Detail, price, fileName, createDate, updateDate);

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

	public List<itemdate> searchuser(String searchWord,String price1,String price2) {
	    Connection conn = null;
	    List<itemdate> itemList = new ArrayList<itemdate>();

	    try {
	        // データベースへ接続
	        conn = DBManeger.getConnection();



	     // SELECT文を準備
	        // TODO: 未実装：管理者以外を取得するようSQLを変更する
	        String sql="SELECT*FROM w_item WHERE id<>0 ";

		if (!searchWord.isEmpty()) {
			sql += "AND item_name like '%"+searchWord+"%' OR detail like '%"+searchWord+"%' ";

		}

		if (!price1.isEmpty()) {
			sql += "AND price>='" + price1 + "' ";

		}
		if (!price2.isEmpty()) {
			sql += "AND price<='" + price2 + "' ";
		}
		sql +="ORDER BY id desc";

	         // SELECTを実行し、結果表を取得
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);

	        // 結果表に格納されたレコードの内容を
	        // Employeeインスタンスに設定し、ArrayListインスタンスに追加
	        while (rs.next()) {
                int id = rs.getInt("id");
                String itemname = rs.getString("item_name");
                String Detail = rs.getString("detail");
                String price = rs.getString("price");
                String fileName = rs.getString("file_name");
                String createDate = rs.getString("create_date");
                Date updateDate = rs.getDate("update_date");
                itemdate item = new itemdate(id, itemname, Detail, price, fileName, createDate, updateDate);

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
	public List<itemdate> cart(String Id) {
        Connection conn = null;
        List<itemdate> itemList = new ArrayList<itemdate>();

        try {
            // データベースへ接続
            conn = DBManeger.getConnection();

         // SELECT文を準備
            // TODO: 未実装：管理者以外を取得するようSQLを変更する
            String sql = "SELECT * FROM w_item WHERE id = "+Id;

             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Employeeインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                String itemName = rs.getString("item_name");
                String detail = rs.getString("detail");
                String price = rs.getString("price");
                String fileName = rs.getString("file_name");
                String createDate = rs.getString("create_date");
                Date updateDate = rs.getDate("update_date");
                itemdate item = new itemdate(id, itemName, detail, price, fileName, createDate, updateDate);

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

	public static int getTotalItemPrice(ArrayList<itemdate> items) {
		int total = 0;
		for (itemdate item : items) {
			total += Integer.parseInt(item.getPrice());
		}
		return total;
	}

	public List<itemdate> brandsearch(String itemName) {
	    Connection conn = null;
	    List<itemdate> itemList = new ArrayList<itemdate>();

	    try {
	        // データベースへ接続
	        conn = DBManeger.getConnection();



	     // SELECT文を準備
	        // TODO: 未実装：管理者以外を取得するようSQLを変更する
	        String sql = "SELECT * FROM w_item WHERE id<>1 ";

			sql += "AND item_name like '%" + itemName + "%' ";



	         // SELECTを実行し、結果表を取得
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);

	        // 結果表に格納されたレコードの内容を
	        // Employeeインスタンスに設定し、ArrayListインスタンスに追加
	        while (rs.next()) {
                int id = rs.getInt("id");
                String itemname = rs.getString("item_name");
                String Detail = rs.getString("detail");
                String price = rs.getString("price");
                String fileName = rs.getString("file_name");
                String createDate = rs.getString("create_date");
                Date updateDate = rs.getDate("update_date");
                itemdate item = new itemdate(id, itemname, Detail, price, fileName, createDate, updateDate);

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


public List<brandDate> findBrand() {
    Connection conn = null;
    List<brandDate> brandList = new ArrayList<brandDate>();

    try {
        // データベースへ接続
        conn = DBManeger.getConnection();

     // SELECT文を準備
        // TODO: 未実装：管理者以外を取得するようSQLを変更する
        String sql = "SELECT * FROM w_brand ";

         // SELECTを実行し、結果表を取得
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        // 結果表に格納されたレコードの内容を
        // Employeeインスタンスに設定し、ArrayListインスタンスに追加
        while (rs.next()) {
            int id = rs.getInt("id");
            String brandName = rs.getString("brand_name");
            String fileName = rs.getString("file_name");
            brandDate brand = new brandDate(id, brandName,fileName);

            brandList.add(brand);
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
    return brandList;
}
public List<itemdate> brand(String Id) {
    Connection conn = null;
    List<itemdate> itemList = new ArrayList<itemdate>();

    try {
        // データベースへ接続
        conn = DBManeger.getConnection();

     // SELECT文を準備
        // TODO: 未実装：管理者以外を取得するようSQLを変更する
        String sql = "select*from w_brand inner join w_item on w_brand.brand_name = w_item.brand_name WHERE w_brand.id="+Id;

         // SELECTを実行し、結果表を取得
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        // 結果表に格納されたレコードの内容を
        // Employeeインスタンスに設定し、ArrayListインスタンスに追加
        while (rs.next()) {
            int id = rs.getInt("id");
            String itemName = rs.getString("item_name");
            String detail = rs.getString("detail");
            String price = rs.getString("price");
            String fileName = rs.getString("file_name");
            String createDate = rs.getString("create_date");
            Date updateDate = rs.getDate("update_date");
            String fileName2 = rs.getString("w_item.file_name");
            itemdate item = new itemdate(id, itemName, detail, price, fileName, createDate, updateDate,fileName2);

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

public brandDate findBrand(String Id) {
    Connection conn = null;
    try {
        // データベースへ接続
        conn = DBManeger.getConnection();

        // SELECT文を準備
        String sql = "SELECT * FROM w_brand WHERE id = "+Id ;
         // SELECTを実行し、結果表を取得
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

         // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
        if (!rs.next()) {
            return null;
        }
        int id = rs.getInt("id");
        String brandName = rs.getString("brand_name");
        String fileName = rs.getString("file_name");

        return new brandDate(id, brandName, fileName);


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

}