# 字符串，列表或元组对象都可用于创建迭代器：
list=[1,2,3,4]
it = iter(list)    # 创建迭代器对象
print (next(it))   # 输出迭代器的下一个元素
print (next(it))

print ("---------")
# 迭代器对象可以使用常规for语句进行遍历
list=[1,2,3,4]
it = iter(list)    # 创建迭代器对象
for x in it:
    print (x, end=" ")


print()
print ("---------")
# 也可以使用 next() 函数：
# import sys         # 引入 sys 模块
#
# list=[1,2,3,4]
# it = iter(list)    # 创建迭代器对象
#
# while True:
#     try:
#         print (next(it))
#     except StopIteration:
#         sys.exit()

# StopIteration 异常用于标识迭代的完成，防止出现无限循环的情况，在 __next__() 方法中我们可以设置在完成指定循环次数后触发 StopIteration 异常来结束迭代。
print ("---------")



# 生成器 在 Python 中，使用了 yield 的函数被称为生成器（generator）
# 跟普通函数不同的是，生成器是一个返回迭代器的函数，只能用于迭代操作，更简单点理解生成器就是一个迭代器。
# 在调用生成器运行的过程中，每次遇到 yield 时函数会暂停并保存当前所有的运行信息，返回 yield 的值, 并在下一次执行 next() 方法时从当前位置继续运行。

import sys

def fibonacci(n): # 生成器函数 - 斐波那契
    a, b, counter = 0, 1, 0
    while True:
        if (counter > n):
            return
        yield a
        a, b = b, a + b
        counter += 1
f = fibonacci(10) # f 是一个迭代器，由生成器返回生成

while True:
    try:
        print (next(f), end=" ")
    except StopIteration:
        sys.exit()







