package P09_kitapYonetimi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static P09_kitapYonetimi.Kitapcı_Methods.menu;

public class Kitapci_KitapEkle {
    public static Scanner scan = new Scanner(System.in);
    public static List<Kitapci_KitapEkle> kitapList = new ArrayList<>();
    protected int kitapNo = 1000;
    protected String kitapAdi;
    protected String yazarAdi;
    protected String kitapFiyat;

    public Kitapci_KitapEkle() {
    }

    public Kitapci_KitapEkle(int kitapNo, String kitapAdi, String yazarAdi, String kitapFiyat) {
        this.kitapNo = kitapNo;
        this.kitapAdi = kitapAdi;
        this.yazarAdi = yazarAdi;
        this.kitapFiyat = kitapFiyat;
    }

    public List<Kitapci_KitapEkle> kitapEkle() {
        System.out.print("Kitap adi giriniz: ");
        String kitapAdi = scan.nextLine();
        scan.nextLine();
        System.out.print("Yazar adi giriniz :");
        String yazarAdi = scan.nextLine();


        System.out.print("Kitabin fiyatini giriniz:");

        String fiyat = scan.nextLine();
        Kitapci_KitapEkle kitap = new Kitapci_KitapEkle(this.kitapNo, kitapAdi, yazarAdi, fiyat);
        this.kitapNo++;
        kitapList.add(kitap);


        System.out.println("Kitap eklendi. Ana menu icin 1, yeni kitap eklemek 2 ");
        int secim = 0;
        try {
            secim = scan.nextInt();

        } catch (Exception e) {
            String hataliSecim = scan.nextLine();
            System.out.println("Hatali secim lutfen tekrar deneyiniz");
            kitapEkle();
        }
        if (secim == 1) {
            menu();
        } else {
            scan.nextLine();
            kitapEkle();
        }

        return kitapList;

    }


}
