package main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class MainTest {
    
    private Main jogo;

    @Test 
    public void testEmapte(){
        jogo = new Main();
        assertEquals(0, jogo.jogar(1,1));
        assertEquals(0, jogo.jogar(2,2));
        assertEquals(0, jogo.jogar(3,3));
    }

    @Test 
    public void testVitoriaJogador1(){
        jogo = new Main();
        assertEquals(1, jogo.jogar(1,2));
        assertEquals(1, jogo.jogar(2,3));
        assertEquals(1, jogo.jogar(3,1));
    }

    @Test 
    public void testVitoriaJogador2(){
        jogo = new Main();
        assertEquals(2, jogo.jogar(2,1));
        assertEquals(2, jogo.jogar(3,2));
        assertEquals(2, jogo.jogar(1,3));
    }


    @Test 
    public void testEntradaInvalida(){
        jogo = new Main();
        assertEquals(-1, jogo.jogar(0,4));
        assertEquals(-1, jogo.jogar(7,20));
        assertEquals(-1, jogo.jogar(83,-2));
    }
}
