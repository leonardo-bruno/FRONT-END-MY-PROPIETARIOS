package com;

import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@ManagedBean(name="ReservaBean")
@SessionScoped
public class ReservaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public String infoEntrante;
	public String bookingno;
	public String clientname;
	public String datearrival;
	public String datedeparture;
	public String status, vS;
	
	List<Reserva1> reservas;
	Reserva1 res;
	
	public ReservaBean() {

	}

	public List<Reserva1> getLista() throws Exception{
		URL url = new URL("http://130.193.15.22:8080/Propietarios_MY/webresources/com.Operaciones/metodo1/"+infoEntrante);
        URLConnection connection = url.openConnection();
        reservas=new ArrayList<Reserva1>();
        Document doc = parseXML(connection.getInputStream());
        
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("bookings");
        for(int i=0; i<nList.getLength();i++)
        {
        	Node nNode=nList.item(i);
        	if(nNode.getNodeType() == Node.ELEMENT_NODE) {
        		Element eElement = (Element) nNode;
        		bookingno=eElement.getElementsByTagName("bookingno").item(0).getTextContent();
        		if(eElement.getElementsByTagName("clientname").getLength()==0) {clientname="";}
        		else clientname=eElement.getElementsByTagName("clientname").item(0).getTextContent();
        		datearrival=eElement.getElementsByTagName("datearrival").item(0).getTextContent();
        		datedeparture=eElement.getElementsByTagName("datedeparture").item(0).getTextContent();
        		status=eElement.getElementsByTagName("status").item(0).getTextContent();
        		res=new Reserva1(bookingno,clientname,datearrival,datedeparture,status);
      	        reservas.add(res);
        	}
        	
	    }
		return reservas;
	}
	private Document parseXML(InputStream stream) throws Exception{
        DocumentBuilderFactory objDocumentBuilderFactory = null;
        DocumentBuilder objDocumentBuilder = null;
        Document doc = null;
        try
        {
            objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
            objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();

            doc = objDocumentBuilder.parse(stream);
        }
        catch(Exception ex)
        {
            throw ex;
        }       

        return doc;
    }
	

	
	public String getInfoEntrante() {
		return infoEntrante;
	}

	public void setInfoEntrante(String infoEntrante) {
		this.infoEntrante = infoEntrante;
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

	public List<Reserva1> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva1> reservas) {
		this.reservas = reservas;
	}

	public Reserva1 getRes() {
		return res;
	}

	public void setRes(Reserva1 res) {
		this.res = res;
	}
	



}
