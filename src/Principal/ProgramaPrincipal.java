package Principal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

import Dto.AlumnoDto;
import Servicios.AlumnoService;

public class ProgramaPrincipal {
	
	public static void main (String[] args) {
		DataSource ds = configurarDatasource();
		AlumnoService alumnoService = AlumnoService.getInstancia(ds);
		
		List <AlumnoDto> alumnos = alumnoService.obtenerTodosLosAlumnos();
		
		for (AlumnoDto alumno : alumnos) {
			System.out.println(alumno.toString());
		}
	}
	
	private static DataSource configurarDatasource() {
		MysqlDataSource ds = null;
		
		Properties prop = new Properties();
	
		FileInputStream  file;
		
		try {
			file = new FileInputStream("resources\\conexion.properties");
			prop.load(file);
			
			ds = new MysqlDataSource();
			ds.setUrl(prop.getProperty("url"));
			ds.setUser(prop.getProperty("user"));
			ds.setPassword(prop.getProperty("password"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ds;
		
	}

}
