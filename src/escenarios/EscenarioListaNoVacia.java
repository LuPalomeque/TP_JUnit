package escenarios;

import excepciones.ClaveYaExistenteException;
import excepciones.DatoInvalidoException;
import modelo.Alumno;
import modelo.IndiceDoble;
import modelo.Profesor;
import modelo.Sistema;

public class EscenarioListaNoVacia {
	
	private Sistema sistema = new Sistema();
	private Alumno alumno;
	private Profesor profesor;
	
	{
		IndiceDoble<Alumno> alumnos = new IndiceDoble<Alumno>();
		sistema.setAlumnos(alumnos);
		IndiceDoble<Profesor> profesores = new IndiceDoble<Profesor>();
		sistema.setProfesores(profesores);
		try {
			alumno = new Alumno("Juan Perez","Colon 2025","juanperez@mail.com");
			sistema.agregarAlumno(alumno);
			sistema.agregarAlumno(new Alumno("Pedro Gutierrez","Laprida 5433","pedro@mail.com"));
			sistema.agregarAlumno(new Alumno("Maria Morales","Rawson 5433","maria@mail.com"));
			profesor = new Profesor("Adolfito","Rawson 5439","adolfito@mail.com","");
			sistema.agregarProfesor(profesor);
			sistema.agregarProfesor(new Profesor("Leonel","Luro 5639","leonel@mail.com","2235916324"));
			sistema.agregarProfesor(new Profesor("Claudio","Jara 5633","claudio@mail.com",""));
		} catch (ClaveYaExistenteException | DatoInvalidoException e) {
			e.printStackTrace();
		}
	}
	
	public Sistema getSistema() {
		return sistema;
	}
	
	public Alumno getAlumno() {
		return alumno;
	}
	
	public Profesor getProfesor() {
		return profesor;
	}

}
