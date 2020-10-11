package testAgregar;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import escenarios.EscenarioListaVacia;
import excepciones.ClaveYaExistenteException;
import excepciones.DatoInvalidoException;
import modelo.Alumno;
import modelo.Sistema;

public class testAgregarAlumnoListaVacia {
	
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
	public void testAlumnoValido() {
		Alumno alumno = new Alumno("Juan Perez","Colon 2025","juanperez@mail.com");
		try {
			sistema.agregarAlumno(alumno);
		} catch (ClaveYaExistenteException | DatoInvalidoException e) {
			Assert.fail("No debe tirar excepcion");
		}
		Assert.assertTrue("El alumno no se cargo en el sistema",sistema.getAlumnos().contieneValor(alumno));
	}
	
	@Test
	public void testAlumnoNull() {
		Alumno alumno = null;
		try {
			sistema.agregarAlumno(alumno);
			Assert.fail("Deberia tirar excepcion");
		} catch (ClaveYaExistenteException e) {
			Assert.fail("No deberia lanzar esta excepcion");
		} catch (DatoInvalidoException e) {
		}
	}
	
	@Test
	public void testNombreNull() {
		Alumno alumno = new Alumno(null,"Colon 2025","juanperez@mail.com");
		try {
			sistema.agregarAlumno(alumno);
			Assert.fail("Deberia tirar excepcion");
		} catch (ClaveYaExistenteException e) {
			Assert.fail("No deberia lanzar esta excepcion");
		} catch (DatoInvalidoException e) {
		}
	}
	
	@Test
	public void testNombreVacio() {
		Alumno alumno = new Alumno("","Colon 2025","juanperez@mail.com");
		try {
			sistema.agregarAlumno(alumno);
			Assert.fail("Deberia tirar excepcion");
		} catch (ClaveYaExistenteException e) {
			Assert.fail("No deberia lanzar esta excepcion");
		} catch (DatoInvalidoException e) {
		}
	}
	
	@Test
	public void testDireccionNull() {
		Alumno alumno = new Alumno("Juan Perez",null,"juanperez@mail.com");
		try {
			sistema.agregarAlumno(alumno);
			Assert.fail("Deberia tirar excepcion");
		} catch (ClaveYaExistenteException e) {
			Assert.fail("No deberia lanzar esta excepcion");
		} catch (DatoInvalidoException e) {
		}
	}
	
	@Test
	public void testDireccionVacia() {
		Alumno alumno = new Alumno("Juan Perez","","juanperez@mail.com");
		try {
			sistema.agregarAlumno(alumno);
			Assert.fail("Deberia tirar excepcion");
		} catch (ClaveYaExistenteException e) {
			Assert.fail("No deberia lanzar esta excepcion");
		} catch (DatoInvalidoException e) {
		}
	}
	
	@Test
	public void testEmailSinArroba() {
		Alumno alumno = new Alumno("Juan Perez","Colon 2025","juanperezmail.com");
		try {
			sistema.agregarAlumno(alumno);
			Assert.fail("Deberia tirar excepcion");
		} catch (ClaveYaExistenteException e) {
			Assert.fail("No deberia lanzar esta excepcion");
		} catch (DatoInvalidoException e) {
		}
	}
	
	@Test
	public void testEmailTerminaArroba() {
		Alumno alumno = new Alumno("Juan Perez","Colon 2025","juanperez@");
		try {
			sistema.agregarAlumno(alumno);
			Assert.fail("Deberia tirar excepcion");
		} catch (ClaveYaExistenteException e) {
			Assert.fail("No deberia lanzar esta excepcion");
		} catch (DatoInvalidoException e) {
		}
	}
	
	@Test
	public void testEmailEmpiezaArroba() {
		Alumno alumno = new Alumno("Juan Perez","Colon 2025","@mail.com");
		try {
			sistema.agregarAlumno(alumno);
			Assert.fail("Deberia tirar excepcion");
		} catch (ClaveYaExistenteException e) {
			Assert.fail("No deberia lanzar esta excepcion");
		} catch (DatoInvalidoException e) {
		}
	}
	
	@Test
	public void testEmailArroba() {
		Alumno alumno = new Alumno("Juan Perez","Colon 2025","@");
		try {
			sistema.agregarAlumno(alumno);
			Assert.fail("Deberia tirar excepcion");
		} catch (ClaveYaExistenteException e) {
			Assert.fail("No deberia lanzar esta excepcion");
		} catch (DatoInvalidoException e) {
		}
	}
	
	@Test
	public void testEmailVacio() {
		Alumno alumno = new Alumno("Juan Perez","Colon 2025","");
		try {
			sistema.agregarAlumno(alumno);
			Assert.fail("Deberia tirar excepcion");
		} catch (ClaveYaExistenteException e) {
			Assert.fail("No deberia lanzar esta excepcion");
		} catch (DatoInvalidoException e) {
		}
	}
	
	@Test
	public void testEmailNull() {
		Alumno alumno = new Alumno("Juan Perez","Colon 2025",null);
		try {
			sistema.agregarAlumno(alumno);
			Assert.fail("Deberia tirar excepcion");
		} catch (ClaveYaExistenteException e) {
			Assert.fail("No deberia lanzar esta excepcion");
		} catch (DatoInvalidoException e) {
		}
	}


}
