# https://www.acmicpc.net/problem/15903

import heapq

n,m = list(map(int,input().split()))
nums = list(map(int,input().split()))

q = []
for k in nums:
    heapq.heappush(q,k)

for _ in range(m):
    first = heapq.heappop(q)
    second = heapq.heappop(q)
    heapq.heappush(q,first  + second)
    heapq.heappush(q, first + second)

print(sum(q))
