var1 = 1
var2 = 10
#使用del语句删除一些数字对象的引用。
del var1, var2


number = 0xA0F # 十六进制
print(number)
number=0o37 # 八进制
print(number)

#数字类型转换
a = 1.0
print(int(a))

#数字运算
#ps 在混合计算时，Python会把整型转换成为浮点数
print ( 5+4 )       # 加法
print ( 4.3-2 )     # 减法
print ( 3*7 )       # 乘法
print ( 2/4 )       # 除法，得到一个浮点数
print ( 2//4 )      # 除法，得到一个整数
print ( 17%3 )      # 取余
print ( 2**5 )      # 乘方

# //得到的并不一定是整数类型的数，它与分母分子的数据类型有关系。
print(7//2)
print(7.0//2)
print( 7//2.0)


width = 20
height = 5*9
print( width * height)

#不同类型的数混合运算时会将整数转换为浮点数：

print(3 * 3.75 / 1.5)
print(7.0 / 2)

#在交互模式中，最后被输出的表达式结果被赋值给变量 _
tax = 12.5 / 100
price = 100.50
print(price * tax)
print(price + _)
print(round(_, 2))


