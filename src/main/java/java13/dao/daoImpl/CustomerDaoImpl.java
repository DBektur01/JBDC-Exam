package java13.dao.daoImpl;

import java13.config.DatabaseConfig;
import java13.dao.CustomerDao;
import java13.entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Bektur Duyshenbek uulu
 */
public class CustomerDaoImpl implements CustomerDao {

    private final Connection connection = DatabaseConfig.getConnection();
    @Override
    public String addCustomer(Customer customer) {
        String sql = """
                create table customers(
                id serial primary key,
                first_name varchar,
                last_name varchar,
                phone_number varchar);
                """;
        String query = """
                insert into customers(first_name, last_name, phone_number)
                values(?, ?, ?);
                """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getPhoneNumber());
            preparedStatement.executeUpdate();
            return "Customer added successfully";
        }catch (SQLException e){
            return e.getMessage();
        }
    }

    @Override
    public Customer getCustomerById(Long id) {
        Customer customer = new Customer();

        String sql = "select * from customers where id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                throw new RuntimeException("Customer with id " + id + "not found");
            }
            customer.setId(resultSet.getLong(1));
            customer.setFirstName(resultSet.getString(2));
            customer.setLastName(resultSet.getString(3));
            customer.setPhoneNumber(resultSet.getString(4));
            return customer;
        }catch (SQLException e){
           throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public String updateCustomerById(Long id, Customer newCustomer) {
        String sql = "update customers set firts_name = ?,last_name = ?, phone_number = ? where id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, newCustomer.getFirstName());
            preparedStatement.setString(2, newCustomer.getLastName());
            preparedStatement.setString(3, newCustomer.getPhoneNumber());
            preparedStatement.executeUpdate();
            return "Customer with id "+id+" Successfully updated!";
        }catch (SQLException e){
            return e.getMessage();
        }
    }

    @Override
    public String deleteCustomerById(Long id) {
        String sql = "delete from customer where id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
            return "Customer with id" +id+" Successfully deleted!";
        }catch (SQLException e){
            return e.getMessage();
        }
    }

    @Override
    public List<Customer> sortCustomerByAge() {
        List<Customer> customers = new ArrayList<>();
        String sql = """
                select * from customers order by firts_name asc
                """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                customers.add(new Customer(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)));
            }
            return customers;
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Customer searchCustomerByName(String name) {
        Customer customer = new Customer();
        String sql = "select * from customers where first_name = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            return customer;
        }catch (SQLException e ){
            throw new RuntimeException(e.getMessage());
        }
    }
}
