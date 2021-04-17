package com.empik.githubclient.control;

import com.empik.githubclient.entity.model.Usage;
import com.empik.githubclient.entity.repository.UsageRepository;
import org.springframework.stereotype.Service;

@Service
public class UsageService {
    private final UsageRepository usageRepository;

    public UsageService(UsageRepository usageRepository) {
        this.usageRepository = usageRepository;
    }

    public void incrementUsageForLogin(String login) {
        Usage usage = usageRepository.findUsageByLogin(login);
        if (usage == null) {
            usage = new Usage(login, 0);
        }

        usage.incrementRequestCount();
        usageRepository.save(usage);
    }
}