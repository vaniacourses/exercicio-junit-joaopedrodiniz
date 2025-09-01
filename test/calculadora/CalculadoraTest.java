package calculadora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Classe de testes unitários para Calculadora")
public class CalculadoraTest {

    private Calculadora calc;

    @BeforeEach
    public void inicializa() {
        calc = new Calculadora();
    }

    // -------------------- soma --------------------
    @Test
    @DisplayName("Soma de dois números positivos")
    public void testSomaPositivos() {
        assertEquals(9, calc.soma(4, 5));
    }

    @Test
    @DisplayName("Soma envolvendo número negativo")
    public void testSomaComNegativo() {
        assertEquals(1, calc.soma(5, -4));
    }

    @Test
    @DisplayName("Soma com zero deve retornar o próprio número")
    public void testSomaComZero() {
        assertEquals(7, calc.soma(7, 0));
    }

    // -------------------- subtração --------------------
    @Test
    @DisplayName("Subtração resultando em positivo")
    public void testSubtracaoPositiva() {
        assertEquals(5, calc.subtracao(8, 3));
    }

    @Test
    @DisplayName("Subtração resultando em negativo")
    public void testSubtracaoNegativa() {
        assertEquals(-2, calc.subtracao(3, 5));
    }

    // -------------------- multiplicação --------------------
    @Test
    @DisplayName("Multiplicação de dois números positivos")
    public void testMultiplicacaoPositivos() {
        assertEquals(20, calc.multiplicacao(4, 5));
    }

    @Test
    @DisplayName("Multiplicação por zero")
    public void testMultiplicacaoPorZero() {
        assertEquals(0, calc.multiplicacao(20, 0));
    }

    @Test
    @DisplayName("Multiplicação por número negativo")
    public void testMultiplicacaoComNegativo() {
        assertEquals(-15, calc.multiplicacao(3, -5));
    }

    // -------------------- divisão --------------------
    @Test
    @DisplayName("Divisão exata de dois números")
    public void testDivisao() {
        assertEquals(2, calc.divisao(8, 4));
    }

    @Test
    @DisplayName("Divisão por zero deve lançar exceção")
    public void testDivisaoPorZero() {
        assertThrows(ArithmeticException.class, () -> calc.divisao(8, 0));
    }

    // -------------------- somatória --------------------
    @Test
    @DisplayName("Somatória de número positivo")
    public void testSomatoriaPositiva() {
        assertEquals(3, calc.somatoria(2)); // 2+1+0
    }

    @Test
    @DisplayName("Somatória de zero deve retornar 0")
    public void testSomatoriaZero() {
        assertEquals(0, calc.somatoria(0));
    }

    @Test
    @DisplayName("Somatória de número negativo deve retornar 0")
    public void testSomatoriaNegativa() {
        assertEquals(0, calc.somatoria(-5));
    }

    // -------------------- ehPositivo --------------------
    @Test
    @DisplayName("Número positivo deve retornar true")
    public void testEhPositivoComNumeroPositivo() {
        assertTrue(calc.ehPositivo(10));
    }

    @Test
    @DisplayName("Zero deve ser considerado positivo")
    public void testEhPositivoComZero() {
        assertTrue(calc.ehPositivo(0));
    }

    @Test
    @DisplayName("Número negativo deve retornar false")
    public void testEhPositivoComNumeroNegativo() {
        assertFalse(calc.ehPositivo(-50));
    }

    // -------------------- compara --------------------
    @Test
    @DisplayName("Compara quando os números são iguais")
    public void testComparaIguais() {
        assertEquals(0, calc.compara(5, 5));
    }

    @Test
    @DisplayName("Compara quando o primeiro é maior")
    public void testComparaMaior() {
        assertEquals(1, calc.compara(10, 5));
    }

    @Test
    @DisplayName("Compara quando o primeiro é menor")
    public void testComparaMenor() {
        assertEquals(-1, calc.compara(2, 20));
    }
}
