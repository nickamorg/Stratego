# Stratego
An alternative version of the classic 2D Board Stratego Game, '**Stratego Ice vs Fire**'. <br/>
It is implemented in Java using Swing and follows the MVC model.

#### Project Phases

**Phase 1** - UML Diagrams & Skeleton Implementation of Classes <br/>
**Phase 2** - Full Implementation & Final UML Diagrams <br/>
 <br/>

#### Game Setups

**Mix** - The pawns of the opponent are placed randomly <br/>
**Random** - The pawns of both players are placed randomly <br/>
**Set** - The two players should place their pawns <br/>
<br/>

#### Game Differences
In comparison with the classic Stratego, in this implementation some pawn has its own unique movement.

**Elf** - Movement Range 2 everywhere, even Diagonally <br/>
**Scout** - Movement Horizontally or Vertically as long as there are empty cells <br/>
**Knight/Beast Rider** - Horizontally & Vertically Range 2 and Diagonally range 1 <br/>
**Sorceress** - Movement Range 2 everywhere otherwise without moving in the same range it can witch opponent pawn with lower level than it and can't lose when attacks. <br/>
**Dragon** - Can pass through allied pawns or forbidden cells till find an empty one or opponent. <br/>
**Every pawn** - Once if it go to the opponent last line, the owner can recover one of its pawns everywhere on its side.
