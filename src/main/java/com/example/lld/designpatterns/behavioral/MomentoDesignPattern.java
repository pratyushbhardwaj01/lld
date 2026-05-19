package com.example.lld.designpatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

class DocumentMomento {
    private String text;

    public DocumentMomento(String text) {
        this.text = text;
    }

    public String getMomentoText() {
        return this.text;
    }
}

class DocumentHistory {
    private List<DocumentMomento> momentoList;

    public DocumentHistory() {
        this.momentoList = new ArrayList<>();
    }

    public void addMomento(DocumentMomento documentMomento) {
        this.momentoList.add(documentMomento);
    }

    public DocumentMomento getMomento(int index) {
        return this.momentoList.get(index);
    }
}

class Document {
    private String text;

    public Document(String text) {
        this.text = text;
    }

    public void writeToDocument(String text) {
        this.text += text;
    }

    public void restoreFromMomento(DocumentMomento documentMomento) {
        this.text = documentMomento.getMomentoText();
    }

    public DocumentMomento createMomento() {
        return new DocumentMomento(this.text);
    }

    public void display() {
        System.out.println(this.text);
    }

}

public class MomentoDesignPattern {
    public static void main(String[] args) {
        DocumentHistory documentHistory = new DocumentHistory();
        Document document = new Document("pratyush");
        DocumentMomento documentMomento = document.createMomento();
        documentHistory.addMomento(documentMomento);
        document.writeToDocument("bhardwaj");
        document.display();
        document.restoreFromMomento(documentMomento);
        document.display();

    }

}
