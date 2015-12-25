package com.fish.acfun.model;

/**
 * Created by lyjq on 2015/12/25.
 */
public class VideoPlays {

    /**
     * code : 200
     * data : {"files":[{"code":1,"description":"标清","url":["http://vplay.aixifan.com/des/20151224/3012439_wmv/3012439_360p.mp4?k=b8eb54c4b4b0429be43e454daff80e43&t=1451027344"]},{"code":2,"description":"高清","url":["http://vplay.aixifan.com/des/20151224/3012439_wmv/3012439_480p.mp4?k=b7f6189540cc241b6fe9537aaa858b34&t=1451027344"]},{"code":3,"description":"超清","url":["http://vplay.aixifan.com/des/20151224/3012439_wmv/3012439_720p.mp4?k=4566688d5aeb5dc1e23d25f4751fed83&t=1451027344"]},{"code":4,"description":"原画","url":["http://vplay.aixifan.com/des/20151224/3012439_wmv/3012439_lvbr.mp4?k=f7bdfe740c525b240acb7110bce2c93e&t=1451027344"]}],"source":"zhuzhan","title":"Part 1","totalseconds":4543}
     * message : OK
     */

    private int code;
    /**
     * files : [{"code":1,"description":"标清","url":["http://vplay.aixifan.com/des/20151224/3012439_wmv/3012439_360p.mp4?k=b8eb54c4b4b0429be43e454daff80e43&t=1451027344"]},{"code":2,"description":"高清","url":["http://vplay.aixifan.com/des/20151224/3012439_wmv/3012439_480p.mp4?k=b7f6189540cc241b6fe9537aaa858b34&t=1451027344"]},{"code":3,"description":"超清","url":["http://vplay.aixifan.com/des/20151224/3012439_wmv/3012439_720p.mp4?k=4566688d5aeb5dc1e23d25f4751fed83&t=1451027344"]},{"code":4,"description":"原画","url":["http://vplay.aixifan.com/des/20151224/3012439_wmv/3012439_lvbr.mp4?k=f7bdfe740c525b240acb7110bce2c93e&t=1451027344"]}]
     * source : zhuzhan
     * title : Part 1
     * totalseconds : 4543
     */

    private Plays data;
    private String message;

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(Plays data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public Plays getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}
