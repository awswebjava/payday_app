package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.iniexistentes", "/web.iniexistentes"})
public final  class iniexistentes extends GXWebObjectStub
{
   public iniexistentes( )
   {
   }

   public iniexistentes( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( iniexistentes.class ));
   }

   public iniexistentes( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new iniexistentes_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new iniexistentes_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "ini Existentes";
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

