# https://www.acmicpc.net/problem/2457

n = int(input())

dates = []
for _ in range(n):
    start1,start2,end1,end2 = list(map(int,input().split(" ")))
    dates.append([start1 * 100 + start2, end1*100 + end2])

dates.sort()

current = 301
end = 1130
count = 0
idx = 0

while current <= end:

    max_end =0
    while idx < n and dates[idx][0] <= current:
        max_end = max(max_end,dates[idx][1])
        idx += 1

    if max_end == 0:
        count = 0
        break

    current = max_end
    count += 1

print(count)
