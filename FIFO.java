import java.util.*;
class FIFO
{
   public static void main(String args[])
   {
       int pages[]={3, 0, 3, 2, 4, 0, 3, 0, 2, 1, 0, 7};
       int frames=3;
       FIFOPageReplacement(pages,frames);
   }
   public static void FIFOPageReplacement(int pages[],int frames)
   {
       Queue<Integer> queue=new LinkedList<Integer>();       // queue used to store pages
       HashSet<Integer> hs=new HashSet<Integer>();           // hs used to know what pages are present in queue
       int page_faults=0;
       int page_replacements=0;
       for(int i=0;i<pages.length;i++)
       {
           if(!hs.contains(pages[i]))                       // if page is not present in hash, then its a page fault
           {
               page_faults++;                               // so increment it
               if(frames>0)                               // if there are empth slots, then add into it
               {
                   frames--;
               }
               else
               {
                   int removed_element=queue.poll();       // else remove an element in fifo order and add new element
                   hs.remove(removed_element);
               }
               hs.add(pages[i]);
               queue.add(pages[i]);
           }
           else                                           // if page is present in hash, then its a page replacement
           {
               page_replacements++;                       // so increment it
           }
       }
       // print the result
       System.out.println("Number of Page Faults= "+page_faults);
       System.out.println("Page Replacements= "+page_replacements);
   }
}