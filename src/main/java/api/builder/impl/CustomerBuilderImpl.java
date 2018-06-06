package api.builder.impl;

import api.builder.CustomerBuilder;
import api.domain.Customer;

import java.time.LocalDate;

public class CustomerBuilderImpl implements CustomerBuilder {

    private Customer customer;

    public CustomerBuilderImpl() {
        customer = new Customer();
    }

    @Override
    public Customer build() {
        return customer;
    }

    @Override
    public CustomerBuilder setId(Long id) {
        customer.setId(id);
        return this;
    }

    @Override
    public CustomerBuilder setName(String name) {
        customer.setName(name);
        return this;
    }

    @Override
    public CustomerBuilder setAge(Long age) {
        customer.setAge(age);
        return this;
    }

    @Override
    public CustomerBuilder setChangeDate() {
        customer.setChangeDate(LocalDate.now());
        return this;
    }
}
