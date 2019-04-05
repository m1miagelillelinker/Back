package myapp.repository;

import myapp.model.Badge;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadgeRepository extends CrudRepository<Badge,Integer> {
}
