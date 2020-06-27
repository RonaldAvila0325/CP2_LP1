package entidad;

import java.sql.Date;

@SuppressWarnings("unused")
public class Doctor 
{
	public int idoctor;
	public String nombre;
	public String dni;
	public String fechaNacimiento;
	public String sueldo;
	public String email;
	
	public int getIdoctor() {
		return idoctor;
	}
	public void setIdoctor(int idoctor) {
		this.idoctor = idoctor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getSueldo() {
		return sueldo;
	}
	public void setSueldo(String sueldo) {
		this.sueldo = sueldo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
