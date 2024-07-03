package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

public class PainelDesenho  extends JPanel {
	private static final long serialVersionUID = 1L;
	Retangulo baseBandeira;
	FormatoGeo[] formatos;
	Color[] coresBandeira = {new Color(0, 48, 130), new Color(255, 255, 255), new Color(40, 151, 40), new Color(255, 206, 0), new Color(210, 16, 52)};
	boolean cheio = false;
	
	public PainelDesenho(Retangulo base, FormatoGeo[] formatosBase) {
		super();
		baseBandeira = base;
		formatos = formatosBase;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//g.fillRect(20, 20, 100, 200);
		Graphics2D g2d = (Graphics2D) g;
        
        for(int i = 0; i < formatos.length-1; i++) {//Desenhando retangulos
        FormatoGeo formato = formatos[i];
        Linha[] linhas = formato.getLinhas(); //Baixo, Cima, Direita, Esquerda
        int[] pontosX = {(int) linhas[0].getInicio().getX(), (int)linhas[2].getInicio().getX(), 
        (int) linhas[1].getInicio().getX(), (int) linhas[3].getInicio().getX(), 
        (int) linhas[0].getInicio().getX()};
        
        int[] pontosY = {(int) linhas[0].getInicio().getY(), (int)linhas[2].getInicio().getY(), 
                (int) linhas[1].getInicio().getY(), (int) linhas[3].getInicio().getY(), 
                (int) linhas[0].getInicio().getY()};
        
        
        g2d.setColor(coresBandeira[i]);
        g2d.drawPolygon(pontosX,pontosY,pontosX.length);
        if(cheio) {
        	g2d.fillPolygon(pontosX,pontosY,pontosX.length); //Filled Polygon
        }
        }
        
        FormatoGeo estrela = formatos[formatos.length-1];
        Linha[] linhas = estrela.getLinhas();
        g2d.setColor(coresBandeira[3]);
        
        int[] pontosX = {(int) linhas[0].getInicio().getX(), (int)linhas[0].getFim().getX(), 
                (int) linhas[1].getFim().getX(), (int) linhas[2].getFim().getX(), 
                (int) linhas[3].getFim().getX(), (int) linhas[4].getFim().getX(), 
                (int) linhas[5].getFim().getX(), (int) linhas[6].getFim().getX(), 
                (int) linhas[7].getFim().getX(), (int) linhas[8].getFim().getX(), 
                (int) linhas[9].getFim().getX()};
        
        int[] pontosY = {(int) linhas[0].getInicio().getY(), (int)linhas[0].getFim().getY(), 
                (int) linhas[1].getFim().getY(), (int) linhas[2].getFim().getY(), 
                (int) linhas[3].getFim().getY(), (int) linhas[4].getFim().getY(), 
                (int) linhas[5].getFim().getY(), (int) linhas[6].getFim().getY(), 
                (int) linhas[7].getFim().getY(), (int) linhas[8].getFim().getY(), 
                (int) linhas[9].getFim().getY()};

        g2d.drawPolygon(pontosX,pontosY,pontosX.length);
        if(cheio) {
        	g2d.fillPolygon(pontosX,pontosY,pontosX.length); //Filled Polygon
        }
        
        //Path2D polygon = new Path2D.Double();
        //polygon.moveTo(linhas[0].getInicio().getX(), linhas[0].getInicio().getY());
        //polygon.lineTo(linhas[0].getFim().getX(), linhas[0].getFim().getY());
        //polygon.lineTo(linhas[3].getInicio().getX(), linhas[3].getInicio().getY());
        //polygon.lineTo(linhas[2].getInicio().getX(), linhas[2].getInicio().getY());
        //polygon.lineTo(linhas[4].getFim().getX(), linhas[4].getFim().getY());
        //polygon.lineTo(linhas[1].getInicio().getX(), linhas[1].getInicio().getY());
        //polygon.closePath();
        //g2d.draw(polygon);
        
	}
	
	public void alterarTamanho(float porcentagem) {
		baseBandeira.mudarEscala(porcentagem);
		for(int i = 0; i < formatos.length; i++) {
			FormatoGeo formato = formatos[i];
			formato.mudarEscala(porcentagem);
			formatos[i] = formato;
		}
		revalidate();
		repaint();
	}
	
	public void alterarCor() {
		cheio = !cheio;
		revalidate();
		repaint();
	}
}
