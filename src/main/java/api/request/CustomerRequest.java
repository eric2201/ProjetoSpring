package api.request;

import javax.validation.constraints.NotNull;

public class CustomerRequest {

    private Long id;
    @NotNull(message = "Nome não pode ser null")
    private String name;
    @NotNull(message = "Idade não pode ser null")
    private Long age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
