module.exports = {
    devServer: {
        proxy: {
            '^/wementis': {
                target: 'http://wementisback:8080'
            }
        }
    }
}