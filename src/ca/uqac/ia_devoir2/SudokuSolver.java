package ca.uqac.ia_devoir2;

import ca.uqac.ia_devoir2.controllers.StartController;
import ca.uqac.ia_devoir2.controllers.TextTileController;
import ca.uqac.ia_devoir2.explorations.BruteForceExploration;
import ca.uqac.ia_devoir2.explorations.DepthExploration;
import ca.uqac.ia_devoir2.model.Position;
import ca.uqac.ia_devoir2.model.SudokuGrid;
import ca.uqac.ia_devoir2.view.MainFrame;
import ca.uqac.ia_devoir2.view.TextTile;

import javax.swing.*;

/**
 * Created by dhawo on 24/10/2016.
 */
public class SudokuSolver {

    private StartController startController;
    private TextTileController textTileController;
    private SudokuGrid example;
    private DepthExploration depthExploration;
    private BruteForceExploration bruteForceExploration;

    public static void main(String[] args) {
        /*Example Grid*/
        SudokuSolver main = new SudokuSolver();
        main.example = new SudokuGrid();

        main.depthExploration = new DepthExploration(main.example);
        main.bruteForceExploration= new BruteForceExploration(main.example);

        main.initControllers();
        main.initView();

        main.example.setTileValue(2, new Position(0, 0));
        main.example.setTileValue(3, new Position(1, 0));
        main.example.setTileValue(8, new Position(2, 0));
        main.example.setTileValue(6, new Position(4, 0));
        main.example.setTileValue(4, new Position(5, 0));
        main.example.setTileValue(1, new Position(8, 0));
        main.example.setTileValue(9, new Position(5, 1));
        main.example.setTileValue(5, new Position(7, 1));
        main.example.setTileValue(8, new Position(8, 1));
        main.example.setTileValue(5, new Position(0, 2));
        main.example.setTileValue(7, new Position(1, 2));
        main.example.setTileValue(3, new Position(7, 2));
        main.example.setTileValue(2, new Position(4, 3));
        main.example.setTileValue(7, new Position(5, 3));
        main.example.setTileValue(1, new Position(6, 3));
        main.example.setTileValue(6, new Position(7, 3));
        main.example.setTileValue(7, new Position(0, 4));
        main.example.setTileValue(6, new Position(3, 4));
        main.example.setTileValue(8, new Position(5, 4));
        main.example.setTileValue(5, new Position(8, 4));
        main.example.setTileValue(2, new Position(1, 5));
        main.example.setTileValue(6, new Position(2, 5));
        main.example.setTileValue(1, new Position(3, 5));
        main.example.setTileValue(5, new Position(4, 5));
        main.example.setTileValue(1, new Position(1, 6));
        main.example.setTileValue(7, new Position(7, 6));
        main.example.setTileValue(3, new Position(8, 6));
        main.example.setTileValue(9, new Position(0, 7));
        main.example.setTileValue(4, new Position(1, 7));
        main.example.setTileValue(8, new Position(3, 7));
        main.example.setTileValue(8, new Position(0, 8));
        main.example.setTileValue(3, new Position(3, 8));
        main.example.setTileValue(1, new Position(4, 8));
        main.example.setTileValue(6, new Position(6, 8));
        main.example.setTileValue(4, new Position(7, 8));
        main.example.setTileValue(9, new Position(8, 8));
        /****************************************/

        System.out.println(main.example);

    }

    private void initView() {
        MainFrame mf = new MainFrame();
        TextTile[][] tiles = mf.getSudokuBoard().getFields();
        for (int i = 0; i < tiles.length; i++)
            for (int j = 0; j < tiles[i].length; j++) {
                example.getTile(i, j).addObserver(tiles[i][j]);
                bruteForceExploration.addObserver(tiles[i][j]);
                depthExploration.addObserver(tiles[i][j]);
                tiles[i][j].addFocusListener(textTileController);
            }
        mf.getControlPanel().getStartDepthButton().addMouseListener(startController);
        mf.getControlPanel().getResetButton().addMouseListener(startController);
        mf.getControlPanel().getStartBruteForceButton().addMouseListener(startController);
    }

    private void initControllers() {
        startController = new StartController(example, depthExploration, bruteForceExploration);
        textTileController = new TextTileController(example);
    }


}
