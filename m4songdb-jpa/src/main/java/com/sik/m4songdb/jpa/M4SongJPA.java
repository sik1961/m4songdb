/**
 * 
 */
package com.sik.m4songdb.jpa;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.joda.time.Duration;
import org.joda.time.LocalDateTime;

import com.sik.jpa.DomainObject;
import com.sik.m4songdb.api.M4Song;

/**
 * @author sik
 *
 */
@Entity
@Table(name = "jpa_m4song")
public class M4SongJPA extends DomainObject implements M4Song {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String origArtist;
	private Duration duration;
	private LocalDateTime dateLastGigged;
	private LocalDateTime dateLastRehearsed;
	private boolean active;
	private boolean m3Able;
	
	/**
	 * @return
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * @return
	 */
	public String getOrigArtist() {
		return this.origArtist;
	}

	/**
	 * @return
	 */
	public Duration getDuration() {
		return this.duration;
	}

	/**
	 * @return
	 */
	public LocalDateTime getDateLastGigged() {
		return this.dateLastGigged;
	}

	/**
	 * @return
	 */
	public LocalDateTime getDateLastRehearsed() {
		return this.dateLastRehearsed;
	}

	/**
	 * @return
	 */
	public boolean isActive() {
		return this.active;
	}

	/**
	 * @return
	 */
	public boolean isM3Able() {
		return this.m3Able;
	}

	/**
	 * @return
	 */
	public boolean getActive() {
		return this.active;
	}

	/**
	 * @return
	 */
	public boolean getM3Able() {
		return this.m3Able;
	}
	
	/**
	 * @param title the title to set
	 * @return 
	 */
	public M4SongJPA setTitle(String title) {
		this.title = title;
		return this;
	}

	/**
	 * @param origArtist the origArtist to set
	 * @return 
	 */
	public M4SongJPA setOrigArtist(String origArtist) {
		this.origArtist = origArtist;
		return this;
	}

	/**
	 * @param duration the duration to set
	 * @return 
	 */
	public M4SongJPA setDuration(Duration duration) {
		this.duration = duration;
		return this;
	}

	/**
	 * @param dateLastGigged the dateLastGigged to set
	 * @return 
	 */
	public M4SongJPA setDateLastGigged(LocalDateTime dateLastGigged) {
		this.dateLastGigged = dateLastGigged;
		return this;
	}

	/**
	 * @param dateLastRehearsed the dateLastRehearsed to set
	 * @return 
	 */
	public M4SongJPA setDateLastRehearsed(LocalDateTime dateLastRehearsed) {
		this.dateLastRehearsed = dateLastRehearsed;
		return this;
	}

	/**
	 * @param active the active to set
	 * @return 
	 */
	public M4SongJPA setActive(boolean active) {
		this.active = active;
		return this;
	}

	/**
	 * @param m3Able the m3Able to set
	 * @return 
	 */
	public M4SongJPA setM3Able(boolean m3Able) {
		this.m3Able = m3Able;
		return this;
	}

	/**
	 * @return
	 */
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("M4SongJpa [title=");
		builder.append(this.title);
		builder.append(", origArtist=");
		builder.append(this.origArtist);
		builder.append(", duration=");
		builder.append(this.duration);
		builder.append(", dateLastGigged=");
		builder.append(this.dateLastGigged);
		builder.append(", dateLastRehearsed=");
		builder.append(this.dateLastRehearsed);
		builder.append(", active=");
		builder.append(this.active);
		builder.append(", m3Able=");
		builder.append(this.m3Able);
		builder.append("]");
		return builder.toString();
	}
	
	public static M4SongJPA fromInterface(M4Song m4Song) {
		return new M4SongJPA().setTitle(m4Song.getTitle())
			.setOrigArtist(m4Song.getOrigArtist())
			.setDuration(m4Song.getDuration())
			.setDateLastGigged(m4Song.getDateLastGigged())
			.setDateLastRehearsed(m4Song.getDateLastRehearsed())
			.setActive(m4Song.isActive())
			.setM3Able(m4Song.isM3Able());
	}
}
