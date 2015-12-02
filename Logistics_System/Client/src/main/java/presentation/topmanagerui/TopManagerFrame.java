package presentation.topmanagerui;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

import presentation.img.Img;
import presentation.mainui.CurrentUser;

public class TopManagerFrame extends JFrame{
	
	private static final long serialVersionUID = 4881080784503653011L;
	public static final int w = 1024;
	public static final int h = 768;
	
	
	private CurrentUser currentUser;
	private int state;
	private int stated;
	boolean changed;
	public void setState(int x){
		state=x;
	}
	public int getState(){
		return state;
	}
	public void setStated(int x){
		stated=x;
	}
	public void setChanged(boolean x){
		changed=x;
	}
	JPanel j;
	CardLayout card;

	//面板对象
	Statistic statistic;//统计报表
	Check check;//审批单据
	PeopleAgencyManage peopleAgencyManage;//人员机构管理
	SalaryStrategy salaryStrategy;//制定薪水策略
	ConstantManage constantManage;//制定价格距离常量
	SystemLog systemLog;//查看系统日志
	
	

//	AccountBLService accountBLService;
//	BaseDataSettingBLService baseDataSettingBLService;
//	CostManagementBLService costManagementBLService;
//	SettlementManageBLService settlementManageBLService;

	private boolean isDraging;//是否被拖住
	private int xx;
	private int yy;
	
	public TopManagerFrame(){
		//this.currentUser=currentUser;
		this.currentUser=new CurrentUser("王大锤","南京中转中心","025000","admin");
		this.setUndecorated(true);
		this.addMouseListener(new MouseAdapter() { 
			public void mousePressed(MouseEvent e) { 
				 isDraging = true; 
				 xx = e.getX(); 
				 yy = e.getY(); 
			}

			public void mouseReleased(MouseEvent e) { 
				 isDraging = false; 
			}
		});
		
		
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) { 
			if (isDraging) { 
				 int left = getLocation().x; 
				 int top = getLocation().y; 
				 setLocation(left + e.getX() - xx, top + e.getY() - yy); 
			}
			}
		});
		this.setSize(w,h);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		state=1;
		stated=1;
		changed=false;
		isDraging=false;
		
		card=new CardLayout();
		j = new JPanel();
        j.setLayout(card);
        add(j);
		
		this.setIconImage(Img.TopManagerICON);
		

//		accountBLService=null;
//		baseDataSettingBLService=null;
//		costManagementBLService=null;
//		settlementManageBLService=null;
		
		statistic=new Statistic(this, currentUser);
		check=new Check(this, currentUser);
		peopleAgencyManage=new PeopleAgencyManage(this, currentUser);
		salaryStrategy=new SalaryStrategy(this, currentUser);
		constantManage=new ConstantManage(this, currentUser);
		systemLog=new SystemLog(this, currentUser);

		j.add(statistic);
		j.add(check);
		j.add(peopleAgencyManage);
		j.add(salaryStrategy);
		j.add(constantManage);
		j.add(systemLog);
		
		new Thread(new Runnable(){
			public void run() {
				while(true){
					if(changed){
						changed=false;
						int a;
						if(state-stated>0)
							a=state-stated;
						else
							a=state+6-stated;
						for(int i=0;i<a;i++)
							card.next(j);
						
					}
				}
			}
		}).start();
	}
}
