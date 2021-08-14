package one.dio.experts.productcatalog.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
//@EnableElasticsearchRepositories(basePackages = "one.dio.experts.productcatalog.repository")
//@ComponentScan(basePackages = {"one.dio.experts.productcatalog"})
public class ElasticSearchConfig extends
        AbstractElasticsearchConfiguration {
    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {

        final ClientConfiguration clientConfiguration =
                ClientConfiguration
                        .builder()
                        .connectedTo("localhost:9200", "localhost:9300")
                        .build();

        return RestClients.create(clientConfiguration).rest();
    }
}
//    @Bean
//    public ElasticsearchOperations elasticsearchTemplate() {
//        return new ElasticsearchRestTemplate(elasticsearchClient());
//    }

    //    @Bean
//    @Override
//    public EntityMapper entityMapper() {
//        ElasticsearchEntityMapper entityMapper = new ElasticsearchEntityMapper(elasticsearchMappingContext(),
//                new DefaultConversionService());
//        entityMapper.setConversions(elasticsearchCustomConversions());
//
//        return entityMapper;
//    }
//@Bean
//public ElasticsearchOperations elasticsearchTemplate() {
//    return new ElasticsearchRestTemplate(elasticsearchClient());
//}
//}
