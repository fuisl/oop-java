import re
regex = re.compile(r"[^A-Za-z]")

temp = input().strip().split()
key = list(temp[1])

for i in range(len(key)):
    key[i] = ord(key[i]) - 95

key.append(1)

if (temp[0] == 'E'):
    # ecryption
    plaintext = input().strip().lower()
    plaintext = re.sub(regex, '', plaintext)

    result = ['.' for _ in range(len(plaintext))]
    plainTextIndex = 0
    inverse = False

    for step in key:
        stepCount = 1
        iterator = range(len(plaintext))

        if inverse:
            iterator = range(len(plaintext)-1, -1, -1)
            inverse = False
        else:
            inverse = True

        for index in iterator:
            if (result[index] != '.'):
                continue

            if (stepCount == step):
                result[index] = plaintext[plainTextIndex]
                stepCount = 1
                plainTextIndex += 1
                continue
       
            stepCount += 1
    
    print(''.join(result))

else:
    # decryoion
    ciphertext = input().strip()
    ciphertext = list(ciphertext)
    result = ['.' for _ in range(len(ciphertext))]
    resultTextIndex = 0
    inverse = False

    for step in key:
        stepCount = 1
        iterator = range(len(ciphertext))

        if inverse:
            iterator = range(len(ciphertext)-1, -1, -1)
            inverse = False
        else:
            inverse = True

        for index in iterator:
            if (ciphertext[index] == '.'):
                continue

            if (stepCount == step):
                result[resultTextIndex] = ciphertext[index]
                ciphertext[index] = '.'
                stepCount = 1
                resultTextIndex += 1
                continue
       
            stepCount += 1
    
    print(''.join(result))
