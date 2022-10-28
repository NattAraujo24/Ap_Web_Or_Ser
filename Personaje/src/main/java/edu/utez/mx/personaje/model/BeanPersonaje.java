package edu.utez.mx.personaje.model;

public class BeanPersonaje {
    Long  id;
    String name;
    String lastname;
    String birthday;
    boolean utiliza_magia;
    String estatura;
    String peso;
    int equipo;
    BeanMagia idm;
    BeanMagia namem;
    BeanTLucha idl;
    BeanTLucha namel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isUtiliza_magia() {
        return utiliza_magia;
    }

    public void setUtiliza_magia(boolean utiliza_magia) {
        this.utiliza_magia = utiliza_magia;
    }

    public String getEstatura() {
        return estatura;
    }

    public void setEstatura(String estatura) {
        this.estatura = estatura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public int getEquipo() {
        return equipo;
    }

    public void setEquipo(int equipo) {
        this.equipo = equipo;
    }

    public BeanMagia getIdm() {
        return idm;
    }

    public void setIdm(BeanMagia idm) {
        this.idm = idm;
    }

    public BeanMagia getNamem() {
        return namem;
    }

    public void setNamem(BeanMagia namem) {
        this.namem = namem;
    }

    public BeanTLucha getIdl() {
        return idl;
    }

    public void setIdl(BeanTLucha idl) {
        this.idl = idl;
    }

    public BeanTLucha getNamel() {
        return namel;
    }

    public void setNamel(BeanTLucha namel) {
        this.namel = namel;
    }
}
