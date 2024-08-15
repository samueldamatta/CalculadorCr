package br.com.CalculcadoraCr.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    public double calcularCr(@RequestBody CalculoCrRequest request) {
        return calculoCrService.calcularCr(request);
    }
}