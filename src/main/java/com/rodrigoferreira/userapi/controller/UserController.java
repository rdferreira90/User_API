package com.rodrigoferreira.userapi.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigoferreira.userapi.dto.UserDTO;

@RestController
public class UserController {
	
	@GetMapping("/")
	public String getMensagem() {
		return "Spring boot is working!";
	}	
	
	public static List<UserDTO> usuarios = new ArrayList<UserDTO>();

	@PostConstruct
	public void initiateList() {
		UserDTO userDTO = new UserDTO();

		userDTO.setNome("Eduardo");
		userDTO.setCpf("123");
		userDTO.setEndereco("Rua Genesio de Barros");
		userDTO.setEmail("rdferreira90@gmail.com");
		userDTO.setTelefone("22738810");
		userDTO.setDataCadastro(new Date());

		UserDTO userDTO2 = new UserDTO();
		userDTO2.setNome("Luiz");
		userDTO2.setCpf("456");
		userDTO2.setEndereco("Rua Augusta");
		userDTO2.setEmail("lcarlos@gmail.com");
		userDTO2.setTelefone("77346627");
		userDTO2.setDataCadastro(new Date());

		UserDTO userDTO3 = new UserDTO();
		userDTO3.setNome("Bruna");
		userDTO3.setCpf("891");
		userDTO3.setEndereco("Rua da Ajuda");
		userDTO3.setEmail("bfraga@gmail.com");
		userDTO3.setTelefone("77644412");
		userDTO3.setDataCadastro(new Date());

		usuarios.add(userDTO);
		usuarios.add(userDTO2);
		usuarios.add(userDTO3);
	}

	
	@GetMapping("/users")
	public List<UserDTO> getUsers(){
		return usuarios;
	}
	
	@GetMapping("/users/{cpf}")
	public UserDTO getUserFiltro(@PathVariable String cpf) {
		for(UserDTO userFilter : usuarios) {
			if(userFilter.getCpf().equals(cpf)) {
				return userFilter;
			}
		}
		return null;
	}
	
}
