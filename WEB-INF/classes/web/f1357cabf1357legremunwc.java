package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.f1357cabf1357legremunwc", "/web.f1357cabf1357legremunwc"})
public final  class f1357cabf1357legremunwc extends GXWebObjectStub
{
   public f1357cabf1357legremunwc( )
   {
   }

   public f1357cabf1357legremunwc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( f1357cabf1357legremunwc.class ));
   }

   public f1357cabf1357legremunwc( int remoteHandle ,
                                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new f1357cabf1357legremunwc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new f1357cabf1357legremunwc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "F1357 Cab F1357 Leg Remun WC";
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

