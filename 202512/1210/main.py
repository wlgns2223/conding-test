# https://www.acmicpc.net/problem/11501

tc = int(input())
while tc:
    n = int(input())
    stocks = list(map(int, input().split(" ")))
    maxStock = 0
    profit = 0

    for i in range(len(stocks) - 1, -1, -1):
        if maxStock < stocks[i]:
            maxStock = stocks[i]
        else:
            profit = profit + (maxStock - stocks[i])

    print(profit)

    tc -= 1


