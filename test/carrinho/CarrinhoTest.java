package carrinho;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("Classe de testes unitários para Carrinho")
public class CarrinhoTest {

    private Carrinho car;
    private Produto produto;
    private Produto produto2;

    @BeforeEach
    public void inicializa() {
        car = new Carrinho();
        produto = new Produto("Mouse", 249.0);
        produto2 = new Produto("Teclado", 300.0);
    }

    @DisplayName("Carrinho deve iniciar vazio")
    @Test
    public void testCarrinhoInicialmenteVazio() {
        assertEquals(0, car.getQtdeItems(), "Carrinho deve iniciar com 0 itens");
        assertEquals(0.0, car.getValorTotal(), 0.001, "Valor total deve iniciar em 0.0");
    }

    @DisplayName("Adicionar itens deve aumentar a quantidade")
    @Test 
    public void testAddItem() {
        car.addItem(produto);
        car.addItem(produto2);
        assertEquals(2, car.getQtdeItems(), "Carrinho deve ter 2 itens após adição");
    }

    @DisplayName("Remover item existente deve reduzir a quantidade")
    @Test 
    public void testRemoveItem() throws ProdutoNaoEncontradoException {
        car.addItem(produto);
        car.addItem(produto2);
        car.removeItem(produto);
        assertEquals(1, car.getQtdeItems(), "Carrinho deve ter 1 item após remoção");
    }

    @DisplayName("Remover item inexistente deve lançar exceção")
    @Test
    public void testRemoverItemInexistenteLancaExcecao() {
        car.addItem(produto); // só adiciona um
        assertThrows(ProdutoNaoEncontradoException.class, () -> {
            car.removeItem(produto2); // tenta remover outro
        });
    }

    @DisplayName("Valor total deve ser calculado corretamente")
    @Test
    public void testValorTotal() {
        car.addItem(produto);
        car.addItem(produto2);
        double valorTotal = car.getValorTotal();
        assertEquals(549.0, valorTotal, 0.001, "Valor total deve ser a soma dos preços");
    }

    @DisplayName("Quantidade de itens deve estar correta")
    @Test 
    public void testQtdeItems() {
        car.addItem(produto);
        car.addItem(produto2);
        int quantidade = car.getQtdeItems();
        assertEquals(2, quantidade, "Carrinho deve conter 2 itens");
    }

    @DisplayName("Esvaziar carrinho deve remover todos os itens")
    @Test 
    public void testEsvazia() {
        car.addItem(produto);
        car.addItem(produto2);
        car.esvazia();
        assertEquals(0, car.getQtdeItems(), "Carrinho deve estar vazio após esvaziar");
        assertEquals(0.0, car.getValorTotal(), 0.001, "Valor total deve ser 0 após esvaziar");
    }

    @DisplayName("Adicionar itens duplicados deve somar quantidade e valor")
    @Test
    public void testAdicionarItensDuplicados() {
        car.addItem(produto);
        car.addItem(produto); // adiciona o mesmo duas vezes

        assertEquals(2, car.getQtdeItems(), "Quantidade deve considerar duplicados");
        assertEquals(produto.getPreco() * 2, car.getValorTotal(), 0.001,
                "Valor total deve somar duplicados corretamente");
    }
}
