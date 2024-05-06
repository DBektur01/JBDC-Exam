package java13.dao.daoImpl;

import java13.config.DatabaseConfig;
import java13.dao.ProductDao;
import java13.entity.Customer;
import java13.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Bektur Duyshenbek uulu
 */
public class ProductDaoImpl implements ProductDao {
    private Connection connection = DatabaseConfig.getConnection();
    @Override
    public String addProduct(Product product) {
        String sql = """
                create table products(
                id serial primary key,
                name varchar(20),
                rating int,
                price int);
                """;
        try(PreparedStatement preparedStatement =connection.prepareStatement(sql)){
            preparedStatement.executeUpdate();
            return "Successfully added product";
        }catch (SQLException e) {
            return e.getMessage();
        }
    }

    @Override
    public Product getProductById(Long id) {
        Product product = null;
        String sql = "select * from products where id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                throw new RuntimeException("Product with id " + id + "not found");
            }
            product.setId(resultSet.getLong(1));
            product.setName(resultSet.getString(2));
            product.setRating(resultSet.getInt(3));
            product.setPrice(resultSet.getInt(4));
            preparedStatement.executeUpdate();
            return product;
        }catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public String updateProductById(Long productId, Product newProduct) {
        String sql = "update customers set name = ?,rating = ?, price = ? where id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,newProduct.getName());
            preparedStatement.setInt(2,newProduct.getRating());
            preparedStatement.setInt(3,newProduct.getPrice());
            preparedStatement.executeUpdate();
            return "Customer with id "+productId+" Successfully updated!";
        }catch (SQLException e){
            return e.getMessage();
        }
    }

    @Override
    public String deleteProductById(Long id) {
        String sql = "delete from products where id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
            return "Product with id" +id+" Successfully deleted!";
        }catch (SQLException e){
            return e.getMessage();
        }
    }

    @Override
    public List<Product> getLowRatingProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "select * from products order by rating desc";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
             ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getLong(1));
                product.setName(resultSet.getString(2));
                product.setRating(resultSet.getInt(3));
                product.setPrice(resultSet.getInt(4));
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Product> getProductsWithPrice(int minPrice, int maxPrice) {
        List<Product> products = new ArrayList<>();
        String sql = "select * from products where price >= ? and price <= ?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setDouble(1, minPrice);
            statement.setDouble(2, maxPrice);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getLong(1));
                product.setName(resultSet.getString(2));
                product.setRating(resultSet.getInt(3));
                product.setPrice(resultSet.getInt(4));
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
}
