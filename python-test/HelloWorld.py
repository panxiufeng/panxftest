#! /usr/bin/env python
# -*- coding: utf-8 -*-

def foo():
    str="function"
    print(str);

def foo1(num):
    print('num' ,num);

def foo2(name ,age):
    print('name' ,name);
    print('age' ,age);

if __name__=="__main__":
    print("main")
    foo2('yuhui' ,30)
    foo1(6)
    foo()

if True:
    print ("True")
else:
    print ("False")

days = ['Monday', 'Tuesday', 'Wednesday',
        'Thursday', 'Friday']

print (days)

#Python字符串格式化

print ("我叫 %s 今年 %d 岁!" % ('小明', 10))
s = 'RUNOOB'
print(str(s))
print('------------------------------')

dict = {'runoob': 'runoob.com', 'google': 'google.com'};
print(str(dict))
print('------------------------------')
