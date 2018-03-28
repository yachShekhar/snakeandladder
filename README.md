# snakeandladder
This is a console application for snake and ladder.
You can make it intresting with below additions.

Snakes, Ladders and More
An enhanced version of Snakes and Ladders. The game in addition to snakes
and ladders will have Trampolines, Springs and Pit stops.
The rules of the game are as below.
A board will have n squares. Each square is numbered, all the players will start on square 1, and
the objective is to reach square n.
Each player throws a dice, the value of the die will be between 1 and 6, this value is added to
the number of the present square, to determine the next hop. The next hop can be a square
which has at most one of snake, ladder, trampoline, spring or pitstop. The expected behavior in
case of snakes and ladder is as per the well known game. In case of trampoline, player is
required to go forward ‘m’ steps, where m is the value of the dice throw. In case of the spring
the player has go backward ‘m’ steps. In case of both springs and trampolines, the rules of the
landing square have to be followed(the landing square can have one of snake, ladder,
trampoline, spring or pitstop)
The players consume one unit of energy per dice throw. Pitstops provide them more energy.
The numbers of units of energy provided is a property of the pitstop. Square one will be a
pitstop with n/3 units of energy. If a players’ energy reaches zero during the game, they need to
return to the square 1. Note that consumption is only for throw of dices, and not for the
change of positions through snakes, ladders etc. Note that the recharges are for each visit to
pitstop.
The sequence of dice throws is presented as inputs, for each of these, the state of the program
has to be determined and output, which should include, the location of the players, their
energy levels and if the game has ended, the winner.
