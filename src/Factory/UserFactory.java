package Factory;

import Models.*;

public class UserFactory implements ObjectFactory {
    @Override
    public User getObject(String input, String... personInfo) {
        if(input.toLowerCase().contains("owner")) {
            return new HomeOwner(personInfo[0], personInfo[1], personInfo[2]);
        } else if(input.toLowerCase().contains("admin")) {
            return new Admin(personInfo[0], personInfo[1], personInfo[2]);
        } else if(input.toLowerCase().contains("users")) {
            return new AccessedUser(personInfo[0], personInfo[1], personInfo[2]);
        } else {
            return null;
        }
    }
}
