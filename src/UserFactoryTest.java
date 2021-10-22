import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {

    @org.junit.jupiter.api.Test
    void getObject() {
        ObjectFactory factory = new UserFactory();
        User user = (User) factory.getObject("users", "ABC", "abc", "abc");
        User admin = (User) factory.getObject("admin", "ABC", "abc", "abc");
        User owner = (User) factory.getObject("owner", "ABC", "abc", "abc");

        assertTrue(user instanceof AccessedUser);
        assertTrue(admin instanceof Admin);
        assertTrue(owner instanceof HomeOwner);
    }

}