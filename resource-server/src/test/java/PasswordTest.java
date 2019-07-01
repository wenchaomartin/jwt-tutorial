import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Create by songwenchao on 2019-06-28
 */
//@RunWith(SpringJUnit4ClassRunner.class)
public class PasswordTest {
  @Test
  public void test() {

  PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    System.out.println(passwordEncoder.encode("pass"));
    System.out.println(passwordEncoder.encode("pass"));
}

}
