package com.example.peoplecard;

public class Person {
    private String nombre;
    private String dni;
    private int edad;
    private String bio;
    private int imagen;

    public Person(int imagen,String nombre, String dni, int edad, String bio) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.bio = bio;
        this.imagen = imagen;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
