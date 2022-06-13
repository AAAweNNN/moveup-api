package jp.co.vermore.common;

/**
 * Created by xieyoujun on 2018/02/03.
 */
public class Constant {

    public static final String EMPTY_STRING = "";
    public static final int ZERO = 0;
    public static final String SPACE = " ";
    public static final String SEEDS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static class UUID {
        public static final int SIZE = 10;
    }

    public static class USER_STATUS {
        public final static int EFFECT = 1;
        public final static int TEMP_WITHDRAWAL = 2;
        public final static int NON_EFFECT = 3;
        public final static int WITHDRAWAL = 4;
    }


    public static class ADMIN_SESSION {
        public final static String USER = "admin_user";
    }

    public static class NOTIFY {
        public final static int UNOPEN = 1;
        public final static int OPEN = 2;
        public final static int UNSEND = 1;
        public final static int SEND = 2;
        public final static int NOTIFY = 1;
        public final static int PUSH = 2;
        public final static int ADMIN = 1;
        public final static int USER = 2;
        public final static int ANDROID = 2;
        public final static int IOS = 2;
        public final static int ALL = 2;
    }

    public static class USER_FOREIGN_TYPE {
        public final static int TWITTER = 1;
        public final static int FACEBOOK = 2;
        public final static int MAIL = 3;
    }

    public static class USER_FOREIGN_ISLOGIN {
        public final static int NOTLOGIN = 0;
        public final static int ISLOGIN = 1;
    }

    public static class USER_TYPE {
        public final static int ADMIN_USER = 1;
        public final static int CUSTOMER = 2;
    }

    public static class CUSTOMER {
        public final static int EFFECTIVE = 1;
        public final static int INVALID = 2;
        public final static int ADMIN_SHOP = 1;
        public final static int SHOP = 2;
        public final static int CUSTOMER_SHOP = 1;
        public final static int CUSTOMER_PLACE = 2;
        public final static int CUSTOMER_RECRUIT = 3;
    }

    public static class ENTRY_TYPE {
        public final static int APPLICATION = 1;
        public final static int IS_ENTRY = 1;
        public final static int NOT_ENTRY = 2;
    }

    public static class USER_PRIVILEGE {
        public final static int NO_AUTHORITY = 0;
        public final static int READ = 1;
        public final static int WRITE = 2;
    }

    public static class ONE_TIME_KEY {
        public final static int SIZE = 64;
        public final static int MAIL_REGIST = 1;
        public final static int MAIL_FORGET = 2;
    }

    public static class PERSON_GENDER {
        public final static int UNKNOW = 0;
        public final static int MALE = 1;
        public final static int FEMALE = 2;
    }

    public static class SESSION {
        public final static int SIZE = 64;
        public final static int MAX_AGE = 30 * 3600 * 24 * 365;
        public final static String PATH = "/";
        public final static String UUID = "uid";
        public final static String SESSIONID = "sid";
        public final static String ADMIN_SESSIONID = "asid";
    }

    public static class SHOP_TAG {
        public final static int ALL = 0;
        public final static int FOOD = 1;
        public final static int RECRUIT = 2;
        public final static int HEALTH = 3;
        public final static int PLAY = 4;
        public final static int BRIDAL = 5;
        public final static int DRIVE = 6;
        public final static int PLACE = 7;
        public final static int CORPORATE_INFO = 8;
        public final static int LEARNING = 9;
        public final static int FACILITY = 10;
        public final static int LIFE = 11;
        public final static int FASTION = 12;
        public final static int AREA = 1;
        public final static int DAY_PRICE_LOW = 2;
        public final static int NIGHT_PRICE_LOW = 3;
        public final static int WEEK_DAYS = 4;
        public final static int DAY_OPEN_TIME = 5;
        public final static int DAY_CLOSE_TIME = 6;
        public final static int DAY_LAST_ORDER = 7;
        public final static int NIGHT_OPEN_TIME = 8;
        public final static int NIGHT_CLOSE_TIME = 9;
        public final static int NIGHT_LAST_ORDER = 10;
        public final static int CHARACTER = 11;
        public final static int SCENE = 12;
        public final static int STATION = 13;
        public final static int WALK_TIME = 14;
        public final static int AVERAGE_PRICE = 15;
        public final static int DAY_PRICE_HIGH = 16;
        public final static int NIGHT_PRICE_HIGH = 17;
        public final static int FIRST_MENU = 18;
        public final static int SECOND_MENU = 19;
        public final static int BRAND = 20;
        public final static int SEAT = 21;
        public final static int MASSAGE_TIME = 22;
        public final static int HEADCOUNT = 23;
        public final static int ROOM_TYPE = 24;
        public final static int ROOM_NUM = 25;
        public final static int CONTACT_TIME = 26;
        public final static int FOOD_PRICE = 27;
        public final static int DRINK_PRICE = 28;
        public final static int CORKAGE_PRICE = 29;
        public final static int EMLOYEE_NUM = 30;
        public final static int CAPITAL = 31;
        public final static int REST_DATE = 32;
        public final static int REST_WEEK = 33;
        public final static int REST_WEEKDAY = 34;
    }

