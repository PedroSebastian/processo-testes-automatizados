import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.util.Random;
import static org.junit.Assert.assertTrue;

public class RandomizadorTest {
    @PrepareForTest({Randomizador.class})

    @Test
    public void doisRandomoicosDevemGerarNumerosDiferentesTest() throws Exception {
        Random expectativaUm = Randomizador.getRandom();
        Random expectativaDois = Randomizador.getRandom();
        assertTrue(expectativaDois != expectativaUm);
    }
}
