/**  
 *  
 * @author Beyza KARACA beyza.karaca@ogr.sakarya.edu.tr / Çiğdem Sıla UĞURLU sila.ugurlu@ogr.sakarya.edu.tr  
 * @since 10 Mart 2019
 * <p>  
 *Ödevde rastgeleliği sistemin zamanını nanaosaniye cinsinden alarak bu alınan saniyenin de 123 e göre modu alınrak rastgele bir sayı elde ettik.
 *Elde edilen bu sayıyın da char a çevirerek rastgele karakter üretmiş olduk.
 *Kütüphanemizde 9 farklı fonksiyon yazdık.
 *Fonksiyonların kontorlü için 7 tane regex ifadesi yazdık.
 * </p>  
 */ 
package RastgeleKarakter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class RastgeleKarakter {
    private  Pattern RastgeleBuyukKarakter;
    private  Matcher RastgeleBuyukKarakterMatches;
    private  final String RastgeleBuyukKarakterRegex ="[A-Z]";
    
    private  Pattern RastgeleKucukKarakter;
    private  Matcher RastgeleKucukKarakterMatches;
    private  final String RastgeleKucukKarakterRegex ="[a-z]";
    
    private  Pattern RastgeleUcKarakter;
    private  Matcher RastgeleUcKarakterMatches; 
    private  final String RastgeleUcKarakterRegex ="[a-zA-Z]{3}";
    
    private  Pattern RastgeleBesKarakter;
    private  Matcher RastgeleBesKarakterMatches;
    private  final String RastgeleBesKarakterRegex ="[a-zA-Z]{5}";
     
    private  Pattern RastgeleAralikliKarakter;
    private  Matcher RastgeleAralikliKarakterMatches;
    private  final String RastgeleAralikliKarakterRegex ="[b-s]";
     
    private  Pattern RastgeleBelirliKarakterB;
    private  Matcher RastgeleBelirliKarakterBMatches;
    private  final String RastgeleBelirliKarakterBRegex ="(B|e|y|z|a|K|A|R|C)";
     
    private  Pattern RastgeleBelirliKarakterS;
    private  Matcher RastgeleBelirliKarakterSMatches;
    private  final String RastgeleBelirliKarakterSRegex ="(C|g|d|e|m|S|i|l|a|U|G|R|L)";
     
    String Karakter="";
    String TamHal="";
    char rastgelekarakter;
    int rastgelesayi;
    /**
     * Bu fonksiyon Systemin nanosaniye cinsinden zamanını döndürür.
     * @return suan
     */
    private  long msuan() 
        {
            long suan;
            suan=System.nanoTime();
            return suan;
        }
    /**
     * Bu fonksiyon Systemin nanosaniye cinsinden alınanan zamanının 123 e göre modunu alıp karaktere çevirir.Yani rastgele karakter üreten fonksiyondur.
     * @return krktr
     */
    public   char rastgelekarakter() 
        {
            char krktr;
            while(true)
                {
                    rastgelekarakter=(char)(int)((msuan())%123);
                    if((rastgelekarakter>=65 && rastgelekarakter<=90) || (rastgelekarakter>=97 && rastgelekarakter<=122))break;
                }
            krktr=(char) rastgelekarakter;
            return krktr;
        }
    /**
     * Bu fonksiyon Systemin nanosaniye cinsinden alınanan zamanınından rastgele sayı üretir.
     * @return rastgelesayi
     */
    private   int rastgelesayi() //rastgele karakter ascii den yararlanarak.
        {
          rastgelesayi=(int)((msuan()%20)+1);
          return rastgelesayi;
        }
    /**
     * Verilen regex ifadesine uyana kadar rastgele karakter üretir ve uyduğu zaman yani match olduğu zaman karakter isimli değişkene atıp büyük karakteri döndürür.
     * @return Karakter
     */
    public String RastgeleBuyukKarakter()
        {
            Karakter="";
            RastgeleBuyukKarakter = Pattern.compile(RastgeleBuyukKarakterRegex);
            do{
                    Karakter=String.valueOf(rastgelekarakter());
                    RastgeleBuyukKarakterMatches = RastgeleBuyukKarakter.matcher(Karakter);
              }while(RastgeleBuyukKarakterMatches.matches()==false);
            return Karakter;
        }   
    /**
     * Verilen regex ifadesine uyana kadar rastgele karakter üretir ve uyduğu zaman yani match olduğu zaman karakter isimli değişkene atıp küçük karakteri döndürür.
     * @return Karakter
     */
    public String RastgeleKucukKarakter()
        {
            Karakter="";
            RastgeleKucukKarakter = Pattern.compile(RastgeleKucukKarakterRegex);
            do{
                Karakter=String.valueOf(rastgelekarakter());
                RastgeleKucukKarakterMatches = RastgeleKucukKarakter.matcher(Karakter);
              }while(RastgeleKucukKarakterMatches.matches()==false);
            return Karakter;
        }
    /**
     * TamHal adlı değişkenin diğer fonksiyonlarda kullanılmış olma ihtimaline karşın ilk başta string sıfırlanır.
     * Verilen regex ifadesine uyana kadar yani üç tane rastgele karakter üretilene kadar rastgele karakter üretir ve uyduğu zaman yani match olduğu zaman TamHal isimli değişkene atıp üç tane rastgele karakter döndürür.
     * @return TamHal
     */
    public String RastgeleUcKarakter()
        {          
            TamHal="";
            RastgeleUcKarakter = Pattern.compile(RastgeleUcKarakterRegex);
            do{
                TamHal+=String.valueOf(rastgelekarakter()); 
                RastgeleUcKarakterMatches = RastgeleUcKarakter.matcher(TamHal);
              }while(RastgeleUcKarakterMatches.matches()==false);
            return TamHal;        
        }
     /**
     * TamHal adlı değişkenin diğer fonksiyonlarda kullanılmış olma ihtimaline karşın ilk başta string sıfırlanır.
     * Verilen regex ifadesine uyana kadar yani beş tane rastgele karakter üretilene kadar rastgele karakter üretir ve uyduğu zaman yani match olduğu zaman TamHal isimli değişkene atıp beş tane rastgele karakter döndürür.
     * @return TamHal
     */
    public String RastgeleBesKarakter()
        {          
            TamHal="";
            RastgeleBesKarakter = Pattern.compile(RastgeleBesKarakterRegex);
            do{
                TamHal+=String.valueOf(rastgelekarakter()); 
                RastgeleBesKarakterMatches = RastgeleBesKarakter.matcher(TamHal);
              }while(RastgeleBesKarakterMatches.matches()==false);
            return TamHal;        
        }
     /**
     * TamHal adlı değişkenin diğer fonksiyonlarda kullanılmış olma ihtimaline karşın ilk başta string sıfırlanır.
     * Verilen regex ifadesine uyana kadar yani b ile s arasından rastgele sayıda rastgele karakter üretilene kadar rastgele karakter üretir ve uyduğu zaman yani match olduğu zaman TamHal isimli değişkene atıp b ile s arasından rastgele sayıda rastgele karakter döndürür.
     * @return TamHal
     */
    public String AralikliKarakter()
        {          
           TamHal="";
           Karakter="";
           RastgeleAralikliKarakter = Pattern.compile(RastgeleAralikliKarakterRegex);
            for(int i=0;i<rastgelesayi();i++){
                do{ 
                    Karakter=String.valueOf(rastgelekarakter()); 
                    RastgeleAralikliKarakterMatches = RastgeleAralikliKarakter.matcher(Karakter);
                  }while(RastgeleAralikliKarakterMatches.matches()==false);
                TamHal+=Karakter;
            }         
            return TamHal;        
        }
    /**
     * TamHal adlı değişkenin diğer fonksiyonlarda kullanılmış olma ihtimaline karşın ilk başta string sıfırlanır.
     * Verilen regex ifadesine uyana kadar yani verilen karakterler arasından rastgele sayıda rastgele karakter üretilene kadar rastgele karakter üretir ve uyduğu zaman yani match olduğu zaman TamHal isimli değişkene atıp verilen karakterler arasından rastgele sayıda rastgele karakter döndürür.
     * @return TamHal
     */
    public String BelirtilenBKarakter()
        {         
            TamHal="";
            Karakter="";
            RastgeleBelirliKarakterB = Pattern.compile(RastgeleBelirliKarakterBRegex);
            for(int i=0;i<rastgelesayi();i++){
                 do{ 
                        Karakter=String.valueOf(rastgelekarakter()); 
                        RastgeleBelirliKarakterBMatches = RastgeleBelirliKarakterB.matcher(Karakter);
                    }while(RastgeleBelirliKarakterBMatches.matches()==false);
                TamHal+=Karakter;
            }         
            return TamHal;        
        }
     /**
     * TamHal adlı değişkenin diğer fonksiyonlarda kullanılmış olma ihtimaline karşın ilk başta string sıfırlanır.
     * Verilen regex ifadesine uyana kadar yani verilen karakterler arasından rastgele sayıda rastgele karakter üretilene kadar rastgele karakter üretir ve uyduğu zaman yani match olduğu zaman TamHal isimli değişkene atıp verilen karakterler arasından rastgele sayıda rastgele karakter döndürür.
     * @return TamHal
     */
    public String BelirtilenSKarakter()
        {         
            TamHal="";
            Karakter="";
            RastgeleBelirliKarakterS = Pattern.compile(RastgeleBelirliKarakterSRegex); 
            for(int i=0;i<rastgelesayi();i++){
                do{ 
                     Karakter=String.valueOf(rastgelekarakter()); 
                     RastgeleBelirliKarakterSMatches = RastgeleBelirliKarakterS.matcher(Karakter);
                  }while(RastgeleBelirliKarakterSMatches.matches()==false);
            TamHal+=Karakter;
            }         
            return TamHal;        
        }
     /**
     * TamHal adlı değişkenin diğer fonksiyonlarda kullanılmış olma ihtimaline karşın ilk başta string sıfırlanır.
     * Bu fonksiyon öncelikli olarak iki döngüyle birlikte rastgele sayı üretimiyle bir cümledeki kelime sayısına ikinci olarakda kelimedeki karakter sayısına karar verir.
     * Daha sonra belirli olan karakter ve kelime sayısıyla bir kısıt olmadığı için döngü sonuna kadar karakater üretir.
     * En sonunda da cümlelerin ayrılabilmesi ve cümle sonlarında noktalama işaretleri kullanılması nedeniyle cümle tamamlandıktan sonra değişkene nokta ekler.Ve cümleyi döndürür.
     * @return TamHal
     */
    public String RastgeleCumle()
        {          
            TamHal="";
            for(int i=0;i<rastgelesayi();i++)
            {
                for(int j=0;j<rastgelesayi();j++)
                {     
                    TamHal+=String.valueOf(rastgelekarakter()); 
                }
                TamHal+=" ";
            }
            TamHal+=".";
            return TamHal;        
        }
}
