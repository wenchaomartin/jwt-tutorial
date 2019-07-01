### oauth2 协议

####  授权码模式 grant_type:code 

以github社交账号登陆为例子([参数详情](https://developer.github.com/enterprise/11.10.340/v3/oauth/#web-application-flow))

1. 请求 github 认证服务器认证  
https://github.com/login/oauth/authorize?client_id=3f65aaca16a3a0fdd88c&redirect_uri=http://localhost:8080/login&state=123456&login=http://localhost:8080

1. 认证成功后 github 会回调 redirect_uri 并且加上code 
http://localhost:8080/login?code=92c3889267580c6b7bba&state=123456

1. 在自己的服务器端请求 access_token.  url 形如
curl -XPOST https://github.com/login/oauth/access_token -dclient_id=3f65aaca16a3a0fdd88c -dclient_secret=aab3fde4338e49cacf9119d8f2eb919a401f15b9 -dcode=eac4c6907fbc698fb401
需要注意的是  请求token 2次就会 code 参数失效
得到  token 写在 内存 里 可以是redis 可以是  session .具体分析

1. 客户端访问时带在 cookie 查找 access_token 访问保护资源 

### 密码模式(password )

curl -XPOST -u clientId:secret "http://localhost:8080/oauth/token?grant_type=password&username=username&password=password"

curl -X POST http://localhost:9050/oauth/token \
    --header "Authorization:Basic YXBwY2xpZW50OmFwcGNsaWVudEAxMjM=" \
    -d "grant_type=password" \
    -d "username=kelly" \
    -d "password=kelly@123"
    
YXBwY2xpZW50OmFwcGNsaWVudEAxMjM= 是 base64(clientId:secret)形式 

curl -XGET --header "Authorization:Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.\
eyJleHAiOjE1NjE4MTk1MjgsInVzZXJfbmFtZSI6InVzZXIiLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwianRpIjo\
iNWUyYWU3YjktYWM2NC00NGQ4LTg4NzUtYzk5ODc5OTBjMjcxIiwiY2xpZW50X2lkIjoiY2xpZW50SWQiLCJzY29wZSI6WyJyZWFkIl19.ONcXyOUTu3pO36NWgHgPoIqb1KEQV5EyxYfh8wdV2e0D5xNwtY1mixgylw5xiLZ2sy6yZUA0CtA1vS6fpcn8IhSzKWIT8yZYp-G0UmhDyu1mciyC2iA_\
jdGWty_0vGhS_BEuARVsypt4WLkGpxo7j8tiYPU9wd6O_abAk49bdlyzW8daOao7ChGxUGk-yR3YVwBScl4TRJ_XSe6xf0YVFhKuXEuY2_iiND68Iz0M1rAltDrAiuztGkiPfgHC4DDFLdEwBlA1zxGk-E8RaDTRIAuxAO2ibT0Nlg\
-NEeW7aTBLHDLpimdXEiUqTzCynKadOeK01ePfCUz0JVSyRstIFA" "http://localhost:9090/me"


参数解释：

获取 token 
curl -u  client:secret  ==== curl --header "Authorization:Basic base64(client:secret)" 






#### 项目中值得思考的地方（TODO）



项目中 sql 语句 放在 script  中 执行 每次执行都会delete 表 是不合理的。
想用 flyway 控制 



 
