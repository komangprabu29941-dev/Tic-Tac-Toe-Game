# Simple Tic-Tac-Toe Game with Java Swing, Login, and Statistics

## Student Information
Name: Komang Prabu Suthaleksana
Student ID: 5026251105
Class: E

## Project Description
This project is a simple Tic-Tac-Toe game built using Java Swing.
The application includes login, game statistics, and Top 5 scorer
feature.

## Features
- Login using database
- Play Tic-Tac-Toe using Swing GUI
- Record wins, losses, draws, and score
- Display personal statistics
- Display Top 5 scorers using JTable
  
## Database
Database used: MySQL

## How to Run
1. Create the database.
2. Import schema.sql.
3. Open the Java project.
4. Add JDBC driver.
5. Configure DatabaseManager.java.
6. Run Main.java.

## Class Explanation
Main: Starting or entry point of the Tic-Tac-Toe program to open the Login window
DatabaseManager: This class is to handles JBDC connection to MySQL database
Player: Class to stores player data like id, username, wins, losses, draws, score
PlayerService: Class to handles login, updating the statistics, and retrieving the top 5 scorers from the database
GameLogic: Handles Tic-Tac-Toe rules including move validation, win checking, draw checking, and computer moves
LoginFrame: Swing window for user login with username and password input
MainMenuFrame: Swing window for main menu navigation after successful login
GameFrame: Swing window for playing the Tic-Tac-Toe game with 3x3 grid board
StatisticsFrame: Swing window to displays personal game statistics
TopScorersFrame: Swing window to displays the top 5 scorers using JTable

## Screenshots
Login:
<img width="333" height="262" alt="Screenshot 2026-06-26 222544" src="https://github.com/user-attachments/assets/14cf0174-f129-4a78-a8eb-a2343eb26473" />

Game Frame:
<img width="386" height="492" alt="Screenshot 2026-06-26 222631" src="https://github.com/user-attachments/assets/ec0a0f8e-b041-4d68-9a37-cbb7f4f0195b" />

Top 5 Scorer:
<img width="467" height="271" alt="Screenshot 2026-06-26 222638" src="https://github.com/user-attachments/assets/c24fef15-5748-4b28-88b8-80022b75251f" />

## Video Link
YouTube: https://youtu.be/BvQfRVXS17w
