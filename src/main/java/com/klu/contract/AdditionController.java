package com.klu.contract;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/ms1")
public class AdditionController {

    private final AdditionService service;

    public AdditionController(AdditionService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Map<String, Integer> add(
            @RequestParam int a,
            @RequestParam int b) {

        return Map.of("result", service.add(a, b));
    }
}