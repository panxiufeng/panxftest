counter = 100          # 整型变量
miles   = 1000.0       # 浮点型变量
name    = "runoob"     # 字符串

print (counter)
print (miles)
print (name)
print('------------------------------')

#多个变量赋值
a = b = c = 1
print (str(a)+'---'+str(b)+'---'+str(c))
a, b, c = 1, 2, "runoob"
print (str(a)+'---'+str(b)+'---'+c)

#Number（数字） Python3 支持 int、float、bool、complex（复数）。

a, b, c, d = 20, 5.5, True, 4+3j
print(type(a), type(b), type(c), type(d))

a = 111
print ( isinstance(a, int))
print('------------------------------')

'''
区别就是:
type()不会认为子类是一种父类类型。
isinstance()会认为子类是一种父类类型。
'''
class A:
    pass
class B(A):
    pass
isinstance(A(), A)    # returns True
type(A()) == A        # returns True
isinstance(B(), A)    # returns True
type(B()) == A        # returns False


#使用del语句删除一些对象引用  del var1[,var2[,var3[....,varN]]]]
var1 = 1
var2 = 10
del var1,var2

#数值运算
#ps 在混合计算时，Python会把整型转换成为浮点数
print ( 5+4 )       # 加法
print ( 4.3-2 )     # 减法
print ( 3*7 )       # 乘法
print ( 2/4 )       # 除法，得到一个浮点数
print ( 2//4 )      # 除法，得到一个整数
print ( 17%3 )      # 取余
print ( 2**5 )      # 乘方
print('------------------------------')


#String（字符串）
str = 'Runoob'
print (str)          # 输出字符串
print (str[0:-1])    # 输出第一个到倒数第二个的所有字符
print (str[0])       # 输出字符串第一个字符
print (str[2:5])     # 输出从第三个开始到第五个的字符
print (str[2:])      # 输出从第三个开始的后的所有字符
print (str * 2)      # 输出字符串两次
print (str + "TEST") # 连接字符串
print('------------------------------')

#List（列表）
list = [ 'abcd', 786 , 2.23, 'runoob', 70.2 ]
tinylist = [123, 'runoob']

print (list)            # 输出完整列表
print (list[0])         # 输出列表第一个元素
print (list[1:3])       # 从第二个开始输出到第三个元素
print (list[2:])        # 输出从第三个元素开始的所有元素
print (tinylist * 2)    # 输出两次列表
print (list + tinylist) # 连接列表
print('------------------------------')


#Tuple（元组） ：元组（tuple）与列表类似，不同之处在于元组的元素不能修改。元组写在小括号 () 里，元素之间用逗号隔开。

tuple = ( 'abcd', 786 , 2.23, 'runoob', 70.2  )
tinytuple = (123, 'runoob')

print (tuple)             # 输出完整元组
print (tuple[0])          # 输出元组的第一个元素
print (tuple[1:3])        # 输出从第二个元素开始到第三个元素
print (tuple[2:])         # 输出从第三个元素开始的所有元素
print (tinytuple * 2)     # 输出两次元组
print (tuple + tinytuple) # 连接元组

#构造包含 0 个或 1 个元素的元组比较特殊
tup1 = ()    # 空元组
tup2 = (20,) # 一个元素，需要在元素后添加逗号
print('------------------------------')

#Set（集合）    集合（set）是一个无序不重复元素的序列。
#可以使用大括号 { } 或者 set() 函数创建集合，注意：创建一个空集合必须用 set() 而不是 { }，因为 { } 是用来创建一个空字典。

student = {'Tom', 'Jim', 'Mary', 'Tom', 'Jack', 'Rose'}
print(student)   # 输出集合，重复的元素被自动去掉
# 成员测试
if 'Rose' in student :
    print('Rose 在集合中')
else :
    print('Rose 不在集合中')


# set可以进行集合运算
a = set('abracadabra')
b = set('alacazam')

print(a)
print(a - b)     # a和b的差集
print(a | b)     # a和b的并集
print(a & b)     # a和b的交集
print(a ^ b)     # a和b中不同时存在的元素
print('------------------------------')

#Dictionary（字典）
#列表是有序的对象集合，字典是无序的对象集合。两者之间的区别在于：字典当中的元素是通过键来存取的，而不是通过偏移存取。

dict = {}
dict['one'] = "1 - 菜鸟教程"
dict[2]     = "2 - 菜鸟工具"

tinydict = {'name': 'runoob','code':1, 'site': 'www.runoob.com'}

print (dict['one'])       # 输出键为 'one' 的值
print (dict[2])           # 输出键为 2 的值
print (tinydict)          # 输出完整的字典
print (tinydict.keys())   # 输出所有键
print (tinydict.values()) # 输出所有值
print('------------------------------')

#Python数据类型转换

print( int() )               # 不传入参数时，得到结果0
print( int(3) )
print( int(3.6) )
print( int('12',16) )        # 如果是带参数base的话，12要以字符串的形式进行输入，12 为 16进制
print( int('0xa',16) )
print( int('10',8) )
print('------------------------------')

print(float(1))
print( float(112))
print( float(-123.6))
print( float('123'))     # 字符串
print('------------------------------')

print(complex(1, 2))
print( complex(1))    # 数字
print( complex("1"))  # 当做字符串处理
# 注意：这个地方在"+"号两边不能有空格，也就是不能写成"1 + 2j"，应该是"1+2j"，否则会报错
print( complex("1+2j"))
print('------------------------------')

para_str = """这是一个多行字符串的实例
多行字符串可以使用制表符
TAB ( \t )。
也可以使用换行符 [ \n ]。
"""
print (para_str)

errHTML = '''
<HTML><HEAD><TITLE>
Friends CGI Demo</TITLE></HEAD>
<BODY><H3>ERROR</H3>
<B>%s</B><P>
<FORM><INPUT TYPE=button VALUE=Back
ONCLICK="window.history.back()"></FORM>
</BODY></HTML>
'''

print (errHTML)







