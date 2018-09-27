# Para realizar un grud

Para tomar de ejemplo describo como ejemplo el crud de conductor

Primero crearemos clases generales que se utilizaran en el crud, y para otras cosas,
por eso lo voy a enumerar separadamente

##Tareas complementarias

### 1- Crear un repositorio
​    Un repositorio en una interfaz donde de definen consultas no estandares a la base de datos,
​    debera estar ubucado en el package "repositorio", y el nombre es la entidad + Repositorio
​    o sea "ConductorRepositorio"
​    y debe parecerce minimamente a esto...      

```java
    
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
###2- Crear un servicio modelo
​    El servicio modelo se encarga de intermediar entre el crud y el repositorio, y otras logica de negocio de la entidad.
​    Esta clase se ubica en el repositorio "serviciosModelo"
​        

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

###3- Crear un proveedor de datos
​    Un proveedor de datos es una clase que se encarga de ir pidiendo datos al servicio modelo, a medida que este lo requiera
​    se utiliza en los componentes que requieran datos  multiples como grid, combos, etc.
​    Se ubican en el package dataProvider

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

##Empezando un CRUD implementando el patron MVP

###1- Presenter del List

Todas las clases o interfaces anteriormente creada, son reutilizables en otros modulos que lo requieran, por eso estan en distintos packages generales.
   Ahora trabajeremos en el crud y utilizamos un package particular.
   Crear un package, con el nombre de la entidad... un package siempre va en minuscula, en nuestro caso "conductor"
   dentro de esta crear una clase para el "presenter", el modelo de CRUD es MVP (modelo, vista, presenter)
   con nombre <entidad>ListPresenter, en nuestro caso ConductorListPresenter  

```java
public class ConductorListPresenter extends AbstractPresenterList<Conductor, ConductorService> {
    @Inject
    public ConductorListPresenter(ConductorService servicio, FilterablePageableDataProvider<Conductor, Long, String> dataProvider) {
        super(servicio, dataProvider);
    }
}
```
###2- List

Creamos una clase que es del que se encargara de armar el list o grilla.
Con el nombre <entidad>List o sea ConductorList. 

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

###3- ListPrever

Esta clase que crearemos es para mostrar un "prever" del registro activo, es opcional.        

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

###4- Presenter del formulario

La siguiente clase antes de crear el form, es el presenter del form su nombre <entidad>FormPresenter
​    en nuestro ejemplo seria ConductorFormPresenter

 ```java
       public class ConductorFormPresenter extends AbstractPresenterForm<Conductor, ConductorService> {
        @Inject
        public ConductorFormPresenter(ConductorService servicio) {
            super(servicio);
        }
    }
 ```
###5-  Contenido del Form (innerForm)

El form conciste en dos parte, todo el contenido con las botoneras, titulos, etc.  (fom) y  el form propiamente dicho (innerForm)
Creamos el innerForm <entidad>InnerForm, en nuestro caso ConductorInnerForm
y la clase completa.

 ```java
    public class ConductorInnerForm extends DefaultInnerDialog<Conductor> {
    
        private TextField id;
        private TextField apellido;
        private TextField nombre;
        private TextField dni;
        private TextField cuil;
        private DatePicker fechaNacimiento;
        private TextField telefono;
        private TextField celular;
        private TextField operadoraTelefonica;
        private DatePicker fechaIngreso;
    
        public ConductorInnerForm(IPresentableForm<Conductor> presentable, String elTitulo) {
            super(presentable, elTitulo);
        }
    
        @Override
        protected Component generarForm() {
            id = textField("ID");
            apellido = textField("Apellido");
            nombre = textField("Nombre");
            dni = textField("DNI");
            cuil = textField("CUIL");
    
            fechaNacimiento = new DatePicker("Fecha Nacimiento");
            fechaNacimiento.setWidth("100%");
            fechaNacimiento.setRequired(true);
    
            telefono = textField("Nro. Telefono");
            celular = textField("Nro. Celular");
            operadoraTelefonica = textField("Operadora");
    
            Div form = new Div();
            form.setSizeFull();
            form.add(
                    envolver(id, "30%"),
                    envolver(apellido),
                    envolver(nombre),
                    envolver(dni,"50%"),
                    envolver(cuil, "50%"),
    
                    envolver(fechaNacimiento,"100%"),
                    envolver(telefono),
                    envolver(celular,"50%"),
                    envolver(operadoraTelefonica,"50%")
                );
           return form;
        }
    
        @Override
        public Focusable getPrimerElementoForm() {
            return id;
        }
    	
        //Puede se requiera bindear algun atributo....
    }
 ```

### 6. Form

Esta clase es la estructura principal del form, y utiliza el innerform para desplegar el contenido, creamos el laclase del form...  <entidad>Form, en nuestro caso ConductorForm y la clase completa: 

```java
public class ConductorForm extends AbstractForm<Conductor> {

    @Inject
    public ConductorForm(IPresenterForm<Conductor> presenter) {
        super(presenter);
    }

    @Override
    protected ILayoutInnerForm<Conductor> generarLayout(AbstractForm<Conductor> padre, String titulo) {
          return new ConductorInnerForm(padre, titulo);
    }

    @Override
    protected Focusable getPrimerElementoForm() {
        return null;
    }

    @Override
    public String getTagVista() {
        return "RCV_TAG_PARAM";
    }

    @Override
    public Class<Conductor> getEntityType() {
        return Conductor.class;
    }
}
```

### 7- La vista

La vista, o clase de la vista es la que te da el punto de entrada al crud. El nombre es <entidad>View, en nuestro caso ConductorView, y la clase completa seria asi...

```java
@Route(value="conductores", layout = MainView.class)
@PageTitle("Lista de Conductores")
@MenuIcon(VaadinIcon.SPECIALIST)
public class ConductorView extends AbstractDefaultView<Conductor> {
    @Inject
    public ConductorView(AbstractList<Conductor> list, AbstractPreview<Conductor> preview, AbstractForm<Conductor> form) {
        super(list, preview, form, EModoVista.EDITAR);
    }
}
```

