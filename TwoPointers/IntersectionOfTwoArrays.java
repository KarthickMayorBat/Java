import java.util.ArrayList;
import java.util.HashSet;

public class IntersectionOfTwoArrays {
    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        // code here
        HashSet<Integer> result = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<a.length; i++){
            set.add(a[i]);
        }
        for(int i=0; i<b.length; i++){
            if(set.contains(b[i])){
                result.add(b[i]);
            }
        }
        return new ArrayList<>(result);
    }
}
