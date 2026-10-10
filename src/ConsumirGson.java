import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class ConsumirGson  {

    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public CEP converterJsonParaObejto(String json) {

         return gson.fromJson(json, CEP.class);

    }

    public String converterParaJson(CEP endereco){

        return gson.toJson(endereco);

    }

    public String converterListaParaJson(List<CEP> listaJson){


                return gson.toJson(listaJson);


    }

    public List<CEP> converterJsonParaLista(String listaObjeto){

        List<CEP> conversor = new ArrayList<>();

        if (listaObjeto != null && !listaObjeto.isEmpty()){
            TypeToken<List<CEP>> listTypeToken = new TypeToken<List<CEP>>(){};
             conversor = gson.fromJson(listaObjeto, listTypeToken.getType());
            }

            return conversor;

    }

}
