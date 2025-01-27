package org.iesalandalus.programacion.matriculacion;

import java.util.IllformedLocaleException;
import java.util.Objects;

public class Asignatura {

    //paso 1 crea la clase con los atributos
    public static int MAX_NUM_HORAS_ANUALES = 300;
    public static int MAX_NUM_HORAS_DESDOBLES = 6;
    private static String ER_CODIGO = "^\\d{4}$";
    private String codigo;
    private String nombre;
    private int horasAnuales;
    private Curso curso;
    private int horasDesdoble;
    private EspecialidadProfesorado especialidadProfesorado;

    private String cadenaAMostrar;

    //paso 3 crea el constructos
    public Asignatura (String codigo, String nombre, int horasAnuales, Curso curso, int horasDesdoble, EspecialidadProfesorado especialidadProfesorado, CicloFormativo cicloFormativo) {
        setCodigo(codigo);
        setNombre(nombre);
        setHorasAnuales(horasAnuales);
        setCurso(curso);
        setHorasDesdoble(horasDesdoble);

    }
     //paso 4 constructor copia

    public Asignatura (Asignatura asignatura) {
        this.codigo = asignatura.codigo;
        this.nombre = asignatura.nombre;
        this.horasAnuales = asignatura.horasAnuales;
        this.curso = asignatura.curso;
        this.horasDesdoble = asignatura.horasDesdoble;

    }


    // paso 2 metodos de acceso

 public String getCicloFormativo() {
        return CicloFormativo;
 }
 public String setCicloFormtivo() {

 }


    public String getCodigo() {
        return codigo;
    }

    private void setCodigo(String codigo) {
        if (!codigo.matches(ER_CODIGO)) {
            throw new IllformedLocaleException("el codigo no es valido");
        }

        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getHorasAnuales() {
        return horasAnuales;
    }
    public void setHorasAnuales(int horasAnuales) {
        if (horasAnuales > MAX_NUM_HORAS_ANUALES) {
            throw new IllformedLocaleException("las horas anuales no pueden ser mayor que " + MAX_NUM_HORAS_ANUALES);
        }
        this.horasAnuales = horasAnuales;
    }
    public int getHorasDesdoble() {
        return horasDesdoble;
    }

    public Curso getCurso() {
        return curso;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setHorasDesdoble(int horasDesdoble) {
        if (horasDesdoble > MAX_NUM_HORAS_DESDOBLES) {
            throw new IllformedLocaleException("las horas desdobles no pueden ser mayor que " + MAX_NUM_HORAS_DESDOBLES);
        }
        this.horasDesdoble = horasDesdoble;
    }

    public EspecialidadProfesorado getEspecialidadProfesorado() {
        return especialidadProfesorado;
    }

    public void setEspecialidadProfesorado(EspecialidadProfesorado especialidadProfesorado) {
        this.especialidadProfesorado = especialidadProfesorado;
    }

    //paso 5 equals y hash code

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asignatura that = (Asignatura) o;
        return horasAnuales == that.horasAnuales && horasDesdoble == that.horasDesdoble && Objects.equals(codigo, that.codigo) && Objects.equals(nombre, that.nombre) && curso == that.curso && especialidadProfesorado == that.especialidadProfesorado && Objects.equals(cadenaAMostrar, that.cadenaAMostrar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, horasAnuales, curso, horasDesdoble, especialidadProfesorado, cadenaAMostrar);
    }
    //paso 7 imprimir
    public String imprimir() {
        return this.ordinal() + ".-" + this.cadenaAMostrar;
    }

    //paso 6 tostring

    @Override
    public String toString() {
        return "Asignatura{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", horasAnuales=" + horasAnuales +
                ", curso=" + curso +
                ", horasDesdoble=" + horasDesdoble +
                ", especialidadProfesorado=" + especialidadProfesorado +
                ", cadenaAMostrar='" + cadenaAMostrar + '\'' +
                '}';
    }

}

