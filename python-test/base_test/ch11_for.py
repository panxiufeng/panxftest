n = 100

sum = 0
counter = 1
while counter <= n:
    sum = sum + counter
    counter += 1

print("1 到 %d 之和为: %d" % (n,sum))

print ("-----------------------")
# 无限循环  可以使用 CTRL+C 来退出当前的无限循环

# var = 1
# while var == 1 :  # 表达式永远为 true
#     num = int(input("输入一个数字  :"))
#     print ("你输入的数字是: ", num)
#
# print ("Good bye!")

# while 循环使用 else 语句
# 在 while … else 在条件语句为 false 时执行 else 的语句块

count = 0
while count < 5:
    print (count, " 小于 5")
    count = count + 1
else:
    print (count, " 大于或等于 5")


print ("-----------------------")
# 类似if语句的语法，如果你的while循环体中只有一条语句，你可以将该语句与while写在同一行中

# flag = 1
# while (flag): print ('欢迎访问菜鸟教程!')
# print ("Good bye!")

languages = ["C", "C++", "Perl", "Python"]

for x in languages:
    print (x)


print ("-----------------------")
sites = ["Baidu", "Google","Runoob","Taobao"]
for site in sites:
    if site == "Runoob":
        print("菜鸟教程!")
        break
    print("循环数据 " + site)
else:
    print("没有循环数据!")
print("完成循环!")


print ("-----------------------")
# 如果你需要遍历数字序列，可以使用内置range()函数。它会生成数列
for i in range(5):
    print(i)

print ("-----------------------")

for i in range(5,9) :
    print(i)

print ("-----------------------")
# 也可以使range以指定数字开始并指定不同的增量(甚至可以是负数，有时这也叫做'步长'):

for i in range(0, 10, 3) :
    print(i)

for i in range(-10, -100, -30) :
    print(i)

print ("-----------------------")
# 可以结合range()和len()函数以遍历一个序列的索引

a = ['Google', 'Baidu', 'Runoob', 'Taobao', 'QQ']
for i in range(len(a)):
    print(i, a[i])

print ("-----------------------")
# 可以使用range()函数来创建一个列表
print(list(range(5)))

# break和continue语句及循环中的else子句

for letter in 'Runoob':     # 第一个实例
    if letter == 'b':
        break
    print ('当前字母为 :', letter)

var = 10                    # 第二个实例
while var > 0:
    print ('当期变量值为 :', var)
    var = var -1
    if var == 5:
        break

print ("Good bye!")


print ("-----------------------")

for letter in 'Runoob':     # 第一个实例
    if letter == 'o':        # 字母为 o 时跳过输出
        continue
    print ('当前字母 :', letter)

var = 10                    # 第二个实例
while var > 0:
    var = var -1
    if var == 5:             # 变量为 5 时跳过输出
        continue
    print ('当前变量值 :', var)
print ("Good bye!")


print ("-----------------------")

for n in range(2, 10):
    for x in range(2, n):
        if n % x == 0:
            print(n, '等于', x, '*', n//x)
            break
    else:
        # 循环中没有找到元素
        print(n, ' 是质数')



# pass 语句
# Python pass是空语句，是为了保持程序结构的完整性。
# pass 不做任何事情，一般用做占位语句，如下实例

# while True:
#     pass  # 等待键盘中断 (Ctrl+C)


for letter in 'Runoob':
    if letter == 'o':
        pass
        print ('执行 pass 块')
    print ('当前字母 :', letter)

print ("Good bye!")

