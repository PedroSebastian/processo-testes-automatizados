import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class LoboGuaraTest {
    private Campo campo;
    private Localizacao localizacao;
    private Localizacao localizacaoDois;
    private Localizacao localizacaoEsperada;
    private LoboGuara loboGuara;
    private LoboGuara loboGuaraDois;

    @Before
    public void init() {

    }

    @Test
    public void loboDeveSerUmAnimal() {
        LoboGuara loboGuara = new LoboGuara(true, new Campo(6, 6),
                new Localizacao(1, 1));
        Assert.assertTrue(loboGuara instanceof Animal);
    }

    @Test
    public void loboDeveTerEstadoInicialDeVivo() {
        LoboGuara lobo = new LoboGuara(true, new Campo(10, 10), new Localizacao(0, 0));

        boolean expectativa = true;
        boolean resultado = lobo.estaVivo();

        Assert.assertEquals(expectativa, resultado);
    }

    @Test
    public void verificaSeLoboMorreAposChamarOSetMorte() {
        LoboGuara lobo = new LoboGuara(true, new Campo(10, 10), new Localizacao(0, 0));
        lobo.setMorte();

        boolean expectativa = false;
        boolean resultado = lobo.estaVivo();

        Assert.assertEquals(expectativa, resultado);
    }

    @Test
    public void localizacaoDeveSerLimpaAposLoboMorrer() {
        LoboGuara lobo = new LoboGuara(true, new Campo(10, 10), new Localizacao(0, 0));
        lobo.setMorte();

        Localizacao expectativa = null;
        Localizacao resultado = lobo.getLocalizacao();

        Assert.assertEquals(expectativa, resultado);
    }

    @Test
    public void oLoboDeveEstarNaPosicaoCorretaDepoisDaCriacaoTest() {
        campo = new Campo(4, 4);
        localizacao = new Localizacao(1, 1);
        loboGuara = new LoboGuara(true, campo, localizacao);
        Localizacao localizacaoEsperada = this.localizacao;
        Localizacao localizacaoObtida = loboGuara.getLocalizacao();
        Assert.assertEquals(localizacaoEsperada, localizacaoObtida);
    }

    @Test
    public void oLoboDeveEstarVivoNoMomentoDaCriacaoTest() {
        campo = new Campo(4, 4);
        localizacao = new Localizacao(1, 1);
        loboGuara = new LoboGuara(true, campo, localizacao);
        boolean esperado = true;
        Assert.assertEquals(true, loboGuara.estaVivo());
    }

    @Test
    public void quandoLoboGuaraCacaSuaIdadeDeveSerIncrementadaTest() {
        campo = new Campo(4, 4);
        localizacao = new Localizacao(0, 0);
        localizacaoDois = new Localizacao(0, 1);
        ArrayList<Animal> novosLobos = new ArrayList<>();
        ArrayList<LoboGuara> loboSemCaca = new ArrayList<>();
        loboGuara = new LoboGuara(false, campo, localizacao);
        novosLobos.add(loboGuara);
        loboGuara.corre(novosLobos);
        loboGuaraDois = new LoboGuara(false, campo, localizacaoDois);
        loboSemCaca.add(loboGuaraDois);
    }

    @Test
    public void nivelDefomeAtingidoOLoboGuaraDeveSerRemovidoDaPosicaoTest() {
        campo = new Campo(4, 4);
        localizacao = new Localizacao(0, 0);
        ArrayList<Animal> novosLobos = new ArrayList<>();
        loboGuara = new LoboGuara(false, campo, localizacao);
        for (int i = 0; i < 7; i++) {
            loboGuara.corre(novosLobos);
        }
        Assert.assertFalse(loboGuara.estaVivo());
    }

    @Test
    public void umLoboGuaraSemPresaDeveSeMoverNaIntersecaoDaMatrizTest() {
        campo = new Campo(6, 6);
        Ovelha ovelhaUm = new Ovelha(false, campo, new Localizacao(0, 0));
        Ovelha OvelhaDois = new Ovelha(false, campo, new Localizacao(0, 1));
        Localizacao localizacaoInicialLobo = new Localizacao(0, 1);
        loboGuara = new LoboGuara(false, campo, localizacaoInicialLobo);
        ArrayList<Animal> novosLobos = new ArrayList<>();
        loboGuara.corre(novosLobos);

        localizacaoEsperada = new Localizacao(3, 3);
        Assert.assertTrue(loboGuara.getLocalizacao() != localizacaoInicialLobo);
    }

    @Test
    public void loboGuaraComIdadeMenorQueDezNaoDeveGerarFilhotesTest() {
        campo = new Campo(6, 6);
        loboGuara = new LoboGuara(false, campo, new Localizacao(0, 0));
        Ovelha ovelhaUm = new Ovelha(false, campo, new Localizacao(5, 5));
        Ovelha OvelhaDois = new Ovelha(false, campo, new Localizacao(4, 5));
        Ovelha ovelhaTres = new Ovelha(false, campo, new Localizacao(4, 4));
        Ovelha OvelhaQuatro = new Ovelha(false, campo, new Localizacao(5, 4));
        Ovelha ovelhaCinco = new Ovelha(false, campo, new Localizacao(4, 0));
        ArrayList<Animal> novosLobos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            loboGuara.corre(novosLobos);
        }
        Assert.assertEquals(0, novosLobos.size());
    }

    @Test
    public void aposCacaLoboGuaraComIdadeMaiorQueDezDeveGerarFilhotesTest() {
        campo = new Campo(6, 6);
        loboGuara = new LoboGuara(true, campo, new Localizacao(0, 0));
        loboGuaraDois = new LoboGuara(false, campo, new Localizacao(0, 1));
        Ovelha ovelhaUm = new Ovelha(false, campo, new Localizacao(5, 5));
        Ovelha OvelhaDois = new Ovelha(false, campo, new Localizacao(4, 5));
        Ovelha ovelhaTres = new Ovelha(false, campo, new Localizacao(4, 4));
        Ovelha OvelhaQuatro = new Ovelha(false, campo, new Localizacao(5, 4));
        Ovelha ovelhaCinco = new Ovelha(false, campo, new Localizacao(4, 0));
        Ovelha OvelhaSeis = new Ovelha(false, campo, new Localizacao(0, 5));
        Ovelha ovelhaSete = new Ovelha(false, campo, new Localizacao(2, 2));
        Ovelha OvelhaOito = new Ovelha(false, campo, new Localizacao(3, 3));
        ArrayList<Animal> novosLobos = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            loboGuara.corre(novosLobos);
            loboGuaraDois.corre(novosLobos);
        }
        Assert.assertTrue(novosLobos.size() != 0);
    }

    @Test
    public void loboPodeChegarAIdadeMaximaDeCentoECinquentaAnos() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        LoboGuara loboGuara = new LoboGuara(false, new Campo(6, 6),
                new Localizacao(1, 1));

        Method incrementaIdade = loboGuara.getClass().getDeclaredMethod("incrementaIdade");
        incrementaIdade.setAccessible(true);

        for (int i = 1; i <= 150; i++) {
            incrementaIdade.invoke(loboGuara);
        }

        Assert.assertTrue(loboGuara.estaVivo());
    }

    @Test
    public void loboDeveMorrerSeAtingirIdadeMaxima() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        LoboGuara loboGuara = new LoboGuara(false, new Campo(6, 6),
                new Localizacao(1, 1));

        Method incrementaIdade = loboGuara.getClass().getDeclaredMethod("incrementaIdade");
        incrementaIdade.setAccessible(true);

        for (int i = 1; i <= 151; i++) {
            incrementaIdade.invoke(loboGuara);
        }

        Assert.assertFalse(loboGuara.estaVivo());
    }

    @Test
    public void loboDeveMorrerSeNaoHouverLocalizacaoDisponivel() {
        Campo campo = new Campo(2, 2);

        LoboGuara loboGuaraUm = new LoboGuara(false, campo,
                new Localizacao(0, 0));
        LoboGuara loboGuaraDois = new LoboGuara(false, campo,
                new Localizacao(0, 1));
        LoboGuara loboGuaraTres = new LoboGuara(false, campo,
                new Localizacao(1, 0));
        LoboGuara loboGuaraQuatro = new LoboGuara(false, campo,
                new Localizacao(1, 1));

        loboGuaraUm.corre(new ArrayList<Animal>());

        Assert.assertFalse(loboGuaraUm.estaVivo());
    }
}
