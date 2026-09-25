from collections import deque

grid = [[1]]

dx = [0,-1,-1,-1,0,1,1,1]
dy = [-1,-1,0,1,1,1,0,-1]

n,m = len(grid) , len(grid[0])
dist = [[float("inf")] * m for _ in range(n)]
q = deque()

if grid[0][0] == 0:
    q.append((0,0))
    dist[0][0] = 1

while q:

    y,x = q.popleft()

    for d in range(8):
        ny,nx = y + dy[d], x+dx[d]
        cost = dist[y][x] + 1

        if 0<= ny < n and 0 <= nx < m:
            if grid[ny][nx] == 0 and cost < dist[ny][nx] :
                dist[ny][nx] = dist[y][x] + 1
                q.append((ny,nx))

for g in grid:
    print(g,end="\n")

print("\n")
for d in dist:
    print(d,end="\n")
print(dist[n-1][m-1])

