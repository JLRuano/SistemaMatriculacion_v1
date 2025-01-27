package org.iesalandalus.programacion.matriculacion;

public enum EspecialidadProfesorado {
    //paso 1 crear enumerado

    //paso 2 crear atributo
    INFORMATICA ("informatica"),
    SISTEMAS ("sistemas"),
    FOL ("FOL");

    private String cadenaAMostrar;
    //paso 3 crear el constructor
    EspecialidadProfesorado(String cadenaAMostrar) {
        this.cadenaAMostrar = cadenaAMostrar;
    }
    //paso 4 crear metodo imprimir
    public String imprimir() {
        return this.ordinal() + ".-" + this.cadenaAMostrar;
    }

    //paso 5 crear metodo toString


    @Override
    public String toString() {
        return "EspecialidadProfesorado{" +
                "cadenaAMostrar='" + cadenaAMostrar + '\'' +
                '}';
    }
}
