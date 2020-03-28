import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Color;

/**
 * Esta classe representa um simulador de predadores e presas,
 * isto é, lobos e ovelhas em um campo.
 */
public class Simulador {
    private static final int LARGURA_PADRAO = 50;
    private static final int PROFUNDIDADE_PADRAO = 50;
    private static final double PROBABILIDADE_CRIACAO_LOBOGUARA = 0.02;
    private static final double PROBABILIDADE_CRIACAO_OVELHA = 0.28;

    private List<Animal> animais;
    private Campo campo;
    private int etapa;
    private SimuladorTela tela;

    /**
     * Constrói uma simulação de campo com um tamanho padrão.
     */
    public Simulador() {
        this(PROFUNDIDADE_PADRAO, LARGURA_PADRAO);
    }

    /**
     * Constrói uma simulação de campo com um tamanho requerido.
     *
     * @param profundidade Profundidade do campo (deve ser maior que zero).
     * @param largura      Largura do Campo (deve ser maior que zero).
     */
    public Simulador(int profundidade, int largura) {
        this.init(profundidade, largura);
    }

    /**
     * Executa a simuação do seu estado atual por um período longo.
     */
    public void executaLongaSimulacao() {
        simulacao(500);
    }

    /**
     * Executa a simulação do seu estado atual por um número de etapas pré-definido.
     * Para antes do número de etapas ser atingido, se deixar de ser viável.
     *
     * @param numEtapas O número de etapas para executar.
     */
    public void simulacao(int numEtapas) {
        for (int etapa = 1; etapa <= numEtapas && tela.ehViavel(campo); etapa++) {
            System.out.println("Etapa: " + etapa);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            simulacaoUmaEtapa();
        }
    }

    /**
     * Executa a simulação do seu estado atual por uma única etapa.
     * Percorre todo o campo atualizando o estado de cada animal.
     */
    public void simulacaoUmaEtapa() {
        this.etapa = this.etapa + 1;

        List<Animal> novosAnimais = new ArrayList<Animal>();
        for (Iterator<Animal> it = animais.iterator(); it.hasNext(); ) {
            Animal animal = it.next();
            animal.corre(novosAnimais);
            if (!animal.estaVivo()) {
                it.remove();
            }
        }

        animais.addAll(novosAnimais);

        tela.mostraStatus(this.etapa, this.campo);
    }

    /**
     * Refedine a simulação para uma posição inicial.
     */
    public void redefine() {
        etapa = 0;
        animais.clear();
        animais.clear();
        povoa();

        tela.mostraStatus(etapa, campo);
    }

    /**
     * Povoa, aleatoriamente, o campo com lobos e ovelhas.
     */
    private void povoa() {
        Random rand = Randomizador.getRandom();
        campo.limpa();
        for (int linha = 0; linha < campo.getProfundidade(); linha++) {
            for (int coluna = 0; coluna < campo.getLargura(); coluna++) {
                if (rand.nextDouble() < PROBABILIDADE_CRIACAO_LOBOGUARA) {
                    Localizacao localizacao = new Localizacao(linha, coluna);
                    LoboGuara loboGuara = new LoboGuara(true, campo, localizacao);
                    animais.add(loboGuara);
                } else if (rand.nextDouble() < PROBABILIDADE_CRIACAO_OVELHA) {
                    Localizacao localizacao = new Localizacao(linha, coluna);
                    Ovelha ovelha = new Ovelha(true, campo, localizacao);
                    animais.add(ovelha);
                }
            }
        }
    }

    private void init(int profundidade, int largura) {
        if (largura <= 0 || profundidade <= 0) {
            System.out.println("As dimensões devem ser maior do que zero.");
            System.out.println("Usando valores padrões.");
            profundidade = PROFUNDIDADE_PADRAO;
            largura = LARGURA_PADRAO;
        }

        animais = new ArrayList<Animal>();
        campo = new Campo(profundidade, largura);

        tela = new SimuladorTela(profundidade, largura);
        tela.setCor(Ovelha.class, Color.orange);
        tela.setCor(LoboGuara.class, Color.blue);

        redefine();
    }
}