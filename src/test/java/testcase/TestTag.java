package testcase;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.ContactPage;
import page.TagPage;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestTag {
    static ContactPage contactPage;
    static TagPage tagPage;
    @BeforeAll
    static void bf(){
        contactPage = new ContactPage();
        tagPage = contactPage.toTag();
    }

    @Test
    void testAddTag(){
        String tagname =  tagPage.addTag("UI").getClass().getName();
        assertEquals(tagname,"UI");
    }

    @Test
    void testdelete(){
        tagPage.search("UI").delete();
    }
}
