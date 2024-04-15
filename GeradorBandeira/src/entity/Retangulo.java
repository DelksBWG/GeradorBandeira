package entity;

public class Retangulo extends FormatoGeo {

	public Retangulo(Coordenadas tamanho) {
		super(criarLinhas(tamanho));
	}
	
	public static Linha[] criarLinhas(Coordenadas tamanho) {
		Coordenadas pontaEsquerBaixo = new Coordenadas(0.0f, 0.0f);
		Coordenadas pontaDireitaBaixo = new Coordenadas(tamanho.getX(), 0.0f);
		Coordenadas pontaDireitaCima = tamanho;
		Coordenadas pontaEsquerCima = new Coordenadas(0.0f, tamanho.getY());
		Linha linhaBaixo = new Linha(pontaEsquerBaixo, pontaDireitaBaixo);
		Linha linhaDireita = new Linha(pontaDireitaBaixo, pontaDireitaCima);
		Linha linhaCima = new Linha(pontaDireitaCima, pontaEsquerCima);
		Linha linhaEsquer = new Linha(pontaEsquerCima, pontaEsquerBaixo);
		Linha[] linhas = {linhaBaixo, linhaCima, linhaDireita, linhaEsquer};
		return linhas;
	}
	
	public void mudarEscala(float tamanho) {
		for(int i = 0; i < linhas.length; i++) {
			linhas[i].mudarTamnanho(tamanho);
		}
	}
	
	
	public String mostrar() {
		String imagem = "";
		//Começar pela linha de cima
		for(int i = 0; i < Math.ceil(pegarTamanhoX(1)); i++) {
			imagem += ". ";
		}
		//Ir para os lados esquerdo e direito
		for(int i = 0; i < Math.ceil(pegarTamanhoY(3))-2; i++) {
			imagem += "\n.";
			for(int o = 0; o < Math.ceil(pegarTamanhoX(1))-2; o++) {
				imagem += " .";
			}
			imagem += " .";
		}
		//Terminar embaixo
		imagem += "\n";
		for(int i = 0; i < Math.ceil(pegarTamanhoX(1)); i++) {
			imagem += ". ";
		}
		return imagem;
	}

}
