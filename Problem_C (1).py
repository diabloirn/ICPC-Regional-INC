import sys

n = int(input())
nums = list(map(int,input().split()))

if len(set(nums)) == 1:
    print(0)
    sys.exit()

ans = 0
curr = None
i = 0
first = True

while i < n-1:
    if nums[i] < nums[i+1]:
        trend = 1
    elif nums[i] > nums[i+1]:
        trend = -1
    else:
        trend = 0
        
    if curr == None and not first:
        curr = trend
        i += 1
    elif curr != trend and trend != 0:
        ans += 1
        curr = trend
        i += 1
    elif trend == 0:
        if i + 2 < n:
            nextTrend = None
            if nums[i] < nums[i+2]:
                    nextTrend = 1
            elif nums[i] > nums[i+2]:
                nextTrend = -1
            else: 
                nextTrend = 0

            if curr == 1 and nextTrend == -1:
                curr = -1
                ans += 1
                i = i + 2
            elif (curr == 1 and nextTrend == 1) or (curr == 1 and nextTrend == 0):
                curr = 1
                ans += 2
                i = i + 2
            elif curr == -1 and nextTrend == 1:
                curr = 1
                ans += 1
                i = i + 2
            elif (curr == -1 and nextTrend == -1) or (curr == -1 and nextTrend == 0):
                curr = -1
                ans += 2
                i = i + 2
            else:
                if first:
                    ans += 1
                    first = False
                if nextTrend == 1 or nextTrend == -1:
                    curr = nextTrend
                    ans += 1
                    i = i + 2
                else:
                    ans += 2
                    i = i + 2
        else:
            ans += 1
            break
    else:
        i += 1

print(ans)

