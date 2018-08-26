
import sys

print('命令行参数如下:')
for i in sys.argv:
    print(i)

print('\n\nPython 路径为：', sys.path, '\n')


# 想使用 Python 源文件，只需在另一个源文件里执行 import 语句，语法如下
# import module1[, module2[,... moduleN]

# 导入模块
import ch15_module_test1
# 现在可以调用模块里包含的函数了
ch15_module_test1.print_func("Runoob")

print("-----------------")

import ch15_module_fibo
ch15_module_fibo.fib(1000)
print()
print(ch15_module_fibo.fib2(100))
print(ch15_module_fibo.__name__)
print()
fib = ch15_module_fibo.fib
fib(100)



print("----------from … import 语句---------")
# from … import 语句
# Python 的 from 语句让你从模块中导入一个指定的部分到当前命名空间中，语法如下：
# from modname import name1[, name2[, ... nameN]]

# from ch15_module_fibo import fib, fib2
# fib(200)

# from … import * 语句
# from ch15_module_fibo import *
# fib(400)


print("--------__name__属性--------")

if __name__ == '__main__':
    print('程序自身在运行')
else:
    print('我来自另一模块')


# print("----dir() 函数----")
# import sys
# dir(sys)



