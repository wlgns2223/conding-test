lines = [input() for _ in range(3)]

for nums in lines:
    count = 1
    answer = 1
    prev = nums[0]
    for n in nums[1:]:

        if prev == n:
            count += 1
        else:
            count = 1
            prev = n

        answer = max(count,answer)

    print(answer)



