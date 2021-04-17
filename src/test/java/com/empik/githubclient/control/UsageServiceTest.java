package com.empik.githubclient.control;

import com.empik.githubclient.entity.model.Usage;
import com.empik.githubclient.entity.repository.UsageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.eq;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UsageServiceTest {
    @MockBean
    private UsageRepository usageRepository;

    @Test
    void addNewUsage() {
        //given
        String login = "newLogin";
        Usage addedUsage = new Usage(login, 1);
        UsageService usageService = new UsageService(usageRepository);

        //when
        when(usageRepository.findUsageByLogin(login)).thenReturn(null);
        when(usageRepository.save(any())).thenReturn(addedUsage);

        //then
        Usage usage = usageService.incrementUsageForLogin("newLogin");
        assertEquals(usage.getLogin(), "newLogin");
        assertEquals(usage.getRequestCount(), 1);

    }

    @Test
    void incrementUsage() {
        //given
        String login = "existingLogin";
        Usage nonIncrementedUsage = new Usage(login, 4);
        Usage incrementedUsage = new Usage(login, 5);
        UsageService usageService = new UsageService(usageRepository);

        //when
        when(usageRepository.findUsageByLogin(login)).thenReturn(nonIncrementedUsage);
        when(usageRepository.save(any())).thenReturn(incrementedUsage);

        //then
        Usage usage = usageService.incrementUsageForLogin("existingLogin");
        assertEquals(usage.getLogin(), "existingLogin");
        assertEquals(usage.getRequestCount(), 5);
    }

}