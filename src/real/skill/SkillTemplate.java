package real.skill;

import org.json.simple.JSONObject;

import java.util.ArrayList;

public class SkillTemplate {

    public boolean isBuffToPlayer() {
        return this.type == 2;
    }

    public boolean isUseAlone() {
        return this.type == 3;
    }

    public boolean isAttackSkill() {
        return this.type == 1;
    }

    public byte id;

    public int classId;

    public String name;

    public int maxPoint;

    public int manaUseType;

    public int type;

    public int iconId;

    public String[] description;

    public Skill[] skills;
    public static ArrayList<SkillTemplate> entrys = new ArrayList<SkillTemplate>();
    public ArrayList<SkillOptionTemplate> templates;
    public String damInfo;
    public static JSONObject ObjectSkill(Skill skill) {
        JSONObject put = new JSONObject();
        put.put((Object)"id", (Object)skill.skillId);
        put.put((Object)"point", (Object)skill.point);
        return put;
    }
    public static SkillOptionTemplate Templates(byte id, byte point) {
        for (SkillTemplate temp : SkillTemplate.entrys) {
            if (temp.id == id) {
                for (SkillOptionTemplate data : temp.templates) {
                    if (data.point == point) {
                        return data;
                    }
                }
            }
        }
        return null;
    }
    public static SkillTemplate Templates(int id) {
        for (SkillTemplate temp : SkillTemplate.entrys) {
            if (temp.id == id) {
                return temp;
            }
        }
        return null;
    }
}
