package org.example.springbootstudy;

// Tomcat組み込みWebサーバーおよび関連クラスのインポート
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Deprecated
public class OldSpringApplication {

    /**
     * curl -v -X GET "http://localhost:8080/hello"
     * 上の内容で詳細リクエスト、レスポンス情報が見れる
     */
    public static void main(String[] args) {
        // TomcatのServletWebServerFactoryを生成する
        ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();

        // Webサーバーを作成し、ServletContextにServletを登録する
        WebServer webServer = serverFactory.getWebServer(servletContext -> {
            // HelloControllerのインスタンスを生成
            HelloController helloController = new HelloController();

            // "frontcontroller"という名前でHttpServletを追加し、全てのパス("/*")にマッピングする
            servletContext.addServlet("frontcontroller", new HttpServlet() {
                @Override
                // HTTPリクエストを処理するメソッドをオーバーライド
                protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                    // 認証、セキュリティ、多言語対応など共通機能の処理場所
                    // "/hello"パスかつGETメソッドの場合
                    if (req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())) {
                        // クエリパラメータからnameを取得
                        String name = req.getParameter("name");

                        // HelloControllerのhelloメソッドを呼び出し
                        String ret = helloController.hello(name);

                        // レスポンスステータスを200 OKに設定
                        resp.setStatus(HttpStatus.OK.value());
                        // レスポンスヘッダーContent-Typeをtext/plainに設定
                        resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
                        // レスポンスボディに結果を出力
                        resp.getWriter().println(ret);

                        // "/user"パスの場合（未実装）
                    } else if (req.getRequestURI().equals("/user")) {
                        // 404 Not Foundを返す
                        resp.setStatus(HttpStatus.NOT_FOUND.value());
                        // その他のパスも404 Not Found
                    } else {
                        resp.setStatus(HttpStatus.NOT_FOUND.value());
                    }
                }
            }).addMapping("/*"); // 全てのパスにServletをマッピング
        });

        // Webサーバーを起動する
        webServer.start();
    }
}
