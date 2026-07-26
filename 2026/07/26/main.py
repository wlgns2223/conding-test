import heapq

n = 5
edges = [[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]]
distanceThreshold = 2

graph = [[] * n for _ in range(n)]
for i in range(len(edges)):
    a,b,w = edges[i]
    graph[a].append((b,w))
    graph[b].append((a,w))

INF = 1e9
cities = []
for i in range(n):

    distance = [INF] * n
    q = []
    distance[i] = 0
    heapq.heappush(q,(0,i))

    while q:

        cost, now = heapq.heappop(q)

        if distance[now] < cost:
            continue

        for to, w in graph[now]:
            next_cost = cost + w

            if next_cost <  distance[to]:
                distance[to] = next_cost
                heapq.heappush(q, (next_cost, to))

    count = 0
    for idx,v in enumerate(distance):
        if idx != i and v <= distanceThreshold:
            count += 1
    cities.append(count)

num = INF
answer = 0
for idx,v in enumerate(cities):
    if v <= num:
        answer = idx
        num = v

print(answer)
