package cn.credit.checker.CreditChecker;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cn.credit.checker.CreditChecker.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
