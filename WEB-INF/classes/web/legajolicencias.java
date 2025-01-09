package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.legajolicencias", "/web.legajolicencias"})
public final  class legajolicencias extends GXWebObjectStub
{
   public legajolicencias( )
   {
   }

   public legajolicencias( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( legajolicencias.class ));
   }

   public legajolicencias( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new legajolicencias_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new legajolicencias_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Licencias y ausencias";
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

