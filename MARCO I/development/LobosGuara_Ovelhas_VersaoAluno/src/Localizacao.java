/**
 * Esta classe representa a localização dentro do campo.
 */
public class Localizacao
{
    private int linha;
    private int coluna;

    /**
     * Este método representa linha e coluna.
     * @param linha a linha do campo.
     * @param coluna a coluna do campo.
     */
    public Localizacao(int linha, int coluna)
    {
        if (linha < 0 || coluna < 0) {
            throw new IllegalArgumentException("A Localização não pode receber valores negativos!");
        }

        this.linha = linha;
        this.coluna = coluna;
    }

    /**
     * Este método implementa a igualdade das linhas e colunas.
     * @param obj
     * @return
     */
    public boolean equals(Object obj)
    {
        if(obj instanceof Localizacao) {
        	Localizacao outra = (Localizacao) obj;
            return linha == outra.getLinha() && coluna == outra.getColuna();
        }
        else {
            return false;
        }
    }

    /**
     * Este método retorna uma string da representação da localização.
     * @return
     */
    public String toString()
    {
        return linha + "," + coluna;
    }

    /**
     * Este método retorna um hashcode para a localização.
     * @return
     */
    public int hashCode()
    {
        return (linha << 16) + coluna;
    }

    /**
     * Este método retorna a linha.
     * @return
     */
    public int getLinha()
    {
        return linha;
    }

    /**
     * Este método retorna a coluna.
     * @return
     */
    public int getColuna()
    {
        return coluna;
    }
}
