# Python program to illustrate cube of a number
# showing difference between def() and lambda().


def cube(y):
	return y*y*y;
	
g = lambda x: x*x*x
print(g(7))
	
print(cube(5))
