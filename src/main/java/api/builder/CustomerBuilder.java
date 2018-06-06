package api.builder;

import api.domain.Customer;

public interface CustomerBuilder {

    Customer build();

    CustomerBuilder setId(Long id);

    CustomerBuilder setName(String name);

    CustomerBuilder setAge(Long age);

    CustomerBuilder setChangeDate();
}
