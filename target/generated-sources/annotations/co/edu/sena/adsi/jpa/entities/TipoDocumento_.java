package co.edu.sena.adsi.jpa.entities;

import co.edu.sena.adsi.jpa.entities.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-26T10:30:50")
@StaticMetamodel(TipoDocumento.class)
public class TipoDocumento_ { 

    public static volatile SingularAttribute<TipoDocumento, String> descripcion;
    public static volatile ListAttribute<TipoDocumento, Usuarios> usuariosList;
    public static volatile SingularAttribute<TipoDocumento, Integer> idTipoDocumento;

}