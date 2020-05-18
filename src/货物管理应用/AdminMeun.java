package 货物管理应用;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class AdminMeun extends JFrame  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenu title=new JMenu("请选择您需要的操作：");
	private JButton cm1=new JButton("商品信息列表");
	private JButton cm2=new JButton("商品信息查询");
	private JButton cm3=new JButton("退出登录");
	private JPanel jp=new JPanel();
	private JFrame thisjf=new JFrame();
	private static AdminMeun adminmeun;
	
	private AdminMeun(){}
	public static AdminMeun getAdminMeun(){
		if(adminmeun==null){
			adminmeun=new AdminMeun();
		}
		return adminmeun;
	}
	
	
	public void meun(Object[][] obj,String[]title2) {
		// TODO Auto-generated method stub
		thisjf.setTitle("管理员菜单");
		jp.setLayout(null);
		title.setBounds(145,50,120,20);
		cm1.setBounds(145,80,120,20);
		cm2.setBounds(145,110,120,20);
		cm3.setBounds(145,140,120,20);
		jp.add(title);
		jp.add(cm1);
		jp.add(cm2);
		jp.add(cm3);
		thisjf.add(jp);
		thisjf.setVisible(true);
		thisjf.setBounds(10,10,390,330);
		thisjf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		 cm1.addActionListener(new ActionListener()
	        {
	            public void actionPerformed(ActionEvent e)
	            {
	            	
	            	ProductList.getProductList().ShowProductList(obj,title2);
	            	
	            	//JOptionPane.showMessageDialog( null, "请输入密码");
	            }
	        });
		 cm2.addActionListener(new ActionListener()
	        {
	            public void actionPerformed(ActionEvent e)
	            {
	            	SearchProduct.getSearchProduct().MakeSearchProductList();
	            }
	        });
		 cm3.addActionListener(new ActionListener()
	        {
	            public void actionPerformed(ActionEvent e)
	            {
	            	LoginInterface.getLoginInterface().MakeLoginInterface();
	            	thisjf.dispose();
	            }
	        });
		 
			
	}
	/*public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cm1)
			JOptionPane.showMessageDialog( null, "请输入密码");
		else if(e.getSource() == cm2)
			JOptionPane.showMessageDialog( null, "请输入密码");
		else if(e.getSource() == cm3){
			new LoginInterface();
			
		}
			
			
	}
	 */
}


