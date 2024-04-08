package com.example.demo.service;

public class PrecoInvalidoException extends RuntimeException {
    public PrecoInvalidoException(String precoNaoPodeSerZero) {
    }
}
