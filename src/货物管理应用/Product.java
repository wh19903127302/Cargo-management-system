package �������Ӧ��;

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
            // ע�� JDBC ����
            Class.forName(JDBC_DRIVER);
        
            // ������
            //System.out.println("�������ݿ�...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // ִ�в�ѯ
            //System.out.println(" ʵ����Statement����...");
            stmt = conn.createStatement();
            String sql;
            sql = str;//"SELECT code, name,supplier,price,category,stock FROM Product";
            ResultSet rs = stmt.executeQuery(sql);
            count=0;
            while(rs.next()){
            	count++;
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
        return count;

 	}
	
	
	public Object[][] getdata(int num,String str){
		Connection conn = null;
        Statement stmt = null;
        int n=0;
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
        return data;
	}
	
	public void DelectProduct(String code){
		Connection conn = null;
        Statement stmt = null;
        int n=0;
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
            sql = "delete from Product where code=?";
            PreparedStatement prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1,code);
            prepStmt.execute();            
            // ��ɺ�ر�
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
		
	}
	public void AddProduct(Object data[]){
		Connection conn = null;
        Statement stmt = null;
        int n=0;
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
            sql = "INSERT INTO Product ( code,name,supplier,price,category,stock )VALUES( ?,?,?,?,?,?)";
            PreparedStatement prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1,data[0].toString());
            prepStmt.setString(2,data[1].toString());
            prepStmt.setString(3,data[2].toString());
            prepStmt.setString(4,data[3].toString());
            prepStmt.setString(5,data[4].toString());
            prepStmt.setString(6,data[5].toString());
            prepStmt.execute();            
            // ��ɺ�ر�
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
		
	}
	public void Modification(String oldcode,String newvalue,String field){
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
            sql = "update Product set "+field+"=? where code=?";
            PreparedStatement prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1,newvalue);
            prepStmt.setString(2,oldcode);
            prepStmt.execute();            
            // ��ɺ�ر�
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
		
	}
	
	
	

	
	
	
	
	
	
	
	
	

}
