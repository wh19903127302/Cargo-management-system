package �������Ӧ��;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class AdminMeun extends JFrame  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenu title=new JMenu("��ѡ������Ҫ�Ĳ�����");
	private JButton cm1=new JButton("��Ʒ��Ϣ�б�");
	private JButton cm2=new JButton("��Ʒ��Ϣ��ѯ");
	private JButton cm3=new JButton("�˳���¼");
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
		thisjf.setTitle("����Ա�˵�");
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
	            	
	            	//JOptionPane.showMessageDialog( null, "����������");
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
			JOptionPane.showMessageDialog( null, "����������");
		else if(e.getSource() == cm2)
			JOptionPane.showMessageDialog( null, "����������");
		else if(e.getSource() == cm3){
			new LoginInterface();
			
		}
			
			
	}
	 */
}


