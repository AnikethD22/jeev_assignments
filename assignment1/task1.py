'''
Enter the first integer: 10
Enter the second integer: 20
Enter a floating-point number: 5.5
Enter a single character: A
Enter a boolean value (true/false): true
Enter your name: John

Sum of 10 and 20 is: 30
Difference between 10 and 20 is: -10
Product of 10 and 20 is: 200
5.5 multiplied by 2 is: 11.0
The next character after 'A' is: B
The opposite of true is: false
Hello, John!
'''

num1 = int(input("Enter 1st Integer:"))
num2 = int(input("Enter 2nd Integer:"))
print("Sum of", num1, "and", num2, "is", (num2+num1))
print("Difference between", num1, "and", num2, "is", (num1-num2))
print("Product of", num1, "and", num2, "is", (num1*num2))

float_input = float(input("Enter a floating-point number:"))
print(float_input, "multiplied by 2 is", (float_input * 2))

char_input = input("Enter a single character:")
next_ascii_value = ord(char_input) + 1
next_character = chr(next_ascii_value)
print("The next character after", char_input, "is:", next_character)

boolean_input = input("enter a boolean value (true/false):")
bool_value = boolean_input.lower() == "true"
opposite_bool_value = not bool_value
print(f"The opposite of {boolean_input} is:{opposite_bool_value}")

name_input = input("Enter your name:")
print(f"Hello {name_input}!")