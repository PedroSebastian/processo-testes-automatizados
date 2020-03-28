import java.awt.Color;

/**
 * Esta classe fornece um contador para um tipo de animal na simulação.
 */
public class Contador
{
    private String name;
    private int count;

    /**
     * Este método fornece o nome do tipo do animal.
     * @param name o nome do animal.
     */
    public Contador(String name)
    {
        this.name = name;
        count = 0;
    }

    /**
     * Este método retorna o nome do animal.
     * @return nome do animal.
     */
    public String getNome()
    {
        return name;
    }

    /**
     * Este método retorna a atual contagem do tipo de animal da simulação.
     * @return a contagem do animal.
     */
    public int getContador()
    {
        return count;
    }

    /**
     * Incrementa a contagem de um em um.
     */
    public void incrementa()
    {
        count++;
    }

    /**
     * Reseta a contagem.
     */
    public void reseta()
    {
        count = 0;
    }
}
