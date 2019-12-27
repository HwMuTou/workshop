# Workshop

## 初始化环境

* 添加Spring Security 实现依赖

    AutoConfig 
    SpringBootWebSecurityConfiguration
    UserDetailsServiceAutoConfiguration
    
* 自定义配置 
    
    自定义的实现 WebSecurityConfigurerAdapter CustomUserDetailsService

* Method Security

    * @PreAuthorize 
    * hasAuthority 
    * hasRole 
    * \#component
    
* SecurityContextHolder.getContext().getAuthentication()
    
    基于 ThreadLocal 的获取当前授权的方法