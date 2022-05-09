/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package real.item;

import java.io.IOException;
import real.player.Player;
import server.Service;
import server.Util;
import server.io.Message;

/**
 *
 * @author Admin
 */
public class useItem {
    public static void uesItem(Player p, Item item, int index , short id) {
        try {
            int numbagnull = p.getBagNull();
            Util.log("Item" + item.id);
            switch (item.id) {
                case 454:
                    if(p.NhapThe == 0){
                        p.NhapThe = 1;
                        Service.gI().loadPlayer(p.session, p);  
                        Service.gI().LoadCaiTrang(p, 1, p.PartHead(), p.PartHead() + 1, p.PartHead() + 2);  
                        
                    }
                    else{
                        p.NhapThe = 0;   
                        Service.gI().loadPlayer(p.session, p);  
                        Service.gI().LoadCaiTrang(p, 1, p.PartHead(), p.PartBody(), p.Leg());  
                       
                    };  
                    break;
                case 595:
                    if(index != -1){
                        if(p.ItemBag[index].id == 595){
                            if(p.ItemBag[index].quantity > 0){
                                 p.hp += p.hp + p.ItemBag[index].getParamItemByID(48);
                                 p.mp += p.mp + p.ItemBag[index].getParamItemByID(48);
                                 p.ItemBag[index].quantity-=1;
                                 Service.gI().loadPoint(p.session,p);
                                 Service.gI().updateItemBag(p);
                            }
                        }
                    }
                    break;
                case 108:
                    Util.log("item name ------------>"+ item.info);
                    ItemTemplate data = ItemTemplate.ItemTemplateID(item.id);
                    byte skill = (byte) data.id;

                    p.openBookSkill(index, skill);
                    break;
                default: {
                    p.sendAddchatYellow("Chức năng đang được cập nhật");
                    break;
                }
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
