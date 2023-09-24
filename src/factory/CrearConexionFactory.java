package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CrearConexionFactory {

	public Connection recuperaConexion(){
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/alurahotel?useTimeZone=true&serverTimeZones=UTC",
					"root",
					"23433jui");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
