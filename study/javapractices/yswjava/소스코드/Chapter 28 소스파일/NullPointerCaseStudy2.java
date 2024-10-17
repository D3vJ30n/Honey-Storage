package study.javapractices.yswjava.소스코드.Chapter

import java.util.Optional;

class Friend {
    String name;
    Company cmp;    // null �� �� ����

    public Friend(String n, Company c) {
        name = n;
        cmp = c;
    }
    public String getName() { return name; }
    public Company getCmp() { return cmp; }
}

class Company {
    String cName;
    ContInfo cInfo;    // null �� �� ����

    public Company(String cn, ContInfo ci) {
        cName = cn;
        cInfo = ci;
    }
    public String getCName() { return cName; }
    public ContInfo getCInfo() { return cInfo; }

}

class ContInfo {
    String phone;   // null �� �� ����
    String adrs;    // null �� �� ����

    public ContInfo(String ph, String ad) {
        phone = ph;
        adrs = ad;
    }
    public String getPhone() { return phone; }
    public String getAdrs() { return adrs; }

}

class NullPointerCaseStudy2 {
    public static void showCompAddr(Optional<Friend> f) {
        String addr = f.map(Friend::getCmp)
                .map(Company::getCInfo)
                .map(ContInfo::getAdrs)
                .orElse("There's no address information.");

        System.out.println(addr);
    }

    public static void main(String[] args) {

        ContInfo ci = new ContInfo("321-444-577", "Republic of Korea");
        Company cp = new Company("YaHo Co., Ltd.", ci);
        Friend frn = new Friend("LEE SU", cp);

        // ģ�� �������� ȸ�� �ּҸ� ���
        showCompAddr(Optional.of(frn));
    }
}