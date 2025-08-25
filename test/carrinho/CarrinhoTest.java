package carrinho;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("Classe para teste do carrinho")
public class CarrinhoTest {

    private Carrinho car;
    private Produto produto;
    private Produto produto2;


    @BeforeEach
    public void inicializa() {
        car = new Carrinho();
        produto = new Produto("Mouse", 249);
        produto2 = new Produto("teclado", 300);
    }

    @DisplayName("Classe para teste de adição de item")
    @Test 
    public void testAddItem(){
        car.addItem(produto);
        car.addItem(produto2);
        assertEquals(2, car.getQtdeItems());
    }

    @DisplayName("Classe para teste de remoção de item")
    @Test 
    public void testremoveItem() throws ProdutoNaoEncontradoException{
        car.addItem(produto);
        car.addItem(produto2);
        car.removeItem(produto);
        assertEquals(1, car.getQtdeItems());
    }

}
