package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class SongRepository {

	   private List<Song> list = new ArrayList<Song>();

       public List<Song> getAllSongs() {
        return list;
       }

       public Song getSongById(Integer id) {
    	   for (Song song : list) {
    		   if(id.equals(song.getId())) {
    			   return song;
    		   }
    	   }
		return null;
}

       public void addSong(Song s) {
    	   list.add(s);
       }

       public void updateSong(Song s) {
    	   for (Song song : list) {
    		   if(s.getId().compareTo(song.getId()) == 0);
    	   }
       }

       public void removeSong(Song s) {
    	   list.remove(s);
       }
	
}
