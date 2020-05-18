package 货物管理应用;

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
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
        
            // 打开链接
            //System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // 执行查询
            //System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            if(type.equals("AdminAccount")){
            	sql = "SELECT name, password FROM AdminAccount";
            }else{
            	sql = "SELECT name, password FROM SaleAccount";
            }
            ResultSet rs = stmt.executeQuery(sql);
        
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                String name1 = rs.getString("name");
                String password1 = rs.getString("password");
    
                // 比较数据
                if(name.equals(name1)&&password.equals(password1)){
                	k=true;
                	break;
                }
            }

            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return k;
		
		
	}
	
	
	

}
	
