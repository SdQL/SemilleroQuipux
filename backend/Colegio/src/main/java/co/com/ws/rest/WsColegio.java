package co.com.ws.rest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import co.com.bd.BaseDatos;
import co.com.model.Estudiante;
import co.com.model.Materia;
import co.com.model.MateriaInput;

@Path("WsColegio")
public class WsColegio {
	
	@GET
	@Path("/getMaterias")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public String getMaterias() {
		Gson gson = new Gson();
		List<Materia> materias = new ArrayList<Materia>();
		
		ResultSet rs;
		PreparedStatement ps;
		
		try {
			Connection conn = BaseDatos.getConnection();
			ps = conn.prepareStatement("SELECT  * from Materias");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Materia mat = new Materia();
				mat.setIdMateria(rs.getInt("idMateria"));
				mat.setNombre(rs.getString("nombre"));
				
				materias.add(mat);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gson.toJson(materias);
	}
	
	@POST
	@Path("/getMateriasById")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public String getMateriasById(String idMateria) {
		Gson gson = new Gson();
		List<Materia> materias = new ArrayList<Materia>();
		
		ResultSet rs;
		PreparedStatement ps;
		
		try {
			Connection conn = BaseDatos.getConnection();
			ps = conn.prepareStatement("SELECT  * from Materias WHERE idMateria = ?");
			ps.setInt(1, Integer.valueOf(idMateria));
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Materia mat = new Materia();
				mat.setIdMateria(rs.getInt("idMateria"));
				mat.setNombre(rs.getString("nombre"));
				
				materias.add(mat);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return gson.toJson(materias);
	}
	
	@POST
	@Path("/getMateriasByIdJson")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public String getMateriasByIdJson(String materia) {
		Gson gson = new Gson();
		MateriaInput materiaInput = gson.fromJson(materia, MateriaInput.class);
		List<Materia> materias = new ArrayList<Materia>();
		
		ResultSet rs;
		PreparedStatement ps;
		
		try {
			Connection conn = BaseDatos.getConnection();
			ps = conn.prepareStatement("SELECT  * from Materias WHERE idMateria = ?");
			ps.setInt(1, materiaInput.getIdMateria());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Materia mat = new Materia();
				mat.setIdMateria(rs.getInt("idMateria"));
				mat.setNombre(rs.getString("nombre"));
				
				materias.add(mat);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return gson.toJson(materias);
	}
	
	@GET
	@Path("/getEstudiantes")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public String getEstudiantes() {
		Gson gson = new Gson();
		List<Estudiante> estudiantes = new ArrayList<Estudiante>();
		
		ResultSet rs;
		PreparedStatement ps;
		
		try {
			Connection conn = BaseDatos.getConnection();
			ps = conn.prepareStatement("SELECT idEstudiante, identificacion, nombres FROM Estudiantes");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Estudiante est = new Estudiante();
				est.setIdentificacion(rs.getString("identificacion"));
				est.setNombre(rs.getString("nombres"));
				est.setIdEstudiante(rs.getInt("idEstudiante"));				
				estudiantes.add(est);
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return gson.toJson(estudiantes);
	}
	
	
	
}
