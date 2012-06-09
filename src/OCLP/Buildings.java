/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OCLP;


import com.jme3.material.Material;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.scene.Node;
import com.jme3.math.Vector3f;
import com.jme3.asset.*;


/**
 *
 * @author xenland
 */
public class Buildings {
    private AssetManager assetManager;
    private Node Buildings;
    
    private Node Building1;
    
    public Node SpawnBuildings(AssetManager assetManager){
        //Give access to assetManager for other functions to use it in this class
        this.assetManager = assetManager;
        
        //Create a "Buildings" node to hold the self-moving buildings
        Buildings = new Node();
        
        Building1 = new Node();
        
        //Spawn 3 buildings
        Geometry geometry_building = createBuilding();
        
        Building1.attachChild(geometry_building);
        
        Buildings.attachChild(Building1);
        
        return Buildings;
    }
    
    private Geometry createBuilding(){
        Vector3f boxVector = new Vector3f(9, 0.9f, 0.2f);
        Box building = new Box(boxVector, 0.2f, 0.8f, 0.2f);
        Geometry geometry_building = new Geometry("Building", building);

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setTexture("ColorMap",assetManager.loadTexture("Textures/Road/flagstone4.jpg"));
        geometry_building.setMaterial(mat);
        
        return geometry_building;
    }
    
    /* Other actions */
    public void tickPosition(){
      //Is building1 past camera?
      Vector3f Building1Pos = Building1.getWorldTranslation();
      System.out.print(Building1Pos.x+"\n");
      if(Building1Pos.x < -14){
          Building1.setLocalTranslation(0, 0, 0);
      }
      Building1.move(-0.008f, 0, 0);
        
    }
}
