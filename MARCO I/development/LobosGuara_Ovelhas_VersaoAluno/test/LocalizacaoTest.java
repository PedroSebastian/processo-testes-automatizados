import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LocalizacaoTest {
    private Localizacao localizacao;
    private Localizacao localizacaoUm;

    @Before
    public void init() {

    }

    @Test
    public void verficaSeLinhaEColunaSaoCriadosCorretamenteTest() {
        localizacao = new Localizacao(0, 0);
        Assert.assertTrue(localizacao.getColuna() == 0 && localizacao.getLinha() == 0);
    }

    @Test
    public void deveRetornarVerdadeiroParaUmObjetoDeMesmaInstanciaTest() {
        localizacao = new Localizacao(1, 1);
        localizacaoUm = new Localizacao(1, 1);
        System.out.println(localizacao.equals(localizacaoUm));
    }

    @Test
    public void deveRetornarFalsoParaUmObjetoComOutraReferenciaTest() {
        localizacao = new Localizacao(1, 1);
        localizacaoUm = new Localizacao(1, 1);
        System.out.println(localizacao.equals(localizacaoUm));
    }

    @Test
    public void deveRetornarUmToStringTest() {
        localizacao = new Localizacao(9, 9);
        String resultadoEsperado = "9,9";
        String resultadoObtido = localizacao.toString();
        Assert.assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    public void doisObjetosComOMesmoParametroDevemPossuirHashCodeIguaisTest() {
        localizacao = new Localizacao(4, 4);
        localizacaoUm = new Localizacao(4, 4);
        Assert.assertNotSame(localizacao, localizacaoUm);
        Assert.assertEquals(localizacao.hashCode(), localizacaoUm.hashCode());
    }

    @Test
    public void doisObjetosComParametrosDiferentesHashCodeNaoDeveSerIgualTest() {
        localizacao = new Localizacao(4, 4);
        localizacaoUm = new Localizacao(1, 1);
        Assert.assertNotEquals(localizacao.hashCode(), localizacaoUm.hashCode());
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDeveAceitarLinhaNegativa() {
        this.localizacao = new Localizacao(-1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDeveAceitarColunaNegativa() {
        this.localizacao = new Localizacao(1, -1);
        this.localizacao = new Localizacao(1, -1);
    }
}