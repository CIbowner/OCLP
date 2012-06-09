package OCLP;

import com.jme3.material.Material;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.asset.*;

public class Road{
    public Geometry SpawnRoad(AssetManager assetManager){
        Box ground = new Box(Vector3f.ZERO, 10, 0.1f, 3);
        Geometry geometry_ground = new Geometry("Road", ground);

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setTexture("ColorMap",assetManager.loadTexture("Textures/Road/flagstone4.jpg"));
        geometry_ground.setMaterial(mat);
        
        return geometry_ground;
    }
}
