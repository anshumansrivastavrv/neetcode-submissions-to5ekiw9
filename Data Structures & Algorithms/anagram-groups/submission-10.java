class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> res = new HashMap<>();

        for(String str:strs){
            char[] freq=new char[26];
            for(char ch:str.toCharArray()){
                freq[ch-'a']++;
            }
            String key=Arrays.toString(freq);

            res.putIfAbsent(key,new ArrayList<>());
            res.get(key).add(str);
        }

        return new ArrayList<>(res.values());
    }
}
