package com.vickikbt.shared.data.network

import com.vickikbt.shared.data.network.models.*
import io.github.aakira.napier.Napier
import io.ktor.client.*
import io.ktor.client.request.*

class ApiServiceImpl constructor(private val httpClient: HttpClient) : ApiService {

    override suspend fun fetchNowPlayingMovies(page: Int, language: String): NowPlayingMoviesDto? {
        return try {
            httpClient.get<NowPlayingMoviesDto>(urlString = "movie/now_playing") {
                parameter("page", page)
                parameter("language", language)
            }
        } catch (e: Exception) {
            Napier.e("Error: ${e.message}")
            null
        }
    }

    override suspend fun fetchPopularMovies(page: Int, language: String): PopularMoviesDto? {
        return try {
            httpClient.get<PopularMoviesDto>(urlString = "movie/popular") {
                parameter("page", page)
                parameter("language", language)
            }
        } catch (e: Exception) {
            Napier.e("Error: ${e.message}")
            null
        }
    }

    override suspend fun fetchTrendingMovies(
        mediaType: String,
        timeWindow: String,
        page: Int
    ): TrendingMoviesDto? {
        return try {
            httpClient.get<TrendingMoviesDto>(urlString = "trending/$mediaType/$timeWindow") {
                parameter("page", page)
            }
        } catch (e: Exception) {
            Napier.e("Error: ${e.message}")
            null
        }
    }

    override suspend fun fetchUpcomingMovies(page: Int, language: String): UpcomingMoviesDto? {
        return try {
            httpClient.get<UpcomingMoviesDto>(urlString = "movie/upcoming") {
                parameter("page", page)
                parameter("language", language)
            }
        } catch (e: Exception) {
            Napier.e("Error: ${e.message}")
            null
        }
    }

    override suspend fun fetchMovieDetails(movieId: Int, language: String): MovieDetailsDto? {
        return try {
            httpClient.get<MovieDetailsDto>(urlString = "movie/{movie_id}") {
                parameter("movie_id", movieId)
                parameter("language", language)
            }
        } catch (e: Exception) {
            Napier.e("Error: ${e.message}")
            null
        }
    }

    override suspend fun fetchMovieCast(movieId: Int, language: String): CastDto? {
        return try {
            httpClient.get<CastDto>(urlString = "movie/{movie_id}/credits") {
                parameter("movie_id", movieId)
                parameter("language", language)
            }
        } catch (e: Exception) {
            Napier.e("Error: ${e.message}")
            null
        }
    }

    override suspend fun fetchMovieVideos(movieId: Int, language: String): MovieVideoDto? {
        return try {
            httpClient.get<MovieVideoDto>(urlString = "movie/{movie_id}/videos") {
                parameter("movie_id", movieId)
                parameter("language", language)
            }
        } catch (e: Exception) {
            Napier.e("Error: ${e.message}")
            null
        }
    }

    override suspend fun fetchSimilarMovies(page: Int, language: String): SimilarMoviesDto? {
        return try {
            httpClient.get<SimilarMoviesDto>(urlString = "movie/{movie_id}/similar") {
                parameter("page", page)
                parameter("language", language)
            }
        } catch (e: Exception) {
            Napier.e("Error: ${e.message}")
            null
        }
    }
}
