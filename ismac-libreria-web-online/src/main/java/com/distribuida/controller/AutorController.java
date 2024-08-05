package com.distribuida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.distribuida.dao.AutorDAO;
import com.distribuida.entities.Autor;

@Controller
@RequestMapping("/autor")//path principal
public class AutorController {
	@Autowired
	@Qualifier("autorDAOImpl2")
	private AutorDAO autorDAO;
	
	@RequestMapping ("/findAll")//path secundario
	public String findAll(Model model) {
		
		//try {
			List<Autor> autor=autorDAO.findAll();
			
			model.addAttribute("autor",autor);//key:clientes o keyclientes !! valor:clientes
			
			return"autor-listar";//este es el nombre del formulario web a usar"clientes-listar.html","clientes-listar.jsp"
			
			
//		} catch (Exception e) {
	//		// TODO: handle exception
		//}
		
				
	}
	
	
	@RequestMapping("/findOne") //Actualizar o eliminar
	public String findOne(@RequestParam("idAutor") @Nullable Integer idAutor
						,@RequestParam("opcion")@Nullable Integer opcion
						,Model model
			) {
		
		if(idAutor !=null) {
			Autor autor =autorDAO.findOne(idAutor);
			model.addAttribute("autor",autor);
		}
		if(opcion == 1) return "autor-add"; 
		else return "autor-del";
	}
	
	@RequestMapping("/add")
	public String add(@RequestParam("idCliente")@Nullable Integer idAutor
					 ,@RequestParam("nombre")@Nullable String nombre
					 ,@RequestParam("apellido")@Nullable String apellido
					 ,@RequestParam("pais")@Nullable String pais
					 ,@RequestParam("direccion")@Nullable String direccion
					 ,@RequestParam("telefono")@Nullable String telefono
					 ,@RequestParam("correo")@Nullable String correo
					 ,Model model
					) {
			if(idAutor == null) {
				Autor autor =new Autor(0,nombre,apellido,pais,direccion,telefono,correo);
				autorDAO.add(autor);
				
			}else {
				Autor autor =new Autor(idAutor,nombre,apellido,pais,direccion,telefono,correo);
				autorDAO.up(autor);
								
				
			}
		
			
				
		return "redirect:/clientes/findAll";
	}
	
	@RequestMapping("/del")
	public String del(@RequestParam("idAutor")@Nullable Integer idAutor) {
		autorDAO.del(idAutor);
		
	return"redirect:/autor/findAll";	
	}
}
	

