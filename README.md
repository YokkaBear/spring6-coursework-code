# spring6-coursework-code
Record spring6 learning process and example code

- 代码上传流程
  - git status // check to-be-uploaded files
  - git add .
  - git commit -m "commit message started with feat/fix/deploy/perf..."
  - git pull --rebase origin master // pull from temp pr branch: origin/master
  - git push origin master // push to temp pr branch
- 代码主分支同步流程
  - 页面发起到origin/main主分支的pull request
  - 修改说明信息，merge pull request
  - 等待页面deploy过程运行成功，主分支同步完成
