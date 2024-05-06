package java13.service;

import java13.entity.Product;

import java.util.List;

/**
 * Author: Bektur Duyshenbek uulu
 */
public interface ProductService {
    String addProduct(Product product);
    Product getProductById(Long id);
    String updateProductById(Long productId,Product newProduct);
    String deleteProductById(Long id);

    /**
     * Unique methods*/
    List<Product> getLowRatingProducts();
    List<Product> getProductsWithPrice(int minPrice,int maxPrice);
}
