package one.dio.experts.productcatalog.repository;

import one.dio.experts.productcatalog.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface ProductRepository extends ElasticsearchRepository<Product, Integer> {
}
