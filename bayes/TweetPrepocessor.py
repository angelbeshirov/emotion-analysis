import re
from nltk.tokenize import word_tokenize
from string import punctuation 
from nltk.corpus import stopwords 
from Tweet import Tweet

class TweetPrepocessor:
  def __init__(self):
    self.stop_words = set(stopwords.words('english') + list(punctuation) + ['AT_USER','URL'])

  def process_tweets(self, list_of_tweets):
    processedTweets = []
    for tweet in list_of_tweets:
      labels = tweet.label.split('|')
      processedTweet = self.process_tweet(tweet.text)
      for label in labels:
        if label != 'nocode' and label != 'not-relevant':
          newTweet = Tweet(processedTweet, label)
          processedTweets.append(newTweet)
    return processedTweets

  def process_tweet(self, tweet):
    tweet = tweet.lower() # convert text to lower-case
    tweet = re.sub('((www\.[^\s]+)|(https?://[^\s]+))', 'URL', tweet) # remove URLs
    tweet = re.sub('@[^\s]+', 'AT_USER', tweet) # remove usernames
    tweet = re.sub(r'#([^\s]+)', r'\1', tweet) # remove the # in #hashtag
    tweet = word_tokenize(tweet) # remove repeated characters (helloooooooo into hello)
    return " ".join([word for word in tweet if word not in self.stop_words])

  def remove_class(self, old_tweets, feature):
    return list(filter(lambda x: x.label != feature, old_tweets))