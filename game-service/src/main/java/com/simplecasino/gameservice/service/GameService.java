package com.simplecasino.gameservice.service;

import com.simplecasino.gameservice.dto.BalanceResponse;
import com.simplecasino.gameservice.dto.BetResponse;
import com.simplecasino.gameservice.dto.PlaceBetRequest;
import com.simplecasino.gameservice.exception.GameServiceException;
import com.simplecasino.gameservice.model.Game;

import java.util.List;

public interface GameService {

    /**
     * Saves the new game and return it
     *
     * @param game - the game to be saved
     * @return the same game, successfully saved to the db
     * @throws GameServiceException in case if the given game already exist
     */
    Game saveGame(Game game);

    /**
     * Finds all bets made by the player with the given {@code playerId}
     *
     * @param playerId - the id of the player to find his bets
     * @return the bets of the player in each game or an empty list if there are
     * no any bets made by the player
     */
    List<BetResponse> getPlayerBets(Long playerId);

    /**
     * Place a bet {@link PlaceBetRequest#amount} for the player with {@link PlaceBetRequest#playerId}
     * in the game with id {@code gameId}
     *
     * @param gameId          the id of the game in which the player place a bet
     * @param placeBetRequest the request to place the bet
     * @return the new player's balance after placing a bet
     * @throws GameServiceException in case if the game with the given id wasn't found
     */
    BalanceResponse placeBet(Long gameId, PlaceBetRequest placeBetRequest);
}
