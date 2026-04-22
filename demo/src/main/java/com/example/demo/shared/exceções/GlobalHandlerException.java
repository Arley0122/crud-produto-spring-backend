package com.example.demo.shared.exceções;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.shared.payload.ErrorResponse;

@ControllerAdvice
public class GlobalHandlerException {
    
    @ExceptionHandler(ProdutoNaoEncontradoException.class)
    public ResponseEntity<ErrorResponse> tratarProdutoNaoEncontraod(ProdutoNaoEncontradoException ex){

        ErrorResponse erro = new ErrorResponse();
        erro.setStatus(404);
        erro.setTimeAmp(Instant.now());
        erro.setMessage(ex.getMessage());

        return ResponseEntity.status(404).body(erro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> tratarProdutoInvalido(MethodArgumentNotValidException ex){
        ErrorResponse erro = new ErrorResponse();
        erro.setMessage("Erro de validação");
        erro.setStatus(400);
        erro.setTimeAmp(Instant.now());

        List<String> mensagemErros = new ArrayList<>();
        
        for(FieldError campoErro : ex.getBindingResult().getFieldErrors()){

            mensagemErros.add(String.format("%s: %s",campoErro.getField(), campoErro.getDefaultMessage() ));
        }
        erro.setErros(mensagemErros);
        return ResponseEntity.status(400).body(erro);
    }
}   
 
