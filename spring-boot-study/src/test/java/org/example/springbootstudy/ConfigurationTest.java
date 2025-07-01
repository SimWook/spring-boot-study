package org.example.springbootstudy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring の @Configuration アノテーションの動作と CGLIB プロキシによる
 * シングルトン保証メカニズムをテストするクラス
 */
public class ConfigurationTest {

    /**
     * Spring コンテナを使用した @Configuration クラスの
     * @Bean メソッドが同一のインスタンスを返すかテスト
     *
     * Spring が CGLIB プロキシを通じて bean1() と bean2() で
     * common() メソッド呼び出し時に同一の Common インスタンスを返すことを確認
     */
    @Test
    void configuration() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(MyConfig.class);
        ac.refresh();

        Bean1 bean1 = ac.getBean(Bean1.class);
        Bean2 bean2 = ac.getBean(Bean2.class);

        // bean1 と bean2 が同一の Common インスタンスを参照するか確認
        Assertions.assertThat(bean1.common).isSameAs(bean2.common);
    }

    /**
     * Spring コンテナなしで直接 MyConfigProxy を使用した時の動作をテスト
     *
     * 手動で実装したプロキシクラスが Spring の CGLIB プロキシと
     * 同一のシングルトン動作を保証するか確認
     */
    @Test
    void proxyCommonMethod() {
        MyConfigProxy myConfigProxy = new MyConfigProxy();

        Bean1 bean1 = myConfigProxy.bean1();
        Bean2 bean2 = myConfigProxy.bean2();

        // 手動プロキシも同一の Common インスタンスを返すか確認
        Assertions.assertThat(bean1.common).isSameAs(bean2.common);
    }

    /**
     * Spring の CGLIB プロキシ動作を模倣した手動プロキシクラス
     *
     * common() メソッド呼び出し時にキャッシングを通じて同一のインスタンスを
     * 返すようにオーバーライド
     */
    static class MyConfigProxy extends MyConfig {
        private Common common;

        @Override
        Common common() {
            // 既に生成されたインスタンスがあれば再利用、なければ新規生成
            if (this.common == null) this.common = super.common();

            return this.common;
        }
    }

    /**
     * Bean 設定を行う Configuration クラス
     * @Configuration アノテーションにより CGLIB プロキシが適用される
     */
    @Configuration
    static class MyConfig {

        /**
         * 共通で使用される Common インスタンスを生成
         */
        @Bean
        Common common() {
            return new Common();
        }

        /**
         * Bean1 インスタンスを生成し、common() メソッドを通じて依存性注入
         */
        @Bean
        Bean1 bean1() {
            return new Bean1(common());
        }

        /**
         * Bean2 インスタンスを生成し、common() メソッドを通じて依存性注入
         */
        @Bean
        Bean2 bean2() {
            return new Bean2(common());
        }
    }

    /**
     * Common に依存する Bean1 クラス
     */
    static class Bean1 {
        private final Common common;

        Bean1(Common common) {
            this.common = common;
        }
    }

    /**
     * Common に依存する Bean2 クラス
     */
    static class Bean2 {
        private final Common common;

        Bean2(Common common) {
            this.common = common;
        }
    }

    /**
     * 共通で使用される依存性クラス
     */
    static class Common {
    }

    // Bean1  <-- Common
    // Bean2  <-- Common
}
