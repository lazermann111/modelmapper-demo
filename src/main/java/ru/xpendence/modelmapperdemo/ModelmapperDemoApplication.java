package ru.xpendence.modelmapperdemo;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

import java.util.Collections;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import ru.xpendence.modelmapperdemo.attributes.OrderStatus;
import ru.xpendence.modelmapperdemo.entity.Customer;
import ru.xpendence.modelmapperdemo.entity.Order;
import ru.xpendence.modelmapperdemo.repository.CustomerRepository;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ModelmapperDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModelmapperDemoApplication.class, args);
    }
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SPRING_WEB).select()
                .apis(RequestHandlerSelectors.basePackage("ru.xpendence.modelmapperdemo"))
                .build();
    }
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true)
                .setFieldAccessLevel(PRIVATE);
        return mapper;
    }


    @Resource
	CustomerRepository repository;

    @PostConstruct
	private void populateDb()
	{
        for (int i = 0; i < 100; i++) {
            Customer c = new Customer("Customer"+i, null);
            Order o = new Order("Order"+i, c, OrderStatus.TODO);
            c.setOrders(Collections.singletonList(o));
            repository.save(c);
        }

	}

}

