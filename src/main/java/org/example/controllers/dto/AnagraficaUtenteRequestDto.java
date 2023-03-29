package org.example.controllers.dto;

public class AnagraficaUtenteRequestDto {



    private String nome;

    private String cognome;

    private String indirizzo;

    private String cellulare;

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getCellulare() {
        return cellulare;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public void setCellulare(String cellulare) {
        this.cellulare = cellulare;
    }
}

