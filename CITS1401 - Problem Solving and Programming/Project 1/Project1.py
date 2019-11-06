# @author - Ignatius Julian Kristandi (22167432)
# Project 1 - CITS1401 - 26 April 2018

import os

# 1 - Test whether the file assigned to variable filename is actually present.
def open_file(filename):
    if os.path.isfile(filename):
        infile = open(filename, "r")
        return infile
    else:
        print("File not found.")
        return None
    close(filename)

# 2 - This function returns a list of two item lists, where the first item in each pair is the code for the unit,
# and the other is a floating point number representing the maximum mark achieved in that unit. 
def get_units(unitfile):
    global unit_number # Used global here to compare to the next function - I cannot think of not using global here sorry.
    unit_number = 0
    x = open(unitfile)
    a = []
    for row in x:
        y = row.split(",")
        y[1] =  abs(float(y[1]))
        a.append(y)
        unit_number = unit_number + 1
    return a, unit_number

# 3 -  This function returns a list containing a list for each student.
def get_student_records(students_file, unit_count):
    if unit_count == unit_number:
        x = open(students_file)
        y = []
        for line in x:
            i = 0
            list = line.split(",")
            list[-1] = list[-1].rstrip()
            for i in range(len(list)):
                if list[i] == list[0]:
                    pass
                elif list[i] == '' :
                    list[i] = None
                else:
                    list [i] = abs(float(list[i]))
                i = i + 1
            y.append(list)
        return y
    else:
        print("Error!")
        
# 4 - Return a new list of student records in which, for each of a student's marks,
# the percentile mark is computed by dividing the actual mark by the maximum mark for the corresponding subject.
def normalise(students_list, units_list):
    i = 0
    z = units_list
    x = students_list
    for list in x:
        for i in range(len(list[:])):
            if list[i] == list[0] or list[i] == None:
                pass
            else:
                list[i] = list[i] / z[i - 1][1]
            i = i + 1
        i = 0
    return x

# 5 - This function computes the mean (average) percentile, ignoring the None values.
def compute_mean_pc(students_pclist):
    x = students_pclist
    i = 0
    total = 0.0
    number = 0
    y = [None, None]
    a = []
    for list in x:
        for i in range(len(list[:])):
            if list[i] == None:
                pass
            elif list[i] == list[0]:
                y[1] = list[i]
            else:
                total = total + list[i]
                number = number + 1
            i = i + 1
        y[0] = (total / number)
        a.append(y)
        total = 0.0
        number = 0
        i = 0
        y = [None, None]
    return a

# 6 -  Print the list to standard output (screen by default), one per line, with the name appearing first.
def print_final_list(mean_pclist):   
    x = mean_pclist
    x.sort(reverse = True)
    for list in x:
        print(list[1], ("%.3f" % list[0]))

# 7 - Prompts the user for the name of the unit and maximum marks file,
# and the name of the student marks file, and then computes and prints out the ranked list.
def main():
    x = str(input("Enter the name of the units and maximum marks file: "))
    y = str(input("Enter the name of the student marks file: "))
    open_file(x)
    open_file(y)
    x, z = get_units(x)
    y = get_student_records(y, z)
    print_final_list(compute_mean_pc(normalise(y, x)))
            
main()        