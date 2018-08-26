
a = [66.25, 333, 333, 1, 1234.5]
# 把一个元素添加到列表的结尾  相当于 a[len(a):] = [x]。
a.append(444)
print(a)

# 通过添加指定列表的所有元素来扩充列表，相当于 a[len(a):] = L
list = [111,222,333]
list.extend(a)
print(list)

#append 是添加一个元素 a 作为一个元素添加到list中
list.append(a)
print(list)

print("---------------")
list = [111,222,333]
list.insert(2,444)
print(list)

list.remove(333)
print(list)


print("---------------")
# 从列表的指定位置移除元素，并将其返回。如果没有指定索引，a.pop()返回最后一个元素。元素随即从列表中被移除。（方法中 i 两边的方括号表示这个参数是可选的，而不是要求你输入一对方括号，你会经常在 Python 库参考手册中遇到这样的标记。）
list = [111,222,333,444,555,666]
# list.pop()
# print(list)

value = list.pop(2)
print(value)
print(list)

print("--------------")
# 移除列表中的所有项，等于del a[:]。
list = [111,222,333,444,555,666]
list.clear()
print(list)

print("--------------")
# 返回列表中第一个值为 x 的元素的索引。如果没有匹配的元素就会返回一个错误。
list = [111,222,333,444,444,333,555,333,666]
index = list.index(333)
print(index)

# 返回 x 在列表中出现的次数。
count = list.count(333)
print(count)

# 返回 x 在列表中出现的次数。
list.sort()
print(list)

# 倒排列表中的元素
list.reverse()
print(list)

print("--------------")
list = [111,222,333,444,333,555,333]
# 返回列表的浅复制，等于a[:]
list1 = list.copy()
print(list1)
list2 = list1.append(999)  #无返回值
print("list=",list)
print("list1=",list1)
print("list2=",list2)

print("----------------------------")
# 将列表当做堆栈使用

stack = [2,3,4,5]
stack.append(6)
print(stack)
stack.pop()
print(stack)


print("将列表当作队列使用--------------")
# 也可以把列表当做队列用，只是在队列里第一加入的元素，第一个取出来；但是拿列表用作这样的目的效率不高。在列表的最后添加或者弹出元素速度快，然而在列表里插入或者从头部弹出速度却不快（因为所有其他的元素都得一个一个地移动）。
from collections import deque
queue = deque(["Eric", "John", "Michael"])
queue.append("Terry")           # Terry arrives
queue.append("Graham")          # Graham arrives
value = queue.popleft()
print(value)
value = queue.popleft()
print(value)


print("列表推导式----------------------")
vec = [2,4,6]
vec2 = [3*x for x in vec]
print("vec2=",vec2)

vec3 = [[x,x**2]for x in vec ]
print("vec3=",vec3)

freshfruit = ['  banana', '  loganberry ', 'passion fruit  ']
freshfruit2=[weapon.strip() for weapon in freshfruit]
print("freshfruit2=",freshfruit2)


vec4 =[3*x for x in vec if x > 3]
print("vec4=",vec4)

print("------------------")


vec1 = [2, 4, 6]
vec2 = [4, 3, -9]
var = [x*y for x in vec1 for y in vec2]
print(var)

var = [x+y for x in vec1 for y in vec2]
print(var)

[vec1[i]*vec2[i] for i in range(len(vec1))]
print(var)


print("------------------")
a = [-1, 1, 66.25, 333, 333, 1234.5]
del a[0]
print(a)



# 嵌套列表解析  以下实例展示了3X4的矩阵列表：
matrix = [
    [1, 2, 3, 4],
    [5, 6, 7, 8],
    [9, 10, 11, 12],
    ]


#以下实例将3X4的矩阵列表转换为4X3列表
var = [[row[i] for row in matrix] for i in range(4)]
print("var=", var)
