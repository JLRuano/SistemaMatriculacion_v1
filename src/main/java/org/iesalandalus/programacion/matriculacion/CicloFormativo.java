package org.iesalandalus.programacion.matriculacion;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class CicloFormativo {

    private String cadenaAMostrar;
    //paso 1 crea la clase con sus atributos
    public int MAXIMO_NUMERO_HORAS;
    private int codigo;
    private String familiaProfesional;
    private Grado grado;
    private String nombre;
    private int horas;

    //paso 3 crea el constructor
    public CicloFormativo(int codigo, String familiaProfesional, Grado grado, String nombre, int horas) {
        setCodigo(codigo);
        setFamiliaProfesional(familiaProfesional);
        setGrado(grado);
        setNombre(nombre);
        setHoras(horas);

    }

    //paso 4 crea el constructor copia
    public CicloFormativo(CicloFormativo cicloFormativo) {
        this.codigo = cicloFormativo.codigo;
        this.familiaProfesional = cicloFormativo.familiaProfesional;
        this.grado = cicloFormativo.grado;
        this.nombre = cicloFormativo.nombre;
        this.horas = cicloFormativo.horas;
    }


    // paso 2 crea los metodos de acceso
    //get y set
    //codigo
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        if (!codigo.) {
            throw new IllegalArgumentException("el codigo no es valido");
        }
        this.codigo = codigo;
    }

    //familiaProfesional
    public String getFamiliaProfesional() {
        return familiaProfesional;
    }

    public void setFamiliaProfesional(String familiaProfesional) {
        this.familiaProfesional = familiaProfesional;
    }

    // grado
    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    //nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // horas
    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        if (horas > MAXIMO_NUMERO_HORAS) {
            throw new IllegalArgumentException(("el total de horas no puede ser mayor de " + MAXIMO_NUMERO_HORAS))
        }
        this.horas = horas;
    }

    //paso 5 equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CicloFormativo that = (CicloFormativo) o;
        return MAXIMO_NUMERO_HORAS == that.MAXIMO_NUMERO_HORAS && codigo == that.codigo && horas == that.horas && Objects.equals(familiaProfesional, that.familiaProfesional) && grado == that.grado && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(MAXIMO_NUMERO_HORAS, codigo, familiaProfesional, grado, nombre, horas);
    }


//paso 7 crea el metodo imprimir
public String imprimir() {
    return this.ordinal() + ".-" + this.cadenaAMostrar;
}




//paso 6 crea el metodo toString
    @Override
    public String toString() {
        return "CicloFormativo{" +
                "MAXIMO_NUMERO_HORAS=" + MAXIMO_NUMERO_HORAS +
                ", codigo=" + codigo +
                ", familiaProfesional='" + familiaProfesional + '\'' +
                ", grado=" + grado +
                ", nombre='" + nombre + '\'' +
                ", horas=" + horas +
                '}';
    }
}