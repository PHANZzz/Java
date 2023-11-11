import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String phone;

    public User(int id, String username, String password, String email, String phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

class UserRepository {
    List<User> userList = new ArrayList<>();

    // CREATE
    public void userCreate(int index, User user) {
        userList.add(index, user);
    }

    // READ
    public List<User> getAllUsers() {
        return userList;
    }

    public Optional<User> findById(int id) {
        return userList.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    // UPDATE
    public Optional<User> userUpdate(int index, User userUpdate) {
        Optional<User> existingUser = findById(userUpdate.getId());
        if (existingUser.isPresent()) {
            userList.set(index, userUpdate);
            return existingUser;
        } else {
            return Optional.empty();
        }
    }

  //DELETE
  public Optional<User> userDelete(int id) {
  Optional<User> existingUser = findById(id);
    if (existingUser.isPresent()) {
      userList.removeIf(user -> user.getId() == id);
      return existingUser;
    }
    else{
      return Optional.empty();
    }
  }
}
class Main {
    public static void main(String[] args) {
        UserRepository userRepo = new UserRepository();
   
      // CREATE USER
        User user1 = new User(1, "user1", "pass1", "email1", "phone1");
        User user2 = new User(2, "user2", "pass2", "email2", "phone2");

        userRepo.userCreate(0, user1);
        userRepo.userCreate(1, user2);

        // UPDATING USER
        Optional<User> userUpdating = Optional.of(new User(1, "KanSophan", "sophan@123", "sophan@gmail.com", "087330040"));
        Optional<User> updatedUser = userRepo.userUpdate(0, userUpdating.get());

        if (updatedUser.isPresent()) {
            User user = updatedUser.get();
            System.out.println("User Updated userID: " + user.getId());
        } else {
            System.out.println("User Not Updated");
        }
//READ BY ID
        Optional<User> findId = userRepo.findById(1);
        if (findId.isPresent()) {
          User user = findId.get();
            System.out.println("User found Name:  " + user.getUsername()+"  Password: "+user.getPassword()+"Email: "+user.getEmail()+"Phone: "+user.getPhone());
        } else {
            System.out.println("User not found");
        }
//DELETE USER

   Optional<User>userDeleted=userRepo.userDelete(2);
if(userDeleted.isPresent()){
  System.out.println("User deleted ID:  "+userDeleted.get().getId());
}else{
  System.out.println("User not deleted");
}
      
//READ ALL
        List<User> getAllUser = userRepo.getAllUsers();
        for (User user : getAllUser) {
            System.out.print(" { ID: " + user.getId() + ", Name: '" + user.getUsername() + "' } , ");
        }
    }
}
