
basket = {'apple', 'orange', 'apple', 'pear', 'orange', 'banana'}
print(basket)                      # 删除重复的

print("orange" in basket)

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




