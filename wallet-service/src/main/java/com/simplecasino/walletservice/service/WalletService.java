package com.simplecasino.walletservice.service;

import com.simplecasino.walletservice.exception.InsufficientBalanceException;
import com.simplecasino.walletservice.exception.WalletServiceException;
import com.simplecasino.walletservice.model.Player;

import java.math.BigDecimal;

public interface WalletService {

    /**
     * Registers the player with the given {@code playerId}
     *
     * @param playerId the id of the new player
     * @return the registered player
     * @throws WalletServiceException in case if the player with the given id is already registered
     */
    Player registerPlayer(Long playerId);

    /**
     * Updates a balance for the player with the given {@code playerId}
     *
     * @param playerId the id of the new player
     * @param amount   the amount to be added to the current player balance.
     *                 Could be both positive and negative
     * @return the player with updated balance
     * @throws WalletServiceException       in case if the player wasn't found
     * @throws InsufficientBalanceException in case if the player doesn't have enough money to proceed updating
     */
    Player updateBalance(Long playerId, BigDecimal amount);

    /**
     * Finds player by the given {@code id}
     *
     * @param id - the id of the player to find
     * @return the found player
     * @throws WalletServiceException in case if the player wasn't found
     */
    Player findById(Long id);
}