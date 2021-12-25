package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class sportsFacility {
    private String id;
    private String name;
    private String nameEnglish;
    private String active;
    private String sDescription;
    private String lDescription;
    private String sDescriptionEnglish;
    private String lDescriptionEnglish;
    private String mo;
    private String subject;
    private String significance;
    private String locality;
    private String localityEnglish;
    private String address;
    private String addressEnglish;
    private String arctmu;
    private String ftp;
    private String actions;
    private Date constructionStartDate;
    private Date constructionEndDate;
    private Long totalFunding;
    private Long fundingFederalBudget;
    private Long fundingFederalBudgetMastered;
    private Long fundingFederalSubjectBudget;
    private Long fundingFederalSubjectBudgetMastered;
    private Long fundingMunicipalityBudget;
    private Long fundingMunicipalityBudgetMastered;
    private Long fundingExtraBudgetarySources;
    private Long fundingExtraBudgetarySourcesMastered;
    private String core;
    private String supervisingAuthority;
    private String supervisingAuthorityEnglish;
    private String supervisingAuthorityAddress;
    private String supervisingAuthorityEnglishAddress;
    private String supervisingAuthorityPhone;
    private String objectContactPhone;
    private String workingHoursWeekdays;
    private String workingHoursSaturday;
    private String workingHoursSunday;
    private Integer area;
    private String email;
    private String url;
    private String register;
    private String sportsComplexType;
    private String competitions;
    private String sports;
    private Float yandexX;
    private Float yandexY;
    private Integer yandexScale;
    private Float yandexCenterX;
    private Float yandexCenterY;
    private Float miniX;
    private Float miniY;
    private Integer generalPlan;
    private Integer extraPlan;
    private Integer photo;
    private String ulrPhoto;
    private Integer video;
    private Integer panorama;
    private Integer webStreams;
    private Integer others;

    sportsFacility(String[] str){
        id = str[0];
        name = str[1];
        nameEnglish = str[2];
        active = str[3];
        sDescription = str[4];
        lDescription = str[5];
        sDescriptionEnglish = str[6];
        lDescriptionEnglish = str[7];
        mo = str[8];
        subject = str[9];
        significance = str[10];
        locality = str[11];
        localityEnglish = str[12];
        address = str[13];
        addressEnglish = str[14];
        arctmu = str[15];
        ftp = str[16];
        actions = str[17];
        try{
            Date utilDate = new SimpleDateFormat("dd.MM.yyyy").parse(str[18]);
            constructionStartDate = new java.sql.Date(utilDate.getTime());
        }
        catch (ParseException e){
            constructionStartDate = null;
        }
        try{
            Date utilDate = new SimpleDateFormat("dd.MM.yyyy").parse(str[19]);
            constructionEndDate = new java.sql.Date(utilDate.getTime());
        }
        catch (ParseException e){
            constructionEndDate = null;
        }
        try{
            totalFunding = Long.parseLong(str[20]);
        }
        catch (NumberFormatException e){
            totalFunding = null;
        }
        try{
            fundingFederalBudget = Long.parseLong(str[21]);
        }
        catch (NumberFormatException e){
            fundingFederalBudget = null;
        }
        try{
            fundingFederalBudgetMastered = Long.parseLong(str[22]);
        }
        catch (NumberFormatException e){
            fundingFederalBudgetMastered = null;
        }
        try{
            fundingFederalSubjectBudget = Long.parseLong(str[23]);
        }
        catch (NumberFormatException e){
            fundingFederalSubjectBudget = null;
        }
        try{
            fundingFederalSubjectBudgetMastered = Long.parseLong(str[24]);
        }
        catch (NumberFormatException e){
            fundingFederalSubjectBudgetMastered = null;
        }
        try{
            fundingMunicipalityBudget = Long.parseLong(str[25]);
        }
        catch (NumberFormatException e){
            fundingMunicipalityBudget = null;
        }
        try{
            fundingMunicipalityBudgetMastered = Long.parseLong(str[26]);
        }
        catch (NumberFormatException e){
            fundingMunicipalityBudgetMastered = null;
        }
        try{
            fundingExtraBudgetarySources = Long.parseLong(str[27]);
        }
        catch (NumberFormatException e){
            fundingExtraBudgetarySources = null;
        }
        try{
            fundingExtraBudgetarySourcesMastered = Long.parseLong(str[28]);
        }
        catch (NumberFormatException e){
            fundingExtraBudgetarySourcesMastered = null;
        }
        core = str[29];
        supervisingAuthority = str[30];
        supervisingAuthorityEnglish = str[31];
        supervisingAuthorityAddress = str[32];
        supervisingAuthorityEnglishAddress = str[33];
        supervisingAuthorityPhone = str[34];
        objectContactPhone = str[35];
        workingHoursWeekdays = str[36];
        workingHoursSaturday = str[37];
        workingHoursSunday = str[38];
        try{
            area = Integer.parseInt(str[39]);
        }
        catch (NumberFormatException e){
            area = null;
        }
        email = str[40];
        url = str[41];
        register = str[42];
        sportsComplexType = str[43];
        competitions = str[44];
        sports = str[45];
        try{
            yandexX = Float.parseFloat(str[46]);
        }
        catch (NumberFormatException e){
            yandexX = null;
        }
        try{
            yandexY = Float.parseFloat(str[47]);
        }
        catch (NumberFormatException e){
            yandexY = null;
        }
        try{
            yandexScale = Integer.parseInt(str[48]);
        }
        catch (NumberFormatException e){
            yandexScale = null;
        }
        try{
            yandexCenterX = Float.parseFloat(str[49]);
        }
        catch (NumberFormatException e){
            yandexCenterX = null;
        }
        try{
            yandexCenterY = Float.parseFloat(str[50]);
        }
        catch (NumberFormatException e){
            yandexCenterY = null;
        }
        try{
            miniX = Float.parseFloat(str[51]);
        }
        catch (NumberFormatException e){
            miniX = null;
        }
        try{
            miniY = Float.parseFloat(str[52]);
        }
        catch (NumberFormatException e){
            miniY = null;
        }
        try{
            generalPlan = Integer.parseInt(str[53]);
        }
        catch (NumberFormatException e){
            generalPlan = null;
        }
        try{
            extraPlan = Integer.parseInt(str[54]);
        }
        catch (NumberFormatException e){
            extraPlan = null;
        }
        try{
            photo = Integer.parseInt(str[55]);
        }
        catch (NumberFormatException e){
            photo = null;
        }
        ulrPhoto = str[56];
        try{
            video = Integer.parseInt(str[57]);
        }
        catch (NumberFormatException e){
            video = null;
        }
        try{
            panorama = Integer.parseInt(str[58]);
        }
        catch (NumberFormatException e){
            panorama = null;
        }
        try{
            webStreams = Integer.parseInt(str[59]);
        }
        catch (NumberFormatException e){
            webStreams = null;
        }
        try{
            others = Integer.parseInt(str[60]);
        }
        catch (NumberFormatException e){
            others = null;
        }
    }
    public String getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getNameEnglish(){
        return this.nameEnglish;
    }
    public String getActive(){
        return this.active;
    }
    public String getsDescription(){
        return this.sDescription;
    }
    public String getsDescriptionEnglish(){
        return this.sDescriptionEnglish;
    }
    public String getlDescription(){
        return this.lDescription;
    }
    public String getlDescriptionEnglish(){
        return this.lDescriptionEnglish;
    }
    public String getMo(){
        return this.mo;
    }
    public String getSubject(){
        return this.subject;
    }
    public String getSignificance(){
        return this.significance;
    }
    public String getLocality(){
        return this.locality;
    }
    public String getLocalityEnglish(){
        return this.localityEnglish;
    }
    public String getAddress(){
        return this.address;
    }
    public String getAddressEnglish(){
        return this.addressEnglish;
    }
    public String getArctmu(){
        return this.arctmu;
    }
    public String getFtp(){
        return this.ftp;
    }
    public String getActions(){
        return this.actions;
    }
    public Date getConstructionStartDate(){
        return this.constructionStartDate;
    }
    public Date getConstructionEndDate(){
        return this.constructionEndDate;
    }
    public Long getTotalFunding(){
        return this.totalFunding;
    }
    public Long getFundingFederalBudget(){
        return this.fundingFederalBudget;
    }
    public Long getFundingFederalBudgetMastered(){
        return this.fundingFederalBudgetMastered;
    }
    public Long getFundingFederalSubjectBudget(){
        return this.fundingFederalSubjectBudget;
    }
    public Long getFundingFederalSubjectBudgetMastered(){
        return this.fundingFederalSubjectBudgetMastered;
    }
    public Long getFundingMunicipalityBudget(){
        return this.fundingMunicipalityBudget;
    }
    public Long getFundingMunicipalityBudgetMastered(){
        return this.fundingMunicipalityBudgetMastered;
    }
    public Long getFundingExtraBudgetarySources(){
        return this.fundingExtraBudgetarySources;
    }
    public Long getFundingExtraBudgetarySourcesMastered(){
        return this.fundingExtraBudgetarySourcesMastered;
    }
    public String getCore(){
        return this.core;
    }
    public String getSupervisingAuthority(){
        return this.supervisingAuthority;
    }
    public String getSupervisingAuthorityEnglish(){
        return this.supervisingAuthorityEnglish;
    }
    public String getSupervisingAuthorityAddress(){
        return this.supervisingAuthorityAddress;
    }
    public String getSupervisingAuthorityEnglishAddress(){
        return this.supervisingAuthorityEnglishAddress;
    }
    public String getSupervisingAuthorityPhone(){
        return this.supervisingAuthorityPhone;
    }
    public String getObjectContactPhone(){
        return this.objectContactPhone;
    }
    public String getWorkingHoursWeekdays(){
        return this.workingHoursWeekdays;
    }
    public String getWorkingHoursSaturday(){
        return this.workingHoursSaturday;
    }
    public String getWorkingHoursSunday(){
        return this.workingHoursSunday;
    }
    public Integer getArea(){
        return this.area;
    }
    public String getEmail(){
        return this.email;
    }
    public String getUrl(){
        return this.url;
    }
    public String getRegister(){
        return this.register;
    }
    public String getSports(){
        return this.sports;
    }
    public String getSportsComplexType(){
        return this.sportsComplexType;
    }
    public String getCompetitions(){
        return this.competitions;
    }
    public Float getYandexX(){
        return this.yandexX;
    }
    public Float getYandexY(){
        return this.yandexY;
    }
    public Float getYandexCenterX(){
        return this.yandexCenterX;
    }
    public Float getYandexCenterY(){
        return this.yandexCenterY;
    }
    public Float getMiniX(){
        return this.miniX;
    }
    public Float getMiniY(){
        return this.miniY;
    }
    public Integer getGeneralPlan(){
        return this.generalPlan;
    }
    public Integer getExtraPlan(){
        return this.extraPlan;
    }
    public Integer getPhoto(){
        return this.photo;
    }
    public String getUrlPhoto(){
        return this.ulrPhoto;
    }
    public Integer getVideo(){
        return this.video;
    }
    public Integer getPanorama(){
        return this.panorama;
    }
    public Integer getWebStreams(){
        return this.webStreams;
    }
    public Integer getOthers(){
        return this.others;
    }
    public Integer getYandexScale(){
        return this.yandexScale;
    }
}
