# https://www.acmicpc.net/problem/1700

n,k = map(int,input().split())
tools = list(map(int,input().split()))

plugged = set()
count = 0
INF = float('inf')

for i in range(k):
    if len(plugged) < n:
        plugged.add(tools[i])
        continue

    if tools[i] in plugged:
        continue

    future = -1
    idx = -1
    for p in plugged:
        if p not in tools[i+1:]:
            future = p
            break

        idx = max(idx, tools[i+1:].index(p))
        future = tools[i+1:][idx]

    plugged.remove(future)
    plugged.add(tools[i])

    count += 1

print(count)






