import csv
import numpy as np
import matplotlib.pyplot as plt
from TweetPrepocessor import TweetPrepocessor
from DatasetExtender import DataExtender
from EmotionClassifier import EmotionClassifier
from Tweet import Tweet
  
def main():
  de = DataExtender()  
  preprocessor = TweetPrepocessor()
  with open("./data/text_emotion.csv", 'r', encoding='utf8') as tf:
    tst = list(csv.reader(tf))
  all_tweets = []
  classes = {
    'anger': 0, 
    'fun': 0, 
    'happiness': 0, 
    'hate': 0,
    'love': 0, 
    'sadness': 0, 
    'surprise': 0 }
  for entry in tst[1:]:
    tweet = Tweet(entry[3], entry[1])
    all_tweets.append(tweet)

  all_tweets = preprocessor.remove_class(all_tweets, 'empty')
  all_tweets = preprocessor.remove_class(all_tweets, 'boredom')
  all_tweets = preprocessor.remove_class(all_tweets, 'worry')
  all_tweets = preprocessor.remove_class(all_tweets, 'relief')
  all_tweets = preprocessor.remove_class(all_tweets, 'neutral')
  all_tweets = preprocessor.remove_class(all_tweets, 'enthusiasm')

  new_tweets = []
  all_tweets = preprocessor.process_tweets(all_tweets)

  for tweet in all_tweets:
    if tweet.label != 'relief' and tweet.label != 'enthusiasm':
      for s in de.generate(tweet.text, tweet.label):
        new_tweets.append(Tweet(s, tweet.label))

  composed = all_tweets + new_tweets

  # show class distribution
  for tweet in composed:
    classes[tweet.label] += 1
  plt.title('Distribution')
  plt.bar(classes.keys(), classes.values())
  plt.show()
  ec = EmotionClassifier()
  ec.train(all_tweets, all_tweets)
  ec1 = EmotionClassifier()
  
  ec1.train(composed, composed)
  user_input = input("Enter text: ")
  while user_input != "exit":    
    probs = ec.predict(user_input)
    probs1 = ec1.predict(user_input)
    f = plt.figure(figsize=(10,3))
    ax = plt.subplot(1,2,1)
    ax.bar(classes.keys(), probs, color='b', width=0.8)
    ax2 = plt.subplot(1,2,2)
    ax2.bar(classes.keys(), probs1, color='g')
    plt.show()
    user_input = input("Enter text: ")

if __name__ == "__main__":
  main();