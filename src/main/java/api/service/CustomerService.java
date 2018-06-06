package api.service;

import api.request.CustomerRequest;
import api.response.CustomerResponse;

import java.util.List;

public interface CustomerService {

    CustomerResponse save(CustomerRequest customerRequest);

    CustomerResponse update(CustomerRequest customerRequest);

    CustomerResponse findOne(Long id);

    List<CustomerResponse> findAll();
}
