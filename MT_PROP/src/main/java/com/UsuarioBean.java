package com;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Query;

@ManagedBean(name="UsuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable{

	private static final long serialVersionUID = 1L;

	String correo, password, cliente;
	
	Usuario usuario;
	DatastoreService ds;
	Usuario usuarioSeleccionado;
	List<Usuario> listaUsuario;
	
	public UsuarioBean() {
		
	}
	
	public String Acceder() {
		ds=DatastoreServiceFactory.getDatastoreService();
		listaUsuario=new ArrayList<Usuario>();
		Query q=new Query("Usuario");
		
		List<Entity> ent=ds.prepare(q).asList(FetchOptions.Builder.withDefaults());
		if(ent.isEmpty()) {
			usuarioSeleccionado=new Usuario("support@masteryield.com","Nadia123","todo");
			ds.put(usuarioSeleccionado.getEnt());
		}
		for(Entity e : ent) {
			if(e.getProperty("correo").toString().equals(correo) && e.getProperty("password").toString().equals(password)) {
				String vC=(String)e.getProperty("correo");
				String vP=(String)e.getProperty("password");
				String vCl=(String)e.getProperty("cliente");
				usuarioSeleccionado=new Usuario(vC,vP,vCl);
				listaUsuario.add(usuarioSeleccionado);
			}
		}
		if(listaUsuario.isEmpty()) return "hello";

		
		return "paginaPrincipal";
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public DatastoreService getDs() {
		return ds;
	}

	public void setDs(DatastoreService ds) {
		this.ds = ds;
	}

	public Usuario getUsuarioSeleccionado() {
		return usuarioSeleccionado;
	}

	public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
		this.usuarioSeleccionado = usuarioSeleccionado;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}
	
}
