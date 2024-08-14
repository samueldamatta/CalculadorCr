package br.com.CalculcadoraCr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.CalculcadoraCr.model.CalculoCrRequest;
import br.com.CalculcadoraCr.service.CalculoCrService;

@RestController
@RequestMapping("/api/calculo-cr")
public class CalculoCrController {

    @Autowired
    private CalculoCrService calculoCrService;

    @PostMapping
    public ResponseEntity<Double> calcularCr(@RequestBody CalculoCrRequest request) {
        try {
            double resultado = calculoCrService.calcularCr(request);
            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<String> testEndpoint() {
    return ResponseEntity.ok("Endpoint funcionando");
}
}