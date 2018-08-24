basket = {'apple', 'orange', 'apple', 'pear', 'orange', 'banana'}
print(basket)                      # 这里演示的是去重功能

flag  = 'orange' in basket                 # 快速判断元素是否在集合内
print(flag)

# 两个集合间的运算
a = set('abracadabra')
b = set('alacazam')
print(a)
print(b)

print(a - b)     # a和b的差集
print(a | b)     # a和b的并集
print(a & b)     # a和b的交集
print(a ^ b)     # a和b中不同时存在的元素
print('------------------------------')

# 类似列表推导式，同样集合支持集合推导式(Set comprehension):
a = {x for x in 'abracadabra' if x not in 'abc'}
print(a)


# 将元素 x 添加到集合 s 中，如果元素已存在，则不进行任何操作
thisset = set(("Google", "Runoob", "Taobao"))
thisset.add("Facebook")
print(thisset)


# 移除元素
thisset = set(("Google", "Runoob", "Taobao"))
thisset.remove("Taobao")
print(thisset)
#thisset.remove("Facebook")   # 不存在会发生错误

# 此外还有一个方法也是移除集合中的元素，且如果元素不存在，不会发生错误
thisset.discard( "Facebook" )

# 也可以设置随机删除集合中的一个元素
print (thisset.pop())

print(len(thisset))

# 清空集合
thisset.clear()