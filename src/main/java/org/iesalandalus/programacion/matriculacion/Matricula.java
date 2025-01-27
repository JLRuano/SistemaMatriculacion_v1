package org.iesalandalus.programacion.matriculacion;

import java.time.LocalDate;
import java.util.Objects;

public class Matricula {

    //paso 1
    public static int MAXIMO_MESES_ANTERIOR_ANULACION = 6;
    public static int MAXIMO_DIAS_ANTERIOR_MATRICULA = 15;
    public static int MAXIMO_NUMERO_HORAS_MATRICULA = 1000;
    public static int MAXIMO_NUMERO_ASIGNATURAS_POR_MATRICULA = 10;
    private static String ER_CURSO_ACADEMICO = "^\\d{2}-\\d{2}$";
    public static String FORMATO_FECHA = "dd/mm/yyyy";

    private int idMatricula;
    private String cursoAcademico;
    private LocalDate fechaMatriculacion;
    private LocalDate fechaAnulacion;


    // paso 3 constructor

public Matricula (int idMatricula, String cursoAcademico, LocalDate fechaMatriculacion) {
    setIdMatricula(idMatricula);
    setCursoAcademico(cursoAcademico);
    setFechaMatriculacion(fechaMatriculacion);
}

    //paso 4 constructor copia
    public Matricula (Matricula matricula) {
    this.idMatricula = matricula.idMatricula;
    this.cursoAcademico = matricula.cursoAcademico;
    this.fechaMatriculacion = matricula.fechaMatriculacion;
    }

    //paso 2 metodos de acceso


    //idmatricula
    public int getIdMatricula() {
        return idMatricula;
    }
    public void setIdMatricula(int idMatricula) {
        if (idMatricula <=0) {
            throw new IllegalArgumentException("el id tiene no puede ser numero negativo");
        }
        this.idMatricula = idMatricula;
    }

    //cursoAcademico
    public String getCursoAcademico() {
        return cursoAcademico;
    }
    public void setCursoAcademico(String cursoAcademico) {
        if (!cursoAcademico.matches(ER_CURSO_ACADEMICO)) {
            throw new IllegalArgumentException("el curso academico no es valido");
        }
        this.cursoAcademico = cursoAcademico;
    }

    //fechaMatriculacion
    public LocalDate getFechaMatriculacion() {

        return fechaMatriculacion;
    }
    public void setFechaMatriculacion(LocalDate fechaMatriculacion) {
        if (fechaMatriculacion > MAXIMO_DIAS_ANTERIOR_MATRICULA) {
            throw new IllegalArgumentException("la matricula no es valida");
        }
        this.fechaMatriculacion = fechaMatriculacion;
    }

    //gechaAnulacion
    public LocalDate getFechaAnulacion() {
        return fechaAnulacion;
    }

    public void setFechaAnulacion(LocalDate fechaAnulacion) {
        if (fechaAnulacion > MAXIMO_MESES_ANTERIOR_ANULACION) {
            throw new IllegalArgumentException("la anulacion no es valida");
        }
        this.fechaAnulacion = fechaAnulacion;
    }

    //alumno


    //equals y hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matricula matricula = (Matricula) o;
        return idMatricula == matricula.idMatricula && Objects.equals(cursoAcademico, matricula.cursoAcademico) && Objects.equals(fechaMatriculacion, matricula.fechaMatriculacion) && Objects.equals(fechaAnulacion, matricula.fechaAnulacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMatricula, cursoAcademico, fechaMatriculacion, fechaAnulacion);
    }

    //imprimir
    public String imprimir() {
        return this.ordinal() + ".-" + this.cadenaAMostrar;
    }

    //toString

    @Override
    public String toString() {
        return "Matricula{" +
                "idMatricula=" + idMatricula +
                ", cursoAcademico='" + cursoAcademico + '\'' +
                ", fechaMatriculacion=" + fechaMatriculacion +
                ", fechaAnulacion=" + fechaAnulacion +
                '}';
    }
}
