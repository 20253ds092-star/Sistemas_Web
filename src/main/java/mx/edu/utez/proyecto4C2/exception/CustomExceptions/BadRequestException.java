package mx.edu.utez.proyecto4C2.exception.CustomExceptions;

public class BadRequestException extends  RuntimeException {
 public  BadRequestException (String message){
     super(message);
 }
}
