package testBuscar;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import escenarios.EscenarioListaNoVacia;
import escenarios.EscenarioListaVacia;
import excepciones.NoEncontradoException;
import modelo.Alumno;
import modelo.Profesor;
import modelo.Sistema;

public class testBuscarAlumnoListaVacia {

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
		Iterator<Alumno> it = null;
		try {
			it = sistema.buscarAlumno("Juan");
			Assert.fail("Debería lanzar excepcion");
		} catch (NoEncontradoException e) {
			Assert.assertTrue("El alumno no es encontrado", it == null);
		}
	}

	@Test
	public void testBuscarVacio() {
		Iterator<Alumno> it = null;
		try {
			it = sistema.buscarAlumno("");
			Assert.fail("Debería lanzar excepcion");
		} catch (NoEncontradoException e) {
		}
	}

	@Test
	public void testBuscarNull() {
		Iterator<Alumno> it = null;
		try {
			it = sistema.buscarAlumno(null);
			Assert.fail("Debería lanzar excepcion");
		} catch (NoEncontradoException e) {
		}
	}
}
