package jintran.cpm.service;

import jintran.cpm.model.Customer;
import jintran.cpm.model.Province;

public interface ICustomerService extends IGenerateService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
}
