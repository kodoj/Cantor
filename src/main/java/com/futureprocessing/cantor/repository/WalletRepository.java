package com.futureprocessing.cantor.repository;

import com.futureprocessing.cantor.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {

    Wallet save(Wallet wallet);
}
