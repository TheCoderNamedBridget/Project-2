/**
 * This class creates a linked list and offers
 * methods to manipulate that linkedlist
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
			
			if ( currentNode.equals(newSong) ) {
				
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
			
			if ( currentNode.data.getYear() > decade && currentNode.data.getYear() < decade + 9 ) {
				
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
		
		Node firstNode = first;
		
		Node currentNode = first;
		
		int numTimesSorted = 0;
		

		boolean sorted = false;
		
		
		while ( !sorted ) {
			
			System.out.println("FirstNodew Value " + first.data.getTitle() + " " + first.data.getRating());
			
			sorted = true;
			
			System.out.println("Numtimessorted " + numTimesSorted );
			
			for (int i = 0; i < size(); i++) {

				Node nextNode = null;
				
				if ( currentNode != null ) {
					
					nextNode = currentNode.next;
					
					
				}
				

				if ( nextNode != null && currentNode != null) {
					
					System.out.println("CurrentNodesdifference "+ currentNode.data.getTitle() + currentNode.data.getRating() + " - " + nextNode.data.getTitle() + nextNode.data.getRating() +  " = "  + currentNode.data.compareTo( nextNode.data ));
					if ( currentNode.data.compareTo( nextNode.data ) < 0 && currentNode.data.compareTo( nextNode.data ) > -100) {//TODO Fix this part of the algorityhm
						

						System.out.println("CurrentNodeBEFORE : " + currentNode.data.getTitle() + " rating " + currentNode.data.getRating());
						System.out.println("NextNodeBEFORE " + nextNode.data.getTitle() + " rating " + nextNode.data.getRating());
						
						Song placeHolder = currentNode.data;
						
						currentNode.data = nextNode.data;
						
						nextNode.data = placeHolder;
						
						

						System.out.println("PlaceholderAFTER : " + placeHolder.getTitle() + " rating " + placeHolder.getRating());
						System.out.println("CurrentNodeAFTER : " + currentNode.data.getTitle() + " rating " + currentNode.data.getRating());
						System.out.println("NextNodeAFTER " + nextNode.data.getTitle() + " rating " + nextNode.data.getRating() + "\n");

						System.out.println("FirstNodeDown " + first.data.getTitle() + " " + first.data.getRating());
						if ( currentNode.equals( firstNode )) {
							
							firstNode = currentNode;
							
						}
						
						sorted = false;
						
					} 
					
					currentNode = currentNode.next;
					
					//System.out.println(" not stuck " ); 

				} 


				
			}
			//numTimesSorted +=1;
			
			System.out.println( "Sorted " + sorted  + " Numtimes " + numTimesSorted);
			if ( !sorted && currentNode.next == null ) {
			
			currentNode = first;
			numTimesSorted += 1;
			
			}
//			if ( !sorted && currentNode.next == null ) {
//				
//				currentNode = first;
//				numTimesSorted += 1;
//				
//			} else if ( sorted ) {
//				
//				while ( first != null) {
//					
//					System.out.println("Current Node " + first.data.getTitle() + " " + first.data.getRating()); 
//
//					first = first.next;
//
//					}
//				
//				return;
//				
//			}
			
			
			//checks if list is not sorted and if list is not sorted sets current node to the first node to start sort over again
			
			
			if ( numTimesSorted < 100 ) {
				System.out.println("numtimes " + numTimesSorted );
				
				Node placeHolderFirst = first;
				while ( first != null) {
					
					System.out.println("Current Node " + first.data.getTitle() + " " + first.data.getRating()); 

					first = first.next;

				}
				
				first = placeHolderFirst;
				if ( numTimesSorted == 9 ) {
					return;
				}
				
			}

			

		}
		
		
		
	}
	
	/**
	 * Displays the whole list of songs
	 */
	public void display () {
		
		Node currentNode = first;
		
		//System.out.println( currentNode.data.toString() );
		
		System.out.println( "HERE " + size());
		
		for (int i = 0; i < size(); i ++) {
			
			
			
			System.out.println( currentNode.data.toString() );
			
			if ( currentNode.next != null ) {
				
				currentNode = currentNode.next;
				
			}
			//
			
		}
		
	}
	
	/**
	 * 
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
