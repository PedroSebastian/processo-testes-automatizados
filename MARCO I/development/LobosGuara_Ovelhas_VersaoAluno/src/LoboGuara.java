import java.util.List;
import java.util.Iterator;
import java.util.Random;

/**
 * Um simples modelo do comportamento de um predador (Lobo Guará).
 * <p>
 * Ilustração das simulações típicas entre predador e presa.
 */
public class LoboGuara extends Animal implements iAnimal {
    private static final int IDADE_PROCRIACAO = 10;
    private static final int IDADE_MAXIMA = 150;
    private static final double PROBABILIDADE_PROCRIACAO = 0.35;
    private static final int TAMANHO_MAXIMO_NINHADA = 5;
    private static final int VALOR_FOME_OVELHA = 7;
    private static final Random rand = Randomizador.getRandom();

    private int idade;
    private int nivelFome;

    /**
     * Método que cria um lobo.
     * <p>
     * Este método permite que um lobo possa ser criado recém nascido e sem fome, ou com uma idade aleatória e com um
     * nível de fome.
     *
     * @param idadeRandomica Se esta cláusula for verdadeira, o lobo terá uma idade aleatória e um nível de fome.
     * @param campo          o campo ocupado pelo animal.
     * @param localizacao    a localização do campo.
     */
    public LoboGuara(boolean idadeRandomica, Campo campo, Localizacao localizacao) {
        super(localizacao, campo);
        idade = 0;
        setLocalizacao(localizacao);
        if (idadeRandomica) {
            idade = rand.nextInt(IDADE_MAXIMA);
            nivelFome = rand.nextInt(VALOR_FOME_OVELHA);
        } else {
            nivelFome = VALOR_FOME_OVELHA;
        }
    }

    /**
     * Este método demonstra o que o lobo tem o intuito de fazer: caçar.
     * Neste método, a cada caça feita, é incrementada a idade e a fome do lobo.
     * Durante todo o processo, o lobo pode morrer de fome, morrer de velho ou dar a luz.
     *
     * @param novosLobos esta é a lista que armazena todos os lobos recém-nascidos.
     */
    public void corre(List<Animal> novosLobos) {
        this.incrementaIdade();
        this.incrementaFome();
        if (estaVivo()) {
            daALuz(novosLobos);
            Localizacao newLocalizacao = procuraComida(getLocalizacao());
            if (newLocalizacao == null) {
                newLocalizacao = getCampo().localizacaoAdjacenteLivre(getLocalizacao());
            }
            if (newLocalizacao != null) {
                setLocalizacao(newLocalizacao);
            } else {
                setMorte();
            }
        }
    }


    /**
     * Este método é utilizado para incrementar a idade do lobo.
     * O mesmo pode morrer, dependendo de sua idade.
     */
    private void incrementaIdade() {
        idade++;
        if (idade > IDADE_MAXIMA) {
            setMorte();
        }
    }

    /**
     * Este método incrementa a fome do lobo.
     * O mesmo pode morrer, dependendo do seu nível de fome.
     */
    private void incrementaFome() {
        nivelFome--;
        if (nivelFome == 0) {
            setMorte();
        }
    }

    /**
     * Este método avisa ao lobo quando há ovelhas adjacentes a ele.
     * A primeira ovelha que estiver viva será comida.
     *
     * @param localizacao qual é a localização no campo.
     * @return a localização de onde a ovelha foi encontrada ou null caso nenhuma ovelha for encontrada.
     */
    private Localizacao procuraComida(Localizacao localizacao) {
        List<Localizacao> adjacente = getCampo().localizacoesAdjacentes(localizacao);
        Iterator<Localizacao> it = adjacente.iterator();
        while (it.hasNext()) {
            Localizacao onde = it.next();
            Object animal = getCampo().pegarAnimalNaPosicao(onde);
            if (animal instanceof Ovelha) {
                Ovelha ovelha = (Ovelha) animal;
                ovelha.setMorte();
                nivelFome = VALOR_FOME_OVELHA;
                return onde;
            }
        }
        return null;
    }

    /**
     * Este método verifica se o lobo deve ou não dar a luz.
     * As novas crias serão colocadas nas localizações adjacentes.
     *
     * @param novosLobos lista utilizada para o armazenamento dos lobos recém-nascidos.
     */
    private void daALuz(List<Animal> novosLobos) {
        List<Localizacao> livre = getCampo().localizacoesAdjacentesLivres(getLocalizacao());
        int nascimentos = procria();
        for (int b = 0; b < nascimentos; b++) {
            if (livre.size() > 0) {
                Localizacao loc = livre.remove(0);
                LoboGuara jovem = new LoboGuara(false, getCampo(), loc);
                novosLobos.add(jovem);
            }
        }
    }

    /**
     * Este método gera um número aleatório que representa o número de nascimento de lobos.
     * Além disso, também verifica se o lobo pode procriar ou não.
     *
     * @return o número de nascimentos.
     */
    protected int procria() {
        int nascimentos = 0;
        if (podeProcriar() && rand.nextDouble() < PROBABILIDADE_PROCRIACAO) {
            nascimentos = rand.nextInt(TAMANHO_MAXIMO_NINHADA) + 1;
        }
        return nascimentos;
    }

    /**
     * Este método verifica se um lobo pode procriar.
     * Depende da sua idade.
     *
     * @return
     */
    protected boolean podeProcriar() {
        return idade >= IDADE_PROCRIACAO;
    }


}