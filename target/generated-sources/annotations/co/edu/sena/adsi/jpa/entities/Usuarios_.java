package co.edu.sena.adsi.jpa.entities;

import co.edu.sena.adsi.jpa.entities.Equipos;
import co.edu.sena.adsi.jpa.entities.Eventos;
import co.edu.sena.adsi.jpa.entities.TipoDocumento;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-26T10:30:50")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, String> apellidos;
    public static volatile SingularAttribute<Usuarios, String> numDocumento;
    public static volatile SingularAttribute<Usuarios, String> password;
    public static volatile ListAttribute<Usuarios, Equipos> equiposList;
    public static volatile ListAttribute<Usuarios, Eventos> eventosList;
    public static volatile SingularAttribute<Usuarios, TipoDocumento> idTipoDocumento;
    public static volatile SingularAttribute<Usuarios, Integer> idUsuarios;
    public static volatile SingularAttribute<Usuarios, String> email;
    public static volatile SingularAttribute<Usuarios, String> nombres;
    public static volatile SingularAttribute<Usuarios, Boolean> activo;

}