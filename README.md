# ejemploJSF
Ejemplo inicial JSF (Java Server Faces)
* Añadido ejemplo REST con JAX-RS

#ESQUEMA
![Esquema del ejemplo](/doc/esquema.jpg?raw=true "Esquema del proyecto JSF + JAX-RS")


#PREVIO

* Instalación de NetBeans JEE con GlassFish
* Crear BD "pruebas_dagss" en MySQL
```
$ mysql -u root -p    [pedirá la contraseña de MySQL]

mysql> create database pruebas_dagss;
mysql> grant all privileges on pruebas_dagss.* to dagss@localhost identified by "dagss";
```
* Copiar driver JDBC de MySQL en el directorio de librerias de GlassFish
```
$ cp $HOME/cp $HOME/netbeans-8.2/ide/modules/ext/mysql-connector-java-5.1.23-bin.jar \       
              $HOME/glassfish-4.1.1/glassfish/domains/domain1/lib/
```
* Descargar copia del proyecto desde GitHub
```
git clone https://github.com/dagss2016/ejemploJSF.git
```
