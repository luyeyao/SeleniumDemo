package testcase;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.ContactPage;
import page.DepartPage;
import page.MainPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDepart {
    static ContactPage contact;
    static DepartPage depart;

    @BeforeAll
    static void bf(){
        contact = new ContactPage();
        depart = contact.toDepart();
    }

    @Test
    void testAddDepart(){
        String departname = depart.addDepart("部门5").getClass().getName();
        assertEquals(departname,"部门5");
    }

    @Test
    void testDelete(){
        depart.search("部门2").delete();
    }
}
