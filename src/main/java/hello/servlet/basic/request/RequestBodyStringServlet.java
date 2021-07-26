package hello.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // inputStream으로 메시지바디의 데이터를 바이트코드로 바로 얻을 수 있다.
        ServletInputStream inputStream = request.getInputStream();
        // 항상 바이트 <--> 문자로 변환할 때는 어떤 인코딩 지정해야 한다.
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        // 출력
        System.out.println("messageBody = " + messageBody);
        response.getWriter().write("OK");
    }
}
