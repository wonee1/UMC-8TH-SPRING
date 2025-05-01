package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 30)
    private String category;

    @Column(nullable = false)
    private Boolean isOpen;

    @Column(nullable = false, length = 100)
    private String address;

    private Double latitude;

    private Double longitude;

    @Column(name = "avg_rating", columnDefinition = "FLOAT DEFAULT 0")
    private Float avgRating;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToMany(mappedBy = "store")
    private List<Mission> missions;

    @OneToMany(mappedBy = "store")
    private List<Review> reviews;
}
