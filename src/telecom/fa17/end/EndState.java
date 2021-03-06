package telecom.fa17.end;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import telecom.fa17.game.MapGameState;

public class EndState extends BasicGameState {

	private StateBasedGame game;
    private GameContainer container;
	public static boolean victory = true;
    public static final int ID = 2;
	
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		this.container = container;
		this.game = game;
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		
		if(victory){
			displayText(g, "YOU WIN !", 285, 64);
			displayText(g, "YOU'RE REALLY DAMN GOOD !", 220, 100);
			g.drawImage(new Image("/resources/end/victory.png"), 225, 140);
			displayText(g, "PRESS [ESC] TO END THE GAME", 200, 400);
		} else {
			displayText(g, "DAMN ! YOU'RE DEAD !", 240, 64);
			displayText(g, "TRY AGAIN IF YOU HAVE THE BALLS !", 170, 100);
			g.drawImage(new Image("/resources/end/dead.png"), 190, 145);
			displayText(g, "PRESS [ESC] FOR LOOSERS", 216, 400);
		}
		
		/*
		 * AFFICHAGE DU TEXTE DE FIN
		 */
		displayText(g, "PRESS [ENTER] TO REPLAY", 215, 364);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		return ID;
	}
	
	@Override
	public void keyPressed(int key, char c) {
		
		// Touche ESC on termine le programme
		if (key == Input.KEY_ESCAPE) {
			container.exit();
        }
		
		// Touche ENTER on rejoue depuis le début
		if (key == Input.KEY_ENTER) {
				try {
					MapGameState.razGame();
				} catch (SlickException e) {}
				game.enterState(MapGameState.ID);
		}
	}
	
	/**
     * Affichage de texte sur la fenêtre du jeu.
     *
     * @param g - Contexte Graphique.
     * @param text - Texte à afficher.
     * @param absOrigin - Coordonnée Horizontale en haut à gauche de la première lettre du texte.
     * @param ordOrigin - Coordonnée Verticale en haut à gauche de la première lettre du texte.
     */
	public void displayText(Graphics g, String text, float absOrigin, float ordOrigin){
		g.setColor(new Color(255, 255, 255));
		g.drawString(text, absOrigin, ordOrigin);
	}

}
