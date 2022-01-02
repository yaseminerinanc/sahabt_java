package com.example.exercises;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.domain.Genre;
import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise7 {
	private static final MovieService movieService = InMemoryMovieService.getInstance();

	public static void main(String[] args) {
		// Find the list of movies having the genres "Drama" and "Comedy" only
		
		final Collection<Movie> movies = movieService.findAllMovies();
		
		  Stream<List<Genre>> dramaMovies= movies.stream()
				.map(Movie::getGenres)
				.filter((Predicate<? super List<Genre>>)
				(g -> ((Genre) g).getName().equals("Drama")));
		  
		  Stream<List<Genre>> comedyMovies= movies.stream()
					.map(Movie::getGenres)
					.filter((Predicate<? super List<Genre>>)
					(g -> ((Genre) g).getName().equals("Comedy")));
		  
		  
		 Stream merged =Stream.concat(dramaMovies, comedyMovies);
		 List <Movie> list = (List) merged.collect(Collectors.toList());
		 
		 list.forEach(c -> System.out.printf("%20s : %3\n ",c.getGenres().stream().map(Genre::getName)));

	}

}
