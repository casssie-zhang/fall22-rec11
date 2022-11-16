package edu.cmu.cs.cs214.rec10.plugin;

import edu.cmu.cs.cs214.rec10.framework.core.GameFramework;
import edu.cmu.cs.cs214.rec10.framework.core.GamePlugin;
import edu.cmu.cs.cs214.rec10.games.TicTacToe;

public class TicTacToePlugin implements GamePlugin<TicTacToe.Player> {
    private GameFramework framework;
    private TicTacToe game;

    @Override
    public String getGameName() {
        return "Tic Tac Toe";
    }

    @Override
    public int getGridWidth() {
        return TicTacToe.SIZE;
    }

    @Override
    public int getGridHeight() {
        return TicTacToe.SIZE;
    }

    @Override
    public void onRegister(GameFramework framework) {
        this.framework = framework;
    }

    @Override
    public void onNewGame() {
        framework.setFooterText("Let's play Tic Tac Toe"); 
        game = new TicTacToe();

    }

    @Override
    public void onNewMove() {
        // do nothing        
    }

    @Override
    public boolean isMoveValid(int x, int y) {
        return game.isValidPlay(x, y);
    }

    @Override
    public boolean isMoveOver() {
        return true;
    }

    @Override
    public void onMovePlayed(int x, int y) {
        // mark the grid to X or O
        framework.setSquare(x, y, game.currentPlayer().toString());
        game.play(x, y);
    }

    @Override
    public boolean isGameOver() {
        return game.isOver();
    }

    @Override
    public String getGameOverMessage() {
        TicTacToe.Player winner = game.winner();
        return winner.toString() + " won";
    }

    @Override
    public void onGameClosed() {
        // do nothing
    }

    @Override
    public TicTacToe.Player currentPlayer() {
        return game.currentPlayer();
    }
    
}
