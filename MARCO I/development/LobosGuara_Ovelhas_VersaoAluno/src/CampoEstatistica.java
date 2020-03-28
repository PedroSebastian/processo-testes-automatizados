import java.util.HashMap;

/**
 * Esta classe coleta e fornece dados estatisticos de um campo.
 */
public class CampoEstatistica
{
    private HashMap<Class, Contador> contadores;
    private boolean contadoresValidos;

    /**
     * Este método constrói um objeto do tipo CampoEstatistica.
     */
    public CampoEstatistica()
    {
        contadores = new HashMap<Class, Contador>();
        contadoresValidos = true;
    }

    /**
     *Este método captura os detalhes do que há no campo.
     * @param campo
     * @return uma string mostrando o que há no campo.
     */
    public String capturaDetalhesPolulacao(Campo campo)
    {
        StringBuffer buffer = new StringBuffer();
        if(!contadoresValidos) {
            geraContadores(campo);
        }
        for(Class chave : contadores.keySet()) {
            Contador info = contadores.get(chave);
            buffer.append(info.getNome());
            buffer.append(": ");
            buffer.append(info.getContador());
            buffer.append(' ');
        }
        return buffer.toString();
    }

    /**
     * Este método reseta todos os contadores para zero.
     */
    public void redefine()
    {
        contadoresValidos = false;
        for(Class chave : contadores.keySet()) {
            Contador contador = contadores.get(chave);
            contador.reseta();
        }
    }

    /**
     * Incrementa o contador para uma classe de animal.
     * @param animalClass
     */
    public void incrementaContador(Class animalClass)
    {
        Contador contador = contadores.get(animalClass);
        if(contador == null) {
            contador = new Contador(animalClass.getName());
            contadores.put(animalClass, contador);
        }
        contador.incrementa();
    }

    /**
     * Este método mostra que o contador, para um tipo de animal, é finalizado.
     */
    public void contadorFinalizado()
    {
        contadoresValidos = true;
    }

    /**
     * Este método indica se a simulação ainda é viável, isto é, se a mesma
     * deve parar ou continuar.
     * @param campo
     * @return true se existe mais de uma espécie viva.
     */
    public boolean ehViavel(Campo campo)
    {
        int nonZero = 0;
        if(!contadoresValidos) {
            geraContadores(campo);
        }
        for(Class key : contadores.keySet()) {
            Contador info = contadores.get(key);
            if(info.getContador() > 0) {
                nonZero++;
            }
        }
        return nonZero > 1;
    }

    /**
     * Este método gera o número de lobos e ovelhas existentes.
     * @param campo o campo a ser gerado os dados estatísticos.
     */
    private void geraContadores(Campo campo)
    {
        redefine();
        for(int linha = 0; linha < campo.getProfundidade(); linha++) {
            for(int coluna = 0; coluna < campo.getLargura(); coluna++) {
                Object animal = campo.pegarAnimalNaPosicao(linha, coluna);
                if(animal != null) {
                    incrementaContador(animal.getClass());
                }
            }
        }
        contadoresValidos = true;
    }
}
