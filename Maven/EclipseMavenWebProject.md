# Web проект

Когато се създава Web Maven Project се използва архитипа maven-archetype-webapp. Проекта има следната структора:

```
ITWebApplication
|-- pom.xml
`-- src
    |-- main
    |   `-- resources
    |           `-- css
    |                `-- main.css
    |           `-- image
    |                `-- male.svg
    |                `-- woman.svg
    |    `-- webapp
    |           `-- index.jsp
    |   `-- WEB-INF
    |         `-- web.xml
```

Web приложения в JAVA се изграждат с servlet-api за което трябва да се добави зависимост в pom.xml файла на проекта 

```
  <dependencies>
    <dependency>
	    <groupId>javax.servlet</groupId>
	    <artifactId>javax.servlet-api</artifactId>
	    <version>4.0.1</version>
	    <scope>provided</scope>
    </dependency>
  </dependencies>
```

# Стартиране на проект

Избирате проекта, от бутона run изберете Run on server настройте пътя до Tomcat, за да се използва като сървър за изпълнение на приложенията. За Server name запишете Tomcat v9.0 Server at <факлтетния ви новер>
