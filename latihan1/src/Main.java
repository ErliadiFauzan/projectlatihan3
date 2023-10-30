import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    /**
     * /disini menggunakan java.util.InputMismatchException (untuk exception)
     * /disini menggunakan java.util.Scanner (untuk input)
     * /methode Main,KonversiSuhu
     * /program main menggunakan "try catch" (untuk membuat kode kesalahan)
     * /program KonvesiSuhu throw new (pengecualian khusus) , switch case (membuat exsekusi blok pilihan)
     * /kemudian didalam switch case ada if else ( untuk menjalankan printah tertentu setelah kondisi tertentu terpenuhi)
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("Program Konversi Suhu");
            System.out.print("Berapa banyak konversi suhu yang ingin Anda lakukan?: ");
            int jumlahKonversi = input.nextInt();

            for (int i = 0; i < jumlahKonversi; i++) {
                System.out.println("Konversi ke-" + (i + 1));
                System.out.println("Pilih satuan suhu asal:");
                System.out.println("1. Reamur");
                System.out.println("2. Kelvin");
                System.out.println("3. Celcius");
                System.out.println("4. Fahrenheit");
                System.out.print("Masukkan pilihan (1/2/3/4): ");
                int pilihanAsal = input.nextInt();

                System.out.print("Masukkan suhu dalam satuan asal: ");
                double suhuAsal = input.nextDouble();

                System.out.println("Pilih satuan suhu tujuan:");
                System.out.println("1. Reamur");
                System.out.println("2. Kelvin");
                System.out.println("3. Celcius");
                System.out.println("4. Fahrenheit");
                System.out.print("Masukkan pilihan (1/2/3/4): ");
                int pilihanTujuan = input.nextInt();

                double hasilKonversi = konversiSuhu(suhuAsal, pilihanAsal, pilihanTujuan);
                System.out.println("Hasil konversi suhu: " + hasilKonversi);
            }
        } catch (InputMismatchException e) {
            System.err.println("Input tidak sesuai dengan spesifikasi program. Mohon masukkan angka.");
            input.nextLine(); // Membersihkan newline yang tidak terbaca
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        input.close();
    }

    public static double konversiSuhu(double suhuAsal, int pilihanAsal, int pilihanTujuan) {
        if (pilihanAsal < 1 || pilihanAsal > 4 || pilihanTujuan < 1 || pilihanTujuan > 4) {
            throw new IllegalArgumentException("Pilihan suhu tidak valid.");
        }

        double hasilKonversi = 0.0;

        switch (pilihanAsal) {
            case 1: // Reamur
                if (pilihanTujuan == 2) { // Reamur ke Kelvin
                    hasilKonversi = (5.0 / 4.0) * suhuAsal + 273.15;
                } else if (pilihanTujuan == 3) { // Reamur ke Celcius
                    hasilKonversi = (5.0 / 4.0) * suhuAsal;
                } else if (pilihanTujuan == 4) { // Reamur ke Fahrenheit
                    hasilKonversi = (9.0 / 4.0) * suhuAsal + 32.0;
                } else {
                    hasilKonversi = suhuAsal; // Reamur ke Reamur
                }
                break;

            case 2: // Kelvin
                if (pilihanTujuan == 1) { // Kelvin ke Reamur
                    hasilKonversi = (4.0 / 5.0) * (suhuAsal - 273.15);
                } else if (pilihanTujuan == 3) { // Kelvin ke Celcius
                    hasilKonversi = suhuAsal - 273.15;
                } else if (pilihanTujuan == 4) { // Kelvin ke Fahrenheit
                    hasilKonversi = (9.0 / 5.0) * (suhuAsal - 273.15) + 32.0;
                } else {
                    hasilKonversi = suhuAsal; // Kelvin ke Kelvin
                }
                break;

            case 3: // Celcius
                if (pilihanTujuan == 1) { // Celcius ke Reamur
                    hasilKonversi = (4.0 / 5.0) * suhuAsal;
                } else if (pilihanTujuan == 2) { // Celcius ke Kelvin
                    hasilKonversi = suhuAsal + 273.15;
                } else if (pilihanTujuan == 4) { // Celcius ke Fahrenheit
                    hasilKonversi = (9.0 / 5.0) * suhuAsal + 32.0;
                } else {
                    hasilKonversi = suhuAsal; // Celcius ke Celcius
                }
                break;

            case 4: // Fahrenheit
                if (pilihanTujuan == 1) { // Fahrenheit ke Reamur
                    hasilKonversi = (4.0 / 9.0) * (suhuAsal - 32.0);
                } else if (pilihanTujuan == 2) { // Fahrenheit ke Kelvin
                    hasilKonversi = (5.0 / 9.0) * (suhuAsal - 32.0) + 273.15;
                } else if (pilihanTujuan == 3) { // Fahrenheit ke Celcius
                    hasilKonversi = (5.0 / 9.0) * (suhuAsal - 32.0);
                } else {
                    hasilKonversi = suhuAsal; // Fahrenheit ke Fahrenheit
                }
                break;

            default:
                hasilKonversi = suhuAsal;
                break;
        }

        return hasilKonversi;
    }
}
