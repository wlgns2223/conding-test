import heapq

n = int(input())

q = []
for _ in range(n):
    x,y = list(map(int,input().split()))
    heapq.heappush(q,[x,y] if x < y else [y,x])


start,end = heapq.heappop(q)
answer = end - start

while q:
    x,y = heapq.heappop(q)

    if y <= end:
        continue

    if x <= end < y:
        answer += (y-end)

    if end < x <= y:
        answer += (y-x)

    start, end = x, y

print(answer)










