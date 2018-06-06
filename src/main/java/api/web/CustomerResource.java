package api.web;

import api.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import api.repository.CustomerRepository;
import api.request.CustomerRequest;
import api.response.CustomerResponse;
import api.service.CustomerService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class CustomerResource {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;

    @PostMapping("/customer")
    public ResponseEntity<CustomerResponse> createCustomer (@Valid @RequestBody CustomerRequest customerRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customerRequest));
    }


    @PutMapping("/customer")
    public ResponseEntity<CustomerResponse> updateCustomer(@Valid @RequestBody CustomerRequest customerRequest){
        return ResponseEntity.status(HttpStatus.OK).body((customerService.update(customerRequest)));
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerResponse> findCustomer(@Valid @PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.findOne(id));
    }

    @GetMapping("/customer")
    public ResponseEntity<List<CustomerResponse>>  findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.findAll());
    }
}
