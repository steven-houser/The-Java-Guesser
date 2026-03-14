# The Java Guesser

**Name:** Steven Houser  
**Course:** CS 121 - Data Structures & Objects  
**Date:** 03/13/26

---

## Program Description

A number guessing game with two modes: the human tries to guess a computer-picked number, or the computer uses binary search to guess a number the human is thinking of.

## Algorithm

**Goal:** Build an interactive guessing game that supports a human guesser mode and a binary search computer guesser mode, accessed through a menu loop.

**Variables needed:**

- `input` - Scanner for all user input (Scanner)
- `keepGoing` - controls the main menu loop (boolean)
- `response` - menu choice read as a String (String)

---

### 1. Menu

**Goal:** Print the options and return the user's choice as a String.

**Steps:**

1. Print the menu options
    - Print "0) Exit"
    - Print "1) Human Guesser"
    - Print "2) Computer guesser"
2. Print prompt "Please enter 0-2: "
3. Read response with nextLine()
4. Return response

---

### 2. Main Loop

**Goal:** Keep the menu active until the user chooses to exit.

**Steps:**

1. Set keepGoing to true
2. While keepGoing is true:
    - Call menu(), store result in response
    - If response equals "0": set keepGoing to false
    - Else if response equals "1": call humanGuesser()
    - Else if response equals "2": call computerGuesser()

---

### 3. Human Guesser

**Goal:** Computer picks a random number, human tries to guess it. Evaluate performance based on number of turns.

**Variables needed:**

- `target` - the randomly generated number (int)
- `strGuess` - user's guess read as a String (String)
- `guess` - parsed integer version of strGuess (int)
- `turns` - counts how many guesses were made (int)
- `hKeepGoing` - controls the inner guess loop (boolean)

**Steps:**

1. Generate target: (int)(Math.random() * 100) + 1
2. Set turns to 0, hKeepGoing to true
3. While hKeepGoing is true:
    - Increment turns by 1
    - Print turn number and prompt for guess
    - Read strGuess with nextLine()
    - Try to parse strGuess to int with Integer.parseInt()
    - If the conversion fails:
        - Print "Please enter a number."
        - Subtract 1 from turns so a bad entry does not count
    - Else continue with the guess:
        - If guess equals target:
            - Print "got it!"
            - Set hKeepGoing to false
        - Else if guess < target: print "too low..."
        - Else: print "too high..."
4. Evaluate performance after loop ends:
    - If turns < 7: print "Very good!"
    - Else if turns == 7: print "Average/Good job"
    - Else: print "Poor performance"

---

### 4. Computer Guesser (Binary Search)

**Goal:** Computer eliminates half the remaining possibilities each turn to find the number the human is thinking of.

**Variables needed:**

- `lower` - lower bound of the current range, starts at 1 (int)
- `upper` - upper bound of the current range, starts at 100 (int)
- `guess` - computer's current guess, calculated by getMean (int)
- `turns` - counts how many guesses were made (int)
- `response` - H/L/C feedback from the user (String)

**Steps:**

1. Set lower to 1, upper to 100, turns to 0
2. Calculate first guess with getMean(lower, upper) (returns 50)
3. Loop until user says correct:
    - Increment turns by 1
    - Print turn number and current guess
    - Prompt "Too (H)igh, too (L)ow, or (C)orrect? "
    - Read response with nextLine()
    - If response equalsIgnoreCase "h": set upper to guess - 1
    - Else if response equalsIgnoreCase "l": set lower to guess + 1
    - Else if response equalsIgnoreCase "c": break out of loop
    - Recalculate guess with getMean(lower, upper)

---

### getMean Helper

**Goal:** Return the midpoint between two bounds.

**Steps:**

1. Return (lower + upper) / 2

---

## Build Instructions

- **Build:** `make`
- **Run:** `make run`
- **Clean:** `make clean`
- **Debug:** `make debug`
