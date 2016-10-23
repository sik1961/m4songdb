/**
 * 
 */
package com.sik.m4songdb.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sik.m4songdb.jpa.M4SongJPA;

/**
 * @author sik
 *
 */
public interface M4SongRepository extends JpaRepository<M4SongJPA,String>{

}
