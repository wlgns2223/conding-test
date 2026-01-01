# https://www.acmicpc.net/problem/2170

n = int(input())

points = []
for _ in range(n):
    s,e = map(int,input().split())
    points.append((s,e))

points = sorted(points)

start,end = points[0]
answer = (end - start)
for i in range(1,len(points)):
    x,y = points[i]

    if y <= end:
        continue


    if x <= end < y:
        answer += ( y - end)

    if end < x < y:
        answer += (y -x)

    start,end = x,y

print(answer)