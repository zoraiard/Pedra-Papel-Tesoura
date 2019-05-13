package br.com.logique.sistemas.avaliacao;

public class Jogador {
	
	private int  id;
	private String nome;
	private int numeroJogosGanhos;
	private int numeroJogosPerdidos;
	private int escolhaSimboloJogado;
	private boolean venceu ;  
	
		
	public Jogador(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getNumeroJogosGanhos() {
		return numeroJogosGanhos;
	}

	public int getNumeroJogosPerdidos() {
		return numeroJogosPerdidos;
	}

	public int getEscolhaSimboloJogado() {
		return escolhaSimboloJogado;
	}

	public void setEscolhaSimboloJogado(int escolhaSimboloJogo) {
		this.escolhaSimboloJogado = escolhaSimboloJogo;
	}

	public boolean venceu() {
		return venceu;
	}

	public void setVenceu(boolean venceu) {
		this.venceu = venceu;
		if (this.venceu) {
			numeroJogosGanhos++;
		}else {
			numeroJogosPerdidos++;
		}
	}

}
