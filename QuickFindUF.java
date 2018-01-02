/*------------------------------------------------------------------
 * Compilation:         javac UnionFind.java
 * Dependencies:        UnionFind.java
 * Author:              Kevin Sun
 * Since:               2018 Jan 1
 * Last Update:         2018 Jan 1
 * 
 * Memory usage(deep):  4n + 56 Bytes 
 *                      = int[] id  + int count + overhead + reference + padding
 *                      = (4n + 24) +     4     +    16    +     8     +   4
 *                  
 *                   
 * Time complexity:     QuickUnionFindUF(n): O(n)
 *                      union(p, q):         O(n)
 *                      find(p):             O(1)
 *                      connected(p,q):      O(1)
 *                      count():             O(1)
 *                      validate():          O(1)
 *                      
 * Log:         
 *      2018 Jan 1: Created this class                  
 *------------------------------------------------------------------*/
package union_find;

/**
 * This is the <em>Union-Find</em> data type based on
 * quick find algorithm. <br>I implement this algorithm by myself in order to
 * have a better understanding of the algorithm.
 * <br><br>
 * References: 
 * <ul>
 * <li><a href="http://algs4.cs.princeton.edu"> 
 * Algorithms and Data Structures</a> course of Princeton University. 
 * <li> The QuickFindUF class created by 
 * <em>Robert Sedgewick</em> and <em>Kevin Wayne</em>
 * </ul>
 * @author Kevin Sun
 * @since 2018 Jan 1 
 */
public class QuickFindUF implements UnionFind{
    
    /*
     * The sites are represented by the indices of the array,
     * each slot stores the ID of the connected component that
     * contains the site represented by the index of this slot.
     */
    private int[] id;     
                             
    private int count;      // Number of connected components
    
    
    /**
     * Constructor. Creates a <em>QuickFindUF</em> of <em>n</em> sites.
     * @param n is the number of the sites
     * @throws IllegalArgumentException when n < 1
     */
    public QuickFindUF(int n) {
        
        if(n < 1) throw new IllegalArgumentException("n < 1");
        
        id = new int[n];
        
        for(int i = 0; i < n; i++) {
            id[i] = i;
        }
        
        count = n;       
    }
    
    
    

    /** 
     * @throws IllegalArgumentException if <em>p</em> or <em>q</em> < 0 or >= array size
     */
    @Override
    public void union(int p, int q) {
        // TODO Auto-generated method stub
        validate(p);
        validate(q);
        
        int pid = id[p];
        int qid = id[q];
        
        if(pid != qid) {
            for(int i = 0; i< id.length; i++) {
                if(id[i] == pid) {
                    id[i] = qid;
                }
            }
            count--;
        }
        
    }

    /** 
     * @throws IllegalArgumentException if <em>p</em> < 0 or >= array size
     */
    @Override
    public int find(int p) {    
        validate(p);
        return id[p];
    }

    /** 
     * @throws IllegalArgumentException if <em>p</em> or <em>q</em> < 0 or >= array size
     */
    @Override
    public boolean connected(int p, int q) {
        validate(p);
        validate(q);
        return id[p] == id[q];
    }

    @Override
    public int getComponentCount() {
        return count;
    }
    
    /**
     * Validates the index.
     * @param index is the index that needs to be verified.
     * @throws IllegalArgumentException if <em>index</em> < 0 or >= array size
     */
    private void validate(int index) {
        int size = id.length;
        if(index < 0 || index >= size) throw 
            new IllegalArgumentException("index < 0 or index > "+(size - 1));
    }

}
