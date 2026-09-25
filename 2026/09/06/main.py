import heapq

dy = [-1,1,0,0]
dx = [0,0,-1,1]

heights = [[1,2,2],[3,8,2],[5,3,5]]
n = len(heights)
m = len(heights[0])
dist = [[float('inf')] * m for _ in range(n)]
dist[0][0] = 0

q = []
heapq.heappush(q,(0,0,0))

while q:

    d,y,x = heapq.heappop(q)

    if d > dist[y][x]:
        continue

    if y == n-1 and x == m-1:
        break

    for i in range(4):
        ny, nx = y + dy[i], x + dx[i]

        if 0<= ny < n and 0<= nx < m:
            nd = max(d, abs(heights[y][x] - heights[ny][nx]))

            if nd < dist[ny][nx]:
                dist[ny][nx] = nd
                heapq.heappush(q,(nd,ny,nx))
