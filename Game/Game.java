import javax.swing.JFrame;
import java.awt.Container;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

public class Game {
    JFrame border;
    Container con; //container (base and you can put several thing on this base) window and comes container, and then other things like panel.
    JPanel titleNameBox, gameStartPanel, mainTextPanel, chooseButtonPanel, statsPanel;
    JLabel gameTitle, hpLabel, hpLabelNumber, weapenLabel, weapenLabelType;
    Font gameTitleFont = new Font("Times New Roman", Font.PLAIN, 92);
    Font startGameButtonFont = new Font("Times New Roman", Font.PLAIN, 20);
    JButton startGameButton, option1, option2, option3, option4;
    JTextArea mainTextArea;

    int playerHP, monsterHP, silverRing;
    String attackWith, position;
    StartButtonClicker sbClicker = new StartButtonClicker();
    OptionsHandler opHandler = new OptionsHandler(); 

    public static void main(String[] args) {
        new Game();
    }
    //we need to create a game window first
    public Game() {
        border = new JFrame();
        border.setSize(800, 800);
        border.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //for closing the window. 
        border.getContentPane().setBackground(Color.black); //color of the window that we are creating. 
        border.setLayout(null); //jframe has a default layout, so we have to set it null first. so we can customize the layout. 
        border.setVisible(true); //even though you created the program, you cannot see -- you need to make it true to see the window.
        con = border.getContentPane(); 

        //making title screen of the game, name for the game. using something called JPanel.
        titleNameBox = new JPanel();
        titleNameBox.setBounds(100, 100, 600, 100); //placing a panel to display title name, text. start from x, y , size in pixels.  
        titleNameBox.setBackground(Color.black);  
        con.add(titleNameBox, con, 0);
        //now create a text on this panel using something called JLabel.

        gameTitle = new JLabel("Adventure");
        gameTitle.setForeground(Color.white); //font color
        //adding gameTitle into the panel. 
        gameTitle.setFont(gameTitleFont);
        titleNameBox.add(gameTitle);
        
        //to create start button, we are creating another JPanel.
        gameStartPanel = new JPanel();
        gameStartPanel.setBounds(300, 400, 200, 100);
        gameStartPanel.setBackground(Color.black);
        startGameButton = new JButton("Start the adventure");
        startGameButton.setBackground(Color.black);
        startGameButton .setForeground(Color.white);
        startGameButton.setFont(startGameButtonFont);
        startGameButton.setFocusPainted(false);
         //setting the font
        startGameButton.addActionListener(sbClicker); //whehn you click this button, this button recognizes the click and call this sbClicker and you can type the result in that handler, calling function. 
         gameStartPanel.add(startGameButton);
        con.add(titleNameBox);
        con.add(gameStartPanel);
   }

