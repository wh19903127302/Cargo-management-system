package 货物管理应用;

import java.sql.*;

public class Product {
	private int count;
	private Object[][] data;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/ProductDataBase";
    static final String USER = "root";
    static final String PASS = "170039";

	
	public Product(){}
	public int getcount(String str){
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
            sql = str;//"SELECT code, name,supplier,price,category,stock FROM Product";
            ResultSet rs = stmt.executeQuery(sql);
            count=0;
            while(rs.next()){
            	count++;
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
        return count;

 	}
	
	
	public Object[][] getdata(int num,String str){
		Connection conn = null;
        Statement stmt = null;
        int n=0;
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
            sql = str;//"SELECT code, name,supplier,price,category,stock FROM Product";
            ResultSet rs = stmt.executeQuery(sql);
            data=new String[num][6];
            while(rs.next()){
            	data[n][0] = rs.getString("code");
            	data[n][1] = rs.getString("name");
            	data[n][2] = rs.getString("supplier");
            	data[n][3] = rs.getString("price");
            	data[n][4] = rs.getString("category");
            	data[n][5] = rs.getString("stock");
            	n++;
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
        return data;
	}
	
	public void DelectProduct(String code){
		Connection conn = null;
        Statement stmt = null;
        int n=0;
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
            sql = "delete from Product where code=?";
            PreparedStatement prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1,code);
            prepStmt.execute();            
            // 完成后关闭
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
		
	}
	public void AddProduct(Object data[]){
		Connection conn = null;
        Statement stmt = null;
        int n=0;
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
            sql = "INSERT INTO Product ( code,name,supplier,price,category,stock )VALUES( ?,?,?,?,?,?)";
            PreparedStatement prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1,data[0].toString());
            prepStmt.setString(2,data[1].toString());
            prepStmt.setString(3,data[2].toString());
            prepStmt.setString(4,data[3].toString());
            prepStmt.setString(5,data[4].toString());
            prepStmt.setString(6,data[5].toString());
            prepStmt.execute();            
            // 完成后关闭
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
		
	}
	public void Modification(String oldcode,String newvalue,String field){
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
            sql = "update Product set "+field+"=? where code=?";
            PreparedStatement prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1,newvalue);
            prepStmt.setString(2,oldcode);
            prepStmt.execute();            
            // 完成后关闭
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
		
	}
	
	
	

	
	
	
	
	
	
	
	
	

}
