package telas;

import java.awt.Color;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import entity.*;
import util.CentroAfricana;

public class TelaBandeira extends JFrame implements ChangeListener{
	
	private static final long serialVersionUID = 1050738591862959244L;

	private JButton bCriar = new JButton("Colorir/Descolorir");
	private JPanel pBotao = new JPanel(); //Painel para botões
	private PainelDesenho pDesenho	= null; //Painel para desenhar
	private JPanel pMain = new JPanel(); //Painel background
	private JPanel pSlider = new JPanel(); //Painel para o slider
	private JSlider slider = new JSlider(); //Slider para o tamanho
	private final static int minimoTamanho = 0;
	private final static int maximoTamanho = 100;
	private final static int inicialTamanho = 10;
	public TelaBandeira() {
		super("Gerador de Bandeira");
		FormatoGeo[] formatos = CentroAfricana.criarBandeira();
		setpDesenho(new PainelDesenho(new Retangulo(new Coordenadas(60.0f, 40.0f)), formatos));
		setResizable(false);
	    setSize(800, 600);
	    setLocation(350,100);
	    bCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	pDesenho.alterarCor();
            }
        });
	    pMain.setBackground(Color.black);
	    pMain.setBounds(getX(), getY(), getWidth(), getHeight());
	    pBotao.setBackground(Color.black);
	    pBotao.setBounds(500, 10,100,50);
	    pBotao.add(bCriar);
	    pDesenho.setBackground(Color.lightGray);
	    pDesenho.setBounds(10, 100, 765, 410);
	    
	    slider = new JSlider(JSlider.HORIZONTAL, minimoTamanho, maximoTamanho, inicialTamanho);
        slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setLabelTable(slider.createStandardLabels(10));
	    slider.addChangeListener(this);
        
	    pSlider.setBackground(Color.black);
	    pSlider.setBounds(70, 10,200,50);
	    
	    pSlider.add(slider);
	    add(pDesenho);
	    add(pSlider);
	    add(pBotao);
	    add(pMain);
	    setVisible(true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public PainelDesenho getpDesenho() {
		return pDesenho;
	}
	public void setpDesenho(PainelDesenho pDesenho) {
		this.pDesenho = pDesenho;
	}
	
	/** Listen to the slider. */
	public void stateChanged(ChangeEvent e) {
	JSlider source = (JSlider)e.getSource();
	if (!source.getValueIsAdjusting()) {
	float valor = (int)source.getValue();
	getpDesenho().alterarTamanho(valor/10);
	}
	}

}
