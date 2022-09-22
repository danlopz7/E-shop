package Market;

import org.junit.jupiter.api.*;

class PedidoTest {

    private Pedido pedido;

    @BeforeEach
    public void setup() {
        System.out.println("Instantiating Pedido pedido");
        this.pedido = new Pedido("Test");
    }

    @Test
    void shouldGetAReference() {
        Assertions.assertFalse(pedido.getReferencia().isEmpty());
    }

    @Test
    void shouldCreateAContainersList() {
        Assertions.assertTrue(pedido.getContenedores().isEmpty());
    }

    @Test
    @DisplayName("Should not add products to an empty list of containers")
    void addProductos() {
        Pedido pedido = new Pedido("TEST");
        Assertions.assertThrows(RuntimeException.class, () -> {
            pedido.addProducto(null);
        });
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Should Execute After Each Test");
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("Should be executed at the end of the Test");
    }
}