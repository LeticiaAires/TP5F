package testeJUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import validacao.Validacao;

/**
 * Teste dos métodos da classe Validacao utilizando JUnit5.
 * @author vitor e leticia
 * @version 1.0 (Out, 2021)
 */

public class TesteValidacao {
	Validacao v = new Validacao();
	/**
	 * Realiza teste do método validaCPF da classe Validacao.
	 */
	@Test
	public void testValidaCPF() {
		assertTrue(v.validaCPF("07046446148"));
		assertFalse(v.validaCPF("21213"));
	}

	/**
	 * Realiza teste do método validaDia da classe Validacao.
	 */
	@Test
	public void testValidaDia() {
		assertTrue(v.validaDia(10, 5));
		assertTrue(v.validaDia(31, 5));
		assertFalse(v.validaDia(31, 4));
		assertFalse(v.validaDia(29, 2));
	}

	/**
	 * Realiza teste do método validaMes da classe Validacao.
	 */
	@Test
	public void testValidaMes() {
		assertTrue(v.validaMes(3));
		assertFalse(v.validaMes(13));
	}

}
