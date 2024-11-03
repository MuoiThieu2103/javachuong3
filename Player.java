public class Player {
    private int number;
    private float x;
    private float y;
    private float z = 0.0f;

        public Player(int number, float x, float y) {
            this.number = number;
            this.x = x;
            this.y = y;
        }

        public void move(float xDisp, float yDisp) {
            x += xDisp;
            y += yDisp;
        }

        public void jump(float zDisp) {
            z += zDisp;
        }

         public boolean near(Ball ball) {
            float dx = x - ball.getX();
            float dy = y - ball.getY();
            double distance = Math.sqrt(dx * dx + dy * dy);

            return distance <= ball.getRadius();
        }

        public void kick(Ball ball) {
            if (near(ball)) {
                ball.setxDelta(ball.getxDelta() * 2);
                ball.setyDelta(ball.getyDelta() * 2);
            } else {
                System.out.println("Player is not near the ball to kick it.");
            }
        }

        @Override
        public String toString() {
            return "Player[number=" + number + ", position=(" + x + ", " + y + ", " + z + ")]";
        }
}
