import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Esta classe gera um gráfico contendo a simulação em uma grade.
 */
public class SimuladorTela extends JFrame
{
    private static final Color COR_VAZIA = Color.white;
    private static final Color COR_INDEFINIDA = Color.gray;

    private final String PREFIXO_ETAPA = "Etapa: ";
    private final String PREFIXO_POPULACAO = "Populacao: ";
    private JLabel rotuloEtapa, populacao;
    private VisaoCampo visaoCampo;
    
    private Map<Class, Color> cores;
    private CampoEstatistica estatisticas;

    /**
     * Este método cria uma tela com a profundidade e largura requerida.
     * @param profundidade a profundidade da simulação.
     * @param largura a largura da simulação.
     */
    public SimuladorTela(int profundidade, int largura)
    {
        this.init(profundidade, largura);
    }

    private void init(int profundidade, int largura) {
        estatisticas = new CampoEstatistica();
        cores = new LinkedHashMap<Class, Color>();

        setTitle("Simulacao Ovelhas and Lobos Guara");
        rotuloEtapa = new JLabel(PREFIXO_ETAPA, JLabel.CENTER);
        populacao = new JLabel(PREFIXO_POPULACAO, JLabel.CENTER);

        setLocation(100, 50);

        visaoCampo = new VisaoCampo(profundidade, largura);

        Container conteudos = getContentPane();
        conteudos.add(rotuloEtapa, BorderLayout.NORTH);
        conteudos.add(visaoCampo, BorderLayout.CENTER);
        conteudos.add(populacao, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    /**
     * Este método define a cor a ser usada para cada tipo de animal.
     * @param animalClass o objeto da classe do animal requerido.
     * @param color a cor a ser usada para a classe de animal requerida.
     */
    public void setCor(Class animalClass, Color color)
    {
        cores.put(animalClass, color);
    }

    /**
     * Este método retorna a cor a ser usada para tal classe de animal.
     * @param animalClass
     * @return
     */
    private Color getCor(Class animalClass)
    {
        Color coluna = cores.get(animalClass);
        if(coluna == null) {
            return COR_INDEFINIDA;
        }
        else {
            return coluna;
        }
    }

    /**
     * Este método mostra a status atual do campo.
     * @param etapa
     * @param campo
     */
    public void mostraStatus(int etapa, Campo campo)
    {
        if(!isVisible()) {
            setVisible(true);
        }
        
        rotuloEtapa.setText(PREFIXO_ETAPA + etapa);
        estatisticas.redefine();
        
        visaoCampo.preparaPintura();

        for(int row = 0; row < campo.getProfundidade(); row++) {
            for(int col = 0; col < campo.getLargura(); col++) {
                Object animal = campo.pegarAnimalNaPosicao(row, col);
                if(animal != null) {
                    estatisticas.incrementaContador(animal.getClass());
                    visaoCampo.marcaDesenho(col, row, getCor(animal.getClass()));
                }
                else {
                    visaoCampo.marcaDesenho(col, row, COR_VAZIA);
                }
            }
        }
        estatisticas.contadorFinalizado();

        populacao.setText(PREFIXO_POPULACAO + estatisticas.capturaDetalhesPolulacao(campo));
        visaoCampo.repaint();
    }

    /**
     * Este método determina se a simulação deve continuar ou não.
     * @param campo
     * @return
     */
    public boolean ehViavel(Campo campo)
    {
        return estatisticas.ehViavel(campo);
    }

    /**
     * Esta classe gera um gráfico de uma grade retangular.
     */
    private class VisaoCampo extends JPanel
    {
        private final int GRID_VIEW_SCALING_FACTOR = 6;

        private int larguraGrade, profundidadeGrade;
        private int xScala, yScala;
        Dimension tamanho;
        private Graphics g;
        private Image imagemCampo;

        /**
         * Este método cria uma nova dimensão.
         * @param profundidade
         * @param largura
         */
        public VisaoCampo(int profundidade, int largura)
        {
            profundidadeGrade = profundidade;
            larguraGrade = largura;
            tamanho = new Dimension(0, 0);
        }

        /**
         * Este método define quão grande deve ser o gráfico.
         * @return
         */
        @Override
        public Dimension getPreferredSize()
        {
            return new Dimension(larguraGrade * GRID_VIEW_SCALING_FACTOR,
                    profundidadeGrade * GRID_VIEW_SCALING_FACTOR);
        }

        /**
         * Este método prepara para uma nova geração de coloração de gráfico.
         */
        public void preparaPintura()
        {
            if(! tamanho.equals(getSize())) {
                tamanho = getSize();
                imagemCampo = visaoCampo.createImage(tamanho.width, tamanho.height);
                g = imagemCampo.getGraphics();

                xScala = tamanho.width / larguraGrade;
                if(xScala < 1) {
                    xScala = GRID_VIEW_SCALING_FACTOR;
                }
                yScala = tamanho.height / profundidadeGrade;
                if(yScala < 1) {
                    yScala = GRID_VIEW_SCALING_FACTOR;
                }
            }
        }

        /**
         * Este método colore a localização do campo, com a cor requerida.
         * @param x
         * @param y
         * @param color
         */
        public void marcaDesenho(int x, int y, Color color)
        {
            g.setColor(color);
            g.fillRect(x * xScala, y * yScala, xScala-1, yScala-1);
        }

        /**
         * Este método copia a imagem interna para a leta.
         * @param g
         */
        @Override
        public void paintComponent(Graphics g)
        {
            if(imagemCampo != null) {
                Dimension currentSize = getSize();
                if(tamanho.equals(currentSize)) {
                    g.drawImage(imagemCampo, 0, 0, null);
                }
                else {
                    g.drawImage(imagemCampo, 0, 0, currentSize.width, currentSize.height, null);
                }
            }
        }
    }
}
