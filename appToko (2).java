package pkgFinalProject;
import java.util.Scanner;
public class appToko {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //daftar barang yang dijual
        cBarang brg1 = new cBarang("Nasi Pecel",10000);
        cBarang brg2 = new cBarang("Nasi Campur",10000);
        cBarang brg3 = new cBarang("Nasi Soto",10000);
        cBarang brg4 = new cBarang("Nasi Kare",10000);
        cBarang brg5 = new cBarang("Nasi Opor",10000);
        int harga;
        //data member toko
        int id;
        int id1 = 1012022;
        int id2 = 1022022;
        int id3 = 1032022;
        String pin;
        String pin1 = "00111";
        String pin2 = "00222";
        String pin3 = "00333";
        //daftar antrian transaksi yg masuk ke toko
        cDaftarTransaksi jual = new cDaftarTransaksi();
        int pilih=0,pilih2=0,pilih3=0,pilihmkn=0;
        int kode=100,jumlah;
        
        //variabel penjualan harian untuk setiap jenis barang
        double mkn1=0, mkn2=0, mkn3=0, mkn4=0, mkn5=0;
        double ph1=0, ph2=0, ph3=0, ph4=0, ph5=0;
        
        //variabel total biaya belanja untuk member
        double mbr1=0, mbr2=0, mbr3=0, mbr4=0, mbr5=0;
        double hrg1=0, hrg2=0, hrg3=0, hrg4=0, hrg5=0;
        do{
            System.out.println("===================================================");
            System.out.println("SELAMAT DATANG DI APLIKASI KASIR WARUNG SEDEP MAREM");
            System.out.println("===================================================");
            System.out.println("\nAPLIKASI WARUNG");
            System.out.println("1.Pembeli");
            System.out.println("2.Anggota");
            System.out.println("3.Admin");
            System.out.println("4.Pemilik");
            System.out.println("5.Exit");
            System.out.print("Pilih = ");
            pilih=sc.nextInt();
            switch(pilih){
                case 1:
                    //Pembeli 
                    kode++;
                    cDaftarTransaksi beli = new cDaftarTransaksi();
                    System.out.print("Masukkan Nama = ");
                    String nama=sc.next();
                    do{
                        System.out.println("\n---- AKUN PEMBELI ----"); 
                        System.out.println("1.Tambah");
                        System.out.println("2.Hapus");
                        System.out.println("3.Lihat");
                        System.out.println("4.Kembali");
                        System.out.print("Pilih = ");
                        pilih2=sc.nextInt();
                        switch(pilih2){
                            case 1:
                                cTransaksi br=null;
                                System.out.println("DAFTAR MENU MAKANAN:");
                                System.out.println("1.Nasi Pecel    : "+brg1.getHarga());
                                System.out.println("2.Nasi Campur   : "+brg2.getHarga());
                                System.out.println("3.Nasi Soto     : "+brg3.getHarga());
                                System.out.println("4.Nasi Kare     : "+brg4.getHarga());
                                System.out.println("5.Nasi Opor     : "+brg5.getHarga());
                                System.out.print("Pilih = ");
                                pilih3=sc.nextInt();
                                System.out.print("Porsi = ");
                                jumlah=sc.nextInt();
                                if(pilih3==1){
                                    br = new cTransaksi(String.valueOf(kode),nama,brg1,jumlah,0);
                                }
                                else if(pilih3==2){
                                    br = new cTransaksi(String.valueOf(kode),nama,brg2,jumlah,0);
                                }
                                else if(pilih3==3){
                                    br = new cTransaksi(String.valueOf(kode),nama,brg3,jumlah,0);
                                }
                                else if(pilih3==4){
                                    br = new cTransaksi(String.valueOf(kode),nama,brg4,jumlah,0);
                                }
                                else if(pilih3==5){
                                    br = new cTransaksi(String.valueOf(kode),nama,brg5,jumlah,0);
                                }
                                beli.tambahTransaksi(br);
                                break;
                            case 2:
                                //hapus transaksi
                                beli.lihatTransaksi();
                                System.out.print("Hapus Nomor = ");
                                int hapus = sc.nextInt();
                                beli.hapusTransaksi(hapus);
                                break;
                            case 3:
                                beli.lihatTransaksi();
                                break;
                            case 4:
                                //selesai. sambungkan transaksi pembeli
                                //ke antrian transaksi toko
                                jual.sambungTransaksi(beli.getFront(), beli.getRear());
                                
                                break;
                        }
                    }while(pilih2!=4);
                    break;
                case 2:
                    //Anggota
                    boolean valid=false;
                    do{
                        System.out.println("------------------");
                        System.out.print("ID MEMBER = ");
                        id = sc.nextInt();
                        System.out.println("------------------");
                        System.out.print("PASSWORD = ");
                        pin = sc.next();
                        if (id==id1 && pin.equalsIgnoreCase(pin1)){
                            valid=true;
                        }else if(id==id2 && pin.equalsIgnoreCase(pin2)){
                            valid=true;
                        }else if(id==id3 && pin.equalsIgnoreCase(pin3)){
                            valid=true;
                        }
                        if (valid==false)
                            System.out.println("ID/Password yang anda masukkan salah!");
                        else break;
                    }while(valid==false);
                    if (valid==true) {
                        System.out.println("=============================================");
                        System.out.println("SELAMAT DATANG DI APLIKASI WARUNG SEDEP MAREM");
                        System.out.println("=============================================");
                        kode++;
                        beli = new cDaftarTransaksi();
                        do{
                            System.out.println("\n---- AKUN MEMBER ----"); 
                            System.out.println("1.Tambah");
                            System.out.println("2.Hapus");
                            System.out.println("3.Lihat");
                            System.out.println("4.Ubah Password");
                            System.out.println("5.Kembali");
                            System.out.print("Pilih = ");
                            pilih2=sc.nextInt();
                            switch(pilih2){
                                case 1:
                                    cTransaksi br=null;
                                    System.out.println("DAFTAR MENU MAKANAN");
                                    System.out.println("1.Nasi Pecel");
                                    System.out.println("2.Nasi Campur");
                                    System.out.println("3.Nasi Soto");
                                    System.out.println("4.Nasi Kare");
                                    System.out.println("5.Nasi Opor");
                                    System.out.print("Pilih = ");
                                    pilih3=sc.nextInt();
                                    System.out.print("Porsi = ");
                                    jumlah=sc.nextInt();
                                    if(pilih3==1){
                                        br = new cTransaksi(String.valueOf(kode),String.valueOf(id),brg1,jumlah,0);
                                    }
                                    else if(pilih3==2){
                                        br = new cTransaksi(String.valueOf(kode),String.valueOf(id),brg2,jumlah,0);
                                    }
                                    else if(pilih3==3){
                                        br = new cTransaksi(String.valueOf(kode),String.valueOf(id),brg3,jumlah,0);
                                    }
                                    else if(pilih3==4){
                                        br = new cTransaksi(String.valueOf(kode),String.valueOf(id),brg4,jumlah,0);
                                    }
                                    else if(pilih3==5){
                                        br = new cTransaksi(String.valueOf(kode),String.valueOf(id),brg5,jumlah,0);
                                    }
                                    beli.tambahTransaksi(br);
                                    break;
                                case 2:
                                    //hapus transaksi
                                    beli.lihatTransaksi();
                                    System.out.print("Hapus Nomor = ");
                                    int hapus = sc.nextInt();
                                    beli.hapusTransaksi(hapus);
                                    break;
                                case 3:
                                    //menampilkan daftar belanja dan diskon
                                    beli.lihatTransaksiMember();
                                    break;
                                case 4:
                                    //ubah password
                                    System.out.println("UBAH PASSWORD MEMBER");           
                                    do{
                                        System.out.print("Masukkan Password Lama = ");
                                        pin = sc.next();
                                        String pinbr;
                                        if (pin.equalsIgnoreCase(pin1)){
                                            valid=true;
                                        }else if(pin.equalsIgnoreCase(pin2)){
                                            valid=true;
                                        }else if(pin.equalsIgnoreCase(pin3)){
                                            valid=true;
                                        }
                                        if(valid==true){
                                            System.out.print("Masukkan Password Baru = ");
                                            pinbr = sc.next();
                                            
                                        if (id==id1) {
                                            pin1=pinbr;
                                            System.out.println("PASSWORD TELAH BERHASIL DIUBAH!");
                                        }else if (id==id2) {
                                            pin2=pinbr;
                                            System.out.println("PASSWORD TELAH BERHASIL DIUBAH!");
                                        }else if (id==id3) {
                                            pin3=pinbr;
                                            System.out.println("PASSWORD TELAH BERHASIL DIUBAH!");
                                        }
                                        }
                                        if (valid==false) {
                                            System.out.println("Password tidak valid!");
                                        }else break;
                                    }while(valid==false);
                                    
                                    break;
                                case 5:
                                    //selesai. sambungkan transaksi pembeli
                                    //ke antrian transaksi toko
                                    jual.sambungTransaksi(beli.getFront(), beli.getRear());
                                    break;
                            }
                        }while(pilih2!=5);
                    }
                    break;
                case 3:
                    //Admin
                    System.out.println("\n---- AKUN ADMIN ----");
                    jual.lihatTransaksi();
                    //memproses setiap transaksi yang belum diproses
                    boolean pbl=false;
                    cTransaksi t=jual.getFront();
                    if (t==null) {
                        System.out.println("Antrian Kosong!");
                    }
                    if (t!=null) {
                    do{
                        if(t.getStatus()==0){
                            System.out.println("\nMAKANAN YANG AKAN DIPROSES");
                            System.out.println("Kode    :"+t.getKode());
                            System.out.println("Pembeli :"+t.getPembeli());
                            System.out.println("Barang  :"+t.getBarang().getNama());
                            System.out.println("Jumlah  :"+t.getJumlah());
                            double jmlh = t.getBarang().getHarga();
                            double porsi = t.getJumlah();
                            double total = jmlh*porsi;
                            System.out.println("\n- Pilih Aksi -");
                            System.out.println("1.Diproses");
                            System.out.println("2.Selesai");
                            System.out.print("Pilih = ");
                            int aksi=sc.nextInt();
                            if(aksi==1){
                               jual.prosesTransaksi(t);
                               System.out.println("Berhasil diproses");
                               
                               //simpan penjualan member
                                if (t.getPembeli().equals(String.valueOf(id1))) {
                                    mbr1=(0.5 * (total));
                                    hrg1= hrg1+(total-mbr1);
                                }
                                else if (t.getPembeli().equals(String.valueOf(id2))) {
                                    mbr2=(0.5 * (total));
                                    hrg2= hrg2+(total-mbr2);
                                }
                                else if (t.getPembeli().equals(String.valueOf(id3))) {
                                    mbr3=(0.5 * (total));
                                    hrg3= hrg3+(total-mbr3);
                                }

                                if (t.getPembeli().equals(String.valueOf(id1))||t.getPembeli().equals(String.valueOf(id2))||t.getPembeli().equals(String.valueOf(id3))){
                                    
                                }
                                //simpan penjualan harian
                                if (t.getBarang().getNama().equals(brg1.getNama())) {
                                    mkn1=(brg1.getHarga()*t.getJumlah());
                                    if (pbl==true) {
                                        ph1= ph1-(0.5*mkn1);  
                                    }
                                    ph1=ph1+mkn1;
                                    mkn1=0;
                                }else if (t.getBarang().getNama().equals(brg2.getNama())) {
                                    mkn2=(brg2.getHarga()*t.getJumlah());
                                    if (pbl==true) {
                                        ph2= ph2-(0.5*mkn2);  
                                    }
                                    ph2=ph2+mkn2;
                                    mkn2=0;
                                }else if (t.getBarang().getNama().equals(brg3.getNama())) {
                                    mkn3=(brg3.getHarga()*t.getJumlah());
                                    if (pbl==true) {
                                        ph3= ph3-(0.5*mkn3);  
                                    }
                                    ph3=ph3+mkn3;
                                    mkn3=0;
                                }else if (t.getBarang().getNama().equals(brg4.getNama())) {
                                    mkn4=(brg4.getHarga()*t.getJumlah());
                                    if (pbl==true) {
                                        ph4= ph4-(0.5*mkn4);  
                                    }
                                    ph4=ph4+mkn4;
                                    mkn4=0;
                                }else if (t.getBarang().getNama().equals(brg5.getNama())) {
                                    mkn5=(brg5.getHarga()*t.getJumlah());
                                    if (pbl==true) {
                                        ph5= ph5-(0.5*mkn5);  
                                    }
                                    ph5=ph5+mkn5;
                                    mkn5=0;
                                }
                            }
                            else{
                                break;
                            }
                        }
                        t=t.next;
                    }while(t!=null);
                    }
                    break;
                case 4:
                    //Pemilik
                    int pilihproses=0;
                    do{
                        System.out.println("\n---- Akun Pemilik ----");
                        System.out.println("1. Ubah Harga Barang");
                        System.out.println("2. Transaksi Diproses");
                        System.out.println("3. Transaksi Belum Diproses");
                        System.out.println("4. Laporan Penjualan Harian");
                        System.out.println("5. Daftar Total Belanja Member");
                        System.out.println("6. Kembali");
                        System.out.print("Pilih = ");
                        pilihproses = sc.nextInt();
                        switch(pilihproses){
                            case 1:
                                //menu mengubah harga barang yang dijual dengan memilih nama barang yang akan diubah harganya.
                                System.out.println("UBAH HARGA");
                                System.out.println("1.Nasi Pecel");
                                System.out.println("2.Nasi Campur");
                                System.out.println("3.Nasi Soto");
                                System.out.println("4.Nasi Kare");
                                System.out.println("5.Nasi Opor");
                                System.out.print("Masukkan Pilihan : ");
                                pilihmkn = sc.nextInt();
                                System.out.print("Masukkan Harga Baru = ");
                                harga = sc.nextInt();
                                if (pilihmkn==1) {
                                    brg1.setHarga(harga);
                                    System.out.println("Harga berhasil diubah...");
                                }else if (pilihmkn==2) {
                                    brg2.setHarga(harga);
                                    System.out.println("Harga berhasil diubah...");
                                }else if (pilihmkn==3) {
                                    brg3.setHarga(harga);
                                    System.out.println("Harga berhasil diubah...");
                                }else if (pilihmkn==4) {
                                    brg4.setHarga(harga);
                                    System.out.println("Harga berhasil diubah...");
                                }else if (pilihmkn==5) {
                                    brg5.setHarga(harga);
                                    System.out.println("Harga berhasil diubah...");
                                }
                                
                                
                                break;
                            case 2:
                                //menampilkan Total nilai penjualan yang sudah diproses
                                System.out.println("-- TRANSAKSI YANG SUDAH DIPROSES --");
                                System.out.println("Jumlah Transaksi Diproses : "+jual.lihatDiproses());
                                jual.lihatTransaksiSudahDiproses();
                                System.out.println("Pemasukan : "+jual.lihatPemasukan());
                                break;
                            case 3:
                                //menampilkan Total nilai penjualan yang belum diproses.
                                System.out.println("-- TRANSAKSI BELUM DIPROSES --");
                                System.out.println("Jumlah Transaksi Yang Belum Diproses : "+jual.belumDiproses());
                                jual.lihatTransaksiBelumDiproses();
                                
                                break;
                            case 4:
                                //menampilkan daftar laporan penjualan harian
                                System.out.println("-- TOTAL NILAI PENJUALAN HARIAN --");
                                System.out.println("TOTAL PEMASUKAN : "+ jual.lihatPemasukan());
                                System.out.println("DAFTAR PENJUALAN MAKANAN");
                                System.out.println("=====================================");
                                System.out.println("NO. | NAMA MAKANAN\t| TOTAL UANG");
                                System.out.println("=====================================");
                                System.out.println("1.  | "+ brg1.getNama()+"\t| "+ph1);
                                System.out.println("2.  | "+ brg2.getNama()+"\t| "+ph2);
                                System.out.println("3.  | "+ brg3.getNama()+"\t\t| "+ph3);
                                System.out.println("4.  | "+ brg4.getNama()+"\t\t| "+ph4);
                                System.out.println("5.  | "+ brg5.getNama()+"\t\t| "+ph5);
                                break;
                            case 5:
                                //menampilkan daftar total biaya belanja untuk pembeli yang statusnya sebagai Member
                                System.out.println("DAFTAR TOTAL BELANJA MEMBER");
                                System.out.println("================================");
                                System.out.println("No. | ID MEMBER\t| TOTAL UANG");
                                System.out.println("================================");
                                System.out.println("1.  | "+ String.valueOf(id1) + "\t| "+hrg1);
                                System.out.println("2.  | "+ String.valueOf(id2) + "\t| "+hrg2);
                                System.out.println("3.  | "+ String.valueOf(id3) + "\t| "+hrg3);
                                break;
                            case 6:
                                break;
                        }
                    }while(pilihproses!=6);
                    break;
                case 5:
                    System.out.println("Terima Kasih");
                    break;
            }
        }while(pilih!=5);
    }
 
}