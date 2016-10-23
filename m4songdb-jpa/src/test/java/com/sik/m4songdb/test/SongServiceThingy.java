/**
 * 
 */
package com.sik.m4songdb.test;

import static org.junit.Assert.assertTrue;

import org.joda.time.Duration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.ServletTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.sik.m4songdb.jpa.M4SongJPA;
import com.sik.m4songdb.repo.M4SongRepository;

/**
 * @author sik
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = TestSongServiceContextConfiguration.class)
//@TestExecutionListeners(listeners = { ServletTestExecutionListener.class, DependencyInjectionTestExecutionListener.class,
//	    DirtiesContextTestExecutionListener.class, TransactionalTestExecutionListener.class })
@Transactional()
public class SongServiceThingy {

	@Autowired
	private M4SongRepository repo;
	
	@Test
	public void test1() {
		M4SongJPA s1 = new M4SongJPA();
		s1.setTitle("Blobby");
		s1.setOrigArtist("Mr.Blobby");
		s1.setDuration(new Duration(4,0));
		s1.setActive(false);
		s1.setM3Able(false);
		
		M4SongJPA newThing = repo.save(s1);
		
		assertTrue(repo.findAll().size()==1);
		
		assertTrue(repo.findOne(newThing.getId()) != null);
		
		
		
	}

}
