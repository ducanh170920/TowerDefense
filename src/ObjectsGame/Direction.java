package ObjectsGame;

enum  Direction {

    LEFT(180), UP(270), RiGHT(0), DOWN(90);

    int degree;

    Direction(int i) {
        degree = i;
    }

    int getDegree() {
        return degree;
    }
}
