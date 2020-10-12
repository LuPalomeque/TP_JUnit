package testBuscar;

import java.util.Iterator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import escenarios.EscenarioListaVacia;
import excepciones.NoEncontradoException;
import modelo.Profesor;
import modelo.Sistema;

public class testBuscarProfesorListaVacia {

	private Sistema sistema;

	@Before
	public void setUp() throws Exception {
		EscenarioListaVacia escenario = new EscenarioListaVacia();
		sistema = escenario.getSistema();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBuscarValido() {
		Iterator<Profesor> it = null;
		try {
			it = sistema.buscarProfesor("Juan");
			Assert.fail("Debería lanzar excepcion");
		} catch (NoEncontradoException e) {
			Assert.assertTrue("El profesor no es encontrado", it == null);
		}
	}

	@Test
	public void testBuscarVacio() {
		Iterator<Profesor> it = null;
		try {
			it = sistema.buscarProfesor("");
			Assert.fail("Debería lanzar excepcion");
		} catch (NoEncontradoException e) {
		}
	}

	@Test
	public void testBuscarNull() {
		Iterator<Profesor> it = null;
		try {
			it = sistema.buscarProfesor(null);
			Assert.fail("Debería lanzar excepcion");
		} catch (NoEncontradoException e) {
		}
	}
}
