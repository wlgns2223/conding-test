import heapq

times = [[1,2,1]]
n = 2 # nodes
k = 2 # start

graph = [[] for _ in range(n+1)]
for t in times:
    source, target, time = t
    graph[source].append((target,time))
INF = int(1e9)
distance = [INF] * (n + 1)

q = []
heapq.heappush(q,(0,k))
distance[k] = 0

while q:
    dist, now = heapq.heappop(q)

    if distance[now] < dist:
        continue

    for target,time in graph[now]:

        cost = distance[now] + time

        if cost < distance[target]:
            distance[target] = cost
            heapq.heappush(q,(cost, target))

answer =  -1 if max(distance[1:]) == INF else  max(distance[1:])
print(answer)

