package entity;

public class Linha {
	private Coordenadas inicio = new Coordenadas(0,0), fim = new Coordenadas(0,0);
	public Linha(Coordenadas inicioCoor, Coordenadas fimCoor) {
		inicio.alterarCoordenadas(inicioCoor.getX(), inicioCoor.getY());
		fim.alterarCoordenadas(fimCoor.getX(), fimCoor.getY());
	}
	public void mudarTamnanho(float tamanho) {
		inicio.mudarTamanho(tamanho);
		fim.mudarTamanho(tamanho);
	}
	public void AumentarLinha(float x, float y) { //Aumenta a linha até a coordenada especificada
		fim.alterarCoordenadas(x, y);
	}
	
	public void AlterarInicio(float x, float y) { //Muda o lugar onde a linha começa
		inicio.alterarCoordenadas(x, y);
	}
	
	public float DistanciaVertical() {
		return Math.abs(fim.getY() - inicio.getY());
	}
	
	public float DistanciaHorizontal() {
		return Math.abs(fim.getX() - inicio.getX());
	}
	
	public float[][] todosPontos() {
		float[][] pontos = new float[(int) this.DistanciaVertical()][(int) this.DistanciaHorizontal()];
	    return pontos;
	}
	
	public Coordenadas getInicio() {
		return inicio;
	}
	
	public Coordenadas getFim() {
		return fim;
	}
	
	public String toString() {
		String inicioString = "Inicio: " + inicio.getX() + ", " + inicio.getY();
		String fimString = "Fim: " + fim.getX() + ", " + fim.getY();
		return inicioString + "\n" + fimString;
	}
	
	public float[] equacaoReta() {
		float a = fim.getY() - inicio.getY();
		float b = inicio.getX() - fim.getX();
		float c = a*(inicio.getX()) + b*(inicio.getY());
		float[] abc = {a, b, c};
		return abc;
	}
}
