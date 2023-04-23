package com.benjamintanone.springdatajpademojava.aop;

import com.benjamintanone.springdatajpademojava.domain.Campaign;
import com.benjamintanone.springdatajpademojava.domain.Customer;
import com.benjamintanone.springdatajpademojava.repositories.CustomerRepository;
import com.benjamintanone.springdatajpademojava.specifications.CustomerSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@Component
public class AfterCampaignAddedComponent extends AbstractRepositoryEventListener<Campaign> {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @Transactional(readOnly = true)
    public void onAfterCreate(Campaign entity) {
        super.onAfterCreate(entity);
        Specification<Customer> specification = CustomerSpecification.hasName(null);
        Stream<Customer> stream = customerRepository.stream(specification, Customer.class);
        stream.forEach(System.out::println);
    }
}