    public static class FAV_TYPE {
        public final static int EVENT = 13;
        public final static int GOODS = 15;
        public final static int SHOP = 14;
        public final static int FREEPAPER = 16;
        public final static int RECRUIT = 17;
        public final static int TV = 18;
        public final static int PLACE = 19;
        public final static int CORPORATEINFO = 20;
    }

    public static class NOTIFY_NOW45 {
        public final static byte now4 = 1;
        public final static byte now5 = 2;
        public final static Byte NOTIFY_TYPE_INAPP = 1;
        public final static Byte NOTIFY_TYPE_PUSH = 2;
        public final static Byte NOTIFY_STATUS_UNOPENED = 1;
        public final static Byte NOTIFY_STATUS_OPENED = 2;
        public final static Byte PUSH_STATUS_UNSENT = 1;
        public final static Byte PUSH_STATUS_SENT = 2;
    }

    public static class SHOP_HEALTH_GENRE {
        public final static int SALON = 301;
        public final static int MASSAGE = 302;
        public final static int CHIROPRATIC = 303;
        public final static int COSMETICS = 304;
        public final static int DRUGSTORE = 305;
        public final static int SUPPLEMENT = 306;
        public final static int HOT_SPRING = 307;
        public final static int TRAINING = 308;
        public final static int COSMETIC_SURGERY = 309;
    }

    public static class SHOP_LEARN_GENRE {
        public final static int SCHOOL = 901;
        public final static int PRE_SCHOOL = 902;
        public final static int CRAM_SCHOOL = 903;
        public final static int CONVERSATION = 904;
        public final static int COOKING_CLASS = 905;
        public final static int DANCE_CLASS = 906;
        public final static int MUSIC_CLASS = 907;
        public final static int SPORTS_SCHOOL = 908;
        public final static int CHILD_EDUCATION = 909;
        public final static int QULIFICATION = 910;
        public final static int IT_CLASS = 911;
    }

    public static class SHOP_FACILITY_GENRE {
        public final static int ACCOMMODATION = 1001;
        public final static int COMMUNAL = 1002;
        public final static int COMMERCIAL = 1003;
        public final static int PARADE = 1004;
        public final static int TEMPLE = 1005;
    }

    public static class SHOP_LIFE_GENRE {
        public final static int HOUSE = 1101;
        public final static int LIFE = 1102;
        public final static int HOBBY = 1103;
        public final static int FINANCIAL = 1104;
        public final static int PET = 1105;
        public final static int PURCHASE = 1106;
        public final static int HOSPITAL = 1107;
    }

    public static class ADMIN {
        public final static int ADMIN_TYPE_SHOP = 1;
        public final static int ADMIN_TYPE_RISE = 2;
    }

    public static class INQUIRE_STATUS {
        public final static int INQUIRE_STATUS_UNFINISH = 0;
        public final static int INQUIRE_STATUS_DONE = 1;
    }

    public static class COMMENT_TYPE {
        public final static int SHOP = 1;
        public final static int RISE = 2;
    }

    public static class INQUIRE_TYPE {
        public final static int USER = 1;
        public final static int ADMIN = 2;
    }

