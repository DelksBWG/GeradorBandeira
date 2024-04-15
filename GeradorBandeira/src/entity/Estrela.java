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
		Coordenadas pontoInicial = new Coordenadas((float) Math.cos(angulo)*tamanho.getX()/2, (float) Math.sin(angulo)*tamanho.getY()/2);
		coordenadasPontos[(int) i] = pontoInicial;
		} 
		Linha linhaCimaEsquerda = new Linha(coordenadasPontos[1], coordenadasPontos[3]); // \
		Linha linhaCimaDireita = new Linha(coordenadasPontos[1], coordenadasPontos[4]); // /
		Linha linhaMeio = new Linha(coordenadasPontos[2], coordenadasPontos[0]); // -
		Linha linhaDireitaEsquerda = new Linha(coordenadasPontos[0], coordenadasPontos[3]); // /
		Linha linhaEsquerdaDireita = new Linha(coordenadasPontos[2], coordenadasPontos[4]); // \	
		
		Linha[] linhas = {linhaCimaEsquerda, linhaCimaDireita, linhaMeio, linhaDireitaEsquerda, linhaEsquerdaDireita};
		
		return linhas;
	}

}
