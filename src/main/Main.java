package main;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Main main=new Main();
		
		Company lxq=Company.getCompany();
		lxq.add(new Employee("唐僧", 20190001));
		lxq.add(new Employee("悟空", 20190002));
		lxq.add(new Employee("八戒", 20190003));
		lxq.add(new Employee("沙僧", 20190004));
		System.out.println("添加信息成功！");
		
		main.run(lxq);
		
	}

	public void run(Company x)
	{
		Scanner in=new Scanner(System.in);
		int choice=0;
		int FinalChoice=0;
		
		while(FinalChoice!=-1)
		{
			System.out.println("----员工打卡系统----");
			System.out.println("输入 0--------退出");
			System.out.println("输入 1--------签到");
			System.out.println("输入 2--------签退");
			System.out.println("输入 3--------查看签到信息");
			System.out.println("请输入想执行的操作：");
			
			while(true)
			{
				try
				{
					choice=(Integer.parseInt(in.nextLine()));
					if(choice>=0&&choice<=3)
					{
						break;
					}
					else
					{
						System.out.println("输入数据有误！");
						System.out.println("请重新输入！");
					}
				}
				catch(NumberFormatException e)
				{
					System.out.println("输入数据有误！");
					System.out.println("请重新输入！");
				}
			}
			
			switch(choice)
			{
				case 1:
					login(x);
					break;
				case 2:
					logout(x);
					break;	
				case 3:
					show(x);
					break;
				case 0:
					FinalChoice=-1;
					break;
			}
		}
		in.close();
		System.out.println("退出");
	}
	
	public void login(Company c)
	{
		int id;
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		
		System.out.println("请输入签到员工ID：");
		while(true)
		{
			try
			{
				id=(Integer.parseInt(in.nextLine()));
				break;
			}
			catch(NumberFormatException e)
			{
				System.out.println("输入数据有误！");
				System.out.println("请重新输入！");
			}
		}
		
		int n=0;
		for (DakaInfo x:c.getDakaInfo())
		{
			if(x.getId()==id)
			{
				n=1;
				if(x.getOn()==null)
				{
					x.login();
					System.out.println("卡号："+x.getId()+"  打卡成功");
					return;
				}
				else
				{
					System.out.println("今天已经打过卡了");
					return;
				}
			}
		}
		if(n==0)
		{
			System.out.println("无此ID员工");
		}
	}
	
	public void logout(Company c)
	{
		int id;
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		
		System.out.println("请输入签退员工ID：");
		while(true)
		{
			try
			{
				id=(Integer.parseInt(in.nextLine()));
				break;
			}
			catch(NumberFormatException e)
			{
				System.out.println("输入数据有误！");
				System.out.println("请重新输入！");
			}
		}
		
		int n=0;
		for (DakaInfo x:c.getDakaInfo())
		{
			if(x.getId()==id)
			{
				n=1;
				if(x.getOn()==null)
				{
					System.out.println("卡号："+x.getId()+"  今天还没有签到，无法签退");
					return;
				}
				else if(x.getOut()==null)
				{
					x.logout();
					System.out.println("卡号："+x.getId()+"  签退成功");
					return;
				}
				else
				{
					System.out.println("今天已经签退了");
					return;
				}
			}
		}
		if(n==0)
		{
			System.out.println("无此ID员工");
		}
	}
	
	public void show(Company c)
	{
		System.out.printf("%s\t\t%s\t\t\t%s\t\t\t\t%s\n","姓名","ID","签到状态","签退状态");
		for(Employee x:c.getEmployee())
		{
			for(DakaInfo y:c.getDakaInfo())
			{
				if(x.getId()==y.getId())
				{
					System.out.printf("%s\t\t%d\t\t%s\t%s\n",x.getName(),x.getId(),y.displayOn(),
											   								   y.displayout());
				}
			}
		}
		
	}
}
