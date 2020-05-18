package 货物管理应用;
import java.sql.*;

public class Order {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/orderDataBase";
    static final String USER = "root";
    static final String PASS = "170039";
    private int count,count2;
    private Object[][] data;
    private String[] tablename;
    
    public Order(){}
    public int getcount2(String str){
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
            count2=0;
            while(rs.next()){
            	count2++;
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
        return count2;

 	}
    public int getcount(){
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
            DatabaseMetaData meta = conn.getMetaData();  
            ResultSet rs = meta.getTables(null, null, null,  
              new String[] { "TABLE" });  
            while (rs.next()) {  
               count++;
            }
            // 完成后关闭
            rs.close();
            //stmt.close();
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
    
    public void AddProduct(Object data[],String str){
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
            sql="SELECT code, name,supplier,price,category,stock FROM Product where code=\'"+data[0]+"\'";
            Object [][]obj=new Product().getdata(1,sql);
            sql = "INSERT INTO "+str+" ( code,name,quantity,unitprice )VALUES( ?,?,?,?)";
            PreparedStatement prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1,obj[0][0].toString());
            prepStmt.setString(3,data[1].toString());
            prepStmt.setString(2,obj[0][1].toString());
            prepStmt.setString(4,obj[0][3].toString());
           
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
    
    public void DelectProduct(String code,String str){
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
            sql = "delete from "+str+" where code=?";
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
    public void creattable(String str){
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
            sql="create table "+str+"( code char(255), name char(255), quantity char(255), unitprice char(255), primary key (code), foreign key (code) references productdatabase.product (code) on delete CASCADE )";
            stmt.executeUpdate(sql);            
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
    	
    
    public String[] gettablename(int num){
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
            DatabaseMetaData meta = conn.getMetaData();  
            ResultSet rs = meta.getTables(null, null, null,  
              new String[] { "TABLE" });  
            tablename=new String[num];
            while (rs.next()) {  
               tablename[n]=rs.getString(3);
               n++;
            }  
            // 完成后关闭
            rs.close();
            //stmt.close();
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
        return tablename;
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
            data=new String[num][4];
            while(rs.next()){
            	data[n][0] = rs.getString("code");
            	data[n][1] = rs.getString("name");
            	data[n][2] = rs.getString("quantity");
            	data[n][3] = rs.getString("unitprice");
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
    public void Modification(String oldcode,String newvalue,String field,String tablename){
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
            sql = "update "+tablename+" set "+field+"=? where code=?";
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
    
    public boolean whetherexist(String tablename,String code){
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
            sql = "select code,name,quantity,unitprice from "+tablename+" where code=\'"+code+"\'";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
            	return true;
            }
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
        return false;
    }
    
    
    
}
