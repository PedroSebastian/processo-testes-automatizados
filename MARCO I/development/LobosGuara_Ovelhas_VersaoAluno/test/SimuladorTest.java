import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class SimuladorTest {

    @Test
    public void verificaSePovoaOCampoCorretamente() throws NoSuchMethodException, NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        Simulador simulador = new Simulador();
        Method povoa = simulador.getClass().getDeclaredMethod("povoa");
        povoa.setAccessible(true);

        Field animais = simulador.getClass().getDeclaredField("animais");
        animais.setAccessible(true);

        povoa.invoke(simulador);

        List resultado = (List) animais.get(simulador);

        Assert.assertTrue(resultado.size() > 0);
    }

    @Test
    public void deveHaverLobosNoCampo() throws NoSuchMethodException, NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        Simulador simulador = new Simulador();
        Method povoa = simulador.getClass().getDeclaredMethod("povoa");
        povoa.setAccessible(true);

        Field animais = simulador.getClass().getDeclaredField("animais");
        animais.setAccessible(true);

        povoa.invoke(simulador);

        List<Animal> resultado = (List) animais.get(simulador);

        int numeroLobos = 0;

        for (Animal animal : resultado) {
            if (animal instanceof LoboGuara) {
                numeroLobos += 1;
            }
        }

        Assert.assertTrue(numeroLobos > 0);
        Assert.assertTrue(numeroLobos > 1);
    }

    @Test
    public void deveHaverOvelhasNoCampo() throws NoSuchMethodException, NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        Simulador simulador = new Simulador();
        Method povoa = simulador.getClass().getDeclaredMethod("povoa");
        povoa.setAccessible(true);

        Field animais = simulador.getClass().getDeclaredField("animais");
        animais.setAccessible(true);

        povoa.invoke(simulador);

        List<Animal> resultado = (List) animais.get(simulador);

        int numeroOvelhas = 0;

        for (Animal animal : resultado) {
            if (animal instanceof Ovelha) {
                numeroOvelhas += 1;
            }
        }

        Assert.assertTrue(numeroOvelhas > 0);
        Assert.assertTrue(numeroOvelhas > 1);
    }

    @Test
    public void numeroInicialDeOvelhasDeveSerMaiorQueODeLobos() throws NoSuchMethodException,
            NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        Simulador simulador = new Simulador();
        Method povoa = simulador.getClass().getDeclaredMethod("povoa");
        povoa.setAccessible(true);

        Field animais = simulador.getClass().getDeclaredField("animais");
        animais.setAccessible(true);

        povoa.invoke(simulador);

        List<Animal> resultado = (List) animais.get(simulador);

        int numeroOvelhas = 0;
        int numeroLobos = 0;

        for (Animal animal : resultado) {
            if (animal instanceof Ovelha) {
                numeroOvelhas += 1;
            } else if (animal instanceof LoboGuara) {
                numeroLobos += 1;
            }
        }

        Assert.assertTrue(numeroOvelhas > numeroLobos);
    }

    @Test
    public void deveIncrementarCorretamenteAEtapaDaSimulacao() throws
            NoSuchFieldException, IllegalAccessException {
        Simulador simulador = new Simulador();
        Field etapa = simulador.getClass().getDeclaredField("etapa");
        etapa.setAccessible(true);

        simulador.simulacaoUmaEtapa();

        int expectativa = 1;
        int resultado = etapa.getInt(simulador);

        Assert.assertEquals(expectativa, resultado);
    }

    @Test
    public void etapaDaSimulacaoDeveIniciarEmZero() throws NoSuchFieldException, IllegalAccessException {
        Simulador simulador = new Simulador();
        Field etapa = simulador.getClass().getDeclaredField("etapa");
        etapa.setAccessible(true);

        int expectativa = 0;
        int resultado = etapa.getInt(simulador);

        Assert.assertEquals(expectativa, resultado);
    }

    @Test
    public void deveSettarValorPadraoDaAreaAoPassarValoresNegativosNaSimulacao() throws NoSuchFieldException, IllegalAccessException {
        Simulador simulador = new Simulador(-1, -1);

        Field campo = simulador.getClass().getDeclaredField("campo");
        campo.setAccessible(true);

        int expectativa = 50;
        Campo campoResultado = (Campo) campo.get(simulador);

        Assert.assertEquals(expectativa, campoResultado.getLargura());
        Assert.assertEquals(expectativa, campoResultado.getProfundidade());
    }

    @Test
    public void deveSettarValorPadraoDaAreaAoPassarValoresIguaisAZeroNaSimulacao() throws NoSuchFieldException, IllegalAccessException {
        Simulador simulador = new Simulador(0, 0);

        Field campo = simulador.getClass().getDeclaredField("campo");
        campo.setAccessible(true);

        int expectativa = 50;
        Campo campoResultado = (Campo) campo.get(simulador);

        Assert.assertEquals(expectativa, campoResultado.getLargura());
        Assert.assertEquals(expectativa, campoResultado.getProfundidade());
    }

    @Test
    public void deveExecutarCincoEtapasDaSimulacaoCorretamente() throws NoSuchFieldException, IllegalAccessException {
        Simulador simulador = new Simulador();

        Field etapa = simulador.getClass().getDeclaredField("etapa");
        etapa.setAccessible(true);

        simulador.simulacao(5);

        Assert.assertTrue(etapa.getInt(simulador) == 5);
    }

}
