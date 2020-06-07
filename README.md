# Spring Boot Framework Demo
> @author: david.wang \
> @log: 2020.06.07
---

## 目的
> 用來測試或實作 需要由spring boot 開發所需要使用的功能
---

## Project Structure
- project
    - README
    ``` 撰寫本專案資訊 ```
    - src
        - main
            - java
                - per.david.demo
                    - Application.java
                    ``` spring boot 啟動的 main function ```
                    - configuration
                    ``` 功能設定檔 ```
                    - controller
                    ``` API 控制器 ```
                    - service
                    ``` API 商務邏輯服務 ```
                    - util
                    ``` 靜態的工具 ```
                    - worker
                    ``` 常用功能的實作 ```
            - resource
                - application.yml
                ``` yaml file 主要放置本專案相關的配置文件或設定檔 ```
        - test
            - java
    - target
    ``` compiler 過後檔案輸出位置 ```
    - pom.xml
    ``` 用以放置 maven project 配置檔，或須引入的liberary 配置檔 ```
    - .gitignore
    ``` 配置不上 git 的檔案名稱或類型 ```
---