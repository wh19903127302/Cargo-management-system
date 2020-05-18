package 货物管理应用;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SearchOrder {
	private JLabel code = new JLabel("订单包含商品的编码");
	private JTextField codetext = new JTextField();		
	private JLabel tablename = new JLabel("订单名称");	
	private JTextField tablenametext = new JTextField();
	JButton jb1 = new JButton("确定");
	private JFrame jf=new JFrame();
	private JPanel jp=new JPanel();
	private String[] title={"编码","名称","数量","单价"};
	private static SearchOrder searchorder;
	
	private SearchOrder(){};
	public static SearchOrder getSearchOrder(){
		if(searchorder==null){
			searchorder=new SearchOrder();
		}
		return searchorder;
	}
	public void meun(){
		jf.setTitle("订单查询");
		jp.setLayout(null);
		code.setBounds(20,50,130,20);
		jp.add(code);		
		codetext.setBounds(150,50,100,20);
		jp.add(codetext);
		tablename.setBounds(100,150,100,20);
		jp.add(tablename);		
		tablenametext.setBounds(150,150,100,20);
		jp.add(tablenametext);
		jb1.setBounds(125, 200, 60, 20);
		jp.add(jb1);
		jf.add(jp);
		jf.setVisible(true);
		jf.setBounds(10,10,390,300);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		jb1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	if(tablenametext.getText().toString().length()!=0){
            		if(wheretherexittable(tablenametext.getText().toString())){
            		String str="SELECT code, name,quantity,unitprice FROM "+tablename.getText().toString();
            		new ProductListFOROrder().ShowProductList(new Order().getdata(new Order().getcount2(str), str), title,tablename.getText().toString());
            		}else{
            			JOptionPane.showMessageDialog( null, "输入的订单名称不存在，请输入正确的订单名称！");
            		}
            }else if(codetext.getText().toString().length()!=0){
            	if(k(codetext.getText().toString())){
            	int count=new Order().getcount();
            	int n=0;
            	String[]tablename=new Order().gettablename(new Order().getcount());
            	String[]tablename2=new String[count];
            	for(int i=0;i<count;i++){
            		if(new Order().whetherexist(tablename[i], codetext.getText().toString())){
            			tablename2[i]=tablename[i];
            			n++;
            		}
            	}
            	new OrderList().ShowOrderList(tablename2, n);
            	}else{
            		JOptionPane.showMessageDialog( null, "输入的商品编码不存在，请输入正确的商品编码！");
            	}
            	
            
            	
            	
            }
            	
            	
            }
        });
	}
	
	private boolean wheretherexittable(String tablename){
		int count=new Order().getcount();
    	String[]tablename2=new Order().gettablename(new Order().getcount());
    	for(int i=0;i<count;i++){
    		if(tablename2[i].equals(tablename)){
    			return true;
    		}
    	}
    	return false;
	}
	private boolean k(String str){
		String str2="SELECT code, name,supplier,price,category,stock FROM Product";
		int n=new Product().getcount(str2);
		Object [][]obj=new Product().getdata(n,str2);
		for(int i=0;i<n;i++){
			if(obj[i][0].toString().equals(str)){
				return true;
			}
		}
		return false;
		
	}
	
	
}



