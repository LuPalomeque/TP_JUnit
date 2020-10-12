package testBuscar;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import escenarios.EscenarioListaNoVacia;
import excepciones.NoEncontradoException;
import modelo.Alumno;
import modelo.Profesor;
import modelo.Sistema;

public class testBuscarProfesorListaNoVacia {

	private Sistema sistema;
	private Profesor profesor;

	@Before
	public void setUp() throws Exception {
		EscenarioListaNoVacia escenario = new EscenarioListaNoVacia();
		sistema = escenario.getSistema();
		profesor = escenario.getProfesor();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBuscarValidoCoincidente() {
		Iterator<Profesor> it = null;
		try {
			it = sistema.buscarProfesor("Leonel");
		} catch (NoEncontradoException e) {
			Assert.fail("No deber�a lanzar excepcion");
		}
		Assert.assertTrue("Se busca el profesor", it != null);
	}

	@Test
	public void testBuscarValidoNoCoincidente() {
		Iterator<Profesor> it = null;
		try {
			it = sistema.buscarProfesor("Roberto");
			Assert.fail("Deber�a lanzar excepcion");
		} catch (NoEncontradoException e) {
			Assert.assertTrue("Se busca el profesor pero no hay coincidencia", it == null);
		}
	}

	@Test
	public void testBuscarVacio() {
		Iterator<Profesor> it = null;
		try {
			it = sistema.buscarProfesor("");
			Assert.fail("Deber�a lanzar excepcion");
		} catch (NoEncontradoException e) {
		}
	}

	@Test
	public void testBuscarNull() {
		Iterator<Profesor> it = null;
		try {
			it = sistema.buscarProfesor(null);
			Assert.fail("Deber�a lanzar excepcion");
		} catch (NoEncontradoException e) {
		}
	}
}
