package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.f1357legremun", "/web.f1357legremun"})
public final  class f1357legremun extends GXWebObjectStub
{
   public f1357legremun( )
   {
   }

   public f1357legremun( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( f1357legremun.class ));
   }

   public f1357legremun( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new f1357legremun_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new f1357legremun_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "F1357 Leg Remu";
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

