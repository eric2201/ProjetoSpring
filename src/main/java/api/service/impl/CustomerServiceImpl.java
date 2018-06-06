package api.service.impl;

import api.builder.CustomerBuilder;
import api.builder.impl.CustomerBuilderImpl;
import api.domain.Customer;
import api.repository.CustomerRepository;
import api.request.CustomerRequest;
import api.response.CustomerResponse;
import api.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    private final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Override
    public CustomerResponse save(CustomerRequest customerRequest) {
        log.info("Request to save customer : {}", customerRequest);
        CustomerBuilder builder = new CustomerBuilderImpl();
        Customer customer = builder.setAge(customerRequest.getAge())
                .setName(customerRequest.getName())
                .setChangeDate()
                .build();


        return buildCustomerResponse(customerRepository.save(customer));
    }

    @Override
    public CustomerResponse update(CustomerRequest customerRequest) {
        log.info("Request to update customer : {}", customerRequest);
        if (customerRequest.getId() == null) {
            throw new EntityNotFoundException("Id não pode ser nulo");
        }
        Customer find = customerRepository.findById(customerRequest.getId()).orElseThrow(EntityNotFoundException::new);
        CustomerBuilder builder = new CustomerBuilderImpl();
        find = builder.setId(customerRequest.getId())
                .setAge(customerRequest.getAge())
                .setName(customerRequest.getName())
                .setChangeDate()
                .build();
        return buildCustomerResponse(customerRepository.save(find));
    }

    @Override
    public CustomerResponse findOne(Long id) {
        log.info("Request to find customer : {}", id);
        return buildCustomerResponse(customerRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public List<CustomerResponse> findAll() {
        log.info("Request to find all customer");
        return customerRepository.findAll().stream().map(c -> buildCustomerResponse(c)).collect(Collectors.toList());
    }

    private CustomerResponse buildCustomerResponse(Customer customer) {
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setId(customer.getId());
        customerResponse.setAge(customer.getAge());
        customerResponse.setName(customer.getName());
        customerResponse.setChangeDate(customer.getChangeDate());
        return customerResponse;
    }
}
