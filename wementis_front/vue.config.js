module.exports = {
    devServer: {
        proxy: {
            '^/wementis': {
                target: 'http://localhost:8080'
            }
        }
    }
}