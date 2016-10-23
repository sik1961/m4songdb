/**
 * 
 */
package com.sik.m4songdb.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.sik.m4songdb.api.M4Song;
import com.sik.m4songdb.api.M4SongService;
import com.sik.m4songdb.jpa.M4SongJPA;
import com.sik.m4songdb.repo.M4SongRepository;

/**
 * @author sik
 *
 */
public class M4SongServiceImpl implements M4SongService{
	
	@Autowired
	private M4SongRepository repo;
	
	public Collection<M4SongJPA> getAllSongs() {
		return repo.findAll();
	}
	
	public M4SongJPA getById(final String id) {
		return repo.findOne(id);
	}
	
	public M4SongJPA createSong(final M4Song song) {
		if (song.getId() != null && this.getById(song.getId()) != null) {
			throw new IllegalStateException("Error - Song already exists with ID: " + song.getId());
		}
		
		M4SongJPA jpa = M4SongJPA.fromInterface(song);
		this.repo.save(jpa);
		return this.repo.getOne(jpa.getId()); 
	}
	
	public M4SongJPA updateSong(final M4Song song) {
		M4SongJPA fromDb = repo.getOne(song.getId());
		
		if (fromDb == null) {
			throw new IllegalStateException("Error - No song found with ID: " + song.getId());
		}
		
		if (fromDb.getTitle() == null || !fromDb.getTitle().equals(song.getTitle())) {
			fromDb.setTitle(song.getTitle());
		}
		
		if (fromDb.getOrigArtist() == null || !fromDb.getOrigArtist().equals(song.getOrigArtist())) {
			fromDb.setOrigArtist(song.getOrigArtist());
		}
		
		if (fromDb.getDuration() == null || !fromDb.getDuration().equals(song.getDuration())) {
			fromDb.setDuration(song.getDuration());
		}
		
		if (fromDb.getDateLastGigged() == null || !fromDb.getDateLastGigged().equals(song.getDateLastGigged())) {
			fromDb.setDateLastGigged(song.getDateLastGigged());
		}
		
		if (fromDb.getDateLastRehearsed() == null || !fromDb.getDateLastRehearsed().equals(song.getDateLastRehearsed())) {
			fromDb.setDateLastRehearsed(song.getDateLastRehearsed());
		}
		
		if (fromDb.isActive() != song.isActive()) {
			fromDb.setActive(song.isActive());
		}
		
		if (fromDb.isM3Able() != song.isM3Able()) {
			fromDb.setM3Able(song.isM3Able());
		}
		
		return this.repo.save(fromDb);
		
	}
	
	public void deleteSong(final String idToDelete) {
		repo.delete(idToDelete);
	}
}
