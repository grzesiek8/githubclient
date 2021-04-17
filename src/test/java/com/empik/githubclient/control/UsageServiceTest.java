package com.empik.githubclient.control;

import com.empik.githubclient.entity.model.Usage;
import com.empik.githubclient.entity.repository.UsageRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
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
        when(usageRepository.findUsageByLogin(anyString())).thenReturn(null);
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