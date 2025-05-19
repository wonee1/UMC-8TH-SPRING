package umc.study.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.QStore;
import umc.study.domain.Store;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StoreRepositoryImpl implements StoreRepositoryCustom {

    private final JPAQueryFactory queryFactory;

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
}
