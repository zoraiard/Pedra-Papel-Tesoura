package br.com.logique.sistemas.avaliacao;

import java.util.Random;

public class Jogo {
	public static final int PEDRA   = 3;
	public static final int PAPEL   = 2;
	public static final int TESOURA = 1;
			
	private Jogador jogador1;
	private Jogador jogador2;
	
	private int numeroDePartidas;
	private int numeroDeEmpates = 0;
	private int numeroDeJogosGanhos = 0;
	private int numeroDeJogosPerdidos = 0;
	
	public Jogador getJogador1() {
		return jogador1;
	}
	
	public void setJogador1(Jogador jogador1) {
		this.jogador1 = jogador1;
	}

	public Jogador getJogador2() {
		return jogador2;
	}

	public void setJogador2(Jogador jogador2) {
		this.jogador2 = jogador2;
	}

	public int getNumeroDeEmpates() {
		return numeroDeEmpates;
	}
	
	public int getNumeroDeJogosGanhos() {
		return numeroDeJogosGanhos;
	}	
	
	public int getNumeroDeJogosPerdidos() {
		return numeroDeJogosPerdidos;
	}

	public void setNumeroDeJogosPerdidos(int numeroDeJogosPerdidos) {
		this.numeroDeJogosPerdidos = numeroDeJogosPerdidos;
	}
	
	public int getNumeroDepartidas() {
		return numeroDePartidas;
	}

	public void setNumeroDepartidas(int numeroDepartidas) {
		this.numeroDePartidas = numeroDepartidas;
	}

	public void realizarJogada() {
		setDescricaoJogadas();
		if (jogadaEmpatada()) {			
			this.numeroDeEmpates++;
			jogador1.setVenceu(false);
			jogador2.setVenceu(false);
		}else { 
			verificarEscolhasDosJogadores();
		}	
	}	
	
	public void setDescricaoJogadas(){
		int  escolhaJogado1 = jogador1.getEscolhaSimboloJogado();
		int  escolhaJogado2 = jogador2.getEscolhaSimboloJogado();
		
		jogador1.setDescricaoSimboloJogado(getDescricaoSimbolo(escolhaJogado1));
		jogador2.setDescricaoSimboloJogado(getDescricaoSimbolo(escolhaJogado2));
	
	}
		
	public boolean jogadaEmpatada() {
		return (jogador1.getEscolhaSimboloJogado() == jogador2.getEscolhaSimboloJogado());
	}

	public void verificarEscolhasDosJogadores() {
		
		int  escolhaJogado1 = jogador1.getEscolhaSimboloJogado();
		int  escolhaJogado2 = jogador2.getEscolhaSimboloJogado();
		
		jogador1.setDescricaoSimboloJogado(getDescricaoSimbolo(escolhaJogado1));
		jogador2.setDescricaoSimboloJogado(getDescricaoSimbolo(escolhaJogado2));
				
		if ((escolhaJogado1 == PEDRA   && escolhaJogado2 == TESOURA) || 
			(escolhaJogado1 == TESOURA && escolhaJogado2 == PAPEL)   || 
			(escolhaJogado1 == PAPEL   && escolhaJogado2 == PEDRA)) 
		{
			jogador1.setVenceu(true);
			jogador2.setVenceu(false);
		}			
		else{
			jogador1.setVenceu(false);
			jogador2.setVenceu(true);
		}
		numeroDeJogosGanhos++;
		numeroDeJogosPerdidos++;		
	}
	
	public static int sortearSimbolos(Boolean comPedra){
		Random simboloSorteado = new Random();
		if (comPedra) {
			return  simboloSorteado.nextInt(3) + 1;
		}else {
			return simboloSorteado.nextInt(2) + 1;
		}
	}
	
	public String getVencedor(){
		if (numeroDePartidas == 1){
			if  (jogadaEmpatada()){ 
				return "Jogo Empatado!"; 
			}
			return (jogador1.venceu()) ? jogador1.getNome() : jogador2.getNome();
			
		}else{
			if  ( jogador1.getNumeroJogosGanhos() == jogador2.getNumeroJogosGanhos()) { 
				return "Jogo Empatado!"; 
			}
			return (jogador1.getNumeroJogosGanhos() > jogador2.getNumeroJogosGanhos()) ? jogador1.getNome() : jogador2.getNome();
		}			
	}

	public String getVencedorPartidas(){
		if (jogadaEmpatada()){
			return "Empate!";
		}else {
			return (jogador1.venceu()) ? jogador1.getNome() : jogador2.getNome();
		}
	}

	public String getDescricaoSimbolo(int simboloJogado ) {
		String  descricao  = "";
		switch(simboloJogado){
		    case PEDRA: 
		    	descricao  = "PEDRA";
		    	 break;
		    case PAPEL: 
		    	descricao  = "PAPEL"; 
		        break;
		    case TESOURA: 
		    	descricao  = "TESOURA"; 
		        break;   
		}
		return descricao;		
	}
}

