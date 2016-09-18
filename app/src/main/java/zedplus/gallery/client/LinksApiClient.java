package zedplus.gallery.client;

import java.util.ArrayList;
import java.util.List;

import zedplus.gallery.client.model.Genre;
import zedplus.gallery.client.model.Movie;

/**
 * @author Anna Savinova
 */
public abstract class LinksApiClient implements ApiClient {

	protected static List<Genre> genres = new ArrayList<>();
	protected static List<Movie> movies = new ArrayList<>();

	static {

		Genre drama = new Genre(newId(), "Драма", "https://www.kinopoisk.ru/picture/2804404/");
		genres.add(drama);

		movies.add(new Movie(newId(), drama.getId(), "Девятая жизнь Луи Дракса", "https://www.kinopoisk.ru/picture/2804404/"));
		movies.add(new Movie(newId(), drama.getId(), "Дуэлянт", "https://www.kinopoisk.ru/picture/2801757/"));
		movies.add(new Movie(newId(), drama.getId(), "До встречи с тобой", "https://www.kinopoisk.ru/picture/2785700/"));
		movies.add(new Movie(newId(), drama.getId(), "Чудо на Гудзоне", "https://www.kinopoisk.ru/picture/2789263/"));
		movies.add(new Movie(newId(), drama.getId(), "Свет в океане", "https://www.kinopoisk.ru/picture/2801978/"));
		movies.add(new Movie(newId(), drama.getId(), "Под покровом ночи", "https://www.kinopoisk.ru/picture/2804303/"));
		movies.add(new Movie(newId(), drama.getId(), "Светская жизнь", "https://www.kinopoisk.ru/picture/2783142/"));


		Genre thriller = new Genre(newId(), "Триллер", "https://www.kinopoisk.ru/picture/2310026/");
		genres.add(thriller);

		movies.add(new Movie(newId(), thriller.getId(), "Инферно", "https://www.kinopoisk.ru/picture/2806170/"));


		Genre cartoon = new Genre(newId(), "Мультфильм", "https://www.kinopoisk.ru/picture/2310026/");
		genres.add(cartoon);

		movies.add(new Movie(newId(), cartoon.getId(), "Холодное сердце", "https://www.kinopoisk.ru/picture/2310026/"));
		movies.add(new Movie(newId(), cartoon.getId(), "Зверополис", "https://www.kinopoisk.ru/picture/2733676/"));
		movies.add(new Movie(newId(), cartoon.getId(), "Король Лев", "https://www.kinopoisk.ru/picture/1712991/"));
		movies.add(new Movie(newId(), cartoon.getId(), "Ледниковый период: Столкновение неизбежно", "https://www.kinopoisk.ru/picture/2766885/"));
		movies.add(new Movie(newId(), cartoon.getId(), "Тайная жизнь домашних животных", "https://www.kinopoisk.ru/picture/2743428/"));
		movies.add(new Movie(newId(), cartoon.getId(), "В поисках Дори", "https://www.kinopoisk.ru/picture/2766007/"));


		Genre horror = new Genre(newId(), "Ужасы", "https://www.kinopoisk.ru/picture/2310026/");
		genres.add(horror);

		movies.add(new Movie(newId(), horror.getId(), "Судная ночь 3", "https://www.kinopoisk.ru/picture/2773044/"));
		movies.add(new Movie(newId(), horror.getId(), "Неоновый демон", "https://www.kinopoisk.ru/picture/2785629/"));
		movies.add(new Movie(newId(), horror.getId(), "Отмель", "https://www.kinopoisk.ru/picture/2783284/"));


		Genre fantasy = new Genre(newId(), "Фэнтези", "https://www.kinopoisk.ru/picture/2310026/");
		genres.add(fantasy);

		movies.add(new Movie(newId(), fantasy.getId(), "Фантастические твари и где они обитают", "https://www.kinopoisk.ru/picture/2701935/"));
		movies.add(new Movie(newId(), fantasy.getId(), "Очень странные дела", "https://www.kinopoisk.ru/picture/2783384/"));
		movies.add(new Movie(newId(), fantasy.getId(), "Дом странных детей Мисс Перегрин", "https://www.kinopoisk.ru/picture/2735900/"));
		movies.add(new Movie(newId(), fantasy.getId(), "Доктор Стрэндж", "https://www.kinopoisk.ru/picture/2806181/"));
		movies.add(new Movie(newId(), fantasy.getId(), "Отряд самоубийц", "https://www.kinopoisk.ru/picture/2792086/"));
		movies.add(new Movie(newId(), fantasy.getId(), "Люди Икс: Апокалипсис", "https://www.kinopoisk.ru/picture/2802646/"));
		movies.add(new Movie(newId(), fantasy.getId(), "Валериан и город тысячи планет", "https://www.kinopoisk.ru/picture/2753280/"));
		movies.add(new Movie(newId(), fantasy.getId(), "Большой и добрый великан", "https://www.kinopoisk.ru/picture/2767094/"));


		Genre western = new Genre(newId(), "Вестерн", "https://www.kinopoisk.ru/picture/2040535/");
		genres.add(western);

		movies.add(new Movie(newId(), western.getId(), "Джанго освобожденный", "https://www.kinopoisk.ru/picture/2040535/"));
		movies.add(new Movie(newId(), western.getId(), "Великолепная семерка", "https://www.kinopoisk.ru/picture/2806942/"));

	}

	@Override
	public List<Movie> getMoviesByGenreId(long genreId) {
		List<Movie> moviesByGenre = new ArrayList<>();
		for (Movie movie : movies) {
			if (movie.getGenreId() == genreId) {
				moviesByGenre.add(movie);
			}
		}
		return moviesByGenre;
	}

	private static long newId() {
		return (long) (Math.random() * Long.MAX_VALUE);
	}

}
