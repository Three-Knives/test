package main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DakaInfo {

	private int id;
	private Date on;
	private Date out;
	
	public DakaInfo( int iniid) 
	{
		id=iniid;
		on=null;
		out=null;
	}
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public Date getOn() 
	{
		return on;
	}
	
	public void setOn(Date on) 
	{
		this.on = on;
	}
	
	public Date getOut() 
	{
		return out;
	}
	
	public void setOut(Date out) 
	{
		this.out = out;
	}
	
	public void login()
	{
		on=new Date();
	}
	
	public void logout()
	{
		out=new Date();
	}
	
	public String displayOn()
	{
		if(on==null)
		{
			return "未签到";
		}
		else
		{
			SimpleDateFormat sdf = new SimpleDateFormat("y年MM月dd日HH时mm分ss秒");
			return sdf.format(on);
		}
	}
	
	public String displayout()
	{
		if(out==null)
		{
			if(on==null)
			{
				return "\t\t\t"+"未签退";
			}
			else
			{
				return "未签退";
			}
		}
		else
		{
			SimpleDateFormat sdf = new SimpleDateFormat("y年MM月dd日HH时mm分ss秒");
			return sdf.format(out);
		}
	}
}
