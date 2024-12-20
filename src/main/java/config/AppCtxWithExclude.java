package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import spring.MemberDao;
import spring.MemberPrinter;

@Configuration
@ComponentScan(basePackages = {"spring"},
        excludeFilters = @ComponentScan.Filter(type = FilterType.ASPECTJ,pattern = "spring.*Dao"))
public class AppCtxWithExclude {

    @Bean
    public MemberDao memberDao(){
        return new MemberDao() ;
    }

    @Bean
    @Qualifier("Printer")
    public MemberPrinter memberPrinter1() {
        return new MemberPrinter();
    }
}


