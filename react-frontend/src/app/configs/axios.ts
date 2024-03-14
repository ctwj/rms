import axios from 'axios';

const instance = axios.create({
	baseURL: 'http://localhost:8080/' // 设置你的基础 URL
});

// 请求拦截器
instance.interceptors.request.use(
	(config) => {
		// 在发送请求之前做一些处理，例如添加请求头信息
		// config.headers['Authorization'] = 'Bearer token123'; // 示例：添加授权令牌
		return config;
	},
	(error) => {
		// 处理请求错误
		return Promise.reject(error);
	}
);

// 响应拦截器
instance.interceptors.response.use(
	(response) => {
		// 对响应数据进行处理
		// eslint-disable-next-line @typescript-eslint/no-unsafe-return
		return response.data;
	},
	(error) => {
		// 处理响应错误
		return Promise.reject(error);
	}
);

export default instance;
