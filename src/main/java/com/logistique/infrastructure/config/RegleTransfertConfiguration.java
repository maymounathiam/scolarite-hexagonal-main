package com.logistique.infrastructure.config;

import com.logistique.domain.policy.inscription.RegleTransfert;
import com.logistique.domain.policy.inscription.RegleTransfertSousDelai;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegleTransfertConfiguration {

    @Bean
    public RegleTransfert regleTransfert(
            @Value("${logistique.transfert.delai-max-mois}")
            int delaiMaxMois
    ) {
        return new RegleTransfertSousDelai(delaiMaxMois);
    }
}

