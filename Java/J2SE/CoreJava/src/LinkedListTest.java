import java.util.*;

public class LinkedListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
          List<String> a = new LinkedList<String>();
          a.add("Amy");
          a.add("Carl");
          a.add("Erica");
          
          System.out.println("original a");
          System.out.println(a);
          
          List<String> b = new LinkedList<String>();
          b.add("Bob");
          b.add("Doug");
          b.add("Frances");
          b.add("Gloria");

          System.out.println("original b");
          System.out.println(b);
          
          // Merge the words from b to a 
          ListIterator<String> aIter = a.listIterator();
          Iterator<String> bIter = b.iterator();
          
          while(bIter.hasNext())
          {
        	  if (aIter.hasNext()) aIter.next();
        	  aIter.add(bIter.next());
          }
          
          System.out.println("merged a");
          System.out.println(a);
          
          // remove every second word from b
          bIter = b.iterator();
          while(bIter.hasNext())
          {
        	  bIter.next();
        	  if (bIter.hasNext())
        	  {
        		  bIter.next();
        		  bIter.remove();
        	  }
          }
          
          System.out.println("every other removed from b");
          System.out.println(b);
          
          // bulk operator, remove all words in b from a
          a.removeAll(b);
          
          System.out.println("items of b removed from a");
          System.out.println(a);
	}

}
