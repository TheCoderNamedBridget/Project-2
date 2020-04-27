/**
 * This class creates a linked list and offers
 * methods to manipulate that linked list
 * @Bridget Naylor
 * @date 4/26/20
 */

import java.util.ArrayList;

public class LinkedList {

	//first node of the linked list
	private Node first;
	
	//last node of the linked list
	private Node last;
	
	/**
	 * Constructor for linked list
	 */
	public LinkedList() {
		
		first = null;
		last = null;
		
	}
	
	/**
	 * Checks if LinkedList is empty
	 * @return true if first node == null
	 */
	public boolean isEmpty( ) {
		
		return first == null;
		
	}
	
	/**
	 * adds a song to the linked List
	 * @param s song to be added
	 */
	public void add( Song s ) {
		
		if( first == null ) {
			
			first = new Node( s );
			
			last = first;
			
		} else {
			
			Node n = new Node( s );
			
			last.next = n;
			
			last = n;
			
			}
		}
	
	/**
	 * Gets the size of the linked list
	 * @return int the size of the linked list
	 */
	public int size( ) {
		
		int count = 0;
		
		Node n = first;
		
		while( n != null ) {
			
			count++;
			
			n = n.next;
			
		}
		
		return count;
		
	}
	
	/**
	 * Removes and returns the top song on the list
	 * @return Song the removed song from the list
	 */
	public Song remove () {
		
		Node placeholder = first.next;
		
		Node originalFirst = first;
		
		first = placeholder;
		
		return originalFirst.data;
		
		
	}
	
	/**
	 * Searches and returns the song that matches the title and artist given
	 * @param title given
	 * @param artist given
	 * @return Song that matches the title and artist given
	 */
	public Song searchSong( String title, String artist ) {
		
		int sizeOfList = size();
		
		Node currentNode = first;
		
		Song newSong = new Song( title, artist );
		
		for (int i = 0; i < sizeOfList; i++) {
			
			if ( currentNode.data.equals(newSong) ) {
				
				return newSong;
				
			}
			currentNode = currentNode.next;
			
		}
		return null;

	}
	
	/**
	 * Searches for songs by an artist and returns a list of the songs
	 * @param name of artist
	 * @return Arraylist of songs by artist
	 */
	public ArrayList<Song> searchArtist( String name ) {
		
		ArrayList<Song> songsByArtist = new ArrayList<Song>();
		
		int sizeOfList = size();
		
		Node currentNode = first;
		
		for (int i = 0; i < sizeOfList; i++) {
			
			if ( currentNode.data.getArtist().equalsIgnoreCase( name )) {
				
				songsByArtist.add( currentNode.data );
				
			}
			
			currentNode = currentNode.next;
			
		}
		
		return songsByArtist;
	}
	
	/**
	 * Searches for songs written in a particular decade and returns a list of those songs
	 * @param decade of song
	 * @return Arraylist of songs written in that decade
	 */
	public ArrayList<Song> searchDecade( int decade ) {
		
		String stringOfDecade = String.valueOf( decade );
		
		if ( stringOfDecade.substring(2, 3).equalsIgnoreCase("0") ) {
			
			decade = Integer.valueOf( stringOfDecade.substring(0, 2) ) * 10;
			
		}
		
		ArrayList<Song> songsInDecade = new ArrayList<Song>();
		
		int sizeOfList = size();
		
		Node currentNode = first;
		
		for (int i = 0; i < sizeOfList; i++) {
			
			if ( currentNode.data.getYear() >= decade && currentNode.data.getYear() <= decade + 9 ) {
				
				songsInDecade.add( currentNode.data );
				
			}
			
			currentNode = currentNode.next;
			
		}
		
		return songsInDecade;
	}
	

	/**
	 * Sorts the list of songs with bubble sort
	 * so that the highest ranked songs show up first
	 */
	public void sort () {
		
		//keeps track of the head of the linked list
		Node firstNode = first;
		
		//keeps track of the current node
		Node currentNode = first;

		//true if list is sorted, false otherwise
		boolean sorted = false;
		
		//Repeats iteration and bubble sorting until the list is sorted
		while ( !sorted ) {
			
			//sets sorted to true
			sorted = true;
			
			//iterates through linked list to swap smaller ratings with larger rating
			for (int i = 0; i < size(); i++) {

				Node nextNode = null;
				
				if ( currentNode != null ) {//checks if next node is usable
					
					nextNode = currentNode.next;
					
				}
				

				//checks to make sure next node and current node are not null
				if ( nextNode != null && currentNode != null) {
					
					//checks if current node's rating is larger than next node's rating
					if ( currentNode.data.compareTo( nextNode.data ) < 0 && currentNode.data.compareTo( nextNode.data ) > -100) {
						
						//swapping the current node and next node's data if current node rating > next node rating
						Song placeHolder = currentNode.data;
						
						currentNode.data = nextNode.data;
						
						nextNode.data = placeHolder;
						
						//if a value later in the list has the greatest rating it will be set as the new head of the linked list
						if ( currentNode.equals( firstNode )) {
							
							firstNode = currentNode;
							
						}
						
						//a swap was made so sorted = false
						sorted = false;
						
					} 
					
					//moving on to the next node
					currentNode = currentNode.next;


				} 


				
			}

			//if list is iterated through but there was a swap then restart at the new first value of the list
			if ( !sorted && currentNode.next == null ) {
			
				currentNode = first;
			
			}

		}
		
	}
	
	/**
	 * Displays the whole list of songs
	 */
	public void display () {
		
		Node currentNode = first;
		
		System.out.println( "Number of Songs: " + size());
		
		for (int i = 0; i < size(); i ++) {

			System.out.println( currentNode.data.toString() );
			
			if ( currentNode.next != null ) {
				
				currentNode = currentNode.next;
				
			}
		}	
	}
	
	/**
	 * Represents the data in a string format
	 */
	@Override public String toString( ) {
		
		String str = "";
		
		Node n = first;
		while( n != null ) {
			
			str = str + n.data.getTitle() + "," + n.data.getArtist() + "," + n.data.getYear() + "," + n.data.getRating() + "/n";;
			
			n = n.next;
			
		}
		
		return str;
	}
}
