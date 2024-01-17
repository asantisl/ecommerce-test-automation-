# Proyecto de Automatización - Cobro Simple

Proyecto de automatización de test para pruebas de integración, sistema, aceptación y regresión.

*Este documento README incluye los pasos necesarios para poner en marcha la aplicación.*

---
### Primeros pasos

Con las siguientes instrucciones logrará el correcto funcionamiento del proyecto en su máquina local para fines de desarrollo y prueba.

#### Prerequisitos

Lo que se necesita para instalar el software:<br>

* **Java JDK** 8.x o superior. <br>El proyecto está configurado con ***Java JDK 11***, se puede descargar Java JDK 11 en el siguiente link [JDK11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
  
* **Maven** 3.x o superior. <br>Puedes descargar maven en el siguiente link [Maven](https://mvnrepository.com/)

---

### Building & Testing

Realizar la ejecución de los siguientes comandos:

```
 mvn clean       # Clean project
 mvn test        # Build & run test (no integration test)
 mvn verify      # Build, run integration test and run static code validation
 
 # Use this for task execution
 mvn clean verify
 mvn clean verify -Dtags="@regresion" 
 mvn clean verify -Denvironment=dev # Clean, run tests in an environment (default, dev, uat, prod)
 mvn clean verify -Dwebdriver.driver=chrome -Denvironment=dev # Clean, run tests in a browser (default, chrome, firefox, edge) and in an environment (default, dev, uat, prod)
 
```  
---                                             

## Authores

**Interbank**<br>

* Karen Estrada<br>
* Jean Carlo Perez<br>
* Adriana Leal<br>
* Julio Huaman
---
                           
## Clone a repository
Usamos Git para la integración del código, clonar el repositorio, además para bajar(pull) y subir(push) código [download and install first](https://git-scm.com/downloads). Si se prefiere clonar mediante lineas de commandos, ver [Clone a repository](https://confluence.atlassian.com/x/4whODQ).

Para una interacción más gráfica con Git utilizamos **Git Extensions**, [se puede descargar desde este link](http://gitextensions.github.io/).<br>
Para la integración del código es necesario las siguientes tareas:

1. Clonar el proyecto.
2. Hacer commit de los cambios trabajados.
3. Bajar el código (pull) y hacer merge.
4. Subir el código (push) al repositorio, en la rama develop.

Now that you're more familiar with your Bitbucket repository, go ahead and add a new file locally. You can [push your change back to Bitbucket with SourceTree](https://confluence.atlassian.com/x/iqyBMg), or you can [add, commit,](https://confluence.atlassian.com/x/8QhODQ) and [push from the command line](https://confluence.atlassian.com/x/NQ0zDQ).