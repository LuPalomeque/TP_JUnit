package testBuscar;

import java.util.Iterator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import escenarios.EscenarioListaNoVacia;
import excepciones.NoEncontradoException;
import modelo.Alumno;
import modelo.Sistema;

public class testBuscarAlumnoListaNoVacia {

	private Sistema sistema;
	private Alumno alumno;

	@Before
	public void setUp() throws Exception {
		EscenarioListaNoVacia escenario = new EscenarioListaNoVacia();
		sistema = escenario.getSistema();
		alumno = escenario.getAlumno();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBuscarValidoCoincidente() {
		Iterator<Alumno> it = null;
		try {
			it = sistema.buscarAlumno("Juan");
		} catch (NoEncontradoException e) {
			Assert.fail("No debería lanzar excepcion");
		}
		Assert.assertTrue("Se busca el/los alumnos", it != null);
	}

	@Test
	public void testBuscarValidoNoCoincidente() {
		Iterator<Alumno> it = null;
		try {
			it = sistema.buscarAlumno("Roberto");
			Assert.fail("Debería lanzar excepcion");
		} catch (NoEncontradoException e) {
			Assert.assertTrue("Se busca el alumno pero no hay coincidencia", it == null);
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
