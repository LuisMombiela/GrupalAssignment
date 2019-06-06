package com.mygdx.theafrica;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.theafrica.HUD.HUD;
import com.mygdx.theafrica.HUD.TextButton;

import java.util.ArrayList;

public class LevelManager {

    public ArrayList<Layer>Layers;

    public ArrayList<GameObject> toRemove;
    public ArrayList<GameObject> toAdd;

    public float currentTime;


    public Background bg;

    public Grid grid;


    public Background bgWall;

    public CameraHelper cameraHelper;

    //HUD THINGS
    public OrthographicCamera hudCamera;
    HUD hud;

    public LevelManager(CameraHelper cameraHelper)
    {
        this.cameraHelper = cameraHelper;
        Layers = new ArrayList<Layer>();
        Layers.add(new Layer(Layer.LayerNames.BACKGROUND)); //0 BG
        Layers.add(new Layer(Layer.LayerNames.CARD));       //1 CARD
        Layers.add(new Layer(Layer.LayerNames.ICONS));      //2 ICONS
        Layers.add(new Layer(Layer.LayerNames.DEFAULT));    //3 DEFAULT

        //Layers.get(0).list.add(bg);

        //bg= GOFactory.generateBG(-Gdx.graphics.getWidth()/2,-Gdx.graphics.getHeight()/2,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        bgWall = GOFactory.generateBGWall(-Gdx.graphics.getWidth()/2,-Gdx.graphics.getHeight()/2,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());


        //ARREGLAR LO DE LOS PLAYERS
        //spawnPlayers();

        grid = new Grid();
        Layers.get(0).list.add(grid);





        toRemove = new ArrayList<GameObject>();
        toAdd = new ArrayList<GameObject>();
        currentTime = 0f;

        //HUD THINGS |||||SACAR ESTO DE AQUI Y PONER CADA HUD Y BACKGROUND EN EL SCREEN QUE CORRESPONDA
        hudCamera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        hud = new HUD();
        TextButton b1 = new TextButton("Hacer algo",10,10,240,50){
            @Override
            public void click() {
                //Aqui iria lo que quisieses meter como nueva accion
            }
        };

        hud.add(b1);

        //


    }

    void spawnPlayers()
    {
        Layers.get(1).list.add(new Player(0,0, 1));
        Layers.get(1).list.add(new Player(0,0, 2));
    }

    public void update(float delta)
    {
        currentTime += delta;
        grid.update(delta);

        //updateLists(delta);
        removeGos();
        addGos();
    }

    public void render(SpriteBatch batch, float staTime) {


        batch.begin();
        batch.setColor(1,1,1,1);
       // bg.draw(batch);
        bgWall.draw(batch,staTime);
        batch.end();

        batch.setProjectionMatrix(hudCamera.combined);
        batch.begin();
        hud.render(batch);
        batch.end();

    }

    /*void updateLists(float delta)
    {

        for(int i = 0; i<Layers.size(); i++)
        {
            for(int j = 0; j<Layers.get(i).list.size(); j++)
            {
                Layers.get(i).list.get(j).update(delta);
            }
        }
    }*/

    void addGos()
    {
        for(int i = 0; i<toAdd.size(); i++)
        {
            for(Layer L:Layers)
            {
                if(L.name == toAdd.get(i).layerTag)
                {
                    L.list.add((toAdd.get(i)));
                }
            }
        }

        toAdd.clear();
    }

    void removeGos()
    {
        for(int i = toRemove.size()-1; i>=0; i--)
        {
            for(Layer L:Layers)
            {
                if(L.name == toRemove.get(i).layerTag)
                {
                    L.list.remove((toRemove.get(i)));
                }
            }
        }
        toRemove.clear();
    }


    ArrayList<GameObject> getLayerList(Layer.LayerNames _name)
    {
        ArrayList<GameObject> goList = null;
        for(Layer L:Layers)
        {
            if(L.name == _name)
            {
                goList = L.list;
            }
        }
        if(goList == null) System.out.println("Oh no the list you want is null! Check your tags or if that list exists.");
        return goList;
    }


    public void Instantiate(GameObject gameObject)//Use this to add a gameObject to the scene
    {
        toAdd.add(gameObject);
        //Center new object:
        toAdd.get(toAdd.size()-1).x = toAdd.get(toAdd.size()-1).x-toAdd.get(toAdd.size()-1).width/2;
        toAdd.get(toAdd.size()-1).y = toAdd.get(toAdd.size()-1).y-toAdd.get(toAdd.size()-1).width/2;

        /*new Vector2(toAdd.get(toAdd.size()-1).position.x-toAdd.get(toAdd.size()-1).width/2,
                                                         toAdd.get(toAdd.size()-1).position.y-toAdd.get(toAdd.size()-1).width/2);*/
    }

    public void Despawn(GameObject gameObject)//Use this to remove a gameObject from the scene
    {
        toRemove.add(gameObject);
    }

    void centerObject(ArrayList<GameObject> arr, int index)
    {

        if(index < arr.size())
        {
            arr.get(index).x = arr.get(index).x-arr.get(index).width/2;
            arr.get(index).y = arr.get(index).y-arr.get(index).width/2;

            //arr.get(index).position = new Vector2(arr.get(index).position.x-arr.get(index).width/2,arr.get(index).position.y-arr.get(index).width/2);
        }
        else
            System.out.println("The index is out of bounds");
    }

    public GameObject getPlayer()
    {
        GameObject go = null;
        for (Layer L: Layers)
        {
            if(L.name == Layer.LayerNames.CARD)
            {
                go = L.list.get(0);
            }
        }
        if(go==null) System.out.println("There is no player object");
        return go;
    }
    public GameObject getBg()
    {
        GameObject go = null;
        for (Layer L: Layers)
        {
            if(L.name == Layer.LayerNames.BACKGROUND)
            {
                go = L.list.get(0);
            }
        }
        if(go==null) System.out.println("There is no background object");
        return go;
    }

    public void drawDebug(ShapeRenderer shapeRender) {


    }

}
