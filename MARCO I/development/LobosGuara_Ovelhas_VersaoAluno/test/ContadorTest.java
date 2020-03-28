import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContadorTest {
    private Contador contador;

    @Before
    public void init() {
        this.contador = new Contador("contador");
    }

    @Test
    public void verificaSeContadorInicializaEmZeroTest() {
        int expected = 0;
        int actual = contador.getContador();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void verificaNomeDeContadorTest() {
        String valorEsperado = "contador";
        String valorObtido = contador.getNome();
        Assert.assertEquals(valorEsperado, valorObtido);
    }

    @Test
    public void verificaSeOContadorIncrementaTest() {
        int valorEsperado = 100;

        for (int i = 0; i < 100; i++) {
            contador.incrementa();
        }

        int valorObtido = contador.getContador();
        Assert.assertEquals(valorObtido, valorEsperado);
    }

    @Test
    public void verificaSeContadorEResetado() {
        int valorEsperado = 0;
        int valorObtido = contador.getContador();
        for (int i = 0; i <= 100; i++) {
            contador.incrementa();
        }
        contador.reseta();
        Assert.assertEquals(valorEsperado, valorObtido);
    }

    @Test
    public void contagemInicialDeveSerZero() {
        int resultado = this.contador.getContador();
        int expectativa = 0;

        Assert.assertEquals(expectativa, resultado);
    }
}
