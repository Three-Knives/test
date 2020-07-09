package main;

import java.util.ArrayList;

public class Company {

	static private Company Company=new Company();
	private ArrayList<Employee> employee;
	private ArrayList<DakaInfo> dakainfo;
	
	
	private Company() 
	{
		employee=new ArrayList<Employee>();
		dakainfo=new ArrayList<DakaInfo>();
	}
	
	static public Company getCompany()
	{
		if(Company==null)
		{
			Company=new Company();
		}
		return Company;
	}
	
	public ArrayList<Employee> getEmployee()
	{
		return  employee;
	}
	
	public ArrayList<DakaInfo> getDakaInfo()
	{
		return  dakainfo;
	}
	
	public void add(Employee a)
	{
		employee.add(a);
		dakainfo.add(new DakaInfo(a.getId()));
		System.out.println("员工："+a.getName()+"  ID："+a.getId()+"  添加成功！");
	}
	
	public void delete(int id)
	{
		for (Employee x:employee)
		{
			if(x.getId()==id)
			{
				employee.remove(x);
				break;
			}
		}
		System.out.println("员工信息删除成功！");
	}
	
	public void find(int id)
	{
		for (Employee x:employee)
		{
			if(x.getId()==id)
			{
				System.out.println("查找成功！");
				System.out.println(x);
				return;
			}
		}
		System.out.println("无此ID员工");
	}
	
	public void find(String name)
	{
		for (Employee x:employee)
		{
			if(x.getName()==name)
			{
				System.out.println("查找成功！");
				System.out.println(x);
				return;
			}
		}
		System.out.println("无此ID员工");
	}
	
	public void display()
	{
		System.out.printf("%s\t%s", "姓名","ID");
		System.out.println();
		for (Employee x:employee)
		{
				System.out.printf("%s\t%s", x.getName(),x.getId());
				System.out.println();
		}
		System.out.println("以上为本公司员工信息");
	}
	
}
