package br.com.etecalbertoferes.CaixaDeSugestoes;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class AdminSeedIntegrationTest extends ContextTest {
    @Test void migrationCreatesActiveAdministratorWithBcryptPassword() {
        var admin = accounts.findByUsername("admin").orElseThrow();
        assertThat(admin.active()).isTrue();
        assertThat(admin.passwordHash()).isNotEqualTo("Admin@123456");
        assertThat(passwordEncoder.matches("Admin@123456", admin.passwordHash())).isTrue();
    }
}