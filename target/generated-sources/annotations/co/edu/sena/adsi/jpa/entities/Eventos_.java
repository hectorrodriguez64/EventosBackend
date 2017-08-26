package co.edu.sena.adsi.jpa.entities;

import co.edu.sena.adsi.jpa.entities.Asistencias;
import co.edu.sena.adsi.jpa.entities.Usuarios;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-26T11:54:31")
@StaticMetamodel(Eventos.class)
public class Eventos_ { 

    public static volatile SingularAttribute<Eventos, String> lugar;
    public static volatile SingularAttribute<Eventos, Date> fechaA;
    public static volatile SingularAttribute<Eventos, Date> fechaB;
    public static volatile SingularAttribute<Eventos, Integer> id;
    public static volatile SingularAttribute<Eventos, String> nombre;
    public static volatile SingularAttribute<Eventos, Asistencias> idAsistencias;
    public static volatile SingularAttribute<Eventos, Usuarios> idUsuarios;

}