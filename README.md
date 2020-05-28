# MVP Book Reader Imitation
*Приложение создано в учебных целях для пробы технологий, дизайну значение не предавалось*

* [Описание приложения](#about)
* [Отличительные особенности модулей](#module)
  * [mvp](#mvp)
  * [moxy](#moxy)
  * [daggermoxy](#daggermoxy)


### <a name="about"></a>Описание:
Приложение пролистывает отрывки из двух книг (Беляев А.Р. "Голова профессора Доуэля", Булгаков М.А. "Мастер и Маргарита"). 
Переключение между авторами, имитация загрузки страниц и перелистывание старниц.  
Приложение состоит из модулей с одинаковым функционалом, но с с использованием разных технологий. 
***
### <a name="module"></a>Отличительные особенности модулей:
#### <a name="mvp"></a>mvp:
Простой MVP с имитацией репозитория и use cases.
Работа с репозиторием через kotlinx-**coroutines**

#### <a name="moxy"></a>moxy:
Это модуль mvp, в котором для реализации MVP использовалась библиотека tech.schoolhelper:**moxy**-x.  
В качестве пробы добавлен **BehaviorSubject** из RX библиотеки.  

#### <a name="daggermoxy"></a>daggermoxy:
Это модуль moxy, в котором добавлена Dependency Injection библиотека **Dagger 2**
