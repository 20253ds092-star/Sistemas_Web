package mx.edu.utez.proyecto4C2.controller;

import jakarta.validation.Valid;
import mx.edu.utez.proyecto4C2.Service.MyService;
import mx.edu.utez.proyecto4C2.controller.Dto.RequestBodyDTO;
import mx.edu.utez.proyecto4C2.controller.Dto.RequestCalculadoraDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/my-services")
public class MyController {
    private final MyService service;

    private final String NOMBRE_ALUMNO = "Avila Baeza Luis Javoer";

    public MyController(MyService service) {
        this.service = service;
    }

    @GetMapping
    public String miPrimerServicio() {
        return "hello world";
    }

    @GetMapping("/servicio2")
    public String servicio2() {
        return "segundo Servicio";
    }

    @PostMapping("/servicio3")
    public String servicio3() {
        return "Este es el servicio 3";
    }

    @GetMapping("/path/{id}")
    public String pathVariable(@PathVariable String id) {
        return "el path variable es: " + id;
    }

    @PostMapping("/body")
    public ResponseEntity<RequestBodyDTO> crearPersona(@Valid @RequestBody RequestBodyDTO payload) {
        System.out.println(payload.getEdad());
        System.out.println(payload.getNombre());
        return ResponseEntity.status(HttpStatus.CREATED).body(payload);
    }

    @GetMapping("/fizzbuzz/{n}")
    public String fizzBuzz(@PathVariable int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
        return NOMBRE_ALUMNO;
    }

    @GetMapping("/fibonacci/{n}")
    public String fibonacci(@PathVariable int n) {
        long a = 0, b = 1;
        for (int i = 1; i <= n; i++) {
            System.out.println(a);
            long siguiente = a + b;
            a = b;
            b = siguiente;
        }
        return NOMBRE_ALUMNO;
    }

    @PostMapping("/calculadora")
    public double calculadora(@RequestBody @Valid RequestCalculadoraDTO payload) {
        return service.calculadora(payload);
    }
}