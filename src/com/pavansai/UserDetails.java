package com.pavansai;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDetails {
	String id;
	String name;
	int age;
	String gender;
	String trainName;
	String bookedSeats;
	public UserDetails(String id,String name, int age, String gender,String tName,String seat) {
		super();
		this.id=id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.trainName=tName;
		this.bookedSeats=seat;
	}
	
	
}
