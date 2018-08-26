# 键必须是唯一的，但值则不必。
# 值可以取任何数据类型，但键必须是不可变的，如字符串，数字或元组。

dict = {'Name': 'Runoob', 'Age': 7, 'Class': 'First'}

print ("dict['Name']: ", dict['Name'])
print ("dict['Age']: ", dict['Age'])

#向字典添加新内容的方法是增加新的键/值对，修改或删除已有键/值对

dict = {'Name': 'Runoob', 'Age': 7, 'Class': 'First'}
dict['Age'] = 8;               # 更新 Age
dict['School'] = "菜鸟教程"  # 添加信息
print ("dict['Age']: ", dict['Age'])
print ("dict['School']: ", dict['School'])


# 如果用字典里没有的键访问数据，会输出错误如下：
dict = {'Name': 'Runoob', 'Age': 7, 'Class': 'First'};
# print ("dict['Alice']: ", dict['Alice'])   #KeyError: 'Alice'

dict = {'Name': 'Runoob', 'Age': 7, 'Class': 'First'}

del dict['Name'] # 删除键 'Name'
dict.clear()     # 清空字典
del dict         # 删除字典
# 删除了  print 会有异常
# print ("dict['Age']: ", dict['Age'])
# print ("dict['School']: ", dict['School'])

#不允许同一个键出现两次。创建时如果同一个键被赋值两次，后一个值会被记住
dict = {'Name': 'Runoob', 'Age': 7, 'Name': '小菜鸟'}
print ("dict['Name']: ", dict['Name'])

#键必须不可变，所以可以用数字，字符串或元组充当，而用列表就不行
# dict = {['Name']: 'Runoob', 'Age': 7}
# print ("dict['Name']: ", dict['Name'])




