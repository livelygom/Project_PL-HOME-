package common.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;


public class ServerItemDataInsertBatch {
	public static void main(String[] args) throws Exception {

		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "pline", "2222");
//		PreparedStatement pstmt = conn.prepareStatement("");
//		pstmt.executeUpdate();
//		pstmt.close();
		PreparedStatement pstmt = conn.prepareStatement("insert into pl_server_item values(?,?,?,?,?)");
		for (int i = 1; i <= 600; i++) {
			/*String id = null;
			
			if (i < 10) {
				id = "00" + i;
			}else if (i < 100){
				id = "0" + i;
			}else{
				id = i + "";
			}*/
				
			pstmt.setInt(1, i);
			
			if(i<=120){
				pstmt.setInt(2, 100);
				int itemId1=i;
				pstmt.setInt(3, itemId1);
			}else if(i<=240){
				pstmt.setInt(2, 101);
				int itemId2=i;
				pstmt.setInt(3, itemId2-120);
			}else if(i<=360){
				pstmt.setInt(2, 102);
				int itemId3=i;
				pstmt.setInt(3, itemId3-240);
			}else if(i<=480){
				pstmt.setInt(2, 103);
				int itemId4=i;
				pstmt.setInt(3, itemId4-360);
			}else if(i<=600){
				pstmt.setInt(2, 104);
				int itemId5=i;
				pstmt.setInt(3, itemId5-480);
			}
			
			
			int ranYear= (int)(Math.random()*2);
			int ranMonth=(int)(Math.random()*12);
			int ranDay = (int)(Math.random()*30);
			
			Date d = new Date(2015-1900+ranYear+1,12-1+ranMonth,25+ranDay);
			pstmt.setDate(4,d);
			
			
			int ranItemCount = (int) (Math.random() * 50);
			pstmt.setInt(5, ranItemCount);
			
			pstmt.addBatch();
			// pstmt.clearParameters();//생략해도 될 듯.
		}
		pstmt.executeBatch();
		pstmt.close();
//		System.out.println(cnts.length);
	}
}
