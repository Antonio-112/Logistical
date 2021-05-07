package com.latam.JPAcrud.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.latam.JPAcrud.JpaCrudApplication;
import com.latam.JPAcrud.dao.ProductoRepository;
import com.latam.JPAcrud.modelo.Productos;
import com.latam.JPAcrud.vo.ProductoVO;

@Service
public class ProductoServiceImpl implements ProductoService {

	private static final Logger log = LoggerFactory.getLogger(JpaCrudApplication.class);

	@Autowired
	ProductoRepository dao;

	com.latam.JPAcrud.vo.ProductoVO respuesta;

	@Override
	public ProductoVO getAllProductos() {
		respuesta = new ProductoVO("102", "Ha ocurrido un error", new ArrayList<Productos>());
		try {
			respuesta.setProducto((List<Productos>) dao.findAll());
			respuesta.setMensaje(String.format("Se ha/n encontrado %d registro/s", respuesta.getProducto().size()));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.trace("Usuario Service: Error en getAllUsuarios", e);
		}
		return respuesta;
	}

	@Override
	@Transactional(readOnly = true)
	public ProductoVO findByNombre(String nombre) {
		respuesta = new ProductoVO("101", "Ha ocurrido un error", new ArrayList<Productos>());
		try {
			List<Productos> producto = dao.findByNombre(nombre);
			if (producto.size() > 0) {
				respuesta.setProducto(producto);
				respuesta.setMensaje("Producto encontrado correctamente.");
				respuesta.setCodigo("0");
			} else {
				respuesta.setMensaje("Producto no encontrado.");
			}
		} catch (Exception e) {
			log.trace("Producto Service: Error en findByNombreAndClave", e);
		}
		return respuesta;
	}

	@Override
	@Transactional
	public ProductoVO add(Productos pruducto) {
		respuesta = new ProductoVO("104", "Ha ocurrido un error", new ArrayList<Productos>());
		try {
			dao.save(pruducto);
			respuesta.setMensaje(String.format("Se ha guardado correctamente al producto %s", pruducto.getNombre()));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.trace("Producto Service: Error en add", e);
		}
		return respuesta;

	}

	@Override
	public ProductoVO update(Productos producto) {
		respuesta = new ProductoVO("105", "Ha ocurrido un error", new ArrayList<Productos>());
		try {
			Integer id = producto.getIdProductos();
			producto.setIdProductos(id);
			dao.save(producto);
			respuesta.setMensaje(String.format("Se ha actualizado correctamente al producto %s", producto.getNombre()));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.trace("Producto Service: Error en update", e);
		}
		return respuesta;
	}

	@Override
	public ProductoVO delete(Productos producto) {
		respuesta = new ProductoVO("106", "Ha ocurrido un error", new ArrayList<Productos>());
		try {
			dao.delete(producto);
			respuesta.setMensaje("Se ha eliminado correctamente al producto");
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.trace("Producto Service: Error en delete", e);
		}
		return respuesta;
	}

	@Override
	public ProductoVO findById(Integer id) {
		respuesta = new ProductoVO("107", "Ha ocurrido un error", new ArrayList<Productos>());
		try {

			Productos producto = dao.findById(id).get();
			respuesta.getProducto().add(producto);
			respuesta.setMensaje("Producto encontrado correctamente.");
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.trace("Producto Service: Error en findByNombreAndClave", e);
		}
		return respuesta;
	}

	@Override
	@Transactional(readOnly = true)
	public ProductoVO getPage(Integer pagina, Integer cantidad) {
		respuesta = new ProductoVO("108", "Ha ocurrido un error", new ArrayList<Productos>());
		try {
			PageRequest pageable = PageRequest.of(pagina, cantidad);
			Page<Productos> responsePage = dao.findAll(pageable);
			respuesta.setProducto(responsePage.getContent());
			respuesta.setMensaje(String.format("Se ha/n encontrado %d registro/s", respuesta.getProducto().size()));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.trace("Usuario Service: Error en getPage", e);
		}
		return respuesta;
	}

}
