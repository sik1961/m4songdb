/**
 * 
 */
package com.sik.m4songdb.api;

import java.util.Collection;

import com.sik.m4songdb.jpa.M4SongJPA;

/**
 * @author sik
 *
 */
public interface M4SongService {
	Collection<M4SongJPA> getAllSongs();
	M4SongJPA getById(String id);
	M4SongJPA createSong(M4Song song);
	M4SongJPA updateSong(M4Song song);
	void deleteSong(String id);
}