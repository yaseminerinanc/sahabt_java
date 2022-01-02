package com.example.exercises;

import static java.lang.String.format;
import static java.lang.System.out;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise8 {
	private static final MovieService movieService = InMemoryMovieService.getInstance();

	public static void main(String[] args) {
		// Group the movies by the year and list them
		Collection<Movie> movies = movieService.findAllMovies();
		
		Map<Integer, String> movie = movies.stream().collect(groupingBy(Movie::getYear, mapping(Movie::getTitle, joining(","))));
        movie.entrySet().stream().sorted(comparing(Entry::getKey)).forEach(e -> out.println(format("%2d: %3s", e.getKey(), e.getValue())));

	}

}
