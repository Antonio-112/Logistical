<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.latam.JPAcrud.vo.ProductoVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="charset=ISO-8859-1">
<title>Logistical</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  		<a class="navbar-brand" href="/">Empresa Logistical</a>
  		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
   			 <span class="navbar-toggler-icon"></span>
  		</button>

  	<div class="collapse navbar-collapse" id="navbarSupportedContent">
    	<ul class="navbar-nav mr-auto">
    	  <li class="nav-item active">
    	    <a class="nav-link" href="/agregarForm">Agregar<span class="sr-only">(current)</span></a>
    	  </li>
   		 </ul>
  	</div>
	</nav>
	<div class="row">
    	<div class="col">
    	</div>
    <div class="col">
    <h3>Editar Producto</h3>
        <form action="editar" method="post">
            <input type="hidden" value="${VO.getIdProductos()}">
            <div class="form-group row">
                <label for="inicio" class="col-4">Codigo:</label>
                <div class="col-8">
                	<p>${VO.getIdProductos()}</p>
                    <input class="form-control" type="hidden" id="idProductos" name="idProductos" value="${VO.getIdProductos()}">
                </div>
            </div>
             <div class="form-group row">
                <label for="inicio" class="col-4">Nombre</label>
                <div class="col-8">
                    <input class="form-control" type="text" id="nombre" name="nombre" value="${VO.getNombre()}">
                </div>
            </div>
            <div class="form-group row">
                <label for="duracion" class="col-4">Precio</label>
                <div class="col-8">
                    <input class="form-control" type="number" id="precio" name="precio" value="${VO.getPrecio()}">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-4">Stock</label>
                <div class="col-8">
                    <input class="form-control" type="number" id="Stock" name="stock" value="${VO.getStock()}">
            	</div>
            </div>
            <div class="form-group row">
                <div class="col-sm-12">
                    <button type="submit" class="btn btn-primary">Agregar</button>
                </div>
            </div>
        </form>
    </div>
    <div class="col">
    </div>
  </div>


<!-- CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<!-- jQuery and JS bundle w/ Popper.js -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>	
</body>
</html>