package entity;

public class FormatoGeo {
	protected Linha[] linhas = new Linha[0];
	
	public FormatoGeo(Linha[] linhasCriadas) {
		setLinhas(linhasCriadas);
	}
	
	public void mudarEscala(float tamanho) {
		for(int i = 0; i < linhas.length; i++) {
			linhas[i].mudarTamnanho(tamanho);
		}
	}

	public Linha[] getLinhas() {
		return linhas;
	}

	public void setLinhas(Linha[] linhas) {
		this.linhas = linhas;
	}
	
	public float pegarTamanhoX(int index) {
		Linha linha = linhas[index];
		return linha.DistanciaHorizontal();
	}
	
	public float pegarTamanhoY(int index) {
		Linha linha = linhas[index];
		return linha.DistanciaVertical();
	}
	
	public String toString() {
		String toString = "";
		for(int i = 0; i < linhas.length; i++) {
			Linha linha = linhas[i];
			toString += "[" + linha.DistanciaHorizontal() + ", " + linha.DistanciaVertical() + "]\n";
		}
		return toString;
	}
	
}
