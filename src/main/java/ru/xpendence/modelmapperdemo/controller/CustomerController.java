package ru.xpendence.modelmapperdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.xpendence.modelmapperdemo.dto.CustomerDto;
import ru.xpendence.modelmapperdemo.service.CustomerService;

@RequestMapping("/customer")
@RestController
public class CustomerController {

	private final CustomerService service;

	@Autowired
	public CustomerController(CustomerService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<CustomerDto> save(@RequestBody CustomerDto customerDto) {
		return ResponseEntity.ok(service.save(customerDto));
	}

	//todo show path/without path
	@GetMapping(path = "/byId")
	public ResponseEntity<CustomerDto> get(@RequestParam Long id) { //todo show RequestParam/PathVariable
		return ResponseEntity.ok(service.get(id));
	}
}
