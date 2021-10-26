from tkinter import*
from PIL import ImageTk
from tkinter import messagebox
class Login:
    def __init__(self,root):
        self.root=root
        self.root.title("Login system")
        self.root.geometry("900x560+100+50")
        self.root.resizable(False,False)
        #BG Image
        self.bg=ImageTk.PhotoImage(file="logo.jpg") #add your image or ang bg of your own choice make sure you update it;s path & name.
        self.bg_image=Label(self.root,image=self.bg).place(x=0,y=0,relwidth=1,relheight=1)

        #Login Frame
        Frame_login=Frame(self.root,bg="white")
        Frame_login.place(x=200,y=100,height=300,width=500)

        title=Label(Frame_login,text="LOGIN HERE",font=("Goudy old style",35,"bold"),fg="#1282B4",bg="white").place(x=120,y=10)
        desc=Label(Frame_login,text="Member Login Area",font=("Goudy old style",18,"bold"),fg="#108FC8",bg="white").place(x=160,y=60)
        #username input
        usr_name=Label(Frame_login,text="Username: ",font=("Goudy old style",16,"bold"),fg="#1282B4",bg="white").place(x=52,y=100)
        self.text_user=Entry(Frame_login,font=("Times new roman", 13),bg="white")
        self.text_user.place(x=152,y=100,width=300,height=35)
        #password input
        usr_pass = Label(Frame_login, text="Password: ", font=("Goudy old style", 16, "bold"), fg="#1282B4",bg="white").place(x=52, y=160)
        self.text_pass = Entry(Frame_login, font=("Times new roman", 13), bg="white")
        self.text_pass.place(x=152,y=160,width=300,height=35)
        #forget button
        forget_btn=Button(Frame_login,text="Forgot Password?", bg="white",fg="#1282B4",bd=0,font=("Times new roman", 13)).place(x=200,y=210)
        #login button
        Login_btn=Button(self.root,command=self.login_function,text="LOGIN", fg="white",bg="#1272B4",font=("Times new roman",12)).place(x=430,y=350)

    def login_function(self):
        if self.text_pass.get()=="" or self.text_user.get()=="":
            messagebox.showerror("Error", "All fields are required",parent=self.root)
        elif self.text_pass.get()!="123456" or self.text_user.get()!="Mayank":
            messagebox.showerror("Error", "Invalid Username or Password",parent=self.root)
        else:
            messagebox.showinfo("Welcome to MVP Degitz", f"Welcome {self.text_user.get()}",parent=self.root)
                                                        # f"\nYour password: {self.text_pass.get()})",parent=self.root)

#Tkinket fxn
root=Tk()
obj=Login(root)
root.mainloop()
