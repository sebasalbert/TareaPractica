import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SistemaReservasDeportivasTest {

    static SistemaReservasDeportivas sistemaReservas;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        sistemaReservas = new SistemaReservasDeportivas(); 
    }

    @Test
    void test() {
        assertTrue(sistemaReservas.reservarPista(1, "21-05-2025 12:00", 60));
        assertFalse(sistemaReservas.reservarPista(1, "21-05-2025 12:00", 60));
        assertTrue(sistemaReservas.reservarPista(1, "21-05-2025 12:00", 60));
        assertTrue(sistemaReservas.reservarPista(1, "21-05-2025 12:00", 60));
        assertTrue(sistemaReservas.reservarPista(1, "21-05-2025 12:00", 60));
    }
    
    @Test
    void testCnacelarPista() {
    	assertTrue(sistemaReservas.reservarPista(1, "21-05-2025 12:00", 60));
    	assertTrue(sistemaReservas.cancelarReserva(0));
    }
    
}

