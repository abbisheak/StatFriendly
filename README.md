# Stat Friendly

## What is Stat Friendly and It's Purpose

Stat Friendly is an application that will allow for sorted data to be used for statistical analysis. The user interface will allow those with minimal background in statistics to choose the tools they want and understand the results they receive. Simple questions will be asked about how the user will wish to interpret the data they are providing, allowing for a beginner-friendly experience. The user will have access to complex statistical methods such as

* Simple Averages
* Confidence Intervals
* Hypothesis Testing
* Multivariate Analysis

all behind an inviting interface. This can be used by those wanting to step into statistics, those looking for a less complex interface to do their computations, or even those who don't know the difference between a mean and a median.


## Why I chose to make Stat Friendly

Statistics has been the start of everything for me, it is the reason why I am currently pursuing mathematics and computer science. I found that statistics is actually one of the most fascinating areas of study, but it is often painted as a gray field of interest. I find that perspective the result of a lack of knowledge and/or experience, so that is why I want to create statistics more inviting to those from all backgrounds. Ease of entry for the beginner, while also providing convenience for the more experienced. 

## User Stories
* I want to be able to add a data entry to a data vector
* I want to be able to view each data entry of my data vector
* I want to be able to delete and start a new data vector
* I want to be able to compute basic averages for my data vector
* I want to be able to view my data's statistics and see how they are changed with each data entry
* I want to be able to see the likelihood of something happening with respect to my data through a confidence interval
* I want to be able to add multiple Data Vectors to my Data Space
* I want to be able to save my data entries in my Data Space into a file, if I so do choose
* I want to be given the option to load my Data Space from a file


# Instructions for End User

- You can "add multiple Xs to a Y" by navigating from the main menu. If you select "Create New Data Space",  you will create your data space (Y) and then add your first data vector to the data space (X). From here the steps align between those who select "Create New Data Space" and "Load Previous Data Space", the user can then select "Add New Data Vector" and then they can input their desired name for the data vector and desired data entries. Hence the user may add multiple data vectors (X) to their data space (Y).
- You can generate the first required action related to the user story "adding multiple Xs to a Y" by navigating from the main menu and either creating a new data space (the instructions are very easy to follow), or loading a previous data space. From there the user will be presented with the option to "View Data" for which the user will be presented with statistical information for their data vector.
- You can generate the second required action related to the user story "adding multiple Xs to a Y" by following the same steps as above, but instead of selecting the "View Data" option, the user selects "Add Data". This will allow the user to update their data vector with data entries and be able to view the changes as they add more entries.
- You can locate my visual component by accessing the "View Data" option as outlined in the first required action. From there you will see a box plot diagram that is customized for the data vector that is being viewed.
- You can save the state of my application by navigating from the data vector options that allow you to view and add data entries, to the data vector selection page by clicking "Go Back". From there the user will have the option to "Save and Quit".
- You can reload the state of my application by starting the application, where the user will have the option presented to "Load Previous Data Space".

# Phase 4: Task 2

- <<Fri Nov 29 10:42:20 PST 2024>>Data vector <Data vector 1> added to data space.
- <<Fri Nov 29 10:42:24 PST 2024>>Calculated statistics for data set.
- <<Fri Nov 29 10:42:24 PST 2024>>Data entry added to data set for data vector.
- <<Fri Nov 29 10:42:25 PST 2024>>Calculated statistics for data set.
- <<Fri Nov 29 10:42:25 PST 2024>>Data entry added to data set for data vector.
- <<Fri Nov 29 10:42:30 PST 2024>>Data vector mean retreived
- <<Fri Nov 29 10:42:30 PST 2024>>Data vector median retreived
- <<Fri Nov 29 10:42:30 PST 2024>>Data vector mode retreived
- <<Fri Nov 29 10:42:30 PST 2024>>Data vector max retreived
- <<Fri Nov 29 10:42:30 PST 2024>>Data vector min retreived
- <<Fri Nov 29 10:42:30 PST 2024>>Data vector standard deviation retreived
- <<Fri Nov 29 10:42:30 PST 2024>>Data vector mean retreived
- <<Fri Nov 29 10:42:30 PST 2024>>Data vector standard deviation retreived
- <<Fri Nov 29 10:42:30 PST 2024>>Data vector 95% confidence interval retreived
- <<Fri Nov 29 10:42:30 PST 2024>>Data vector mean retreived
- <<Fri Nov 29 10:42:30 PST 2024>>Calculated statistics for data set.
- <<Fri Nov 29 10:42:30 PST 2024>>Data entry added to data set for data vector.
- <<Fri Nov 29 10:42:30 PST 2024>>Data vector mean retreived
- <<Fri Nov 29 10:42:30 PST 2024>>Calculated statistics for data set.
- <<Fri Nov 29 10:42:30 PST 2024>>Data entry added to data set for data vector.
- <<Fri Nov 29 10:42:30 PST 2024>>Data vector mean retreived
- <<Fri Nov 29 10:42:41 PST 2024>>Data vector <Data vector 2> added to data space.

# Phase 4: Task 3

I am quite happy with the turnout of my project, however there are many design aspects of my project that I wish I could've changed if I had more time. Starting off, the user may notice in the code functionality that allows the user to store data as the data type long. This functionality is not available to the user, as I found that my project started to exponentially become more complicated, as the project scaled through the months, hence I only used the Double type functionality. I would have wanted to implement the long data type for the app, as this would ensure greater accuracy, but I struggled to find a middle ground between repeated code and functionality for the implementation.

A major let down of the project, was the inability of the app to provide confidence intervals for varying confidence levels. As of right now the project provides confidence intervals at a fixed confidence level of 95%. I wanted to allow the user the ability to select their confidence level, but this required a more advanced program. I had asked TA's and my instructor for advice, which led to me looking at using external libraries, however the current state of the project did not allow for that. My implementation of recording data argued with the implementation of these external libraries, which did not allow me to move forward with my goal. The main issue was that I coded my project without the thought of using external libraries such as java stat, hence if I had more time I would scrap and redesign my primitive data types.