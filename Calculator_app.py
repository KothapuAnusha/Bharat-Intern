import tkinter as tk

def clear():
    entry.delete(0, tk.END)

def click_number(number):
    current = entry.get()
    entry.delete(0, tk.END)
    entry.insert(0, current + str(number))

def calculate():
    try:
        expression = entry.get()
        result = eval(expression)
        entry.delete(0, tk.END)
        entry.insert(0, result)
    except Exception as e:
        entry.delete(0, tk.END)
        entry.insert(0, "Error")

# Create a tkinter window
window = tk.Tk()
window.title("Simple Calculator")
window.geometry("400x600")

# Entry widget for displaying the input and result
entry = tk.Entry(window, font=("Helvetica", 24))
entry.pack(fill="both", expand=True, padx=20, pady=20)

# Create a grid of buttons for numbers and operators
button_frame = tk.Frame(window)
button_frame.pack(fill="both", expand=True)

buttons = [
    '7', '8', '9', '/',
    '4', '5', '6', '*',
    '1', '2', '3', '-',
    'C', '0', '=', '+'
]

row, col = 1, 0
for button in buttons:
    if button == 'C':
        tk.Button(button_frame, text=button, font=("Helvetica", 18), command=clear).grid(row=row, column=col, padx=5, pady=5, sticky="nsew")
    elif button == '=':
        tk.Button(button_frame, text=button, font=("Helvetica", 18), command=calculate).grid(row=row, column=col, padx=5, pady=5, sticky="nsew")
    else:
        tk.Button(button_frame, text=button, font=("Helvetica", 18), command=lambda b=button: click_number(b)).grid(row=row, column=col, padx=5, pady=5, sticky="nsew")
    col += 1
    if col > 3:
        col = 0
        row += 1

# Make the grid cells expand equally
for i in range(4):
    button_frame.columnconfigure(i, weight=1)
    button_frame.rowconfigure(i, weight=1)

# Run the tkinter main loop
window.mainloop()