    public static class COIN_ID {
        public final static int SHOP = 1;
        public final static int GOODS = 2;
        public final static int INVITE = 3;
        public final static int SNS = 4;
        public final static int FREEPAPER_AD = 5;
        public final static int TV_AD = 6;
        public final static int TEST = 99;
    }

    public static class COIN_TYPE {
        public final static Byte INCREASE = 1;
        public final static Byte REDUCE = 2;
    }

    public static class TV_VIDEO_TYPE {
        public final static int YOUTUBE = 1;
        public final static int AWS = 2;

        public final static Byte YOUTUBE_TYPE = 1;
        public final static Byte AWS_TYPE = 2;
    }

    public static class GOODS_SIZE {
        public final static Byte FREESIZE = 0;
        public final static Byte XS = 1;
        public final static Byte S = 2;
        public final static Byte M = 3;
        public final static Byte L = 4;
        public final static Byte XL = 5;
    }

    public static class GOODS_COLOR {
        public final static Byte COLORIZED = 0;
        public final static Byte BLACK = 1;
        public final static Byte WHITE = 2;
    }

    public static class STOCK_TYPE {
        public final static Byte INCREASE = 1;
        public final static Byte REDUCE = 2;
    }

    public static class CAREER {
        public final static int CAREER = 0;
        public final static int JUNIOR_STUDENT = 1;
        public final static int SENIOR_STUDENT = 2;
        public final static int COLLEGE_STUDENT = 3;
        public final static int UNIVERSITY_STUDENT = 4;
        public final static int CIVIL_SERVANT = 5;
        public final static int SELF_EMPLOYED = 6;
        public final static int EMPLOYEE = 7;
        public final static int TEMPORARY = 8;
        public final static int DISPATCHED = 9;
        public final static int CONTRACT = 10;
        public final static int HOUSE_WIFE = 11;
        public final static int HOUSE_HUSBAND = 12;
        public final static int ARBEIT = 13;
        public final static int OTHER = 14;
    }

    public static class PURCHASE_STATUS {
        public final static int CART = 11;
        public final static int PURCHASE_SUCCESS = 12;
        public final static int PURCHASE_FAILURE = 13;
        public final static int DELIVER_GOODS = 14;
        public final static int RETURN_GOODS = 21;
        public final static int TRANSACTION_COMPLETION = 31;
        public final static int CONVENIENCE_STORE_TO_BE_PAID = 41;
        public final static int CONVENIENCE_STORE_HAS_BEEN_PAID = 42;
        public final static int CONVENIENCE_STORE_PAYMENT_HAS_EXPIRED = 43;
    }

    public static class NEWS_TYPE {
        public final static Byte UNKNOW = 0;
        public final static Byte EVENT = 1;
        public final static Byte MOVEUP = 2;
        public final static Byte NEWS = 3;
        public final static Byte ENTRY = 4;
        public final static Byte STUDIO_NEWS = 5;
    }

    public static class TEAM_TYPE {
        public final static Byte UNKNOW = 0;
        public final static Byte EVENT = 1;
        public final static Byte MOVEUP = 2;
        public final static Byte TEAM = 3;
        public final static Byte ENTRY = 4;
        public final static Byte STUDIO_NEWS = 5;
    }


    /**
     * 20210317　楊追加
     */
    public static class REPORT_TYPE {
        public final static Byte UNKNOW = 0;
        public final static Byte EVENT = 1;
        public final static Byte MOVEUP = 2;
        public final static Byte REPORT = 3;
        public final static Byte ENTRY = 4;
        public final static Byte STUDIO_REPORT = 5;
    }

    public static class ENTRY__MAIL_TYPE {
        public final static Byte UNKNOW = 0;
        public final static Byte NEWS_MOVEUP = 1;
        public final static Byte NEWS_EVENT = 2;
        public final static Byte EVENT = 3;
    }


