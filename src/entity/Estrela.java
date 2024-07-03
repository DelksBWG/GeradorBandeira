package entity;

public class Estrela extends FormatoGeo {

	//Ponta superior, exatamente no meio X e na ponta superior Y
	//Pontas do lado, exatamente no meio Y e nas pontas esquerda e direita respectivamente X
	//Pontas inferiores, pontas inferiores Y e 2/4 e 3/4 X
		
	
	public Estrela(Coordenadas tamanho) {
		super(criarLinhas(tamanho));
	}
	
	public static Linha[] criarLinhas(Coordenadas tamanho) {
		Coordenadas[] coordenadasPontos = new Coordenadas[5]; //DireitaMeio, Superior, EsquerMeio, EsquerBaixo, DireitaBaixo
		for(float i = 0; i < coordenadasPontos.length; i++) {
		float angulo = (float) Math.toRadians(((i/coordenadasPontos.length) * 360f)-18);
		
		Coordenadas pontoInicial = new Coordenadas((float) (Math.cos(angulo)*tamanho.getX()/2)-5.3661964E-8f, (float) Math.sin(angulo)*tamanho.getY()/2);
		coordenadasPontos[(int) i] = pontoInicial;
		} 
		Linha linhaCimaEsquerda = new Linha(coordenadasPontos[4], coordenadasPontos[2]); // \
		Linha linhaCimaDireita = new Linha(coordenadasPontos[4], coordenadasPontos[1]); // /
		Linha linhaMeio = new Linha(coordenadasPontos[3], coordenadasPontos[0]); // -
		Linha linhaDireitaEsquerda = new Linha(coordenadasPontos[0], coordenadasPontos[2]); // /
		Linha linhaEsquerdaDireita = new Linha(coordenadasPontos[3], coordenadasPontos[1]); // \	
		
		Linha[] linhas = {linhaCimaEsquerda, linhaCimaDireita, linhaMeio, linhaDireitaEsquerda, linhaEsquerdaDireita};
		
		linhas = interseccionarLinhas(linhas);
		
		return linhas;
	}
	
	
	
	private static Linha[] interseccionarLinhas(Linha[] linhas) {
		Linha [] linhasComInterseccoes = new Linha[10];
		Coordenadas[] coordenadasInterseccoes = new Coordenadas[10];
		int indiceAtual = 0;
		for(int i = 0; i < linhas.length; i++) {
			for(int j = 0; j < linhas.length; j++) {
				if(j != i) {
				float[] equacaoI = linhas[i].equacaoReta();
				float[] equacaoJ = linhas[j].equacaoReta();
				
				float determinante = equacaoI[0]*equacaoJ[1] - equacaoJ[0]*equacaoI[1];
				
				if (determinante != 0) { //Linhas não são paralelas
					float x = (equacaoJ[1]*equacaoI[2] - equacaoI[1]*equacaoJ[2])/determinante;
					float y = (equacaoI[0]*equacaoJ[2] - equacaoJ[0]*equacaoI[2])/determinante;
					Coordenadas coordenadasAtuais = new Coordenadas(x, y);
					if(!coordenadasAtuais.estaNoArray(coordenadasInterseccoes)) {
						coordenadasInterseccoes[indiceAtual] = coordenadasAtuais;
						indiceAtual++;
					}
				}
				}
			}
		}
		
		linhasComInterseccoes[0] = new Linha(coordenadasInterseccoes[0], coordenadasInterseccoes[1]); //MeioEsquerdaCima
		linhasComInterseccoes[1] = new Linha(coordenadasInterseccoes[1], coordenadasInterseccoes[8]); //EsquerdaCima
		linhasComInterseccoes[2] = new Linha(coordenadasInterseccoes[8], coordenadasInterseccoes[3]); //EsquerdaMeio
		linhasComInterseccoes[3] = new Linha(coordenadasInterseccoes[3], coordenadasInterseccoes[2]); //EsquerdaBaixo
		
		linhasComInterseccoes[4] = new Linha(coordenadasInterseccoes[2], coordenadasInterseccoes[9]); //MeioEsquerdaBaixo
		linhasComInterseccoes[5] = new Linha(coordenadasInterseccoes[9], coordenadasInterseccoes[6]); //MeioDireitaBaixo
		
		linhasComInterseccoes[6] = new Linha(coordenadasInterseccoes[6], coordenadasInterseccoes[5]); //DireitaBaixo
		linhasComInterseccoes[7] = new Linha(coordenadasInterseccoes[5], coordenadasInterseccoes[7]); //DireitaMeio
		linhasComInterseccoes[8] = new Linha(coordenadasInterseccoes[7], coordenadasInterseccoes[4]); //DireitaCima
		linhasComInterseccoes[9] = new Linha(coordenadasInterseccoes[4], coordenadasInterseccoes[0]); //MeioDireitaCima
		
		return linhasComInterseccoes;
	}

}
