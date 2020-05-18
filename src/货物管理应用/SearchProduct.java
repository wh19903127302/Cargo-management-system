package 货物管理应用;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchProduct {
	private Object data[]=new Object[6];
	private JLabel code = new JLabel("编码");
	private JTextField codetext = new JTextField();		
	private JLabel name = new JLabel("名称");	
	private JTextField nametext = new JTextField();
	private JLabel supplier = new JLabel("供应商");	
	private JTextField suppliertext = new JTextField();
	private JLabel price = new JLabel("价格");	
	private JLabel price2 = new JLabel("至");
	private JTextField pricetext1 = new JTextField();
	private JTextField pricetext2 = new JTextField();
	private JLabel category = new JLabel("类别");	
	private JTextField categorytext = new JTextField();
	private JLabel stock = new JLabel("库存");
	private JLabel stock2 = new JLabel("至");
	private JTextField stocktext = new JTextField();
	private JTextField stocktext2 = new JTextField();
	private JButton jb1 = new JButton("查询");
	private JButton jb2 = new JButton("取消");
	private JPanel jp=new JPanel();
	private JFrame jf=new JFrame();
	private static SearchProduct searchproduct;
	
	private SearchProduct(){}
	public static SearchProduct getSearchProduct(){
		if(searchproduct==null){
			searchproduct=new SearchProduct();
			
		}
		return searchproduct;
	}
	
	public void MakeSearchProductList(){
		jf.setTitle("查询信息");
		jp.setLayout(null);
		code.setBounds(100,50,100,20);
		jp.add(code);		
		codetext.setBounds(150,50,100,20);
		jp.add(codetext);
		name.setBounds(100,100,100,20);
		jp.add(name);		
		nametext.setBounds(150,100,100,20);
		jp.add(nametext);
		supplier.setBounds(100,150,100,20);
		jp.add(supplier);		
		suppliertext.setBounds(150,150,100,20);
		jp.add(suppliertext);
		price.setBounds(100,200,100,20);
		jp.add(price);		
		pricetext1.setBounds(150,200,50,20);
		jp.add(pricetext1);
		price2.setBounds(200,200,15,20);
		jp.add(price2);
		pricetext2.setBounds(220,200,50,20);
		jp.add(pricetext2);
		category.setBounds(100,250,100,20);
		jp.add(category);		
		categorytext.setBounds(150,250,100,20);
		jp.add(categorytext);
		stock.setBounds(100,300,100,20);
		jp.add(stock);		
		stocktext.setBounds(150,300,50,20);
		jp.add(stocktext);
		stock2.setBounds(200,300,15,20);
		jp.add(stock2);
		stocktext2.setBounds(220,300,50,20);
		jp.add(stocktext2);
		jp.add(jb1);
		jb1.setBounds(100,340,60,20);
		jp.add(jb2);
		jb2.setBounds(200,340,60,20);
		jf.add(jp);
		jf.setVisible(true);
		jf.setBounds(10,10,390,430);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jb1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            { 			
            	if(codetext.getText().length()!=0){
            		getmessage_code(e,codetext.getText().toString());
            	}else if(pricetext1.getText().length()!=0&&pricetext2.getText().length()!=0&&nametext.getText().length()==0&&suppliertext.getText().length()==0&&categorytext.getText().length()==0&&stocktext.getText().length()==0&&stocktext2.getText().length()==0){
            		getmessage_priceorstock3(e,pricetext1.getText().toString(),pricetext2.getText().toString(),"price");
            	}else if(pricetext1.getText().length()!=0&&pricetext2.getText().length()==0&&nametext.getText().length()==0&&suppliertext.getText().length()==0&&categorytext.getText().length()==0&&stocktext.getText().length()==0&&stocktext2.getText().length()==0){
            		getmessage_priceorstock2(e,pricetext1.getText().toString(),"price");
            	}else if(pricetext1.getText().length()==0&&pricetext2.getText().length()!=0&&nametext.getText().length()==0&&suppliertext.getText().length()==0&&categorytext.getText().length()==0&&stocktext.getText().length()==0&&stocktext2.getText().length()==0){
            		getmessage_priceorstock1(e,pricetext2.getText().toString(),"price");
            	}else if(stocktext.getText().length()!=0&&stocktext2.getText().length()!=0&&nametext.getText().length()==0&&suppliertext.getText().length()==0&&categorytext.getText().length()==0&&pricetext1.getText().length()==0&&pricetext2.getText().length()==0){
            		getmessage_priceorstock3(e,stocktext.getText().toString(),stocktext2.getText().toString(),"stock");
            	}else if(stocktext.getText().length()!=0&&stocktext2.getText().length()==0&&nametext.getText().length()==0&&suppliertext.getText().length()==0&&categorytext.getText().length()==0&&pricetext1.getText().length()==0&&pricetext2.getText().length()==0){
            		getmessage_priceorstock2(e,stocktext.getText().toString(),"stock");
            	}else if(stocktext.getText().length()==0&&stocktext2.getText().length()!=0&&nametext.getText().length()==0&&suppliertext.getText().length()==0&&categorytext.getText().length()==0&&pricetext1.getText().length()==0&&pricetext2.getText().length()==0){
            		getmessage_priceorstock1(e,stocktext2.getText().toString(),"stock");
            	}else if(suppliertext.getText().length()!=0&&nametext.getText().length()==0&&categorytext.getText().length()==0&&pricetext1.getText().length()==0&&pricetext2.getText().length()==0&&stocktext.getText().length()==0&&stocktext2.getText().length()==0){
            		getmessage_supplier(e,suppliertext.getText().toString());
            	}else if(suppliertext.getText().length()==0&&nametext.getText().length()==0&&categorytext.getText().length()!=0&&pricetext1.getText().length()==0&&pricetext2.getText().length()==0&&stocktext.getText().length()==0&&stocktext2.getText().length()==0){
            		getmessage_category(e,categorytext.getText().toString());
            	}else{
            		JOptionPane.showMessageDialog( null, "不支持该种查询，支持的种类：价格，库存，编码，供应商，类别，(仅能单独查询某一项)。");
            	}
            }
        });
		jb2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	jf.dispose();
            }
        });
	}
	
	public void getmessage_code(ActionEvent e,String str){
		String[] title={"编码","名称","供应商","价格","类别","库存"};
		String str2;
		str2="SELECT code, name,supplier,price,category,stock FROM Product where code=\'"+str+"\'";
		new ProductList().ShowProductList(new Product().getdata(new Product().getcount(str2), str2), title);
		
	}
	public void getmessage_priceorstock3(ActionEvent e,String str,String str3,String leibie){
		String[] title={"编码","名称","供应商","价格","类别","库存"};
		String str2;
		str2="SELECT code, name,supplier,price,category,stock FROM Product where "+leibie+">="+str+" and "+leibie+"<="+str3;
		new ProductList().ShowProductList(new Product().getdata(new Product().getcount(str2), str2), title);
		
	}
	public void getmessage_priceorstock2(ActionEvent e,String str,String leibie){
		String[] title={"编码","名称","供应商","价格","类别","库存"};
		String str2;
		str2="SELECT code, name,supplier,price,category,stock FROM Product where "+leibie+">="+str;
		new ProductList().ShowProductList(new Product().getdata(new Product().getcount(str2), str2), title);
		
	}
	public void getmessage_priceorstock1(ActionEvent e,String str,String leibie){
		String[] title={"编码","名称","供应商","价格","类别","库存"};
		String str2;
		str2="SELECT code, name,supplier,price,category,stock FROM Product where "+leibie+"<="+str;
		new ProductList().ShowProductList(new Product().getdata(new Product().getcount(str2), str2), title);
		
	}
	public void getmessage_supplier(ActionEvent e,String str){
		String[] title={"编码","名称","供应商","价格","类别","库存"};
		String str2;
		str2="SELECT code, name,supplier,price,category,stock FROM Product where supplier="+"\'"+str+"\'";
		new ProductList().ShowProductList(new Product().getdata(new Product().getcount(str2), str2), title);
	}
	public void getmessage_category(ActionEvent e,String str){
		String[] title={"编码","名称","供应商","价格","类别","库存"};
		String str2;
		str2="SELECT code, name,supplier,price,category,stock FROM Product where category="+"\'"+str+"\'";
		new ProductList().ShowProductList(new Product().getdata(new Product().getcount(str2), str2), title);
	}
	

}
