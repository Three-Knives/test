package main;


public class Employee {

	private int id;
	private String name;
	
	
	public Employee(String ininame,int iniid) {
		// TODO Auto-generated constructor stub
		id=iniid;
		name=ininame;
	}
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	@Override
	public String toString() 
	{
		// TODO Auto-generated method stub
		String result="员工姓名："+name+"\n"+"ID："+id;
		return result;
	}
}
