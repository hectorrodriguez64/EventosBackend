package co.edu.sena.adsi.jpa.entities;

import co.edu.sena.adsi.jpa.entities.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-26T12:34:05")
@StaticMetamodel(Equipos.class)
public class Equipos_ { 

    public static volatile SingularAttribute<Equipos, String> descripcion;
    public static volatile SingularAttribute<Equipos, String> marca;
    public static volatile SingularAttribute<Equipos, String> tipo;
    public static volatile SingularAttribute<Equipos, Integer> id;
    public static volatile SingularAttribute<Equipos, String> modelo;
    public static volatile SingularAttribute<Equipos, String> referencia;
    public static volatile SingularAttribute<Equipos, Usuarios> idUsuarios;

}