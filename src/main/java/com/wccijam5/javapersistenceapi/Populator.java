package com.wccijam5.javapersistenceapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Populator implements CommandLineRunner {

    @Resource
    private EmployeeRepository employeeRepo;

    @Resource
    private AddressRepository addressRepo;


    @Override
    public void run(String... args) throws Exception {
        Address address = new Address("apple", "cleveland", "ohio", "cuyahoga");
        addressRepo.save(address);
        Employee employee = new Employee("tyler","koenig", address);
        employeeRepo.save(employee);


    }
}
