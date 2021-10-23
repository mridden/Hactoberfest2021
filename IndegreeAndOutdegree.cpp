# include <iostream>
using namespace std;
int main()
{ int n;
int a[10][10];
     cout<<"Enter the order of the Adjancy matrix of graph";
      cin>>n;
     cout<<"Enter the Adjancy Matrix"<<endl;
      for(int i=0; i<n; i++)
      {
          for(int j=0; j<n; j++)
          {
              cin>>a[i][j];
          }
      }
      int ch='a';
      int indegree[n]={0};
      int outdegree[n]={0};
      for(int i=0; i<n; i++)
      {
         for(int j=0; j<n; j++)
         {


                 outdegree[i]+=a[i][j];
                 indegree[i]+=a[j][i];

         }
      }
      cout<<"Vertex "<<" Indegree "<<" Outdegree"<<endl;
      for(int i=0; i<n; i++)
      {
          cout<<"("<<(char)(ch+i)<<")        "<<indegree[i]<<"         "<<outdegree[i]<<endl;
      }
      cout<<endl;
    return 0;
}
