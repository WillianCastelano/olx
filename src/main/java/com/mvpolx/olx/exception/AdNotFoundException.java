package com.mvpolx.olx.exception;

public class AdNotFoundException extends RuntimeException {

        public AdNotFoundException(Long id) {
            super("Anúncio com ID " + id + "não encontrado.");
        }
    }
