import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class PrintAnagramsTogether {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        HashMap<String, List<String>> setMap = new HashMap<>();
        for(String str : arr){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
        
            if(!setMap.containsKey(sortedString)){
                List<String> list = new ArrayList<>(); // Create a new list
                list.add(str);  
                setMap.put(sortedString, list);
            }else{
                setMap.get(sortedString).add(str);
            }
        }
        for (List<String> value : setMap.values()) {
            result.add(new ArrayList<>(value));
        }
        return result;
    }
}