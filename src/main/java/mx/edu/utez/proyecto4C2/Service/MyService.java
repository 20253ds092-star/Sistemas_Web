package mx.edu.utez.proyecto4C2.Service;

import mx.edu.utez.proyecto4C2.controller.Dto.RequestCalculadoraDTO;
import mx.edu.utez.proyecto4C2.exception.CustomExceptions.BadRequestException; // Importante
import org.springframework.stereotype.Service;

@Service
public class MyService {

    public double calculadora(RequestCalculadoraDTO payload) {
        String operacion = payload.getOperacion();

        // Validar operación permitida
        if (!"DIVISION".equals(operacion)
                && !"SUMA".equals(operacion)
                && !"RESTA".equals(operacion)
                && !"MULTIPLICACION".equals(operacion)) {
            // Se lanza la excepción personalizada que atrapa el ErrorHandler
            throw new BadRequestException("La operacion no es valida");
        }

        double resultado = 0;

        switch (operacion) {
            case "MULTIPLICACION":
                resultado = payload.getNum1() * payload.getNum2();
                break;
            case "SUMA":
                resultado = payload.getNum1() + payload.getNum2();
                break;
            case "RESTA":
                resultado = payload.getNum1() - payload.getNum2();
                break;
            case "DIVISION":
                if (payload.getNum2() == 0) {
                    throw new BadRequestException("No se puede dividir entre cero");
                }
                resultado = payload.getNum1() / payload.getNum2();
                break;
        }

        return resultado;
    }
}