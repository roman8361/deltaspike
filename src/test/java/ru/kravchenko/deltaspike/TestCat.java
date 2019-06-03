package ru.kravchenko.deltaspike;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.kravchenko.deltaspike.dao.CatDAO;
import ru.kravchenko.deltaspike.entity.Cat;

import javax.inject.Inject;
import java.util.List;
import java.util.logging.LogRecord;


/**
 * @author Roman Kravchenko
 */

@RunWith(CdiTestRunner.class)
public class TestCat {

    private Lorem lorem = new LoremIpsum();

    @Inject
    private CatDAO catDAO;

    @Test
    public void addAnyCat() {
        for (int i = 0; i < 10; i++) {
            addOneCat();
        }
    }

    public void addOneCat() {
        Cat cat = new Cat();
        cat.setName(lorem.getLastName());
        catDAO.persist(cat);
    }

    @Test
    public void findAll() {
        final List<Cat> list = catDAO.findAll();
        System.out.println(list);
    }

    @Test
    public void removeById() {
        catDAO.removeById("5a3bc6c4-1d6e-4045-8222-9e6ba61f0c52");
    }


    @Test
    public void testCRUD() {
        final List<Cat> cats = catDAO.findAll();
        final Cat cat = new Cat();
        cat.setName(lorem.getFirstName());
//        project.setDateBegin(new Date());
//        project.setDateEnd(new Date());
//        project.setDescription(lorem.getWords(4));
        catDAO.persist(cat);
        final Cat catInsert = catDAO.findById(cat.getId());
        Assert.assertNotNull(catInsert);
        catDAO.removeById(cat.getId());
        Assert.assertNull(catDAO.findById(cat.getId()));
    }

}
