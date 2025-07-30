package Store404.backend.Entity.Product;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "original_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal originalPrice;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "discount_rate")
    private Integer discountRate;

    @Column(name = "stock_quantity", nullable = false)
    private Integer stockQuantity;

    @Column(name = "image_url")
    private String imageUrl;

    // 인기상품 플래그
    @Column(name = "is_featured", nullable = false)
    @Builder.Default
    private Boolean isFeatured = false;

    // 신상품 플래그
    @Column(name = "is_new", nullable = false)
    @Builder.Default
    private Boolean isNew = false;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // TODO: 카테고리 관계
    // TODO: 장바구니 관계
    // TODO: 주문 상품 관계

    // 재고 확인
    public boolean isInStock(int quantity) {
        return stockQuantity >= quantity;
    }

    // 재고 감소
    public void decreaseStock(int quantity) {
        if (!isInStock(quantity)) {
            throw new IllegalArgumentException("재고가 부족합니다.");
        }
        this.stockQuantity -= quantity;
    }

    // 재고 증가
    public void increaseStock(int quantity) {
        this.stockQuantity += quantity;
    }
}
