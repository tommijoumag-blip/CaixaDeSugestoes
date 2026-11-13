package br.com.etecalbertoferes.CaixaDeSugestoes;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import static org.assertj.core.api.Assertions.assertThat;

@org.springframework.test.context.ActiveProfiles("test")
@org.springframework.test.annotation.DirtiesContext(classMode = org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_CLASS)
@SpringBootTest
class ContextTest {
    static final String ADMIN_PASSWORD = "Test-Admin-2026!";
    @Autowired JdbcTemplate jdbc;
    @Autowired br.com.etecalbertoferes.CaixaDeSugestoes.domain.AdminAccountRepository accounts;
    @Autowired org.springframework.security.crypto.password.PasswordEncoder passwordEncoder;
    @org.junit.jupiter.api.BeforeEach void provisionTestAdmin() {
        if (accounts.findByUsername("test-admin").isEmpty())
            jdbc.update("insert into administrators (username, password_hash) values (?, ?)",
                    "test-admin", passwordEncoder.encode(ADMIN_PASSWORD));
    }
    @Test void migrationsAndSeeds() {
        assertThat(jdbc.queryForObject("select count(*) from courses", Long.class)).isEqualTo(4L);
        assertThat(jdbc.queryForObject("select count(*) from categories", Long.class)).isEqualTo(3L);
        assertThat(jdbc.queryForObject("select count(*) from suggestions", Long.class)).isZero();
    }
}