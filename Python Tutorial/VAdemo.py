#Nghe

import speech_recognition
import pyttsx3
from datetime import date
from datetime import datetime
from gtts import gTTS
import requests, json



robot_ear = speech_recognition.Recognizer()

#Nói

robot_mouth = pyttsx3.init()

while True:
	with speech_recognition.Microphone() as mic:
		print("gạo: I'm Listening")
		audio = robot_ear.listen(mic)
	try:
		you = robot_ear.recognize_google(audio)
	except:
		you = ""

	print("Boss: " + you)

	#Hiểu

	if you == "":
		robot_brain = "I can't hear you, try again"
	elif "hello" in you:
		robot_brain = "hello my boss"
	elif "today" in you:
		today = date.today()
		robot_brain = today.strftime("%d/%m/%Y")
	elif "time" in you:
		now = datetime.now()
		robot_brain = now.strftime("%H hours %M minutes %S seconds")
	elif "where is" in you:
		robot_brain = "https://www.google.com/maps/place/"
	elif "bye" in you:
		robot_brain = "Bye Boss"
		print("gạo: " + robot_brain)
		robot_mouth.say(robot_brain)
		robot_mouth.runAndWait()
		break
	
	else:
		robot_brain = "I'm fine thank you and you"

	print("gạo: " + robot_brain)
	robot_mouth.say(robot_brain)
	robot_mouth.runAndWait()

