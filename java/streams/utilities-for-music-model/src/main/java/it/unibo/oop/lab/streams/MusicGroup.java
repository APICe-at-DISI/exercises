package it.unibo.oop.lab.streams;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Stream;

/**
 * This interface represents a music group, which is a collection of albums and songs.
 */
public interface MusicGroup {

    /**
     * Adds an album to the music group.
     *
     * @param albumName
     *            album name
     * @param year
     *            album year
     */
    void addAlbum(String albumName, int year);

    /**
     * Adds a song to the music group.
     *
     * @param songName
     *            song title
     * @param albumName
     *            album name
     * @param duration
     *            duration
     */
    void addSong(String songName, Optional<String> albumName, double duration);

    /**
     * Returns a stream of all the songs for this group, ordered by name.
     *
     * @return all the songs for this group, ordered by name
     */
    Stream<String> orderedSongNames();

    /**
     * Returns a stream of all the albums for this group.
     *
     * @return all the albums of this group
     */
    Stream<String> albumNames();

    /**
     * Returns a stream of all the albums for this group in the given year.
     *
     * @param year
     *            the year
     * @return all the albums in the given year
     */
    Stream<String> albumInYear(int year);

    /**
     * Counts the number of songs in the given album.
     *
     * @param albumName
     *            album name
     * @return number of songs
     */
    int countSongs(String albumName);

    /**
     * Counts the number of songs not included in albums.
     *
     * @return the number of songs not included in albums
     */
    int countSongsInNoAlbum();

    /**
     * Calculates the average duration of songs in the given album.
     *
     * @param albumName
     *            the album name
     * @return average track length for the album
     */
    OptionalDouble averageDurationOfSongs(String albumName);

    /**
     * Returns the longest song.
     *
     * @return the longest song
     */
    Optional<String> longestSong();

    /**
     * Returns the longest album.
     *
     * @return the longest album
     */
    Optional<String> longestAlbum();
}
