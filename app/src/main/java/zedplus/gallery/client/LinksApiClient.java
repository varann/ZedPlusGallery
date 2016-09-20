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

		Genre drama = new Genre(newId(), "Драма", "https://st.kp.yandex.net/im/kadr/2/8/0/kinopoisk.ru-The-9th-Life-of-Louis-Drax-2804404.jpg");
		genres.add(drama);

		movies.add(new Movie(newId(), drama.getId(), "Девятая жизнь Луи Дракса", "https://st.kp.yandex.net/im/kadr/2/8/0/kinopoisk.ru-The-9th-Life-of-Louis-Drax-2804404.jpg"));
		movies.add(new Movie(newId(), drama.getId(), "Дуэлянт", "https://st.kp.yandex.net/im/kadr/2/8/0/kinopoisk.ru-Duelyant-2801757.jpg"));
		movies.add(new Movie(newId(), drama.getId(), "До встречи с тобой", "https://st.kp.yandex.net/im/kadr/2/7/8/kinopoisk.ru-Me-Before-You-2785700.jpg"));
		movies.add(new Movie(newId(), drama.getId(), "Чудо на Гудзоне", "https://st.kp.yandex.net/im/kadr/2/7/8/kinopoisk.ru-Sully-2789263.jpg"));
		movies.add(new Movie(newId(), drama.getId(), "Свет в океане", "https://st.kp.yandex.net/im/kadr/2/8/0/kinopoisk.ru-The-Light-Between-Oceans-2801978.jpg"));
		movies.add(new Movie(newId(), drama.getId(), "Под покровом ночи", "https://st.kp.yandex.net/im/kadr/2/8/0/kinopoisk.ru-Nocturnal-Animals-2809067.jpg"));
		movies.add(new Movie(newId(), drama.getId(), "Светская жизнь", "https://st.kp.yandex.net/im/kadr/2/7/8/kinopoisk.ru-Caf_26_23233_3B-Society-2783142.jpg"));


		Genre thriller = new Genre(newId(), "Триллер", "https://st.kp.yandex.net/im/kadr/2/8/0/kinopoisk.ru-Inferno-2806170.jpg");
		genres.add(thriller);

		movies.add(new Movie(newId(), thriller.getId(), "Инферно", "https://st.kp.yandex.net/im/kadr/2/8/0/kinopoisk.ru-Inferno-2806170.jpg"));


		Genre cartoon = new Genre(newId(), "Мультфильм", "https://st.kp.yandex.net/im/kadr/2/3/1/kinopoisk.ru-Frozen-2310026.jpg");
		genres.add(cartoon);

		movies.add(new Movie(newId(), cartoon.getId(), "Холодное сердце", "https://st.kp.yandex.net/im/kadr/2/3/1/kinopoisk.ru-Frozen-2310026.jpg"));
		movies.add(new Movie(newId(), cartoon.getId(), "Зверополис", "https://st.kp.yandex.net/im/kadr/2/7/3/kinopoisk.ru-Zootopia-2733676.jpg"));
		movies.add(new Movie(newId(), cartoon.getId(), "Король Лев", "https://st.kp.yandex.net/im/kadr/1/7/1/kinopoisk.ru-The-Lion-King-1712991.jpg"));
		movies.add(new Movie(newId(), cartoon.getId(), "Ледниковый период: Столкновение неизбежно", "https://st.kp.yandex.net/im/kadr/2/7/6/kinopoisk.ru-Ice-Age_3A-Collision-Course-2766885.jpg"));
		movies.add(new Movie(newId(), cartoon.getId(), "Тайная жизнь домашних животных", "https://st.kp.yandex.net/im/kadr/2/7/4/kinopoisk.ru-The-Secret-Life-of-Pets-2743428.jpg"));
		movies.add(new Movie(newId(), cartoon.getId(), "В поисках Дори", "https://st.kp.yandex.net/im/kadr/2/7/6/kinopoisk.ru-Finding-Dory-2766007.jpg"));


		Genre horror = new Genre(newId(), "Ужасы", "https://st.kp.yandex.net/im/kadr/2/7/7/kinopoisk.ru-The-Purge_3A-Election-Year-2773044.jpg");
		genres.add(horror);

		movies.add(new Movie(newId(), horror.getId(), "Судная ночь 3", "https://st.kp.yandex.net/im/kadr/2/7/7/kinopoisk.ru-The-Purge_3A-Election-Year-2773044.jpg"));
		movies.add(new Movie(newId(), horror.getId(), "Неоновый демон", "https://st.kp.yandex.net/im/kadr/2/7/8/kinopoisk.ru-The-Neon-Demon-2785629.jpg"));
		movies.add(new Movie(newId(), horror.getId(), "Отмель", "https://st.kp.yandex.net/im/kadr/2/7/8/kinopoisk.ru-The-Shallows-2783284.jpg"));


		Genre fantasy = new Genre(newId(), "Фэнтези", "https://st.kp.yandex.net/im/kadr/2/7/0/kinopoisk.ru-Fantastic-Beasts-and-Where-to-Find-Them-2701935.jpg");
		genres.add(fantasy);

		movies.add(new Movie(newId(), fantasy.getId(), "Фантастические твари и где они обитают", "https://st.kp.yandex.net/im/kadr/2/7/0/kinopoisk.ru-Fantastic-Beasts-and-Where-to-Find-Them-2701935.jpg"));
		movies.add(new Movie(newId(), fantasy.getId(), "Очень странные дела", "https://st.kp.yandex.net/im/kadr/2/7/8/kinopoisk.ru-Stranger-Things-2783384.jpg"));
		movies.add(new Movie(newId(), fantasy.getId(), "Дом странных детей Мисс Перегрин", "https://st.kp.yandex.net/im/kadr/2/7/3/kinopoisk.ru-Miss-Peregrine_27s-Home-for-Peculiar-Children-2735900.jpg"));
		movies.add(new Movie(newId(), fantasy.getId(), "Доктор Стрэндж", "https://st.kp.yandex.net/im/kadr/2/8/0/kinopoisk.ru-Doctor-Strange-2806181.jpg"));
		movies.add(new Movie(newId(), fantasy.getId(), "Отряд самоубийц", "https://st.kp.yandex.net/im/kadr/2/7/9/kinopoisk.ru-Suicide-Squad-2792086.jpg"));
		movies.add(new Movie(newId(), fantasy.getId(), "Люди Икс: Апокалипсис", "https://st.kp.yandex.net/im/kadr/2/7/6/kinopoisk.ru-X-Men_3A-Apocalypse-2762653.jpg"));
		movies.add(new Movie(newId(), fantasy.getId(), "Валериан и город тысячи планет", "https://st.kp.yandex.net/im/kadr/2/7/5/kinopoisk.ru-Valerian-and-the-City-of-a-Thousand-Planets-2753280.jpg"));
		movies.add(new Movie(newId(), fantasy.getId(), "Большой и добрый великан", "https://st.kp.yandex.net/im/kadr/2/7/6/kinopoisk.ru-The-BFG-2767094.jpg"));


		Genre western = new Genre(newId(), "Вестерн", "https://st.kp.yandex.net/im/kadr/2/0/4/kinopoisk.ru-Django-Unchained-2040535.jpg");
		genres.add(western);

		movies.add(new Movie(newId(), western.getId(), "Джанго освобожденный", "https://st.kp.yandex.net/im/kadr/2/0/4/kinopoisk.ru-Django-Unchained-2040535.jpg"));
		movies.add(new Movie(newId(), western.getId(), "Великолепная семерка", "https://st.kp.yandex.net/im/kadr/2/8/0/kinopoisk.ru-The-Magnificent-Seven-2806942.jpg"));


		Genre comedy = new Genre(newId(), "Комедия", "https://st.kp.yandex.net/im/kadr/1/8/7/kinopoisk.ru-Intouchables-1877733.jpg");
		genres.add(comedy);

		movies.add(new Movie(newId(), comedy.getId(), "1 + 1", "https://st.kp.yandex.net/im/kadr/1/8/7/kinopoisk.ru-Intouchables-1877733.jpg"));
		movies.add(new Movie(newId(), comedy.getId(), "Бриджит Джонс 3", "https://st.kp.yandex.net/im/kadr/2/7/1/kinopoisk.ru-Bridget-Jones_27s-Baby-2717333.jpg"));

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
