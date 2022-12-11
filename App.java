
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class App {
  public static void main(String[] args) {
    Infrastructure infrastructure = new Infrastructure();

    System.out.println(infrastructure.getAllInfo(1));
    System.out.println(infrastructure.getAllInfo(2));
    System.out.println(infrastructure.getAllInfo(3));
    System.out.println(infrastructure.getAllInfo(4));
    System.out.println(infrastructure.getAllInfo(5));
    System.out.println(infrastructure.getAllInfo(6));
    System.out.println();
    System.out.println(infrastructure.nameSearch("карна"));
    System.out.println();
    infrastructure.totalSearch("марвел");
  }
}

class Infrastructure {
  public Infrastructure() {
    init();
  }

  Db db;

  public Db getDb() {
    return db;
  }

  public ArrayList <String> nameSearch(String keyWordString) { //поиск только по полю имя
    Queue<Cinema> queue = new LinkedList<>();
    queue.addAll(db.films);
    int res = 0;
    ArrayList <String> searchResult = new ArrayList<>();
    System.out.println("Вы ищете фильмы по слову: "+keyWordString);
    for (Cinema object : queue) {
      String temp = object.name;
      if (temp.toLowerCase().contains(keyWordString.toLowerCase())) {
        res++;
        int tempid = object.id;
        searchResult.add(getAllInfo(tempid));
      }
    }
    if (res == 0) {
      String myres = String.format("Совпадений со словом %s нет", keyWordString);
      System.out.println(myres);
    }
    return searchResult;
  }
  public void totalSearch(String keyWordString) { //поиск по всем данным
    Queue<Cinema> queue = new LinkedList<>();
    queue.addAll(db.films);
    int res = 0;
    System.out.println("Вы ищете фильмы по слову: "+keyWordString);
    for (Cinema object : queue) {
      String temp = getAllInfo(object.id);
      if (temp.toLowerCase().contains(keyWordString.toLowerCase())) {
        res++;
        System.out.println(temp);
      }
    }
    if (res == 0) {
      String myres = String.format("Совпадений со словом %s нет", keyWordString);
      System.out.println(myres);
    }
  }

  public String getAllInfo(int idCinema) {
    Cinema c = db.films.get(idCinema - 1);

    return String.format("%d %s %s %s",
        c.id,
        c.name,
        db.genres.get(c.genre - 1).name,
        db.prod.get(c.filmProd - 1).titleName);
  }

  Db init() {
    db = new Db();
    Cinema c1 = new Cinema(1, "Тьма", 1, 1);
    Cinema c2 = new Cinema(2, "Свет", 1, 2);
    Cinema c3 = new Cinema(3, "Особенности национальной охоты", 3, 4);
    Cinema c4 = new Cinema(4, "Человек-паук", 3, 3);
    Cinema c5 = new Cinema(5, "Карнавальная ночь", 3, 3);
    Cinema c6 = new Cinema(6, "Тьма египетская", 2, 2);

    db.films.add(c1);
    db.films.add(c2);
    db.films.add(c3);
    db.films.add(c4);
    db.films.add(c5);
    db.films.add(c6);

    db.genres.add(new Genre(1, "Ужасы"));
    db.genres.add(new Genre(2, "Драма"));
    db.genres.add(new Genre(3, "Комедия"));
    FilmProducerFactory pf = new FilmProducerFactory();
    db.addFilmProducer(pf.getFilmProducer("Ленфильм"));
    db.addFilmProducer(pf.getFilmProducer("Марвел"));
    db.addFilmProducer(pf.getFilmProducer("Мосфильм"));
    db.addFilmProducer(pf.getFilmProducer("DC"));

    return db;
  }
}

class Db {
  ArrayList<Cinema> films = new ArrayList<>();
  ArrayList<FilmProducer> prod = new ArrayList<>();
  ArrayList<Genre> genres = new ArrayList<>();

  public void addFilmProducer(FilmProducer producer) {
    prod.add(producer);
  }
}

class Cinema {
  int id;
  int filmProd;
  String name;
  int genre;

  public Cinema(int id, String name, int genre, int filmProd) {
    this.id = id;
    this.filmProd = filmProd;
    this.name = name;
    this.genre = genre;
  }
}

class FilmProducer {
  int id;
  String titleName;
}

class Genre {
  int id;
  String name;

  public Genre(int id, String name) {
    this.id = id;
    this.name = name;
  }
}

class FilmProducerFactory {
  int count = 1;

  public FilmProducer getFilmProducer(String name) {
    FilmProducer fp = new FilmProducer();
    fp.id = count++;
    fp.titleName = name;
    return fp;
  }
}