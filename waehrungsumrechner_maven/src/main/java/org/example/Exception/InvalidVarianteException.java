package org.example.Exception;

public class InvalidVarianteException extends Exception{

    public InvalidVarianteException(){
        super("Diese Variante wird nicht unterstützt");
    }


}
