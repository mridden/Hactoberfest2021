"""bfs with differerent components """
vt=7
e=[[1,2],[2,3],[5,6],[3,4], [3,5]]
s=[[] for x in range(vt)]
for i in range(len(e)):
    
    s[e[i][0]].append(e[i][1])
    s[e[i][1]].append(e[i][0])

''' s is adj matrix'''
v=[0 for x in range(vt)]
q=[]
print("bfs")
for i in range(vt):
    if v[i] == 0:
        print(i , end= " ")
        q.append(i)
        v[i] = 1
        while len(q) != 0:

            for j in s[q[0]]:
                if v[j] == 0:
                    print(j, end=" ")
                    v[j] =1
                    q.append(j)
            q.pop(0)