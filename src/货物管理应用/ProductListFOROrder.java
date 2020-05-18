package �������Ӧ��;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class ProductListFOROrder  {

	private static DefaultTableModel model;
	private JTable datalist,datalist2;
	private JScrollPane pane,pane2;
	private JPanel jp=new JPanel();
    private JFrame thisjf=new JFrame();
	private JButton jb2 = new JButton("ɾ��");
	private JButton jb3 = new JButton("����");
	private JButton jb4 = new JButton("�޸�");
	private DefaultTableModel tableModel,tableModel2;
	//private String[] title={"����","����","��Ӧ��","�۸�","���","���"};
	private String[] title2={"code","name","quantity","unitprice"};
	private int row;
	private int column;
	private static ProductListFOROrder productlistfororder;
	public ProductListFOROrder(){}
	public static ProductListFOROrder getProductList(){
		if(productlistfororder==null){
			productlistfororder=new ProductListFOROrder();
		}
		return productlistfororder;
	}
	
	
	public void ShowProductList(Object[][] obj,String[]title,String tablename){
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
           thisjf.setTitle("������ϸ��Ϣ");
           thisjf.add(pane);
           thisjf.setVisible(true);
           thisjf.setBounds(10,10,780,560);
           thisjf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           model=(DefaultTableModel) datalist.getModel();
   			
           
           jb2.addActionListener(new ActionListener()
	        {
	            public void actionPerformed(ActionEvent e)
	            {
	            	remove(e,tablename);
	            }
	        });
           jb3.addActionListener(new ActionListener()
	        {
	            public void actionPerformed(ActionEvent e)
	            {
	            	insert(e,tablename);
	            }
	        });
           jb4.addActionListener(new ActionListener()
	        {
	            public void actionPerformed(ActionEvent e)
	            {

	            	modification(e,title,tablename);
	            }
	        });
           


	}
	

	
	private void modification(ActionEvent e,String[] title,String tablename){
		JPanel jp=new JPanel();
		JFrame jf=new JFrame();
		JButton jb2 = new JButton("ȡ��");
		JButton jb1 = new JButton("ȷ��");
		String str="�������µ�";
		String oldvalue=title[column];
		str=str+oldvalue;
		JLabel getvalue = new JLabel(str);
		JTextField getvaluetext = new JTextField();
		jf.setTitle("�޸Ķ�����Ϣ");
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
            	if(getvalue.getText().toString().length()==0){
            		JOptionPane.showMessageDialog( null, "�������µ���ֵ��");
            	}
            	
            	new Order().Modification(datalist.getValueAt(row, 0).toString(),getvaluetext.getText().toString(),title2[column],tablename);
            	Object[][]obj=new Product().getdata(1,"SELECT code, name,supplier,price,category,stock FROM Product where code=\'"+datalist.getValueAt(row, 0).toString()+"\'");
            	new Product().Modification(datalist.getValueAt(row, 0).toString(),String.valueOf(Integer.valueOf(obj[0][5].toString())+Integer.valueOf(getvalue.getText().toString())), "stock");
            	model.setValueAt(getvaluetext.getText().toString(),row , column);
            	datalist.setModel(model);
            	jf.dispose();
            }
        });
		
		model=(DefaultTableModel) datalist.getModel();
		
		
		
		
	}
	
	private void remove(ActionEvent e,String str2){
		
		String str,str3;
		Object[][]obj;
	    int[] selectedRows=datalist.getSelectedRows();
	    if((JOptionPane.showConfirmDialog(null,"ȷ��Ҫɾ����","ɾ����ʾ",0))==0){
	    for(int i=0;i<selectedRows.length;i++)
	    {
	    	str=datalist.getValueAt(selectedRows[i], 0).toString();
	    	str3=datalist.getValueAt(selectedRows[i], 2).toString();
	    	obj=new Product().getdata(1,"SELECT code, name,supplier,price,category,stock FROM Product where code=\'"+str+"\'");
	        model.removeRow(selectedRows[i]);
	        new Order().DelectProduct(str,str2);
	        new Product().Modification(str,String.valueOf(Integer.valueOf(obj[0][5].toString())-Integer.valueOf(str3)), "stock");
	    }
	    datalist.setModel(model);
	    
	    }
	    model=(DefaultTableModel) datalist.getModel();
	    
	    
	}
	
	private void insert(ActionEvent e,String str){
		Object data[]=new Object[2];
		JLabel code = new JLabel("����");
		JTextField codetext = new JTextField();		
		JLabel quantity = new JLabel("����");	
		JTextField quantitytext = new JTextField();	
		JButton jb1 = new JButton("ȷ��");
		JButton jb2 = new JButton("ȡ��");
		JPanel jp=new JPanel();
		JFrame jf=new JFrame();


		
		jf.setTitle("����������Ϣ");
		jp.setLayout(null);
		code.setBounds(100,50,100,20);
		jp.add(code);		
		codetext.setBounds(150,50,100,20);
		jp.add(codetext);
		quantity.setBounds(100,150,100,20);
		jp.add(quantity);		
		quantitytext.setBounds(150,150,100,20);
		jp.add(quantitytext);
		jp.add(jb1);
		jb1.setBounds(100,20,60,20);
		jp.add(jb2);
		jb2.setBounds(200,20,60,20);
		jf.add(jp);
		jf.setVisible(true);
		jf.setBounds(10,10,390,250);
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
            	if(codetext.getText().length()==0||quantitytext.getText().length()==0){
            		JOptionPane.showMessageDialog( null, "�����������Ķ�����Ϣ��");
            	}else if(k(codetext.getText())){
            		JOptionPane.showMessageDialog( null, "������벻���ڣ����������룡");
            	}else{
            		data[0]=codetext.getText();
            		data[1]=quantitytext.getText();
            		String sql="SELECT code, name,supplier,price,category,stock FROM Product where code=\'"+data[0]+"\'";
                    Object [][]obj=new Product().getdata(1,sql);
            		model.addRow(new Object[]{data[0].toString(),obj[0][1],data[1].toString(),obj[0][3].toString()});
            		datalist.setModel(model);
            		new Order().AddProduct(data,str);
            		new Product().Modification(data[0].toString(),String.valueOf(Integer.valueOf(obj[0][5].toString())-Integer.valueOf(data[1].toString())), "stock");
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
				return false;
			}
		}
		return true;
		
	}
	
	
	
	

}
