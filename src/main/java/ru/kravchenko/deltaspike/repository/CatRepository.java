package ru.kravchenko.deltaspike.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.jpa.api.transaction.Transactional;
import ru.kravchenko.deltaspike.entity.Cat;

import java.util.List;

/**
 * @author Roman Kravchenko
 */

@Repository
@Transactional
public interface CatRepository extends FullEntityRepository<Cat, String> {

    Cat findByName(String name);

    void removeById(String id);

    List<String> findAllId();

}
