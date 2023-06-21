package pkgFinalProject;
public class cDaftarTransaksi {
    cTransaksi front,rear;
    int jumlah;
    cDaftarTransaksi(){
        front=rear=null;
        jumlah=0;
    }
    public cTransaksi getFront(){
        return front;
    }
    public cTransaksi getRear(){
        return rear;
    }
    public void tambahTransaksi(cTransaksi baru){
        if(rear==null){
            front=rear=baru; 
        }
        else{
            rear.next=baru;
            rear=baru;
        }
        System.out.println("Penambahan sukses...");
    }
    public void lihatTransaksi(){
        int i=1;
        System.out.println("DAFTAR TRANSAKSI");
        System.out.println("===============================================================");
        System.out.println("No. \tKODE \tID/NAMA | NAMA MAKANAN \tPORSI \tSTATUS");
        System.out.println("===============================================================");
        for (cTransaksi t= front; t!=null; t=t.next){
            System.out.print(i+".");
            System.out.print("\t"+t.getKode()+"\t");
            System.out.print(t.getPembeli()+"\t| ");
            System.out.print(t.getBarang().getNama()+"\t");
            System.out.print(t.getJumlah()+"\t");
            System.out.println(t.getStatus());
            i++;
        }
        System.out.println("===============================================================");
    }
    
    public void lihatTransaksiMember(){
        int i=1;
        double total=0,diskon;
        System.out.println("\t\tDAFTAR TRANSAKSI MEMBER\t\t");
        System.out.println("===============================================================");
        System.out.println("No. \tKODE \tID/NAMA | NAMA MAKANAN \tPORSI \tHARGA \tSTATUS");
        System.out.println("===============================================================");
        for (cTransaksi t= front; t!=null; t=t.next){
            System.out.print(i+".");
            System.out.print("\t"+t.getKode()+"\t");
            System.out.print(t.getPembeli()+"\t| ");
            System.out.print(t.getBarang().getNama()+"\t");
            System.out.print(t.getJumlah()+"\t");
            System.out.print(t.getBarang().getHarga());
            System.out.println("\t"+t.getStatus());
            i++;
            total=total+(t.getBarang().getHarga()*t.getJumlah());
        }
        System.out.println("===============================================================");
        System.out.println("Total Bayar    : "+total);
        System.out.println("Diskon         : "+(0.5*total));
        System.out.println("Jumlah Dibayar : "+(total-(0.5*total)));
    }
    public void lihatTransaksiSudahDiproses(){
        int i=1;
        double harga=0, total1=0;
        System.out.println("===============================================================");
        System.out.println("\t\tDAFTAR TRANSAKSI SUDAH DIPROSES\t\t");
        System.out.println("===============================================================");
        System.out.println("No. \tKODE \tID/NAMA | NAMA MAKANAN \tPORSI \tHARGA \tSTATUS");
        System.out.println("===============================================================");
        for (cTransaksi trk= front; trk!=null; trk=trk.next){
            if (trk.getStatus()==1){
                System.out.print(i+".");
                System.out.print("\t"+trk.getKode()+"\t");
                System.out.print(trk.getPembeli()+"\t| ");
                System.out.print(trk.getBarang().getNama()+"\t");
                System.out.print(trk.getJumlah()+"\t");
                System.out.print(trk.getBarang().getHarga());
                System.out.println("\t"+trk.getStatus());
                i++; 
                total1=total1+(trk.getBarang().getHarga()*trk.getJumlah());
            }   
        }
        System.out.println("===============================================================");
        System.out.println("Total Transaksi  : "+total1);
    }
    public void lihatTransaksiBelumDiproses(){
        int i=1;
        double harga=0, total1=0;
        System.out.println("===============================================================");
        System.out.println("\t\tDAFTAR TRANSAKSI BELUM DIPROSES\t\t");
        System.out.println("===============================================================");
        System.out.println("No. \tKODE \tID/NAMA | NAMA MAKANAN \tPORSI \tHARGA \tSTATUS");
        System.out.println("===============================================================");
        for (cTransaksi trk= front; trk!=null; trk=trk.next){
            if (trk.getStatus()==0){
                System.out.print(i+".");
                System.out.print("\t"+trk.getKode()+"\t");
                System.out.print(trk.getPembeli()+"\t| ");
                System.out.print(trk.getBarang().getNama()+"\t");
                System.out.print(trk.getJumlah()+"\t");
                System.out.print(trk.getBarang().getHarga());
                System.out.println("\t"+trk.getStatus());
                i++; 
                total1=total1+(trk.getBarang().getHarga()*trk.getJumlah());
            }     
        }
        System.out.println("===============================================================");
        System.out.println("Total Transaksi Belum Diproses  : "+total1);
    }
    public void hapusTransaksi(int nomor){
       cTransaksi t=front;
       cTransaksi prev=null;
       int i=1;
       if(nomor==1){
           if(t.next==null){
               front=rear=null;
           }
           else{
           front=front.next;
           t.next=null;
           } 
           System.out.println("["+t.getBarang().getNama()+"] dihapus");
       }
       else{
           for (; t!=null; t=t.next) {
               if(i==nomor){
                   break; 
               }
               i++;
               prev=t;
           }  
           //yang dihapus di ujung belakang
           if(t.next==null){
               rear=prev;
               rear.next=null;
           }
           else{
               prev.next=t.next;
               t.next=null;
           }
           System.out.println("["+t.getBarang().getNama()+"] dihapus");
       }
    }
    public void sambungTransaksi(cTransaksi depan, cTransaksi belakang){
        //sambungkan transaksi
        if(rear==null){ //transaksi toko masih kosong
            front=depan;
            rear=belakang;
        }
        else{
            rear.next=depan;
            //update posisi rear
            rear=belakang;  
        }       
    }
    public void prosesTransaksi(cTransaksi t){
        t.setStatus(1);
    }
    public void prosesTransaksiMember(cTransaksi t){
       //mendapatkan diskon 
    }
    public int belumDiproses(){
        cTransaksi t=front;
        int proses=0;
        for (;t!=null; t=t.next) {
            if (t.getStatus()==0) {
                proses++;
            }
        }
        return proses;
    }
    public int lihatDiproses(){
        cTransaksi t=front;
        int proses=0;
        for (;t!=null; t=t.next) {
            if(t.getStatus()==1){
                proses++;
            }
        }
        return proses;
    } 
    public double lihatPemasukan(){
        cTransaksi t=front;
        double nominal=0, pemasukan=0;
        for(;t!=null; t=t.next){
            if (t.getStatus()==1) {
                //cek member berdasarkan data nama/kode pembeli
                nominal=nominal+t.getBarang().getHarga()*t.getJumlah();
                if (t.getPembeli().compareToIgnoreCase("1012022")==0||t.getPembeli().compareToIgnoreCase("1022022")==0||t.getPembeli().compareToIgnoreCase("1032022")==0||t.getPembeli().compareToIgnoreCase("1042022")==0||t.getPembeli().compareToIgnoreCase("1052022")==0) {
                    //System.out.println("Member!");
                    nominal=nominal-(0.5*nominal);
                }
            }
            pemasukan=pemasukan+nominal;
            nominal=0;
        }
        return pemasukan;
    }
}