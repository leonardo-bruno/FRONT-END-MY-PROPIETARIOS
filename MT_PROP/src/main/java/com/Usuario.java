package com;

import java.io.Serializable;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.Entity;

public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	String correo, password, cliente;
	
	Entity ent=new Entity("Usuario");
	DatastoreService ds;
	
	public Usuario(String vcorreo, String vpassword, String vcliente) {
		ent.setProperty("correo", vcorreo);
		ent.setProperty("password", vpassword);
		ent.setProperty("cliente", vcliente);
	}

	public String getCorreo() {
		return (String)ent.getProperty("correo");
	}

	public void setCorreo(String correo) {
		ent.setProperty("correo", correo);
	}

	public String getPassword() {
		return (String)ent.getProperty("password");
	}

	public void setPassword(String password) {
		ent.setProperty("password", password);
	}

	public String getCliente() {
		return (String)ent.getProperty("cliente");
	}

	public void setCliente(String cliente) {
		ent.setProperty("cliente", cliente);
	}

	public Entity getEnt() {
		return ent;
	}

	public void setEnt(Entity ent) {
		this.ent = ent;
	}

	public DatastoreService getDs() {
		return ds;
	}

	public void setDs(DatastoreService ds) {
		this.ds = ds;
	}
	
	
	
}
