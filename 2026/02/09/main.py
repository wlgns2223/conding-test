# https://www.acmicpc.net/problem/11265
n,m = map(int,input().split())
graph = []
for _ in range(n):
    r = list(map(int,input().split()))
    graph.append(r)

for k in range(n):
    for a in range(n):
        for b in range(n):
            if graph[a][k] + graph[k][b] < graph[a][b]:
                graph[a][b] = graph[a][k] + graph[k][b]

for _ in range(m):
    i,j,c = map(int,input().split())
    i -= 1
    j -= 1

    print("Enjoy other party") if graph[i][j] <= c else print("Stay here")

