import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CampoTest {
    private Campo campo;

    @Test
    public void inserirUmAnimalPelaLocalizacaoTest() throws ObjetoInvalidoException {
        campo = new Campo(4, 4);
        Localizacao localizacao = new Localizacao(0, 0);
        Localizacao localizacao2 = new Localizacao(0, 2);
        Ovelha ovelha = new Ovelha(true, campo, localizacao);
        campo.lugar(ovelha, localizacao2);
        Assert.assertTrue(campo.pegarAnimalNaPosicao(localizacao) == campo.pegarAnimalNaPosicao(localizacao2));
    }

    @Test
    public void inserirUmAnimalPelaLinhaEColunaTest() throws ObjetoInvalidoException {
        campo = new Campo(4, 4);
        Localizacao localizacao = new Localizacao(0, 0);
        Ovelha ovelha = new Ovelha(true, campo, localizacao);
        campo.lugar(ovelha, 0, 1);
        Assert.assertTrue(campo.pegarAnimalNaPosicao(0, 0) == campo.pegarAnimalNaPosicao(0, 1));
    }

    @Test
    public void getObjectPelaLocalizacaoTest() {
        campo = new Campo(4, 4);
        Localizacao localizacaoUm = new Localizacao(0, 0);
        Localizacao localizacaoDois = new Localizacao(0, 1);
        Ovelha ovelha = new Ovelha(true, campo, localizacaoUm);
        Ovelha ovelha2 = new Ovelha(true, campo, localizacaoDois);
        Assert.assertTrue(ovelha == campo.pegarAnimalNaPosicao(localizacaoUm) && ovelha2 == campo.pegarAnimalNaPosicao
                (localizacaoDois));
    }

    @Test
    public void getObjectPelaLinhaEColunaTest() {
        campo = new Campo(4, 4);
        Localizacao localizacaoUm = new Localizacao(0, 0);
        Localizacao localizacaoDois = new Localizacao(0, 1);
        Ovelha ovelha = new Ovelha(true, campo, localizacaoUm);
        Ovelha ovelha2 = new Ovelha(true, campo, localizacaoDois);
        Assert.assertTrue(ovelha == campo.pegarAnimalNaPosicao(0, 0) && ovelha2 == campo.pegarAnimalNaPosicao
                (0, 1));
    }

    @Test
    public void getProfundidadeTest() {
        campo = new Campo(2, 4);
        int valorObtido = campo.getProfundidade();
        Assert.assertEquals(2, valorObtido);
    }

    @Test
    public void getLarguraTest() {
        campo = new Campo(2, 4);
        int valorObtido = campo.getLargura();
        Assert.assertEquals(4, valorObtido);

    }

    @Test
    public void localizacaoAdjacenteRandomicaTest() {
        campo = new Campo(4, 4);
        Localizacao localizacao = new Localizacao(0, 1);
        campo.localizacaoAdjacenteRandomica(localizacao);
        System.out.println(localizacao.toString());
    }

    @Test
    public void localizacoesAdjacentesLivreTest() {
        campo = new Campo(6, 6);
        Localizacao localizacao = new Localizacao(0, 0);
        Localizacao localizacaoAdj1 = new Localizacao(1, 0);
        Localizacao localizacaoAdj2 = new Localizacao(1, 1);
        Localizacao localizacaoAdj3 = new Localizacao(0, 1);
        Ovelha ovelha = new Ovelha(true, campo, localizacao);
        Ovelha ovelhaUm = new Ovelha(true, campo, localizacaoAdj1);
        Ovelha ovelhaDois = new Ovelha(true, campo, localizacaoAdj2);
        ArrayList<Localizacao> LocalizacaoEsperada = new ArrayList<>();
        LocalizacaoEsperada.add(localizacaoAdj3);
        Assert.assertEquals(campo.localizacoesAdjacentesLivres(localizacao), LocalizacaoEsperada);
    }

    @Test
    public void localizacoesAdjacentesTest() {
        campo = new Campo(6, 6);
        Localizacao localizacao = new Localizacao(0, 0);
        Localizacao localizacaoAdj1 = new Localizacao(1, 0);
        Localizacao localizacaoAdj2 = new Localizacao(1, 1);
        Localizacao localizacaoAdj3 = new Localizacao(0, 1);
        List<Localizacao> localizacoesTest = new LinkedList<>();
        localizacoesTest.add(localizacaoAdj1);
        localizacoesTest.add(localizacaoAdj2);
        localizacoesTest.add(localizacaoAdj3);
        Assert.assertTrue(campo.localizacoesAdjacentes(localizacao).size() == 3);
    }

    @Test
    public void pegarUmObjetoQueNaoExisteNoCampoTest() {
        campo = new Campo(2, 2);
        Assert.assertNull(campo.pegarAnimalNaPosicao(1, 1));
    }

    @Test()
    public void criandoUmCampoComLarguraZeroEProfundidadeZeroTest() {
        campo = new Campo(0, 0);
        Assert.assertTrue(campo.getProfundidade() == 0 && campo.getLargura() == 0);
    }

    @Test(expected = ObjetoInvalidoException.class)
    public void deveLancarExcecaoAoInserirObjetoDiferenteDeAnimalNoCampo() throws ObjetoInvalidoException {
        campo = new Campo(4, 4);
        Contador cont = new Contador("teste");
        campo.lugar(cont, 0, 0);
    }

    @Test
    public void inserirDoisAnimaisNoMesmoLocalTest() {
        campo = new Campo(4, 4);
        Localizacao localizacaoUm = new Localizacao(0, 0);
        Ovelha ovelha1 = new Ovelha(true, campo, localizacaoUm);
        Ovelha ovelha2 = new Ovelha(true, campo, localizacaoUm);
        Assert.assertTrue(campo.pegarAnimalNaPosicao(0, 0) == ovelha2);
    }

    @Test
    public void inserirUmAnimalNoCampoTest() {
        campo = new Campo(4, 4);
        Localizacao localizacaoUm = new Localizacao(0, 0);
        Ovelha ovelha = new Ovelha(true, campo, localizacaoUm);
        Assert.assertEquals(ovelha, campo.pegarAnimalNaPosicao(localizacaoUm));
    }

    @Test
    public void verificaSeUmCampoECriadoCorretamenteTest() {
        campo = new Campo(4, 4);
        for (int i = 0; i < campo.getLargura(); i++) {
            for (int j = 0; j < campo.getProfundidade(); j++) {
                Assert.assertEquals(null, campo.pegarAnimalNaPosicao(i, j));
            }

        }
    }

    @Test
    public void limpaUmaLocalizacaoTest() {
        campo = new Campo(4, 4);
        Localizacao localizacaoUm = new Localizacao(0, 0);
        Localizacao localizacaoDois = new Localizacao(0, 1);
        Localizacao localizacaoTres = new Localizacao(0, 2);
        Localizacao localizacaoQuatro = new Localizacao(0, 3);
        Ovelha ovelha = new Ovelha(true, campo, localizacaoUm);
        campo.limpa(localizacaoUm);
        Assert.assertNull(campo.pegarAnimalNaPosicao(localizacaoUm));
    }

    @Test
    public void verificaSeEPossivelLimparOCampoTest() {
        campo = new Campo(4, 4);
        Localizacao localizacaoUm = new Localizacao(0, 0);
        Localizacao localizacaoDois = new Localizacao(0, 1);
        Localizacao localizacaoTres = new Localizacao(0, 2);
        Localizacao localizacaoQuatro = new Localizacao(0, 3);
        Ovelha ovelha = new Ovelha(true, campo, localizacaoUm);
        Ovelha ovelha2 = new Ovelha(true, campo, localizacaoDois);
        Ovelha ovelha3 = new Ovelha(true, campo, localizacaoTres);
        Ovelha ovelha4 = new Ovelha(true, campo, localizacaoQuatro);
        campo.limpa();
        Assert.assertEquals(null, campo.pegarAnimalNaPosicao(0, 0));
        Assert.assertEquals(null, campo.pegarAnimalNaPosicao(1, 1));
        Assert.assertEquals(null, campo.pegarAnimalNaPosicao(2, 2));
        Assert.assertEquals(null, campo.pegarAnimalNaPosicao(3, 3));
    }

    @Test(expected = ObjetoInvalidoException.class)
    public void verificaSeLancaExcecaoAoInserirObjetoInvalidoEmLocal() throws ObjetoInvalidoException {
        Contador c = new Contador("Contador");
        this.campo = new Campo(5, 5);
        this.campo.lugar(c, 1, 1);
    }

    @Test
    public void deveRetornarUmaLocalizacaoAdjacenteRandomica() {
        this.campo = new Campo(3, 3);

        for (int i = 0; i <= 20; i++) {
            Localizacao resultado = this.campo.localizacaoAdjacenteRandomica(new Localizacao(1, 1));
            Assert.assertTrue(resultado != new Localizacao(1, 1));
        }
    }

    @Test(expected = java.lang.NegativeArraySizeException.class)
    public void deveLancarExcecaoSeProfundidadeOuLarguraForNegativa() {
        this.campo = new Campo(-1, -1);
    }

    @Test
    public void verificaSePegaTresPosicoesAdjacentesDoCantoSuperiorEsquerdoDoCampo() {
        this.campo = new Campo(3, 3);

        List<Localizacao> resultado = this.campo.localizacoesAdjacentes(new Localizacao(0, 0));

        Assert.assertTrue(resultado.size() == 3);
    }

    @Test
    public void verificaSePegaPosicoesAdjacentesCorretasDoCantoSuperiorEsquerdoDoCampo() {
        this.campo = new Campo(3, 3);

        List<Localizacao> resultados = this.campo.localizacoesAdjacentes(new Localizacao(0, 0));

        Iterator iterator = resultados.iterator();
        while(iterator.hasNext()){
            Localizacao local = (Localizacao) iterator.next();

            boolean resultado = local.toString().equals("0,1") || local.toString().equals("1,1") ||
                    local.toString().equals("1,0") && !local.toString().equals("0,0");

            Assert.assertTrue(resultado);
        }
    }

    @Test
    public void verificaSePegaTresPosicoesAdjacentesDoCantoInferiorDireitoDoCampo() {
        this.campo = new Campo(3, 3);

        List<Localizacao> resultado = this.campo.localizacoesAdjacentes(new Localizacao(2, 2));

        Assert.assertTrue(resultado.size() == 3);
    }

    @Test
    public void verificaSePegaPosicoesAdjacentesCorretasDoCantoInferiorDireitoDoCampo() {
        this.campo = new Campo(3, 3);

        List<Localizacao> resultados = this.campo.localizacoesAdjacentes(new Localizacao(2, 2));

        Iterator iterator = resultados.iterator();
        while(iterator.hasNext()){
            Localizacao local = (Localizacao) iterator.next();

            boolean resultado = local.toString().equals("1,2") || local.toString().equals("2,1") ||
                    local.toString().equals("1,1") && !local.toString().equals("2,2");

            Assert.assertTrue(resultado);
        }
    }

    @Test(expected = ObjetoInvalidoException.class)
    public void deveLancarExcecaoAoInserirObjetoInvalidoEmLugar() throws ObjetoInvalidoException {
        Campo campo = new Campo(9, 9);
        campo.lugar(new StringBuffer(), new Localizacao(1, 1));
    }
}
