package �������Ӧ��;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PasswordCheck {
	
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/Account";
    static final String USER = "root";
    static final String PASS = "170039";
    boolean k=false;
    private static PasswordCheck passwordcheck;
    
	private PasswordCheck(){}
	public static PasswordCheck getpasswordcheck(){
		if(passwordcheck==null){
			passwordcheck=new PasswordCheck();
		}
		return passwordcheck;
	}
	
	public boolean Check(String type,String name,String password){
		Connection conn = null;
        Statement stmt = null;
        try{
            // ע�� JDBC ����
            Class.forName(JDBC_DRIVER);
        
            // ������
            //System.out.println("�������ݿ�...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // ִ�в�ѯ
            //System.out.println(" ʵ����Statement����...");
            stmt = conn.createStatement();
            String sql;
            if(type.equals("AdminAccount")){
            	sql = "SELECT name, password FROM AdminAccount";
            }else{
            	sql = "SELECT name, password FROM SaleAccount";
            }
            ResultSet rs = stmt.executeQuery(sql);
        
            // չ����������ݿ�
            while(rs.next()){
                // ͨ���ֶμ���
                String name1 = rs.getString("name");
                String password1 = rs.getString("password");
    
                // �Ƚ�����
                if(name.equals(name1)&&password.equals(password1)){
                	k=true;
                	break;
                }
            }

            // ��ɺ�ر�
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // ���� JDBC ����
            se.printStackTrace();
        }catch(Exception e){
            // ���� Class.forName ����
            e.printStackTrace();
        }finally{
            // �ر���Դ
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// ʲô������
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return k;
		
		
	}
	
	
	

}
	
