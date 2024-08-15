package br.com.CalculcadoraCr.service;

import br.com.CalculcadoraCr.model.CalculoCrRequest;
import org.springframework.stereotype.Service;

@Service
public class CalculoCrService {

    public double calcularCr(CalculoCrRequest request) {
        double somaNotas = 0.0;
        int somaHoras = 0;

        for (int i = 0; i < request.getNotas().size(); i++) {
            double nota = request.getNotas().get(i).getValor();
            int horas = request.getCargasHorarias().get(i).getHoras();
            somaNotas += nota * horas;
            somaHoras += horas;
        }

        return somaNotas / somaHoras;
    }
}