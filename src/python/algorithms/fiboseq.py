# Program to display the Fibonacci sequence up to nth term where n is provided by the user

# change this value for a different result
nterms = 8

# uncomment to take input from the user
#nterms = int(input("How many terms? "))

# first two terms
n1 = 0
n2 = 1
count = 0

# check if the number of terms is valid
if nterms <= 0:
   print("Please enter a positive integer")
elif nterms == 1:
   print("Fibonacci sequence upto:",nterms)
   print(n1)
else:
   print("Fibonacci sequence upto:",nterms)
   while count < nterms:
       if count < nterms - 1:
         # ends the output with a commma and space instead of default newline
         print(n1,end=", ")
       else:
          print(n1)
       nth = n1 + n2
       # update values
       n1 = n2
       n2 = nth
       count += 1
