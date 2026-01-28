# https://www.acmicpc.net/problem/4889

i = 1
while True:
    s = input()
    if s.count("-") != 0:
        break

    stack = []
    answer = 0

    for c in s:

        if c == "{":
            stack.append(c)
        else: # }
            if len(stack) == 0:
                answer += 1
                stack.append("{")
            else:
                stack.pop()

    if len(stack) != 0:
        answer += (len(stack) // 2)

    print(f'{i}. {answer}')
    i += 1
