import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Hashtable;

public class OvelhaTest {

    @Test
    public void ovelhaDeveSerUmAnimal() {
        Ovelha ovelha = new Ovelha(true, new Campo(6, 6),
                new Localizacao(1, 1));
        Assert.assertTrue(ovelha instanceof Animal);
    }

    @Test
    public void ovelhaDeveIniciarViva() {
        Ovelha ovelha = new Ovelha(true, new Campo(6, 6),
                new Localizacao(1, 1));

        Assert.assertTrue(ovelha.estaVivo());
    }

    @Test
    public void verificaSeOvelhaMorreAposChamarOSetMorte() {
        Ovelha ovelha = new Ovelha(true, new Campo(10, 10), new Localizacao(0, 0));
        ovelha.setMorte();

        boolean expectativa = false;
        boolean resultado = ovelha.estaVivo();

        Assert.assertEquals(expectativa, resultado);
    }

    @Test
    public void localizacaoDeveSerLimpaAposOvelhaMorrer() {
        Ovelha ovelha = new Ovelha(true, new Campo(10, 10), new Localizacao(0, 0));
        ovelha.setMorte();

        Localizacao expectativa = null;
        Localizacao resultado = ovelha.getLocalizacao();

        Assert.assertEquals(expectativa, resultado);
    }

    @Test
    public void ovelhaDeveEstarNaPosicaoCorretaDepoisDaCriacaoTest() {
        Campo campo = new Campo(4, 4);
        Localizacao localizacao = new Localizacao(1, 1);
        Ovelha ovelha = new Ovelha(true, campo, localizacao);
        Localizacao localizacaoEsperada = localizacao;
        Localizacao localizacaoObtida = ovelha.getLocalizacao();
        Assert.assertEquals(localizacaoEsperada, localizacaoObtida);
    }

    @Test
    public void novaOvelhaSemIdadeRamdomicaDeveIniciarComIdadeIgualAZero() throws NoSuchFieldException, IllegalAccessException {
        Animal ovelha = new Ovelha(false, new Campo(6, 6),
                new Localizacao(1, 1));

        Field idade = ovelha.getClass().getDeclaredField("idade");
        idade.setAccessible(true);

        int expectativa = 0;
        int resultado = (int) idade.get(ovelha);

        Assert.assertEquals(expectativa, resultado);
    }

    @Test
    public void novaOvelhaComIdadeRamdomicaDeveIniciarComIdadeMaiorQueZero() throws NoSuchFieldException, IllegalAccessException {
        Animal ovelha = new Ovelha(true, new Campo(6, 6),
                new Localizacao(1, 1));

        Field idade = ovelha.getClass().getDeclaredField("idade");
        idade.setAccessible(true);

        int resultado = (int) idade.get(ovelha);

        Assert.assertTrue(resultado > 0);
    }

    @Test
    public void verificaSeOvelhaIncrementaIdadeCorretamente() throws NoSuchFieldException, IllegalAccessException {
        Animal ovelha = new Ovelha(false, new Campo(6, 6),
                new Localizacao(1, 1));

        ovelha.corre(new ArrayList<Animal>());
        Field idade = ovelha.getClass().getDeclaredField("idade");
        idade.setAccessible(true);

        int expectativa = 1;
        int resultado = (int) idade.get(ovelha);

        Assert.assertEquals(expectativa, resultado);
    }

    @Test
    public void verificaSeOvelhaIncrementaIdadeCorretamenteAposCorrerCincoVezes() throws NoSuchFieldException, IllegalAccessException {
        Animal ovelha = new Ovelha(false, new Campo(6, 6),
                new Localizacao(1, 1));

        for (int i = 1; i <= 5; i++) {
            ovelha.corre(new ArrayList<Animal>());
        }
        Field idade = ovelha.getClass().getDeclaredField("idade");
        idade.setAccessible(true);

        int expectativa = 5;
        int resultado = (int) idade.get(ovelha);

        Assert.assertEquals(expectativa, resultado);
    }

    @Test
    public void ovelhaDeveMorrerAoPassarDaIdadeMaxima() {
        Animal ovelha = new Ovelha(false, new Campo(6, 6),
                new Localizacao(1, 1));

        for (int i = 1; i <= 41; i++) {
            ovelha.corre(new ArrayList<Animal>());
        }

        Assert.assertFalse(ovelha.estaVivo());
    }

    @Test
    public void ovelhaComIdadeMenorQueCincoNaoDeveSerPermitidoProcriacao() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Animal ovelha = new Ovelha(false, new Campo(6, 6),
                new Localizacao(1, 1));

        Method procria = ovelha.getClass().getDeclaredMethod("podeProcriar");
        procria.setAccessible(true);

