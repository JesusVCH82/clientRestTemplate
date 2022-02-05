package com.client.restTemplate.models;


public class Cliente {
	
	private int id;
	private String nombre;
	private String apellidos;
	private int edad;
	private String rfc;
	private String direccion;
	private String telefono;
	
	public Cliente(int id, String nombre, String apellidos, int edad, String rfc, String direccion, String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.rfc = rfc;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	 
	public Cliente() {
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", rfc="
				+ rfc + ", direccion=" + direccion + ", telefono=" + telefono + "]";
	}
}
