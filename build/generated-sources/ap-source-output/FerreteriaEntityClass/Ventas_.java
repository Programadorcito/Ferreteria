package FerreteriaEntityClass;

import FerreteriaEntityClass.Clientes;
import FerreteriaEntityClass.Empleados;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-04T12:00:49")
@StaticMetamodel(Ventas.class)
public class Ventas_ { 

    public static volatile SingularAttribute<Ventas, Clientes> cliente;
    public static volatile SingularAttribute<Ventas, String> estado;
    public static volatile SingularAttribute<Ventas, String> numero;
    public static volatile SingularAttribute<Ventas, Empleados> empleado;
    public static volatile SingularAttribute<Ventas, String> direccionenvio;
    public static volatile SingularAttribute<Ventas, String> fechaventa;

}