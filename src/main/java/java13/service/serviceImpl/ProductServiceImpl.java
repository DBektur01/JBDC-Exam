package java13.service.serviceImpl;

import java13.dao.ProductDao;
import java13.dao.daoImpl.ProductDaoImpl;
import java13.entity.Product;
import java13.service.ProductService;

import java.util.List;

/**
 * Author: Bektur Duyshenbek uulu
 */
public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao = new ProductDaoImpl();
    @Override
    public String addProduct(Product product) {
        return productDao.addProduct(product);
    }

    @Override
    public Product getProductById(Long id) {
        return productDao.getProductById(id);
    }

    @Override
    public String updateProductById(Long productId, Product newProduct) {
        return productDao.updateProductById(productId,newProduct);
    }

    @Override
    public String deleteProductById(Long id) {
        return productDao.deleteProductById(id);
    }

    @Override
    public List<Product> getLowRatingProducts() {
        return productDao.getLowRatingProducts();
    }

    @Override
    public List<Product> getProductsWithPrice(int minPrice, int maxPrice) {
        return productDao.getProductsWithPrice(minPrice,maxPrice);
    }
}
