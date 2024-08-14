package br.com.CalculcadoraCr.service;

import org.springframework.stereotype.Service;
import br.com.CalculcadoraCr.model.CalculoCrRequest;

@Service
public class CalculoCrService {
    public double calcularCr(CalculoCrRequest request) {
        double somaNotas = 0.0;
        double somaCargas = 0.0;

        for (int i = 0; i < request.getNotas().size(); i++) {
            double nota = request.getNotas().get(i).getValor();
            double carga = request.getCargaHoraria().get(i).getHoras();
            somaNotas += nota;
            somaCargas += carga;

        }

        return somaNotas / somaCargas;
    }
}
