import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CampoEstatisticaTest {

    @Test
    public void deveIncrementaContadorDeOvelhaTest() {
        Campo campo = new Campo(2, 2);
        CampoEstatistica campoEstatistica = new CampoEstatistica();
        Localizacao localizacao = new Localizacao(0, 0);
        Ovelha ovelha = new Ovelha(true, campo, localizacao);
        campoEstatistica.incrementaContador(ovelha.getClass());
        campoEstatistica.incrementaContador(ovelha.getClass());
        campoEstatistica.incrementaContador(ovelha.getClass());
        campoEstatistica.incrementaContador(ovelha.getClass());
        Assert.assertEquals("Ovelha: 4 ", campoEstatistica.capturaDetalhesPolulacao(campo));
    }

    @Test
    public void deveRedefinirOContadorParaUmTest() {
        CampoEstatistica campoEstatistica = new CampoEstatistica();
        Campo campo = new Campo(2, 2);
        Localizacao localizacao = new Localizacao(0, 0);
        Ovelha ovelha = new Ovelha(true, campo, localizacao);
        campoEstatistica.incrementaContador(ovelha.getClass());
        campoEstatistica.incrementaContador(ovelha.getClass());
        campoEstatistica.incrementaContador(ovelha.getClass());
        campoEstatistica.incrementaContador(ovelha.getClass());
        campoEstatistica.redefine();
        Assert.assertEquals("Ovelha: 1 ", campoEstatistica.capturaDetalhesPolulacao(campo));
    }

    @Test
    public void oNumeroDeContadoresDeveRetornarFalsoTest() {
        CampoEstatistica campoEstatistica = new CampoEstatistica();
        Campo campo = new Campo(2, 2);
        Ovelha ovelha = new Ovelha(true, campo, new Localizacao(0, 0));
        Ovelha ovelha1 = new Ovelha(true, campo, new Localizacao(0, 1));
        Ovelha ovelha2 = new Ovelha(true, campo, new Localizacao(1, 0));
        Ovelha ovelha3 = new Ovelha(true, campo, new Localizacao(1, 1));
        Assert.assertFalse(campoEstatistica.ehViavel(campo));
    }

    @Test
    public void contadorDeveRetornarFalsoAoRedefinirTest() throws NoSuchFieldException, IllegalAccessException {
        CampoEstatistica campoEstatistica = new CampoEstatistica();
        Campo campo = new Campo(2, 2);
        Localizacao localizacao = new Localizacao(0, 0);
        Ovelha ovelha = new Ovelha(true, campo, localizacao);
        campoEstatistica.incrementaContador(ovelha.getClass());
        campoEstatistica.incrementaContador(ovelha.getClass());
        campoEstatistica.incrementaContador(ovelha.getClass());
        campoEstatistica.incrementaContador(ovelha.getClass());
        campoEstatistica.redefine();
        Field field = campoEstatistica.getClass().getDeclaredField("contadoresValidos");
        field.setAccessible(true);
        Object value = field.get(campoEstatistica);
        String valorObtido = value.toString();
        Assert.assertEquals("false", valorObtido);
    }

    @Test
    public void quandoContadorForFinalizadoDeveRetornarVerdadeiroTest() throws IllegalAccessException, NoSuchFieldException {
        CampoEstatistica campoEstatistica = new CampoEstatistica();
        Campo campo = new Campo(2, 2);
        Localizacao localizacao = new Localizacao(0, 0);
        Ovelha ovelha = new Ovelha(true, campo, localizacao);
        campoEstatistica.incrementaContador(ovelha.getClass());
        campoEstatistica.incrementaContador(ovelha.getClass());
        campoEstatistica.incrementaContador(ovelha.getClass());
        campoEstatistica.incrementaContador(ovelha.getClass());
        campoEstatistica.contadorFinalizado();
        Field field = campoEstatistica.getClass().getDeclaredField("contadoresValidos");
        field.setAccessible(true);
        Object value = field.get(campoEstatistica);
        String valorObtido = value.toString();
        Assert.assertEquals("true", valorObtido);
    }

    @Test
    public void contadoresDevemSerValidosNaCriacaoConstrutorTest() throws IllegalAccessException, NoSuchFieldException {
        CampoEstatistica campoEstatistica = new CampoEstatistica();
        Field field = campoEstatistica.getClass().getDeclaredField("contadoresValidos");
        field.setAccessible(true);
        Object value = field.get(campoEstatistica);
        String valorObtido = value.toString();
        Assert.assertEquals("true", valorObtido);
    }

    @Test
    public void deveGerarOsContadoresTest() throws NoSuchFieldException, IllegalAccessException {
        CampoEstatistica campoEstatistica = new CampoEstatistica();
        Campo campo = new Campo(2, 2);
        Ovelha ovelha = new Ovelha(true, campo, new Localizacao(0, 0));
        Ovelha ovelha1 = new Ovelha(true, campo, new Localizacao(0, 1));
        Ovelha ovelha2 = new Ovelha(true, campo, new Localizacao(1, 0));
        Ovelha ovelha3 = new Ovelha(true, campo, new Localizacao(1, 1));
        campoEstatistica.redefine();
        Field field = campoEstatistica.getClass().getDeclaredField("contadoresValidos");
        field.setAccessible(true);
        Object value = field.get(campoEstatistica);
        String valorObtidoUm = value.toString();
        campoEstatistica.ehViavel(campo);
        Field fieldTest = campoEstatistica.getClass().getDeclaredField("contadoresValidos");
        fieldTest.setAccessible(true);
        Object teste = field.get(campoEstatistica);
        String valorObtidoDois = teste.toString();
        Assert.assertTrue(valorObtidoUm != valorObtidoDois);
    }

    @Test
    public void verificaSeIncrementaOContadorMontrandoOResultadoCorretamente() {
        CampoEstatistica estatistica = new CampoEstatistica();
        Campo campo = new Campo(9, 9);
        for (int i = 0; i < 10; i++) {
            estatistica.incrementaContador(Ovelha.class);

        }
        for (int i = 0; i < 5; i++) {
            estatistica.incrementaContador(LoboGuara.class);
        }
        String resultado = estatistica.capturaDetalhesPolulacao(campo);
        Assert.assertTrue(resultado.contains("LoboGuara: 5") && resultado.contains("Ovelha: 10"));
    }

    @Test
    public void estatisticaDeveIniciarZerada() {
        CampoEstatistica estatistica = new CampoEstatistica();
        Campo campo = new Campo(9, 9);

        String resultado = estatistica.capturaDetalhesPolulacao(campo);
        Assert.assertTrue(resultado.contains(""));
    }
}
