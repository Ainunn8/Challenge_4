package com.example.Challenge_4.controller;

import com.example.Challenge_4.model.Product;
import com.example.Challenge_4.model.Users;
import com.example.Challenge_4.repository.UserRepository;
import com.example.Challenge_4.service.ProductService;
import com.example.Challenge_4.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

@Slf4j
@Component
@Service
public class BinarfudController {

    private Scanner scanner = new Scanner(System.in);

    @Autowired
    public ProductService productService;
    public UserService userService;
    private UserRepository userRepository;

    public void separator() {
        System.out.println("===============================================");
    }

    public void mainMenu() throws ParseException {
        System.out.println("Welcome to Binar FUD!!\n" +
                "Kamilah Siap Menjadi Pemadam Kelaparanmu\n" +
                "Silahkan pilih menu\n" +
                "1. Lihat daftar menu\n" +
                "2. Tambahkan menu\n" +
                "3. Lihat semua menu terbaru\n" +
                "4. Hapus menu\n" +
                "-----User------\n" +
                "5. Tambah User\n" +
                "6. Update user\n" +
                "7. Hapus User\n" +
                "0. Keluar");
        System.out.print("=> ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();
        switch(pilihan) {
            case 1:
                this.showMenu();
                break;
            case 2:
                this.addNewProduct();
                break;
            case 3:
                this.getAllProduct();
                break;
            case 4:
                this.deleteProduct();
                break;
            case 5:
                this.addNewUser();
                break;
            case 6:
                this.deleteUser();
                break;
            case 7:
                this.updateUser();
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Silahkan pilih kembali\n!!!!!!!!!!!");
                this.mainMenu();
        }
    }

    public void showMenu () throws ParseException {
        separator();
        System.out.println("Daftar Menu:");
        System.out.println("1. Nasi Goreng \t | Rp. 15,000");
        System.out.println("2. Mie Ayam \t | Rp. 13,000");
        System.out.println("3. Nasi + Ayam \t | Rp. 18,000");
        System.out.println("4. Es Teh Manis \t | Rp. 5,000");
        System.out.println("5. Es Jeruk \t | Rp. 5,000");
        System.out.println("Silahkan pilih makanan:");
        System.out.println("99. Pesan dan Bayar");
        System.out.println("0. Keluar Aplikasi");
        separator();
        System.out.print("=> ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        switch (pilihan) {
            case 1:
                System.out.println("Anda memilih Nasi Goreng | Rp. 15,000");
                // Implementasi logika untuk memproses pesanan Nasi Goreng
                break;
            case 2:
                System.out.println("Anda memilih Mie Ayam | Rp. 13,000");
                // Implementasi logika untuk memproses pesanan Mie Ayam
                break;
            case 3:
                System.out.println("Anda memilih Nasi + Ayam | Rp. 18,000");
                // Implementasi logika untuk memproses pesanan Nasi + Ayam
                break;
            case 4:
                System.out.println("Anda memilih Es Teh Manis | Rp. 5,000");
                // Implementasi logika untuk memproses pesanan Es Teh Manis
                break;
            case 5:
                System.out.println("Anda memilih Es Jeruk | Rp. 5,000");
                // Implementasi logika untuk memproses pesanan Es Jeruk
                break;
            case 99:
                System.out.println("Anda memilih Pesan dan Bayar");
                // Implementasi logika untuk pesan dan bayar
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Pilihan tidak valid. Silahkan pilih kembali.");
                showMenu();
        }
    }
    public void addNewProduct () throws ParseException {
        System.out.println("Nama Menu : ");
        String productName = scanner.nextLine();
        System.out.println("Harga : ");
        double productPrice = scanner.nextDouble();

        Product newProduct = Product.builder()
                .name(productName)
                .price(productPrice)
                .build();
        productService.addNewProduct(newProduct);
        System.out.println("\n Menu baru berhasil di tambah!");
        this.mainMenu();

    }
    public void addNewUser () throws ParseException {
        System.out.println("Masukkan nama anda : ");
        String username = scanner.nextLine();
        System.out.println("Masukkan email address anda : ");
        String email = scanner.nextLine();
        System.out.println("Masukkan password anda : ");
        String password = scanner.nextLine();


        Users newUser = Users.builder()
                .username(username)
                .email(email)
                .password(password)
                .build();
        userService.addUsers(newUser);
        System.out.println("\n Menu baru berhasil di tambah!");
        this.mainMenu();
    }
    public void updateUser (String userId, String newUsername, String newEmail, String newPassword) throws ParseException {
        Users user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            // Perbarui nilai-nilai yang diperlukan
            if (newUsername != null) {
                user.setUsername(newUsername);
            }

            if (newEmail != null) {
                user.setEmail(newEmail);
            }

            if (newPassword != null) {
                user.setPassword(newPassword);
            }

            // Simpan perubahan ke dalam basis data
            userRepository.save(user);
        }
        mainMenu();

    }

    public void getAllProduct () throws ParseException {
        List<Product> products = productService.getAllProducts();

        if (products.isEmpty()) {
            System.out.println("Tidak ada produk yang tersedia.");
        } else {
            System.out.println("Daftar Produk:");
            for (Product product : products) {
                System.out.println(product.getName() + " | Rp. " + product.getPrice());
            }
        }
        // Kembali ke menu utama
        mainMenu();

    }

    public void deleteProduct () throws ParseException {
        System.out.print("Masukkan kode produk yang ingin dihapus: ");
        String productCode = scanner.nextLine();

        productService.deleteProduct(productCode);

        // Kembali ke menu utama
        mainMenu();

    }
    public void deleteUser () throws ParseException {
        System.out.print("Masukkan ID pengguna yang ingin dihapus: ");
        String userId = scanner.nextLine();

        userService.deleteUsers(userId);

        // Kembali ke menu utama
        mainMenu();
    }

}
