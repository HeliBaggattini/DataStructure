//Projeto II
//
//Tarefa 2 - sumarizar para cada ano de lançamento:
//
//+ número de reviews deste ano
//+ percentual de ‘Mediocre’ reviews (sobre o número de reviews deste ano)
//+ média aritmética dos scores
//+ desvio padrão populacional dos scores
//+ melhor jogo (basta indicar um entre os de maior score)
//+ pior jogo (basta indicar um entre os de menor score)
//
//Ao final: qual o ano em que foi lançado um maior número de jogos do gênero ‘Action’?
//
package TasksListsAndProject;

import java.util.Map;
import java.util.TreeMap;
import regEx.SimpleReader;

/**
 *
 * @author 1511 FOX
 */
public class ProjectGameReviews {

    public static void main(String[] args) {
        exec();
    }

    public static void exec() {
        //title; -------- 0
        //platform;------ 1
        //score_phrase;-- 2
        //score;--------- 3
        //genre;--------- 4
        //editors_choice; 5
        //release_year--- 6
        Map<Integer, Item> map = new TreeMap<Integer, Item>();

        SimpleReader file = new SimpleReader("game-reviews.csv");

        String s = file.readLine();
        s = file.readLine();
        while (s != null) {
        //for (int i = 0; i < 310; i++) { //-----for temporário (para testes)
            String[] line = s.split(";");

            int key = Integer.parseInt(line[6]);
            double score = Double.parseDouble(line[3]);
            String game = line[0];
            String review = line[2];
            String genre = line[4];

            //System.out.println(key + "/" + score + "/" + review + "/" + genre);//---print temporario(para testes)

            if (!map.containsKey(key)) {
                map.put(key, new Item(1, game, score, review, genre));
            } else {
                Item aux = map.get(key);

                aux.addPop();
                aux.addScore(game, score);
                aux.putReview(review);
                aux.putGenre(genre);

                map.put(key, aux);
            }

            s = file.readLine();
        }

        file.close();

        for (int w : map.keySet()) {
            System.out.println(w + ":\n" + map.get(w));
        }

//Ao final: qual o ano em que foi lançado um maior número de jogos do gênero ‘Action’?
        int ano = 0;
        int cont = 0;
        int aux = 0;

        for (int w : map.keySet()) {
            if (map.get(w).genreCount.get("Action") != null) {
                aux = map.get(w).genreCount.get("Action");

                if (aux > cont) {
                    ano = w;
                    cont = aux;
                }
            }
        }

        System.out.println("Qual o ano em que foi lançado um maior número de jogos do gênero 'Action'?");
        System.out.println(ano + " : " + cont + " games");
    }

    private static class Item {

        public int pop;
        public double scoreSquered;
        public double scoreSum;
        public double scoreLow;
        public String gameLow;
        public double scoreHigh;
        public String gameHigh;
        public int mediocreCont;
        public Map<String, Integer> reviewsCount = new TreeMap<String, Integer>();
        public Map<String, Integer> genreCount = new TreeMap<String, Integer>();

        public Item() {
        }

        public Item(int pop, String game, double score, String review, String genre) {
            this.pop = pop;
            this.scoreSquered = Math.pow(score, 2);
            this.scoreSum = score;
            this.scoreLow = score;
            this.gameLow = game;
            this.scoreHigh = score;
            this.gameHigh = game;

            putReview(review);
            putGenre(genre);
        }

        public void addPop() {
            pop++;
        }

        public void addScore(String game, double score) {
            this.scoreSum += score;
            this.scoreSquered += Math.pow(score, 2);

            if (this.scoreLow > score) {
                this.scoreLow = score;
                this.gameLow = game;
            }

            if (this.scoreHigh < score) {
                this.scoreHigh = score;
                this.gameHigh = game;
            }
        }

        public void putReview(String review) {
            if (!this.reviewsCount.containsKey(review)) {
                this.reviewsCount.put(review, 1);
            } else {
                this.reviewsCount.put(review, (this.reviewsCount.get(review) + 1));
            }

            if (review.equals("Mediocre")) {
                mediocreCont++;
            }
        }

        public void putGenre(String genre) {
            if (!this.genreCount.containsKey(genre)) {
                this.genreCount.put(genre, 1);
            } else {
                this.genreCount.put(genre, this.genreCount.get(genre) + 1);
            }
        }

//+ número de reviews deste ano
//+ percentual de ‘Mediocre’ reviews (sobre o número de reviews deste ano)
//+ média aritmética dos scores
//+ desvio padrão populacional dos scores
//+ melhor jogo (basta indicar um entre os de maior score)
//+ pior jogo (basta indicar um entre os de menor score)
        public String toString() {
            String s = "";
            s += "nº de reviews: " + pop + "\n";
            s += "Reviews 'Mediocre'(%): " + ((100 * mediocreCont) / pop) + "%\n";
            s += "Média arimética do Score: " + String.format("%.2f", (scoreSum / pop)) + "\n";
            s += "Desvio Padrão do Score: " + String.format("%.2f", (Math.sqrt(((scoreSquered) - ((Math.pow(scoreSum, 2)) / pop)) / pop))) + "\n";
            s += "Melhor game: " + gameHigh + "(" + scoreHigh + ")\n";
            s += "Pior game: " + gameLow + "(" + scoreLow + ")\n";

            return s;
        }

    }

}
