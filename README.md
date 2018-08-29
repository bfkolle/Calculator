# Calculator

Final working version of a calculator I built in between Computer Science II and III. Nearly completely redid the entire project to replace the math system with postfix evaluation, as opposed to the wonky custom logic I had implemented earlier. Edited visual appeal of the calculator to give a modern look that is familiar to many users. As far as I know, there are no bugs after extensive testing. All operations, except for division, are set to unlimited precision. Division has been set to 10 digits after the decimal point to address the exception of the system being unable to display an infinite number (like 1/3).

To-do:

Possibly separate the calculator buttons into their own class.

To produce a working version, clone the repository and then on the command line type "jar cfm Calculator.jar manifest.txt *.class css\main.css" in the directory where you cloned the repository.
