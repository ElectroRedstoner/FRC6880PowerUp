package org.usfirst.frc.team6880.robot.jsonReaders;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class AutonomousOptionsReader extends JsonReader {
	public JSONArray tasks;
    public AutonomousOptionsReader(String filePath, String autonomousOption) {

        super(filePath);
        try {
            String key = getKeyIgnoreCase(rootObj, autonomousOption);
            tasks = (JSONArray) rootObj.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public AutonomousOptionsReader(String filePath){
        super(filePath);
    }

    public JSONObject getTask(int taskNum){
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject)tasks.get(taskNum);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public String getTaskType(int taskNum) {
        String taskType = null;
        JSONObject obj = null;

        try {
            obj = (JSONObject) tasks.get(taskNum);
            taskType = getString(obj, "type");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (taskType);
    }

    public String getMethodName(int taskNum) {
        JSONObject obj = null;
        String methodName = null;

        try {
            obj = (JSONObject) tasks.get(taskNum);
            methodName = getString(obj, "method");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (methodName);
    }


    public List<String> getAll(){
        Iterator<String> keysIterator = rootObj.keySet().iterator();
        ArrayList<String> rootObjNames = new ArrayList<String>();
        while (keysIterator.hasNext()){
            rootObjNames.add(keysIterator.next());
        }
        return rootObjNames;
    }
}
