import java.util.List;
import java.util.Random;

public class Ovelha extends Animal implements iAnimal {
    private static final int IDADE_PROCRIACAO = 5;
    private static final int IDADE_MAXIMA = 40;
    private static final double PROBABILIDADE_PROCRIACAO = 0.15;
    private static final int TAMANHO_MAXIMO_NINHADA = 4;
    private static final Random rand = Randomizador.getRandom();

    private int idade;


    public Ovelha(boolean randomAge, Campo campo, Localizacao localizacao) {
        super(localizacao, campo);
        idade = 0;
        setLocalizacao(localizacao);
        if (randomAge) {
            idade = rand.nextInt(IDADE_MAXIMA);
        }
    }

    public void corre(List<Animal> novasOvelhas) {
        incrementaIdade();
        if (estaVivo()) {
            daALuz(novasOvelhas);
            Localizacao newLocalizacao = getCampo().localizacaoAdjacenteLivre(getLocalizacao());
            if (newLocalizacao != null) {
                setLocalizacao(newLocalizacao);
            } else {
                setMorte();
            }
        }
    }

    private void incrementaIdade() {
        idade++;
        if (idade > IDADE_MAXIMA) {
            this.setMorte();
        }
    }

    private void daALuz(List<Animal> novasOvelhas) {
        List<Localizacao> livre = getCampo().localizacoesAdjacentesLivres(getLocalizacao());
        int nascimentos = procria();
        for (int b = 0; b < nascimentos; b++) {
            if (livre.size() > 0) {
                Localizacao loc = livre.remove(0);
                Ovelha jovem = new Ovelha(false, getCampo(), loc);
                novasOvelhas.add(jovem);
            }
        }
    }

    protected int procria() {
        int nascimentos = 0;
        if (podeProcriar() && rand.nextDouble() < PROBABILIDADE_PROCRIACAO) {
            nascimentos = rand.nextInt(TAMANHO_MAXIMO_NINHADA) + 1;
        }
        return nascimentos;
    }

    protected boolean podeProcriar() {
        return idade >= IDADE_PROCRIACAO;
    }
}
