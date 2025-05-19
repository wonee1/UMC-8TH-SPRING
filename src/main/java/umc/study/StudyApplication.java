package umc.study;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import umc.study.domain.Store;
import umc.study.service.store.StoreQueryService;

import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class StudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {
			StoreQueryService storeService = context.getBean(StoreQueryService.class);

			System.out.println("✅ 전체 매장 조회");

			List<Store> stores = storeService.findAllStores();

			if (stores.isEmpty()) {
				System.out.println("❌ 등록된 매장이 없습니다.");
			} else {
				stores.forEach(System.out::println);
			}
		};
	}

}
