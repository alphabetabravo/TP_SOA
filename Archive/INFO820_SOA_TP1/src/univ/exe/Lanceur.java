
package univ.exe;

import univ.controller.TemplateController;
import univ.vue.Template;


public class Lanceur {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TemplateController controller=new TemplateController();
        Template template=new Template(controller);
        
    }
    
}
