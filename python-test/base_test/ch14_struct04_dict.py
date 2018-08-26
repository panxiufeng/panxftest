

tel = {'jack': 4098, 'sape': 4139}
tel['guido'] = 4127
print(tel)

del tel['jack']
print(tel)

print("在字典中遍历时，关键字和对应的值可以使用 items() 方法同时解读出来--------------")
knights = {'gallahad': 'the pure', 'robin': 'the brave'}
for k, v in knights.items():
    print(k,'=', v)


print("在序列中遍历时，索引位置和对应值可以使用 enumerate() 函数同时得到--------------")
for i, v in enumerate(['tic', 'tac', 'toe']):
    print(i,'=', v)


print("同时遍历两个或更多的序列，可以使用 zip() 组合--------------")
questions = ['name', 'quest', 'favorite color']
answers = ['lancelot', 'the holy grail', 'blue']
for q, a in zip(questions, answers):
    print('What is your {0}?  It is {1}.'.format(q, a))

print("要反向遍历一个序列，首先指定这个序列，然后调用 reversed() 函数----------------------")
for i in reversed(range(1, 10, 2)):
    print(i)

print("要按顺序遍历一个序列，使用 sorted() 函数返回一个已排序的序列，并不修改原值----")
basket = ['apple', 'orange', 'apple', 'pear', 'orange', 'banana']
for f in sorted(set(basket)):
    print(f)






