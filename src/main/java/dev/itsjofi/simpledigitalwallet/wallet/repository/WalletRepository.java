package dev.itsjofi.simpledigitalwallet.wallet.repository;

import dev.itsjofi.simpledigitalwallet.wallet.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
