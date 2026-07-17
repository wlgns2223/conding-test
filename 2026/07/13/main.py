import heapq

n = 3
edges = [[0,1],[1,2],[0,2]]
succProb = [0.5,0.5,0.2]
start_node = 0
end_node = 2
graph = [[] * n for _ in range(n)]

for i in range(len(edges)):
    source, target = edges[i]
    prob = succProb[i]
    graph[source].append((target, prob))
    graph[target].append((source, prob))

distance = [0] * n
distance[start_node] = 1
q = []
heapq.heappush(q, (-1, start_node))

while q:
    cur_prob, now = heapq.heappop(q)
    cur_prob = -cur_prob

    if distance[now] > cur_prob:
        continue

    for dest, prob in graph[now]:
        next_prob = distance[now] * prob

        if next_prob > distance[dest]:
            distance[dest] = next_prob
            heapq.heappush(q, (-next_prob, dest))
