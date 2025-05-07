import pandas as pd

from ydata_profiling import ProfileReport
from sklearn.model_selection import  train_test_split
from sklearn.preprocessing import  StandardScaler
from sklearn.svm import SVC
from sklearn.ensemble import RandomForestClassifier
from sklearn.linear_model import  LogisticRegression
from sklearn.metrics import  accuracy_score, precision_score, recall_score, f1_score, confusion_matrix
from sklearn.model_selection import  GridSearchCV, RandomizedSearchCV

from pandasai import SmartDataframe
from pandasai.llm.openai import OpenAI
import openai

#Import data
data = pd.read_csv("diabetes.csv")

target = "Outcome"

# profile = ProfileReport(data, title = "Diabetes Report", explorative= True)
# profile.to_file("diabetes_report.html")

#Phân chia dữ liệu
x = data.drop(target, axis = 1)
y = data[target]

x_train, x_test, y_train, y_test = train_test_split(x, y, test_size=0.2, random_state= 482003)

#Tiền xử lý dữ liệu
scaler = StandardScaler()
x_train = scaler.fit_transform(x_train)
x_test = scaler.transform(x_test)


#Tạo báo cáo tự động

profile = ProfileReport(data, title="Diabetes Report", explorative=True)
profile.to_file("diabetes_report.html")  # Báo cáo xuất ra file HTML


#Pick mô hình để train
model = SVC(random_state=100),
param_grid= params,
scoring="recall",
cv = 6,
verbose = 1,
n_jobs=1,

params = {
    "n_estimators": [50, 100, 200],
    "criterion": ["gini", "entropy", "log_loss"],
    "max_depth": [None, 2, 5]
}

model = GridSearchCV(estimator=RandomForestClassifier(random_state=42),
                     param_grid=params,
                     scoring="recall",
                     cv=5,
                     verbose=1,
                     n_jobs=-1)

model.fit(x_train, y_train)

#Train model đã pick
model.fit(x_train, y_train)
print(model.best_score_)
print(model.best_params_)

y_predict = model.predict(x_test)

for i, j in zip(y_predict, y_test.values):
    print("Predicted value: {}. Actual value: {}".format(i,j))

#Dự đoán và đánh giá mô hình

y_predict = model.predict(x_test)

print("\nEvaluation Metrics:")
print("Accuracy:", accuracy_score(y_test, y_predict))
print("Precision:", precision_score(y_test, y_predict))
print("Recall:", recall_score(y_test, y_predict))
print("F1 Score:", f1_score(y_test, y_predict))

# NLP Truy vấn dữ liệu bằng pandasai

openai_api_key = "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"

llm = OpenAI(api_token=openai_api_key)
smart_df = SmartDataframe(data, config={"llm": llm})

# Ví dụ câu hỏi:
question = "Tỷ lệ bệnh nhân bị tiểu đường là bao nhiêu phần trăm?"
print("\n🧠 Trả lời từ AI (pandasai):")
print(smart_df.chat(question))

#Truy vấn AI trực tiếp bằng chat GPT

def ask_openai_direct(question, df):
    context = f"Dữ liệu gồm các cột: {', '.join(df.columns)}. Hãy trả lời câu hỏi dưới đây dựa trên dữ liệu diabetes:"
    prompt = f"{context}\n\nCâu hỏi: {question}\nTrả lời:"

    response = openai.ChatCompletion.create(
        model="gpt-4",
        messages=[{"role": "user", "content": prompt}],
        api_key=openai_api_key
    )

    return response.choices[0].message.content


# Ví dụ truy vấn:
direct_q = "Có bao nhiêu bệnh nhân không mắc tiểu đường?"
print("\n🤖 Trả lời từ AI (OpenAI GPT-4):")
print(ask_openai_direct(direct_q, data))

