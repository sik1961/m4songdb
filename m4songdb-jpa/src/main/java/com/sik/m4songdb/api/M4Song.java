/**
 * 
 */
package com.sik.m4songdb.api;

import org.joda.time.Duration;
import org.joda.time.LocalDateTime;

/**
 * @author sik
 *
 */
public interface M4Song {
	String getId();
	String getTitle();
	String getOrigArtist();
	Duration getDuration();
	LocalDateTime getDateLastGigged();
	LocalDateTime getDateLastRehearsed();
	boolean isActive();
	boolean isM3Able();
	
}
