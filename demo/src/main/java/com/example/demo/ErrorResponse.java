package com.example.demo;

import java.time.Instant;
import java.util.List;

public class ErrorResponse {
    int status;
    String message;
    Instant timeAmp;
    private List<String> erros;


    public void setStatus(int status){this.status = status;}
    public void setMessage(String message){this.message = message;}
    public void setTimeAmp(Instant timeAmp){this.timeAmp = timeAmp;}
    public void setErros(List<String> erros){this.erros = erros;}

    public int getStatus(){return this.status;}
    public String getMessage(){return this.message;}
    public Instant getTimeAmp(){return this.timeAmp;}
    public List<String> getErros(){return this.erros;}
    
    }
    

