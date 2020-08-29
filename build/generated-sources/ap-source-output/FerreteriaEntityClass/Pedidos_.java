package FerreteriaEntityClass;

import FerreteriaEntityClass.DetallePedido;
import FerreteriaEntityClass.Proveedores;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-04T12:00:49")
@StaticMetamodel(Pedidos.class)
public class Pedidos_ { 

    public static volatile SingularAttribute<Pedidos, String> fechapedido;
    public static volatile SingularAttribute<Pedidos, String> estado;
    public static volatile SingularAttribute<Pedidos, String> numero;
    public static volatile SingularAttribute<Pedidos, Proveedores> proveedor;
    public static volatile CollectionAttribute<Pedidos, DetallePedido> detallePedidoCollection;
    public static volatile SingularAttribute<Pedidos, String> cuotas;
    public static volatile SingularAttribute<Pedidos, String> formapago;

}