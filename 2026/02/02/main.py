# https://www.acmicpc.net/problem/11403

n = int(input())
graph = []
for _ in range(n):
    r = list(map(int,input().split()))
    graph.append(r)

for k in range(n):
    for a in range(n):
        for b in range(n):
            if graph[a][k] and graph[k][b]:
                graph[a][b] = 1


for r in graph:
    for c in r:
        print(c,end=" ")
    print()