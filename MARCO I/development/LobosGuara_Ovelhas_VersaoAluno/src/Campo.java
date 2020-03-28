import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Representa uma grade retangular, onde cada posição
 * pode conter somente um animal.
 */
public class Campo {
    private static final Random rand = Randomizador.getRandom();

    private int profundidade, largura;
    private Object[][] campo;

    /**
     * Representa um campo com o tamanho requerido.
     *
     * @param profundidade profundidade do campo.
     * @param largura      largura do campo.
     */
    public Campo(int profundidade, int largura) {
        this.profundidade = profundidade;
        this.largura = largura;
        campo = new Object[profundidade][largura];
    }

    /**
     * Esvazia o campo.
     */
    public void limpa() {
        for (int linha = 0; linha < profundidade; linha++) {
            for (int coluna = 0; coluna < largura; coluna++) {
                campo[linha][coluna] = null;
            }
        }
    }

    /**
     * Limpa somente a localização dada.
     *
     * @param localizacao a localização que deve ser limpa.
     */
    public void limpa(Localizacao localizacao) {
        campo[localizacao.getLinha()][localizacao.getColuna()] = null;
    }

    /**
     * Adiciona um animal na posição requerida.
     * Se já houver um animal em tal posição, então o mesmo não é adicionado.
     *
     * @param animal animal que vai ser adicionado no campo.
     * @param linha  coordenada do campo.
     * @param coluna coordenada do campo.
     * @throws ObjetoInvalidoException
     */
    public void lugar(Object animal, int linha, int coluna) throws ObjetoInvalidoException {
        if (!(animal instanceof iAnimal)) {
            throw new ObjetoInvalidoException("O objeto passado no argumento não consiste em um animal válido!");
        }
        lugar(animal, new Localizacao(linha, coluna));
    }

    /**
     * Adiciona um animal na posição requerida.
     * Se já houver um animal em tal posição, então o mesmo não é adicionado.
     *
     * @param animal      animal que vai ser adicionado no campo.
     * @param localizacao localização para adicionar o animal.
     * @throws ObjetoInvalidoException
     */
    public void lugar(Object animal, Localizacao localizacao) throws ObjetoInvalidoException {
        if (!(animal instanceof iAnimal)) {
            throw new ObjetoInvalidoException("O objeto passado no argumento não consiste em um animal válido!");
        }
        campo[localizacao.getLinha()][localizacao.getColuna()] = animal;
    }

    /**
     * Se houver um animal em tal posição, o método retorna ele.
     *
     * @param localizacao localização do campo.
     * @return o animal que estiver na posição, ou null caso não possua nenhum animal naquela posição.
     */
    public Object pegarAnimalNaPosicao(Localizacao localizacao) {
        return pegarAnimalNaPosicao(localizacao.getLinha(), localizacao.getColuna());
    }

    /**
     * Se houver um animal em tal posição, o método retorna ele.
     *
     * @param linha  linha requerida.
     * @param coluna coluna requerida.
     * @return o animal que estiver na posição, ou null caso não possua nenhum animal naquela posição.
     */
    public Object pegarAnimalNaPosicao(int linha, int coluna) {
        return campo[linha][coluna];
    }

    /**
     * Gera uma localização aleatória que é adjacente a localização requerida
     * ou a mesma localização.
     * A localização retornada estará entre os limites do campo.
     *
     * @param localizacao localização onde gerará a sua adjacente.
     * @return uma localização válida entre a grade do campo.
     */
    public Localizacao localizacaoAdjacenteRandomica(Localizacao localizacao) {
        List<Localizacao> adjacent = localizacoesAdjacentes(localizacao);
        return adjacent.get(0);
    }

    /**
     * Obtém uma lista aleatória de localizações adjancentes livres.
     *
     * @param localizacao obtém a localização adjancente a essa.
     * @return uma lista de localizações adjacentes livres.
     */
    public List<Localizacao> localizacoesAdjacentesLivres(Localizacao localizacao) {
        List<Localizacao> livre = new LinkedList<Localizacao>();
        List<Localizacao> adjacente = localizacoesAdjacentes(localizacao);
        for (Localizacao proximo : adjacente) {
            if (pegarAnimalNaPosicao(proximo) == null) {
                livre.add(proximo);
            }
        }
        return livre;
    }

    /**
     * Tenta encontrar uma localização livre que seja adjacente a localização
     * requerida (caso não houver localização livre, retorna null).
     * A localização retorna estará entre os limites do campo.
     *
     * @param localizacao localização onde gerará a sua adjacente.
     * @return uma localização válida entre a grade do campo.
     */
    public Localizacao localizacaoAdjacenteLivre(Localizacao localizacao) {
        List<Localizacao> livre = localizacoesAdjacentesLivres(localizacao);
        if (livre.size() > 0) {
            return livre.get(0);
        } else {
            return null;
        }
    }

    /**
     * Retorna uma lista de localizações adjacentes a localização requerida.
     * A lista não incluirá o próprio local.
     * Todos os locais estarão dentro da grade do campo.
     *
     * @param localizacao a localização de onde serão geradas suas adjacentes.
     * @return uma lista de localizações adjacentes a dada.
     */
    public List<Localizacao> localizacoesAdjacentes(Localizacao localizacao) {
        assert localizacao != null : "Null localizacao passed to adjacentLocalizacoes";
        List<Localizacao> localizacoes = new LinkedList<Localizacao>();
        if (localizacao != null) {
            int linha = localizacao.getLinha();
            int coluna = localizacao.getColuna();
            for (int i = -1; i <= 1; i++) {
                int proximaLinha = linha + i;
                if (proximaLinha >= 0 && proximaLinha < profundidade) {
                    for (int j = -1; j <= 1; j++) {
                        int proximaColuna = coluna + j;
                        if (proximaColuna >= 0 && proximaColuna < largura && (i != 0 || j != 0)) {
                            localizacoes.add(new Localizacao(proximaLinha, proximaColuna));
                        }
                    }
                }
            }
            Collections.shuffle(localizacoes, rand);
        }
        return localizacoes;
    }

    /**
     * Retorna a profundidade do campo.
     *
     * @return profundidade do campo.
     */
    public int getProfundidade() {
        return profundidade;
    }

    /**
     * Retorna a largura do campo.
     *
     * @return a largura do campo.
     */
    public int getLargura() {
        return largura;
    }
}
