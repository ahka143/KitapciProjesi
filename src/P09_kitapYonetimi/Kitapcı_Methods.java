package P09_kitapYonetimi;

import java.util.List;
import java.util.Scanner;

public class Kitapcı_Methods extends Kitapci_KitapEkle {

    public static Scanner scan = new Scanner(System.in);


    public static void noIleKitapGoruntule(List<Kitapci_KitapEkle> kitapList) {
        System.out.print("Kitap no giriniz: ");
        int girilenKitapNo = scan.nextInt();
        for (Kitapci_KitapEkle each : kitapList
        ) {
            if (girilenKitapNo == each.kitapNo) {
                System.out.println("Kitap no: " + each.kitapNo + "\nKitap adi: " + each.kitapAdi + "\nYazar adi: " + each.yazarAdi + "\nFiyati: " + each.kitapFiyat);
            } else {
                System.out.println(girilenKitapNo + " no'lu kitap bulunamadi. Tekrar deneyiniz. ");
                menu();
            }

        }

    }

    public static void bilgiIleKitapGoruntule(List<Kitapci_KitapEkle> kitapList) {
        System.out.println("Lutfen kitap adi veya yazarini giriniz:");
        String kitapBilgi = scan.nextLine();

        for (Kitapci_KitapEkle each : Kitapci_KitapEkle.kitapList
        ) {
            if (each.kitapAdi.equalsIgnoreCase(kitapBilgi) || each.yazarAdi.equalsIgnoreCase(kitapBilgi)) {
                System.out.println("Kitap no: " + each.kitapNo + "\nKitap adi: " + each.kitapAdi + "\nYazar adi: " + each.yazarAdi + "\nFiyati: " + each.kitapFiyat);
            } else {
                System.out.println("Girdiginiz bilgilere uygun kitap bulunamadi. Tekrar deneyiniz. ");
                menu();
            }
        }


    }

    public static void noIleKitapSil(List<Kitapci_KitapEkle> kitapList) {
       Kitapci_KitapEkle yeniKitap= new Kitapci_KitapEkle();
        System.out.println("Kitap no giriniz:");
        int ktpno=scan.nextInt();
        for (int i = 0; i <kitapList.size() ; i++) {
            if (ktpno==yeniKitap.kitapNo){
                kitapList.remove(i);
            }else{
                System.out.println("hatali kitap numarasi. tekrar deneyiniz.");
                noIleKitapSil(kitapList);
            }
        }


    }

    public static void tumKitaplariListele(List<Kitapci_KitapEkle> kitapList) {
        scan.nextLine();
        for (Kitapci_KitapEkle each : kitapList
        ) {
            System.out.println(each.kitapNo + " : " + each.kitapAdi + " Yazari: " + each.yazarAdi + " - Fiyati : " + each.kitapFiyat);
        }
    }

    public static void cikis() {
        System.out.println("Programimizi kullaniginiz icin tesekkurler. Iyi gunler");

    }

    public static void menu() {
       Kitapci_KitapEkle yeniKitap = new Kitapci_KitapEkle();
        System.out.println("******* KITAPCI OTOMASYONUNA HOS GELDINIZ *******");
        System.out.println("Lutfen yapmak istediginiz islemi seciniz: \n1- Kitap ekle\n2- Kitap no ile kitap goruntule\n" +
                "3- Bilgi ile kitap goruntule\n4- Kitap no ile kitap sil\n5- Tum kitaplari listele\n6- Cikis ");
        int secim = 0;
        try {
            secim = scan.nextInt();
        } catch (Exception e) {
            String hataliSecim = scan.nextLine();
            System.out.println("Hatali secim lutfen tekrar deneyiniz ");
            menu();
        }

        switch (secim) {
            case 1:
               scan.nextLine();
                yeniKitap.kitapEkle();
                scan.nextLine();
                menu();
                break;
            case 2:
                noIleKitapGoruntule(kitapList);
                menu();
                break;
            case 3:
               scan.nextLine();
                bilgiIleKitapGoruntule(kitapList);
                menu();
                break;
            case 4:
                scan.nextLine();
                noIleKitapSil(kitapList);
                menu();
                break;
            case 5:
                tumKitaplariListele(kitapList);
                menu();
                break;
            case 6:
                cikis();
                break;
            default:
                System.out.println("Hatali secim lutfen tekrar deneyiniz: ");
                menu();

        }

    }


}
