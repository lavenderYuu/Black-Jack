package persistence;

import model.Player;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest {

    @Test
    void testReaderNonExistenceFile() {
        JsonReader reader = new JsonReader("./data/nope");
        try {
            Player play = reader.read();
            fail("IOExecption expected");
        } catch (IOException e) {
        }
    }

    @Test
    void testReaderGeneralPlayer() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralPlayer.json");
        try {
            Player play = reader.read();
            assertEquals(1000, play.getMoney());
        } catch (IOException e) {
            fail("Cannot read the file");
        }
    }


}
