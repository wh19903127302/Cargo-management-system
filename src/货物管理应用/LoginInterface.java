package 货物管理应用;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class LoginInterface extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JLabel username = new JLabel("用户名");
	private JTextField userName = new JTextField();		
	private JLabel psw = new JLabel("密码");	
	private JPasswordField Psw = new JPasswordField();
	private JLabel jlp=new JLabel("身份");
	private String []str={"管理员","销售员"};
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox jcb=new JComboBox(str);	
	private JButton jb1 = new JButton("登录");
	private JButton jb2 = new JButton("取消");
	private JPanel jp=new JPanel();
	private static LoginInterface logininterface;
	private LoginInterface(){}
	public static LoginInterface getLoginInterface(){
		if(logininterface==null){
			logininterface=new LoginInterface();
		}
		return logininterface;
	}
	public void MakeLoginInterface(){
		this.setTitle("商品信息管理系统");
		jp.setLayout(null);
		username.setBounds(100,50,100,20);
		jp.add(username);		
		userName.setBounds(150,50,100,20);
		jp.add(userName);
		psw.setBounds(100,100,100,20);
		jp.add(psw);
		Psw.setBounds(150,100,100,20);
		jp.add(Psw);
		jlp.setBounds(100,150,100,20);
		jp.add(jlp);
		jcb.setBounds(150,150,100,20);
		jp.add(jcb);
		jcb.addActionListener(this);
		jb1.setBounds(100,210,60,20);
		jp.add(jb1);
		jb1.addActionListener(this);
		jb2.setBounds(200,210,60,20);
		jp.add(jb2);     
		jb2.addActionListener(this);
		this.add(jp);
		this.setVisible(true);
		this.setBounds(10,10,390,330);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}


	

	public void actionPerformed(ActionEvent e) {		
		if (e.getSource() == jb1) {
			String name=userName.getText();
			String password = new String(Psw.getPassword());
			if(name.length()==0&&password.length()!=0)
				JOptionPane.showMessageDialog( null, "请输入用户名");
			else  if(name.length()!=0&&password.length()==0)
				JOptionPane.showMessageDialog( null, "请输入密码");
			else if(name.length()==0&&name.length()==0)
					JOptionPane.showMessageDialog( null, "请输入用户名和密码");
			else if(jcb.getSelectedIndex()==0&&name.length()!=0&&name.length()!=0){
				if(PasswordCheck.getpasswordcheck().Check("AdminAccount", name, password)){
					String str="SELECT code, name,supplier,price,category,stock FROM Product";
					String[] title={"编码","名称","供应商","价格","类别","库存"};
					AdminMeun.getAdminMeun().meun(new Product().getdata(new Product().getcount(str),str), title);
					this.dispose();
		//			JOptionPane.showMessageDialog(null, "管理员登录成功！");//待更改
				}else{
					JOptionPane.showMessageDialog( null, "账号密码错误！");
				}
			}
			else if(jcb.getSelectedIndex()==1&&name.length()!=0&&password.length()!=0){
				if(PasswordCheck.getpasswordcheck().Check("SaleAccount", name, password)){
					SaleMeun.getSaleMeun().meun();
					this.dispose();
				}else{
					JOptionPane.showMessageDialog( null, "账号密码错误！");
				}
			}
			
				
		}
		else if(e.getSource()==jb2)
			this.dispose();
	}
	


	


}
