# About/Overview
This program provides a comprehensive management system for U10 soccer teams. Utilizing object-oriented principles, it allows users to fill in player profiles, add them into team, create a team, and see the team's all players and starting lineup.

# List of Features
## Player Management:
- Add, remove, and view player profiles.
- View detailed player attributes including name, date of birth, preferred position, skill level, and actual game position.
## Team Management:
- Add or remove players from the team.
- Define starting lineup and bench players.
- Assign jersey numbers.
## Interactive GUI:
- User-friendly interface to manage the soccer team.
- Real-time updates on the team's roster and lineup.
# How To Run
## Running the jar file:
- Open the terminal or command prompt.
- Navigate to the directory containing the jar file.
- Use the command java -jar finalProject.jar.
## Arguments:
Currently, no arguments are required to run the jar file. 

# How to Use the Program
## Adding a Player:
- Fill in the player details (name, date of birth, preferred position, skill level).
- Click the 'Add Player' button.
## Removing a Player:
- Type in the first name and the last name of the player you want to remove.
- Click the 'Remove Player' button.
## Creating a Team:
- Once all players are added and the number of players are not less than 10, click on the 'Create Team' button. This assigns jersey numbers and defines the starting lineup and bench.
# Design/Model Changes
## Version 1.0:
- Initial release with basic player and team management features, but only printing the result in terminal without interactive GUI.
## Version 1.1:
- Introduced interactive GUI for improved user experience.


# Assumptions
- A player can only be in one position at a time.
- A player's skill level remains constant and does not change over time.
- A player's preferred position remains unchanged (but his/her actual position in team can be changed).
- Two players cannot have the same name.

# Limitations
- The program currently supports only U10 soccer teams.
- Limited error handling for incorrect user inputs in the GUI.

# Citations
None.

I hope this README provides a clear understanding of the program. For any queries or issues, please refer to the specific code or contact me.