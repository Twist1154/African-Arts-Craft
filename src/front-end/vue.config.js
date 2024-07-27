const {defineConfig} = require('@vue/cli-service')
module.exports = defineConfig({
    transpileDependencies: true,
    devServer: {
        port: 3000,  // Change this to your desired port number
        proxy: {
            '/store/api/users': {
                target: 'http://localhost:8080',
                ws: true,
                changeOrigin: true
            }
        }
    }
})
