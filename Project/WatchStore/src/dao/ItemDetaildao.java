package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import model.saledate;


public class ItemDetaildao {
	public saledate findById(String Id) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManeger.getConnection();

            // SELECT文を準備
            String sql = "select * from w_item left outer join w_sale on w_item.brand_name=w_sale.brand_name AND w_sale.start_date<= now() AND now() <= w_sale.finish_date WHERE w_item.id = "+Id ;
             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }
            int id = rs.getInt("id");
            String itemName = rs.getString("item_name");
            String detail = rs.getString("detail");
            String price = rs.getString("price");
            String fileName = rs.getString("file_name");
            String createDate = rs.getString("create_date");
            Date updateDate = rs.getDate("update_date");
            String sale = rs.getString("sale");
            String startDate = rs.getString("start_date");
            String finishDate = rs.getString("finish_date");

            if(sale!=null){

            int p=Integer.parseInt(price);
			int s=Integer.parseInt(sale);
			double s2=(double)(100-s)/100;
			int saleprice=(int)((int)p*s2);

            return new saledate (id, itemName, detail, price, fileName, createDate, updateDate,sale,startDate,finishDate,saleprice);

            }else {

        	return new saledate(id, itemName, detail, price, fileName, createDate, updateDate,sale,startDate,finishDate);
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
}

}
