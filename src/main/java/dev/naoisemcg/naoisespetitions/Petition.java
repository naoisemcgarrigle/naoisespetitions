package dev.naoisemcg.naoisespetitions;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Petition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    @Lob
    private String content;

    @ElementCollection
    private List<String> signatures = new ArrayList<>();

    public Petition() {}

    public Petition(String title, String content, List<String> signatures) {
        this.title = title;
        this.content = content;
        this.signatures = signatures;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getSignatures() {
        return signatures;
    }

    public void setSignatures(List<String> signatures) {
        this.signatures = signatures;
    }
}
