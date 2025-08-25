package calculadora;


import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois n�meros")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	

	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}

	
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exce��o n�o lan�ada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}

	@Test
	public void testSubtracao() {
		int subtracao = calc.subtracao(8, 3);
		assertTrue(subtracao == 5);
	}

	@Test
	public void testMultiplicacaoPorZero() {
		int multiplicacao = calc.multiplicacao(20, 0);
		assertTrue(multiplicacao == 0);
	}

	@Test
	public void testNumPositivo(){
		boolean resposta = calc.ehPositivo(-50);
		assertFalse(resposta);
	}

	@Test
	public void testComparaNumeros() {
		int a = 2;
		int b = 20;

		int comparacao = calc.compara(2, 20);
		assertTrue(comparacao == -1);
	}

	@Test
	public void testSomatoria(){
		int n = 2;
		int respostaSomatoria = calc.somatoria(n);
		assertTrue(respostaSomatoria == 3);

	}
}
