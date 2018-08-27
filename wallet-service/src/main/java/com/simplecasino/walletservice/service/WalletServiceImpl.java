package com.simplecasino.walletservice.service;

import com.simplecasino.walletservice.dao.WalletDao;
import com.simplecasino.walletservice.exception.InsufficientBalanceException;
import com.simplecasino.walletservice.exception.WalletServiceException;
import com.simplecasino.walletservice.model.Balance;
import com.simplecasino.walletservice.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class WalletServiceImpl implements WalletService {

    private WalletDao walletDao;

    @Autowired
    public WalletServiceImpl(WalletDao walletDao) {
        this.walletDao = walletDao;
    }

    @Transactional
    @Override
    public Player registerPlayer(Long playerId) {
        throwExceptionIfPlayerExists(playerId);

        Player player = new Player(playerId, new Balance());
        return walletDao.save(player);
    }

    private void throwExceptionIfPlayerExists(Long playerId) {
        if (walletDao.existsById(playerId)) {
            throw new WalletServiceException(WalletServiceException.Type.PLAYER_ALREADY_EXIST);
        }
    }

    @Transactional
    @Override
    public Player updateBalance(Long playerId, BigDecimal amount) {
        Player player = walletDao.findById(playerId)
                .orElseThrow(() -> new WalletServiceException(WalletServiceException.Type.PLAYER_NOT_FOUND));

        BigDecimal currentBalance = player.getBalance().getAmount();
        BigDecimal newBalance = currentBalance.add(amount);

        throwExceptionIfBalanceNegative(currentBalance, newBalance);

        player.setBalance(new Balance(currentBalance.add(amount)));

        return player;
    }

    private void throwExceptionIfBalanceNegative(BigDecimal currentBalance, BigDecimal newBalance) {
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new InsufficientBalanceException(WalletServiceException.Type.INSUFFICIENT_BALANCE, currentBalance);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Player findById(Long id) {
        return walletDao.findById(id)
                .orElseThrow(() -> new WalletServiceException(WalletServiceException.Type.PLAYER_NOT_FOUND));
    }
}
