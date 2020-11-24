package com.latam.JPAcrud.vo;

import lombok.Data;

@Data
public class GenericVO {
	
	String mensaje;
	String codigo;
	
	public GenericVO() {
		super();
	}
	
	public GenericVO(String mensaje, String codigo) {
		super();
		this.mensaje = mensaje;
		this.codigo = codigo;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	

}
