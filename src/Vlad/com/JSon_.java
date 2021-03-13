package Vlad.com;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


public class JSon_ {
    public void JSon_(){}

    protected String prettyView(String s){
        JsonElement jsonElement = new JsonParser().parse(s);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(jsonElement);

        return json;
    }
    /*{"url":"/context/detail/id/164892248/",
    "ci":{"id":277294,"name":"webDelivery","vertical":"pdp","version":2,"params":[{"name":"theme","text":"default"},
    {"name":"holidaysNotificationText","text":"Сроки доставки увеличены, так как склад продавца не работает в праздники"}
    ,{"name":"holidaysNotificationLinkText","text":"Посмотреть товары других продавцов"}],
    "tokens":{"widget":"w-9246765f94997db3c54ec7ffd12c6398cec1a52b","page":"p-fa2603c0872931a625244f1aee5c94d16fd35761"}}}
     */
}
