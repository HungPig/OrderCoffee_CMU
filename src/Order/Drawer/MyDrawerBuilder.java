/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Order.Drawer;
import Order.form.TestForm;
import Order.tabbed.WindowsTabbed;
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
            .setTitle("Đặng Tiến Hoàng (ViruSs)")
            .setDescription("booking@vrstudio.vn");
}


    @Override
    public SimpleMenuOption getSimpleMenuOption() {
        String menus[][] = {
            {"~MASTER DATA~"},
            {"Products", "Product List", "Categories"},
            {"Settings"},
            {"~MAIN MENU~"},
            {"Dashboard"},
            {"Orders"},
            {"Sign Out"},};

        
        String icons[] = {
            "product.svg",
            "setting.svg",
            "dashboard.svg",
            "order.svg",}; 

        return new SimpleMenuOption()
                .setMenus(menus)
                .setIcons(icons)
                .setBaseIconPath("Order/drawer/icon")
                .setIconScale(0.03f)
                .addMenuEvent(new MenuEvent() {
            @Override
            public void selected(MenuAction action, int index, int subIndex) {
                if (index == 0) {
                            WindowsTabbed.getInstance().addTab("Test Form", new TestForm());
                        }
                System.out.println("Menu selected "+index+" "+subIndex);
            }
                })
                .setMenuValidation(new MenuValidation(){
            @Override
            public boolean menuValidation(int index, int subIndex) {
                /*if(index==0){
                    return false;
                }else if(index == 3){
                    return false;
                }*/
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

