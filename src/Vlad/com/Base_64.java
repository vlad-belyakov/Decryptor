package Vlad.com;

import java.util.Base64;

public class Base_64 {

    protected String codeToBase64(String code){
        return Base64.getEncoder().encodeToString(code.getBytes());
    }
    protected String encodeFromBase64(String code){
        try {
            byte[] actualByte= Base64.getDecoder().decode(code);
            return new String(actualByte);
        } catch (Exception e){
            return code;
        }
    }
}
/*{"url":"/context/detail/id/164892248/",
"ci":{"id":277294,"name":"webDelivery",
"vertical":"pdp","version":2,
"params":[{"name":"theme","text":"default"},
{"name":"holidaysNotificationText",
"text":"Сроки доставки увеличены,
 так как склад продавца не работает в праздники"},
 {"name":"holidaysNotificationLinkText",
 "text":"Посмотреть товары других продавцов"}],
 "tokens":{"widget":"w-9246765f94997db3c54ec7ffd12c6398cec1a52b",
 "page":"p-fa2603c0872931a625244f1aee5c94d16fd35761"}}}
 */

//0KXQvtGA0L7RiNC+INC20LjQstC10YIg0L3QsCDRgdCy0LXRgtC1INCS0LjQvdC90Lgg0J/Rg9GFIQ==
