package br.com.etecalbertoferes.CaixaDeSugestoes.domain;

import java.util.Optional;
public interface AdminAccountRepository {
    Optional<AdminAccount> findByUsername(String username);
}