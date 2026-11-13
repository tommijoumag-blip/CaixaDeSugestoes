package br.com.etecalbertoferes.CaixaDeSugestoes.infrastructure.persistence;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.com.etecalbertoferes.CaixaDeSugestoes.domain.*;
@Repository
@Transactional(readOnly = true)
public class AdminAccountPersistenceAdapter implements AdminAccountRepository {
    private final AdminAccountJpaRepository repository;
    public AdminAccountPersistenceAdapter(AdminAccountJpaRepository repository) {
        this.repository = repository;
    }
    public Optional<AdminAccount> findByUsername(String username) {
        return repository.findByUsername(username).map(e -> new AdminAccount(e.id, e.username, e.passwordHash, e.active));
    }
}