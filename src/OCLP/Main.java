package OCLP;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.scene.Spatial;
import com.jme3.scene.Node;

public class Main extends SimpleApplication {
    private Buildings buildingsObj;
    
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        //Create the road/ground
        Road road = new Road();
        Geometry road_geometry = road.SpawnRoad(assetManager);
        
        buildingsObj = new Buildings();
        Node buildings = buildingsObj.SpawnBuildings(assetManager);
        
        //Attach elements to rootNode, Start the game afterwards
        rootNode.attachChild(road_geometry);
        rootNode.attachChild(buildings);
    }

    @Override
    public void simpleUpdate(float tpf) {
        //Tell elements to update
        buildingsObj.tickPosition();
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
