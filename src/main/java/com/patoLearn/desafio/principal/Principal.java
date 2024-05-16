package com.patoLearn.desafio.principal;

import com.patoLearn.desafio.model.Datos;
import com.patoLearn.desafio.service.ConsumoApi;
import com.patoLearn.desafio.service.ConvierteDatos;

public class Principal {
    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConvierteDatos conversor = new ConvierteDatos();

    public void mostrarMenu() {
        String json = consumoApi.obtenerDatos(URL_BASE);
        System.out.println(json);

        Datos datos = conversor.obtenerDatos(json, Datos.class);
        System.out.println(datos);
    }
}
