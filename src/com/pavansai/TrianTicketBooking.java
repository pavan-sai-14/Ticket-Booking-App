package com.pavansai;

import java.util.ArrayList;
import java.util.Scanner;

public class TrianTicketBooking {
	
	public static void main(String args[])
	{
		Scanner input=new Scanner(System.in);
		
		ArrayList<TrianDetails> trains=new ArrayList<>();
		
		
		trains.add(new TrianDetails("Express-1"));
		trains.add(new TrianDetails("Express-2"));
		trains.add(new TrianDetails("Express-3"));
		trains.add(new TrianDetails("Express-4"));
		trains.add(new TrianDetails("Express-5"));
		
		ArrayList<UserDetails> user=new ArrayList<>();
		
		boolean exit=true;
		while(exit)
		{
			System.out.println("Enter the Train Name ");
			trains.forEach(train->System.out.println(train.name));
			String tName=input.next();
			System.out.println("");
			System.out.println("");
			System.out.println("Choice the Options Below");
			System.out.println("Show Available Tickets-1");
			System.out.println("Book Ticket-2");
			System.out.println("View Ticket Details-3");
			System.out.println("Cancellation Ticket-4");
			System.out.println("EXIT-5");
			int opt=input.nextInt();
			
			switch(opt)
			{
				//To View seats
				case 1:
					input.hasNextLine();
					System.out.println("-------------------------------------------------------");
					System.out.println("-------------------------------------------------------");
					System.out.println("----------------Show Available Seats-------------------");
					for(TrianDetails i: trains)
					{
						if(i.name.equalsIgnoreCase(tName))
						{
							i.showAvailableSeat(i);
						}
					}
					System.out.println("-------------------------------------------------------");
					System.out.println("-------------------------------------------------------");
					System.out.println("-------------------------------------------------------");
					System.out.println("");
					System.out.println("");
					break;
				case 2:
					input.hasNextLine();
					System.out.println("-------------------------------------------------------");
					System.out.println("-------------------------------------------------------");
					System.out.println("--------------------Book Seats-------------------------");
					for(TrianDetails i: trains)
					{
						if(i.name.equalsIgnoreCase(tName))
						{
							System.out.println("Enter the Person name,age,gender");
							String name=input.next();
							int age=input.nextInt();
							String gender=input.next();
							String berth;
							String bookedSeat="";
							if(age>5)
							{
								if(i.confirmSeatIsAvailable(i))
								{
									System.out.println("Enter the berth (lower/middle/upper)");
									berth=input.next();
									if(i.confirmSeatIsAvailable(i,berth))
									{
										bookedSeat=i.bookConfirmedTicket(i,berth);
									}
									else
									{
										bookedSeat=i.bookConfirmedTicket(i);
									}
								}
								else if(i.racSeatIsAvailable(i))
								{
									bookedSeat=i.bookRacTicket(i);
								}
								else if(i.waitingListIsAvailable(i))
								{
									bookedSeat="Waiting List";
								}
								else
								{
									System.out.println("Tickets Not Available");
								}
							}
							else
							{
								bookedSeat="Nil";
							}
							user.add(new UserDetails(tName+"##"+name,name,age,gender,tName,bookedSeat)); 
							System.out.println("Sucessfull Booking");
						}
					}
					System.out.println("-------------------------------------------------------");
					System.out.println("-------------------------------------------------------");
					System.out.println("-------------------------------------------------------");
					System.out.println("");
					System.out.println("");
					break;
				case 3:
					input.hasNextLine();
					System.out.println("-------------------------------------------------------");
					System.out.println("-------------------------------------------------------");
					System.out.println("------------------View TicketHolders-------------------");
					System.out.println("Enter Id (i.e TrainName##UserName)");
					String id1=input.next();
					int flag=0;
					for(UserDetails i:user)
					{
						if(i.id.equalsIgnoreCase(id1))
						{
							System.out.println(i);
							flag=1;
							break;
						}
					}
					if(flag==0)
					{
						System.out.println("----------------INVAILD USER DETAILS---------------");
						
					}
					System.out.println("-------------------------------------------------------");
					System.out.println("-------------------------------------------------------");
					System.out.println("-------------------------------------------------------");
					System.out.println(" ");
					System.out.println(" ");
					break;
				case 4:
					input.hasNextLine();
					System.out.println("-------------------------------------------------------");
					System.out.println("-------------------------------------------------------");
					System.out.println("------------------Ticket Cancellation------------------");
					System.out.println("Enter the Id (i.e TrainName##UserName)");
					String id=input.next();
					String seat="";
					String tName1="";
					for(UserDetails i:user)
					{
						if(i.id.equalsIgnoreCase(id))
						{
							int ind=user.indexOf(i);
							tName1=i.trainName;
							seat=i.bookedSeats;
							System.out.println(user.remove(ind));
							break;
						}
					}
					for(TrianDetails i: trains)
					{
						if(i.name.equalsIgnoreCase(tName1))
						{
							if(i.cancellationTicket(i, seat))
							{
								System.out.println("Cancellation Sucessfull");
							}
						}
					}
					
					System.out.println("-------------------------------------------------------");
					System.out.println("-------------------------------------------------------");
					System.out.println("-------------------------------------------------------");
					System.out.println(" ");
					System.out.println(" ");
					break;
				case 5:
					exit=false;
					break;
			}
		}
	}
}
