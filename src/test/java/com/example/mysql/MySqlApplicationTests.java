package com.example.mysql;

import com.example.mysql.repositories.MotorcycleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = {"com.example.mysql.db"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MySqlApplicationTests {

    @Autowired
    MotorcycleRepository motorcycleRepository;

    @Test
    void testMySQL() {
        long countBefore = motorcycleRepository.count();
        assertThat(countBefore).isEqualTo(2);

    }

}


