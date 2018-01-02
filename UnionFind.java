/*------------------------------------------------------------------
 * Compilation:      javac UnionFind.java
 * Author:           Kevin Sun
 * Since:            2018 Jan 1
 * Last Update:      2018 Jan 1
 * 
 * Log:         
 *      2018 Jan 1: Created this interface.                  
 *------------------------------------------------------------------*/
package union_find;

/**
 * This is an abstract <em>Union-Find</em> data type of a set of integers. 
 * For definition and more, see <a href="https://en.wikipedia.org/wiki/Disjoint-set_data_structure"> 
 * Disjoint-set data structure</a> on wikipedia. The 
 * @author Kevin Sun
 * @since 2018 Jan 1
 */
public interface UnionFind {
    
    /**
     * Unions the component that contains <em>p</em> and the component that contains <em>q</em>. 
     * @param p is an element 
     * @param q is another element
     */
    public void union(int p, int q);
    
    /**
     * Finds which component contains <em>p</em>
     * @param p is an element
     * @return the integer that represents the component that contains <em>p</em>
     */
    public int find(int p);
    
    /**
     * Verifies if two elements <em>p</em> and <em>q</em> are connected
     * @param p is an element 
     * @param q is another element
     * @return if <em>p</em> and <em>q</em> are connected
     */
    public boolean connected(int p, int q);
   
    /**
     * @return the number of connected components
     */
    public int getComponentCount();
    
    

}
