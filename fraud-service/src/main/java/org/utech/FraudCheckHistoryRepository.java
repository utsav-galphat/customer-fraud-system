package org.utech;

import org.springframework.data.jpa.repository.JpaRepository;
import org.utech.entity.FraudCheckHistory;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Integer> {
}
