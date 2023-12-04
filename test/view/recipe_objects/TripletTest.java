package view.recipe_objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TripletTest {
    private final String NAME = new String("triplet name");
    private final String LINK = new String("triple.link.com");
    private final String[] STR_LST = new String[]{"A", "B", "C"};
    private Triplet triplet;

    @BeforeEach
    public void setUp() {
        this.triplet = new Triplet(NAME, LINK, STR_LST);
    }

    @Test
    public void getNameTest() {
        assertEquals(triplet.getName(), NAME);
    }

    @Test
    public void getLinkTest() {
        assertEquals(triplet.getLink(), LINK);
    }

    @Test
    public void getListTest() {
        assertEquals(triplet.getList(), STR_LST);
    }
}