package com.simplecasino.walletservice;

import com.simplecasino.walletservice.dto.BalanceResponse;
import com.simplecasino.walletservice.dto.RegisterPlayerRequest;
import com.simplecasino.walletservice.dto.UpdateBalanceRequest;
import com.simplecasino.walletservice.model.Player;
import com.simplecasino.walletservice.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class WalletController {

    private WalletService walletService;

    @Autowired
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("/player")
    public BalanceResponse registerPlayer(@RequestBody RegisterPlayerRequest registerRequest) {
        Player player = walletService.registerPlayer(registerRequest.getPlayerId());

        return new BalanceResponse(player.getBalance().getAmount());
    }

    @PutMapping("/player/{id}/balance")
    public BalanceResponse updateBalance(@PathVariable Long id,
                                         @RequestBody UpdateBalanceRequest updateBalanceRequest) {
        Player player = walletService.updateBalance(id, updateBalanceRequest.getBalance());
        return new BalanceResponse(player.getBalance().getAmount());
    }

    @GetMapping("/player/{id}/balance")
    public BalanceResponse getBalance(@PathVariable Long id) {
        Player player = walletService.findById(id);
        return new BalanceResponse(player.getBalance().getAmount());
    }
}
