package org.example.service;

import it.pasqualecavallo.studentsmaterial.authorization_framework.filter.AuthenticationContext;
import org.example.controllers.dto.AnagraficaUtenteRequestDto;
import org.example.controllers.dto.AnagraficaUtenteResponseDto;
import org.example.controllers.dto.ImmobileRequestDto;
import org.example.entity.AnagraficaUtente;
import org.example.entity.Immobile;
import org.example.entity.Utente;
import org.example.repository.AnagraficaUtenteRepository;
import org.example.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnagraficaUtenteService {
    
    @Autowired
    private AnagraficaUtenteRepository anagraficaUtenteRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    public AnagraficaUtenteResponseDto postAnagrafica(AnagraficaUtenteRequestDto request){
        String username = AuthenticationContext.get().getUsername();
        Optional<Utente> utente = utenteRepository.findById(username);
        return anagraficaUtenteToResponse(anagraficaUtenteRepository.save(anagraficaUtenteToEntity(request, utente.get())));
    }



    private AnagraficaUtenteResponseDto anagraficaUtenteToResponse(AnagraficaUtente anagraficaUtente){
        AnagraficaUtenteResponseDto response = new AnagraficaUtenteResponseDto();
        response.setNome(anagraficaUtente.getNome());
        response.setId(anagraficaUtente.getId());
        response.setIndirizzo(anagraficaUtente.getIndirizzo());
        response.setCellulare(anagraficaUtente.getCellulare());
        response.setCognome(anagraficaUtente.getCognome());
        return response;
    }

    private AnagraficaUtente anagraficaUtenteToEntity(AnagraficaUtenteRequestDto request, AnagraficaUtente anagraficaUtente, Utente utente){
        anagraficaUtente.setNome(request.getNome());
        anagraficaUtente.setCognome(request.getCognome());
        anagraficaUtente.setIndirizzo(request.getIndirizzo());
        anagraficaUtente.setCellulare(request.getCellulare());
        anagraficaUtente.setUtente(utente);
        return anagraficaUtente;
    }

    private AnagraficaUtente anagraficaUtenteToEntity(AnagraficaUtenteRequestDto request, Utente utente){
        AnagraficaUtente anagraficaUtente = new AnagraficaUtente();
        return anagraficaUtenteToEntity(request, anagraficaUtente, utente);
    }

}
