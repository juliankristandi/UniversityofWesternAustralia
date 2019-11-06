# @author - Ignatius Julian Kristandi (22167432)
# Project 2 - CITS1401

import math
import os

# main method
def main(corpus_file_name, commonwords_file_name = None):
    text, common = check(corpus_file_name, commonwords_file_name) # calls the check method
    if text == None:
        pass
    else:
        targetword = str(input('Enter target word or multiple target words, space in between. Blank line to end. \n')) # input for target word  
        while True: # while loop to allow blank lines as input
            targetwords = input() # grabs the input
            targetword += ' ' + targetwords # adds the input to previous inputs
            if targetwords == '': # if blank line entered, breaks while loop
                break
        queryword = str(input('Enter query words, one per line. Blank line to start calculating. \n')) # input for query word                 
        while True: # same while loop but for query words
            querywords = input()
            queryword += ' ' + querywords
            if querywords == '':
                break
        if targetword == ' ': # if target word and query word empty, ends program, else asks user to try again
            if queryword == ' ': 
                print('Thank you for using the synonym calculator. Goodbye!') # ends
            else:
                print('Please enter the target word.') # scenario where target word is empty but query word exists
                main(text, common)
        elif queryword == ' ': # scenario where query word is empty but target word exists
            print('Please enter the query word.')
            main(text, common) # makes the program keeps on running
        else:
            calculate(start(sort(text, common)), targetword, queryword)
            main(text, common) # makes the program keeps on running
            
# This method checks if file exists
def check(corpus_file_name, commonwords_file_name):    
    if os.path.isfile(corpus_file_name): # checks if textfile exists
        if os.path.isfile(str(commonwords_file_name)): # checks if common words file exists, else sets to None if not found
            return corpus_file_name, commonwords_file_name
        else:
            print('Common file will be set to None since it is not found.')
            return corpus_file_name, None
    else:
        print('File not found. Please check your text file name.')
        return None, None

# This method sorts the text file, turning it into a list of strings, separated by sentences, removing the common words (if a common word file exists),
# and turns every word into lowercase letters.
def sort(text, commonwords):
    if commonwords == None: 
        textfile = open(text, "r") # opens the text file
        textlist = textfile.read()
        for ch in [',',"'",'"',':',';','(',')','[',']','\n','\t']: # for loop to replace punctuation marks as space and next line or tab symbols
            if ch in textlist:
                textlist = textlist.replace(ch, ' ')
        textlist = textlist.lower().replace("?", ".").replace("!", ".").split(".") # turns the text into lowercase letters, changes all the punctuation that indicates the end of the sentence to a period, and splits the period.
        sortedlist = [] # initialize list
        for str in textlist: # iterates through each sentence in textlist
            str = str.split() # separate word by word
            str = ' '.join(sorted(set(str), key = str.index)) # removes duplicate words
            sortedlist.append(str) # adds sentences to sorted list
        textfile.close()
        return sortedlist
    else:
        textfile = open(text, "r") # opens the text file
        common = open(commonwords, "r") # opens the common words file
        commonlist = common.read().replace("\n", " ").split() # removes the next line symbol and turns into a list of the common words
        textlist = textfile.read()
        for ch in [',',"'",'"',':',';','(',')','[',']','\n','\t']: # for loop to replace punctuation marks as space and next line or tab symbols
            if ch in textlist:
                textlist = textlist.replace(ch, ' ')
        textlist = textlist.lower().replace("?", ".").replace("!", ".").split(".") # turns the text into lowercase letters, changes all the punctuation that indicates the end of the sentence to a period, and splits the period.
        sortedlist = [] # initialize list
        for str in textlist: # iterates through each sentence in textlist
            str = str.split() # separate word by word
            str = [word for word in str if word not in commonlist] # removes word if it is in the commonlist
            str = ' '.join(sorted(set(str), key = str.index)) # combines the word into sentences again whilst removing duplicate words
            sortedlist.append(str) # adds the sentence to the sorted list
        textfile.close()
        common.close()
        return sortedlist

# This method initializes the dictionary of each words, while adding another dictionary for the word count in each sentence.
def start(list):
    dictionaryword = {} # initializes main dictionary
    for str in list: # iterates through each sentence
        wordlist = str.split() # separates sentence to words
        for word in wordlist: # iterates through each word in sentence           
            if dictionaryword.get(word, 0) == 0: # checks if word exists in dictionary word
                wordcount = {} 
            else:
                wordcount = dictionaryword.get(word) # retrieves existing dictionary entry if word exists already
            keyword = word # sets a word as the key word
            for otherword in wordlist: # iterates through each word in sentence
                if otherword == keyword: # compares the word to key word; if same pass
                    pass
                elif otherword in wordcount: # if word already exists, add the count 
                    wordcount[otherword] += 1
                else:
                    wordcount[otherword] = 1 # else sets as 1, since first sentence it is reached
            dictionaryword[keyword] = wordcount # sets the wordcount dictionary as values for the main dictionary
    return dictionaryword

# This method asks for the target word and evaluate the scores for each query word
def calculate(dictionary, targetword, queryword):
    targetword = targetword.split()
    for x in targetword:  # iterates through target words (if there are multiple)
        synonym = {} # initialize dictionary
        targetprofile = dictionary.get(x, 0) 
        if targetprofile == 0: # checks if target word exists
            print("The target word you are searching for does not exist.")
            pass
        else:
            targetprofile = set(targetprofile) 
            if type(queryword) == list: # checks if queryword is already a list
                pass
            else:
                queryword = queryword.split() # splits based on lines
            for word in queryword: # checks each word that is queried
                if dictionary.get(word,0) == 0:
                    score = 0.0
                else:
                    score = 0
                    num_sum = 0 # initialize the sum of the numerator
                    den_sum_target = 0 # initialize the target sum in denominator
                    den_sum_query = 0 # initialize the query sum in denominator
                    queryprofile = set(dictionary.get(word))
                    for str in targetprofile.intersection(queryprofile): # str here is the same words shared
                        target = dictionary.get(x).get(str) # get the count for the words shared from the target profile
                        query = dictionary.get(word).get(str) # get the count for the words shared from the query profile
                        num_multiplier = target * query # calculate the numerator multiplier
                        num_sum = num_sum + num_multiplier # sums the numerator multiplier
                    for item in dictionary.get(x): # for loop to find the sum of the target profile count squared
                        den_target = dictionary.get(x).get(item)
                        den_sum_target = den_sum_target + den_target * den_target
                    for item in dictionary.get(word): # for loop to find the sum of the query profile count squared
                        den_query = dictionary.get(word).get(item)
                        den_sum_query = den_sum_query + den_query * den_query
                    den_sum = math.sqrt(den_sum_target * den_sum_query) # square root the multiplier of both sums
                    score = num_sum / den_sum # finds the score
                synonym[word] = score # insert the word and score into the synonym dictionary
            synonym = sorted(synonym.items(), key=lambda x: x[1], reverse = True) # sorts the dictionary based on highest score, turns into list of tuples
            for tuple in synonym: # prints the sorted list of tuples
                print(tuple[0],': ', "%.3f" % tuple[1]) # rounds to 3 decimal places
            print('The best calculated synonym for',x,'is: ', synonym[0][0])