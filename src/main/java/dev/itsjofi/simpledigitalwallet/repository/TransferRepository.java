package dev.itsjofi.simpledigitalwallet.repository;

import dev.itsjofi.simpledigitalwallet.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {
}
