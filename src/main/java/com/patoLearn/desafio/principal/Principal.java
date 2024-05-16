package com.patoLearn.desafio.principal;

import com.patoLearn.desafio.model.Datos;
import com.patoLearn.desafio.model.DatosLibros;
import com.patoLearn.desafio.service.ConsumoApi;
import com.patoLearn.desafio.service.ConvierteDatos;

import java.util.Comparator;

public class Principal {
    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConvierteDatos conversor = new ConvierteDatos();

    public void mostrarMenu() {
        String json = consumoApi.obtenerDatos(URL_BASE);
        System.out.println(json);

        Datos datos = conversor.obtenerDatos(json, Datos.class);

        // Top 10 libros más descargados
        System.out.println("Top 10 libros más descargados");
        datos.resultados().stream()
                .sorted(Comparator.comparing(DatosLibros::numeroDescargas).reversed())
                .limit(10)
                .map(l -> l.titulo().toUpperCase())
                .forEach(System.out::println);
    }
}
