package org.iesalandalus.programacion.matriculacion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.IllformedLocaleException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Alumno {

    private String cadenaAMostrar;
    //paso 1 crear la clase alumno

    //paso 2 crea los atributos
    private static String ER_TELEFONO = "^\\d{9}$";
    private static String ER_CORREO = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private static String ER_DNI;
    public static String FORMATO_FECHA = "dd/MM/YYYY";
    private static String ER_NIA;
    private static int MIN_EDAD_ALUMNADO = 16;

    private String nombre;
    private String telefono;
    private String correo;
    private String dni;
    private LocalDate fechaNacimiento;
    private String nia;

    //paso 8 constructor
    public Alumno(String nombre, String dni, String correo, String telefono, LocalDate fechaNacimiento)
        throws  ParseException {
        setNombre(nombre);
        setDni(dni);
        setCorreo(correo);
        setTelefono(telefono);
        setFechaNacimiento(fechaNacimiento);
    }

    //paso 9 constructor copia
public Alumno (Alumno alumno) {
        this.nombre = alumno.nombre;
        this.dni = alumno.dni;
        this.correo = alumno.correo;
        this.telefono =alumno.telefono;
        this.fechaNacimiento =alumno.fechaNacimiento;
}


    //paso 5 crear metodos de acceso
    //gets y sets
    //Nia
    public String getNia() {
        return nia;
    }
    private void setNia(String nia) {
        this.nia = nia;
    }

    //nombre
    public String getNombre() {
        return nombre;
    }
    private void setNombre(String nombre) {
        this.nombre = nombre;
    }
    // paso 3 crear metodo formateaNombre
    private String FormateaNombre(String nombre) {
        // copiado
        String[] palabras = nombre.trim().split("\\s+");
        StringBuilder nombreFormateado = new StringBuilder();
        for (String palabra : palabras) {
            nombreFormateado.append(Character.toUpperCase(palabra.charAt(0)))
                    .append(palabra.substring(1).toLowerCase())
                    .append(" ");
        }
        return nombreFormateado.toString().trim();
    }

    //telefono
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        if (!telefono.matches(ER_TELEFONO)) {
            throw new IllformedLocaleException("el numero de telefono no es valido");
        }
        this.telefono = telefono;
    }

    //correo
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        if (!correo.matches(ER_CORREO)) {
            throw new IllformedLocaleException("el correo no es valido");
        }
        this.correo = correo;
    }

    //dni
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        if (!dni.matches(ER_DNI)) {
            throw new IllformedLocaleException("el dni no es valido");
        }
        this.dni = dni;
    }


    //paso 4 crea el metodo comprobarLetraDNI
    public boolean comprobarLetraDNI() {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        String patron = "(\\d+)([A-Z])";
        Pattern pattern = Pattern.compile(patron);

        Matcher matcher = pattern.matcher(dni);

        if (matcher.matches()) {
            String numero = matcher.group(1);
            char letra = matcher.group(2).charAt(0);

            int num = Integer.parseInt(numero);
            char letraCorrecta = letras.charAt(num % 23);

            return letra == letraCorrecta;
        }

        return false;
    }


    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) throws ParseException {
        if (!fechaNacimiento.matches(FORMATO_FECHA)) {
            throw new IllformedLocaleException("la fecha no es valida");
        }
    }



    private boolean esMayorDeEdad(Date fecha) {
        Date hoy = new Date();
        long diferenciaEnMillis = hoy.getTime() - fecha.getTime();
        long edad = diferenciaEnMillis / (1000L * 60 * 60 * 24 * 365);
        return edad >= MIN_EDAD_ALUMNADO;
    }


    //equals y hascode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(nombre, alumno.nombre) && Objects.equals(telefono, alumno.telefono) && Objects.equals(correo, alumno.correo) && Objects.equals(dni, alumno.dni) && Objects.equals(fechaNacimiento, alumno.fechaNacimiento) && Objects.equals(nia, alumno.nia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, telefono, correo, dni, fechaNacimiento, nia);
    }

    public String imprimir() {
        return this.ordinal() + ".-" + this.cadenaAMostrar;
    }


    //toString

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", dni='" + dni + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", nia='" + nia + '\'' +
                '}';
    }
}
