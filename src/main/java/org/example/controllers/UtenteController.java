package org.example.controllers;

import it.pasqualecavallo.studentsmaterial.authorization_framework.security.ZeroSecurity;
import org.example.controllers.dto.*;
import org.example.service.AnagraficaUtenteService;
import org.example.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.pasqualecavallo.studentsmaterial.authorization_framework.filter.AuthenticationContext;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.PublicEndpoint;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.RoleSecurity;

@RestController
@RequestMapping("/user")
public class UtenteController {

	@Autowired
	private UtenteService utenteService;
	
	@PostMapping("/register")
	@PublicEndpoint
	public RegistrationResponseDto register(@RequestBody RegistrationRequestDto request) {
		return utenteService.register(request);
	}
	
	@PostMapping("/activate")
	@PublicEndpoint
	public ActivateResponseDto activate(@RequestBody ActivateRequestDto request) {
		return utenteService.activate(request);		
	}
	
	@PostMapping("/promote-me")
	@RoleSecurity(value = "ROLE_UTENTE")
	public StatusResponse promoteMe() {
		String username = AuthenticationContext.get().getUsername();
		return utenteService.promoteMe(username);
	}
	@Autowired
	private AnagraficaUtenteService anagraficaUt;

	@PostMapping("/create-anagrafica")
	@ZeroSecurity
	public AnagraficaUtenteResponseDto createAnagrafica(@RequestBody AnagraficaUtenteRequestDto request){
		return anagraficaUt.postAnagrafica(request);
	}

}
