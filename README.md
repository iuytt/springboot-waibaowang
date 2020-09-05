# waibao

## 数据库

- user

  - **userName** varchar(30)：唯一，**用户名**
  
  - ==**PN**== bigint(11)：唯一，**手机号**
  
  - **pwd** varchar(30)：**密码**
  
  - **email** varchar(30)：唯一，**邮箱**
  
  - **userStatus** int(1)：**身份**
    
    ```
    0:开发, 1:需求
    ```
  
  - **projectID** text：**所有参与项目的ID**
  
    ```
    project_projectID;project_projectID;project_projectID;
    ```

- project

  - ==**projectID**== bigint(8)：唯一，**项目ID**

  - **projectName** carchar(40)：**项目名称**

  - **issue** bigint(11)：**发布者**(**PN**)

  - **projectType** int(2)：**项目类型**

    ```
    0="Web网站" 
    1="APP开发"
    2="微信小程序"
    3="微信公众号"
    4="其他"
    ```

  - **projectDetails** text：**项目描述**

  - **pay** int(8)：**项目资金**

  - **date** int(4)：**项目周期**

  - **projectState** int(1)：**项目状态**
      
    ```
    0:招募中, 1:开发中, 2:结束
    ```

  - **employee** text：**雇员**
    
    ```
    user_PN;user_PN;user_PN;user_PN;
    ```

  - **recruit** int(2)：**招募类型**

    ```
    0="项目顾问"
    1="项目经理" 
    2="产品经理" 
    3="Android开发"
    4="iOS开发"
    5="前端开发"
    6="后端开发"
    7="全栈开发"
    8="测试工程师"
    ```

  - **time** datetime：**项目创建时间**
