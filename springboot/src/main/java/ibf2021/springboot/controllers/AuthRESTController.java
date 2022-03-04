// package ibf2021.springboot.controllers;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.MediaType;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import ibf2021.springboot.models.User;
// import ibf2021.springboot.services.UserService;

// // THIS PATH SHOULD BE PROTECTED OR ONLY ADMIN CAN ACCESS
// @RestController
// @RequestMapping(path = "/api/auth", produces =
// MediaType.APPLICATION_JSON_VALUE)
// public class AuthRESTController {

// @Autowired
// UserService userSvc;

// // return all the users!
// @GetMapping(path = "/users")
// public ResponseEntity<List<User>> getUsers() {
// return ResponseEntity.ok().body(userSvc.getUsers());
// }

// // save new user
// @PostMapping(path = "/user/add")
// public ResponseEntity<User> saveUser(@RequestBody User user) {
// return
// ResponseEntity.status(HttpStatus.CREATED).body(userSvc.saveUser(user));
// }

// @PostMapping(path = "/login")
// public ResponseEntity<String> login() {
// // CREATE A JWT TOKEN AND PASS IT BACK TO THE FRONT END
// // WHICH SUBSEQUENT REQUEST MUST BE MADE WITH THE HEADER AUTHORIZATION:
// 'Bearer
// // '
// // + JWT TOKEN
// return null;
// }

// }
