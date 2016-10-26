def main():
    parse()

def isPangram(strings):
    res = ""
    for str in strings:
        charset = set()
        for c in str:
            if c in charset:
                continue
            else:
                charset.add(c)
        if len(charset) == 26:
            res = res+"1"
        else:
            res = res+"0"
    return res

def parse():
    nums = [4,3]
    texts=["<tag1 value = \"Hello\">","</tag1>", "<tag2 name = \"name1\">", "</tag2>"]
    exes = ["tag1.tag2~name", "tag1~name", "tag1~value"]
    strings=[]
    d = {}
    tag = ''
    prev = ['']
    for text in texts:
        ele = text.strip()[1:-1].split()
        strings.append(ele)
    for string in strings:
        if string[0][0] == '/':
            tag = prev.pop()
        else:
            prev.append(tag)
            tag += '.' + string[0]
            for j in range(1, len(string), 3):
                d[tag + '~' + string[j]] = string[j + 2].strip()[1:-1]
    for i in range(nums[1]):
        try:
            print d['.' + exes[i]]
        except:
            print "Not Found!"

if __name__ == "__main__":
    main()