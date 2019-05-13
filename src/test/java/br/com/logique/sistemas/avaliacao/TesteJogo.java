package br.com.logique.sistemas.avaliacao;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class TesteJogo {
	
	private Jogo jogo;

	@Before
	public void CriarJogo(){
		jogo = new Jogo();	
		
		Jogador jogador1 = new Jogador(1, "Jogador 1");
		Jogador jogador2 = new Jogador(2, "Jogador 2");
		
		jogo = new Jogo();		
		jogo.setJogador1(jogador1);
		jogo.setJogador2(jogador2);
		jogo.setNumeroDepartidas(1);	
	} 	

	@Test
	public void pedraGanhadDaTesouraJogador1() {
		jogo.getJogador1().setEscolhaSimboloJogado(Jogo.PEDRA);
		jogo.getJogador2().setEscolhaSimboloJogado(Jogo.TESOURA);
		jogo.realizarJogada();
		assertTrue(jogo.getJogador1().venceu());
	}
	
	@Test
	public void pedraGanhaDaTesouraJogador2() {
		jogo.getJogador1().setEscolhaSimboloJogado(Jogo.TESOURA);
		jogo.getJogador2().setEscolhaSimboloJogado(Jogo.PEDRA);
		jogo.realizarJogada();
		assertTrue(jogo.getJogador2().venceu());
	}
	
	@Test
	public void tesouraGanhaDoPapelJogador1() {
		jogo.getJogador1().setEscolhaSimboloJogado(Jogo.TESOURA);
		jogo.getJogador2().setEscolhaSimboloJogado(Jogo.PAPEL);
		jogo.realizarJogada();
		assertTrue(jogo.getJogador1().venceu());
	}
	
	@Test
	public void tesouraGanhaDoPapelJogador2() {
		jogo.getJogador1().setEscolhaSimboloJogado(Jogo.PAPEL);
		jogo.getJogador2().setEscolhaSimboloJogado(Jogo.TESOURA);
		jogo.realizarJogada();
		assertTrue(jogo.getJogador2().venceu());
	}
	
	@Test
	public void papelGanhaDaPedraJogador1() {
		jogo.getJogador1().setEscolhaSimboloJogado(Jogo.PAPEL);
		jogo.getJogador2().setEscolhaSimboloJogado(Jogo.PEDRA);
		jogo.realizarJogada();
		assertTrue(jogo.getJogador1().venceu());
	}
	
	@Test
	public void papelGanhaDaPedraJogador2() {
		jogo.getJogador1().setEscolhaSimboloJogado(Jogo.PEDRA);
		jogo.getJogador2().setEscolhaSimboloJogado(Jogo.PAPEL);
		jogo.realizarJogada();
		assertTrue(jogo.getJogador2().venceu());		
	}
		
	@Test
	public void eJogadaEmpatada() {
		jogo.getJogador1().setEscolhaSimboloJogado(Jogo.PAPEL);
		jogo.getJogador2().setEscolhaSimboloJogado(Jogo.PAPEL);
		jogo.realizarJogada();
		assertTrue(jogo.jogadaEmpatada());		
	}
}
