package java13.service;

import java13.entity.Customer;

import java.util.List;

/**
 * Author: Bektur Duyshenbek uulu
 */
public interface CustomerService {
    String addCustomer(Customer customer);
    Customer getCustomerById(Long id);
    String updateCustomerById(Long id,Customer newCustomer);
    String deleteCustomerById(Long id);

    //Unique methods
    List<Customer> sortCustomerByAge();
    Customer searchCustomerByName(String name);

}
