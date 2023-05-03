package JunitUnterrichten.day20_ExcelRead_WriteExcel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
public class C01_ExcelRead {
    //burda Selenium a ihtiyacimiz yok o yüzden TestBase kullanmiyorum

    //pom xml e apachi poi ekleyerek excel  datamizi okuyabiliyor olucaz
    //örn 1000 tane kullanici ad ve sifre var tercihen excelde saklayip
    // kullanacagiz
    //öncelikle dosyayi disardan alip okuyacak File Input Steream (dosyayi iceri alan )
    // classina ihtiyacimiz var.Birde File Output Stream var ama onu burda kullanmayacagiz
    //daha sonra onu okumak icin Workbook clasina ihtiyacimiz olacak

/*
    Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
    3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
    Kullanılan satır sayısın bulun
    Ülke-Başkent şeklinde verileri yazdırın
     */

    @Test
    public void readExcelTest() throws IOException {

        //Dosyayı al:bu islemle su an dosyam intelijde disardan alacagim excelin dosya yoluna ihtyacim var
        FileInputStream fileInputStream = new FileInputStream("src/test/java/resources/Capitals.xlsx");

        //FileInputStream objesini WorkBook(Excel) dosyası olarak aç:
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //Sayfayı(Sheet) aç:
        Sheet sheet1 = workbook.getSheet("Sheet1");

        //Satıra(Row) git:
        Row row = sheet1.getRow(0);//1. satır: indeks 0

        //Birinci hücreyi(Cell) al:
        Cell cell = row.getCell(0);//1. hücre: indeks 0

        System.out.println("cell = " + cell);

//        Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        Cell cell1_2 = sheet1.getRow(0).getCell(1);
        System.out.println("cell1 = " + cell1_2);

//        3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        Cell cell3_1 = sheet1.getRow(2).getCell(0);
        System.out.println("cell31 = " + cell3_1);
        assertEquals("France", cell3_1.toString());//cell datasi oldugu icin to String yap

//        Kullanılan satır sayısın bulun
        int sonKullanilanSatirIndeksi = sheet1.getLastRowNum();//Son kullanılan satırın indeksini verir****
        System.out.println("sonKullanilanSatirIndeksi = " + sonKullanilanSatirIndeksi);

        int kullanilanToplamSatirSayisi = sheet1.getPhysicalNumberOfRows();//Kullanılan toplam satır sayısını verir
        System.out.println("kullanilanToplamSatirSayisi = " + kullanilanToplamSatirSayisi);

//        Ülke-Başkent şeklinde verileri yazdırın
        Map<String, String> ulkelerVeBaskentleri = new HashMap<>();

        for (int satirIndeks = 1; satirIndeks < kullanilanToplamSatirSayisi; satirIndeks++) {

            String ulkeAdi = sheet1.getRow(satirIndeks).getCell(0).toString();
            String baskentAdi = sheet1.getRow(satirIndeks).getCell(1).toString();

            ulkelerVeBaskentleri.put(ulkeAdi, baskentAdi);

        }

        System.out.println("ulkelerVeBaskentleri = " + ulkelerVeBaskentleri);

    }

}
