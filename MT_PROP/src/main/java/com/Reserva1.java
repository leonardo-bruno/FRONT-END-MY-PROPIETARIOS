package com;

import java.io.Serializable;

public class Reserva1  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	String bookingno;
	String clientname;
	String datearrival;
	String datedeparture;
	String status;
	
	public Reserva1(String vbookingno, String vclientname, String vdatearrival, String vdatedeparture, String vstatus) {
		this.bookingno=vbookingno;
		this.clientname=vclientname;
		this.datearrival=vdatearrival;
		this.datedeparture=vdatedeparture;
		this.status=vstatus;
	}
	

	public String getBookingno() {
		return bookingno;
	}

	public void setBookingno(String bookingno) {
		this.bookingno = bookingno;
	}

	public String getClientname() {
		return clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	public String getDatearrival() {
		return datearrival;
	}

	public void setDatearrival(String datearrival) {
		this.datearrival = datearrival;
	}

	public String getDatedeparture() {
		return datedeparture;
	}

	public void setDatedeparture(String datedeparture) {
		this.datedeparture = datedeparture;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

}
