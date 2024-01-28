package br.com.alura.screenmatch.dto;

import br.com.alura.screenmatch.model.Categoria;
import jakarta.persistence.*;

public record SerieDTO(
        Long id,
        String titulo,
        Integer totalTemporadas,
        Double avaliacao,
        Categoria genero,
        String atores,
        String poster,
        String sinopse) {


}
// Uma classe do tipo record nos oferecem os getter e setter sem que precisamos implementa-los.
