# https://www.acmicpc.net/problem/11000

import  heapq

n = int(input())
times = []
for _ in range(n):
    times.append(list(map(int,input().split(" "))))
q = []
times = sorted(times)
heapq.heappush(q,(times[0][1],times[0][0]))
for i in range(1,n):
    pre_room_time = heapq.heappop(q)
    if times[i][0] < pre_room_time[0]:
        heapq.heappush(q,pre_room_time)

    heapq.heappush(q, (times[i][1], times[i][0]))

print(len(q))
