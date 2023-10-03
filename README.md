## Pasos a seguir
1. Primero necesitamos agregar los persmisos de internet en AndroidManifest.xml 
2. Necesitamos agregar las dependencias en el build.gradle.kts además del id para no tener problemas con el kapt
3. Creamos nuestras capetas
    <div align="center">
        <img src="docs/discover.png" alt="Logo" width=32%>
    </div>
4. Una vez creamos las capetas comenzamos con los model que nos piden, hacemos la estructura de lo que queremos encontrar
5. Despues creamos su Entity donde pondremos el primary key y el nombre de la tabla
6. Pasamos a la carpeta remote donde crearemos el Product Response
7. Siguiendo crearemos el Product Service
8. Y por ultimo el ApiClient para que no halla ningun inconveniente
9. Ahora vamos a crear nuestro Product Dao en la carpeta local
10. y seguimos con el AppDatabase igualmente dentro de la carpeta local
11. creamos nuestra clase result en la capeta Util
12. y ahora si realizamos el repository
13. Una vez hecho el repository pasamos a crear los componentes
14. Primero el Search Bar