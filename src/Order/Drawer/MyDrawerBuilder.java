/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Order.Drawer;
import raven.drawer.component.SimpleDrawerBuilder;
import raven.drawer.component.footer.SimpleFooterData;
import raven.drawer.component.header.SimpleHeaderData;
import raven.drawer.component.menu.MenuAction;
import raven.drawer.component.menu.MenuEvent;
import raven.drawer.component.menu.MenuValidation;
import raven.drawer.component.menu.SimpleMenuOption;
import raven.swing.AvatarIcon;

public class MyDrawerBuilder extends SimpleDrawerBuilder {

    @Override
    public SimpleHeaderData getSimpleHeaderData() {
    return new SimpleHeaderData()
            .setIcon(new AvatarIcon(getClass().getResource("/Order/image/Avatar.jpeg"), 60, 60, 999))
            .setTitle("ViruSs")
            .setDescription("booking@vrstudio.vn");
}


    @Override
    public SimpleMenuOption getSimpleMenuOption() {
        String menus[][] = {
                {"~MAIN~"},
                {"Dashboard"},
                {"~WEB APP~"},
                {"Email", "Inbox", "Read", "Compost"},
                {"Chat"},
                {"Calendar"},
                {"~COMPONENT~"},
                {"Advanced UI", "Cropper", "Owl Carousel", "Sweet Alert"},
                {"Forms", "Basic Elements", "Advanced Elements", "SEditors", "Wizard"},
                {"~OTHER~"},
                {"Charts", "Apex", "Flot", "Sparkline"},
                {"Icons", "Feather Icons", "Flag Icons", "Mdi Icons"},
                {"Special Pages", "Blank page", "Faq", "Invoice", "Profile", "Pricing", "Timeline"},};
        
        String icons[] = {
                "dashboard.svg",
                "email.svg",
                "chat.svg",
                "calendar.svg",
                "ui.svg",
                "forms.svg",
                "chart.svg",
                "icon.svg",
                "page.svg",
            };
        return new SimpleMenuOption()
                .setMenus(menus)
                .setIcons(icons)
                .setBaseIconPath("Order/drawer/icon")
                .setIconScale(0.5f)
                .addMenuEvent(new MenuEvent() {
            @Override
            public void selected(MenuAction action, int index, int subIndex) {
                System.out.println("Menu selected "+index+" "+subIndex);
            }
                })
                .setMenuValidation(new MenuValidation(){
            @Override
            public boolean menuValidation(int index, int subIndex) {
                if(index==0){
                    return false;
                }else if(index == 3){
                    return false;
                }
                return true;
            }
                    
                });
}

    @Override
    public SimpleFooterData getSimpleFooterData() {
        return new SimpleFooterData()
                .setTitle("Java Swing Drawer")
                .setDescription("Version 1.1.0");
        
    }    
}

