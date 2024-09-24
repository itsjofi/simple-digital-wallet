package dev.itsjofi.simpledigitalwallet.repository;

import dev.itsjofi.simpledigitalwallet.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
