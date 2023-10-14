package co.com.bd;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BaseDatos {
	private static Connection conn;
	
	public static Connection getConnection() throws SQLException{
		if (conn != null && conn.isValid(15)) {
			return conn;
			
		} else {
			//Objeto de propiedades donde vamos a cargar las propiedades del archivo
			Properties props = new Properties();
			
			//Input Stream donde leemos el recurso donde está el archivo de propiedades
			InputStream is = BaseDatos.class.getClassLoader().getResourceAsStream("app.properties");
			
			//Abrimos try para controlar cualquier excepción de SQL que ocurra
			try {
				//Cargamos las propiedades que vienene del archivo
				props.load(is);

				//Cerramos el recurso
				is.close();

				//Abrimos conexión a base de datos
				conn = DriverManager.getConnection(props.getProperty("url"), props);
				
				//Catch para atrapar alguna excepción de SQL
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			//Bloque finally para cerrar la conexión
			}
			
			return conn;
			
		}

	}

}
