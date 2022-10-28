package edu.utez.mx.personaje.model;

import edu.utez.mx.personaje.utils.MySQL;
import edu.utez.mx.personaje.utils.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoPersonaje implements Repository {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    MySQL mysql = new MySQL();


    @Override
    public List<BeanPersonaje> findAll() {
        List<BeanPersonaje> personaje = new ArrayList<>();
        BeanPersonaje personaje1 = null;
        BeanMagia magia = null;
        BeanTLucha tlucha = null;
        try {
            conn = mysql.getConnection();
            String query = "Select pe.*, ma.namem FROM personaje pe"+
                    "JOIN position tl ON pe.namel = tl.namel";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                personaje1 = new BeanPersonaje();
                magia = new BeanMagia();
                tlucha = new BeanTLucha();
                personaje1.setId(rs.getLong("id"));
                personaje1.setName(rs.getString("Name"));
                personaje1.setLastname(rs.getString("Lastname"));
                personaje1.setBirthday(rs.getString("Birthday"));
                personaje1.setPeso(rs.getString("Peso"));
                personaje1.setEstatura(rs.getString("Estatura"));
                personaje1.setEquipo(rs.getInt("Equipo"));
                magia.setNamem(rs.getString("Nombre de la magia"));
                tlucha.setNamel(rs.getString("tipo de lucha"));
            }
        }catch (SQLException e){
            Logger.getLogger(DaoPersonaje.class.getName())
                    .log(Level.SEVERE, "Error -> finAll"+e.getMessage());
        }finally {
            mysql.close(conn, ps, rs);
        }
        return personaje;
    }

    @Override
    public Response findById(Long id) {
        List<BeanPersonaje> personaje = new ArrayList<>();
        BeanPersonaje personaje1 = null;
        BeanMagia magia = null;
        BeanTLucha tlucha = null;
        try {
            conn = mysql.getConnection();
            String query = "Select pe.*, ma.idm FROM personaje pe"+
                    "JOIN position tl ON pe.idl = tl.idl";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                personaje1 = new BeanPersonaje();
                magia = new BeanMagia();
                tlucha = new BeanTLucha();
                personaje1.setId(rs.getLong("id"));
                magia.setIdm(rs.getLong("id de magia"));
                tlucha.setIdl(rs.getLong("id de tipo de lucha"));
            }
        }catch (SQLException e){
            Logger.getLogger(DaoPersonaje.class.getName())
                    .log(Level.SEVERE, "Error -> finAll"+e.getMessage());
        }finally {
            mysql.close(conn, ps, rs);
        }
        return (Response) personaje;
    }

    @Override
    public Response<BeanPersonaje> save(BeanPersonaje object) {
        Response<BeanPersonaje> response = new Response<>();
        try {
            conn = mysql.getConnection();
            String query = "INSERT INTO  personal (name,lastname"+
                    "bisthday,peso,estatura,namem_idm,namel_idl) values (?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, object.getName());
            ps.setString(3, object.getLastname());
            ps.setString(4, object.getBirthday());
            ps.setString(5, object.getPeso());
            ps.setString(6, object.getEstatura());
            ps.setLong(7, object.getNamem().getIdm());
            ps.setLong(8, object.getNamel().getIdl());
            if (ps.executeUpdate() ==1 ) {
                response.setError(false);
                response.setStatus(100);
                response.getMessage("ok");
                response.setData(response.getData());
            }else {
                response.setError(false);
                response.setStatus(100);
                response.getMessage("Nothing found");
                response.setData(null);
            }

        }catch (SQLException e){
            Logger.getLogger(DaoPersonaje.class.getName())
                    .log(Level.SEVERE, "Error -> finAll"+e.getMessage());
        }finally {
            mysql.close(conn, ps, rs);
        }
        return null;
    }

    @Override
    public Response update(Object object) {
        List<BeanPersonaje> personaje = new ArrayList<>();
        BeanPersonaje personaje1 = null;
        BeanMagia magia = null;
        BeanTLucha tlucha = null;
        try {
            conn = mysql.getConnection();
            String query = "Select pe.*, ma.namem FROM personaje pe"+
                    "JOIN position tl ON pe.namel = tl.namel";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                personaje1 = new BeanPersonaje();
                magia = new BeanMagia();
                tlucha = new BeanTLucha();
                personaje1.setId(rs.getLong("id"));
                personaje1.setName(rs.getString("Name"));
                personaje1.setLastname(rs.getString("Lastname"));
                personaje1.setBirthday(rs.getString("Birthday"));
                personaje1.setPeso(rs.getString("Peso"));
                personaje1.setEstatura(rs.getString("Estatura"));
                personaje1.setEquipo(rs.getInt("Equipo"));
                magia.setNamem(rs.getString("Nombre de la magia"));
                tlucha.setNamel(rs.getString("tipo de lucha"));
            }
        }catch (SQLException e){
            Logger.getLogger(DaoPersonaje.class.getName())
                    .log(Level.SEVERE, "Error -> finAll"+e.getMessage());
        }finally {
            mysql.close(conn, ps, rs);
        }
        return (Response) personaje;
    }
}
