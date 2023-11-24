package org.jb.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.jb.entity.Menu;
@ApplicationScoped
public class MenuRepository implements PanacheRepository<Menu> {
}
