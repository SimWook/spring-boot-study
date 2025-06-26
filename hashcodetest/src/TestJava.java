import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class TestJava {
    public static void main(String[] args) {
        // JSON 데이터 (문자열)
        String jsonData = "{\"adId\": \"s00000000064005\", \"title\": \"生協組合員募集プログラム２(02-0308)\", \"endTerm\": \"2999-12-31T23:59:59\", \"logoUrl\": \"https://pub.a8.net/a8v2/media/eyecatchBannerUrlAction.do?insId=s00000000064005\", \"startTerm\": \"2025-04-03T22:02:17\", \"adSourceId\": \"s00000000064005\", \"advertiser\": \"パルシステム生活協同組合連合会\", \"categoryId\": 7, \"logoSubUrl\": \"\", \"rewardRate\": null, \"categoryIds\": [7], \"description\": \"生協の宅配パルシステムの組合員（会員）募集プログラムです。\\n\\n首都圏を中心に約160万世帯の組合員で構成される生協の宅配（パルシステム）のご案内です。\\nパルシステムは、安全・安心な食材を中心に、毎週一回、ご自宅先まで宅配する生協の事業です。\\nもちろん注文はインターネットでok！\\n※資料は郵送または担当エリアの職員が直接お持ちします。\\nプログラム名称・ＰＲ文等はメディア会員様に向けた説明です。\\nこちらのページ内で使用されている文言や表現等を運営サイトに転載した場合、広告表示に適さない場合がございます。\\n事前に「法律関連の禁止事項」をご確認いただきますようお願いいたします。\", \"redirectUrl\": \"https://px.a8.net/svt/ejp?a8mat=2BNVFU+DPKD9U+HS+TU8UB\", \"rewardPrice\": 833.0, \"approvalSpan\": \"１〜３ヶ月程度\", \"pointSetting\": \"fix\", \"targetDevice\": \"PC,Android,iPhone\", \"actionPointId\": \"31\", \"isOnlyOneTime\": true, \"actionCondition\": \"【成果条件】\\n・広告主新規（当広告主を初めて利用する方）\\n・WEB申込後、14日以内の電話確認\\n※「資料請求」「加入申し込み」2つの成果が発生した場合、先に発生したもののみを確定します。\\n【否認条件】\\n・東京、神奈川、千葉、埼玉、茨城、栃木、群馬、福島、山梨、静岡、新潟、長野以外と当会組合員からの資料請求 \\n・サービス提供外にお住いの方\\n・ご利用をされるご本人様以外の方からの申込（代理申込不可）\\n・おともだち紹介など他キャンペーンを利用した場合\\n・年齢：18歳未満NG（高校生不可）\\n・過去1年以内にパルシステムの組合員登録をしたことがある場合\\n記載の成果条件・否認条件の他、A8.netのルールを遵守いただく必要がございます。\\nA8.netより広告掲載面の開示を求めた際に応じていただけない場合は、成果キャンセルとなる可能性がございます。 その他、広告掲載前に「A8.netでの禁止事項」をご確認いただきますようお願いいたします。\\n【備考】: ■ポイントサイトについて\\n□ポイント獲得のみを目的とした資料請求と判断された場合、成果対象外（ポイント付与対象外）とさせていただきます。\\n□媒体が独自の企画でインセンティブをユーザーへ提供する場合、\\n・媒体独自の企画である点を明記する\\n・広告主/スポンサーへの問合せはNGである点を明記する\", \"rewardStartTerm\": \"2025-04-03T22:02:17\", \"additionActionPoint\": \"・広告主新規（当広告主を初めて利用する方）\", \"preparedApprovalSpan\": \"\"}";
        try {
            // ObjectMapper 생성
            ObjectMapper objectMapper = new ObjectMapper();

            // JSON 문자열을 HashMap으로 변환 (키는 String, 값은 Object)
            Map<String, Object> map = objectMapper.readValue(jsonData, HashMap.class);

            // 결과 출력
            System.out.println("HashMap 결과:");
            map.forEach((key, value) -> {
                System.out.println(key + " : " + value);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
