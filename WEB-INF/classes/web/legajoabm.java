package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.legajoabm", "/web.legajoabm"})
public final  class legajoabm extends GXWebObjectStub
{
   public legajoabm( )
   {
   }

   public legajoabm( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( legajoabm.class ));
   }

   public legajoabm( int remoteHandle ,
                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new legajoabm_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new legajoabm_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Legajo ABM";
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

