package com.example.demo0812.bean;

import java.util.List;

public class Rule {
    private int pid;
    private String pname;
    private String pcode;
    private String ppos;
    private String ptype;

    public static void Print(List<Rule> RuleList){
        int count = RuleList.size();
        String format = String.format("Rule[%%%dd]: %%s", String.valueOf(count).length());
        String info = String.format("%s %s %s %s","pname", "pcode","ppos","ptype");
        System.out.println(String.format(format, count, info));
        for(int i=0;i<count;i++){
            Rule rule = RuleList.get(i);
            info = String.format("%s %s %s %s",rule.pname,rule.pcode,rule.ppos,rule.ptype);
            System.out.println(String.format(format, i,info));
        }
        return;
    }

    public Rule() {
    }

    public Rule(String pname, String pcode, String ppos, String ptype) {
        this.pname = pname;
        this.pcode = pcode;
        this.ppos = ppos;
        this.ptype = ptype;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getPpos() {
        return ppos;
    }

    public void setPpos(String ppos) {
        this.ppos = ppos;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }
}
