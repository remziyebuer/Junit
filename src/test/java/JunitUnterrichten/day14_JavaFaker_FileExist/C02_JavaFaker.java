package JunitUnterrichten.day14_JavaFaker_FileExist;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C02_JavaFaker {

    @Test
    public void javaFakerTest() {
        //1.Faker objesi olustur.
        Faker faker =new Faker();
        //ya da Faker.instance() static metodu ile baslayabiliriz
        Faker.instance();
        //Firstname yazdirin:
        System.out.println(faker.name().firstName());

        //Lastname yazdiriniz
        System.out.println(faker.name().lastName());
        //Kulanici adi yaziniz
        System.out.println(faker.name().username());
        //Funny Name yazdiriniz
        System.out.println(faker.funnyName().name());
        //meslek ismi yazdiriniz
        System.out.println(faker.name().title());
        //sehir ismi yazdiriniz
        System.out.println(faker.address().city());
        //eyalet yazdiriniz
        System.out.println(faker.address().state());
        //Full adress yazdirin
        System.out.println(faker.address().fullAddress());
        //cep tlf no yazdiriniz
        System.out.println(faker.phoneNumber().cellPhone());
        //e mail yazdiriniz
        System.out.println(faker.internet().emailAddress());
        //posta kodu yazdiriniz
        System.out.println(faker.address().zipCode());
        //ratgele 15 haneli bir numara alalim
        System.out.println(faker.number().digits(15));
        //bana 1 ile 10000000 arasinda bir sayi ver
        System.out.println(faker.number().numberBetween(1,10000000));

        //bunlari sadece java ile yapiyorum driver a iihtiyacim yok

    }
}
