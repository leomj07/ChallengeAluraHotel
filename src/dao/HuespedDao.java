package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import factory.CrearConexionFactory;
import modelo.Huesped;

public class HuespedDao {
	
	final private Connection con;

	public HuespedDao(Connection con) {
		this.con = con;
	}
	
	public void gHuesped(Huesped h) {
		try(con) {
			System.out.println(h.getNombre());
			//con.setAutoCommit(false);
			final PreparedStatement stm = con.prepareStatement("INSERT INTO HUESPEDES(NOMBRE, APELLIDOS, FECHA_NACIMIENTO, NACIONALIDAD, TELEFONO, idReserva ) "
					+ " VALUES( ?, ?, ?, ?, ?, ? )", 
					Statement.RETURN_GENERATED_KEYS);
			try(stm){
				stm.setString(1, h.getNombre());
				stm.setString(2, h.getApellidos());
				stm.setObject(3, h.getFecha_nacimiento());
				stm.setString(4, h.getNacionalidad());
				stm.setString(5, h.getTelefono());
				stm.setInt(6,h.getIdReserva());
				stm.execute();
	
				ResultSet rs = stm.getGeneratedKeys();
				
				while(rs.next()) {				
					JOptionPane.showMessageDialog(null, "El registro del huesped se realizo con éxito, el id de reserva es: "+h.getIdReserva());	
				}	
				
				//con.commit();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void actualizarHuesped(Huesped h) {
		try(con) {
			System.out.println(h.getId());
			final PreparedStatement pr = con.prepareStatement("UPDATE HUESPEDES SET"
					+ " NOMBRE = ? "
					+ ", APELLIDOS = ?"
					+ ", FECHA_NACIMIENTO = ? "
					+ ", NACIONALIDAD = ? "
					+ ", TELEFONO = ? "
					+ ", idReserva = ? "
					+ " WHERE ID = ?; ");
			try(pr){
				pr.setString(1, h.getNombre());
				pr.setString(2, h.getApellidos());
				pr.setString(3, h.getFecha_nacimiento());
				pr.setString(4, h.getNacionalidad());
				pr.setString(5, h.getTelefono());
				pr.setInt(6, h.getIdReserva());
				pr.setInt(7, h.getId());
				pr.execute();
				
				Integer actualizado = pr.getUpdateCount();		
				System.out.println("Actualizado "+ actualizado);
			} 
			//pr.close();	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public void eliminarHuesped(String id) {
				System.out.println(id);
		try(con){
					//con.setAutoCommit(false);
					final PreparedStatement stm = con.prepareStatement("DELETE FROM HUESPEDES WHERE id = ?");
					try(stm){
						stm.setString(1, id);
						stm.execute();
					    Integer Eliminado = stm.getUpdateCount();
					    JOptionPane.showMessageDialog(null, "El usuario se elimino con exito con éxito, el id es: "+ id);
					    System.out.println("Eliminado "+ Eliminado);
					    con.commit();
					}
				}catch (SQLException e) {
					//con.rollback();
					throw new RuntimeException(e);
				}
		} 
	
	public void buscarHuesped(String b, DefaultTableModel modelo) {
		try(con){
			final PreparedStatement stm = con.prepareStatement("SELECT ID, NOMBRE, APELLIDOS, FECHA_NACIMIENTO, NACIONALIDAD, TELEFONO, idReserva "
					+ "FROM HUESPEDES WHERE APELLIDOS = ?");		
			try(stm) {			
				stm.setString(1, b);
				ResultSet set = stm.executeQuery();
				
				while(set.next()) {
					modelo.addRow(new Object[] {set.getInt("ID"), 
							set.getString("NOMBRE"),
							set.getString("APELLIDOS"),
							set.getString("FECHA_NACIMIENTO"),
							set.getString("NACIONALIDAD"), 
							set.getString("TELEFONO" ),
							set.getString("idReserva" )});
				}
		}
		//con.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}


