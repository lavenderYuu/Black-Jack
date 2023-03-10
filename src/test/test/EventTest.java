package test;

import model.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

//tests for the Event class cite from the AlarmSystem
public class EventTest {
    private Event e;
    private Date d;

    @BeforeEach
    public void runBefore() {
        e = new Event("Card set is cleared.");
        d = Calendar.getInstance().getTime();
    }

    @Test
    public void testGetDate() {
        e = new Event("date check");
        d = Calendar.getInstance().getTime();
        assertEquals(d, e.getDate());
    }

    @Test
    public void testEvent() {
        assertEquals("Card set is cleared.", e.getDescription());
    }

    @Test
    public void testToString() {
        assertEquals(d.toString() + "\n" + "Card set is cleared.", e.toString());
    }
}

