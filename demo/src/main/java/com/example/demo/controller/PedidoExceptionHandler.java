package com.example.demo.controller;

import com.example.demo.service.PrecoInvalidoException;
import com.example.demo.service.QuantidadeInvalidaException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //  para tratar erros e podemos incluir exceção que queremos
public class PedidoExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> tratarGeral(Exception e){
        System.out.println("Exceção do geral: " + e.getMessage());
        return ResponseEntity.status(400).body("Voce fez alguma coisa errada");

    }

    @ExceptionHandler(QuantidadeInvalidaException.class)
    public ResponseEntity<String> tratarQuantidadeInvalida(Exception e){
        System.out.println("Exceção do tratarQuantidadeInvalida: " + e.getMessage());
        return ResponseEntity.status(400).body("Voce digitou a quatntidade errada");
    }

    @ExceptionHandler(PrecoInvalidoException.class)
    public ResponseEntity<String> tratarPrecoInvalido(Exception e){
        System.out.println("Exceção do PrecoInvalidoException: " + e.getMessage());
        return ResponseEntity.status(400).body("Voce digitou o preco errado");
        // com esse metodo estamos no escoppo da aplicação inteira, diferentemente do try cath basico

    }
}
