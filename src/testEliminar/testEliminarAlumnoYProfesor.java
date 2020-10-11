package testEliminar;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import escenarios.EscenarioListaNoVacia;
import modelo.Alumno;
import modelo.Profesor;
import modelo.Sistema;

public class testEliminarAlumnoYProfesor {
	
	private Sistema sistema;
	private Alumno alumno;
	private Profesor profesor;

	@Before
	public void setUp() throws Exception {
		EscenarioListaNoVacia escenario = new EscenarioListaNoVacia();
		sistema = escenario.getSistema();
		alumno = escenario.getAlumno();
		profesor = escenario.getProfesor();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEliminarAlumnoValido() {
		sistema.eliminarAlumno(alumno);
		Assert.assertTrue("El sistema no elimino el alumno",!sistema.getAlumnos().contieneValor(alumno));
	}
	
	@Test
	public void testEliminarProfesorValido() {
		sistema.eliminarProfesor(profesor);
		Assert.assertTrue("El sistema no elimino el profesor",!sistema.getProfesores().contieneValor(profesor));
	}

}
