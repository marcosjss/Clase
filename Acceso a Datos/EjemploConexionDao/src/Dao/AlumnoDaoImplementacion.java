package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import Entidad.AlumnoEntidad;

public class AlumnoDaoImplementacion implements AlumnoDao {
	
	
	private static AlumnoDaoImplementacion instancia;
	private DataSource dataSource;
	
	
	
	
	private AlumnoDaoImplementacion(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}



	public AlumnoDaoImplementacion getInstancia(DataSource dataSource) {
		if (instancia == null) 
			instancia = new AlumnoDaoImplementacion(dataSource);
			return instancia;
	}
	
	

	public void crearAlumno(AlumnoEntidad alumno) {
		String sql = "insert into alumno(codAlumno,nombreAlumno,apellidosAlumno,fechaNacimiento,grupo) values (?,?,?,?,?,)";
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, alumno.getCodAlumno());
			statement.setString(2, alumno.getNombreAlumno());
			statement.setString(3, alumno.getApellidoAlumno());
			statement.setDate(4, new java.sql.Date(alumno.getFechaNacimiento().getTime()));
			statement.setString(5, String.valueOf(alumno.getGrupo()));
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public AlumnoEntidad obtenerAlumnoPorId(String id) {
		String sql = "Select codAlumno,nombreAlumno,apellidosAlumno,fechaNacimiento,grupo from alumno whre cod_alumno = ?";
		try {	
			Connection connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet result = statement.executeQuery(sql);
			
			if (result.next())
				return mapearResultSetAlumno(result);
			
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	
	public List<AlumnoEntidad> obtenerTodosLosAlumnos() {
		// TODO Auto-generated method stub
		return null;
	}

	public void actualizarAlumno(AlumnoEntidad alumno) {
		String sql = "update alumno set nombre_alumno = ?, apellidos_alumno = ?, fecha_nacimiento = ?, grupo= ? where cod_alumno = ?";

		try {
			
			Connection connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, alumno.getNombreAlumno());
			statement.setString(2, alumno.getApellidoAlumno());
			statement.setDate(3, new java.sql.Date(alumno.getFechaNacimiento().getTime()));
			statement.setString(4, String.valueOf(alumno.getGrupo()));
			statement.setString(5, alumno.getCodAlumno());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

	public void eliminarAlumno(String id) {
		String sql = "delete from alumno where cod_alumno = ?";
		try {
			
			Connection connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, id);
			statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private AlumnoEntidad mapearResultSetAlumno(ResultSet alumno) {
		AlumnoEntidad aux = new AlumnoEntidad();
	
		try {
			aux.setFechaNacimiento(alumno.getDate("fecha_nacimiento"));
			aux.setCodAlumno(alumno.getString("cod_alumno"));
			aux.setApellidoAlumno(alumno.getString("apellidos_alumno"));
			aux.setGrupo(alumno.getString("grupo").charAt(0));
			aux.setNombreAlumno(alumno.getString(0));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aux;

	}

}
