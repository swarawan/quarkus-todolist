package id.swarawan.database.repository;

import id.swarawan.database.entity.Todo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class TodoRepository implements PanacheRepository<Todo> {

    public Optional<Todo> findByTitleOptional(String title) {
        return find("title", title).singleResultOptional();
    }
}
