import random

data_folder = './data/'

class DataExtender:
  JOY_FILE = 'joy.txt'
  ANGER_FILE = 'anger.txt'
  ANTICIPATION_FILE = 'anticipation.txt'
  CALM_FILE = 'calm.txt'
  CONF_FILE = 'confident.txt'
  FEAR_FILE = 'fear.txt'
  HATE_FILE = 'hate.txt'
  LOVE_FILE = 'love.txt'
  SAD_FILE = 'sadness.txt'
  SURPISE_FILE = 'surprise.txt'
  TRUST_FILE = 'trust.txt'

  def __init__(self):
    self.anger_set = self.get_set(self.ANGER_FILE)
    self.joy_set = self.get_set(self.JOY_FILE)
    self.anticipation_set = self.get_set(self.ANTICIPATION_FILE)
    self.calm_set = self.get_set(self.CALM_FILE)
    self.conf_set = self.get_set(self.CONF_FILE)
    self.fear_set = self.get_set(self.FEAR_FILE)
    self.hate_set = self.get_set(self.HATE_FILE)
    self.love_set = self.get_set(self.LOVE_FILE)
    self.sad_set = self.get_set(self.SAD_FILE)
    self.surprise_set = self.get_set(self.SURPISE_FILE)
    self.trust_set = self.get_set(self.SURPISE_FILE)

  def get_set(self, filename):
    with open(data_folder + filename) as f:
      content = f.readlines()
      f.close() 
    result = [x.rstrip() for x in content]
    return result

  def generate(self, sentence, label):
    words = sentence.split(' ')
    result = []
    for i in range(len(words)):
      result = result + self.generate_sentences(words, i, label)
    return result

  def generate_from_set(self, syn_set, count, words, pos):
    result = []
    if words[pos] in syn_set:
        for syn in random.sample(syn_set, count):
          result.append(' '.join(w for w in list(words[:pos] + [syn] + words[pos+1:])))
    return list(result)

  def generate_sentences(self, words, i, label):
    syn_set, count = self.get_set_by_label(label)
    return self.generate_from_set(syn_set, count, words, i)

  def get_set_by_label(self, label):
    sets = {
      'happiness': self.joy_set,
      'sadness': self.sad_set,
      'fun': self.joy_set,
      'hate': self.hate_set,
      'love': self.love_set,
      'relief': None,
      'surprise': self.surprise_set,
      'anger': self.anger_set
    }
    counts = {
      'happiness': 4,
      'sadness': 7,
      'fun': 25,
      'hate': 35,
      'love': 6,
      'relief': 5,
      'surprise': 70,
      'anger': 350
    }
    return sets[label], counts[label]