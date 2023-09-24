package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import factory.CrearConexionFactory;
import modelo.Reserva;
import views.RegistroHuesped;

public class ReservasDao {
	
	final private Connection con;
	
	public ReservasDao(Connection con) {
		this.con = con;
	}

	public void gReserva(Reserva r) {
			try(con){
				//con.setAutoCommit(false);
				final PreparedStatement stm = con.prepareStatement("INSERT INTO RESERVAS(FECHA_ENTRADA, FECHA_SALIDA, VALOR, FORMA_PAGO) VALUES("
						+ "?, ?, ?, ?)", 
						Statement.RETURN_GENERATED_KEYS);
			
				try(stm){
					stm.setString(1, r.getFecha_entrada());
					stm.setString(2, r.getFecha_salida());
					stm.setInt(3,r.getValor());
					stm.setString(4,r.getForma_pago());
					stm.execute();
					ResultSet rs = stm.getGeneratedKeys();
					
					while(rs.next()) {
						r.setId(rs.getInt(1));
						JOptionPane.showMessageDialog(null, "La reserva se realizo con éxito, el id de reserva es: "+r.getId());
						RegistroHuesped registro = new RegistroHuesped(rs.getInt(1));
						registro.setVisible(true);
					}		 
					//con.commit();
				}		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
public void actualizarReserva(Reserva r) {
	System.out.println(r.getValor());
	
		try(con) {
			PreparedStatement pt = con.prepareStatement("UPDATE RESERVAS SET"
			+" FECHA_ENTRADA =?"
			+", FECHA_SALIDA = ?"
			+", VALOR= ?"
			+", FORMA_PAGO= ?"
			+" WHERE ID = ?");
			
			pt.setString(1, r.getFecha_entrada());
			pt.setString(2, r.getFecha_salida());
			pt.setInt(3, r.getValor());
			pt.setString(4, r.getForma_pago());
			pt.setInt(5, r.getId());
			
			pt.execute();
			
			Integer actualizado = pt.getUpdateCount();			
			System.out.println("Actualizado "+ actualizado);
			 
			pt.close();
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	  }

public void eliminarReserva(String id) {
		    System.out.println(id);
			try(con){
				//con.setAutoCommit(false);
				final PreparedStatement stm = con.prepareStatement("DELETE FROM RESERVAS WHERE id = ?");			
				try(stm){
					//con.setAutoCommit(false);
					stm.setString(1, id);
					stm.execute();
				    Integer Eliminado = stm.getUpdateCount();
				    JOptionPane.showMessageDialog(null, "El usuario se elimino con exito con éxito, el id es: "+ id);
				    System.out.println("Eliminado "+ Eliminado);
				    //con.commit();
				}
			} catch (SQLException e) {
					throw new RuntimeException(e);
			}
}

	public void buscarReserva(String b, DefaultTableModel modelo){
		try(con){
			final PreparedStatement stm = con.prepareStatement("SELECT ID, FECHA_ENTRADA, FECHA_SALIDA, VALOR, FORMA_PAGO FROM RESERVAS"
					+ " WHERE id = ?");
			stm.setString(1, b);
			ResultSet set = stm.executeQuery();
						
			while(set.next()) {	
				modelo.addRow(new Object[] {set.getInt("ID"), 
					set.getString("FECHA_ENTRADA"),
					set.getString("FECHA_SALIDA"), 
					set.getInt("VALOR"), 
					set.getString("FORMA_PAGO" )});
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		//con.close();
	}
	
}

