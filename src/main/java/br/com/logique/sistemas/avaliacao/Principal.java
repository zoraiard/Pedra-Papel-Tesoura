package br.com.logique.sistemas.avaliacao;

public class Principal {

	private static Jogo jogo;
		
	
	public static void main(String[] args) {	
		inicializaJogo();		
		int guardajogadaAnterior = 0;
	
		for (int i = 1; i <= jogo.getNumeroDepartidas(); i++) {
			jogo.getJogador1().setEscolhaSimboloJogado(Jogo.PAPEL);
			
			if (guardajogadaAnterior == Jogo.PEDRA){
				jogo.getJogador2().setEscolhaSimboloJogado(Jogo.sortearSimbolos(true));
			}else {
				jogo.getJogador2().setEscolhaSimboloJogado(Jogo.sortearSimbolos(false));
			}
			guardajogadaAnterior = jogo.getJogador2().getEscolhaSimboloJogado();
			jogo.realizarJogada();		
		}				
		mostrarResultados();
	};		
			
	private static void inicializaJogo() {
		Jogador jogador1 = new Jogador(1, "João");
		Jogador jogador2 = new Jogador(2, "Maria");
		
		jogo = new Jogo();		
		jogo.setJogador1(jogador1);
		jogo.setJogador2(jogador2);
		jogo.setNumeroDepartidas(100);		
	}
		
	private static void mostrarResultados() {
		System.out.println("# ################## PARTIDAS ENCERRADAS ############### #");
		
		String  resultadoFinal =  jogo.getJogador1().getNome() +" "+jogo.getJogador1().getNumeroJogosGanhos()  + " X " + 
							      jogo.getJogador2().getNome() +" "+jogo.getJogador2().getNumeroJogosGanhos() ;
		
		String str ="=========================================================="  + "\n"
				+ "Número de Partidas: "   + jogo.getNumeroDepartidas() + "\n"
				+ "Número de Empates : "   + jogo.getNumeroDeEmpates()+ "\n"
				+ " "+ "\n"
				+ "Número de Jogos Ganhos:   " +  jogo.getNumeroDeJogosGanhos()+"\n"
				+ "Número de Jogos Perdidos: " +  jogo.getNumeroDeJogosPerdidos()+"\n"
				+ " "+ "\n"
				+ "Resultado Final : " + resultadoFinal  + "\n"
				+ "Jogador Vencedor: " + jogo.getVencedor()  + "\n"
				+ "==========================================================" + "\n";
		System.out.println(str);
	}
	
}
