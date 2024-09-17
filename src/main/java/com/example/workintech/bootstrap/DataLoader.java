package com.example.workintech.bootstrap;

import com.example.workintech.entity.Category;
import com.example.workintech.entity.Product;
import com.example.workintech.entity.User;
import com.example.workintech.repository.CategoryRepository;
import com.example.workintech.repository.ProductRepository;
import com.example.workintech.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static com.example.workintech.entity.Role.ADMIN;
import static com.example.workintech.entity.Role.CUSTOMER;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataLoader(UserRepository userRepository, ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Örnek Kategoriler
        Category category1 = new Category(null, "Elektronik", null);
        Category category2 = new Category(null, "Ev Eşyaları", null);
        Category category3 = new Category(null, "Müzik Aletleri", null);
        Category category4 = new Category(null, "Spor", null);
        Category category5 = new Category(null, "Giyim", null);
        Category category6 = new Category(null, "Kozmetik", null);

        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);
        categoryRepository.save(category4);
        categoryRepository.save(category5);
        categoryRepository.save(category6);

        // Örnek Kullanıcılar
        User user1 = new User(null, "user1@example.com", "User One", "hashedpassword1", CUSTOMER);
        User user2 = new User(null, "user2@example.com", "User Two", "hashedpassword2", CUSTOMER);
        User admin = new User(null, "admin@example.com", "Admin User", "hashedpassword3", ADMIN);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(admin);

        // Örnek Ürünler (Her kategori için 5 ürün)
        // Elektronik
        Product product1 = new Product(null, "Laptop", "High-performance laptop", 1500.00, 10, category1, true, 0, 100);
        Product product2 = new Product(null, "Akıllı Telefon", "Son model akıllı telefon", 1000.00, 15, category1, false, 0, 200);
        Product product3 = new Product(null, "Tablet", "Taşınabilir tablet", 600.00, 8, category1, true, 0, 80);
        Product product4 = new Product(null, "Kulaklık", "Kablosuz kulaklık", 150.00, 20, category1, false, 0, 50);
        Product product5 = new Product(null, "Akıllı Saat", "Fitness takibi için akıllı saat", 300.00, 5, category1, true, 0, 90);

        // Ev Eşyaları
        Product product6 = new Product(null, "Blender", "Çok amaçlı mutfak blenderı", 100.00, 20, category2, true, 0, 50);
        Product product7 = new Product(null, "Çay Makinesi", "Elektrikli çay makinesi", 80.00, 12, category2, false, 0, 75);
        Product product8 = new Product(null, "Buzdolabı", "Çift kapılı buzdolabı", 2000.00, 3, category2, true, 0, 120);
        Product product9 = new Product(null, "Mikrodalga Fırın", "Kompakt mikrodalga fırın", 300.00, 7, category2, false, 0, 40);
        Product product10 = new Product(null, "Süpürge", "Elektrikli süpürge", 400.00, 9, category2, true, 0, 60);

        // Müzik Aletleri
        Product product11 = new Product(null, "Akustik Gitar", "Profesyonel akustik gitar", 300.00, 8, category3, false, 0, 120);
        Product product12 = new Product(null, "Piyano", "Dijital piyano", 500.00, 5, category3, true, 0, 90);
        Product product13 = new Product(null, "Davul Seti", "Çocuklar için davul seti", 150.00, 6, category3, false, 0, 30);
        Product product14 = new Product(null, "Keman", "Başlangıç seviyesi keman", 200.00, 10, category3, true, 0, 45);
        Product product15 = new Product(null, "Flüt", "Ahşap flüt", 50.00, 15, category3, false, 0, 20);

        // Spor
        Product product16 = new Product(null, "Koşu Bandı", "Ev tipi koşu bandı", 700.00, 3, category4, true, 0, 60);
        Product product17 = new Product(null, "Yoga Matı", "Kaymaz yoga matı", 20.00, 25, category4, false, 0, 40);
        Product product18 = new Product(null, "Dambıl Seti", "Ağırlık antrenmanı için dambıl seti", 100.00, 15, category4, true, 0, 55);
        Product product19 = new Product(null, "Basketbol Topu", "Profesyonel basketbol topu", 50.00, 20, category4, false, 0, 70);
        Product product20 = new Product(null, "Tenis Raketi", "Grafit tenis raketi", 120.00, 10, category4, true, 0, 80);

        // Giyim
        Product product21 = new Product(null, "T-shirt", "Pamuklu T-shirt", 10.00, 50, category5, true, 0, 30);
        Product product22 = new Product(null, "Kot Pantolon", "Denim kot pantolon", 30.00, 40, category5, false, 0, 10);
        Product product23 = new Product(null, "Mont", "Su geçirmez mont", 120.00, 5, category5, true, 0, 100);
        Product product24 = new Product(null, "Şapka", "Yazlık şapka", 15.00, 30, category5, false, 0, 25);
        Product product25 = new Product(null, "Spor Ayakkabı", "Koşu için spor ayakkabı", 90.00, 20, category5, true, 0, 85);

        // Kozmetik
        Product product26 = new Product(null, "Parfüm", "Kalıcı parfüm", 70.00, 10, category6, true, 0, 110);
        Product product27 = new Product(null, "Nemlendirici", "Cilt nemlendirici krem", 25.00, 18, category6, false, 0, 80);
        Product product28 = new Product(null, "Şampuan", "Doğal içerikli şampuan", 15.00, 40, category6, true, 0, 20);
        Product product29 = new Product(null, "Yüz Maskesi", "Hızlı etkili yüz maskesi", 5.00, 30, category6, false, 0, 50);
        Product product30 = new Product(null, "Göz Kremi", "Anti-aging göz kremi", 35.00, 12, category6, true, 0, 95);

        // Ürünleri Kaydetme
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
        productRepository.save(product5);
        productRepository.save(product6);
        productRepository.save(product7);
        productRepository.save(product8);
        productRepository.save(product9);
        productRepository.save(product10);
        productRepository.save(product11);
        productRepository.save(product12);
        productRepository.save(product13);
        productRepository.save(product14);
        productRepository.save(product15);
        productRepository.save(product16);
        productRepository.save(product17);
        productRepository.save(product18);
        productRepository.save(product19);
        productRepository.save(product20);
        productRepository.save(product21);
        productRepository.save(product22);
        productRepository.save(product23);
        productRepository.save(product24);
        productRepository.save(product25);
        productRepository.save(product26);
        productRepository.save(product27);
        productRepository.save(product28);
        productRepository.save(product29);
        productRepository.save(product30);
    }
}
