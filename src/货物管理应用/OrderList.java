package 货物管理应用;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.*;


public class OrderList {
	private String[] title={"编码","名称","数量","单价"};
	private JPanel jp=new JPanel();
    private JFrame thisjf=new JFrame();
    JLabel orderlist = new JLabel("订单列表");
    private JButton[] jb;
    private JButton jb2=new JButton("增添订单");
    private String str,str2;
    private JScrollPane pane=new JScrollPane();
    
    public void ShowOrderList(String[]tablename,int num){
    	int a=100;
    	int b=50;
    	jb=new JButton[num];
    	thisjf.setTitle("订单列表");
    	jp.setLayout(null);
    	for(int i=0;i<num;i++){
    		jb[i]=new JButton(tablename[i]);
    		str2=tablename[i];
    		str="SELECT code, name,quantity,unitprice FROM "+tablename[i];
    		jb[i].setBounds(a, b, 200, 20);
    		jp.add(jb[i]);
    		jb[i].addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                	new ProductListFOROrder().ShowProductList(new Order().getdata(new Order().getcount2(str), str), title,str2);
                }
            });
    		b=b+30;
    	}
    	pane.setViewportView(jp);
    	jb2.setBounds(a,b,100,30);
    	jp.add(jb2);
    	thisjf.add(pane);
    	thisjf.setVisible(true);
		thisjf.setBounds(10,10,390,330);
		thisjf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		jb2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
            	String str="Order"+df.format(new Date());// new Date()为获取当前系统时间
            	new Order().creattable(str);
            	String str2="SELECT code, name,quantity,unitprice FROM "+str;
            	new ProductListFOROrder().ShowProductList(new Order().getdata(new Order().getcount2(str2), str2), title,str);
            }
        });
    	
    	
    	
    	
    }
	
}
