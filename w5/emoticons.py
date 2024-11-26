msg_str = input()
msg_set = set(msg_str)
emoticons = [":)", ":-)", ":-(", ";-)", "xD", "^_^", "-_-", "^o^", "^^;", "(..)"]
emo_set = set("".join(emoticons))
all_char_set = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ abcdefghijklmnopqrstuvwxyz!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~"

def check_emoticons(msg):
    emoticons = [":)", ":-)", ":-(", ";-)", "xD", "^_^", "-_-", "^o^", "^^;", "(..)"]
    count = 0
    i = 0

    while i < len(msg):
        for emo in emoticons:
            emo_len = len(emo)
            if msg[i:i+emo_len] == emo:
                i += emo_len - 1
                break
        
        count += 1
        i += 1
    
    return count

max_count = 0
min_count = 101

for emo in emo_set:
    for char in msg_set:
        temp = msg_str.replace(char, emo)
        min_count = min(min_count, check_emoticons(temp))
        max_count = max(max_count, check_emoticons(temp))

print(min_count, max_count)