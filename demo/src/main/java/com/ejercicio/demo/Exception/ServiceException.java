package com.ejercicio.demo.Exception;

public class ServiceException extends Exception{

    private static final long serislVersionUID= -1777306343576377317L;

    public ServiceException(String mensaje){
        super(mensaje);
    }
    public ServiceException(String mensaje, Throwable causa){
        super(mensaje, causa);
    }
}
