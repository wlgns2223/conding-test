# https://www.acmicpc.net/problem/2224
from collections import defaultdict

n = int(input())
graph = defaultdict(list)
visited = {}

# 플로이드 워셜 알고리즘으로 구할 수 있을 것 같다
# 2
# A => b
# b => C
# graph[A][b] = 1
# graph[b][C] = 1
# -> graph[A][C] = 1
# if C => x == 1
# then graph[A][x] == 1
# 모든 지점에서 모든 지점까지 최단거리 경로를 구한다.
# 거리를 단지 1로 정의할뿐