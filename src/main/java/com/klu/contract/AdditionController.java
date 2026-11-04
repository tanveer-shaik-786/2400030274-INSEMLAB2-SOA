package com.klu.contract;

import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RestController
	@RequestMapping("/ms1")
	public class AdditionController {

	    @GetMapping("/add")
	    public Map<String, Integer> add(
	            @RequestParam int a,
	            @RequestParam int b) {

	        int sum = a + b;

	        return Map.of("result", sum);
	    }
	}
