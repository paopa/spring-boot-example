# Spring Boot Framework Practice
> @author: poa.s.w \
> @log: 2020.09.24
---

## 目的
> 用來測試或實作 需要由spring boot 開發所需要使用的功能
---

## Project Structure
- project
    - README.md
    ``` 撰寫本專案相關資訊 ```
    - src
        - main
            - java
                - per.david.demo 
                    - Application.java
                    ``` springboot starter object```
                    - configuration
                    ``` 功能設定檔物件```
                    - controller
                    ``` API 控制器物件```
                        - service
                        ``` API 商務邏輯服務物件```
                    - dao
                    ``` 對 database 操作的物件```
                        - jpa
                    - entity
                    ``` 存放 database 傳出資料的物件 ```
                    - enums
                    ``` enumerate 類型的物件 ```
                    - util
                    ``` 工具類物件 ```
                    - worker
                    ``` 常用功能的實作物件 ```
            - resource
                - application.yml
                ``` yaml file 主要放置本專案相關的配置文件或設定檔 ```
        - test
            ``` test case ```
    - target
    ``` compiler 過後檔案輸出位置 ```
    - pom.xml
    ``` 用以放置 maven project 配置檔，或須引入的 liberary 配置檔 ```
    - .gitignore
    ``` 配置不上 git 的檔案名稱或類型 ```
---

## Object Definition
- POJO `(Plain Ordinary Java Object)`
    ```
    專指只有 setter/getter/toString 的简单 method，包括DO/DTO/BO/VO等，
    在一些地方可能會是用 Entity 來稱呼。
    ```
- DAO `(Data Access Object) 資料訪問物件`
    ```
    主要用於ORM(hibernate)將資料從資料庫提取的邏輯物件，
    簡單來說就是與 database 連接進行操作的物件，常與 PO/DO 結合使用。
    ```
- PO `(Persistant Object) 持久物件` 
    ```
    通常對應資料庫模型，因為ORM框架的誕生所以才有此，可以看成是與 table 相對映的物件與 DO 功能一樣。
    ```
- DO `(Data Object) `
    ```
    通常對應資料庫模型，因為ORM框架的誕生所以才有此，可以看成是與 table 相對映的物件與 PO 功能一樣。
    ```
- DTO `(Data Transfer Object) 資料傳輸物件`
    ```
    泛指用於展示層與服務層之間的資料傳輸物件。
    假設程式像資料庫提取了PO資料物件，須將資料傳往其他系統或是服務時則可以用DTO進行再包裝，
    通常DTO的資訊都會比PO少，因為沒有必要將全部的資料傳輸出去。
    ```
- BO `(Business Object) 商務/業務邏輯物件`
    ```
    商務／業務邏輯操作的物件，不像PO/DO只有單純的資料存取或儲存物件，包含複雜的業務邏輯。
    ```
---