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
	
	public void BasePrint() {
		System.out.println(xBase + ", " + yBase);
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
	
	public boolean estaNoArray(Coordenadas[] coordenadas) {
		boolean esta = false;
		for(int i = 0; i < coordenadas.length; i++) {
			Coordenadas atual = coordenadas[i];
			if(atual != null) {
				if(atual.getX() == this.getX() && atual.getY() == this.getY()) {
				esta = true;
				}
			} 
		}
		return esta;
	}
}