    public static class NOTIFICATION {
        public final static int SEND_TYPE_ALL = 1;
        public final static int SEND_TYPE_SPECIFY = 2;
        public final static int SEND_TYPE_APP = 3;
        public final static int USER_TYPE_ADMIN = 1;
        public final static int USER_TYPE_USER = 2;
        public final static Byte NOTIFY_TYPE_INAPP = 1;
        public final static Byte NOTIFY_TYPE_PUSH = 2;
        public final static Byte NOTIFY_DEVICE_ANDROID = 1;
        public final static Byte NOTIFY_DEVICE_IOS = 2;
        public final static Byte NOTIFY_DEVICE_ALL = 3;
        public final static Byte NOTIFY_STATUS_UNOPENED = 1;
        public final static Byte NOTIFY_STATUS_OPENED = 2;
        public final static Byte PUSH_STATUS_UNSENT = 1;
        public final static Byte PUSH_STATUS_SENT = 2;
        public final static int PUSH_ADMIN = 1;
        public final static int PUSH_NOW4 = 2;
        public final static int PUSH_NOW5 = 3;
    }

    public static class TAG_MODULE_TYPE {
        public final static int ALL = 0;
        public final static int FOOD = 1;
        public final static int RECRUIT = 2;
        public final static int HEALTH = 3;
        public final static int PLAY = 4;
        public final static int BRIDAL = 5;
        public final static int DRIVE = 6;
        public final static int PLACE = 7;
        public final static int CORPORATE_INFO = 8;
        public final static int LEARNING = 9;
        public final static int FACILITY = 10;
        public final static int LIFE = 11;
        public final static int FASTION = 12;
    }

    public static class RECRUIT_TAG_TYPE {
        public final static int AREA = 1;                                         // 1:エリア(1:岡山市、TODO:確認要)
        public final static int MODE = 2;                                         // 2:雇用形態
        public final static int DETAIL = 3;                                       // 3:こだわり
        public final static int FEATURE = 4;                                      // 4:特徽
        public final static int TREATMENT = 5;                                    // 5:待遇
        public final static int WORKING_TIME_START = 6;                           // 6：就業時間が始まる(HHMM)
        public final static int WORKING_TIME_END = 7;                             // 7：就業時間が終わる(HHMM)
        public final static int CAREER = 8;                                       // 8:業種
        public final static int WORK_PERIOD = 9;
        public final static int WORK_TIME = 10;
        public final static int CAPACITY = 11;
        public final static int WORK_WAY = 12;
        public final static int ALLOWANCE_SPECIAL = 13;
        public final static int WORK_ENVIRONMENT = 14;
        public final static int TREATMENT_NEW = 15;

    }

    public static class EVENT_PIC_TYPE {
        public final static Byte STAR = 1;
        public final static Byte COMMENT = 2;
        public final static Byte TEAM = 3;
        public final static Byte STUDIO_NEWS = 4;
        public final static Byte STUDIO_NEWS_DETAIL = 5;
        public final static Byte SHOP = 6;
        public final static Byte PLACE = 7;
        public final static Byte INFO = 8;
        public final static Byte RECRUIT = 9;
        public final static Byte NEWS_TOP = 10;
        public final static Byte NEWS_FOOT = 11;
        public final static Byte STUDIO_REPORT = 12;
        public final static Byte STUDIO_REPORT_DETAIL = 13;
        public final static Byte REPORT_TOP = 14;
        public final static Byte REPORT_FOOT = 15;
        public final static Byte Team_TOP = 16;
        public final static Byte Team_FOOT = 17;
    }
    
    public static class FREEPAPER_PIC_TYPE {
        public final static Byte IMG = 1;
        public final static Byte PDF = 2;
    }

    public static class BATCH_TYPE {
        public final static Byte COUPON = 1;
        public final static Byte SHOP_MONTHLY_EXPENSES = 2;
        public final static Byte PEYMENT_CVS = 3;
        public final static Byte PIC = 4;
        public final static Byte FREEPAPER = 5;
        public final static Byte TV = 6;
        public final static Byte NOTIFY_NOW4 = 7;
        public final static Byte NOTIFY_NOW5 = 8;
        public final static Byte RANDOM_SHOP_ONE = 9;
        public final static Byte RANDOM_SHOP_TWO = 10;
        public final static Byte UPDATE_SHOP_NOW4 = 11;
        public final static Byte UPDATE_SHOP_NOW5 = 12;
        public final static Byte SETTLEMENT_NOTIFY = 13;
        public final static Byte NOTIFY_PUSH = 14;
        public final static Byte PERSON_MAIL = 20;
    }

