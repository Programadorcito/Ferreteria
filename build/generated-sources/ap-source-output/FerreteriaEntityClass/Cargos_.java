package FerreteriaEntityClass;

import FerreteriaEntityClass.Empleados;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-04T12:00:49")
@StaticMetamodel(Cargos.class)
public class Cargos_ { 

    public static volatile SingularAttribute<Cargos, String> estado;
    public static volatile SingularAttribute<Cargos, String> numero;
    public static volatile CollectionAttribute<Cargos, Empleados> empleadosCollection;
    public static volatile SingularAttribute<Cargos, String> salario;
    public static volatile SingularAttribute<Cargos, String> nombre;

}