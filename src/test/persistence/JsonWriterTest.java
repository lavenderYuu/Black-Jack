package persistence;

import model.Player;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

//Json Writer Test
public class JsonWriterTest {

    @Test
    void testWriterInvalidFile() {
        Player play = new Player();
        JsonWriter writer = new JsonWriter("./data/\0invalid");
        try {
            writer.open();
            fail("IOException was expected");
        } catch (FileNotFoundException e) {
            //pass
        }
    }

    @Test
    void testWriterGeneralPlayer() {
        try {
            Player play = new Player();
            int m = play.getMoney();
            play.placeBet(m);
            play.moneyAddMins(2);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralPlayer.json");
            writer.open();
            writer.write(play);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralPlayer.json");
            play = reader.read();
            assertEquals(3 * m, play.getMoney());

        } catch (IOException e) {
            fail("Exception should not been thrown");
        }
    }
}
