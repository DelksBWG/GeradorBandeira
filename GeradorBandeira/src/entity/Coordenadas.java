package entity;

public class Coordenadas {
	private float x = 0, y = 0, xBase = 0, yBase = 0, tamanho = 1;
	public Coordenadas(float xPadrao, float yPadrao) {
		alterarCoordenadas(xPadrao, yPadrao);
	}
	
	public void mudarTamanho(float novoTamanho) {
		tamanho = novoTamanho;
		carregarCoordenadas();
	}
	
	public void alterarCoordenadas(float xNovo, float yNovo) {
		xBase = xNovo;
		yBase = yNovo;
		carregarCoordenadas();
	}
	
	public void carregarCoordenadas() {
		this.setX(xBase*tamanho);
		this.setY(yBase*tamanho);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public String toString() {
		return "X = " + this.getX() + ", Y =" + this.getY();
	}
}
