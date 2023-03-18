package com.example.mysql;

import com.example.mysql.model.Motorcycle;
import com.example.mysql.repositories.MotorcycleRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = {"com.example.mysql.db"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SpringBootJpaTestSlice {

    @Autowired
    MotorcycleRepository motorcycleRepository;

    @Commit
    @Order(1)
    @Test
    void testJpaTestSplice() {
        long countBefore = motorcycleRepository.count();
        assertThat(countBefore).isEqualTo(2);

        motorcycleRepository.save(new Motorcycle("1","2","3"));

        long countAfter = motorcycleRepository.count();

        assertThat(countBefore).isLessThan(countAfter);
    }

    @Order(2)
    @Test
    void testJpaTestSpliceTransaction() {
        long countBefore = motorcycleRepository.count();
        assertThat(countBefore).isEqualTo(3);

    }
}
