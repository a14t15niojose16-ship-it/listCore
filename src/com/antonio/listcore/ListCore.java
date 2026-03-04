package com.antonio.listcore;

import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.*;
import com.google.appinventor.components.runtime.*;

import java.util.ArrayList;
import java.util.Collections;

@DesignerComponent(
    version = 1,
    description = "listCore - Lista moderna e poderosa",
    category = ComponentCategory.EXTENSION,
    nonVisible = true,
    iconName = ""
)
@SimpleObject(external = true)
public class ListCore extends AndroidNonvisibleComponent {

    private ArrayList<String> items = new ArrayList<>();

    public ListCore(ComponentContainer container) {
        super(container.$form());
    }

    @SimpleFunction(description = "Adicionar item")
    public void AddItem(String text) {
        items.add(text);
    }

    @SimpleFunction(description = "Remover item pelo índice")
    public void RemoveItem(int index) {
        if (index > 0 && index <= items.size()) {
            items.remove(index - 1);
        }
    }

    @SimpleFunction(description = "Limpar lista")
    public void Clear() {
        items.clear();
    }

    @SimpleFunction(description = "Obter item pelo índice")
    public String GetItem(int index) {
        if (index > 0 && index <= items.size()) {
            return items.get(index - 1);
        }
        return "";
    }

    @SimpleFunction(description = "Alterar item pelo índice")
    public void SetItem(int index, String newText) {
        if (index > 0 && index <= items.size()) {
            items.set(index - 1, newText);
        }
    }

    @SimpleFunction(description = "Quantidade de itens")
    public int Count() {
        return items.size();
    }

    @SimpleFunction(description = "Ordenar lista")
    public void Sort() {
        Collections.sort(items);
    }

    @SimpleFunction(description = "Inverter lista")
    public void Reverse() {
        Collections.reverse(items);
    }

    @SimpleFunction(description = "Buscar item e retornar índice (0 se não encontrar)")
    public int Search(String text) {
        int index = items.indexOf(text);
        return (index >= 0) ? index + 1 : 0;
    }

    @SimpleFunction(description = "Importar lista do Kodular")
    public void ImportFromList(YailList list) {
        items.clear();
        for (Object obj : list.toArray()) {
            items.add(String.valueOf(obj));
        }
    }

    @SimpleFunction(description = "Exportar lista para o Kodular")
    public YailList ExportToList() {
        return YailList.makeList(items);
    }
}
