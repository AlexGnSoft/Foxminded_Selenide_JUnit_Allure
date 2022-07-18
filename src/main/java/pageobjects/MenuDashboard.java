package pageobjects;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class MenuDashboard {

    public static final SelenideElement minimizeSideBarBtn = $(".material-icons.visible-on-sidebar-mini");
    public static final SelenideElement managersTab = $("#menu-managers");
    public static final SelenideElement departmentsTab = $("#menu-departments");
    public static final SelenideElement closeButton = $(".close");



}
