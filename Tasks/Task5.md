# Задача 7

1. След влизане на потребител, да се запише сесина променлива с данните му.
2. При зареждане на профилната страница на потребителя да се използва обекта записан в сесията.
3. Добавете doGet метод в LoginServlet и RegisterServlet, който да връщат съответно login.jsp с формата за влизане и register.jsp с формата ререгистрация.
4. Ако потребителя записан в сесията направи опит да достъпи страницата за влизане или регистрация, да се пренасочи към профилната му страница, проверката да се прави в doGet метода на съответния Servlet.
5. Ако потребител, който няма активна сесия опита да достъпи профилната си страница да бъде пренасочен към страницата за вход
6. Да се добави линкове в хедъра "Вход" и "Регистрация" ако потребителя е влязал да има само един линк "Изход"
7. Когато влезе за първи път през деня потребител да се изпише съощение за "Добре дошли" и бутон изключи. След като потребителя натисне бутона изключи да се запази cookie, до края на деня, че съобщението вече е показано.

![image](https://user-images.githubusercontent.com/10382663/78857143-45210700-7a31-11ea-98ff-3cf706013a68.png)
