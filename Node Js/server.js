const express = require('express');
const ytdl = require('ytdl-core');
const app = express();
const port = 3000;
app.get('/stream', (req, res) => {
    const url = req.query.url;
    if (!url) {
        res.status(400).send('URL이 필요합니다.');
        return;
    }

    try {
        const stream = ytdl(url, { filter: 'audioonly' });
        res.setHeader('Content-Type', 'audio/mpeg');
        stream.pipe(res);
    } catch (error) {
        console.error(error);
        res.status(500).send('오류 발생');
    }
});
app.listen(port, () => console.log(`Node.js 서버가 http://localhost:${port} 에서 실행 중입니다.`));
