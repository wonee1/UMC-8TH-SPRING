package umc.study.service.store;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.QStore;
import umc.study.domain.Store;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreQueryServiceImpl implements StoreQueryService {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Store> findAllStores() {
        QStore store = QStore.store;

        return queryFactory
                .selectFrom(store)
                .fetch();
    }
    @Override
    public List<Store> findOpenStoresByRegionId(Long regionId) {
        QStore store = QStore.store;

        return queryFactory
                .selectFrom(store)
                .where(
                        store.region.id.eq(regionId),
                        store.isOpen.isTrue()
                )
                .fetch();
    }

    @Override
    public List<Store> findStoresByCategory(String category) {
        QStore store = QStore.store;

        return queryFactory
                .selectFrom(store)
                .where(
                        store.category.eq(category)
                )
                .fetch();
    }
}
