class Solution {
    List<List<Integer>> res=new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited=new boolean[nums.length];
        ans(nums,new ArrayList<Integer>(),visited);
        return res;
    }
    public void ans(int []arr,List<Integer> l,boolean[] visited)
    {
        if(arr.length==l.size())
        {
            res.add(new ArrayList(l));
            return;
        }
        
        for(int i=0;i<arr.length;i++)
        {
            if(visited[i]==true)
                continue;
            l.add(arr[i]);
            visited[i]=true;
            ans(arr,l,visited);
            l.remove(l.size()-1);
            visited[i]=false;
        }
    }
}
