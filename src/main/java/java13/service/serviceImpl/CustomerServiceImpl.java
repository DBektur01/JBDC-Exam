package java13.service.serviceImpl;

import java13.config.DatabaseConfig;
import java13.dao.CustomerDao;
import java13.dao.daoImpl.CustomerDaoImpl;
import java13.entity.Customer;
import java13.service.CustomerService;

import java.util.List;

/**
 * Author: Bektur Duyshenbek uulu
 */
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao = new CustomerDaoImpl();
    @Override
    public String addCustomer(Customer customer) {
        return customerDao.addCustomer(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerDao.getCustomerById(id);
    }

    @Override
    public String updateCustomerById(Long id, Customer newCustomer) {
        return customerDao.updateCustomerById(id,newCustomer);
    }

    @Override
    public String deleteCustomerById(Long id) {
        return customerDao.deleteCustomerById(id);
    }

    @Override
    public List<Customer> sortCustomerByAge() {
        return customerDao.sortCustomerByAge();
    }

    @Override
    public Customer searchCustomerByName(String name) {
        return customerDao.searchCustomerByName(name);
    }
}
