class Solution {
    List<String> res=new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        char []ch=new char[s.length()];
        
        
        back(s,0,ch);
        return res;
        
    }
    
    public void back(String str,int index,char[] arr)
    {
        if(str.length()==index)
        {
            StringBuilder sb=new StringBuilder();
            for(char e:arr)
                sb.append(e);
            res.add(sb.toString());
            return;
        }
        
        char c=str.charAt(index);
        if(Character.isDigit(c))
        {
            arr[index]=c;
            back(str,index+1,arr);
        }
        else
        {
            arr[index]=Character.toUpperCase(c);
            back(str,index+1,arr);
            arr[index]=Character.toLowerCase(c);
            back(str,index+1,arr);
        }
            
        
    }

}
