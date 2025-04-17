package tests.interactions;

import org.testng.annotations.Test;
import pageObjects.interactions.DroppablePO;

public class TestDroppable {
    @Test
    public void testDroppable(){
        DroppablePO drop = new DroppablePO();
        drop.setup();
        drop.irADRoppable();

        drop.arrastrarYsoltar();
        drop.captura("Test_Droppable_Simple");

        drop.tabPreventPropagation();
        drop.arrastrarYsoltarInnerNotGreedy();
        drop.captura("Test_Droppable_Prevent_Propogation_InnerNotGreedy");


        drop.arrastrarYsoltarInnerGreedy();
        drop.captura("Test_Droppable_Prevent_Propogation_InnerGreedy");

        drop.tabRevertDraggable();
        drop.dragWillRevert();
        drop.captura("Test_Droppable_Revert_Draggable_Will_Revert");

        drop.dragNotRevert();
        drop.captura("Test_Droppable_Revert_Draggable_Will_Not_Revert");

        drop.cerrarDriver();
    }
}
