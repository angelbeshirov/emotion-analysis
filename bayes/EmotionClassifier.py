from sklearn.naive_bayes import MultinomialNB
from sklearn.feature_extraction.text import CountVectorizer
from sklearn import metrics
from sklearn.pipeline import Pipeline
from sklearn.feature_extraction.text import TfidfTransformer
from TweetPrepocessor import TweetPrepocessor

class EmotionClassifier:
  def __init__(self):
    self.nb = None

  def train(self, train_set, test_set):
    train_x = [tw.text for tw in train_set]
    train_y = [tw.label for tw in train_set]
    test_x = [tw.text for tw in test_set]
    test_y = [tw.label for tw in test_set]

    self.nb = Pipeline([('vect', CountVectorizer()),
               ('tfidf', TfidfTransformer()),
               ('clf', MultinomialNB())])
    self.nb.fit(train_x, train_y)
    y_pred = self.nb.predict(test_y)

  def predict(self, text):
    tp = TweetPrepocessor()
    processed = tp.process_tweet(text)
    return self.nb.predict_proba([processed])[0]

  def convert_to_positive_class(self, positive_label, labels):
    return [1 if label == positive_label else 0 for label in labels]