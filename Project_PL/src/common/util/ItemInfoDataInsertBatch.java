package common.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class ItemInfoDataInsertBatch {
	public static void main(String[] args) throws Exception {

		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "pline", "2222");
//		PreparedStatement pstmt = conn.prepareStatement("");
//		pstmt.executeUpdate();
//		pstmt.close();
		PreparedStatement pstmt = conn.prepareStatement("insert into pl_item_info values(item_index_seq.nextval,?,?,?)");
		int category = 0;
		for (int i = 1; i <= 120; i++) {

			pstmt.setString(1, " ");
			pstmt.setInt(2, 1);
				
			if(i<=40){
				category = 1;
				pstmt.setInt(3, category);
			}else if(i<=60){
				category = 2;
				pstmt.setInt(3, category);
			}else if(i<=80){
				category = 3;
				pstmt.setInt(3, category);
			}else if(i<=100){
				category = 4;
				pstmt.setInt(3, category);
			}else if(i<=120){
				category = 5;
				pstmt.setInt(3, category);
			}
			
		
			pstmt.addBatch();
			// pstmt.clearParameters();//생략해도 될 듯.
		}
		pstmt.executeBatch();
		pstmt.close();
//		System.out.println(cnts.length);
	}
}
