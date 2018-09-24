#Para realizar un grud

Para tomar de ejemplo describo como ejemplo el crud de conductor


   
1- Crear un repositorio
    Un repositorio en una interfaz donde de definen consultas no estandares a la base de datos,
    debera estar ubucado en el package "repositorio", y el nombre es la entidad + Repositorio
    o sea "ConductorRepositorio"
    y debe parecerce minimamente a esto...

      
```java
    
    package com.gmail.sanfrancisco.repositorio;
    
    
    import com.gmail.sanfrancisco.entidad.Conductor;
    import org.apache.deltaspike.data.api.*;
    
    @SuppressWarnings("CdiManagedBeanInconsistencyInspection")
    @Repository
    public interface ConductorRepositorio extends EntityRepository<Conductor, Long>, EntityManagerDelegate<Conductor> {
        @Query("SELECT u FROM Conductor u WHERE u.nombre like :filter or u.apellido like :filter")
        QueryResult<Conductor> findFiltered(
                @FirstResult int offset,
                @MaxResults int limit,
                @QueryParam("filter") String filter);
                
        @Query("SELECT COUNT(u) FROM Conductor u WHERE u.nombre like :filter or u.apellido like :filter")
        QueryResult<Conductor> countFiltered(
               @QueryParam("filter") String filter);                
    }
```
2- Crear un servicio modelo
    Este servicio se encarga de intermediar entre el crud y el repositorio
    Esta clase se ubica en el repositorio "serviciosModelo"
    Ej.
    
  ```java
   
    @Stateless
    public class ConductorService extends ServicioModelo<Conductor> {
        @Inject
        public ConductorService(ConductorRepositorio repo) {
            this.repo = repo;
        }
    
        @Override
        public Stream<Conductor> findAnyMatching(Object padre, String filtro, int offset, int limit, List<QuerySortOrder> sortOrders) {
            QueryResult<Conductor> result = ((ConductorRepositorio)repo).findFiltered( offset, limit, likePattern(filtro));
            return QueryHelper.applyLimitsAndSortOrder(result, offset, limit, sortOrders).getResultList().stream();
        }
    
        @Override
        public long countAnyMatching(Object padre, String filtro) {
            Long cnt = null;
            cnt = ((ConductorRepositorio) repo).countFiltered(filtro);
            return cnt;
        }
    }
```

3- Crear un proveedor de datos
    Un proveedor de datos es una clase que se encarga de ir pidiendo datos al servicio modelo, a medida que este lo requiera
    se utiliza en los componentes que requieran datos  multiples como grid, combos, etc.
    Se ubican en el package dataPrivider

    Ej.
    
```java
     @Dependent
    public class ConductorDataProvider extends FilterablePageableDataProvider<Conductor,Long, String> {
        @Inject
        public ConductorDataProvider(ServicioModelo<Conductor> servicio) {
            super(servicio, Arrays.asList(
                            new QuerySortOrder("apellido", SortDirection.ASCENDING),
                            new QuerySortOrder("nombre", SortDirection.ASCENDING))
                );
        }
    }
```

4- Todas las clases o interfaces anteriormente creada, son reutilizables en otros modulos que lo requieran, por eso estan en distintos packages generales.
   Ahora trabajeremos en el crud y utilizamos un package particular.
   Crear un package, con el nombre de la entidad... un package siempre va en minuscula, en nuestro caso "conductor"
   dentro de esta crear una clase para el "presenter", el modelo de CRUD es MVP (modelo, vista, presenter)
   con nombre <entidad>ListPresenter, en nuestro caso ConductorListPresenter  
   Ej.  
```java
public class ConductorListPresenter extends AbstractPresenterList<Conductor, ConductorService> {
    @Inject
    public ConductorListPresenter(ConductorService servicio, FilterablePageableDataProvider<Conductor, Long, String> dataProvider) {
        super(servicio, dataProvider);
    }
}
```   
5- Creamos una clase que es del que se encargara de armar el list o grilla.
   Con el nombre <entidad>LIst o sea ConductorList. 
   Ej. 

```java
public class ConductorList  extends AbstractList<Conductor> {
    @Inject
    public ConductorList(IPresenterList<Conductor> presenter) {
        super(presenter);
        setListaCols(Arrays.asList(
                new ColumnList<>(Conductor::getApellido,"Apellido","apellido", true),
                new ColumnList<>(Conductor::getNombre,"Nombre","nombre", true),
                new ColumnList<>(Conductor::getCuil,"C.U.I.L.","cuil", true)

        ));
    }

    @Override
    public String getTagVista() {
        return "CONDUCTOR";
    }

    @Override
    public Class<Conductor> getEntityType() {
        return Conductor.class;
    }

    @Override
    public String getTitulo() {
        return "Lista de Conductorres";
    }
}
```

6- Esta clase que crearemos es para mostrar un "prever" del registro activo, es opcional.
    Ej.
        
```java
   public class ConductorListPrever extends AbstractPreview<Conductor> {
        TextField id;
        TextField apellido;
        TextField nombre;
        TextField telefono;
        TextField celular;
    
        @Override
        public void crearElementos() {
            id          = textField("ID",       true);
            apellido    = textField("Apelldio", true);
            nombre      = textField("Apelldio", true);
            telefono    = textField("Telefono", false);
            celular     = textField("Celular", false);
        }
    
        @Override
        public void actualizar(Conductor item) {
            setValor(id,        Conductor::getId);
            setValor(apellido,  Conductor::getApellido);
            setValor(nombre,    Conductor::getNombre);
            setValor(telefono,  Conductor::getTelefono);
            setValor(celular,   Conductor::getCelular);
        }
    }
```

    

