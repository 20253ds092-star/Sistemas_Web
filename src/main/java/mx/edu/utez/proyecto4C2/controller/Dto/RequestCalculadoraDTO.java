package mx.edu.utez.proyecto4C2.controller.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RequestCalculadoraDTO {

    @NotNull(message = "El número 1 es obligatorio")
    private Double num1;

    @NotNull(message = "El número 2 es obligatorio")
    private Double num2;

    @NotBlank(message = "La operación es obligatoria")
    private String operacion; // Con 'a'

    // Getters y Setters
    public Double getNum1() {
        return num1;
    }

    public void setNum1(Double num1) {
        this.num1 = num1;
    }

    public Double getNum2() {
        return num2;
    }

    public void setNum2(Double num2) {
        this.num2 = num2;
    }

    public String getOperacion() { // Con 'a'
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }
}