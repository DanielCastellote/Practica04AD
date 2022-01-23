 public class Blog {
        private static Blog instance;

        private Blog() {
        }

        public static Blog getInstance() {
            if (instance == null) {
                instance = new Blog();
            }
            return instance;
        }

    }