package ru.xpendence.modelmapperdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.xpendence.modelmapperdemo.dto.UnicornDto;
import ru.xpendence.modelmapperdemo.service.UnicornService;


@RequestMapping("/unicorn")
@RestController
public class UnicornController {

    private final UnicornService service;

    @Autowired
    public UnicornController(UnicornService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UnicornDto> save(@RequestBody UnicornDto unicornDto) {
        return ResponseEntity.ok(service.save(unicornDto));
    }

    @GetMapping(path = "/byId")
    public ResponseEntity<UnicornDto> get(@RequestParam Long id) {
        return ResponseEntity.ok(service.get(id));
    }
}
