package ru.xpendence.modelmapperdemo;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.xpendence.modelmapperdemo.attributes.OrderStatus;
import ru.xpendence.modelmapperdemo.entity.Customer;
import ru.xpendence.modelmapperdemo.entity.Order;
import ru.xpendence.modelmapperdemo.repository.CustomerRepository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Collections;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

@SpringBootApplication
public class ModelmapperDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModelmapperDemoApplication.class, args);
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
    private void populateDb() {
        for (int i = 0; i < 100; i++) {
            Customer c = new Customer("Customer" + i, null);
            Order o = new Order("Order" + i, c, OrderStatus.TODO);
            c.setOrders(Collections.singletonList(o));
            repository.save(c);
        }

    }

}

