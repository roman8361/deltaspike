package ru.kravchenko.deltaspike;

import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.kravchenko.deltaspike.entity.Cat;
import ru.kravchenko.deltaspike.repository.CatRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

@RunWith(CdiTestRunner.class)
public class CatTest {

    @Inject
    private CatRepository catRepository;

    @Test
    public void test() {
        catRepository.save(new Cat());
        final List<Cat> cats = catRepository.findAll();
        System.out.println(cats);
    }

    @Test
    public void findByName() {
       final Cat cat = catRepository.findByName("Keller");
        System.out.println("ID CAT: " + cat.getId() + " NAME CAT: " + cat.getName());
    }

    @Test
    public void remove() {
        final Cat cat = catRepository.findBy("4f4f032a-aa7f-4f17-8c12-5d905084079c");
        catRepository.remove(cat);
    }

    @Test
    public void clear() {
        catRepository.clear();
    }

}
