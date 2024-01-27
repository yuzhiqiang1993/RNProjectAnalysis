## 默认方式创建的React Native项目分析

### 创建步骤

https://reactnative.cn/docs/environment-setup

先在临时目录中创建一个项目

```bash
 npx react-native init MyProject --template react-native-template-typescript
```

然后将项目移动到当前目录

```bash
mv MyProject/* ./
```

### 运行项目

先安装依赖

```bash
yarn install
```

运行到Android设备上

```bash
yarn android
```

## Android端项目目录结构分析

