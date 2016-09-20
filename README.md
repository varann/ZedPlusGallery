# ZedPlusGallery
Тестовое задание для Zed+

APK: https://github.com/varann/ZedPlusGallery/releases/download/version%2F1.0.0/app-release.apk

Для запуска доступны две активности:
* Zed+ Gallery Settings -- можно переключать наборы жанров (1, 3, 4 и все доступные, т.е. 7).
* Zedplus Gallery -- галерея с жанрами и фильмами. По умолчанию, запускается с 3 жанрами.


##Имплементация своих жанров и фильмов

Чтобы добавить свой пункт в список доступных API для галереи, нужно:
* Унаследоваться от `zedplus.gallery.client.LinksApiClient` и использовать заполненные данные жанров и фильмов для вывода в методах `getGenres()` и `getMoviesByGenreId()`.
* Добавить новую имплементацию и ее имя в карту в классе `zedplus.gallery.client.ApiClient.Implementations`. 

Либо изменить вывод количества жанров в любой из четырех доступных имплементаций, которые находятся в пакете `zedplus.gallery.client`.
