package testAgregar;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import escenarios.EscenarioListaVacia;
import excepciones.ClaveYaExistenteException;
import excepciones.DatoInvalidoException;
import modelo.Profesor;
import modelo.Sistema;

public class testAgregarProfesorListaVacia {

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
	public void testProfesorValido() {
		Profesor profesor = new Profesor("Ivonne","Alvear 4563","ivonne@mail.com","2235916374");
		try {
			sistema.agregarProfesor(profesor);
		} catch (ClaveYaExistenteException | DatoInvalidoException e) {
			Assert.fail("No debe tirar excepcion");
		}
		Assert.assertTrue("El profesor no se cargo en el sistema",sistema.getProfesores().contieneValor(profesor));
	}
	
	@Test
	public void testProfesorNull() {
		Profesor profesor = null;
		try {
			sistema.agregarProfesor(profesor);
			Assert.fail("Deberia tirar excepcion");
		} catch (ClaveYaExistenteException e) {
			Assert.fail("No deberia lanzar esta excepcion");
		} catch (DatoInvalidoException e) {
		}
	}
	
	@Test
	public void testNombreNull() {
		Profesor profesor = new Profesor(null,"Alvear 4563","ivonne@mail.com","");
		try {
			sistema.agregarProfesor(profesor);
			Assert.fail("Deberia tirar excepcion");
		} catch (ClaveYaExistenteException e) {
			Assert.fail("No deberia lanzar esta excepcion");
		} catch (DatoInvalidoException e) {
		}
	}
	
	@Test
	public void testNombreVacio() {
		Profesor profesor = new Profesor("","Alvear 4563","ivonne@mail.com","");
		try {
			sistema.agregarProfesor(profesor);
			Assert.fail("Deberia tirar excepcion");
		} catch (ClaveYaExistenteException e) {
			Assert.fail("No deberia lanzar esta excepcion");
		} catch (DatoInvalidoException e) {
		}
	}
	
	@Test
	public void testDireccionNull() {
		Profesor profesor = new Profesor("Ivonne",null,"ivonne@mail.com","");
		try {
			sistema.agregarProfesor(profesor);
			Assert.fail("Deberia tirar excepcion");
		} catch (ClaveYaExistenteException e) {
			Assert.fail("No deberia lanzar esta excepcion");
		} catch (DatoInvalidoException e) {
		}
	}
	
	@Test
	public void testDireccionVacia() {
		Profesor profesor = new Profesor("Ivonne","","ivonne@mail.com","");
		try {
			sistema.agregarProfesor(profesor);
			Assert.fail("Deberia tirar excepcion");
		} catch (ClaveYaExistenteException e) {
			Assert.fail("No deberia lanzar esta excepcion");
		} catch (DatoInvalidoException e) {
		}
	}
	
	@Test
	public void testEmailSinArroba() {
		Profesor profesor = new Profesor("Ivonne","Alvear 4563","ivonnemail.com","");
		try {
			sistema.agregarProfesor(profesor);
			Assert.fail("Deberia tirar excepcion");
		} catch (ClaveYaExistenteException e) {
			Assert.fail("No deberia lanzar esta excepcion");
		} catch (DatoInvalidoException e) {
		}
	}
	
	@Test
	public void testEmailTerminaArroba() {
		Profesor profesor = new Profesor("Ivonne","Alvear 4563","ivonne@","");
		try {
			sistema.agregarProfesor(profesor);
			Assert.fail("Deberia tirar excepcion");
		} catch (ClaveYaExistenteException e) {
			Assert.fail("No deberia lanzar esta excepcion");
		} catch (DatoInvalidoException e) {
		}
	}
	
	@Test
	public void testEmailEmpiezaArroba() {
		Profesor profesor = new Profesor("Ivonne","Alvear 4563","@mail.com","");
		try {
			sistema.agregarProfesor(profesor);
			Assert.fail("Deberia tirar excepcion");
		} catch (ClaveYaExistenteException e) {
			Assert.fail("No deberia lanzar esta excepcion");
		} catch (DatoInvalidoException e) {
		}
	}
	
	@Test
	public void testEmailArroba() {
		Profesor profesor = new Profesor("Ivonne","Alvear 4563","@","");
		try {
			sistema.agregarProfesor(profesor);
			Assert.fail("Deberia tirar excepcion");
		} catch (ClaveYaExistenteException e) {
			Assert.fail("No deberia lanzar esta excepcion");
		} catch (DatoInvalidoException e) {
		}
	}
	
	@Test
	public void testEmailVacio() {
		Profesor profesor = new Profesor("Ivonne","Alvear 4563","","");
		try {
			sistema.agregarProfesor(profesor);
			Assert.fail("Deberia tirar excepcion");
		} catch (ClaveYaExistenteException e) {
			Assert.fail("No deberia lanzar esta excepcion");
		} catch (DatoInvalidoException e) {
		}
	}
	
	@Test
	public void testEmailNull() {
		Profesor profesor = new Profesor("Ivonne","Alvear 4563",null,"");
		try {
			sistema.agregarProfesor(profesor);
			Assert.fail("Deberia tirar excepcion");
		} catch (ClaveYaExistenteException e) {
			Assert.fail("No deberia lanzar esta excepcion");
		} catch (DatoInvalidoException e) {
		}
	}
	
	@Test
	public void testTelefonoNull() {
		Profesor profesor = new Profesor("Ivonne","Alvear 4563","ivonne@mail.com",null);
		try {
			sistema.agregarProfesor(profesor);
		} catch (ClaveYaExistenteException | DatoInvalidoException e) {
			Assert.fail("No deberia lanzar esta excepcion");
		}
	}

}
