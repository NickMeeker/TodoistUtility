# TodoistUtility
Developed mostly for personal use. Parses spreadsheet planner (as .csv, not .xlsm) of the form:

Topics,Course,Req (mins),Practical Start,Ideal Start,Ideal Done,Done & Due,Section,Earned Points,Total Points,Grade %

And creates a new task on Todoist using the relevant information from the spreadsheet. Takes .csv file name as argument. Sample file included as both .csv and .xlsm. 

# Bearer Token
Note that the bearer token provided by Todoist is hard-coded as a String in the TodoistUtility class. If you want to play around with this, you'll have to provide your own token. 
