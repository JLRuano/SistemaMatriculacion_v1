package org.iesalandalus.programacion.matriculacion;

import java.util.ArrayList;
import java.util.List;

public class Alumnos {

    private int capacidad;
    private int tamano;

    //paso 1.1 constructor
    private List<Alumno> ListaAlumnos;

    public Alumnos(int capacidad) {
        ListaAlumnos = new ArrayList<>(capacidad);
    }

    //paso 1.2 copia profunda
    public List<Alumno> get() {
        return copiaProfundaAlumnos(ListaAlumnos);
    }

    private List<Alumno> copiaProfundaAlumnos(List<Alumno> alumnos) {
        List<Alumno> copia = new ArrayList<>();
        for (Alumno alumno : alumnos) {
            copia.add(new Alumno(alumno));

        }
        return copia;
    }
        public int getTamano () {
            return tamano;
        }

        public int getCapacidad () {
            return capacidad;
        }

        //paso 1.3 insertar
        public void insertar(Alumno alumno) {
            if (alumno == null) {
                throw new IllegalArgumentException("el alumno no puede ser nulo");
            }
            if (!ListaAlumnos.contains(alumno)) {
                ListaAlumnos.add(alumno);
            } else {
                throw new IllegalArgumentException("El alumno ya dxiste");
            }
        }

        //paso 1.4 buscar
        public Alumno buscar(Alumno alumno) {
            int index = ListaAlumnos.indexOf(alumno);
            return index >= 0 ? new Alumno(ListaAlumnos.get(index)) : null;
        }
        //paso 1.5 borrar

    public void borrar(Alumno alumno) {
        if (alumno == null) {
            throw new IllegalArgumentException("el alumno no puede ser nulo");
        }
        int index = ListaAlumnos.indexOf(alumno);
        if (index >= 0) {
            ListaAlumnos.remove(index);
        } else {
            throw new IllegalArgumentException("El alumno no existe");
        }


}