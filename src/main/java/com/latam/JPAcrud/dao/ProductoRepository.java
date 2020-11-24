package com.latam.JPAcrud.dao;


import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.latam.JPAcrud.modelo.Productos;

@ComponentScan
public interface ProductoRepository extends CrudRepository<Productos,
Integer>,PagingAndSortingRepository<Productos, Integer> {
	
	@Query("FROM Productos WHERE nombre = ?1")
	public List<Productos> findByNombre(String nombre);
	
	@Modifying
    @Query("UPDATE from Productos p SET p.nombre = :nombre WHERE p.idProductos = :idProductos")
	public int updateProducto(@Param("nombre") String nombre, @Param("idProductos") String idProductos); 




}
