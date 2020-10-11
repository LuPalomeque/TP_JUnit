package escenarios;

import modelo.Alumno;
import modelo.IndiceDoble;
import modelo.Profesor;
import modelo.Sistema;

public class EscenarioListaVacia {
	
	private Sistema sistema = new Sistema();
	
	{
		IndiceDoble<Alumno> alumnos = new IndiceDoble<Alumno>();
		sistema.setAlumnos(alumnos);
		IndiceDoble<Profesor> profesores = new IndiceDoble<Profesor>();
		sistema.setProfesores(profesores);
	}
	
	public Sistema getSistema() {
		return sistema;
	}
	
	
}
