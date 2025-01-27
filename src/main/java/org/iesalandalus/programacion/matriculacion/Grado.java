package org.iesalandalus.programacion.matriculacion;

public enum Grado {


    //paso 1 creae enum con valores
     BASICO ("grado basico"),
    MEDIO("grado medio"),
    SUPERIOR("grado superior");

    //paso 2 crea el atributo cadenaAMostrar
    private String cadenaAMostrar;

    //paso 3 crea el constructor
    Grado (String cadenaAMostrar) {
        this.cadenaAMostrar = cadenaAMostrar;
    }

    //paso 4 crea el metodo imprimir
    public String imprimir() {
        return this.ordinal() + ".-" + this.cadenaAMostrar;
    }

    //paso 5 crea el metodo toString
    @Override
    public String toString() {
        return "Grado{" +
                "cadenaAMostrar='" + cadenaAMostrar + '\'' +
                '}';
    }
}
