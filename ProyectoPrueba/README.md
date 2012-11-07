Proyecto de prueba para la asignatura TIW del grado de informática de la  Universidad Carlos III de Madrid
==========================================================================================================
 **Profesor:** David Palomar Delgado

Objetivos
---------    
    Este proyecto muestra el desarrollo de una infraestructura MVC en Java J2EE
    y servirá como base para la incorporación de otras tecnologías.
    
Estado actual:
--------------   
   + Comunicación entre jsps y Servlets y presentación a través de JSTL.
   + Añadido objeto de comprobación de errores
   + Añadidas Sesiones y Filtros de ejemplo
   + Añadido el cierre de sesión y retorno al login
   + Se recuperan los datos del listado desde **base de datos**
   + Se pueden crear, modificar y borrar usuarios en la base de datos
   + Se modifica el acceso a base de datos de local a un **DataSource** gestionado por el servidor
   + Se ha eliminado todo rastro de JDBC y se han sustituido los DAOs por Acceso **JPA** con un DataSource Jndi.

   
Entorno
-------
   + Desarrollado con Eclipse Indigo, jdk 1.6 y Glassfish 3.1.2.
   + Es posible que si dispones de otro entorno diferente eclipse muestre algunos errores en el proyecto. Para ello cambia los facets del proyecto (Menú propiedades del proyecto->Project Facets) ahí puedes elegir en la pestaña Runtime el servidor que tengas instalado y en la opción java cambiar el jdk.
   
