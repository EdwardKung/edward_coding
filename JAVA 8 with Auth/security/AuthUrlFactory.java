

/**
 * Created by edward.gong on 2016/3/16.
 */
@Service
public class AuthUrlFactory {
    @Autowired
    AuthService authService;
    @Autowired
    RoleService roleService;
    @Autowired
    PermissionService permissionService;
    private  final List<UrlPattern> urlSet=getUrlConfigSet();
    protected    List<UrlPattern> getUrlConfigSet(){
        List<UrlPattern> urlSet=new ArrayList<UrlPattern>();

        urlSet.add(createUrlPattern("/login",true,null,null));
        urlSet.add(createUrlPattern("/rest/auth/test*",false,new Role.DefaultRole[]{Role.DefaultRole.ADMIN},null));
        urlSet.add(createUrlPattern("/rest/auth*",true,null,null));
        urlSet.add(createUrlPattern("/*",false,Role.DefaultRole.values(),null));
        return urlSet;
    }
    private  UrlPattern  createUrlPattern(String urlString,boolean isPublic, Role.DefaultRole[] roles, Permission.DefaultPermission[] permissions){

        UrlPattern urlObject=new UrlPattern(urlString);
        urlObject.setPublic(isPublic);
        if(roles!=null){
            urlObject.getRoles().addAll(Arrays.asList(roles));
        }
        if(permissions!=null){
            urlObject.getPermissions().addAll(Arrays.asList(permissions));
        }
        return urlObject;
    }
    private  boolean matchUrl(String patternString,String inputString){
        String patternStr =new String("(^"+patternString+")|(^"+patternString+"$)");
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(inputString);
        return  matcher.find();
    }
    public  boolean checkPermission(HttpServletRequest request){
        User user= this.getUser(request);
        boolean isAuth=  this.isAuthPermission(request,user);
        return isAuth;
    }
    protected User getUser(HttpServletRequest request){
        //TODO when redirecting page, the token method is not workable. The token cannot support syntax of js which uses "location.href"
        return authService.getAuthUserByUuId(request.getHeader("token"));
    }

    protected boolean isAuthPermission(HttpServletRequest request,User user){
        String checkUrl=request.getRequestURI();
        Optional<UrlPattern> url=urlSet.parallelStream().filter((urlPattern)->matchUrl(urlPattern.getUrl(),checkUrl)).findFirst();
        boolean result=false;
        if(url.isPresent()){
            UrlPattern urlPattern=url.get();
            Set<Permission> urlAllRequirePermissions = getUrlAllPermissions(urlPattern);
            if(urlPattern.isPublic())
                result=true;
            if(!result && user !=null)
               result= checkAuthByPermission(user,urlAllRequirePermissions);
        }
        return result;
    }

    private Set<Permission> getUrlAllPermissions(UrlPattern urlPattern) {
        Set<Permission> urlPermissions =getUrlPermissions(urlPattern);
        Set<Permission> urlAllRequirePermissions= getUrlPermissionsFromRole(urlPattern);
        urlAllRequirePermissions.addAll(urlPermissions);
        return urlAllRequirePermissions;
    }

    private Set<Permission> getUrlPermissionsFromRole(UrlPattern urlPattern){
        return urlPattern.getRoles()
                .stream()
                .map((roleEnum)->roleService.getRoleByName(roleEnum.toString()).getPermissions())
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }
    private Set<Permission> getUrlPermissions(UrlPattern urlPattern){
        return urlPattern.getPermissions()
                .stream()
                .map((permissionEnum)->permissionService.getPermissionByName(permissionEnum.toString()))
                .collect(Collectors.toSet());
    }
    private boolean checkAuthByPermission(User user,Set<Permission> permissions){
         Set<Permission> userPermission=user.getRole().getPermissions();
        boolean result=false;
         for(Permission permission:userPermission){
             if(permissions.contains(permission)){
                 result=true;
                 break;
             }
         }
        return result;
    }

}
