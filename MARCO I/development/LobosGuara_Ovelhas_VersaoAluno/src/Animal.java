import java.util.List;

/**
 * Created by Esther Favero on 01/09/2017.
 */
public abstract class Animal {

    private boolean vivo;
    private Localizacao localizacao;
    private Campo campo;

    public Animal(Localizacao localizacao, Campo campo) {
        vivo = true;
        this.campo = campo;
        setLocalizacao(localizacao);
    }

    public boolean estaVivo() {
        return vivo;
    }

    public void setMorte() {
        vivo = false;
        if (localizacao != null) {
            campo.limpa(localizacao);
            localizacao = null;
            campo = null;
        }
    }

    public void setLocalizacao(Localizacao newLocalizacao) {
        if (localizacao != null) {
            campo.limpa(localizacao);
        }
        localizacao = newLocalizacao;
        try {
            campo.lugar(this, newLocalizacao);
        } catch (ObjetoInvalidoException e) {
            e.printStackTrace();
        }
    }

    abstract public void corre(List<Animal> novosAnimais);

    public Campo getCampo() {
        return this.campo;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    protected abstract int procria();

    protected abstract boolean podeProcriar();

}
