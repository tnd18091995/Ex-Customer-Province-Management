package jintran.cpm.repository;

import jintran.cpm.model.Customer;
import jintran.cpm.model.Province;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerRepository extends CrudRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);
}
