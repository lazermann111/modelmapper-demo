package ru.xpendence.modelmapperdemo.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.xpendence.modelmapperdemo.dto.CustomerDto;
import ru.xpendence.modelmapperdemo.entity.Customer;
import ru.xpendence.modelmapperdemo.service.CustomerService;

@RequestMapping("/customer")
@RestController
public class CustomerController {

	private final CustomerService service;

	@Autowired
	public CustomerController(CustomerService service) {
		this.service = service;
	}

	@ApiOperation(value = "Creates new customer")
	@ApiResponses({
			@ApiResponse(code = 201, message = "New customer was created",
					response = CustomerDto.class),
			@ApiResponse(code = 500, message = "Something wen wrong")
	})
	@PostMapping
	public ResponseEntity<CustomerDto> save(@RequestBody CustomerDto customer) {
		return ResponseEntity.ok(service.save(customer));
	}

	//todo show path/without path
	@GetMapping(path = "/byId")
	public ResponseEntity<CustomerDto> get(@RequestParam Long id) { //todo show RequestParam/PathVariable
		return ResponseEntity.ok(service.get(id));
	}
}
