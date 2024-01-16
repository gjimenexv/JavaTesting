package com.platzi.javatests.movies.service;

import com.platzi.javatests.movies.data.MovieRepository;
import com.platzi.javatests.movies.model.Genre;
import com.platzi.javatests.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.mockito.Mockito;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MovieServiceShould {

  private MovieService movieService;

  @Before
  public void setUp() throws Exception {

    MovieRepository movieRepository = Mockito.mock(MovieRepository.class);

    Mockito.when(movieRepository.findAll()).thenReturn(
            Arrays.asList(
                    new Movie(1, "Dark Knight", 152, Genre.ACTION),
                    new Movie(2, "Memento", 113, Genre.THRILLER),
                    new Movie(3, "There's Something About Mary", 119, Genre.COMEDY),
                    new Movie(4, "Super 8", 112, Genre.THRILLER),
                    new Movie(5, "Scream", 111, Genre.HORROR),
                    new Movie(6, "Home Alone", 103, Genre.COMEDY),
                    new Movie(7, "Matrix", 136, Genre.ACTION)
            )
    );
    movieService = new MovieService(movieRepository);
  }

  @Test
  public void return_movies_by_genre() {

    Collection<Movie> moviesByGenre = movieService.findMoviesByGenre(Genre.COMEDY);
    assertThat(getMoviesIds(moviesByGenre), CoreMatchers.is(Arrays.asList(3,6)));
  }
  @Test
  public void return_movies_by_length() {
    Collection<Movie> moviesByLength = movieService.findMoviesByLength(119);
    assertThat(getMoviesIds(moviesByLength), CoreMatchers.is(Arrays.asList(2,3,4,5,6)));
  }
  private static List<Integer> getMoviesIds(Collection<Movie> moviesByGenre) {
    return moviesByGenre.stream().map(Movie::getId).collect(Collectors.toList());
  }

  @Nested
  @DisplayName("when searching movies by multiple attributes")
  class SearchByTemplateMethod {

    @Test
    @DisplayName("using id")
    void whenUsingId() {
      Collection<Movie> movies = movieService.findByTemplate(new Movie(5, null, null, Genre.ACTION, null));
      assertEquals(Collections.singletonList(5), getMoviesIds(movies));
    }

    @Test
    @DisplayName("using negative minutes")
    void whenUsingNegativeMinutes() {
      assertThrows(
              IllegalArgumentException.class,
              () -> movieService.findByTemplate(new Movie(null, null, -15, Genre.ACTION, null))
      );
    }

    @Test
    @DisplayName("using genre and minutes")
    void whenUsingGenreAndMinutes() {
      Collection<Movie> movies = movieService.findByTemplate(new Movie(null, null, 180, Genre.ACTION, null));
      assertEquals(Arrays.asList(1, 5), getMoviesIds(movies));
    }

    @Test
    @DisplayName("using name and minutes")
    void whenUsingNameAndMinutes() {
      Collection<Movie> movies = movieService.findByTemplate(new Movie(null, "annabelle", 100, null, null));
      assertEquals(Collections.singletonList(7), getMoviesIds(movies));
    }

    @Test
    @DisplayName("using director and minutes")
    void whenUsingDirectorAndMinutes() {
      Collection<Movie> movies = movieService.findByTemplate(new Movie(null, null, 110, null, "Chris"));
      assertEquals(Collections.singletonList(4), getMoviesIds(movies));
    }
  }
}