package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import entidad.Doctor;
import util.MySqlDBConexion;

@SuppressWarnings("unused")
public class DoctorModel
{
	public int insertaDoctor(Doctor d)
	{
		int salida=-1;
		Connection con=null;
		PreparedStatement pstm=null;
		try 
		{
			con=MySqlDBConexion.getConexion();
			
			String sql="insert into doctor values(null,?,?,?,?,?)";
			pstm=con.prepareStatement(sql);
			pstm.setString(1, d.getNombre());
			pstm.setString(2, d.getDni());
			pstm.setString(3, d.getFechaNacimiento());
			pstm.setString(4, d.getSueldo());
			pstm.setString(5, d.getEmail());
			
			System.out.println("SQL-->"+pstm);
			
			salida=pstm.executeUpdate();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(pstm!=null)pstm.close();
				if(con!=null)con.close();
			}
			catch(Exception e2) 
			{				
			}
		}
		return salida;
	}
	
	//LISTAMOS LA TABLA DOCTOR
	public List<Doctor> listaDoctor()
	{
		ArrayList<Doctor> data=new ArrayList<Doctor>();
		Connection con=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try 
		{
			con=MySqlDBConexion.getConexion();
			String sql="select * from doctor";
			pstm=con.prepareStatement(sql);
			System.out.println("SQL-->"+pstm);
			rs=pstm.executeQuery();
			
			Doctor d=null;
			while(rs.next())
				{
					d=new Doctor();
					
					d.setIdoctor(rs.getInt("idoctor"));
					d.setNombre(rs.getString("nombre"));
					d.setDni(rs.getString("dni"));
					d.setFechaNacimiento(rs.getString("fechaNacimiento"));
					d.setSueldo(rs.getString("sueldo"));
					d.setEmail(rs.getString("email"));
					
					data.add(d);
				}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(pstm!=null)pstm.close();
				if(con!=null)con.close();
			}
			catch(SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return data;
	}
	//Actuaizamos a los doctores registrados
	public int actualizaDoctor(Doctor d) 
	{
		int actualizados=-1;
		Connection con=null;
		PreparedStatement pstm=null;
		try 
		{
			con=MySqlDBConexion.getConexion();
			String sql="update doctor set nombre=?,dni=?,fechaNacimiento=?,sueldo=?,email=?";
			pstm=con.prepareStatement(sql);
			pstm.setString(1, d.getNombre());
			pstm.setString(2, d.getDni());
			pstm.setString(3, d.getFechaNacimiento());
			pstm.setString(4, d.getSueldo());
			pstm.setString(5, d.getEmail());
			
			actualizados=pstm.executeUpdate();
			
			System.out.println("actualizados: "+actualizados);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(pstm!=null)pstm.close();
				if(con!=null)con.close();
			}
			catch(SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return actualizados;
	}
	//Eliminamos al doctor seleccionado
	public int eliminaDoctor(int idoctor) 
	{
		int eliminados=-1;
		Connection con=null;
		PreparedStatement pstm=null;
		try 
		{
			con=MySqlDBConexion.getConexion();
			String sql="delete from doctor where idoctor=?";
			pstm=con.prepareStatement(sql);
			pstm.setInt(1, idoctor);
			
			eliminados=pstm.executeUpdate();
			System.out.println("eliminados: "+eliminados);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try
			{
				if(pstm!=null)pstm.close();
				if(con!=null)con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return eliminados;
	}
}
