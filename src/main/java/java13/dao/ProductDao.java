package java13.dao;

import java13.entity.Product;

import java.util.List;

/**
 * Author: Bektur Duyshenbek uulu
 */
public interface ProductDao {

    String addProduct(Product product);
    Product getProductById(Long id);
    String updateProductById(Long productId,Product newProduct);
    String deleteProductById(Long id);

    /**
     * Unique methods*/
    List<Product> getLowRatingProducts();
    List<Product> getProductsWithPrice(int minPrice,int maxPrice);
}
