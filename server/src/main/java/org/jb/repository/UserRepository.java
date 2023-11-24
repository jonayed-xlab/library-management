package org.jb.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.jb.entity.User;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
}
