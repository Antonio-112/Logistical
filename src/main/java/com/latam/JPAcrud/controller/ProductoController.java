package com.latam.JPAcrud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.latam.JPAcrud.modelo.Productos;
import com.latam.JPAcrud.service.ProductoService;
import com.latam.JPAcrud.vo.ProductoVO;

@Controller
public class ProductoController {
	
	private static final Logger log = LoggerFactory.getLogger(ProductoController.class);

	@Autowired
	ProductoService svc;
	
	
	/**
	* Las solicitudes de la pagina principal
	*/
	@GetMapping({ "/" })
	public String home(Model model) {
		model.addAttribute("VO", svc.getAllProductos());
	return "home";
	}
	
	/**
	* Abre el formulario de edición cargando los datos del usuario
	*/
	@GetMapping("/editarForm")
	public ModelAndView editarForm(Model model, @RequestParam String idProductos, RedirectAttributes ra) {
		ProductoVO respuestaServicio = new ProductoVO();
		respuestaServicio.setMensaje("No se pudo cargar la vista de edición, intente nuevamente.");
		try {
			Integer id = (Integer.parseInt(idProductos));
			respuestaServicio = svc.findById(id);
			//System.out.println(respuestaServicio.getProductos().get(id).getIdProductos());
			model.addAttribute("mensaje", respuestaServicio.getMensaje());
			model.addAttribute("VO", respuestaServicio.getProductos().get(0));
			return new ModelAndView("editar");
		} catch (Exception e) {
			log.error("Error en editarForm editar", e);
		}
	ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
	respuestaServicio = svc.getAllProductos();
	return new ModelAndView("redirect:/");
	}
	
	/**
	* Llama al método del servicio que se encarga de actualizar los datos del usuario en base de datos
	*/
	@PostMapping("/editar")
	public ModelAndView editar(@ModelAttribute Productos producto, RedirectAttributes ra) {
		//producto.setIdProductos(idProductos);
		ProductoVO respuestaServicio = svc.update(producto);
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		if (respuestaServicio.getCodigo().equals("0")) {
			return new ModelAndView("redirect:/");
		} else {
			return new ModelAndView("redirect:/editarForm");
		}
	}
	
	/**
	* Abre el formulario de creación de usuarios
	*/
	@GetMapping("/agregarForm")
	public String agregarForm(Model model) {
		return "agregar";
	}
	
	/**
	* Llama al método del servicio que se encarga de crear los datos del usuario en base de datos
	*/
	@PostMapping("/agregar")
	public ModelAndView agregarSubmit(@ModelAttribute Productos producto, RedirectAttributes ra) {
		ProductoVO respuestaServicio = svc.add(producto);
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		if (respuestaServicio.getCodigo().equals("0")) {
			return new ModelAndView("redirect:/");	
		} else {
			return new ModelAndView("redirect:/agregarForm");
		}
	}
	
	/**
	* Llama al método del servicio que se encarga de eliminar los datos del usuario en base de datos
	* y redirecciona al home.
	*/
	@GetMapping("/eliminar")
	public ModelAndView eliminar(Model model, @RequestParam String idProductos, RedirectAttributes ra){
		ProductoVO respuestaServicio = new ProductoVO();
		respuestaServicio.setMensaje("No se pudo eliminar al usuario, intente nuevamente.");
		try {
			Productos eliminado = new Productos();
			eliminado.setIdProductos(Integer.parseInt(idProductos));
			respuestaServicio = svc.delete(eliminado);
			ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
			return new ModelAndView("redirect:/");
		} catch (Exception e) {
			log.error("Error en UsuarioController eliminar", e);
		}
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		respuestaServicio = svc.getAllProductos();
		ra.addAttribute("VO", respuestaServicio);
		return new ModelAndView("redirect:/");
	}
	
}
