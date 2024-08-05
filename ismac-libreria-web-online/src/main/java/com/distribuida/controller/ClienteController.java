package com.distribuida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.distribuida.dao.ClienteDAO;
import com.distribuida.entities.Cliente;

@Controller
@RequestMapping("/clientes")//path principal
public class ClienteController {
	@Autowired
	private ClienteDAO clienteDAO;
	
	@RequestMapping ("/findAll")//path secundario
	public String findAll(Model model) {
		
		//try {
			List<Cliente> clientes=clienteDAO.findAll();
			
			model.addAttribute("clientes",clientes);//key:clientes o keyclientes !! valor:clientes
			
			return"clientes-listar";//este es el nombre del formulario web a usar"clientes-listar.html","clientes-listar.jsp"
			
			
//		} catch (Exception e) {
	//		// TODO: handle exception
		//}
		
				
	}
	
	
	@RequestMapping("/findOne") //Actualizar o eliminar
	public String findOne(@RequestParam("idCliente") @Nullable Integer idCliente
						,@RequestParam("opcion")@Nullable Integer opcion
						,Model model
			) {
		
		if(idCliente !=null) {
			Cliente cliente =clienteDAO.findOne(idCliente);
			model.addAttribute("cliente",cliente);
		}
		if(opcion == 1) return "clientes-add"; 
		else return "clientes-del";
	}
	
	@RequestMapping("/add")
	public String add(@RequestParam("idCliente")@Nullable Integer idCliente
					 ,@RequestParam("cedula")@Nullable String cedula
					 ,@RequestParam("nombre")@Nullable String nombre
					 ,@RequestParam("apellido")@Nullable String apellido
					 ,@RequestParam("direccion")@Nullable String direccion
					 ,@RequestParam("telefono")@Nullable String telefono
					 ,@RequestParam("correo")@Nullable String correo
					 ,Model model
					) {
			if(idCliente == null) {
				Cliente cliente =new Cliente(0,cedula,nombre,apellido,direccion,telefono,correo);
				clienteDAO.add(cliente);
				
			}else {
				Cliente cliente =new Cliente(idCliente,cedula,nombre,apellido,direccion,telefono,correo);
				clienteDAO.up(cliente);
				
			}
		
			
				
		return "redirect:/clientes/findAll";
	}
	
	@RequestMapping("/del")
	public String del(@RequestParam("idCliente")@Nullable Integer idCliente) {
		clienteDAO.del(idCliente);
		
	return"redirect:/clientes/findAll";	
	}
	
}
