# Създаване на Maven проект в Eclipse IDE

Eclipse поддържа разширение за работа с Maven, което може да се инсталира от Help -> Install New Softuware... избирате Add и изтегляте от хранилището
Name : M2Eclipse
Location : http://download.eclipse.org/technology/m2e/releases

Може да се изтегли версия на Eclipse IDE с поддръжка за web приложения на Java която съдържа Mavan:

https://www.eclipse.org/downloads/packages/ 

https://tomcat.apache.org/download-90.cgi

## Създаване на нов проект 

File -> New Maven Project

![step1.png](https://github.com/theVelislavKolesnichenko/IT/blob/master/Maven/Image/step1.png)

- От първия прозорец се избира директория на проекта:

![step1.png](https://github.com/theVelislavKolesnichenko/IT/blob/master/Maven/Image/step2.png)

- От втория прозорец се избира типа на проекта, първия тип който ще направим е "maven-archetype-quickstart"

![step1.png](https://github.com/theVelislavKolesnichenko/IT/blob/master/Maven/Image/step3.png)

- От третия прозорец се въвежда groupId, artifactId и version

Когато проекта е настроен избирате Finish

## Задача

Съставете програма която да дефинира геометрични фигури (триъгълник, квадрат, окръжност). Комбинация от геометрични фигури образуват етаж в къща. На стандартния вгохд се подава брой къщи, след това брой етажи, на нов ред фигурите от които се състой един етаж. Да се намери къщата с най-голям обем и да се изведат етажите на къщата подредени по нарастваща площ. Правоъгълнижите и триъгълниците се допират, за да образуват площа на етаж, окръжността не може да се допре до друга фигура тя влиза на 50% в другата фугура, за да образува площа на етаж.

Примерен вход:
```
3
2
triangle: 10 20 10; rectangle: 20 50;
circle: 5; rectangle: 5, 10;
1
triangle: 10 20 10; rectangle: 20 50;
3
triangle: 10 20 10; rectangle: 20 50;
circle: 5; rectangle: 5, 10;
triangle: 5
```
