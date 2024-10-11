package dev.itsjofi.simpledigitalwallet.transfer.repository;

import dev.itsjofi.simpledigitalwallet.transfer.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {
    List<Transfer> findTransferBySenderId(Long senderId);
    List<Transfer> findTransferByReceiverId(Long receiverId);
    List<Transfer> findTransferBySenderIdAndReceiverId(Long senderId, Long receiverId);
}
