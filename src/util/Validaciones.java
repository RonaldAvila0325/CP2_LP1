package util;

public class Validaciones
{

	public static final String NOMBRE = "[a-zA-ZáéíóúñüÁÉÍÓÚÑÜ\\s]{3,30}";
	public static final String DNI = "\\d{8}";
	public static final String FECHA = "((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])";
	public static final String SUELDO = "\\d+.\\d";	
	public static final String CORREO = "[_A-Za-z0-9-]{3}+(\\.[_A-Za-z0-9-]{3}+)+(\\.[_A-Za-z0-9-]{3}+)@[A-Za-z0-9]{3}(\\.[A-Za-z]{2})";
}
