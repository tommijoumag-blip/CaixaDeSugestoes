package br.com.etecalbertoferes.CaixaDeSugestoes;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import static org.assertj.core.api.Assertions.assertThat;

@org.springframework.test.context.ActiveProfiles("test")
@SpringBootTest
class ContextTest {
    @Autowired JdbcTemplate jdbc;
    @Test void migrationsAndSeeds() {
        assertThat(jdbc.queryForObject("select count(*) from courses", Long.class)).isEqualTo(4L);
        assertThat(jdbc.queryForObject("select count(*) from categories", Long.class)).isEqualTo(3L);
        assertThat(jdbc.queryForObject("select count(*) from suggestions", Long.class)).isZero();
    }
}