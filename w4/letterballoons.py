temp = input().strip().split()
maxChar = int(temp[0])
teamCount = int(temp[1])

teamList = []

for _ in range(teamCount):
    temp = input().strip()
    numRepresentation = 0
    flag = False

    for char in temp:
        charNum = ord(char) - 64

        if charNum > maxChar:
            flag = True
            break

        charRepresentation = 1 << (charNum-1)

        if (numRepresentation & charRepresentation) != 0:
            flag = True
            break

        numRepresentation += 1 << (charNum-1)
    
    if flag: continue

    teamList.append(numRepresentation)

def recursiveSearch(teamList, filter, indexLeft):
    

for teamIndex in range(len(teamList)):
    count = 1
    filter = teamList[teamIndex]

    for oTeamIndex in range(len(teamList)):
        if oTeamIndex == teamIndex: continue

        if (teamList[teamIndex] & teamList[oTeamIndex]) == 0:
            count += 1
            filter = filter | teamList[oTeamIndex]
    
    maxCount = max(maxCount, count)

print(maxCount)