   public void createGameScreen() {
        titleNameBox.setVisible(false);
        gameStartPanel.setVisible(false);
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);
        mainTextArea = new JTextArea("Hi there how are you doing today? I was wondering if you are free for a coffee today????????????????????????????????");
        mainTextArea.setLineWrap(true);
        mainTextArea.setBounds(100,100,600,250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(startGameButtonFont);
        mainTextPanel.add(mainTextArea);


        chooseButtonPanel = new JPanel();
        chooseButtonPanel.setBounds(250,350,300,150);
        chooseButtonPanel.setBackground(Color.black);
        chooseButtonPanel.setLayout(new GridLayout(4,1));
        con.add(chooseButtonPanel);

        option1 = new JButton("Choice 1");
        option1.setBackground(Color.black);
        option1.setForeground(Color.white);
        option1.setFont(startGameButtonFont);
        chooseButtonPanel.add(option1);
        option1.setFocusPainted(false); //to remove the inner surrounding box. 
        option1.addActionListener(opHandler); //to connect 4 buttons 
        option1.setActionCommand("c1"); //this is the key that makes the buttons different?
        

        option2 = new JButton("Choice 2");
        option2.setBackground(Color.black);
        option2.setForeground(Color.white);
        option2.setFont(startGameButtonFont);
        chooseButtonPanel.add(option2);
        option2.setFocusPainted(false);
        option2.addActionListener(opHandler); 
        option2.setActionCommand("c2"); 

        option3 = new JButton("Choice 3");
        option3.setBackground(Color.black);
        option3.setForeground(Color.white);
        option3.setFont(startGameButtonFont);
        chooseButtonPanel.add(option3);
        option3.setFocusPainted(false);
        option3.addActionListener(opHandler); 
        option3.setActionCommand("c3"); 

        option4 = new JButton("Choice 4");
        option4.setBackground(Color.black);
        option4.setForeground(Color.white);
        option4.setFont(startGameButtonFont);
        chooseButtonPanel.add(option4);
        option4.setFocusPainted(false);
        option4.addActionListener(opHandler); 
        option4.setActionCommand("c4"); //we will compare with c4 and the do this statements.

        statsPanel = new JPanel();
        statsPanel.setBounds(105,20,400,50);
        statsPanel.setBackground(Color.blue);
        statsPanel.setLayout(new GridLayout(1,4));
        con.add(statsPanel);

        hpLabel = new JLabel("HP:");
        hpLabel.setFont(startGameButtonFont);
        hpLabel.setForeground(Color.white);
        statsPanel.add(hpLabel);

        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(startGameButtonFont);
        hpLabelNumber.setForeground(Color.white);
        statsPanel.add(hpLabelNumber);

        weapenLabel = new JLabel("Weapon:");
        weapenLabel.setFont(startGameButtonFont);
        weapenLabel.setForeground(Color.white);
        statsPanel.add(weapenLabel);
        
        weapenLabelType = new JLabel();
        weapenLabelType.setFont(startGameButtonFont);
        weapenLabelType.setForeground(Color.white);
        statsPanel.add(weapenLabelType);
        
        playerSetup();
   }
   public void playerSetup() {
        playerHP = 16; //default ones
        monsterHP = 21;
        attackWith = "Knife"; 
        weapenLabelType.setText(attackWith); //you can use setText method to display what ever you want. //you can also manually type what ever you need. 
        hpLabelNumber.setText(" "+ playerHP); //we converted int to the string. 
        gate();
   }

   public void gate() {
    position = "gate";
    option2.setVisible(true);
    option3.setVisible(true);
    option4.setVisible(true);
    mainTextArea.setText("You are at the gate of the town. \n A guard is standing infront of you. \n What do you do?");
    option1.setText("Talk to the guard");
    option2.setText("Attack the guard");
    option3.setText("Leave");
    option4.setVisible(false); //setting the final one invisible because we only have 4 options.
   }

   public void talkGuard() {
    position = "talkGuard";
    mainTextArea.setText("Guard: Hello stranger. I have never seen your face. \n I'm sorry but I cannot let a stranger enter our town");
    option1.setText("Go back");
    option2.setText("");
    option3.setText("");
    option4.setText("");
   }
   
   public void attackGuard() {
    position = "attackGuard";
    mainTextArea.setText("Hey! Don't be stupid! \n The guard fought back and hit you hard. \n (You received 3 damage) ))");
    playerHP = playerHP - 3;
    hpLabelNumber.setText("" + playerHP);
    option1.setText("Go back");
    option2.setText("");
    option3.setText("");
    option4.setText("");
   }

   public void goSomewhereElse() {
    position = "crossRoad";
    option2.setVisible(true);
    option3.setVisible(true);
    option4.setVisible(true);
    mainTextArea.setText("You are at a cross road. \n If you go South, you will go back to the town.");
    option1.setText("Go North");
    option2.setText("Go East");
    option3.setText("Go South");
    option4.setText("Go West");
   }

   public void goNorth() {
    position = "north";
    mainTextArea.setText("There is a river. \n You drink the water and rest at the riverside. \n (Your HP is recovered by 2)");
    playerHP = playerHP + 2;
    hpLabelNumber.setText("" + playerHP);
    option1.setText("Go south");
    option2.setVisible(false);
    option3.setVisible(false);
    option4.setVisible(false);

   }
   public void goEast() {
     position = "east";
     mainTextArea.setText("You walk into a forest and found a long sword! \n \n (You found a new weapon.)");
     attackWith = "Long Sword";
     weapenLabelType.setText(attackWith);
     option1.setText("Go West");
     
     }

