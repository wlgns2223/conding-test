import heapq

roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
n = 7

INF = int(1e9)

modulo = 10**9 + 7

distance = [INF] * n
graph = [[] * n for _ in range(n)]

for i in range(len(roads)):
    source,target,time = roads[i]
    graph[source].append((target,time))
    graph[target].append((source,time))

start = 0
end = n-1
distance[start] = 0
q = []
heapq.heappush(q,(0,start))
paths = [set()  for _ in range(n)]
paths[0].add(-1)

while q:

    dist, now = heapq.heappop(q)

    if distance[now] < dist:
        continue

    for target,time in graph[now]:
        cost = distance[now] + time

        if cost <= distance[target]:
            distance[target] = cost
            paths[target].add(now)
            heapq.heappush(q,(cost,target))

path = []
result = []
def dfs(node):

    path.append(node)

    if node == start:
        result.append(path[::-1])

    else:
        for parent in paths[node]:
            if parent != -1:
                dfs(parent)

    path.pop()

    return result

all_paths = dfs(end)

for p in all_paths:
    print(p)








