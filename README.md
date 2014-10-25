BSTIndex
One of my class's last project using Binary Search Tree that I did.
========
Binary Search Tree to parse through IMDB's actors and movies.

The goal is to quickly find the information associated with an actor (or a movie), based on the movie or
actor name (e.g. Arnold Schwartzeneger), or prefix of a name (e.g. Arnold Schw*). The search should be
case insensitive (e.g. arnold schw* should also work). In other words, the search key is the short or
simplified name of a movie or actor. The associated value or data is of type MovieInfo, which is defined in
the following class:

class MovieInfo{
 public String shortName; //short or simplified name, e.g., “Tom Hanks”.
 public String fullName; //full name, e.g., “Hanks, Thomas III”.
 public int ID; //integer ID.
}

The BST index is implemented as a stand-alone class BSTIndex with the following public classes:

The Node class within the BSTIndex classcontains 4 fields: 
key (of String type), 
data (of MovieInfo type), 
left and right link to the children nodes. 

· public BSTIndex () : constructor to initialize the BST. The data element is an object of the type
MovieInfo, described above.

· public MovieInfo findExact (String key) : returns the data element MovieInfo where the shortName
matches the key exactly (can have different capitalization).

· public MovieInfo findPrefix (String prefix) : returns the data element MovieInfo where the shortName
starts with the prefix (can have different capitalization).

· public void insert (MovieInfo data) : inserts the given data element into the proper place in the BST
structure

The IndexTester class tests the BSTIndex class. The indexTester creates an empty
BSTIndex object (using the constructor of the BSTIndex class), reads the data from an input movie or
actor file, builds a MovieInfo object for each row, and insert it into the BST index (using the insert method
of insert BSTIndex class). At this point, the BST index is built for all the movie or actor entries in the file.
It will then ask for a search string from user and search for the MovieInfo object associated with the name,
testing the search functionality of your BSTIndex (using the findExact or findPrefix methods of the
BSTIndex).
