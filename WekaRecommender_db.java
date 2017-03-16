
//package default;

import java.util.Comparator;
import java.util.Map;
import java.util.PrimitiveIterator;
import java.util.Random;
import java.util.TreeMap;
import weka.classifiers.Classifier;
import weka.classifiers.lazy.IBk;
import weka.classifiers.meta.Vote;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.experiment.InstanceQuery;

/**
 *
 * @author cw1491
 */
public class WekaRecommender_db {

  private Instances trainingInstances;
  private Classifier currentClassifier = null;
  private boolean classifierInitialized = false;

  public WekaRecommender_db(Instances trainingInstances, Classifier classifier) {
    this.trainingInstances = trainingInstances;
    if (classifier == null) {
      // default to kNN
      this.currentClassifier = new IBk(20);
    } else {
      this.currentClassifier = classifier;
    }
  }

  public void setClassfier(Classifier passedClassifier) {
    currentClassifier = passedClassifier;
    classifierInitialized = false;
  }

  /**
   * Returns recommendations sorted such that first element has highest
   * predicted rating, map is key is predicted rating, value is item id.
   *
   * @param passedInstance
   * @return
   * @throws Exception
   */
  public TreeMap<Double, String> getRecommendations(Instance passedInstance) throws Exception {
    TreeMap<Double, String> recommendations = new TreeMap(Comparator.naturalOrder().reversed());
    // Go through each rating
    for (int attrIndex = 1; attrIndex < passedInstance.numAttributes(); attrIndex++) {
      // Only predict rating for missing attributes
      if (passedInstance.isMissing(attrIndex)) {
        trainingInstances.setClassIndex(attrIndex);
        currentClassifier.buildClassifier(trainingInstances);
        double predictedRating = currentClassifier.classifyInstance(passedInstance);
        recommendations.put(predictedRating, attrIndex + "");
      }
    }
    return recommendations;
  }

  public static Instance createDummyCurrentUser(Instances instances) {
    Instance dummyUserInstance = new DenseInstance(instances.numAttributes());
    dummyUserInstance.setDataset(instances);
    int numRatingsGiven = 0;
    Random random = new Random();
    PrimitiveIterator.OfInt attributeIdStream = random.ints(1, instances.numAttributes() - 1).iterator();
    PrimitiveIterator.OfInt ratingStream = random.ints(1, 6).iterator();
    int numToRate = random.ints(20, 100).iterator().nextInt();
    while (numRatingsGiven < numToRate) {
      int attributeId = attributeIdStream.nextInt();
      int rating = ratingStream.nextInt();
      System.out.println("Setting item: " + attributeId + " rating: " + rating);
      dummyUserInstance.setValue(attributeId, rating);
      numRatingsGiven++;
    }
    return dummyUserInstance;
  }

  public static void main(String[] args) {
    try {
        
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
            String url="jdbc:sqlserver://LAVANYA-COLLEGE\\SQLEXPRESS;databaseName=MoviesDB";        
            String User = "sa";
            String Password = "sa";
            String sql = "select * from Movies";
            
            InstanceQuery query = new InstanceQuery();
            query.setDatabaseURL(url);
            query.setUsername(User);
            query.setPassword(Password);
            query.setQuery(sql);
      //String trainingFile = "C:\\Users\\Lavanya\\Desktop\\Testing\\u.datasmall.arff";
      // Read all the instances in the file (ARFF, CSV, XRFF, ...)
      //DataSource source = new DataSource(trainingFile);
      //Instances instances = source.getDataSet(); 
      Instances instances = query.retrieveInstances();
      Instance dummyUser = createDummyCurrentUser(instances);

      WekaRecommender recommender = new WekaRecommender(instances, null);
      System.out.println("*** KNN ***");
      TreeMap<Double, String> recommendations = recommender.getRecommendations(dummyUser);
      for (int i = 0; i < 5; i++) {
        Map.Entry<Double, String> recommendation = recommendations.pollFirstEntry();
        System.out.println("Predicted rating: " + recommendation.getKey() + " id: " + recommendation.getValue());
      }
      System.out.println("*** Vote ***");
      recommender.setClassfier(new Vote());
      recommendations = recommender.getRecommendations(dummyUser);
      for (int i = 0; i < 5; i++) {
        Map.Entry<Double, String> recommendation = recommendations.pollFirstEntry();
        System.out.println("Predicted rating: " + recommendation.getKey() + " id: " + recommendation.getValue());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
