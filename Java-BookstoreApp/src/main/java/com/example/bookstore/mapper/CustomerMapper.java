package com.example.bookstore.mapper;

import com.example.bookstore.dto.CustomerDto;
import com.example.bookstore.entity.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public CustomerMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CustomerDto toDto(Customer customer) {
        return modelMapper.map(customer, CustomerDto.class);
    }

    public Customer toEntity(CustomerDto customerDto) {
        return modelMapper.map(customerDto, Customer.class);
    }
}
