<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.latam.JPAcrud.modelo.Productos"%>
<%@page import="com.latam.JPAcrud.vo.ProductoVO"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Logistical</title>

    <!-- CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
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
	<h3>${mensaje}</h3>
	<div class="container">
		<div class="row">
    		<div class="col">
    		</div>
    	<div class="col">
    	<h3>Agregar Producto</h3>
        <form action="agregar" method="post">
            
             <div class="form-group row">
                <label for="inicio" class="col-4">Nombre</label>
                <div class="col-8">
                    <input class="form-control" type="text" id="nombre" name="nombre">
                </div>
            </div>
            <div class="form-group row">
                <label for="duracion" class="col-4">Precio</label>
                <div class="col-8">
                    <input class="form-control" type="number" value="" id="precio" name="precio">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-4">Stock</label>
                <div class="col-8">
                    <input class="form-control" type="number" id="Stock" name="stock">
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
</div>	
<!-- CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<!-- jQuery and JS bundle w/ Popper.js -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>	

</body>
</html>