        Assert.assertFalse((Boolean) procria.invoke(ovelha));
    }

    @Test
    public void ovelhaComIdadeIgualACincoDeveSerPermitidoProcriacao() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Animal ovelha = new Ovelha(false, new Campo(6, 6),
                new Localizacao(1, 1));

        for (int i = 1; i <= 5; i++) {
            ovelha.corre(new ArrayList<Animal>());
        }

        Method procria = ovelha.getClass().getDeclaredMethod("podeProcriar");
        procria.setAccessible(true);

        Assert.assertTrue((Boolean) procria.invoke(ovelha));
    }

    @Test
    public void ovelhaComIdadeMaiorACincoDeveSerPermitidoProcriacao() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Animal ovelha = new Ovelha(false, new Campo(6, 6),
                new Localizacao(1, 1));

        for (int i = 1; i <= 8; i++) {
            ovelha.corre(new ArrayList<Animal>());
        }

        Method procria = ovelha.getClass().getDeclaredMethod("podeProcriar");
        procria.setAccessible(true);

        Assert.assertTrue((Boolean) procria.invoke(ovelha));
    }

    @Test
    public void ovelhaComIdadeMenorQueCincoNaoDeveProcriar() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Animal ovelha = new Ovelha(false, new Campo(6, 6),
                new Localizacao(1, 1));

        Method procria = ovelha.getClass().getDeclaredMethod("procria");
        procria.setAccessible(true);

        int expectativa = 0;
        int resultado = (int) procria.invoke(ovelha);

        Assert.assertEquals(expectativa, resultado);
    }

    @Test
    public void ovelhaComIdadeIgualACincoDeveProcriar() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Animal ovelha = new Ovelha(false, new Campo(6, 6),
                new Localizacao(1, 1));

        for (int i = 1; i <= 5; i++) {
            ovelha.corre(new ArrayList<Animal>());
        }

        int novasOvelhas = 0;

        Method procria = ovelha.getClass().getDeclaredMethod("procria");
        procria.setAccessible(true);

        for (int i = 1; i <= 15; i++) {
            novasOvelhas = (int) procria.invoke(ovelha);
            if (novasOvelhas > 0) {
                break;
            }
        }

        Assert.assertTrue(novasOvelhas > 0);
    }

    @Test
    public void ovelhaComIdadeMaiorACincoDeveProcriar() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Animal ovelha = new Ovelha(false, new Campo(6, 6),
                new Localizacao(1, 1));

        for (int i = 1; i <= 10; i++) {
            ovelha.corre(new ArrayList<Animal>());
        }

        int novasOvelhas = 0;

        Method procria = ovelha.getClass().getDeclaredMethod("procria");
        procria.setAccessible(true);

        for (int i = 1; i <= 15; i++) {
            novasOvelhas = (int) procria.invoke(ovelha);
            if (novasOvelhas > 0) {
                break;
            }
        }

        Assert.assertTrue(novasOvelhas > 0);
    }

    @Test
    public void devePermitirAtribuirCampoAOvelha() {
        Campo campo = new Campo(5, 5);
        Animal ovelha = new Ovelha(true, campo, new Localizacao(4, 4));

        Assert.assertEquals(campo, ovelha.getCampo());
    }

    @Test
    public void devePermitirAtribuirLocalizacaoAOvelhaPorConstrutor() {
        Campo campo = new Campo(5, 5);
        Localizacao localizacao = new Localizacao(4, 4);
        Animal ovelha = new Ovelha(true, campo, localizacao);

        Assert.assertEquals(localizacao, ovelha.getLocalizacao());
        Assert.assertEquals(localizacao.getColuna(), ovelha.getLocalizacao().getColuna());
        Assert.assertEquals(localizacao.getLinha(), ovelha.getLocalizacao().getLinha());
    }

    @Test
    public void devePermitirAtribuirLocalizacaoAOvelhaPorSetter() {
        Campo campo = new Campo(5, 5);
        Localizacao localizacao = new Localizacao(4, 4);
        Animal ovelha = new Ovelha(true, campo, new Localizacao(3, 3));
        ovelha.setLocalizacao(localizacao);

        Assert.assertEquals(localizacao, ovelha.getLocalizacao());
        Assert.assertEquals(localizacao.getColuna(), ovelha.getLocalizacao().getColuna());
        Assert.assertEquals(localizacao.getLinha(), ovelha.getLocalizacao().getLinha());
    }

    @Test
    public void ovelhaDeveMorrerAposAtingirIdadeMaxima() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Animal ovelha = new Ovelha(false, new Campo(6, 6),
                new Localizacao(1, 1));

        Method incrementaIdade = ovelha.getClass().getDeclaredMethod("incrementaIdade");
        incrementaIdade.setAccessible(true);

        for (int i = 1; i <= 41; i++) {
            incrementaIdade.invoke(ovelha);
        }

        Assert.assertFalse(ovelha.estaVivo());
    }

}
