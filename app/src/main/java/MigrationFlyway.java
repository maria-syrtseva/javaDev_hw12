import org.flywaydb.core.Flyway;

public class MigrationFlyway {
    public static void main(String[] args) {

        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;", "sa", "")
                .load();

        flyway.migrate();

        System.out.println("Міграції успішно виконано");
    }
}
