package org.jb.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.jb.entity.Login;
import org.jb.entity.Menu;

@ApplicationScoped
public class LoginRepository implements PanacheRepository<Login> {
    @Transactional
    public Login saveLogin(Login login) {
        persist(login);
        return login;
    }

    @Transactional
    public Login updateLogin(Long loginId, Login updatedLogin) {
        Login login = findById(loginId);
        if (login != null) {
            login.setLogoutDateTime(updatedLogin.getLogoutDateTime());
            return login;
        }
        return null;
    }
}
