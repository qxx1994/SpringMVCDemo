import com.qxx.model.BlogEntity;
import com.qxx.model.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by Administrator on 2016/9/26.
 */

public class CommonTest {
    @Test
    public void setUser(){
        System.out.println("aa");
        UserEntity userEntity = new UserEntity.Builder().nickname("xiaoming").username("nighsf").build();
        System.out.println(userEntity);
    }

    @Test
    public void setBlog(){
        System.out.println("aa");
        BlogEntity blogEntity = new BlogEntity.Builder().pubDate(new Date()).content("aaa").title("a1").userId(1).build();
        System.out.println(blogEntity);
    }

}
