package util;

import entity.Coordenadas;
import entity.Estrela;
import entity.FormatoGeo;
import entity.Linha;
import entity.Retangulo;

public class CentroAfricana {
	public static FormatoGeo[] criarBandeira() {
		FormatoGeo[] formatos = {new Retangulo(new Coordenadas(60.0f, 10.0f)), new Retangulo(new Coordenadas(60.0f, 10.0f)), new Retangulo(new Coordenadas(60.0f, 10.0f)), new Retangulo(new Coordenadas(60.0f, 10.0f)), new Retangulo(new Coordenadas(10.0f, 40.0f)), new Estrela(new Coordenadas(9f, 9f))};
		float baixo = 0.5f;
		float cima = -9.5f;
		for(int i = 0; i < formatos.length-2; i++) {
		baixo += 10;
		cima += 10;
		FormatoGeo retangulo = formatos[i];
		Linha linhaBaixo = retangulo.getLinhas()[0];
		Linha linhaCima = retangulo.getLinhas()[1];
		Linha linhaDireita = retangulo.getLinhas()[2];
		Linha linhaEsquer = retangulo.getLinhas()[3];
		linhaBaixo.AlterarInicio(linhaBaixo.getInicio().getX(), baixo);
		linhaBaixo.AumentarLinha(linhaBaixo.getFim().getX(), baixo);
		linhaCima.AlterarInicio(linhaCima.getInicio().getX(), cima);
		linhaCima.AumentarLinha(linhaCima.getFim().getX(), cima);
		linhaDireita.AlterarInicio(linhaDireita.getInicio().getX(), baixo);
		linhaDireita.AumentarLinha(linhaDireita.getFim().getX(), cima);
		linhaEsquer.AlterarInicio(linhaEsquer.getInicio().getX(), cima);
		linhaEsquer.AumentarLinha(linhaEsquer.getFim().getX(), baixo);
		Linha[] linhas = {linhaBaixo, linhaCima, linhaDireita, linhaEsquer};
		retangulo.setLinhas(linhas);
		formatos[i] = retangulo;
		}
		
		
		FormatoGeo retangulo = formatos[4];
		Linha linhaBaixo = retangulo.getLinhas()[0];
		Linha linhaCima = retangulo.getLinhas()[1];
		Linha linhaDireita = retangulo.getLinhas()[2];
		Linha linhaEsquer = retangulo.getLinhas()[3];
		linhaBaixo.AlterarInicio(linhaBaixo.getInicio().getX()+25, linhaBaixo.getInicio().getY()+0.5f);
		linhaBaixo.AumentarLinha(linhaBaixo.getFim().getX()+25, linhaBaixo.getFim().getY()+0.5f);
		linhaCima.AlterarInicio(linhaCima.getInicio().getX()+25, linhaCima.getInicio().getY()+0.5f);
		linhaCima.AumentarLinha(linhaCima.getFim().getX()+25, linhaCima.getFim().getY()+0.5f);
		linhaDireita.AlterarInicio(linhaDireita.getInicio().getX()+25, linhaDireita.getInicio().getY()+0.5f);
		linhaDireita.AumentarLinha(linhaDireita.getFim().getX()+25, linhaDireita.getFim().getY()+0.5f);
		linhaEsquer.AlterarInicio(linhaEsquer.getInicio().getX()+25, linhaEsquer.getInicio().getY()+0.5f);
		linhaEsquer.AumentarLinha(linhaEsquer.getFim().getX()+25, linhaEsquer.getFim().getY()+0.5f);
		Linha[] linhas = {linhaBaixo, linhaCima, linhaDireita, linhaEsquer};
		retangulo.setLinhas(linhas);
		formatos[4] = retangulo;
		
		
		Estrela estrela = (Estrela) formatos[formatos.length-1];
		
		//Linha linhaCimaEsquerda = estrela.getLinhas()[0]; // \
		//Linha linhaCimaDireita = estrela.getLinhas()[1]; // /
		//Linha linhaMeio = estrela.getLinhas()[2]; // -
		//Linha linhaDireitaEsquerda = estrela.getLinhas()[3]; // /
		//Linha linhaEsquerdaDireita = estrela.getLinhas()[4]; // \
		
		
		
		//Linha[] linhas = {linhaCimaEsquerda, linhaCimaDireita, linhaMeio, linhaDireitaEsquerda, linhaEsquerdaDireita};
		//estrela.setLinhas(linhas);
		linhas = estrela.getLinhas();
		for(int i = 0; i < linhas.length; i++) {
			Linha linhaAtual = linhas[i];
			linhaAtual.AlterarInicio(linhaAtual.getInicio().getX()+10, linhaAtual.getInicio().getY()+5.5f);
			linhaAtual.AumentarLinha(linhaAtual.getFim().getX()+10, linhaAtual.getFim().getY()+5.5f);
			linhas[i] = linhaAtual;
		}
		estrela.setLinhas(linhas);
		formatos[formatos.length-1] = estrela;
		return formatos;
	}
}
