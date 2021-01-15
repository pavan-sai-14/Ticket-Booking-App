package com.pavansai;

import javax.security.auth.callback.ConfirmationCallback;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TrianDetails {
	
	String name;
	String confirmedSeat[][]=new String[21][3];
	String RacSeats[][]=new String[9][2];
	String waitingList[]=new String[10];
	
	public TrianDetails(String name) {
		super();
		this.name = name;
		int c=1;
		String s="";
		for(int i=0;i<21;i+=3)
		{
			for(int j=0;j<3;j++)
			{
				if(j%3==0) s="-L-A";
				if(j%3==1) s="-M-A";
				if(j%3==2) s="-U-A";
				confirmedSeat[i][j]=c+s;
				c++;
			}
		}
		
		c=1;
		
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<2;j++)
			{
				RacSeats[i][j]=c+"R-A";
				c++;
			}
		}
		c=1;
		for(int i=0;i<10;i++)
		{
			waitingList[i]=c+"A";
		}
	}
	
	public static boolean confirmSeatIsAvailable(TrianDetails t)
	{
		for(int i=0;i<21;i+=3)
		{
			for(int j=0;j<3;j++)
			{
				String str=t.confirmedSeat[i][j];
				int l=str.length();
				
				if(str.charAt(l-1)=='A')
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean confirmSeatIsAvailable(TrianDetails t, String s) {
		char berth;
		if(s.equalsIgnoreCase("lower"))
		{
			berth='L';
		}
		else if(s.equalsIgnoreCase("middle"))
		{
			berth='M';
		}
		else
		{
			berth='U';
		}
		for(int i=0;i<21;i+=3)
		{
			for(int j=0;j<3;j++)
			{
				String str=t.confirmedSeat[i][j];
				int l=str.length();
				
				if(str.charAt(l-3)==berth)
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean racSeatIsAvailable(TrianDetails t)
	{
		for(int i=0;i<9;i+=3)
		{
			for(int j=0;j<2;j++)
			{
				String str=t.RacSeats[i][j];
				int l=str.length();
				
				if(str.charAt(l-1)=='A')
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean waitingListIsAvailable(TrianDetails t)
	{
		for(int i=0;i<10;i++)
		{
			String str=t.waitingList[i];
			int l=str.length();
			
			if(str.charAt(l-1)=='A')
			{
				return true;
			}
		}
		return false;
	}
	
	public static String bookConfirmedTicket(TrianDetails t)
	{
		for(int i=0;i<21;i+=3)
		{
			for(int j=0;j<3;j++)
			{
				String str=t.confirmedSeat[i][j];
				int l=str.length();
				
				if(str.charAt(l-1)=='A')
				{
					t.confirmedSeat[i][j]=str.substring(0,l-1)+"R";
					return str;
				}
			}
		}
		return "Nil";
	}
	
	public static String bookConfirmedTicket(TrianDetails t,String s)
	{
		char berth;
		if(s.equalsIgnoreCase("lower"))
		{
			berth='L';
		}
		else if(s.equalsIgnoreCase("middle"))
		{
			berth='M';
		}
		else
		{
			berth='U';
		}
		for(int i=0;i<21;i+=3)
		{
			for(int j=0;j<3;j++)
			{
				String str=t.confirmedSeat[i][j];
				int l=str.length();
				
				if(str.charAt(l-1)=='A' && str.charAt(l-3)==berth)
				{
					t.confirmedSeat[i][j]=str.substring(0,l-1)+"R";
					return str.substring(0,l-1)+"R";
				}
			}
		}
		return "Nil";
	}
	
	public static String bookRacTicket(TrianDetails t)
	{
		for(int i=0;i<9;i+=3)
		{
			for(int j=0;j<2;j++)
			{
				String str=t.RacSeats[i][j];
				int l=str.length();
				
				if(str.charAt(l-1)=='A')
				{
					t.RacSeats[i][j]=str.substring(0,l-1)+"R";
					return str.substring(0,l-1)+"R";
				}
			}
		}
		return "Nil";
	}
	
	public static String putInWaitList(TrianDetails t)
	{
		for(int i=0;i<10;i++)
		{
			String str=t.waitingList[i];
			int l=str.length();
			
			if(str.charAt(l-1)=='A')
			{
				t.waitingList[i]=str.substring(0,l-1)+"R";
				return str.substring(0,l-1)+"R";
			}
		}
		return "Nil";
	}
	
	public static boolean cancellationTicket(TrianDetails t,String seat)
	{
		for(int i=0;i<21;i+=3)
		{
			for(int j=0;j<3;j++)
			{
				String str=t.confirmedSeat[i][j];
				int l=str.length();
				if(str.equalsIgnoreCase(seat))
				{
					t.confirmedSeat[i][j]=seat.substring(0,l-1)+"A";
					return true;
				}
			}
		}
		return false;
	}
	
	public static void showAvailableSeat(TrianDetails trian)
	{
		System.out.println("-------------------------------------------------------");
		System.out.println("----------------Show Available Confirmed Seats---------");
		for(int i=0;i<21;i+=3)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print(trian.confirmedSeat[i][j]+" ");
			}
			System.out.println("");
		}
		System.out.println("-------------------------------------------------------");
		System.out.println("----------------Show Available RAC Seats---------------");
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<2;j++)
			{
				System.out.print(trian.RacSeats[i][j]+" ");
			}
			System.out.println(" ");
		}
	}
	
}
