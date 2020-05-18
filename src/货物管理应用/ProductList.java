package 货物管理应用;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class ProductList  {

	private static DefaultTableModel model;
	private JTable datalist,datalist2;
	private JScrollPane pane,pane2;
	private JPanel jp=new JPanel();
    private JFrame thisjf=new JFrame();
	private JButton jb2 = new JButton("删除");
	private JButton jb3 = new JButton("增加");
	private JButton jb4 = new JButton("修改");
	private DefaultTableModel tableModel,tableModel2;
	//private String[] title={"编码","名称","供应商","价格","类别","库存"};
	private String[] title2={"code","name","supplier","price","category","stock"};
	private int row;
	private int column;
	private static ProductList productlist;
	public ProductList(){}
	public static ProductList getProductList(){
		if(productlist==null){
			productlist=new ProductList();
		}
		return productlist;
	}
	
	
	public void ShowProductList(Object[][] obj,String[]title){
           tableModel2= new DefaultTableModel(obj,title);
           tableModel=tableModel2;
           datalist2=new JTable(tableModel);
           datalist=datalist2;
           datalist.setRowHeight(30);        
           datalist.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
           thisjf.setLayout(new BorderLayout(0,0));
           thisjf.add(jp,BorderLayout.SOUTH);
           jp.add(jb2);
           jp.add(jb3);
           jp.add(jb4);

           pane2=new JScrollPane(datalist);
           pane=pane2;
           datalist.addMouseListener(new MouseAdapter()
           {
               public void mouseClicked(MouseEvent event)
               {
            	   if(event.getClickCount() == 1){
           			Point p = event.getPoint();
           			row = datalist.rowAtPoint(p);
           			column = datalist.columnAtPoint(p);

           		}
               }
           });
           thisjf.setTitle("商品列表");
           thisjf.add(pane);
           thisjf.setVisible(true);
           thisjf.setBounds(10,10,780,560);
           thisjf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           model=(DefaultTableModel) datalist.getModel();
   			
           
           jb2.addActionListener(new ActionListener()
	        {
	            public void actionPerformed(ActionEvent e)
	            {
	            	remove(e);
	            }
	        });
           jb3.addActionListener(new ActionListener()
	        {
	            public void actionPerformed(ActionEvent e)
	            {
	            	insert(e);
	            }
	        });
           jb4.addActionListener(new ActionListener()
	        {
	            public void actionPerformed(ActionEvent e)
	            {

	            	modification(e,title);
	            }
	        });
           


	}
	

	
	private void modification(ActionEvent e,String[] title){
		JPanel jp=new JPanel();
		JFrame jf=new JFrame();
		JButton jb2 = new JButton("取消");
		JButton jb1 = new JButton("确定");
		String str="请输入新的";
		String oldvalue=title[column];
		str=str+oldvalue;
		JLabel getvalue = new JLabel(str);
		JTextField getvaluetext = new JTextField();
		jf.setTitle("修改货物信息");
		jp.setLayout(null);
		getvalue.setBounds(50,50,130,20);
		jp.add(getvalue);
		getvaluetext.setBounds(250,50,100,20);
		jp.add(getvaluetext);
		jb1.setBounds(60, 100, 60, 20);
		jb2.setBounds(130, 100, 60, 20);
		jp.add(jb1);
		jp.add(jb2);
		jf.add(jp);
		jf.setVisible(true);
		jf.setBounds(10,10,390,200);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jb2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	jf.dispose();
            }
        });
		jb1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	//int row2=datalist.getSelectedRow();
        		//int column2=datalist.getSelectedColumnCount();
            	if(getvalue.getText().toString().length()==0){
            		JOptionPane.showMessageDialog( null, "请输入新的数值！");
            	}
            	
            	new Product().Modification(datalist.getValueAt(row, 0).toString(),getvaluetext.getText().toString(),title2[column]);
            	
            	model.setValueAt(getvaluetext.getText().toString(),row , column);
            	datalist.setModel(model);
            	jf.dispose();
            }
        });
		
		model=(DefaultTableModel) datalist.getModel();
		
		
		
		
	}
	
	private void remove(ActionEvent e){
		
		String str;
	    int[] selectedRows=datalist.getSelectedRows();
	    if((JOptionPane.showConfirmDialog(null,"确定要删除吗？","删除提示",0))==0){
	    for(int i=0;i<selectedRows.length;i++)
	    {
	    	str=datalist.getValueAt(selectedRows[i], 0).toString();
	        model.removeRow(selectedRows[i]);
	        new Product().DelectProduct(str);
	    }
	    datalist.setModel(model);
	    
	    }
	    model=(DefaultTableModel) datalist.getModel();
	    
	    
	}
	
	private void insert(ActionEvent e){
		Object data[]=new Object[6];
		JLabel code = new JLabel("编码");
		JTextField codetext = new JTextField();		
		JLabel name = new JLabel("名称");	
		JTextField nametext = new JTextField();
		JLabel supplier = new JLabel("供应商");	
		JTextField suppliertext = new JTextField();
		JLabel price = new JLabel("价格");	
		JTextField pricetext = new JTextField();
		JLabel category = new JLabel("类别");	
		JTextField categorytext = new JTextField();
		JLabel stock = new JLabel("库存");	
		JTextField stocktext = new JTextField();	
		JButton jb1 = new JButton("确定");
		JButton jb2 = new JButton("取消");
		JPanel jp=new JPanel();
		JFrame jf=new JFrame();


		
		jf.setTitle("增加货物信息");
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
		pricetext.setBounds(150,200,100,20);
		jp.add(pricetext);
		category.setBounds(100,250,100,20);
		jp.add(category);		
		categorytext.setBounds(150,250,100,20);
		jp.add(categorytext);
		stock.setBounds(100,300,100,20);
		jp.add(stock);		
		stocktext.setBounds(150,300,100,20);
		jp.add(jb1);
		jb1.setBounds(100,340,60,20);
		jp.add(jb2);
		jb2.setBounds(200,340,60,20);
		jp.add(stocktext);
		jf.add(jp);
		jf.setVisible(true);
		jf.setBounds(10,10,390,430);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jb2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	jf.dispose();
            }
        });
		jb1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	if(codetext.getText().length()==0||nametext.getText().length()==0||pricetext.getText().length()==0||suppliertext.getText().length()==0||categorytext.getText().length()==0||stocktext.getText().length()==0){
            		JOptionPane.showMessageDialog( null, "请输入完整的货物信息！");
            	}else if(k(codetext.getText())){
            		JOptionPane.showMessageDialog( null, "货物编码已存在，请重新输入！");
            	}else{
            		data[0]=codetext.getText();
            		data[1]=nametext.getText();
            		data[2]=pricetext.getText();
            		data[3]=suppliertext.getText();
            		data[4]=categorytext.getText();
            		data[5]=stocktext.getText();
            		model.addRow(data);
            		datalist.setModel(model);
            		new Product().AddProduct(data);
            		jf.dispose();
            	}
            	
            	
            }
        });
		
		model=(DefaultTableModel) datalist.getModel();
		
		
		
		
		
		
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
