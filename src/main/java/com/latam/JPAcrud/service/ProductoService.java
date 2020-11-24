package com.latam.JPAcrud.service;

import com.latam.JPAcrud.modelo.Productos;
import com.latam.JPAcrud.vo.ProductoVO;

public interface ProductoService {
	
	public ProductoVO getAllProductos();
	public ProductoVO findByNombre(String nombre);
	public ProductoVO add(Productos producto);
	public ProductoVO update(Productos producto);
	public ProductoVO delete(Productos producto);
	public ProductoVO findById(Integer id);
	public ProductoVO getPage(Integer pagina, Integer cantidad);

}
