
from tkinter import *
import random
import time
tk = Tk()
tk.title("Bounce")
tk.resizable(0, 0)
tk.wm_attributes("topmost", 1)
canvas = Canvas(tk, width = 500, height=400, bd = 0, highlihgtthickness = 0) 
canvas.pack()
tk.update
import random
import time
class Ball:\def_init_(self, canvas, color):
self.canvas = canvas
self.id = canvas.create_oval(10, 10, 25, 25, fill=color)
self.canvas.move(self.id,245,100)
def draw(self):
pass
ball=Ball(canvas,'red')
