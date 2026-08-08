class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.size()!=t.size())
        return false;

        vector<int>store(26,0);

        for(char c:s)
        store[c-'a']++;

        for(char c:t)
        store[c-'a']--;

        for(int num:store)
        if(num!=0)
        return false;

        return true;
    }
};
