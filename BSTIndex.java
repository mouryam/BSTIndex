/*
THIS CODE WAS MY OWN WORK , IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS . MOURYA MEDA
*/
public class BSTIndex {
	
	private Node root;	
	public class Node {
		String key;
		MovieInfo data;
		Node left, right;
		
		public Node(String k, MovieInfo m) {
			this.key = k;
			this.data = m;
		}
	} 
	
	public BSTIndex() {
		root = null;
	}
	
	public void insert(MovieInfo data) {
		root = insert(root,data);
	}	
	
	public Node insert(Node x, MovieInfo movie) {
		if (x==null) {
			return new Node(movie.shortName,movie);
		}		
		int compare = movie.shortName.compareTo(x.key);		
		if (compare<0) {
			x.left = insert(x.left,movie);
		}		
		else if (compare>0) {
			x.right = insert(x.right,movie);
		}		
		else {
			x.data = movie;
		}
		return x;
	}
	
	public MovieInfo findExact(String key) {
		Node x = root;
		while (x!=null) {
			int compare = key.compareToIgnoreCase(x.key);		//key is the shortName which is the full name the user inputs
			if (compare<0) {
				x = x.left;
			}
			else if (compare>0) {
				x = x.right;
			}
			else {
				return x.data;									// returns when matched
			}
		}
		
		return null;
	}
	
	public MovieInfo findPrefix(String sName) {
		sName = sName.substring(0,sName.indexOf('*'));				// gets the string before the '*'
		Node x = root;
		while (x!=null) {
			sName = sName.toLowerCase();							// lower case the input
			x.key = x.key.toLowerCase();							// lower case the key (shortName)
			
			boolean there = x.key.startsWith(sName);				// method found in String class: 
																	//true if the character sequence represented by the argument is a prefix of the character sequence represented by this string 
																	//false otherwise.
			
			if (!there) {											// if the prefix isn't THERE then it goes and compares down the tree
			int compare = sName.compareToIgnoreCase(x.key);
			
				if (compare==0) {
					return x.data;
				}
					else if (compare<0) {
						x = x.left;
					}
						else {
							x = x.right;
						}	
			}		
			else {
				return x.data;										// if its THERE then returns that node's data
			}
		}

		return null;
	}
}