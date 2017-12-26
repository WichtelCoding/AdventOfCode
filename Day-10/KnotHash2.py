def reverse(pos, length):
    for i in range(length//2):
        list[(pos + i) % len(list)], list[(pos + length - i - 1) % len(list)] = list[(pos + length - i - 1) % len(list)], list[(pos + i) % len(list)]

def round():
    for i in range(len(instr)):
        global ptr
        global skip
        reverse(ptr, instr[i])
        ptr += skip + instr[i]
        skip += 1


instr = bytearray('227,169,3,166,246,201,0,47,1,255,2,254,96,3,97,144', 'utf8') + bytearray([17, 31, 73, 47, 23])
ptr = 0
skip = 0
list = [0]*256
for i in range(256):
    list[i] = i

for _ in range(64):
    round()
tmp = bytearray()
for i in range(16):
    xor = 0;
    for j in range(16):
        xor ^= list[i*16 + j]
    tmp.append(xor)
print(tmp.hex())
