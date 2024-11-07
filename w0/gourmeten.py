T = int(input())
N = int(input())
track = [0 for i in range(T + 1)]  # 0 -> T
track[0] = 1

foods = []
for i in range(N):
    foods.append(int(input()))

foods.sort()

for i in range(1, T + 1):
    for f in foods:
        if i - f < 0:
            break
        track[i] += track[i - f]

print(track[-1])
