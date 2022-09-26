package jpa.study.controller;

import jpa.study.service.GauService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gau")
public class GauController {

    private final GauService gauService;

    @GetMapping
    public String get(){
        gauService.logic();
        return "ok";
    }
}
