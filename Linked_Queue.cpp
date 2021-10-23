# include <iostream>
using namespace std;
template <class T>
class node
{   public:
    T info;
    node<T>* next;
    node(T x, node* n=NULL)
    {
        info=x;
        next=n;
    }

};
template <class T>
class queuetype
{
  node<T>* f,*r;
  public :
  queuetype()
  {
      f=r=NULL;
  }
  int isempty();
  void enqueue(T x);
  T dequeue();
  int count();
  void display();


};
template <class T>
int queuetype <T>::isempty()
{
    if(f==NULL)
    {
        return 1;
    }
    else
    return -1;
}
template <class T>
void queuetype<T> :: enqueue(T x)
{
    node<T>* temp;
    temp=new node<T>(x);
    if(f==NULL)
     f=r=temp;
    else
    {
      r->next=temp;
      r=temp;
    }
}
template <class T>
T queuetype<T> :: dequeue()
{
    int x;
    x=f->info;
    if(f==r)
    {
        delete f;
        f=r=NULL;
    }
    else
    {
      node<T>* temp;
      temp=f;
      f=f->next;
      delete(temp);
    }
    return x;
}
template <class T>
int queuetype<T> :: count()
{
    int ct=0;
     node<T>* temp;
    for(temp=f; temp!=NULL; temp=temp->next)
        {
           ct++;
        }
        return ct;
}
template <class T>
void queuetype<T> :: display()
{
    if(f==NULL)
    cout<<"Queue is Empty! Nothing to display"<<endl;
    else
    {  node<T>* temp;
        cout<<"Elements of Queue from front end to rare end are : "<<endl;
        for(temp=f; temp!=NULL; temp=temp->next)
        {
           cout<<temp->info<<"  ";
        }
        cout<<endl;
    }
}

int main()
{
    int choice, i , in, del ,ct;
    char c='y';
    queuetype<int> q;
    while(c=='y' || c=='Y')
    {
        cout<<"Main menu :- "<<endl;
        cout<<" 1. Add an element in a Queue "<<endl;
        cout<<" 2. Remove an element fom Queue"<<endl;
        cout<<" 3. Check for emptyness "<<endl;
        cout<<" 4. Display Queue "<<endl;
        cout<<" 5. Count the no of elements in an Queue"<<endl;
        cout<<"Enter your choice(1-5) ";
        cin>>choice;
        switch(choice)
        {
            case 1 : cout<<"Enter the element you want to add ";
                     cin>>in;
                     q.enqueue(in);
                     q.display();
                     break;
            case 2 : i=q.isempty();
                     if(i==1){
                      cout<<"Queue is empty! Nothing to display."<<endl;
                     }
                     else{
                     del=q.dequeue();
                     cout<<del<<" has been deleted from the Queue."<<endl;
                     q.display();
                     }
                     break;
            case 3 : i=q.isempty();
                     if(i==1){
                         cout<<"Queue is empty"<<endl;
                      }
                      else
                      {
                          cout<<"Queue is Nonempty"<<endl;
                      }
                      break;
            case 4 : q.display();
            case 5 : ct=q.count();
                     cout<<"No of elements in Queue are "<<ct<<endl;
                     break;
            default : cout<<"You entered a wrong choice "<<endl;


        }
        cout<<"Do you want to continue? ";
        cin>>c;

    }

}
