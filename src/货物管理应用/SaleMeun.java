package �������Ӧ��;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;

public class SaleMeun {
	private static final long serialVersionUID = 1L;
	private JMenu title=new JMenu("��ѡ������Ҫ�Ĳ�����");
	private JButton cm1=new JButton("�����б�");
	private JButton cm2=new JButton("������Ϣ��ѯ");
	private JButton cm3=new JButton("�˳���¼");
	private JPanel jp=new JPanel();
	private JFrame thisjf=new JFrame();
	private static SaleMeun salemeun;
	
	private SaleMeun(){}
	public static SaleMeun getSaleMeun(){
		if(salemeun==null){
			salemeun=new SaleMeun();
		}
		return salemeun;
	}
	
	
	public void meun() {
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
	            	
	            	new OrderList().ShowOrderList(new Order().gettablename(new Order().getcount()),new Order().getcount());
	            	
	            	//JOptionPane.showMessageDialog( null, "����������");
	            }
	        });
		 cm2.addActionListener(new ActionListener()
	        {
	            public void actionPerformed(ActionEvent e)
	            {
	            	SearchOrder.getSearchOrder().meun();
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
	
}


