package com.empik.githubclient.entity.repository;

import com.empik.githubclient.entity.model.Usage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsageRepository extends JpaRepository<Usage, String> {
    Usage findUsageByLogin(String login);
}