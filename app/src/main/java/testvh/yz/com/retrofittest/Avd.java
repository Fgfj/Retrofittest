package testvh.yz.com.retrofittest;

import java.util.List;

/**
 * Created by yuzhou on 2016/9/28.
 * ============testavd
 */
public class Avd {


    /**
     * error_code : 0
     * reason : Success
     * result : {"data":[{"content":"一个苦逼气管炎过三十岁生日，　　估计心里憋屈喝大了，　　猛的一拍桌子指着他媳妇说：　　\u201c从今天起以后老子当家作主\u201d，　　媳妇当着大伙不好意思发作就问：　　\u201c你想做什么主呀\u201d，　　没想到那哥们憋了半天说　　\u201c以后我上厕所小便冲不冲我说了算\u201d。","hashId":"5d8dbfdbb8c238becc0dfe0cb88f17cb","unixtime":1475027030,"updatetime":"2016-09-28 09:43:50"},{"content":"宿舍一兄弟真诚的感谢我，　　略带颤抖说：你的脚臭的，　　把我打呼噜治好了！","hashId":"db2aa8b2387a1dc7079540078fa9d2a4","unixtime":1475027030,"updatetime":"2016-09-28 09:43:50"},{"content":"大学同学聚会时，　　发现都叫不上来名字，　　不禁感慨自己当年逃课太多。　　吃完发现是走错包间。","hashId":"8e673c84fcbee930b74db41f94dd9677","unixtime":1475027030,"updatetime":"2016-09-28 09:43:50"},{"content":"一次和一胖子同学从食堂吃完饭出来，　　当时雨天路滑，下台阶时胖子脚下一滑，　　坐在了地上，胖子站起来拍拍屁股说没事\u2026　　这时旁边一妹子弱弱地说：\u201c同学，瓷砖碎了\u2026\u201d","hashId":"0787c1c9ec01b54627d1bc78760fed6f","unixtime":1475027030,"updatetime":"2016-09-28 09:43:50"},{"content":"昨天中午和二货媳妇逛步行街，　　到人多的地方她问我她裙子后面是不是没弄好，　　让我帮她弄下，我手刚触摸到裙子，　　\u201c啪！\u201d贼响亮一耳光伴随二货一　　句怒吼：\u201c臭流氓，你干嘛？\u201d　　看着扬长而去的媳妇和周　　围群众的指责，我特么差点哭了。","hashId":"e3b1ae6330805b71f96b974d43729182","unixtime":1475026430,"updatetime":"2016-09-28 09:33:50"},{"content":"俗话说，左眼跳财。这不假，　　可是我左眼跳得这么厉害，　　才中六块钱！　　那要是中五百万，　　还不得把我眼睛跳瞎了啊！","hashId":"263a3926feb996f03b31ca920653caba","unixtime":1475026430,"updatetime":"2016-09-28 09:33:50"},{"content":"今天做活动遇到一个奇葩客户，　　填写单子的时候问他姓名，他说：\u201c你猜猜。\u201d　　我说要填写你宝宝的名字，他说：\u201c你猜猜。\u201d　　问了三次说了三次你猜猜，问到最后客户恼了，　　拿过笔来大笔一挥写下了他宝宝的名字\u201c倪彩彩\u201d","hashId":"de13c534787a43f0553bd82f68a3df83","unixtime":1475026430,"updatetime":"2016-09-28 09:33:50"},{"content":"一男子想女孩求婚。　　女孩问：\u201c我们认识一个　　月都不到，你了解我吗？\u201d　　男子：\u201c当然了解，而且不只一点点\u201d。　　女孩大惊：\u201c是吗？\u201d　　男子：\u201c我在银行工作，　　你爸爸账上有多少钱，　　我比谁都清楚\u201d。","hashId":"d0e51b834ff26517deb302b80759d529","unixtime":1475026430,"updatetime":"2016-09-28 09:33:50"},{"content":"闲得无聊，用微信找美眉聊天。　　搜索到附近一美眉，果断聊，各种扯。　　终于扯到约见面了，结果被拒绝。　　追问其为何，她说：\u201c哎呀，　　过段时间再说吧，我现在不缺钱花\u201d。","hashId":"f4226f21826aebd6ef45fa35631b2588","unixtime":1475026430,"updatetime":"2016-09-28 09:33:50"},{"content":"\u201c老公，我觉得这面膜很有效，你看我现在都白了好多。\u201d　　\u201c额，我建议你把面膜从脸上撕下来再看看。\u201d","hashId":"9ae10b5ad57b763a093b5f80b8ae731f","unixtime":1475026430,"updatetime":"2016-09-28 09:33:50"}]}
     */

    private int error_code;
    private String reason;
    private ResultBean result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        @Override
        public String toString() {
            return "ResultBean{" +
                    "data=" + data +
                    '}';
        }

        /**
         * content : 一个苦逼气管炎过三十岁生日，　　估计心里憋屈喝大了，　　猛的一拍桌子指着他媳妇说：　　“从今天起以后老子当家作主”，　　媳妇当着大伙不好意思发作就问：　　“你想做什么主呀”，　　没想到那哥们憋了半天说　　“以后我上厕所小便冲不冲我说了算”。
         * hashId : 5d8dbfdbb8c238becc0dfe0cb88f17cb
         * unixtime : 1475027030
         * updatetime : 2016-09-28 09:43:50
         */

        private List<DataBean> data;

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            @Override
            public String toString() {
                return "DataBean{" +
                        "content='" + content + '\'' +
                        ", hashId='" + hashId + '\'' +
                        ", unixtime=" + unixtime +
                        ", updatetime='" + updatetime + '\'' +
                        '}';
            }

            private String content;
            private String hashId;
            private int unixtime;
            private String updatetime;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getHashId() {
                return hashId;
            }

            public void setHashId(String hashId) {
                this.hashId = hashId;
            }

            public int getUnixtime() {
                return unixtime;
            }

            public void setUnixtime(int unixtime) {
                this.unixtime = unixtime;
            }

            public String getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(String updatetime) {
                this.updatetime = updatetime;
            }
        }
    }

    @Override
    public String toString() {
        return "Avd{" +
                "error_code=" + error_code +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }
}