    public static class BATCH_STATUS {
        public final static Byte NOT_BEGINNING = 0;
        public final static Byte WORKING = 1;
        public final static Byte FINISH = 2;
    }

    public static class SETTLEMENT_ITEM_TYPE {
        public final static Byte SHOP = 1;
        public final static Byte GOODS = 2;
        public final static Byte TOP = 3;
        public final static Byte FREEPAPER = 4;
        public final static Byte EVENT = 5;
        public final static Byte NEWS = 6;
        public final static Byte PLACE = 7;
        public final static Byte RECRUIT = 8;
    }

    public static class SETTLEMENT_TYPE {
        public final static Byte COUPON = 1;
        public final static Byte SCORE = 2;
        public final static Byte ADVERTISEMENT = 3;
        public final static Byte MONTHLY_EXPENSES = 4;
        public final static Byte SUBSHOP = 5;
    }

    public static class SETTLEMENT_STATUS {
        public final static boolean UNSETTLED = false;
        public final static boolean ALREADY_SETTLED = true;
    }

    public static class SETTLEMENT_METHOD {
        public final static Byte UNSETTLED = 0;
        public final static Byte CREDIT_CARD = 1;
        public final static Byte BANK_ACCOUNT_BUCKLE = 2;
        public final static Byte BANK_REMITTANCE = 3;
    }

    public static class PURCHASE_TYPE {
        public final static String CARD = "クレジットカード";
        public final static String CVS = "コンビニ";
    }

    public static class PAYMENT_TYPE {
        public final static int PURCHASE_SUCCESS = 1;
        public final static int PURCHASE_FAILURE = 2;
        public final static int DELIVER_GOODS = 3;
        public final static int RETURN_GOODS = 4;
        public final static int TRANSACTION_COMPLETION = 5;
    }

    public static class USER_SETTING {
        public final static String SHOP = "1";
        public final static String EVENT = "2";
        public final static String TV = "3";
        public final static String RECRUIT = "4";
        public final static String GOODS = "5";
        public final static String FREEPAPER = "6";
        public final static String NOW4 = "7";
        public final static String NOW5 = "8";

        public final static String ON = "0";
        public final static String OFF = "1";
    }

    public static class NOTIFY_ITEM {
        public final static Integer SHOP = 1;
        public final static Integer EVENT = 2;
        public final static Integer TV = 3;
        public final static Integer RECRUIT = 4;
        public final static Integer GOODS = 5;
        public final static Integer FREEPAPER = 6;
        public final static Integer NOW4 = 7;
        public final static Integer NOW5 = 8;
        public final static Integer SETTLEMENT = 9;
        public final static Integer NEWS = 10;
        public final static Integer PLACE = 11;
        public final static Integer INFO = 12;
    }

    public static class SYS_CONF {
        public final static int SYSTEM_STATUS = 1;
        public final static int SYSTEM_STATUS_NORMAL = 1;
        public final static int SYSTEM_STATUS_MAINTENANCE = 2;
        public final static int COUPON_PRICE_DAY = 2;
        public final static int COUPON_PRICE_MONTH = 3;
        public final static int SYSTEM_STATUS_IOS_ADMIN_VERSION = 4;
        public final static int SYSTEM_STATUS_IOS_MAIN_VERSION = 5;
        public final static int SYSTEM_STATUS_IOS_NOW_VERSION = 6;
        public final static int SYSTEM_STATUS_ANDROID_ADMIN_VERSION = 7;
        public final static int SYSTEM_STATUS_ANDROID_MAIN_VERSION = 8;
        public final static int SYSTEM_STATUS_ANDROID_NOW_VERSION = 9;
    }

    public static class VERSION_CODE {
        public final static int VERSION_CODE = 0;
        public final static int VERSION_CODE_ONE = 1;
        public final static int VERSION_CODE_TWO = 2;
        public final static int VERSION_CODE_THREE = 3;
        public final static int VERSION_CODE_FOUR = 4;
        public final static int VERSION_CODE_FIVE = 5;
    }

    public static class VERSION_CODE_NAME {
        public final static String VERSION_CODE_NAME = "1.0.0";
    }

}