   public void goWest() {
    position = "west";
    option2.setVisible(true);
    mainTextArea.setText("You encounter a goblin");
    option1.setText("Fight");
    option2.setText("Run");

   }

   public void fight() {
    position = "fight";
    option2.setVisible(true);
    mainTextArea.setText("Monster HP: " + monsterHP + "\n \n What do you want to do?");
    option1.setText("Attack");
    option2.setText("Run");
   }

   public void uAttack() {
    position = "uAttack";
    int playerDamage = 0;
    if (attackWith.equals("Knife")) {
        playerDamage = new java.util.Random().nextInt(3);  //will pickup random number 0,1,2
    }
    if (attackWith.equals("Long Sword")) {
        playerDamage = new java.util.Random().nextInt(7);  //will pickup random number 0,1,2,3,4, 5, 6
    }
    mainTextArea.setText("You attacked the monster and gave " + playerDamage + " damage!");
    monsterHP = monsterHP - playerDamage;
    option1.setText(">"); 
   }

public void monsterAttack () {
    position = "monsterAttack";
    int monsterDamage = 0;
    monsterDamage = new java.util.Random().nextInt(5);
    mainTextArea.setText("The monster attacked you and gave " + monsterDamage + " damage! ");
    playerHP = playerHP - monsterDamage;
    hpLabelNumber.setText("" + playerHP);
    option1.setText(">");
    
}

public void lose() {
    position = "lose";
    mainTextArea.setText("You are dead.  \n \n Game over! ");
    option1.setText(">"); 
    option1.setText("Play again!");
    gate();
}

public void win() {
    position = "win";
    mainTextArea.setText("You defeated the monster! \n The monster dropped a ring. \n You have obtained a silver ring and restored your health.");
    silverRing = 1;
    option1.setText("Go back to the gate! ");
    playerHP = 16; //default ones
    monsterHP = 21;
}
   public class OptionsHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String urChoice = event.getActionCommand(); //if you click choice 1, c1 will be put into the urChoice string. 
            option2.setVisible(false);
            option3.setVisible(false);
            option4.setVisible(false);

            //writing results for each buttons.
            switch (position) {
                case "gate":
                switch(urChoice) {
                    case "c1": talkGuard(); break;
                    case "c2": attackGuard(); break;
                    case "c3": goSomewhereElse(); break;
                }
                break;
                case "talkGuard": 
                switch(urChoice) {
                    case "c1": gate(); break;
                }
                break;
                case "attackGuard":
                switch(urChoice) {
                    case "c1": gate(); break;
                }
                break;
                case "crossRoad": 
                switch(urChoice) {
                    case "c1":  goNorth(); break;
                    case "c2": goEast(); break;
                    case "c3": gate(); break;
                    case "c4": goWest(); break;
                }
                break;
                case "north":
                switch(urChoice) {
                    case "c1": goSomewhereElse(); break;
                }
                break;
                case "east":
                switch(urChoice) {
                    case "c1": goSomewhereElse(); break;
                }
                break;
                case "west":
                switch(urChoice) {
                    case "c1": fight(); break;
                    case "c2": goSomewhereElse(); break;
                }
                break;
                case "fight":
                switch (urChoice) {
                    case "c1": uAttack(); break;
                    case "c2": goSomewhereElse(); break;
                }
                break;
                case "uAttack":
                switch(urChoice) {
                    case "c1": 
                    if (monsterHP <1) {
                        win(); 
                    } 
                    else {
                        monsterAttack(); 
                    } 
                    break;
                }
                break;
                case "monsterAttack":
                switch(urChoice) {
                    case "c1": 
                    if (playerHP<1) {
                        lose();
                    }
                    else {
                        fight(); 
                    }break;
                }
                break;
                case "win": 
                    switch(urChoice) {
                        case "c1": goSomewhereElse(); break;
                    }
                    break;

            }
        }
        }


   public class StartButtonClicker implements ActionListener {
    public void actionPerformed(ActionEvent event) {
        createGameScreen();
    }
   }
}
